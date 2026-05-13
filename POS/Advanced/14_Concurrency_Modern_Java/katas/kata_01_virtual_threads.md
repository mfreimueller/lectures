# Kata 1: Virtual Threads

| Feld | Wert |
|------|------|
| Konzepte | Virtual Threads, Platform Threads, ExecutorService |
| Schwierigkeit | 2/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Vergleiche die Performance von Virtual Threads vs. Platform Threads.

1. **Teil 1: Platform Threads**
   - Erstelle einen `ExecutorService` mit `Executors.newFixedThreadPool(100)`
   - Fuhre 10.000 Tasks aus, die jeweils 100ms schlafen (Thread.sleep)
   - Miss die Gesamtzeit

2. **Teil 2: Virtual Threads**
   - Erstelle einen `ExecutorService` mit `Executors.newVirtualThreadPerTaskExecutor()`
   - Gleiche Anzahl Tasks (10.000), gleiche sleep-Dauer
   - Miss die Gesamtzeit

3. **Teil 3: Skalierungsversuch**
   - Erhohe auf 100.000 Tasks (nur Virtual Threads)
   - Miss die Zeit

4. Gib die Ergebnisse tabellarisch aus.

### Beispiel-Output

```
=== Vergleich: Platform vs. Virtual Threads ===

10.000 Tasks, je 100ms Sleep:
  Platform Threads (Pool 100): 10.234 ms
  Virtual Threads:             1.045 ms
  Speedup:                     9.8x

100.000 Tasks, je 100ms Sleep:
  Virtual Threads:             10.234 ms
```

### Erweiterung

Simuliere CPU-intensive Tasks (z.B. Primzahlenberechnung) statt I/O. Zeige, dass Virtual Threads bei CPU-Last keinen Vorteil bieten.
