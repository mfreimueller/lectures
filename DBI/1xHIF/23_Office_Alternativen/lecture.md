# Lecture: Woche 23 - MS Office Alternativen

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] LibreOffice installiert und geöffnet
- [ ] Beispiel-DOCX-Datei vorbereitet
- [ ] Beispiel-XLSX-Datei vorbereitet
- [ ] Google Workspace-Übersicht (Browser-Tabs)

---

## 1. Einführung: Warum Alternativen zu MS Office? (10 min)

**Frage an die Klasse:**
"Wer hat schon mal was anderes als Word/Excel/PowerPoint verwendet?"

**Vier Hauptgründe:**

1. **Kosten** — Microsoft 365 kostet Geld (Abomodell). LibreOffice ist komplett kostenlos.
2. **Offene Standards** — ODF (OpenDocument Format) ist ein ISO-zertifizierter Standard. Niemand ist an einen Hersteller gebunden.
3. **Plattformunabhängigkeit** — LibreOffice läuft auf Windows, macOS, Linux. MS Office auf Windows/macOS (eingeschränkt).
4. **Datenschutz** — Bei Cloud-Lösungen (Google) sind die Daten auf fremden Servern.

**Vendor-Lock-In:**
- Wenn alles nur in DOCX/XLSX/PPTX vorliegt, ist man an Microsoft gebunden
- Offene Formate (ODT, ODS, ODP) können von vielen Programmen gelesen werden

---

## 2. Theorie: LibreOffice & ODF-Formate (25 min)

### LibreOffice

| Komponente | Entspricht | Dateiformat |
|------------|------------|-------------|
| Writer | Microsoft Word | ODT |
| Calc | Microsoft Excel | ODS |
| Impress | Microsoft PowerPoint | ODP |
| Base | Microsoft Access | ODB |
| Draw | — (Visio-ähnlich) | ODG |
| Math | Formeleditor | OMF |

**Geschichte:**
- 2010: Oracle kauft Sun (OpenOffice)
- Community forkt zu LibreOffice
- Heute: LibreOffice ist die aktivste Open-Source-Office-Suite

### OpenDocument-Format (ODF)

- **ISO-Standard** (ISO 26300)
- **ODT** = Textdokument (wie DOCX)
- **ODS** = Tabellendokument (wie XLSX)
- **ODP** = Präsentationsdokument (wie PPTX)
- **Zip-komprimiertes XML** (genau wie DOCX/XLSX/PPTX)

### Kompatibilität

| LibreOffice kann... |
|---------------------|
| DOCX öffnen und bearbeiten |
| XLSX öffnen und bearbeiten |
| PPTX öffnen und bearbeiten |
| Als DOCX/XLSX/PPTX exportieren |
| Als PDF exportieren |

**Achtung:** Komplexe Formatierungen, Makros (VBA) und ActiveX-Elemente werden nicht immer perfekt übernommen.

### Google Workspace

- **Docs** (Text), **Sheets** (Tabellen), **Slides** (Präsentationen)
- Rein cloud-basiert (keine Installation nötig)
- Kollaboration in Echtzeit (mehrere Personen gleichzeitig)
- Export als DOCX, PDF, ODT möglich
- Nachteil: Nur online nutzbar, Daten liegen bei Google

### OnlyOffice

- Stärkere MS-Office-Kompatibilität als LibreOffice
- Desktop- und Cloud-Version
- Bietet auch Kollaborations-Features
- Wird oft als "kompatibelste freie Alternative" bezeichnet

---

## 3. Live-Demo: DOCX in LibreOffice konvertieren (15 min)

### Schritt 1: DOCX in Writer öffnen
1. LibreOffice Writer starten
2. Datei → Öffnen → Beispiel.docx
3. Zeigen: Die Formatierung wird (meist) korrekt übernommen

### Schritt 2: Als ODT speichern
1. Datei → Speichern unter
2. Dateityp: "ODF Textdokument (.odt)"
3. Speichern

### Schritt 3: Formatierung prüfen
- Sind Überschriften gleich?
- Sind Tabellen korrekt?
- Sind Bilder an der richtigen Position?

### Schritt 4: Export nach PDF
- Datei → Exportieren als → PDF
- Zeigen: Auch ohne MS Office kann man PDFs erzeugen

---

## 4. Kata 1: LibreOffice Import/Export (20 min)

Kata-Blätter zeigen. Schüler arbeiten selbstständig.

---

## 5. Kata 2: ODF Kompatibilität (25 min)

Kata-Blätter zeigen. Schüler arbeiten selbstständig.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| LibreOffice | Kostenlose Open-Source-Alternative zu MS Office |
| ODT/ODS/ODP | Offene Standards (ISO 26300) |
| Kompatibilität | LibreOffice kann MS-Formate öffnen und speichern |
| Google Workspace | Cloud-basiert, Echtzeit-Kollaboration |
| OnlyOffice | Hohe MS-Office-Kompatibilität |
| ODF ist Zip+XML | Genau wie DOCX/XLSX/PPTX |

### Ausblick

Nächste Woche: **Markdown I** — Einfache Auszeichnungssprache für Dokumentation.
