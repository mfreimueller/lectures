# Kata 2: ExecutorService

| Feld | Wert |
|------|------|
| Konzepte | ExecutorService, Callable, Future, Thread-Pool |
| Schwierigkeit | 2/5 |
| Dauer | ca. 40 min |

### Aufgabenstellung

Implementiere eine parallele Summenberechnung für ein grosses Array mit `ExecutorService`.

1. Erstelle ein Array mit 1.000.000 zufälligen Integer-Werten (1-100).

2. Teile das Array in gleich grosse Segmente auf (z.B. 100.000 Elemente pro Segment).

3. Erstelle eine `SumTask implements Callable<Long>`:
   - Nimmt ein Sub-Array (oder Start/End-Index) entgegen
   - Berechnet die Summe des Segments
   - Gibt das Ergebnis als Long zurück

4. Reiche alle Tasks bei einem `ExecutorService` mit 4 Threads ein.

5. Sammle alle `Future<Long>` und summiere die Ergebnisse.

6. Vergleiche die Zeit mit einer sequenziellen Berechnung (einfache Schleife).

### Beispiel-Output

```
Array size: 1,000,000
Segments: 10 (100,000 elements each)

Parallel computation (4 threads):
  Result: 50,523,847
  Time: 23 ms

Sequential computation:
  Result: 50,523,847
  Time: 8 ms
```

### Erweiterung

Probiere verschiedene Pool-Größen (1, 2, 4, 8, 16) aus und miss die Zeiten. Wann ist der Thread-Pool schneller als sequenziell? Wann wird er langsamer?
