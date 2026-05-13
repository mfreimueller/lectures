# Lecture: Woche 29 - JSON

---

## 1. Wiederholung (10 min)

Quick-Quiz zu CSV:

1. "Wofür steht CSV?" → Comma-Separated Values
2. "Warum verwendet man in Europa oft Semikolon statt Komma?" → Komma ist Dezimaltrennzeichen
3. "Welches Problem tritt bei CSV mit Umlauten auf?" → Encoding (ANSI vs. UTF-8)
4. "Was geht beim Speichern von Excel als CSV verloren?" → Formatierungen, Formeln

---

## 2. Theorie: JSON (25 min)

### Was ist JSON?

JSON = **J**ava**S**cript **O**bject **N**otation

Ein Datenformat für strukturierte Daten. Es ist:
- **Für Menschen lesbar** (ähnlich wie CSV, aber mächtiger)
- **Für Maschinen leicht zu verarbeiten**
- **Sprachenunabhängig** (jede Programmiersprache kann JSON lesen)
- **Der Standard für APIs** (Web-Schnittstellen)

---

### Grundaufbau

JSON kennt zwei grundlegende Strukturen:

**Objekt** — eine Sammlung von Schlüssel/Wert-Paaren:

```json
{
  "name": "Anna",
  "alter": 16
}
```

- Umgrenzt von `{` und `}`
- Schlüssel sind immer Strings in doppelten Anführungszeichen
- Schlüssel und Wert werden durch `:` getrennt
- Paare werden durch `,` getrennt

**Array** — eine geordnete Liste von Werten:

```json
["Anna", "Ben", "Clara"]
```

- Umgrenzt von `[` und `]`
- Werte werden durch `,` getrennt

---

### JSON-Datentypen

| Typ | Beispiel | Beschreibung |
|-----|----------|--------------|
| **String** | `"Hallo"` | Text, immer in doppelten Anführungszeichen |
| **Number** | `123`, `123.45` | Ganze Zahlen und Kommazahlen (Punkt!) |
| **Boolean** | `true`, `false` | Wahr/Falsch-Werte (klein geschrieben!) |
| **Null** | `null` | Kein Wert (klein geschrieben!) |
| **Object** | `{ "key": "value" }` | Geschachteltes Objekt |
| **Array** | `["a", "b", "c"]` | Liste von Werten |

**Wichtig:** Strings NUR mit doppelten Anführungszeichen! In JavaScript/TypeScript sind auch einfache Anführungszeichen erlaubt — in JSON nicht!

---

### JSON-Beispiel

```json
{
  "name": "Anna",
  "alter": 16,
  "klasse": "1xHIF",
  "aktiv": true,
  "noten": [1, 2, 1, 3],
  "adresse": {
    "strasse": "Musterstraße 12",
    "ort": "Wien",
    "plz": 1010
  }
}
```

---

### Wichtige Regeln

1. **Schlüssel immer in doppelten Anführungszeichen**
   - Richtig: `"name": "Anna"`
   - Falsch: `name: "Anna"` oder `'name': "Anna"`

2. **Kein Trailing-Comma** (Komma nach dem letzten Element)
   - Richtig: `"a": 1, "b": 2` — letztes ohne Komma
   - Falsch: `"a": 1, "b": 2,` — Komma nach 2!

3. **Strings immer in doppelten Anführungszeichen**
   - Richtig: `"Hallo"`
   - Falsch: `'Hallo'` oder `Hallo`

4. **Keine Kommentare** in JSON! (Anders als in Code)

---

### JSON validieren

JSON muss **syntaktisch korrekt** sein, sonst können Programme es nicht lesen.

**Validierungs-Tools:**
- [JSONLint.com](https://jsonlint.com/) — der Klassiker
- Browser-Konsole: `JSON.parse('{"name":"Anna"}')` — liefert `null` bei Fehler
- VS Code: Zeigt JSON-Fehler automatisch an (wenn die Datei `.json` heißt)
- [JSON Schema Validator](https://www.jsonschemavalidator.net/) — für fortgeschrittene Validierung

**Typische Fehler:**
- Fehlende Anführungszeichen bei Schlüsseln
- Einfache statt doppelte Anführungszeichen
- Trailing-Comma
- Fehlende Klammern
- Falsche Schreibweise von `true`, `false`, `null`

---

### JSON vs. CSV

| Kriterium | CSV | JSON |
|-----------|-----|------|
| Struktur | Flache Tabelle | Beliebig verschachtelt |
| Datentypen | Alles Text | Strings, Zahlen, Boolean, Null |
| Lesbarkeit | Einfach, kompakt | Etwas mehr Text, aber lesbar |
| Komplexität | Nur 2D-Tabelle | Objekte in Objekten, Arrays |
| APIs/Programmierung | Selten verwendet | **Der Standard** |
| Excel-Kompatibilität | Sehr gut | Schlecht (kein nativer Import) |
| Dateigröße | Kleiner | Größer (mehr Text) |

**Faustregel:**
- Einfache Tabellen → CSV
- Komplexe, verschachtelte Daten → JSON
- Datenaustausch zwischen Programmen → JSON (oft)
- Datenanalyse in Excel → CSV

---

## 3. Live-Demo (10 min)

### Demo 1: JSON erstellen

1. Texteditor öffnen, neue Datei `schueler.json`
2. JSON-Objekt erstellen:

```json
{
  "vorname": "Anna",
  "nachname": "Müller",
  "alter": 16,
  "klasse": "1xHIF",
  "aktiv": true
}
```

3. Datei speichern, im Browser/Validator prüfen

### Demo 2: Typische Fehler zeigen

Fehlerhafte JSONs zeigen und gemeinsam korrigieren:

```json
// Fehler 1: Einfache Anführungszeichen
{ 'name': 'Anna' }

// Fehler 2: Keine Anführungszeichen bei Schlüssel
{ name: "Anna" }

// Fehler 3: Trailing-Comma
{ "name": "Anna", }

// Fehler 4: true/False groß geschrieben
{ "aktiv": True }
```

### Demo 3: JSON Validator

1. JSONLint.com öffnen
2. Korrektes JSON einfügen → "Valid JSON"
3. Fehlerhaftes JSON einfügen → Fehlermeldung zeigen
4. Browser-Konsole: `JSON.parse('...')` zeigen

---

## 4. Kata 1: Schüler JSON (25 min)

Kata-Blätter zeigen.

---

## 5. Kata 2: JSON Validierung (25 min)

Kata-Blätter zeigen.

---

## 6. Zusammenfassung (5 min)

| Konzept | Erklärung |
|---------|-----------|
| JSON | JavaScript Object Notation, strukturiertes Datenformat |
| Objekt | `{ "key": "value" }` — Schlüssel/Wert-Paare |
| Array | `[wert1, wert2]` — geordnete Liste |
| Datentypen | String, Number, Boolean, Null, Object, Array |
| Validierung | JSONLint, Browser-Konsole, VS Code |
| JSON vs. CSV | JSON für komplexe/verschachtelte Daten, CSV für einfache Tabellen |

### Abschluss Datenformate-Modul

Wir haben in den letzten Wochen gelernt:
- **Markdown** — einfaches Textformat für Dokumentation
- **AsciiDoc** — mächtiger als Markdown, für technische Dokumentation
- **CSV** — einfaches Tabellenformat
- **JSON** — strukturiertes Datenformat für APIs

Diese Formate sind überall in der IT zu finden!
