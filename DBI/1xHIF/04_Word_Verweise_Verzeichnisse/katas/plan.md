# Katas - Woche 04: Word Verweise & Verzeichnisse

---

## Kata 1: Inhaltsverzeichnis erstellen

| Feld | Wert |
|------|------|
| Konzepte | Überschriften-Stile (Überschrift 1/2/3), Inhaltsverzeichnis generieren, aktualisieren |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle ein Dokument mit Überschriften und lass Word automatisch ein Inhaltsverzeichnis generieren.

#### Schritt 1: Dokument mit Stilen erstellen

Neues Dokument. Schreibe folgenden Text und wende die richtigen Stile an:

```
[Überschrift 1 - Strg+Alt+1]  1. Einleitung

Diese Hausarbeit behandelt das Thema Word für wissenschaftliche Arbeiten.
Die korrekte Formatierung ist wichtig für eine gute Benotung.

[Überschrift 2 - Strg+Alt+2]  1.1 Hintergrund

Früher wurden Dokumente von Hand geschrieben und formatiert.
Heute übernimmt das der Computer.

[Überschrift 1 - Strg+Alt+1]  2. Hauptteil

Im Hauptteil geht es um die Kernkonzepte.

[Überschrift 2 - Strg+Alt+2]  2.1 Methodik

Die richtige Methodik ist entscheidend.

[Überschrift 3 - Strg+Alt+3]  2.1.1 Vorgehensweise

Zuerst wird dies gemacht, dann jenes.

[Überschrift 2 - Strg+Alt+2]  2.2 Ergebnisse

Die Ergebnisse zeigen...

[Überschrift 1 - Strg+Alt+1]  3. Zusammenfassung

Am Ende folgt die Zusammenfassung.
```

Tipp: Nutze die Tastenkürzel!
- `Strg+Alt+1` = Überschrift 1
- `Strg+Alt+2` = Überschrift 2
- `Strg+Alt+3` = Überschrift 3
- `Strg+Umsch+N` = Standard (Fließtext)

#### Schritt 2: Inhaltsverzeichnis einfügen

1. Gehe an den ANFANG des Dokuments (vor "1. Einleitung")
2. Füge eine neue Seite ein: `Strg+Enter`
3. Gehe zurück auf die neue Seite 1
4. Schreibe als Überschrift: **"Inhaltsverzeichnis"** (mit Stil Überschrift 1 oder manuell)
5. Drücke `Enter` einmal
6. Menü: **Referenzen → Inhaltsverzeichnis**
7. Wähle eine der automatischen Vorlagen

Fertig!

#### Schritt 3: Test der Aktualisierung

Teste, ob das Inhaltsverzeichnis aktualisiert werden kann:

1. Ändere im Text:
   - "1. Einleitung" → "1. EINLEITUNG NEU"
   - Oder: Lösche einen Abschnitt
   - Oder: Füge eine Seite zwischen den Text ein

2. Klicke **ins Inhaltsverzeichnis** (markiert es)
3. **Rechtsklick → Feld aktualisieren**
4. Wähle: **Ganzes Inhaltsverzeichnis aktualisieren**
5. OK

→ Die Änderung sollte im Inhaltsverzeichnis sichtbar sein!

### Häufige Fehler

1. Keine Stile verwendet → Inhaltsverzeichnis ist leer
2. Falscher Stil (nur "Überschrift 1", aber keine "Überschrift 2") → Keine Hierarchie
3. Vergessen zu aktualisieren → Alte Überschriften/Seitenzahlen

---

## Kata 2: Fußnoten & Beschriftungen

| Feld | Wert |
|------|------|
| Konzepte | Fußnoten einfügen, Bildbeschriftungen mit autom. Nummerierung, Abbildungsverzeichnis |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Teil A: Fußnoten

Teil B: Bildbeschriftungen

#### Teil A: Fußnoten

1. Neues Dokument oder weiteres Dokument
2. Schreibe:
   ```
   Fußnoten sind wichtig in wissenschaftlichen Arbeiten.
   Sie belegen Behauptungen mit Quellen.
   
   Laut einer Studie sind 73% aller Studenten der Meinung, dass Fußnoten kompliziert sind[HIER KLICKEN].
   ```

3. Klicke hinter "sind" (da, wo ich das `[HIER KLICKEN]` geschrieben habe - direkt hinter das Wort)
4. Menü: **Referenzen → Fußnote einfügen**
5. Word springt automatisch nach unten zur Fußzeile
6. Schreibe dort:
   ```
   Quelle: Eigene Umfrage unter 100 Studierenden, 2026.
   ```

7. Füge mehr Text und weitere Fußnoten hinzu:
   - Füge eine zweite Fußnote ein
   - Füge eine dritte Fußnote ein

Beobachte: Die Nummerierung erfolgt automatisch!

#### Teil B: Beschriftungen (für Bilder)

1. Füge ein Bild ein:
   - **Einfügen → Bilder → Dieses Gerät** wählen oder
   - Einfügen → Icons (einfaches Symbol)
   - Oder: Ein Screenshot

2. Klicke das Bild an, sodass es markiert ist
3. **Rechtsklick → Beschriftung einfügen**
4. Oder: **Referenzen → Beschriftung einfügen**
5. Einstellungen:
   - **Bezeichnung:** Abbildung
   - **Position:** Unterhalb des Elements
   - **Beschriftung:** "Ein schönes Bild aus dem Internet"
6. OK

→ Word fügt automatisch hinzu: `Abbildung 1: Ein schönes Bild...`

7. Füge ein ZWEITES Bild ein
8. Wiederhole Beschriftung einfügen
9. Beachte: Jetzt steht automatisch `Abbildung 2: ...`

**Test:**
- Füge jetzt ein DRITTES Bild ZWISCHEN Bild 1 und 2 ein
- Füge eine Beschriftung hinzu → `Abbildung 2: ...`
- Aber: Das "alte" Bild 2 ist jetzt `Abbildung 3`!
- **Aber:** Die Beschriftungstexte wurden NICHT automatisch aktualisiert!

**Aktualisieren:**
- `Strg+A` (Alles markieren)
- `F9` (oder Rechtsklick → Feld aktualisieren)
- Jetzt sollten alle Nummern passen!

#### Teil C: Abbildungsverzeichnis (Optional)

Wenn du mehrere Bilder mit Beschriftungen hast:

1. Gehe an den Anfang des Dokuments (oder da, wo das Verzeichnis soll)
2. Menü: **Referenzen → Abbildungsverzeichnis**
3. Wähle Vorlage
4. OK

→ Fertig!

### Wichtige Hinweise

- Fußnoten: Immer direkt hinter das zu belegende Wort klicken, nicht dahinter einen Abstand
- Beschriftungen: Immer erst das Bild markieren!
- Aktualisieren mit `F9` oder "Feld aktualisieren"

### Erweiterung (optional)

Erstelle ein "komplettes" wissenschaftliches Dokument-Muster:
1. Titelblatt (ohne Seitenzahl)
2. Inhaltsverzeichnis (römisch)
3. Abbildungsverzeichnis (römisch)
4. Haupttext (arabisch, mit Fußnoten)
5. Literaturverzeichnis
