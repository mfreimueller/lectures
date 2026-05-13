# Katas - Woche 08: Word Bewerbungsmappe

---

## Kata 1: Deckblatt gestalten

| Feld | Wert |
|------|------|
| Konzepte | Titelseite, Layout, grafische Elemente, Textpositionierung |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Gestalte ein professionelles Deckblatt für deine Bewerbung.

#### Was gehört auf ein Deckblatt?

**Pflicht:**
1. **Titel:** "BEWERBUNG" oder genauer: "Bewerbung um die Stelle als..."
2. **Vor- und Nachname:** Groß oder hervorgehoben
3. **Kontaktdaten:** Adresse, Telefon, E-Mail
4. **Ort und Datum:** z.B. "Wien, 12.05.2026"

**Optional:**
- Foto (wenn nicht im Lebenslauf)
- Firmenlogo (wenn bekannt und gewünscht)
- Grafik/Design-Element
- Stellenbezeichnung / Bereich

#### Variante A: Einfach und Clean

```
┌─────────────────────────────────────────┐
│                                         │
│                                         │
│                                         │
│              BEWERBUNG                   │
│                                         │
│     als Ferialpraktikant/in IT          │
│                                         │
│                                         │
│                                         │
│                                         │
│                                         │
│   Max Mustermann                        │
│   Hauptstraße 1                         │
│   1010 Wien                             │
│                                         │
│   Tel.: 0664/1234567                   │
│   E-Mail: max@mustermann.at             │
│                                         │
│                                         │
│   Wien, 12.05.2026                      │
│                                         │
└─────────────────────────────────────────┘
```

#### Variante B: Zweispaltig mit Foto

Linke Spalte:
- Foto
- Kontaktdaten

Rechte Spalte:
- Titel
- Stellenbezeichnung
- Datum

**Wie in Word realisieren?**
- Tabelle mit 2 Spalten
- Rahmen entfernen
- Oder: Textfelder

#### Schritt für Schritt Anleitung

1. Neues Word-Dokument
2. Menü: Layout → Seitenränder → Schmal (oder Normal)
3. Schreibe "BEWERBUNG" groß oben
4. Zentriere den Text: Start → Zentrieren
5. Formatiere: Groß, fett, evtl. andere Schriftfarbe
6. Drücke mehrfach Enter um Platz nach unten zu machen
7. Schreibe deinen Namen, Adresse, Kontaktdaten
8. Schreibe unten: Ort und Datum
9. Optional: Füge ein Bild/Symbol ein
   - Einfügen → Bilder oder Icons
10. Optional: Füge eine Farbfläche als Hintergrund hinzu
   - Einfügen → Formen → Rechteck
   - Rechteck über ganze Seite ziehen
   - Form formatieren → Füllen → Farbe wählen
   - Form formatieren → Anordnung → Hinter Text

#### Styling-Tipps

- **Weniger ist mehr:** Nicht zu viele verschiedene Schriftarten
- **Max. 2 verschiedene Schriftarten:** Eine für Überschriften, eine für Fließtext
- **Farben:** Eine Hauptfarbe (z.B. dunkelblau) + schwarz/weiß/ausgegraut
- **Kontrast:** Dunkler Text auf hellem Grund (oder umgekehrt)
- **Ausrichtung:** Alles entweder links, rechts oder zentriert (nicht wild mischen!)

### Mögliche Elemente zum Ausprobieren

| Element | Wie in Word |
|---------|--------------|
| **Große Überschrift** | Schriftgröße 28-36 pt, fett |
| **Trennlinie** | Einfügen → Formen → Linie |
| **Farbige Fläche** | Rechteck-Form "Hinter Text" |
| **Rahmen** | Start → Ränder |
| **Icons** | Einfügen → Icons |

### Erweiterung (optional)

Versuche verschiedene Layouts:

1. **Zentriertes Layout:** Alles ist zentriert
2. **Linksbündig:** Alles ist links (kann auch professionell wirken)
3. **Zweispaltig:** Linke Spalte = Foto/Kontakt, Rechte = Inhalt

---

## Kata 2: PDF-Export & Final-Check

| Feld | Wert |
|------|------|
| Konzepte | PDF-Export-Einstellungen, Komprimierung, Namenskonvention, Check-Liste |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Nimm deine Dokumente (Lebenslauf, Anschreiben, optional Deckblatt) und führe einen kompletten Final-Check durch, dann exportiere als PDF.

#### Schritt 1: Alle Dokumente öffnen

Öffne:
- Lebenslauf
- Anschreiben
- Deckblatt (falls vorhanden)

#### Schritt 2: Rechtschreibprüfung

