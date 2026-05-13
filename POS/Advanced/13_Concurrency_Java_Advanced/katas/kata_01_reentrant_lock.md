# Kata 1: ReentrantLock

| Feld | Wert |
|------|------|
| Konzepte | Lock, ReentrantLock, tryLock, unlock |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Implementiere einen thread-sicheren Zahler mit `ReentrantLock` statt `synchronized`.

1. Erstelle eine Klasse `LockCounter` mit:
   - Privatem Feld `int count`
   - Privatem `ReentrantLock lock`
   - Methode `void increment()` (count++, immer in lock()/unlock())
   - Methode `void decrement()` (count--, immer in lock()/unlock())
   - Methode `int getCount()` (lesend, auch im Lock)

2. Erstelle eine Klasse `CounterTask implements Runnable`:
   - 1000x increment() und 1000x decrement() auf dem Counter

3. Starte in main():
   - 10 Threads parallel
   - Nach allen Threads: Ausgabe des Endwerts (sollte 0 sein)

4. Zusatz: Rufe `lock.getQueueLength()` auf um zu sehen, wie viele Threads warten.

### Beispiel-Output

```
Starting count: 0
Running 10 threads with 2000 operations each...
All threads completed.
Final count: 0
Tasks waiting during execution: 347 (Gesamtwartende uber alle Aufrufe)
```

### Erweiterung

Fuge eine `void incrementWithTimeout()`-Methode hinzu die `tryLock(500, TimeUnit.MILLISECONDS)` verwendet. Was passiert, wenn der Lock nicht erworben werden kann?
