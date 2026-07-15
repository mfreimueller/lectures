---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 14 - Concurrency in Modern Java
## POS - Advanced

---

## Agenda (1/2)

1. Motivation
2. Platform Threads vs. Virtual Threads
3. Virtual Threads - Prinzip
4. Virtual Threads erzeugen
5. 100.000 Virtual Threads
6. Virtual Threads - Einschränkungen
7. Structured Concurrency - Konzept

---

## Agenda (2/2)

8. StructuredTaskScope - ShutdownOnFailure
9. StructuredTaskScope - ShutdownOnSuccess
10. Structured Concurrency - Beispiel
11. ScopedValue - Motivation
12. ScopedValue vs. ThreadLocal
13. ScopedValue - Beispiel

---

## Lernziele

- Ich kenne den Unterschied zwischen Platform Threads und Virtual Threads
- Ich kann Virtual Threads erzeugen und ihre Einschränkungen nennen
- Ich kann Structured Concurrency mit StructuredTaskScope einsetzen
- Ich kenne ScopedValue als Alternative zu ThreadLocal

---

## Recap: Bisherige Concurrency-Lektionen

- Lektion 12: Threads, Runnable, synchronized, volatile, wait/notify
- Lektion 13: Locks, Executors, Callable/Future, CompletableFuture, ForkJoin
- Einschränkung: Platform Threads sind teuer (1 MB Stack pro Thread)
- Einschränkung: Manuelle Future-Verwaltung ist fehleranfällig (vergessene join(), ausreißende Tasks)
- Einschränkung: ThreadLocal hat Probleme mit Virtual Threads und Speicherlecks

---

## Motivation

- Ein Platform Thread = ~1 MB Stack + OS-Thread = teuer
- Server mit 16 GB RAM: max ~16.000 Platform Threads
- Virtual Thread: ~einige KB, Millionen gleichzeitig möglich
- "Einfach zu codierende, hochskalierbare Server-Anwendungen" (JEP 444)

---

## Platform Threads vs. Virtual Threads

Platform Thread (OS Thread)

Wird direkt vom OS verwaltet
1:1 Mapping auf OS-Thread
Kostet ~1 MB Stack + OS-Ressourcen
Teurer Context Switch

Virtual Thread

Wird von der JVM verwaltet
M:N Mapping (viele Virtual Threads auf wenige Platform Threads)
Kostet ~einige KB
Leichtgewichtiger Mount/Unmount auf Carrier Thread

---

## Virtual Threads - Prinzip

```plaintext
JVM (M : N Mapping)

Carrier Thread 1 (Platform Thread) ---+--- VT-A, VT-B, VT-C
Carrier Thread 2 (Platform Thread) ---+--- VT-D, VT-E
...

Wenn VT-A blockiert (z.B. I/O):
   VT-A wird ausgehangt (unmount)
   Carrier-1 führt VT-B weiter aus
   Wenn I/O fertig: VT-A wird wieder auf einen freien Carrier gemountet
```

- Blockierende I/O-Operationen blockieren NICHT den Carrier Thread
- Keine Thread-Pools mehr nötig — einfach für jede Aufgabe einen neuen Virtual Thread

---

## Virtual Threads erzeugen

```java
// Mit Thread Builder
Thread vThread = Thread.ofVirtual()
    .name("my-virtual-thread")
    .unstarted(() -> System.out.println("Hello from VT"));
vThread.start();

// Direkt starten
Thread.startVirtualThread(() -> {
    System.out.println("Hello from VT");
});

// Mit ExecutorService (Java 21+)
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    executor.submit(() -> "Task in VT");
} // auto-close: wartet auf alle Tasks
```

---

## 100.000 Virtual Threads

```java
// Platform Threads: inakzeptabel (100.000 * 1 MB = ~100 GB)
// Virtual Threads: problemlos möglich

try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    for (int i = 0; i < 100_000; i++) {
        int taskId = i;
        executor.submit(() -> {
            Thread.sleep(1000);  // blockiert NICHT den Carrier
            return taskId;
        });
    }
} // wartet auf alle 100.000 Virtual Threads
```

---

## Virtual Threads - Einschränkungen

- **synchronized:** Virtual Thread wird beim Eintritt in synchronized blockiert und belegt den Carrier (Pinning) — vermeiden!
- **CPU-intensive Tasks:** Virtual Threads bringen keinen Vorteil, da sie keine I/O-Wartezeit haben
- **Native Code / JNI:** Kann zu Pinning führen
- Lösung: synchronized durch ReentrantLock ersetzen (kein Pinning)

