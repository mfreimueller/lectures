# Kata 1: Ampel-System für Noten

## Ziel

Lerne Zellen automatisch nach Regeln zu formatieren.

## Was ist Bedingte Formatierung?

Excel kann Zellen automatisch färben oder mit Symbolen versehen, wenn sie eine Bedingung erfüllen.

Beispiele:
- Alle Werte < 50 = Rot
- Alle Werte >= 90 = Grün
- Ampel-Symbole für Noten

**Menü:** Start → Bedingte Formatierung

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Student** | **Punkte** | **Note (1-5)** | **Status** |
| **2** | Anna Müller | 88 | 1 | |
| **3** | Ben Schmidt | 65 | 3 | |
| **4** | Clara Weber | 45 | 5 | |
| **5** | David Bauer | 92 | 1 | |
| **6** | Eva Huber | 52 | 4 | |
| **7** | Felix Mayer | 28 | 5 | |
| **8** | Greta Klein | 77 | 2 | |
| **9** | Hans Gross | 71 | 3 | |
| **10** | Ida König | 33 | 5 | |

---

### Schritt 2: Werte < 50 rot färben

**Markiere B2:B10** (die Punkte-Spalte)

Menü:
1. **Start** → **Bedingte Formatierung**
2. **Regeln für hervorgehobene Zellen**
3. **Kleiner als**
4. Gib ein: `50`
5. Format: "Rote Füllung, dunkelroter Text"
6. OK

Jetzt sind alle Punkte unter 50 rot markiert!

---

### Schritt 3: Werte >= 90 grün färben

**Markiere B2:B10** wieder

1. **Start** → **Bedingte Formatierung**
2. **Regeln für hervorgehobene Zellen**
3. **Größer als**
4. Gib ein: `89`
5. Format: "Grüne Füllung, dunkelgrüner Text"
6. OK

Jetzt sind:
- Alle < 50 = Rot
- Alle > 89 = Grün
- Die dazwischen = Normal

---

### Schritt 4: Farbskala für Punkte

Eine Farbskala zeigt automatisch einen Verlauf von Grün (hoch) über Gelb (mittel) nach Rot (niedrig).

**Markiere B2:B10**

1. **Start** → **Bedingte Formatierung**
2. **Farbskalen**
3. Wähle: "Grün - Gelb - Rot Farbskala"

Jetzt sieht man auf einen Blick:
- Grün = Hohe Punkte
- Gelb = Mittlere Punkte
- Rot = Niedrige Punkte

---

### Schritt 5: Ampel-Symbole für Note

Symbolsätze zeigen Icons wie Ampeln direkt in den Zellen.

**Markiere C2:C10** (die Note-Spalte)

1. **Start** → **Bedingte Formatierung**
2. **Symbolsätze**
3. Wähle: **"3 Ampeln (ohne Rahmen)"**

Jede Note bekommt eine Ampel:
- Note 1 = Grün
- Note 2-3 = Gelb
- Note 4-5 = Rot

---

### Schritt 6: Datenbalken

Datenbalken zeigen einen Balken proportional zum Wert.

**Markiere B2:B10**

1. **Start** → **Bedingte Formatierung**
2. **Datenbalken**
3. Wähle: **"Blaue Datenbalken"**

Jeder Wert hat einen Balken, der zeigt wie groß er ist im Vergleich zu den anderen.

---

### Schritt 7: Regeln verwalten

Du kannst deine Regeln anschauen und verwalten:

1. **Start** → **Bedingte Formatierung**
2. **Regeln verwalten**

Hier kannst du:
- Regeln bearbeiten
- Regeln löschen
- Die Reihenfolge der Regeln ändern

---

## Was du gelernt hast

| Art der Formatierung | Was macht sie? |
|----------------------|----------------|
| Regeln für hervorgehobene Zellen | Einfache Regeln wie "Kleiner als 50" |
| Farbskalen | Farbverlauf nach Wert |
| Datenbalken | Balken proportional zum Wert |
| Symbolsätze | Icons wie Ampeln oder Pfeile |

---

## Erweiterung (optional)

1. Füge weitere Schüler zur Tabelle hinzu und beobachte, wie die Formatierung automatisch angewendet wird

2. Versuche "Regeln für oben/unten":
   - Markiere B2:B10
   - Start → Bedingte Formatierung → Regeln für oben/unten
   - Versuche: "Oberste 3 Elemente" oder "Über Durchschnitt"

3. Versuche eine Formel-Regel:
   - Markiere D2:D10
   - Neue Regel → "Formel zur Bestimmung der zu formatierenden Zellen"
   - Gib ein: `=B2>=50`
   - Format: Grün
   - Dann zweite Regel für `=B2<50` → Rot
