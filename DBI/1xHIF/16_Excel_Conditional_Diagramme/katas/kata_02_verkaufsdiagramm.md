# Kata 2: Verkaufsdiagramm erstellen

## Ziel

Lerne Diagramme in Excel zu erstellen und anzupassen.

## Die wichtigsten Diagrammtypen

| Typ | Darstellung | Wann verwenden? |
|-----|-------------|-----------------|
| **Säule** | Vertikale Balken | Werte vergleichen |
| **Linie** | Linie mit Punkten | Verlauf über Zeit |
| **Kreis** | Kreis in Segmente | Anteile am Ganzen |
| **Balken** | Horizontale Balken | Bei langen Labels |

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

| | A | B | C |
|---|---|---|---|
| **1** | **Monat** | **Umsatz** | **Kosten** |
| **2** | Jän | 12000 | 8000 |
| **3** | Feb | 15000 | 9500 |
| **4** | Mrz | 11000 | 7500 |
| **5** | Apr | 18000 | 10000 |
| **6** | Mai | 22000 | 12000 |
| **7** | Jun | 19000 | 11000 |

---

### Schritt 2: Säulendiagramm erstellen

**Wichtig:** Markiere die gesamte Tabelle inklusive der Überschriften!

1. **Markiere A1:C7**
2. Menü: **Einfügen**
3. **Säulendiagramm**
4. Wähle: **"Gruppiertes Säulendiagramm"**

Fertig! Ein Diagramm erscheint mit:
- Blau = Umsatz
- Orange = Kosten

---

### Schritt 3: Diagrammtitel ändern

1. Klicke auf den Titel (über dem Diagramm)
2. Schreibe: **"Umsatz & Kosten 1. Halbjahr"**

---

### Schritt 4: Layout und Stil anpassen

Klicke ins Diagramm, damit die Reiter "Diagrammentwurf" und "Format" erscheinen.

**Schnelllayout:**
1. Reiter: **Diagrammentwurf**
2. Klicke auf **Schnelllayout**
3. Probier verschiedene Layouts aus

**Formatvorlage:**
1. Reiter: **Diagrammentwurf**
2. Klicke auf **Formatvorlagen**
3. Wähle einen schönen Stil

---

### Schritt 5: Datenbeschriftungen hinzufügen

Datenbeschriftungen zeigen die Werte direkt über den Balken.

1. Klicke auf eine der blauen Balken (Umsatz)
2. Klicke auf das **Plus-Symbol (+)** oben rechts am Diagramm
3. Hake bei **"Datenbeschriftungen"** an

Jetzt stehen die Werte direkt über den Balken!

---

### Schritt 6: Liniendiagramm erstellen

Für Verläufe über die Zeit ist ein Liniendiagramm oft besser.

1. **Markiere A1:C7**
2. **Einfügen** → **Liniendiagramm**
3. Wähle: **"Linie mit Markern"**

**Vergleich:**
- Säulendiagramm = Guter **Vergleich** von Umsatz vs. Kosten pro Monat
- Liniendiagramm = Guter **Verlauf** über die Monate

---

### Schritt 7: Kreisdiagramm für Anteile

Kreisdiagramme zeigen Anteile am Ganzen.

**Wichtig:** Kreisdiagramme nur für **max. 5-6 Kategorien**! Sonst wird es unübersichtlich.

1. **Markiere A1:B7** (nur Monat und Umsatz)
2. **Einfügen** → **Kreisdiagramm**
3. Wähle: **"Kreis"**

**Datenbeschriftungen mit Prozenten:**

1. Klicke auf das Kreisdiagramm
2. Plus-Symbol (+) → **Datenbeschriftungen** → Pfeil → **Mehr Optionen**
3. Wähle bei "Bezeichnung enthält":
   - [x] Prozent
   - [x] Kategoriename

Jetzt sieht man den prozentualen Anteil jedes Monats am Gesamtumsatz.

---

### Schritt 8: Diagramm verschieben und vergrößern

**Verschieben:**
- Klicke auf den Rand des Diagramms
- Halte Maustaste gedrückt
- Ziehe an die gewünschte Position

**Größe ändern:**
- Klicke ins Diagramm
- Ziehe an den Ecken oder Seiten

---

## Die Diagramm-Typen im Überblick

| Typ | Wann? |
|-----|-------|
| **Säulendiagramm** | Vergleich von Werten verschiedener Kategorien |
| **Liniendiagramm** | Verlauf über die Zeit |
| **Kreisdiagramm** | Anteile am Ganzen (max. 5-6 Kategorien!) |
| **Balkendiagramm** | Wie Säule, aber horizontal (bei langen Kategorienamen) |

## Workflow zum Erstellen

1. **Daten markieren** (inklusive Überschriften!)
2. **Einfügen** → Gewünschten Diagrammtyp wählen
3. **Anpassen:**
   - Titel ändern
   - Layout/Stil wählen
   - Datenbeschriftungen hinzufügen
   - Achsenbeschriftungen

---

## Erweiterung (optional)

1. Versuche ein **kombiniertes Diagramm**:
   - Umsatz als Säule
   - Kosten als Linie
   - Tipp: Rechtsklick auf eine Datenreihe → "Diagrammtyp ändern"

2. Versuche ein **Flächendiagramm**:
   - Ähnlich wie Liniendiagramm, aber Fläche gefüllt

3. Ändere die Farben des Diagramms:
   - Reiter "Diagrammentwurf" → "Farben ändern"

4. Füge eine **Trendlinie** hinzu:
   - Rechtsklick auf eine Linie → "Trendlinie hinzufügen"
   - Zeigt die durchschnittliche Entwicklung

5. (Schwer) Erstelle ein Diagramm aus **nicht zusammenhängenden Daten**:
   - Markiere A1:A7 (Monate)
   - Halte `Ctrl` gedrückt
   - Markiere C1:C7 (Kosten)
   - Lösche `Ctrl`
   - Einfügen → Diagramm
   → Jetzt hast du nur Kosten, nicht Umsatz
