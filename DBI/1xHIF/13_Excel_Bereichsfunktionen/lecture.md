# Lecture: Woche 13 - Excel Bereichsfunktionen

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] Excel offen

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Was macht `=IF(A1>=50; "Ja"; "Nein")`?" → Gibt "Ja" zurück wenn A1 >= 50, sonst "Nein"
2. "Was ist der Unterschied zwischen `AND()` und `OR()`?" → `AND()` braucht alle Bedingungen wahr, `OR()` reicht eine
3. "Welche Funktion ist einfacher als verschachteltes IF?" → `IFS()`

---

## 2. Theorie: Bereichsfunktionen (30 min)

### Das Problem

Nehmen wir an, wir haben diese Verkaufs-Tabelle:

| | A | B | C |
|---|---|---|---|
| **1** | Kategorie | Produkt | Umsatz |
| **2** | POS | Notebook | 1200 |
| **3** | DBI | Maus | 25 |
| **4** | POS | Monitor | 350 |
| **5** | INF | Tastatur | 45 |
| **6** | DBI | Headset | 80 |

Fragen:
- Wie viel Umsatz hat die Kategorie "POS" insgesamt?
- Wie viele Produkte gibt es in "DBI"?
- Was ist der Durchschnittsumsatz von "POS"?

**Mit `SUM()` allein geht das nicht!**

→ Wir brauchen **bedingte Bereichsfunktionen**.

---

### SUMIF: Summe mit Bedingung

```
=SUMIF(Bereich; Kriterium; Summenbereich)
```

**Was bedeutet das?**
- `Bereich`: Wo soll geprüft werden? (Spalte A: Kategorie)
- `Kriterium`: Was muss gelten? ("POS")
- `Summenbereich`: Was soll summiert werden? (Spalte C: Umsatz)

**Beispiel:**

```excel
=SUMIF(A2:A6; "POS"; C2:C6)
```

Ergebnis: `1200 + 350 = 1550`

---

### Live-Demo: SUMIF

Erstelle am Beamer:

| | A | B | C |
|---|---|---|---|
| **1** | Kategorie | Produkt | Umsatz |
| **2** | POS | Notebook | 1200 |
| **3** | DBI | Maus | 25 |
| **4** | POS | Monitor | 350 |
| **5** | INF | Tastatur | 45 |
| **6** | DBI | Headset | 80 |

**Gesamter Umsatz POS:**
```excel
=SUMIF(A2:A6; "POS"; C2:C6)
```
→ 1550

**Gesamter Umsatz DBI:**
```excel
=SUMIF(A2:A6; "DBI"; C2:C6)
```
→ 105

---

### COUNTIF: Zählen mit Bedingung

```
=COUNTIF(Bereich; Kriterium)
```

Zählt, wie oft das Kriterium vorkommt.

**Beispiel:**
```excel
=COUNTIF(A2:A6; "POS")
```
Ergebnis: `2` (Notebook und Monitor sind POS)

**Noch ein Beispiel:**
```excel
=COUNTIF(C2:C6; ">100")
```
Ergebnis: `2` (1200 und 350 sind > 100)

---

### AVERAGEIF: Durchschnitt mit Bedingung

```
=AVERAGEIF(Bereich; Kriterium; Durchschnittsbereich)
```

**Beispiel:**
```excel
=AVERAGEIF(A2:A6; "POS"; C2:C6)
```
Ergebnis: `(1200 + 350) / 2 = 775`

---

### Alle drei im Überblick

| Funktion | Was macht sie? |
|----------|----------------|
| `SUMIF` | Summe aller Werte, die Bedingung erfüllen |
| `COUNTIF` | Anzahl aller Werte, die Bedingung erfüllen |
| `AVERAGEIF` | Durchschnitt aller Werte, die Bedingung erfüllen |

---

### Syntax im Detail

**SUMIF:**
```excel
=SUMIF(Wo_pruefen; Was_ muss_gelten; Was_summieren)
=SUMIF(A2:A6; "POS"; C2:C6)
```

**COUNTIF (einfacher, weil es nur zählt):**
```excel
=COUNTIF(Wo_pruefen; Was_muss_gelten)
=COUNTIF(A2:A6; "POS")
```

**Wichtig:** Der Summenbereich ist bei COUNTIF nicht nötig weil es nur zählt, nicht summiert.

---

### Kriterien-Formate

