# Kata 1: UML -> Code (Rechnung)

| Feld | Wert |
|------|------|
| Konzepte | Lesen von UML-Diagrammen, Code-Generierung aus UML |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Gegeben ist folgendes UML-Klassendiagramm. Schreibe den Java-Code dazu.

```
+---------------------------+
| Rechnung                  |
+---------------------------+
| - nummer: int             |
| - datum: String           |
| - gesamtbetrag: double    |
+---------------------------+
| + Rechnung(int, String)   |
| + drucken(): void         |
| + getNummer(): int        |
| + getDatum(): String      |
| + getGesamtbetrag(): double|
+---------------------------+
```

1. Erstelle die Klasse `Rechnung` genau wie im UML-Diagramm.
2. Die Methode `drucken()` gibt die Rechnungsdaten auf der Konsole aus.
3. Erstelle eine `main()`-Methode, die eine Rechnung erstellt und `drucken()` aufruft.

### Beispiel-Output

```
Rechnung r = new Rechnung(1001, "2024-03-15");
r.drucken();
// Ausgabe:
// Rechnung #1001
// Datum: 2024-03-15
// Gesamtbetrag: 0.0 EUR
```
