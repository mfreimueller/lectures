# Kata 3: Noten-Array mit Statistik

| Feld | Wert |
|------|------|
| Konzepte | Array-Analyse, mehrere Ruckgabewerte, Berechnungen mit double |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Implementiere eine Klasse `NotenStatistik` mit mehreren statischen Methoden zur Analyse eines Noten-Arrays (Noten von 1 bis 5).

1. **`double durchschnitt(int[] noten)`**: Berechne den Notendurchschnitt.
2. **`int besteNote(int[] noten)`**: Finde die beste Note (kleinster Wert).
3. **`int schlechtesteNote(int[] noten)`**: Finde die schlechteste Note (grosster Wert).
4. **`int anzahlDurchgefallen(int[] noten)`**: Zahle die Noten mit Wert 5.
5. **`void printStatistik(int[] noten)`**: Gib alle Statistiken aus.

### Beispiel-Output

```
int[] noten = {2, 3, 1, 4, 5, 2, 3, 4, 1};
NotenStatistik.printStatistik(noten);

// Ausgabe:
// Noten: 9 Eintrage
// Durchschnitt: 2.78
// Beste Note: 1
// Schlechteste Note: 5
// Durchgefallen: 1
```
