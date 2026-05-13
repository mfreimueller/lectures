# Kata 3: Mini-Taschenrechner

| Feld | Wert |
|------|------|
| Konzepte | Methoden, Switch-Case, Scanner, Menüführung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Schreibe einen Taschenrechner mit Menü und Methoden.

1. Zeige ein Menü mit den Optionen Addieren, Subtrahieren, Multiplizieren, Dividieren, Beenden
2. Der Benutzer wählt eine Operation (1-5)
3. Der Benutzer gibt zwei Zahlen ein
4. Das Ergebnis wird berechnet und ausgegeben
5. Das Menü erscheint erneut, bis der Benutzer "Beenden" wählt
6. Jede Operation ist eine eigene Methode

### Methoden

- `double addieren(double a, double b)`
- `double subtrahieren(double a, double b)`
- `double multiplizieren(double a, double b)`
- `double dividieren(double a, double b)` - mit Prüfung auf Division durch 0
- `void zeigeMenue()` - zeigt das Menü an

### Beispiel-Output

```
=== Mini-Taschenrechner ===
1 - Addieren
2 - Subtrahieren
3 - Multiplizieren
4 - Dividieren
5 - Beenden
Wahl: 1
Erste Zahl: 10
Zweite Zahl: 5
Ergebnis: 15.0

=== Mini-Taschenrechner ===
1 - Addieren
2 - Subtrahieren
3 - Multiplizieren
4 - Dividieren
5 - Beenden
Wahl: 5
Auf Wiedersehen!
```
