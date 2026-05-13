# Kata 2: Serienbrief mit Wenn-Dann-Regeln

## Ziel

Lerne bedingte Texte im Serienbrief mit "Wenn-Dann"-Regeln.

Manchmal soll nicht in allen Briefen der gleiche Text stehen, sondern nur unter bestimmten Bedingungen.

**Beispiele:**
- "Wenn Gast aus WIEN → Hinweis zum Parken"
- "Wenn Premium-Kunde → Extra-Text mit Dankeschön"
- "Wenn weiblich → Sehr geehrte Frau, wenn männlich → Sehr geehrter Herr"

## Aufgabenstellung

Erstelle einen Serienbrief mit einer Wenn-Dann-Regel.

Situation:
- Gäste aus **Wien** bekommen einen Extra-Hinweis:
  > "Als Gast aus Wien erhalten Sie einen kostenlosen Getränkegutschein!"
- Gäste aus anderen Orten bekommen diesen Hinweis **nicht**.

---

### Schritt 1: Excel-Tabelle erweitern

Nimm die Excel-Tabelle aus Kata 1 oder erstelle eine neue:

| Anrede | Vorname | Nachname | Ort | Status |
|--------|---------|----------|-----|--------|
| Herr | Max | Mustermann | Wien | Premium |
| Frau | Anna | Beispieldame | Graz | Standard |
| Herr | Peter | Testmann | Wien | Premium |
| Frau | Maria | Müller | Salzburg | Standard |
| Herr | Hans | Huber | Innsbruck | Standard |

Neu ist die Spalte `Ort` oder `Status`, die wir für die Regel verwenden.

**Speichern und Excel schließen!**

---

### Schritt 2: Serienbrief starten wie gewohnt

1. Neues Word-Dokument
2. Schreibe einen Text:

```
[Adressblock]

[Grußzeile]

wir freuen uns auf Ihren Besuch am Schulfest.

[HIER KOMMT DER BEDINGTE TEXT]

Mit freundlichen Grüßen
```

3. Serienbrief-Assistent starten:
   - Sendungen → Schritt-für-Schritt-Seriendruck-Assistent
   - Datenquelle auswählen (deine Excel-Datei)
   - Adressblock und Grußzeile einfügen wie gewohnt

---

### Schritt 3: Wenn-Dann-Regel einfügen

Jetzt kommt die Regel!

1. Klicke im Text an die Stelle, wo der bedingte Text stehen soll
2. Menü: **Sendungen → Regeln**
3. Wähle: **Wenn...Dann...Sonst...**

**Dialog "Einfügen von Word-Feld: Wenn" erscheint:**

Einstellungen:

| Feld | Wert |
|------|------|
| **Feldname:** | Ort (oder: Status, je nachdem was du verwenden willst) |
| **Vergleich:** | gleich |
| **Vergleichswert:** | Wien (oder: Premium) |
| **Dann diesen Text einfügen:** | `Als Gast aus Wien erhalten Sie einen kostenlosen Getränkegutschein!` |
| **Sonst diesen Text einfügen:** | (LEER lassen, oder Standard-Text wie "Vielen Dank für Ihre Anmeldung!") |

4. Klicke **OK**

---

### Schritt 4: Testen mit Vorschau

1. Menü: **Sendungen → Vorschau der Ergebnisse**
2. Blättere durch die Datensätze mit den Pfeilen >> und <<

**Prüfe:**

| Gast | Erwartetes Ergebnis |
|------|---------------------|
| Max Mustermann (Wien/Premium) | Extra-Text erscheint! |
| Anna Beispieldame (Graz/Standard) | Extra-Text erscheint NICHT |
| Peter Testmann (Wien/Premium) | Extra-Text erscheint! |
| Maria Müller (Salzburg/Standard) | Extra-Text erscheint NICHT |

---

### Schritt 5: Zusammenführen

Wenn alles passt:
- In einzelne Dokumente zusammenführen
- Prüfe das Ergebnis

---

## Weitere Regeln ausprobieren

Es gibt noch mehr nützliche Regeln unter:

| Regel | Was sie macht |
|-----------|---------------|
| **Wenn...Dann...Sonst...** | Bedingten Text einfügen (das, was wir gerade gemacht haben) |
| **Nur wenn** | Wie Wenn-Dann, aber ohne "Sonst" |
| **Nächstes Datensatz wenn** | Überspringt einen Datensatz unter bestimmter Bedingung |
| **Merke** | Speichert einen Wert zwischen |
| **Füge Text ein** | Fügt festen Text ein |

### Beispiel: "Nur wenn"

Wenn du nur Text unter einer Bedingung haben willst, ohne "Sonst"-Fall:

1. Menü: **Sendungen → Regeln → Nur wenn**
2. Einstellungen:
   - Feldname: Ort
   - Vergleich: gleich
   - Vergleichswert: Wien
   - Dann diesen Text einfügen: "Hinweis für Gäste aus Wien..."

### Beispiel: Komplexere Regel mit "Verschachtelt"

Du kannst auch mehrere Bedingungen kombinieren:

**Beispiel:**
- Wenn Ort = Wien UND Status = Premium
- Dann: "Sie sind Premium-Gast aus Wien!"

**Wie es geht:**
1. Eine Wenn-Dann-Regel einfügen: Wenn Ort = Wien
2. Innerhalb dieser Regel: Eine weitere Wenn-Dann-Regel einfügen: Wenn Status = Premium
3. Text: Doppeltes Extra!

---

## Hinweise

- Die Spalte für die Regel muss in der Excel-Datenquelle vorhanden sein
- "Vorschau der Ergebnisse" ist hier sehr wichtig, um zu testen, ob die Regeln funktionieren
- Wenn etwas nicht funktioniert: Rechtsklick auf das Feld → **Feld bearbeiten**
- Oder: Einfügen → Schnellbausteine → Feld → Suche nach "IF"

## Erweiterung (optional)

### Versuche:

1. **Regel mit "Nächstes Datensatz wenn"**
   - Männer (Geschlecht=m) sollen übersprungen werden
   - Oder: Alle außer Premium-Gäste überspringen

2. **Regel mit Zahlen**
   - Füge in Excel eine Spalte "Alter" hinzu
   - Regel: Wenn Alter > 18 → "Erwachsener"
   - Sonst: "Minderjährig"

3. **Regel für Anrede**
   - Statt fertiger "Grußzeile" kannst du auch selbst bauen:
   - Wenn Geschlecht = m → "Sehr geehrter Herr"
   - Wenn Geschlecht = w → "Sehr geehrte Frau"
