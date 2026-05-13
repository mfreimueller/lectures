# Kata 1: Klasse Bankkonto

| Feld | Wert |
|------|------|
| Konzepte | Attribute, Methoden mit Parametern, Logik |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle eine Klasse `Bankkonto`:

1. Die Klasse hat die Attribute `kontostand` (double) und `inhaber` (String)
2. Die Methode `einzahlen(double betrag)` erhöht den Kontostand um den Betrag (nur positive Beträge erlaubt)
3. Die Methode `auszahlen(double betrag)` verringert den Kontostand, wenn genug Geld vorhanden ist
4. Die Methode `zeigeKontostand()` gibt den aktuellen Kontostand aus

Erstelle eine Test-Klasse mit main-Methode, die ein Konto eröffnet, ein- und auszahlt und den Kontostand anzeigt.

### Beispiel-Output

```
Konto von: Max Mustermann
Kontostand: 1000.0
Einzahlung: 500.0
Neuer Kontostand: 1500.0
Auszahlung: 200.0
Neuer Kontostand: 1300.0
Auszahlung von 2000.0 nicht möglich!
Kontostand: 1300.0
```