---

## Structured Concurrency - Konzept

- Ziel: "Strukturierte Nebenläufigkeit" mit klaren Lebenszyklen
- Ein Task erzeugt Sub-Tasks, deren Lebensdauer an den umgebenden Block gebunden ist
- Wenn ein Sub-Task fehlschlägt: alle anderen werden abgebrochen
- Keine "ausreissenden" Tasks (runaway tasks)
- Fehlerpropagation: Entweder alle erfolgreich ODER Fehler

---

## StructuredTaskScope - ShutdownOnFailure

```java
// Alle Subtasks müssen erfolgreich sein
try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
    Future<String> user = scope.fork(() -> fetchUser(1));
    Future<String> address = scope.fork(() -> fetchAddress(1));

    scope.join();             // warte auf alle
    scope.throwIfFailed();    // wenn einer fehlschlägt -> Exception

    // Alle erfolgreich:
    return user.resultNow() + ", " + address.resultNow();
}
```

---

## StructuredTaskScope - ShutdownOnSuccess

```java
// Das erste erfolgreiche Ergebnis nehmen
try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
    scope.fork(() -> fetchFromPrimary("data"));
    scope.fork(() -> fetchFromSecondary("data"));
    scope.fork(() -> fetchFromCache("data"));

    String result = scope.join().result();  // erstes erfolgreiches
    return result;
}
// Alle anderen Tasks werden abgebrochen
```

---

## Structured Concurrency - Beispiel

```java
Response handle() throws InterruptedException, ExecutionException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
        Future<User> user = scope.fork(() -> userService.getUser(id));
        Future<List<Order>> orders = scope.fork(() -> orderService.getOrders(id));

        scope.join();           // warte auf beide
        scope.throwIfFailed();  // wenn einer fehlschlägt -> beide abbrechen

        return new Response(user.resultNow(), orders.resultNow());
    }
}

// Vorteil: Wenn getUser() fehlschlägt ->
// orders-Task wird automatisch abgebrochen
// Kein manuelles future.cancel() nötig!
```

---

## ScopedValue - Motivation

- Problem mit ThreadLocal: Jeder Thread hat eigene Kopie, Speicherlecks, mutable, Probleme mit Virtual Threads
- Lösung: ScopedValue (JEP 446) — immutable, scope-gebunden, sicher für Virtual Threads
- Anwendungsfalle: Request-ID, User-Context, Transaktions-ID

---

## ScopedValue vs. ThreadLocal

```java
// ThreadLocal (alt, mutable, Speicherleck-Gefahr)
private static final ThreadLocal<String> requestId = new ThreadLocal<>();
requestId.set("abc-123");
// ... requestId.get() ...
requestId.remove();  // manuelle Bereinigung!

// ScopedValue (neu, immutable, scope-gebunden)
private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();

ScopedValue.where(REQUEST_ID, "abc-123")
    .run(() -> {
        // Innerhalb dieses Scopes:
        String id = REQUEST_ID.get();  // "abc-123"
    });
// Ausserhalb: REQUEST_ID.get() -> NoSuchElementException (sicher!)
```

---

## ScopedValue - Beispiel

```java
public class RequestContext {
    private static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    public static void processRequest(String requestId, String user) {
        ScopedValue.where(REQUEST_ID, requestId)
            .where(USER, user)
            .run(() -> handle());
    }

    private static void handle() {
        System.out.println("Request " + REQUEST_ID.get() + " by " + USER.get());
        // weiterer Code ohne explizite Parameterübergabe
    }
}

// Virtual Threads + ScopedValues: perfekte Kombination
Thread.startVirtualThread(() ->
    RequestContext.processRequest("req-1", "alice")
);
```

---

## Zusammenfassung

- Virtual Threads: leichtgewichtige Threads (M:N), Millionen gleichzeitig möglich
- I/O-blockierende Operationen blockieren keine Platform Threads
- Structured Concurrency: Strukturierte Lebenszyklen für Sub-Tasks
- StructuredTaskScope: ShutdownOnFailure / ShutdownOnSuccess
- ScopedValue: Scope-gebundene, immutable Kontextwerte (Alternative zu ThreadLocal)
