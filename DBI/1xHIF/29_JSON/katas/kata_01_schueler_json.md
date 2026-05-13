# Kata 1: Schüler JSON

## Ziel

Lerne den Aufbau von JSON, indem du ein JSON-Objekt mit Schülerdaten erstellst. Du wirst verschiedene Datentypen verwenden: Strings, Zahlen, Boolean, Null, Arrays und ein verschachteltes Objekt.

---

## Aufgabenstellung

### Schritt 1: Einfaches JSON-Objekt

Öffne einen Texteditor und erstelle eine neue Datei `schueler.json`.

Schreibe ein JSON-Objekt für eine/n Schüler/in deiner Wahl:

```json
{
  "vorname": "Anna",
  "nachname": "Müller",
  "alter": 16,
  "klasse": "1xHIF",
  "aktiv": true
}
```

**Achte auf:**
- Schlüssel in **doppelten** Anführungszeichen
- Strings in **doppelten** Anführungszeichen
- Zahlen **ohne** Anführungszeichen
- `true` und `false** klein geschrieben

Öffne die Datei in VS Code. VS Code erkennt `.json`-Dateien und markiert Syntax-Fehler automatisch rot!

---

### Schritt 2: Arrays hinzufügen

Füge Arrays für Noten und Lieblingsfächer hinzu:

```json
{
  "vorname": "Anna",
  "nachname": "Müller",
  "alter": 16,
  "klasse": "1xHIF",
  "aktiv": true,
  "noten": [1, 2, 1, 3, 2],
  "lieblingsfaecher": ["POS", "DBI", "INF"]
}
```

**Fragen:**
- Welcher Datentyp sind die Werte im Array `noten`? (Zahlen)
- Welcher Datentyp sind die Werte im Array `lieblingsfaecher`? (Strings)
- Kann ein Array verschiedene Datentypen mischen? Ja! → `[1, "Text", true]`

---

### Schritt 3: Verschachteltes Objekt

Füge eine Adresse als **verschachteltes Objekt** hinzu:

```json
{
  "vorname": "Anna",
  "nachname": "Müller",
  "alter": 16,
  "klasse": "1xHIF",
  "aktiv": true,
  "noten": [1, 2, 1, 3, 2],
  "lieblingsfaecher": ["POS", "DBI", "INF"],
  "adresse": {
    "strasse": "Musterstraße 12",
    "ort": "Wien",
    "plz": 1010
  }
}
```

**Beachte:** Das Objekt `adresse` ist IN `schueler` geschachtelt. JSON erlaubt beliebig tiefe Verschachtelung!

**Frage:** Welcher Datentyp hat der Wert von `"plz"`? (Zahl)
Und wenn die PLZ `"1010"` (mit Anführungszeichen) wäre? (String — beides ist möglich, je nachdem was du brauchst)

---

### Schritt 4: Mehrere Schüler (Array von Objekten)

Erstelle jetzt ein JSON, das **mehrere Schüler/innen** enthält.

Dazu brauchst du ein **Array**, das mehrere Objekte enthält:

```json
[
  {
    "vorname": "Anna",
    "nachname": "Müller",
    "alter": 16,
    "klasse": "1xHIF",
    "aktiv": true,
    "noten": [1, 2, 1, 3, 2],
    "lieblingsfaecher": ["POS", "DBI", "INF"],
    "adresse": {
      "strasse": "Musterstraße 12",
      "ort": "Wien",
      "plz": 1010
    }
  },
  {
    "vorname": "Ben",
    "nachname": "Schmidt",
    "alter": 17,
    "klasse": "1xHIF",
    "aktiv": false,
    "noten": [3, 2, 2, 4, 3],
    "lieblingsfaecher": ["INF", "ENG"],
    "adresse": {
      "strasse": "Schulweg 5",
      "ort": "Graz",
      "plz": 8010
    }
  },
  {
    "vorname": "Clara",
    "nachname": "Weber",
    "alter": 16,
    "klasse": "1xHIF",
    "aktiv": true,
    "noten": [1, 1, 2, 1, 1],
    "lieblingsfaecher": ["POS", "DBI", "MAT", "ENG"],
    "adresse": {
      "strasse": "Berggasse 22",
      "ort": "Linz",
      "plz": 4020
    }
  }
]
```

Füge **mindestens 3 Schüler/innen** hinzu. Verwende für jede/n:
- Unterschiedliche Namen, Alter, Klassen
- Unterschiedliche Noten und Fächer
- Unterschiedliche Adressen
- Eine/einen Schüler/in mit `"aktiv": false`

**Achtung:** Jedes Objekt außer dem letzten braucht ein Komma danach! Letztes Objekt: **kein Komma**!

---

### Schritt 5: Validieren

Gehe auf [JSONLint.com](https://jsonlint.com/) und füge dein JSON ein.

Klicke auf **"Validate JSON"**.

- Zeigt der Validator "Valid JSON" an? Super!
- Zeigt er einen Fehler an? Korrigiere ihn und versuche es erneut.

**Alternative:** Öffne die Browser-Konsole (F12 → Console) und gib ein:

```javascript
JSON.parse('dein JSON hier')
```

Ersetze `dein JSON hier` durch deinen JSON-Text (in einfachen Anführungszeichen).
- Wenn kein Fehler: Es wird ein Objekt angezeigt
- Wenn ein Fehler: Die Konsole zeigt dir, wo der Fehler ist

---

## Hinweise

- **Doppelte Anführungszeichen** (`"`) für Schlüssel und Strings — das ist die häufigste Fehlerquelle!
- **Kein Trailing-Comma:** Nach dem letzten Element in einem Objekt oder Array kommt **kein** Komma.
- **true, false, null** werden **klein** geschrieben.
- **VS Code hilft:** JSON-Dateien werden automatisch auf Fehler geprüft. Rot unterstrichen = Fehler.
- **Verschachtelung:** Denk an die Einrückung, damit du den Überblick behältst.
- **Kommas richtig setzen:** Jedes Paar außer dem letzten braucht ein Komma.

---

## Erweiterung (optional)

1. Füge ein Feld `"geburtsdatum"` im Format `"2008-03-15"` (String!) hinzu
2. Füge `"telefonnummern"` als Array von Strings hinzu: `["+43 1 2345678", "+43 664 12345678"]`
3. Füge eine Notiz `null` für Schüler/innen ohne besondere Bemerkungen hinzu
4. Erstelle eine JSON-Datei für deine eigene Klasse mit echten (anonymisierten) Daten
5. Recherchiere: Was ist JSON Schema und wozu dient es?
6. **Bonus:** Schreibe eine HTML-Seite, die dein JSON mit `JSON.parse()` einliest und als Tabelle darstellt
