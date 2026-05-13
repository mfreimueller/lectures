# Lecture: Woche 28 - CSV

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] Texteditor (VS Code / Notepad++) offen
- [ ] Excel offen mit Beispiel-CSV
- [ ] CSV-Dateien mit UTF-8 und ANSI Encoding vorbereitet (mit Umlauten)
- [ ] Beispiel-CSV mit verschiedenen Delimitern vorbereitet

---

## 1. Wiederholung (10 min)

Quick-Quiz zu Markdown und AsciiDoc:

1. "Wie macht man in Markdown eine Überschrift 1. Ordnung?" → `# `
2. "Welches Zeichen leitet eine Tabelle in AsciiDoc ein?" → `|===
3. "Was ist der Unterschied zwischen Markdown und AsciiDoc bei Tabellen?" → AsciiDoc hat mehr Funktionen (Zellen verbinden, Ausrichtung)

---

## 2. Theorie: CSV (25 min)

### Was ist CSV?

CSV = **C**omma-**S**eparated **V**alues = "durch Komma getrennte Werte"

Ein einfaches Textformat für Tabellendaten.

**Grundaufbau:**

```
Name;Alter;Ort
Anna;16;Wien
Ben;17;Graz
Clara;16;Linz
```

- **Eine Zeile** = Ein Datensatz (eine Tabellenzeile)
- **Trennzeichen** = Trennt die Felder voneinander
- **Erste Zeile** = Oft die Kopfzeile (Spaltennamen)

---

### Delimiter (Trennzeichen)

| Delimiter | Zeichen | Üblich in |
|-----------|---------|-----------|
| Komma | `,` | USA (Name,Alter,Ort) |
| Semikolon | `;` | Europa (Name;Alter;Ort) |
| Tabulator | `\t` | TSV-Dateien |
| Pipe | `\|` | Seltener |

**Warum Semikolon in Europa?**
- In Europa ist das Komma das Dezimaltrennzeichen: `1,5` statt `1.5`
- Ein Komma als Delimiter würde die Zahl `1,5` als zwei Felder interpretieren!
- Deshalb: In Europa oft Semikolon als Trennzeichen

**Beispiel (Semikolon):**

```
Name;Alter;Note
Anna;16;1,5
Ben;17;2,3
```

**Beispiel (Komma — USA):**

```
Name,Alter,Note
Anna,16,1.5
Ben,17,2.3
```

---

### Encoding-Probleme

**Das Problem:**
- Excel speichert CSV manchmal in **ANSI** (Windows-1252) statt **UTF-8**
- Umlaute (ä, ö, ü, ß) werden dann in anderen Programmen kaputt dargestellt: `Müller` → `M�ller` oder `MÃ¼ller`

**Lösungen:**

1. **In Excel speichern:** "CSV UTF-8 (durch Trennzeichen getrennt)" wählen
2. **Nach dem Speichern prüfen:** Mit Texteditor öffnen und auf Umlaute achten
3. **Mit Texteditor nachbessern:** Im Texteditor als UTF-8 speichern

**Demo:**
- CSV mit Umlauten in UTF-8 erstellen → sieht gut aus
- Gleiche Datei in ANSI speichern → Umlaute kaputt
- In Excel "CSV UTF-8" vs. "CSV (Windows)" vergleichen

```
# UTF-8 (korrekt):
Name;Ort
Müller;Wien

# ANSI (falsch interpretiert):
Name;Ort
MÃ¼ller;Wien
```

---

### Excel ↔ CSV

**CSV in Excel öffnen:**

1. Excel öffnen → **Daten → Aus Text/CSV**
2. Datei auswählen
3. Excel erkennt meist automatisch das Trennzeichen
4. Bei Problemen: Trennzeichen manuell einstellen
5. Encoding bei Bedarf auf UTF-8 stellen

Alternative: Datei einfach doppelklicken — aber Vorsicht! Excel rät manchmal falsch.

**Excel als CSV speichern:**

1. **Datei → Speichern unter → CSV (durch Trennzeichen getrennt)**
2. **Wichtig:** Bei neueren Excel: "CSV UTF-8" wählen!
3. Folgen:
   - Alle Formatierungen (Farben, Schriftarten) gehen verloren
   - Formeln werden durch ihre aktuellen Werte ersetzt
   - Es wird NUR das aktuelle Blatt gespeichert

---

### Vorteile von CSV

- Einfach und lesbar (mit jedem Texteditor öffnen)
- Sehr klein (keine Formatierungsdaten)
- Wird von fast jedem Programm unterstützt
- Einfach maschinell zu verarbeiten (Programmierung)

### Nachteile von CSV

- Keine Formatierung (Farben, Schriftarten)
- Keine Formeln
- Keine Mehrere Tabellenblätter
- Delimiter-Probleme (Komma vs. Semikolon)
- Encoding-Probleme (ANSI vs. UTF-8)
- Keine Datentypen (alles ist Text)
- Kommas in Daten schwierig

---

### CSV mit Textqualifizierer

Was, wenn ein Feld selbst ein Komma enthält?

```
Name;Beschreibung
Anna;"Pizza, Pasta, Sushi"
Ben;"Sport, Musik"
```

Das Anführungszeichen `"` ist der **Textqualifizierer** (Textqualifier).
Alles in Anführungszeichen wird als ein Feld betrachtet.

---

## 3. Live-Demo (10 min)

### Demo 1: CSV erstellen

1. Öffne Texteditor (VS Code)
2. Schreibe:

```
Vorname;Nachname;Klasse;Geburtsjahr
Anna;Müller;1xHIF;2008
Ben;Schmidt;1xHIF;2008
Clara;Weber;1xHIF;2007
```

3. Speichern als `schueler.csv`
4. Mit Excel öffnen: Doppelklick — funktioniert?

### Demo 2: Encoding-Problem

1. `schueler.csv` mit Umlauten erstellen:
```
Name;Ort
Müller;Wien
Schön;Graz
```
2. In VS Code als **UTF-8** speichern → in Excel öffnen → ok
3. In VS Code als **Windows 1252 (ANSI)** speichern → in Excel öffnen → Umlaute kaputt?
4. Lösung: In Excel "CSV UTF-8" speichern

---

## 4. Kata 1: CSV Editor erstellen (25 min)

Kata-Blätter zeigen.

---

## 5. Kata 2: CSV ↔ Excel Import (25 min)

Kata-Blätter zeigen.

---

## 6. Zusammenfassung (5 min)

| Konzept | Erklärung |
|---------|-----------|
| CSV | Comma-Separated Values, einfaches Tabellenformat |
| Delimiter | Trennzeichen: `;` (Europa), `,` (USA), `\t` (TSV) |
| Encoding | UTF-8 vs. ANSI — Umlaut-Probleme |
| Textqualifizierer | `"` um Felder mit Trennzeichen |
| Excel-Export | Formate/Formeln gehen verloren |

### Ausblick

Nächste Woche: **JSON** — strukturierte Daten für APIs und Programme.
