# Kata 1: Adresse als Attribut von Person

| Feld | Wert |
|------|------|
| Konzepte | Assoziation, Objekt als Attribut, Getter/Setter |
| Schwierigkeit | 2/5 |
| Dauer | ca. 15 min |

### Aufgabenstellung

Erstelle zwei Klassen: `Adresse` und `Person`.

1. **Klasse `Adresse`** mit folgenden privaten Attributen:
   - `strasse` (String)
   - `plz` (String)
   - `ort` (String)
   - Erstelle einen Konstruktor, der alle drei Attribute setzt.
   - Erstelle Getter und Setter fur alle Attribute.
   - Uberschreibe `toString()`, sodass die Adresse im Format `Strasse, PLZ Ort` ausgegeben wird.

2. **Klasse `Person`** mit folgenden privaten Attributen:
   - `name` (String)
   - `alter` (int)
   - `adresse` (Adresse)
   - Erstelle einen Konstruktor, der alle drei Attribute setzt.
   - Erstelle Getter und Setter fur alle Attribute.
   - Uberschreibe `toString()`, sodass die Person inklusive Adresse ausgegeben wird.

### Beispiel-Output

```
Adresse a = new Adresse("Hauptstr. 1", "1050", "Wien");
Person p = new Person("Anna", 25, a);
System.out.println(p);
// Ausgabe: Anna (25), Hauptstr. 1, 1050 Wien
```
