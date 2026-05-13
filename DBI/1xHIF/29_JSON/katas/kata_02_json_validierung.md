# Kata 2: JSON Validierung

## Ziel

Lerne, typische JSON-Fehler zu erkennen und zu korrigieren. Du wirst fehlerhafte JSON-Dateien analysieren, reparieren und mit einem Validator prüfen.

---

## Aufgabenstellung

### Schritt 1: Fehlerhafte JSONs analysieren

Unten siehst du 6 fehlerhafte JSON-Dateien. Jede enthält **genau einen Fehler**.

Finde den Fehler in jeder Datei und schreibe auf, was falsch ist.

**Datei A:**

```json
{
  'name': 'Anna',
  'alter': 16
}
```

**Datei B:**

```json
{
  name: "Anna",
  alter: 16
}
```

**Datei C:**

```json
{
  "name": "Anna",
  "alter": 16,
}
```

**Datei D:**

```json
{
  "name": "Anna",
  "alter": 16,
  "aktiv": True
}
```

**Datei E:**

```json
{
  "name": "Anna",
  "alter": 16
  "aktiv": true
}
```

**Datei F:**

```json
{
  "name": "Anna",
  "hobbys": ["Sport", "Musik", "Lesen",]
}
```

---

### Schritt 2: Fehler korrigieren

Korrigiere jede Datei. Erstelle für jede korrigierte Version eine eigene Datei:

| Fehlerhafte Datei | Korrigierte Datei |
|-------------------|-------------------|
| `fehler_a.json` | `korrigiert_a.json` |
| `fehler_b.json` | `korrigiert_b.json` |
| `fehler_c.json` | `korrigiert_c.json` |
| `fehler_d.json` | `korrigiert_d.json` |
| `fehler_e.json` | `korrigiert_e.json` |
| `fehler_f.json` | `korrigiert_f.json` |

Schreibe die korrigierten JSONs in deinen Texteditor und speichere sie.

---

### Schritt 3: Validieren mit JSONLint

Gehe auf [JSONLint.com](https://jsonlint.com/).

1. Füge **eine korrigierte Datei nach der anderen** ein
2. Klicke auf **"Validate JSON"**
3. Wenn "Valid JSON" angezeigt wird: ✅ Weiter zur nächsten
4. Wenn ein Fehler angezeigt wird: Korrigiere ihn und versuche es erneut

Trage in einer Tabelle ein, ob die Validierung erfolgreich war:

| Datei | Fehler gefunden? | Korrigiert? | Validierung bestanden? |
|-------|------------------|-------------|------------------------|
| A | Einfache Anführungszeichen | Ja/Nein | Ja/Nein |
| B | | | |
| C | | | |
| D | | | |
| E | | | |
| F | | | |

---

### Schritt 4: Eigenes fehlerhaftes JSON erstellen

Jetzt bist du dran! Erstelle ein JSON-Objekt mit **3 versteckten Fehlern**.

1. Schreibe ein JSON, das eine Person beschreibt (mindestens 5 Felder)
2. Baue **3 Fehler** ein (z.B. Trailing-Comma, fehlende Anführungszeichen, falsche Boolean-Schreibweise)
3. Speichere als `fehler_selbstgemacht.json`
4. Gib die Datei einer Mitschülerin/einem Mitschüler
5. Versuche, die Fehler der anderen zu finden und zu korrigieren

**Wichtig:** Merk dir, welche Fehler du eingebaut hast, damit du die Korrektur überprüfen kannst!

---

### Schritt 5: Browser-Konsole als Validator

Öffne die Browser-Konsole (F12 → Konsole / Console).

Teste deine korrigierten JSONs mit:

```javascript
JSON.parse('{"name":"Anna","alter":16}')
```

- Funktioniert es? → Es wird ein Objekt angezeigt: `{name: 'Anna', alter: 16}`
- Gibt es einen Fehler? → Die Konsole zeigt eine Fehlermeldung mit Zeilennummer

Teste auch ein **bewusst fehlerhaftes** JSON:

```javascript
JSON.parse("{'name':'Anna'}")
```

**Frage:** Welche Fehlermeldung zeigt die Konsole?

---

## Hinweise

**Die 5 häufigsten JSON-Fehler:**

| Fehler | Falsch | Richtig |
|--------|--------|---------|
| Einfache Anführungszeichen | `'name': 'Anna'` | `"name": "Anna"` |
| Schlüssel ohne Anführungszeichen | `name: "Anna"` | `"name": "Anna"` |
| Trailing-Comma | `"alter": 16,` | `"alter": 16` |
| true/false/null groß | `True`, `False`, `Null` | `true`, `false`, `null` |
| Fehlendes Komma | `"name": "Anna" "alter": 16` | `"name": "Anna", "alter": 16` |

**JSON Validatoren:**
- [JSONLint.com](https://jsonlint.com/) — einfach und schnell
- VS Code — zeigt Fehler automatisch an (bei `.json`-Dateien)
- Browser-Konsole — `JSON.parse('...')`
- [JSON Schema Validator](https://www.jsonschemavalidator.net/) — prüft auch die Struktur

**Tipp für VS Code:**
- VS Code markiert JSON-Fehler mit roter Wellenlinie
- Wenn du mit der Maus über die rote Markierung fährst, siehst du die Fehlermeldung
- Drücke `Cmd+Shift+P` (Mac) / `Ctrl+Shift+P` (Windows) und suche nach "JSON" für weitere Tools

---

## Erweiterung (optional)

1. **Schwerer:** Finde heraus, was passiert, wenn du eine Zahl mit führender Null in JSON schreibst (z.B. `"plz": 0100`). Ist das gültig?
2. **JSON vergleichen:** Schreibe ein korrektes JSON und kopiere es. Füge dann ein Leerzeichen mehr ein. Sind beide Versionen gültig?
3. **Komplexer Fehler:** Erstelle ein JSON mit **verschachtelten Objekten**, das einen Fehler in der Tiefe hat. Gib es einer/m Partner/in zum Korrigieren.
4. **JSON vs. JavaScript:** Warum ist `{name: "Anna"}` in JavaScript erlaubt, aber nicht in JSON? Recherchiere den Unterschied.
5. **Programmierung:** Schreibe ein kleines Python- oder JavaScript-Programm, das eine JSON-Datei einliest, auf Gültigkeit prüft und "Valid" oder "Invalid" ausgibt.