| Kriterium | Bedeutung |
|-----------|-----------|
| `"POS"` | Genau "POS" |
| `">100"` | Größer als 100 |
| `"<50"` | Kleiner als 50 |
| `">=90"` | Größer oder gleich 90 |
| `"<=1000"` | Kleiner oder gleich 1000 |
| `"<>0"` | Ungleich 0 |

**Wichtig:** Bei Vergleichsoperatoren müssen die Anführungszeichen sein!

Richtig:
```excel
=COUNTIF(C2:C6; ">100")
```

Falsch:
```excel
=COUNTIF(C2:C6; >100)
```

---

### Wildcards: `*` und `?`

Man kann auch nach Mustern suchen:

| Wildcard | Bedeutung |
|----------|-----------|
| `*` | Beliebig viele Zeichen (auch 0) |
| `?` | Genau ein Zeichen |

**Beispiele:**

| Kriterium | Was findet es? |
|-----------|----------------|
| `"P*"` | Alles was mit P anfängt: "POS", "Projekt", etc. |
| `"*T"` | Alles was mit T aufhört: "INF", "Arbeit", etc. |
| `"?OS"` | Genau 3 Zeichen, letzte 2 = OS: "POS", "INF" |
| `"*HIF*"` | Alles was HIF enthält: "1xHIF", "2xHIF", etc. |

**Beispiel:**
```excel
=COUNTIF(A2:A6; "P*")
```
→ Zählt alle Einträge die mit "P" anfangen.

---

### SUMIFS: Mehrere Bedingungen

Was wenn wir **sowohl** Kategorie = "POS" **UND** Umsatz > 500 wollen?

→ `SUMIFS()` (mit S am Ende)

**Syntax:**
```excel
=SUMIFS(Summenbereich; Bereich1; Kriterium1; Bereich2; Kriterium2; ...)
```

**Wichtig:** Bei `SUMIFS` kommt der Summenbereich zuerst!

**Beispiel:**

"Summe von Umsatz, wo Kategorie = POS UND Umsatz > 500"

```excel
=SUMIFS(C2:C6; A2:A6; "POS"; C2:C6; ">500")
```

Ergebnis: `1200` (nur Notebook, Monitor ist nur 350)

---

### COUNTIFS: Zählen mit mehreren Bedingungen

```excel
=COUNTIFS(Bereich1; Kriterium1; Bereich2; Kriterium2; ...)
```

**Beispiel:**

"Wie viele POS-Produkte haben Umsatz > 100?"

```excel
=COUNTIFS(A2:A6; "POS"; C2:C6; ">100")
```
Ergebnis: `2`

---

### Wichtiger Unterschied: SUMIF vs. SUMIFS

| Funktion | Reihenfolge der Parameter |
|----------|---------------------------|
| `SUMIF` | `Bereich; Kriterium; Summenbereich` |
| `SUMIFS` | `Summenbereich; Bereich1; Kriterium1; ...` |

**Merke:**
- `SUMIF` (ein Kriterium): Bereich zuerst
- `SUMIFS` (mehrere Kriterien): Summenbereich zuerst

---

## 3. Kata 1: Verkaufsauswertung (25 min)

Kata-Blätter zeigen.

---

## 4. Kata 2: Produktauswertung (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Funktion | Was macht sie? | Parameter |
|----------|----------------|-----------|
| `SUMIF` | Summe mit EINER Bedingung | `(Bereich; Krit; [Summe])` |
| `COUNTIF` | Zählen mit EINER Bedingung | `(Bereich; Krit)` |
| `AVERAGEIF` | Durchschnitt mit EINER Bedingung | `(Bereich; Krit; [Bereich])` |
| `SUMIFS` | Summe mit MEHREREN Bedingungen | `(Summe; Bed1; Krit1; ...)` |
| `COUNTIFS` | Zählen mit MEHREREN Bedingungen | `(Bed1; Krit1; Bed2; Krit2; ...)` |

### Kriterien

| Format | Bedeutung |
|--------|-----------|
| `"Text"` | Genauer Text |
| `">100"` | Vergleich (mit Anführungszeichen!) |
| `"P*"` | Beginnt mit P |
| `"?OS"` | Genau 3 Zeichen |

### Ausblick

Nächste Woche: **Suchen & Referenzieren** (`VLOOKUP`, `XLOOKUP`)
