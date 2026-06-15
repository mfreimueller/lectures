# Große Übung: Online-Shop

Schreibe zwei Klassen: `Artikel` und `Warenkorb`.

## Klasse Artikel

Attribute (alle private):
- `artikelNr` (int)
- `bezeichnung` (String)
- `preis` (double)
- `lagerbestand` (int)

Setter mit Validierung:
- `preis` > 0
- `lagerbestand` >= 0

Getter für alle Attribute.

Methode:
- `void reduceStock(int menge)` — reduziert den Lagerbestand (nur wenn genug vorhanden)

## Klasse Warenkorb

Attribute:
- `artikel` (Artikel)
- `menge` (int)

Getter/Setter mit Validierung: Menge > 0.

Methode:
- `double getGesamtpreis()` — berechnet den Gesamtpreis (artikel.preis * menge)

## Test

Erzeuge mehrere Artikel (z. B. "Laptop", 999.99, 5 und "Maus", 29.99, 20).
Erzeuge Warenkörbe für diese Artikel.
Gib die Gesamtkosten aller Warenkörbe aus.