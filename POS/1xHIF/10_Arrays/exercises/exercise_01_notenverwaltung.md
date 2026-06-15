# Exercise: Notenverwaltung

Erstelle ein Programm, das die Noten einer Klasse (5 Noten, z. B. 2, 3, 1, 4, 2) in einem `int`-Array speichert. Berechne den Durchschnitt, den besten und den schlechtesten Wert. Gib alle Noten sowie die Statistik aus.

**Beispielausgabe:**

```
Noten: 2 3 1 4 2
Durchschnitt: 2.4
Beste Note: 1
Schlechteste Note: 4
```

### Hinweise

- Lege das Noten-Array mit Werten an: `int[] noten = {2, 3, 1, 4, 2};`
- Durchlaufe das Array mit einer `for`-Schleife.
- Für den Durchschnitt: Summe aller Noten durch Anzahl.
- Für Minimum/Maximum: Vergleiche jedes Element mit dem aktuellen Minimum/Maximum.

### Erweiterung

- Gib aus, wie viele Schüler positiv (Note <= 4) und wie viele negativ (Note = 5) sind.
- Gib die Note mit den meisten Vorkommen (Modalwert) aus.
