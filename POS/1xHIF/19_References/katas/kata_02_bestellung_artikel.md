# Kata 2: Bestellung und Artikel

| Feld | Wert |
|------|------|
| Konzepte | Referenzen zwischen unabhangigen Klassen, Delegation |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle zwei Klassen: `Artikel` und `Bestellung`.

1. **Klasse `Artikel`** mit folgenden privaten Attributen:
   - `name` (String)
   - `preis` (double)
   - Konstruktor, Getter, toString()

2. **Klasse `Bestellung`** mit folgenden privaten Attributen:
   - `nummer` (int)
   - `artikel` (Artikel) - Referenz auf den bestellten Artikel
   - `menge` (int)
   - Konstruktor, Getter
   - Methode `getGesamtpreis()` berechnet `artikel.getPreis() * menge`
   - Uberschreibe `toString()` mit Bestellnummer, Menge, Artikel und Gesamtpreis

### Beispiel-Output

```
Artikel a = new Artikel("Tastatur", 49.99);
Bestellung b = new Bestellung(1001, a, 3);
System.out.println(b);
// Ausgabe: Bestellung #1001: 3x Tastatur (49.99 EUR) = 149.97 EUR
```
