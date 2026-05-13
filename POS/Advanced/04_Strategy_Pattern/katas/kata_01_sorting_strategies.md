# Kata 1: Sorting Strategies

| Feld | Wert |
|------|------|
| Konzepte | Strategy Interface, Algorithmen, Bubble Sort, Quick Sort |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementiere das Strategy Pattern für verschiedene Sortieralgorithmen.

Erstelle:
1. Ein `SortStrategy`-Interface mit `void sort(int[] data)`
2. Mindestens drei konkrete Strategien: `BubbleSortStrategy`, `QuickSortStrategy`, `MergeSortStrategy`
3. Eine `Sorter`-Context-Klasse, die eine Strategie verwendet
4. Eine `SortBenchmark`-Klasse, die alle Strategien auf demselben Array ausführt und die Laufzeit misst
5. Ein Hauptprogramm zur Demonstration

### Beispiel-Output

```
Unsorted: [5, 2, 9, 1, 5, 6, 3, 8, 7, 4]

Using Bubble Sort
Sorted:   [1, 2, 3, 4, 5, 5, 6, 7, 8, 9]
Time:     0.42 ms

Using Quick Sort
Sorted:   [1, 2, 3, 4, 5, 5, 6, 7, 8, 9]
Time:     0.08 ms

Using Merge Sort  
Sorted:   [1, 2, 3, 4, 5, 5, 6, 7, 8, 9]
Time:     0.15 ms
```

### Erweiterung

Füge eine `JavaSortStrategy` hinzu, die `Arrays.sort()` verwendet und vergleiche die Laufzeiten mit einem Array von 10.000 Elementen.
