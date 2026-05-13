# Kata 02: Matrix transponieren

Schreibe eine Methode `int[][] transponieren(int[][] matrix)`, die Zeilen und Spalten einer Matrix vertauscht.

Beispiel:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

int[][] transponiert = transponieren(matrix);
// Ergebnis:
// {1, 4},
// {2, 5},
// {3, 6}
```

Hinweise:
- Die neue Matrix hat so viele Zeilen wie die ursprüngliche Spalten hat
- Die neue Matrix hat so viele Spalten wie die ursprüngliche Zeilen hat
- Verwende verschachtelte Schleifen
- Zugriff: ergebnis[spalte][zeile] = matrix[zeile][spalte]
