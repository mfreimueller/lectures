# Lecture: Woche 16 - Excel Bedingte Formatierung & Diagramme

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Welche Funktion gibt die ersten N Zeichen eines Textes zurück?" → `LEFT()`
2. "Wie berechnet man das Alter in Excel?" → `=DATEDIF(Geburtstag; TODAY(); "y")`
3. "Was ist das Ergebnis von `=MID("Hallo"; 2; 3)`?" → "all"

---

## 2. Theorie: Bedingte Formatierung (20 min)

### Was ist Bedingte Formatierung?

Zellen werden automatisch formatiert, wenn sie eine Bedingung erfüllen.

Beispiele:
- Alle Noten < 50 rot färben
- Alle Verkäufe > 10.000 grün färben
- Top 10 Werte hervorheben
- Ampel-Symbole für Status anzeigen

**Menü:** Start → Bedingte Formatierung

---

### Typ 1: Hervorgehobene Zellen

Einfache Regeln:

| Regel | Erklärung |
|-------|-----------|
| Größer als | `> Wert` |
| Kleiner als | `< Wert` |
| Gleich | `= Wert` |
| Zwischen | `Zwischen Wert1 und Wert2` |
| Text enthält | Enthält bestimmten Text |
| Datum auftritt | Bestimmtes Datum |
| Duplizierte Werte | Findet Doppelte |

**Live-Demo:**
- Tabelle mit Noten erstellen
- Alle < 50 rot, alle >= 90 grün

---

### Typ 2: Oben/Unten-Regeln

| Regel | Erklärung |
|-------|-----------|
| Oberste 10 Elemente | Top N Werte |
| Unterste 10 Elemente | Bottom N Werte |
| Oberste 10% | Top N Prozent |
| Unterste 10% | Bottom N Prozent |
| Über Durchschnitt | Werte > Mittelwert |
| Unter Durchschnitt | Werte < Mittelwert |

---

### Typ 3: Datenbalken

Farbbalken direkt in den Zellen, proportional zum Wert.

Gut für:
- Schnellen visuellen Vergleich
- Fortschritt anzeigen

---

### Typ 4: Farbskalen

Farbverlauf repräsentiert Werte.

Beliebt: Grün-Gelb-Rot
- Grün = Hoher Wert
- Gelb = Mittel
- Rot = Niedriger Wert

---

### Typ 5: Symbolsätze

Icons in den Zellen:

| Satz | Icons |
|------|-------|
| **Richtung** | Pfeile: ↑ ↗ → ↘ ↓ |
| **Formen** | Formen: ● ◐ ○ |
| **Indikatoren** | Ampeln: 🟢 🟡 🔴 |
| **Bewertungen** | Sterne: ★★★ |

Besonders nützlich: **Ampel-System** für Status

---

### Typ 6: Neue Regel mit Formel

Eigene Formel als Bedingung.

Beispiel:
```excel
=UND(A1>=50; B1>=50)
```

Nur formatieren, wenn BEIDE Zellen >= 50 sind.

---

### Live-Demo: Bedingte Formatierung

Erstelle am Beamer:

| | A | B | C |
|---|---|---|---|
| **1** | **Student** | **Punkte** | **Note** |
| **2** | Anna | 88 | 1 |
| **3** | Ben | 65 | 3 |
| **4** | Clara | 45 | 5 |
| **5** | David | 92 | 1 |
| **6** | Eva | 52 | 4 |
| **7** | Felix | 28 | 5 |

**Regel 1: Punkte < 50 = Rot**
- Markiere B2:B7
- Start → Bedingte Formatierung → Regeln für hervorgehobene Zellen → Kleiner als
- Wert: `50`
- Format: Rote Füllung

**Regel 2: Punkte >= 90 = Grün**
- Markiere B2:B7
- Start → Bedingte Formatierung → Regeln für hervorgehobene Zellen → Größer als
- Wert: `=89`
- Format: Grüne Füllung

**Regel 3: Ampel-Symbole für Note**
- Markiere C2:C7
- Start → Bedingte Formatierung → Symbolsätze → Ampeln (3 Symbole)

Oder Farbskala für Punkte:
- Markiere B2:B7
- Start → Bedingte Formatierung → Farbskalen → Grün-Gelb-Rot

---

## 3. Theorie: Diagramme (15 min)

### Warum Diagramme?

