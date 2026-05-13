# Woche 09 - Excel: Grundlagen & Formeln

**Index:** 09
**Woche im Jahr:** 18 (nach Weihnachtsferien)
**Dauer:** 2h

---

## Lernziele dieser Woche

- Excel-Interface wiederholen: Zellen, Zeilen, Spalten, Blätter
- Formeln schreiben: Mit `=` starten
- Grundrechenarten: `+`, `-`, `*`, `/`
- Operatorenrangfolge: Punkt vor Strich
- Zellbezüge: `=A1`, `=B2+C2`
- Formel runterziehen: Automatische Anpassung
- Füllfunktion

---

## Katas dieser Woche

| # | Titel | Konzepte | Dauer |
|---|-------|----------|-------|
| 1 | Preisberechnung Netto/Brutto | Formeln, Multiplikation, Division, Prozentrechnung | ca. 20 min |
| 2 | Rechenregeln & Operatorenrangfolge | Punkt vor Strich, Klammern, komplexere Formeln | ca. 20 min |

---

## Wichtige Konzepte

### Grundrechenarten in Excel

| Rechenart | Zeichen | Beispiel |
|-----------|---------|----------|
| Addition | `+` | `=A1+B1` |
| Subtraktion | `-` | `=A1-B1` |
| Multiplikation | `*` | `=A1*B1` |
| Division | `/` | `=A1/B1` |
| Potenz | `^` | `=A1^2` (Quadrat) |

### Wichtig: Jede Formel fängt mit `=` an!

| ✅ Richtig | ❌ Falsch |
|-----------|-----------|
| `=A1+B1` | `A1+B1` |
| `=5*3` | `5*3` |

### Operatorenrangfolge

Wie in der Mathematik: **Punkt vor Strich**

| Rangfolge | Operator |
|-----------|----------|
| 1 | `()` Klammern |
| 2 | `^` Potenz |
| 3 | `*` `/` Multiplikation, Division |
| 4 | `+` `-` Addition, Subtraktion |

**Beispiele:**
- `=2+3*4` = 14 (nicht 20!)
- `=(2+3)*4` = 20 (wegen Klammern)
- `=10/2+3` = 8
- `=10/(2+3)` = 2

### Formel runterziehen

Der "kleine Quadrat" am rechten unteren Rand der Zelle:

1. Schreibe Formel in eine Zelle
2. Klicke die Zelle an
3. Ziehe das kleine Quadrat am rechten unteren Rand nach unten/rechts
4. Excel passt die Zellbezüge automatisch an!

### Speichern

- `Strg+S`
- Immer speichern, bevor man Excel schließt!

---

## Unterrichtsaufbau

| Phase | Dauer | Inhalt |
|-------|-------|--------|
| Wiederholung Word & Einstieg Excel | 15 min | Rückfragen, Excel-Interface wiederholen |
| Theorie: Formeln & Grundrechenarten | 25 min | =-Zeichen, +-*/, Beispiele |
| Theorie: Operatorenrangfolge & Füllen | 20 min | Punkt vor Strich, Klammern, runterziehen |
| Kata 1 | 20 min | Preisberechnung |
| Kata 2 | 20 min | Rechenregeln |

---

## Ausblick nächste Woche

**Woche 10:** Bezüge (relativ vs. absolut mit `$`).