Für JEDES Dokument:
1. `F7` drücken oder Menü: Überprüfen → Rechtschreibung und Grammatik
2. Alle korrigieren
3. Ganz wichtig: Auch SELBST nochmal durchlesen! (Rechtschreibprüfung findet nicht alles)

#### Schritt 3: Layout prüfen

Checkliste:

- [ ] Gleiche Schriftart in allen Dokumenten?
- [ ] Keine wilden Farben?
- [ ] Konsistente Schriftgrößen?
- [ ] Keine leeren Seiten am Ende?
- [ ] Seitenzahlen (falls vorhanden) passen?
- [ ] Anrede passt? ("Sehr geehrter Herr" vs. "Sehr geehrte Frau")
- [ ] Datum aktuell?

#### Schritt 4: Dokumente zusammenfügen (Optional)

Wenn alles in EINEM PDF sein soll:

**Möglichkeit A: In Word zusammenfügen**

1. Öffne das Dokument, das als ERSTES stehen soll (z.B. Deckblatt oder Anschreiben)
2. Gehe ans ENDE des Dokuments
3. Layout → Umbrüche → **Nächste Seite** (neuer Abschnitt)
4. Menü: **Einfügen → Objekt → Text aus Datei...**
5. Wähle das nächste Dokument (z.B. Lebenslauf)
6. Wiederhole bis alle Dokumente drin sind
7. Speichern als neues Dokument: `Bewerbung_Komplett.docx`

**Möglichkeit B: Später im PDF-Editor zusammenfügen**

- Einzeln als PDF exportieren
- Dann mit PDF-Tool zusammenfügen (z.B. Adobe Acrobat, diverse Online-Tools)

#### Schritt 5: Bilder komprimieren

Wenn Bilder im Dokument sind:

1. Ein Bild markieren
2. Menü: **Grafikformat → Bilder komprimieren**
3. Einstellungen:
   - [ ] Haken entfernen bei: "Nur dieses Bild anwenden" (damit alle Bilder komprimiert werden!)
   - Auflösung: **E-Mail (96 ppi)** (reicht für Bildschirm)
4. OK

#### Schritt 6: PDF exportieren

1. Menü: **Datei → Exportieren → PDF/XPS-Dokument erstellen**
2. Button: **PDF/XPS erstellen**
3. **WICHTIG: Guter Dateiname!**
   - ❌ Schlecht: `Bewerbung.pdf`
   - ✅ Gut: `Bewerbung_Max_Mustermann_Ferialpraktikum_2026.pdf`
4. Button: **Optionen...**
5. Einstellungen:
   - Seiten: Alle
   - Kommentare einfügen: Nein
   - Dokumentstruktur-Tags: Ja
6. OK
7. **Speichern**

#### Schritt 7: PDF öffnen und prüfen!

**NICHT ÜBERSPRINGEN!**

1. Öffne die erstellte PDF
2. Blättere durch ALLE Seiten
3. Prüfe:
   - [ ] Passt das Layout?
   - [ ] Sind alle Seiten da?
   - [ ] Sind Bilder sichtbar?
   - [ ] Keine Zeilenumbrüche "kaputt gegangen"?
   - [ ] Keine leeren Seiten am Ende?
4. Wenn etwas nicht passt: In Word korrigieren und neu exportieren!

#### Schritt 8: Namenskonvention

Finale Prüfung des Dateinamens:

✅ **Gute Beispiele:**
```
Bewerbung_Max_Mustermann_Ferialpraktikum_IT.pdf
Lebenslauf_Anna_Beispieldame_2026.pdf
Anschreiben_Sarah_Schmidt_TechSolutions.pdf
```

❌ **Schlechte Beispiele:**
```
Bewerbung.pdf
doc1.pdf
FINAL.pdf
FINAL_FINAL.pdf
Neues Microsoft Word-Dokument.pdf
```

### Final-Check Liste

- [ ] Rechtschreibprüfung über ALLE Dokumente
- [ ] Keine offensichtlichen Fehler im Text
- [ ] Konsistente Schriftart
- [ ] Keine leeren Seiten
- [ ] PDF NACH dem Export nochmal geöffnet und geprüft
- [ ] Dateiname ist sinnvoll
- [ ] Anrede ist korrekt

### Wenn E-Mail Versand:

**Betreff der E-Mail:**
```
Bewerbung Ferialpraktikant/in IT - Max Mustermann
```

**E-Mail-Text (kurz):**
```
Sehr geehrte Frau Schmidt,

anbei erhalten Sie meine Bewerbungsunterlagen für die ausgeschriebene Stelle als Ferialpraktikant/in.

Ich freue mich auf Ihre Rückmeldung.

Mit freundlichen Grüßen
Max Mustermann
Tel.: 0664/1234567
```

**Anhang:**
- Die PDF-Datei
- Nicht: DOCX-Datei!
