# Kata 02: Bubblesort optimiert mit Early Break

Schreibe eine Methode `void bubbleSortOptimiert(int[] arr)`, die Bubblesort mit zwei Optimierungen implementiert:

1. **Early Break:** Wenn in einem Durchgang keine Vertauschung stattfindet, ist das Array bereits sortiert und die Schleife kann abgebrochen werden.
2. **Count Swaps:** Zähle die Anzahl der Vertauschungen und gib sie aus.

Beispiel:

```java
int[] zahlen = {5, 2, 8, 1, 9};
bubbleSortOptimiert(zahlen);
// Ausgabe: Vertauschungen: 5
System.out.println(java.util.Arrays.toString(zahlen));
// [1, 2, 5, 8, 9]
```

Hinweise:
- Verwende eine boolean-Variable `swapped`, die in jedem Durchlauf zurückgesetzt wird
- Wenn nach der inneren Schleife `swapped` false ist, brich mit `break` ab
- Zähle die Vertauschungen mit einem int-Zähler