Zahlen sind schwer zu vergleichen. Diagramme machen Daten sichtbar.

---

### Diagrammtypen

| Typ | Darstellung | Wann? |
|-----|-------------|-------|
| **Säule** | Vertikale Balken | Werte vergleichen |
| **Balken** | Horizontale Balken | Bei langen Labels |
| **Linie** | Linie mit Punkten | Verlauf über Zeit |
| **Kreis** | Kreis in Segmente | Anteile am Ganzen |
| **Fläche** | Gefüllte Fläche | Wie Linie, aber betont Volumen |

---

### Wann welcher Typ?

**Säulendiagramm:**
- Vergleich: Verkauf nach Monat
- Kategorien: Jan, Feb, Mrz...
- Werte: Umsatz

**Liniendiagramm:**
- Verlauf: Aktienkurs über Tage
- Zeitachse: Tage
- Werte: Kurs

**Kreisdiagramm:**
- Anteile: Marktanteile
- Wichtig: Max. 5-6 Segmente, sonst unübersichtlich

---

### Diagramm erstellen - Schritt für Schritt

1. **Daten markieren** (Tabelle mit Überschriften)
2. **Einfügen** → Gewünschten Diagrammtyp wählen
3. **Anpassen** (wenn nötig)

---

### Diagramm-Elemente

| Element | Erklärung |
|---------|-----------|
| **Diagrammtitel** | Überschrift |
| **Achsen** | X-Achse (horizontal), Y-Achse (vertikal) |
| **Achsenbeschriftungen** | Was bedeuten die Achsen? |
| **Legende** | Was ist welche Farbe/Serie? |
| **Datenbeschriftungen** | Werte direkt an den Balken |
| **Datenreihe** | Eine Werte-Gruppe |

---

### Diagramm anpassen

Nach dem Erstellen:
- Klicke ins Diagramm
- Reiter **Diagrammentwurf** → Schnelllayout, Formatvorlagen
- Reiter **Format** → Farben, Effekte

Oder:
- Rechtsklick → Daten auswählen
- Rechtsklick → Achse formatieren
- Rechtsklick → Datenreihe formatieren

---

### Live-Demo: Diagramm erstellen

Erstelle am Beamer:

**Verkauf nach Monat:**

| | A | B |
|---|---|---|
| **1** | **Monat** | **Umsatz** |
| **2** | Jän | 12000 |
| **3** | Feb | 15000 |
| **4** | Mrz | 11000 |
| **5** | Apr | 18000 |
| **6** | Mai | 22000 |
| **7** | Jun | 19000 |

**Schritte:**
1. Markiere A1:B7
2. Einfügen → Säulendiagramm
3. Diagrammtitel ändern: "Umsatz 1. Halbjahr"
4. Layout mit Schnelllayout anpassen
5. Datenbeschriftungen hinzufügen

**Zweite Datenreihe hinzufügen:**

| | C |
|---|---|
| **1** | **Kosten** |
| **2** | 8000 |
| **3** | 9000 |
| **4** | 7500 |
| **5** | 10000 |
| **6** | 12000 |
| **7** | 11000 |

1. Rechtsklick ins Diagramm → Daten auswählen
2. Hinzufügen → Reihenname: `=C1`, Werte: `=C2:C7`
3. OK

Jetzt hat man Umsatz und Kosten im Vergleich.

Oder als **Liniendiagramm** für Verlauf.

---

## 4. Kata 1: Ampel-System für Noten (25 min)

Kata-Blätter zeigen.

---

## 5. Kata 2: Verkaufsdiagramm (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

### Bedingte Formatierung

| Typ | Was macht es? |
|-----|---------------|
| Hervorgehobene Zellen | Einfache Regeln (>, <, =, etc.) |
| Datenbalken | Balken in Zellen |
| Farbskalen | Farbverlauf nach Wert |
| Symbolsätze | Icons (Ampeln, Pfeile, Sterne) |

**Menü:** Start → Bedingte Formatierung

### Diagramme

| Typ | Wann? |
|-----|-------|
| Säule | Werte vergleichen |
| Linie | Verlauf über Zeit |
| Kreis | Anteile am Ganzen |

**Erstellung:** Daten markieren → Einfügen → Diagrammtyp

### Ausblick

Nächste Woche: **Konsolidierung PLÜ-Vorbereitung**
