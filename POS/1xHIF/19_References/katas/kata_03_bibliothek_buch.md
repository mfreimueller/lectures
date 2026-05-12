# Kata 3: Bibliothek und Buch

| Feld | Wert |
|------|------|
| Konzepte | Einfache Assoziation, toString() mit delegiertem Aufruf |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Erstelle zwei Klassen: `Buch` und `Bibliothek`.

1. **Klasse `Buch`** mit folgenden privaten Attributen:
   - `titel` (String)
   - `autor` (String)
   - Konstruktor, Getter, toString()

2. **Klasse `Bibliothek`** mit folgenden privaten Attributen:
   - `name` (String)
   - `buch` (Buch) - die Bibliothek besitzt genau ein Buch
   - Zwei Konstruktoren:
     - `Bibliothek(String name)` - ohne Buch (buch = null)
     - `Bibliothek(String name, Buch buch)` - mit Buch
   - Getter und Setter fur beide Attribute
   - Uberschreibe `toString()` mit Name der Bibliothek und Buch-Info (oder "Kein Buch vorhanden" wenn buch == null)

### Beispiel-Output

```
Buch b = new Buch("Der Hobbit", "J.R.R. Tolkien");
Bibliothek bib = new Bibliothek("Stadtbibliothek", b);
System.out.println(bib);
// Ausgabe: Stadtbibliothek: Der Hobbit von J.R.R. Tolkien

Bibliothek leereBib = new Bibliothek("Schulbibliothek");
System.out.println(leereBib);
// Ausgabe: Schulbibliothek: Kein Buch vorhanden
```
