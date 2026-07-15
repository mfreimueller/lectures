---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 13 - Concurrency in Java - Advanced
## POS - Advanced

---

## Agenda (1/2)

1. Motivation
2. Lock Interface & ReentrantLock
3. ReentrantLock - Eigenschaften
4. ReadWriteLock
5. ExecutorService & Thread-Pools
6. Thread-Pool Typen
7. Callable & Future

---

## Agenda (2/2)

8. invokeAll & invokeAny
9. CompletableFuture - Grundlagen
10. CompletableFuture - Verkettung
11. CompletableFuture - Kombination
12. Fork/Join Framework
13. Fork/Join - Work Stealing

---

## Lernziele

- Ich kann ReentrantLock und ReadWriteLock anstelle von synchronized einsetzen
- Ich kann Aufgaben mit ExecutorService und Thread-Pools verwalten
- Ich kann Callable/Future und invokeAll/invokeAny verwenden
- Ich kann CompletableFuture verketten und kombinieren
- Ich kenne das Fork/Join-Framework und Work Stealing

---

## Recap: Lektion 12

- Thread-Erzeugung (extends Thread / implements Runnable)
- synchronized — gegenseitiger Ausschluss
- volatile — Sichtbarkeit
- wait/notify — Thread-Koordination
- Einschränkungen: synchronized ist starr, kein Timeout, keine feineren Locks

---

## Motivation

- synchronized ist inflexibel: kein Timeout, kein tryLock, keine getrennten Lese-/Schreib-Locks
- Manuelle Thread-Verwaltung ist fehleranfällig und schwer skalierbar
- Thread-Pools trennen Aufgaben von der Thread-Verwaltung
- Asynchrone Programmierung mit Futures ermöglicht nicht-blockierende Aufrufe

---

## Lock Interface & ReentrantLock

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    // kritischer Abschnitt
    counter++;
} finally {
    lock.unlock();  // immer freigeben!
}

// Optional: tryLock mit Timeout
if (lock.tryLock(1, TimeUnit.SECONDS)) {
    try {
        // ...
    } finally {
        lock.unlock();
    }
}
```

- Explizites Lock — mehr Kontrolle als synchronized
- ReentrantLock: Thread kann Lock mehrmals erwerben
- Immer unlock() in finally-Block!

---

## ReentrantLock - Eigenschaften

- **Fairness:** ReentrantLock(true) = langs/langere Wartezeit (fair), ReentrantLock(false) = keine Garantie (Standard)
- **tryLock:** Versucht Lock zu erwerben, bricht bei Misserfolg ab (mit/ohne Timeout)
- **Condition:** wait/notify-Ersatz mit mehr Kontrolle (await/signal statt wait/notify)
- Mit Condition kann man getrennte Wait-Sets für Produzenten und Konsumenten haben

---

## ReadWriteLock

```java
ReadWriteLock rwLock = new ReentrantReadWriteLock();

// Lesen: viele gleichzeitig
rwLock.readLock().lock();
try {
    return data;
} finally {
    rwLock.readLock().unlock();
}

// Schreiben: exklusiv
rwLock.writeLock().lock();
try {
    data = newData;
} finally {
    rwLock.writeLock().unlock();
}
```

- Optimiert für: viele Lese-, wenige Schreibzugriffe
- Read-Lock: mehrere Threads gleichzeitig
- Write-Lock: exklusiv (kein Lesen/Schreiben parallel)

---

## ExecutorService & Thread-Pools

```java
// Thread-Pool erstellen
ExecutorService executor = Executors.newFixedThreadPool(4);

// Aufgabe ausführen (Runnable)
executor.execute(() -> System.out.println("Task in pool"));

// Aufgabe mit Rückgabe (Callable)
Future<Integer> future = executor.submit(() -> {
    Thread.sleep(1000);
    return 42;
});

// Ergebnis abholen (blockierend)
Integer result = future.get();  // wartet maximal

ExecutorService executor.shutdown();
```

---

## Thread-Pool Typen

- **newFixedThreadPool(n):** Feste Anzahl Threads, Warteschlange für Aufgaben
- **newCachedThreadPool():** Dynamisch wachsende Anzahl (Idle-Threads werden nach 60s beendet)
- **newSingleThreadExecutor():** Ein Thread, Aufgaben werden sequenziell ausgeführt
- **newScheduledThreadPool(n):** Fur verzögerte/wiederholte Ausführung

---

## Callable & Future

```java
Callable<String> task = () -> {
    TimeUnit.SECONDS.sleep(2);
    return "Ergebnis";
};

ExecutorService executor = Executors.newFixedThreadPool(2);
Future<String> future = executor.submit(task);

// Andere Arbeit während Task lauft
System.out.println("Warte auf Ergebnis...");

