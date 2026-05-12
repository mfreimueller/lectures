# Kata 02: Selection Sort (String[])

Schreibe eine Methode `void selectionSort(String[] arr)`, die ein String-Array alphabetisch mit Selection Sort sortiert.

Verwende `compareTo` zum Vergleichen von Strings:

```java
if (arr[j].compareTo(arr[minIndex]) < 0) {
    // arr[j] kommt alphabetisch vor arr[minIndex]
}
```

Beispiel:

```java
String[] namen = {"Legolas", "Aragorn", "Frodo", "Gandalf", "Gimli"};
selectionSort(namen);
System.out.println(java.util.Arrays.toString(namen));
// [Aragorn, Frodo, Gandalf, Gimli, Legolas]
```
