# Kata 2: CSV ↔ Excel Import

## Ziel

Lerne, wie man CSV-Dateien korrekt in Excel importiert, bearbeitet und wieder als CSV exportiert. Dabei erkennst du typische Probleme und Fallstricke.

---

## Aufgabenstellung

### Schritt 1: CSV-Datei bereitstellen

Dein Lehrer stellt dir die Datei `noten.csv` zur Verfügung. Sie enthält Noten von Schüler/innen.

Öffne die Datei **zuerst mit einem Texteditor**, um zu sehen, wie sie aufgebaut ist:

- Welches Trennzeichen wird verwendet?
- Gibt es eine Kopfzeile?
- Enthält die Datei Umlaute?
- Gibt es Textqualifizierer?

Schreibe deine Beobachtungen auf.

---

### Schritt 2: CSV in Excel importieren

Importiere die Datei `noten.csv` in Excel — aber **nicht** durch Doppelklick!

Verwende stattdessen:

**Daten → Aus Text/CSV**

Wichtig: Achte auf die Import-Einstellungen!

| Einstellung | Was einstellen? |
|-------------|-----------------|
| **Trennzeichen** | Semikolon oder Komma — je nach Datei |
| **Encoding** | UTF-8 (oder 1250/1252 bei älteren Dateien) |
| **Kopfzeile** | "Kopfzeile verwenden" aktivieren |
| **Datentyp** | Standard (oder als Text, wenn Nullen erhalten bleiben sollen) |

Klicke auf **Laden**, um die Daten in Excel zu übernehmen.

**Frage:** Was wäre passiert, wenn du die Datei einfach doppelgeklickt hättest?

---

### Schritt 3: Daten bearbeiten

Jetzt bearbeitest du die Tabelle in Excel:

1. Füge eine neue Spalte **"Note (Wort)"** hinzu
2. Schreibe neben jede Note die Bezeichnung:
   - 1 → Sehr gut
   - 2 → Gut
   - 3 → Befriedigend
   - 4 → Genügend
   - 5 → Nicht genügend

3. Füge drei neue Schüler/innen mit eigenen Noten hinzu
4. Formatiere die Tabelle:
   - Kopfzeile **fett** und hinterlegt (z.B. hellblau)
   - Noten unter 4 rot färben
   - Spaltenbreite anpassen

---

### Schritt 4: Als CSV exportieren

Exportiere die bearbeitete Tabelle wieder als CSV:

**Datei → Speichern unter → CSV UTF-8 (durch Trennzeichen getrennt)**

Speichere als `noten_bearbeitet.csv`.

Öffne die exportierte CSV-Datei mit einem **Texteditor**.

**Vergleiche:**
- Was ist anders im Vergleich zur Originaldatei `noten.csv`?
- Sind die Formatierungen (Farben, Fett) noch da?
- Sind die neuen Schüler/innen enthalten?
- Sind die Noten-Wörter (Sehr gut, etc.) korrekt exportiert?

---

### Schritt 5: Probleme erkennen

Beantworte folgende Fragen:

1. **Was ist mit den Formatierungen passiert?** Warum sind Farben und Fettdruck weg?
2. **Was passiert mit den Formeln?** (Falls du welche verwendet hast — z.B. wenn du den Notenschnitt berechnet hast)
3. **Encoding prüfen:** Öffne `noten_bearbeitet.csv` nochmal in Excel über **Daten → Aus Text/CSV**. Sind alle Umlaute korrekt? Wenn nicht: Woran liegt das?
4. **Zusätzlich: Dezimaltrennzeichen testen**
   - Gib in einer Zelle die Zahl `1,5` ein
   - Speichere als CSV
   - Öffne die CSV im Texteditor
   - Wie wird `1,5` dargestellt? Als `1,5` oder `1.5`?

---

## Hinweise

- **Nie direkt doppelklicken** zum Öffnen von CSV in Excel! Verwende **Daten → Aus Text/CSV**, um Trennzeichen und Encoding selbst zu wählen.
- **CSV UTF-8 speichern:** Verwende "CSV UTF-8 (durch Trennzeichen getrennt)" — nicht das normale "CSV (Windows)".
- **Formatierungen gehen verloren:** CSV ist ein reines Textformat — Farben, Schriftarten, Zellformatierungen und Formeln werden nicht gespeichert.
- **Nur das aktuelle Blatt** wird beim CSV-Export gespeichert. Wenn du mehrere Tabellenblätter hast, brauchst du mehrere CSV-Dateien.
- **Dezimaltrennzeichen beachten:** Mit Semikolon als Delimiter ist `1,5` eine Zahl. Mit Komma als Delimiter wird `1,5` zu zwei Feldern.

---

## Erweiterung (optional)

1. **TSV testen:** Exportiere die Tabelle als **TSV** (Tab-Separated Values). Wie unterscheidet sich die Datei?
2. **LibreOffice:** Öffne `noten.csv` in LibreOffice Calc. Welche Import-Optionen bietet LibreOffice? Ist der Import komfortabler als in Excel?
3. **Google Sheets:** Lade `noten.csv` in Google Sheets hoch. Wie verhält es sich?
4. **Riesen-CSV:** Suche eine große CSV-Datei im Internet (z.B. öffentliche Daten von data.gv.at, Statistik Austria) und versuche, sie in Excel zu öffnen. Geht das? Gibt es eine Grenze bei Excel?
5. **Programmierung:** Schreibe ein Skript in Python, das eine CSV-Datei Zeile für Zeile einliest, nach einer bestimmten Bedingung filtert und das Ergebnis wieder als CSV speichert.
