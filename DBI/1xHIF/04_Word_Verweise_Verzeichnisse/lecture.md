# Lecture: Woche 04 - Word Verweise & Verzeichnisse

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Was brauche ich, um römische und arabische Seitenzahlen in einem Dokument zu haben?" → **Abschnittswechsel**
2. "Welcher Button ist am wichtigsten nach einem Abschnittswechsel?" → **"Mit vorherigem verknüpfen" AUSSCHALTEN!**
3. "Start bei 1 oder Fortfahren von vorherigem?" → **Start bei 1** für neuen Abschnitt

---

## 2. Theorie: Inhaltsverzeichnis (20 min)

### Das Wichtigste zuerst!

**INHALTSVERZEICHNIS = STILE!**

Wenn du Überschriften so formatierst:
- Markieren → Fett → Größe 16

...dann kann Word **KEIN** automatisches Inhaltsverzeichnis erstellen!

Word braucht:
- **Überschrift 1** (Strg+Alt+1)
- **Überschrift 2** (Strg+Alt+2)
- **Überschrift 3** (Strg+Alt+3)

Nur dann erkennt Word die Hierarchie.

### Live-Demo: Inhaltsverzeichnis

**Voraussetzung:** Dokument mit Überschriften-Stilen.

1. Dokument erstellen:
   ```
   [Überschrift 1] 1. Einleitung
   Text...
   
   [Überschrift 2] 1.1 Hintergrund
   Text...
   
   [Überschrift 1] 2. Hauptteil
   Text...
   
   [Überschrift 2] 2.1 Methodik
   Text...
   ```

2. Einfügen:
   - Cursor an die Stelle, wo das Inhaltsverzeichnis soll (an den ANFANG!)
   - **Strg+Enter** für neue Seite, wenn nötig
   - Menü: **Referenzen → Inhaltsverzeichnis**
   - Eine Vorlage wählen

3. Fertig!

### Aktualisieren

**Wichtig:** Inhaltsverzeichnis aktualisiert sich NICHT automatisch!

Wenn du:
- Überschriften hinzufügst/löschst
- Überschriften umbenennst
- Seitenzahlen ändern sich

Dann manuell aktualisieren:

1. Klicke ins Inhaltsverzeichnis
2. **Rechtsklick → Feld aktualisieren**
3. Wähle:
   - **Nur Seitenzahlen aktualisieren** (schnell)
   - **Ganzes Inhaltsverzeichnis aktualisieren** (wenn Überschriften geändert)

Oder: Menü Referenzen → **Inhaltsverzeichnis aktualisieren**

### Benutzerdefiniertes Inhaltsverzeichnis

Referenzen → Inhaltsverzeichnis → Benutzerdefiniertes Inhaltsverzeichnis

Einstellungen:
- **Füllzeichen:** Zwischen Überschrift und Seitenzahl (Punkte, Striche, etc.)
- **Ebenen anzeigen:** Wie viele Ebenen (Überschrift 1-3 oder nur 1-2)?
- **Hyperlinks:** Damit man im PDF klicken kann

---

## 3. Theorie: Beschriftungen & weitere Verzeichnisse (20 min)

### Beschriftungen

Für Bilder und Tabellen braucht man oft "Bild 1: ...", "Tabelle 2: ..."

**Problem bei manuell:**
- Wenn ich Bild 2 lösche, ist Bild 3 plötzlich Bild 2...
- Muss ich von Hand durchzählen und umbenennen!

**Mit Word-Beschriftungen:**
- Automatische Nummerierung
- Nummerierung aktualisiert sich automatisch

### Demo: Beschriftung einfügen

1. Klicke auf ein Bild (oder markiere Tabelle)
2. Rechtsklick → **Beschriftung einfügen**
3. Oder: Referenzen → **Beschriftung einfügen**
4. Einstellungen:
   - **Bezeichnung:** "Abbildung", "Tabelle", "Grafik", etc.
   - **Position:** Unterhalb des Elements (Standard)
   - **Beschriftung:** Text eingeben
5. OK

Word fügt automatisch ein: `Abbildung 1: Mein Bildtext`

**Wenn ich jetzt ein Bild davor einfüge:**
- Neue Nummerierung automatisch!

### Abbildungsverzeichnis

Genau wie Inhaltsverzeichnis, aber für Bilder:

1. Stelle, wo es sein soll
2. Menü: **Referenzen → Abbildungsverzeichnis**
3. Vorlage wählen

**Gleiches gilt für:**
- Tabellenverzeichnis
- Formelverzeichnis

---

## 4. Theorie: Fußnoten (10 min)

### Fußnoten einfügen

1. Klicke im Text an die Stelle, wo eine Fußnote referenziert wird
   - Beispiel: "...laut einer Studie[HIER KLICKEN]..."
2. Menü: **Referenzen → Fußnote einfügen**
3. Word springt automatisch zur Fußzeile (oder Seitenende)
4. Fußnoten-Text eingeben

Word erstellt automatisch eine hochgestellte Zahl im Text und eine Fußnote unten.

### Fußnoten bearbeiten

- Einfach in der Fußnote unten bearbeiten
- Rechtsklick auf Fußnotenzeichen im Text → "Fußnote bearbeiten"

### Fußnoten vs. Endnoten

| Art | Platz |
|-----|-------|
| Fußnote | Unten auf der SEITE |
| Endnote | Am ENDE des Dokuments |

---

## 5. Kata 1: Inhaltsverzeichnis erstellen (20 min)

Kata-Blätter zeigen.

**Wichtig:** Stile zuerst prüfen! Wenn kein "Überschrift 1" verwendet wurde, geht nichts.

---

## 6. Kata 2: Fußnoten & Beschriftungen (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Voraussetzung TOC | **Überschriften-Stile** (Überschrift 1/2/3), nicht manuell formatieren! |
| Referenzen → Inhaltsverzeichnis | TOC generieren |
| Rechtsklick → Feld aktualisieren | TOC aktualisieren |
| Rechtsklick → Beschriftung einfügen | Für Bilder/Tabellen → autom. Nummerierung |
| Referenzen → Fußnote einfügen | Fußnote |

### Ausblick

Nächste Woche: **Serienbrief**
