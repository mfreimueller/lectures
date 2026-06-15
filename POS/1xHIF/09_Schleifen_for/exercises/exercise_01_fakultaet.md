# Exercise: Fakultät

Schreibe ein Programm, das mit einer `for`-Schleife die Fakultät einer Zahl n berechnet (n! = 1 × 2 × 3 × ... × n). Für n = 5 ist das Ergebnis 120. Gib die Rechnung und das Ergebnis aus. Teste mit verschiedenen Werten für n.

**Beispiel für n = 5:**

```
5! = 1 * 2 * 3 * 4 * 5 = 120
```

**Weitere Beispiele:**

```
3! = 1 * 2 * 3 = 6
7! = 1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040
```

### Hinweise

- n! ist definiert als das Produkt aller Zahlen von 1 bis n.
- 0! = 1 (mathematische Definition, musst du nicht implementieren).
- Verwende eine Variable `ergebnis`, die bei 1 startet.
- Multipliziere in der Schleife: `ergebnis *= i`.
- Für die Ausgabe der Rechnung kannst du die Multiplikatoren in einem String sammeln.

### Erweiterung

- Frage den Benutzer nach der Zahl n.
- Gib eine Fehlermeldung aus, wenn n negativ ist.
- Berechne auch die Summe 1 + 2 + ... + n und gib beide Ergebnisse vergleichend aus.