// Ergebnis abholen (blockiert bis Task fertig)
String result = future.get(3, TimeUnit.SECONDS);  // Timeout
System.out.println("Ergebnis: " + result);

executor.shutdown();
```

- Future.get() blockiert den aufrufenden Thread
- Future.isDone() prüft, ob Task abgeschlossen ist
- Future.cancel() bricht den Task ab (per Interrupt)

---

## invokeAll & invokeAny

```java
List<Callable<Integer>> tasks = List.of(
    () -> compute(1000),   // 1 Sekunde
    () -> compute(2000),   // 2 Sekunden
    () -> compute(500)     // 0.5 Sekunden
);

// Alle abwarten:
List<Future<Integer>> results = executor.invokeAll(tasks);

// Das schnellste Ergebnis nehmen:
Integer firstResult = executor.invokeAny(tasks, 3, TimeUnit.SECONDS);
```

---

## CompletableFuture - Grundlagen

```java
// Manuelle Erstellung
CompletableFuture<String> future = new CompletableFuture<>();
future.complete("fertig");  // Setzt Ergebnis

// Asynchrone Ausführung
CompletableFuture<Integer> future = CompletableFuture
    .supplyAsync(() -> {
        // Wird in ForkJoinPool.commonPool() ausgeführt
        return 42;
    });

// Ergebnis abholen (blockierend)
Integer result = future.join();  // wirft keine checked Exception
Integer result2 = future.get();  // wirft InterruptedException, ExecutionException
```

- CompletableFuture implementiert CompletionStage und Future
- Ermöglicht funktionale Verkettung von asynchronen Operationen

---

## CompletableFuture - Verkettung

```java
CompletableFuture
    .supplyAsync(() -> fetchUser(1))
    .thenApply(user -> user.getEmail().toLowerCase())
    .thenAccept(email -> System.out.println("Email: " + email))
    .exceptionally(ex -> {
        System.err.println("Fehler: " + ex);
        return null;
    });

// Sequenzielle Verkettung (flaches Future)
CompletableFuture
    .supplyAsync(() -> getUser(1))
    .thenCompose(user -> fetchOrders(user.getId()))
    .thenAccept(orders -> orders.forEach(System.out::println));
```

- thenApply: Transformiert Ergebnis (Function)
- thenAccept: Konsumiert Ergebnis (Consumer)
- thenCompose: Verkettet Futures (flacht Verschachtelung)
- exceptionally: Fehlerbehandlung

---

## CompletableFuture - Kombination

```java
// Zwei unabhängige Futures kombinieren
CompletableFuture<String> user = CompletableFuture.supplyAsync(() -> getUser(1));
CompletableFuture<String> address = CompletableFuture.supplyAsync(() -> getAddress(1));

user.thenCombine(address, (u, a) -> u + " wohnt in " + a)
    .thenAccept(System.out::println);

// Auf mehrere warten (alle abschliessen)
CompletableFuture.allOf(f1, f2, f3).join();

// Auf das schnellste warten
CompletableFuture.anyOf(f1, f2, f3).join();
```

---

## Fork/Join Framework

```java
// Divide-and-Conquer mit RecursiveTask/RecursiveAction
class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10_000;
    private final int[] array;
    private final int start, end;

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Direkte Berechnung für kleine Arrays
            long sum = 0;
            for (int i = start; i < end; i++) sum += array[i];
            return sum;
        }
        // Aufteilung in Teilaufgaben
        int mid = start + (end - start) / 2;
        SumTask left = new SumTask(array, start, mid);
        SumTask right = new SumTask(array, mid, end);
        left.fork();  // Asynchrone Ausführung
        return right.compute() + left.join();
    }
}

// Verwendung
ForkJoinPool pool = new ForkJoinPool();
Long result = pool.invoke(new SumTask(array, 0, array.length));
```

---

## Fork/Join - Work Stealing

- Jeder Thread hat eine eigene Aufgabenschlange (Deque)
- Leerlaufende Threads stehlen Aufgaben von anderen Threads (Work Stealing)
- Optimal für Divide-and-Conquer: fork() = Aufgabe in eigene Schlange, compute() = selbst ausführen, join() = Ergebnis abholen
- ForkJoinPool.commonPool() == standardmäßig verfügbar

---

## Zusammenfassung

- ReentrantLock: Flexiblere Alternative zu synchronized (tryLock, Timeout, Fairness)
- ReadWriteLock: Getrennte Lese-/Schreib-Locks
- ExecutorService: Thread-Pools für Aufgabenverwaltung
- Callable/Future: Aufgaben mit Rückgabewert
- CompletableFuture: Asynchrone Verkettung und Kombination
- Fork/Join: Divide-and-Conquer mit Work Stealing
