# Kata 1: Bibliothek mit mehreren Buchern

| Feld | Wert |
|------|------|
| Konzepte | Array von Objektreferenzen, Methoden zur Verwaltung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle die Klassen `Buch` und `Bibliothek`.

1. **Klasse `Buch`** mit:
   - Attributen: `titel` (String), `autor` (String)
   - Konstruktor, Getter, toString()

2. **Klasse `Bibliothek`** mit:
   - Attributen: `name` (String), `buecher` (Buch[10]), `anzahl` (int)
   - Methode `buchHinzufuegen(Buch b)`: Fuge ein Buch hinzu, falls noch Platz ist
   - Methode `buecherAuflisten()`: Gib alle Bucher aus (mit Index)
   - Methode `getAnzahl()`: Gib die Anzahl der Bucher zuruck
   - toString() mit Name und Anzahl der Bucher

### Beispiel-Output

```
Bibliothek bib = new Bibliothek("Stadtbibliothek");
bib.buchHinzufuegen(new Buch("Der Hobbit", "Tolkien"));
bib.buchHinzufuegen(new Buch("1984", "Orwell"));
System.out.println(bib.anzahl()); // 2
bib.buecherAuflisten();
// Ausgabe:
// 1. Der Hobbit von Tolkien
// 2. 1984 von Orwell
```
