# Kata 1: CSV Editor erstellen

## Ziel

Lerne den Aufbau von CSV-Dateien kennen, indem du eine CSV-Datei manuell mit einem Texteditor erstellst. Du wirst verschiedene Delimiter (Trennzeichen) und Encoding-Optionen testen.

---

## Aufgabenstellung

### Schritt 1: Einfache CSV mit Semikolon

Öffne einen Texteditor (VS Code, Notepad++ oder einen anderen Editor deiner Wahl) und erstelle eine neue Datei.

Schreibe folgende Daten als CSV:

```csv
Vorname;Nachname;Klasse;Ort;Geburtsjahr
Anna;Müller;1xHIF;Wien;2008
Ben;Schmidt;1xHIF;Graz;2009
Clara;Weber;1xHIF;Linz;2008
David;Bauer;1xHIF;Salzburg;2008
Eva;Huber;1xHIF;Wien;2009
```

Speichere die Datei als `schueler_semikolon.csv`.

Öffne sie dann mit einem Doppelklick in Excel.
- Werden die Spalten richtig erkannt?
- Sind die Umlaute korrekt?

---

### Schritt 2: Verschiedene Delimiter testen

Erstelle zwei weitere Versionen derselben Daten:

**a) Mit Komma als Trennzeichen** → `schueler_komma.csv`

```
Vorname,Nachname,Klasse,Ort,Geburtsjahr
Anna,Müller,1xHIF,Wien,2008
Ben,Schmidt,1xHIF,Graz,2009
Clara,Weber,1xHIF,Linz,2008
David,Bauer,1xHIF,Salzburg,2008
Eva,Huber,1xHIF,Wien,2009
```

**b) Mit Tabulator als Trennzeichen** → `schueler_tsv.csv`

Tipp: In VS Code / Texteditor die **Tab-Taste** drücken, um einen Tabulator einzufügen.

```
Vorname	Nachname	Klasse	Ort	Geburtsjahr
Anna	Müller	1xHIF	Wien	2008
Ben	Schmidt	1xHIF	Graz	2009
Clara	Weber	1xHIF	Linz	2008
David	Bauer	1xHIF	Salzburg	2008
Eva	Huber	1xHIF	Wien	2009
```

Öffne beide Dateien in Excel. Was fällt dir auf?

- Funktioniert das Komma als Trennzeichen bei `Müller`? (Denk an die Umlaute — das ist ein Encoding-Problem, nicht das Trennzeichen!)
- Was passiert mit der Tabulator-Version? Erkennt Excel das Trennzeichen automatisch?

**Frage:** Warum ist Semikolon in Europa oft besser als Komma?

---

### Schritt 3: Encoding testen

Wir bleiben bei der Semikolon-Version.

1. Erstelle eine CSV mit Umlauten:
   ```
   Name;Ort;Beruf
   Müller;Wien;Ingenieur
   Schön;Graz;Architekt
   Groß;Linz;Designer
   ```

2. Speichere die Datei in deinem Texteditor einmal als:
   - `encoding_utf8.csv` → Encoding: **UTF-8**
   - `encoding_ansi.csv` → Encoding: **ANSI** (oder Windows 1252)

   *In VS Code: Unten rechts auf "UTF-8" klicken → "Save with Encoding" → gewünschtes Encoding wählen*

3. Öffne beide Dateien in Excel.
   - Siehst du einen Unterschied?
   - Sind die Umlaute in beiden Dateien korrekt?

4. Öffne beide Dateien nochmal im Texteditor.
   - Siehst du einen Unterschied im rohen Text?
   - `Müller` sieht in ANSI anders aus als in UTF-8!

---

### Schritt 4: Textqualifizierer

Was passiert, wenn ein Feld selbst ein Komma oder Semikolon enthält?

Erstelle eine neue CSV-Datei `hobbies.csv`:

```csv
Name;Hobbys;Ort
Anna;Sport;Wien
Ben;"Fußball, Tennis, Schwimmen";Graz
Clara;Lesen;Linz
David;"Reisen, Fotografie";Salzburg
```

**Warum brauchen Ben und David Anführungszeichen?**

Öffne die Datei in Excel. Werden die Hobbys von Ben und David in **einer** Spalte angezeigt?

Teste auch: Was passiert OHNE Anführungszeichen?

---

## Hinweise

- Ein **Delimiter** (Trennzeichen) trennt die Felder einer CSV-Datei. In Europa ist Semikolon üblich, weil das Komma das Dezimaltrennzeichen ist (z.B. `1,5` statt `1.5`).
- **Encoding** beschreibt, wie Zeichen gespeichert werden. UTF-8 ist der moderne Standard. ANSI (Windows-1252) wird von älteren Windows-Programmen verwendet.
- **Umlaute** (ä, ö, ü, ß) sind besonders anfällig für Encoding-Fehler.
- Ein **Textqualifizierer** (meist `"`) schützt Felder, die selbst das Trennzeichen enthalten.
- In Excel: **Daten → Aus Text/CSV** ist sicherer als Doppelklick!

---

## Erweiterung (optional)

1. Erstelle eine CSV-Datei mit Dezimalzahlen: Wie verhält sich Excel bei `1,5` vs. `1.5` mit Komma als Delimiter?
2. Öffne eine CSV-Datei in LibreOffice Calc. Welche Einstellungen bietet LibreOffice beim Import an?
3. Suche im Internet eine echte CSV-Datei (z.B. von data.gv.at) und öffne sie in Excel. Musst du Einstellungen anpassen?
4. Schreibe ein kleines Python-Skript, das eine CSV-Datei Zeile für Zeile einliest und ausgibt (optional, nur bei Interesse).
