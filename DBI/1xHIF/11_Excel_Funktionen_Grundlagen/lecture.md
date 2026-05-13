# Lecture: Woche 11 - Excel Funktionen Grundlagen

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Was bedeutet `$B$7`?" → Absoluter Bezug auf B7, ändert sich nicht beim Runterziehen
2. "Welche Taste durchschaltet die Bezugsarten?" → `F4`
3. "Was ist das Problem bei `=A2*B7` ohne `$`?" → Beim Runterziehen wird B7 zu B8, B9...

---

## 2. Theorie: Funktionen (30 min)

### Was ist eine Funktion?

Eine Funktion ist ein **vordefiniertes Rechenprogramm**, das eine bestimmte Aufgabe erledigt.

| Manuell | Mit Funktion |
|---------|---------------|
| `=A1+A2+A3+A4+A5` | `=SUM(A1:A5)` |
| `=(A1+A2+A3+A4+A5)/5` | `=AVERAGE(A1:A5)` |

Vorteile von Funktionen:
1. **Kürzer:** Weniger schreiben
2. **Übersichtlicher:** Leichter zu verstehen
3. **Weniger fehleranfällig:** Bei `=A1+A2+A3+...` kann man leicht eine Zelle vergessen

---

### Aufbau einer Funktion

Jede Funktion in Excel hat diesen Aufbau:

```
=Funktionsname(Argument1; Argument2; ...)
```

- `=` → Formelzeichen wie immer
- `Funktionsname` → Name der Funktion (z.B. `SUM`, `AVERAGE`)
- `()` → Klammern gehören IMMER dazu!
- `Argumente` → Was die Funktion bearbeiten soll (Bereiche, Zellen, Werte)

---

### Die wichtigsten Grundfunktionen

| Funktion | Erklärung | Beispiel |
|----------|-----------|----------|
| `SUM(Bereich)` | Summe aller Werte | `=SUM(A1:A5)` |
| `AVERAGE(Bereich)` | Durchschnitt (Mittelwert) | `=AVERAGE(A1:A5)` |
| `COUNT(Bereich)` | Zählt nur Zellen mit Zahlen | `=COUNT(A1:A5)` |
| `COUNTA(Bereich)` | Zählt alle nicht-leeren Zellen | `=COUNTA(A1:A5)` |
| `MIN(Bereich)` | Kleinster Wert | `=MIN(A1:A5)` |
| `MAX(Bereich)` | Größter Wert | `=MAX(A1:A5)` |

---

### Bereichsnotation

Statt einzelne Zellen zu addieren:
```excel
=A1+A2+A3+A4+A5
```

Kann man einen **Bereich** schreiben:
```excel
=SUM(A1:A5)
```

`A1:A5` bedeutet: Alle Zellen von A1 bis A5.

**Weitere Beispiele:**

| Bereich | Bedeutung |
|---------|-----------|
| `A1:A5` | Spalte A, Zeilen 1 bis 5 |
| `B2:D4` | Rechteck von B2 bis D4 |
| `A1:A5; C1:C5` | Beide Bereiche (Semikolon als Trennzeichen) |
| `A1; B3; C5` | Drei einzelne Zellen |

**Tipp:** Markieren mit der Maus!
- Schreibe `=SUM(`
- Dann markiere mit der Maus den gewünschten Bereich
- Excel trägt den Bereich automatisch ein

---

### Live-Demo: Noten-Tabelle

Erstelle diese Tabelle am Beamer:

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | **Student** | **Test 1** | **Test 2** | **Test 3** | **Summe** | **Schnitt** |
| **2** | Anna | 85 | 90 | 88 | | |
| **3** | Ben | 75 | 82 | 78 | | |
| **4** | Clara | 92 | 88 | 95 | | |

**In E2 (Summe):**
```excel
=SUM(B2:D2)
```

**In F2 (Schnitt/Durchschnitt):**
```excel
=AVERAGE(B2:D2)
```

Runterziehen auf E3, F3, E4, F4.

---

### MIN und MAX

Zusatz: Beste und schlechteste Note in Test 1:

In B6 (Beste Note):
```excel
=MAX(B2:B4)
```

In B7 (Schlechteste Note):
```excel
=MIN(B2:B4)
```

---

### COUNT vs. COUNTA

**Wichtiger Unterschied:**

| Funktion | Was zählt sie? |
|----------|-----------------|
| `COUNT()` | Nur Zellen mit **ZAHLEN** |
| `COUNTA()` | Alle **nicht leeren** Zellen (auch Text!) |

**Beispiel:**

| | A |
|---|---|
| **1** | 100 |
| **2** | 200 |
| **3** | Hallo |
| **4** | 300 |
| **5** | |

- `=COUNT(A1:A5)` = 3 (nur die Zahlen: 100, 200, 300)
- `=COUNTA(A1:A5)` = 4 (alle nicht leeren: 100, 200, Hallo, 300)

**Regel:**
- Zählen von Zahlen/Werten → `COUNT()`
- Zählen von Einträgen (auch Text) → `COUNTA()`

---

### Funktionen verschachteln

Man kann Funktionen in anderen Funktionen verwenden.

**Beispiel: Spannweite (Differenz zwischen Max und Min)**

```excel
=MAX(A1:A5) - MIN(A1:A5)
```

Oder:

```excel
=AVERAGE(B2:D2) * 2
```

---

## 3. AutoSumme-Button (15 min)

Den schnellsten Weg gibt es über den Button:

**Start → AutoSumme (Σ)**

Oder:
**Formeln → AutoSumme**

Klick auf AutoSumme und Excel schlägt automatisch einen Bereich vor!

Mehr Optionen unter AutoSumme:
- Summe
- Durchschnitt
- Anzahl
- Max
- Min

---

## 4. Kata 1: Notenschnitt (20 min)

Kata-Blätter zeigen.

---

## 5. Kata 2: Statistik-Auswertung (25 min)

Kata-Blätter zeigen.

---

## Übersicht aller Funktionen

| Funktion | Erklärung |
|----------|-----------|
| `=SUM(A1:A5)` | Summe |
| `=AVERAGE(A1:A5)` | Durchschnitt / Mittelwert |
| `=COUNT(A1:A5)` | Zählt nur Zahlen |
| `=COUNTA(A1:A5)` | Zählt alle nicht-leeren Zellen |
| `=MIN(A1:A5)` | Kleinster Wert |
| `=MAX(A1:A5)` | Größter Wert |

## Wichtige Shortcuts

| Shortcut | Aktion |
|----------|--------|
| `Alt+=` | AutoSumme |

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Funktion | Vordefiniertes Rechenprogramm |
| `SUM()` | Summe |
| `AVERAGE()` | Durchschnitt |
| `MIN()`, `MAX()` | Kleinster/größter Wert |
| `COUNT()` | Zählt nur Zahlen |
| `COUNTA()` | Zählt alle nicht-leeren Zellen |
| `A1:A5` | Bereich von A1 bis A5 |

### Ausblick

Nächste Woche: **Logische Funktionen** (`IF`, `AND`, `OR`)
