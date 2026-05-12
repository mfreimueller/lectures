# Kata 03: Array-Filter (gerade Zahlen)

Schreibe eine Methode `int[] filterGerade(int[] eingabe)`, die ein neues Array nur mit den geraden Zahlen aus dem Eingabe-Array zurueckgibt.

Beispiel:

```java
int[] zahlen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int[] gerade = filterGerade(zahlen);
// Ergebnis: {2, 4, 6, 8, 10}
```

Vorgehen:
1. Zaehle zuerst, wie viele gerade Zahlen es gibt
2. Erzeuge ein neues Array mit der passenden Groesse
3. Befuelle das neue Array mit den geraden Zahlen
