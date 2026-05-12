# Kata 1: Konto - gekapselt

| Feld | Wert |
|------|------|
| Konzepte | private Attribute, Getter, Setter mit Validierung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle eine vollstaendig gekapselte Klasse `Konto`:

1. Attribut `private long kontostand`
2. Getter `getKontostand()` gibt den aktuellen Kontostand zurueck
3. Methode `einzahlen(long betrag)`:
   - Nur positive Betraege erlaubt
   - Bei Erfolg: Betrag zum Kontostand addieren
   - Bei Fehler: Fehlermeldung ausgeben
4. Methode `auszahlen(long betrag)`:
   - Nur positive Betraege erlaubt
   - Kontostand muss ausreichend sein
   - Bei Erfolg: Betrag abziehen
   - Bei Fehler: Fehlermeldung ausgeben
5. Konstruktor: `Konto(long startbetrag)` mit Pruefung (kein negativer Startbetrag)

Erstelle eine Test-Klasse, die alle Funktionen testet, inklusive Fehlerfaelle.

### Beispiel-Output

```
Kontostand: 1000
Einzahlung: 500 - Erfolgreich. Neuer Stand: 1500
Auszahlung: 200 - Erfolgreich. Neuer Stand: 1300
Einzahlung: -100 - Fehler: Betrag muss positiv sein!
Auszahlung: 5000 - Fehler: Nicht genug Guthaben!
```
