# Exercise: Bankkonto mit Setter/Getter

Schreibe eine Klasse `Bankkonto` mit folgenden privaten Attributen:

- `kontoinhaber` (String)
- `kontostand` (double)
- `ueberzugsLimit` (double)

## Setter/Getter

- `kontoinhaber`: Setter (nicht leer) und Getter
- `ueberzugsLimit`: Setter (nicht negativ) und Getter
- `kontostand`: nur Getter (kein Setter — der Kontostand wird nur über Methoden geändert)

## Methoden

- `void einzahlen(double betrag)` — nur positive Beträge erlaubt
- `boolean abheben(double betrag)` — prüft, ob der Betrag das Limit nicht überschreitet

## Test

Erzeuge ein Bankkonto, zahle Geld ein, heb Geld ab und gib den Kontostand aus. Teste auch ungültige Eingaben (negativer Betrag, Überschreitung des Limits).