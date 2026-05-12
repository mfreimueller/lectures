# Kata 1: Summe / Min / Max eines int-Arrays

| Feld | Wert |
|------|------|
| Konzepte | Array-Iteration, Berechnungen |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Implementiere eine Klasse `ArrayUtils` mit drei statischen Methoden.

1. **`int summe(int[] zahlen)`**: Berechne die Summe aller Elemente.
2. **`int min(int[] zahlen)`**: Finde das kleinste Element.
3. **`int max(int[] zahlen)`**: Finde das grosste Element.

Schreibe ausserdem eine main()-Methode zum Testen.

### Beispiel-Output

```
int[] zahlen = {12, 7, 19, 3, 25, 8};

int s = ArrayUtils.summe(zahlen);   // 74
int mi = ArrayUtils.min(zahlen);    // 3
int ma = ArrayUtils.max(zahlen);    // 25

System.out.println("Summe: " + s);
System.out.println("Min: " + mi);
System.out.println("Max: " + ma);
```
