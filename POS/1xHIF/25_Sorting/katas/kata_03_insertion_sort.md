# Kata 03: Insertion Sort

Schreibe eine Methode `void insertionSort(int[] arr)`, die ein int-Array mit Insertion Sort sortiert.

Beispiel:

```java
int[] zahlen = {5, 2, 8, 1, 9};
insertionSort(zahlen);
System.out.println(java.util.Arrays.toString(zahlen));
// [1, 2, 5, 8, 9]
```

Hinweise:
- Beginne bei Index 1 (das erste Element ist bereits sortiert)
- Speichere das aktuelle Element in einer Variablen
- Verschiebe größere Elemente nach rechts
- Füge das aktuelle Element an der richtigen Stelle ein
