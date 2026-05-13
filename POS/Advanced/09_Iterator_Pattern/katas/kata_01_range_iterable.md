# Kata 1: Range Iterable

| Feld | Wert |
|------|------|
| Konzepte | Iterable, Iterator, For-Each |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

## Aufgabenstellung

Implementieren Sie eine Klasse `Range`, die das Interface `Iterable<Integer>` implementiert. Die Klasse soll einen Zahlenbereich von start (inklusive) bis end (exklusive) reprasentieren.

- `Range(int start, int end)` — Konstruktor
- Die for-each-Schleife soll uber alle Zahlen von start bis end-1 iterieren
- Optional: `Range(int end)` — start ist default 0

### Beispiel-Output

```
Range range = new Range(1, 5);
for (int n : range) {
    System.out.print(n + " ");
}
// Output: 1 2 3 4

Range range2 = new Range(3);
for (int n : range2) {
    System.out.print(n + " ");
}
// Output: 0 1 2
```

### Erweiterung

Fugen Sie einen zweiten Iterator hinzu, der ruckwarts iteriert. Implementieren Sie dafur eine Methode `Iterable<Integer> reversed()`, die ein Iterable zuruckgibt, das von end-1 bis start lauft.
