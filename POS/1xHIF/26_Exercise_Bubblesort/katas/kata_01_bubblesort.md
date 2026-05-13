# Kata 01: Bubblesort

Schreibe eine Methode `void bubbleSort(int[] arr)`, die ein int-Array mit Bubblesort sortiert.

Beispiel:

```java
int[] zahlen = {5, 2, 8, 1, 9};
bubbleSort(zahlen);
System.out.println(java.util.Arrays.toString(zahlen));
// [1, 2, 5, 8, 9]
```

Hinweise:
- Vergleiche benachbarte Elemente
- Bei jedem Durchgang steigt das größte Element nach oben
- Die innere Schleife wird mit jedem Durchgang um 1 kleiner
