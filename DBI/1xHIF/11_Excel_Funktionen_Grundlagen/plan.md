# Woche 11 - Excel: Funktionen Grundlagen (SUM, AVERAGE, COUNT, MIN, MAX)

**Index:** 11
**Woche im Jahr:** 20
**Dauer:** 2h

---

## Bisher gelernte Inhalte

| Index | Thema | Konzepte |
|-------|-------|----------|
| 09 | Grundlagen | Formeln mit `=`, `+` `-` `*` `/` |
| 10 | Bezüge | Relativ vs. Absolut, `$`, `F4` |

---

## Lernziele dieser Woche

- Was sind Funktionen in Excel?
- `=SUM()`: Summe bilden
- `=AVERAGE()`: Durchschnitt berechnen
- `=COUNT()`: Zellen zählen (nur Zahlen!)
- `=COUNTA()`: Zellen zählen (auch Text!)
- `=MIN()`: Kleinster Wert
- `=MAX()`: Größter Wert
- Bereichsnotation: `A1:A5` statt `A1+A2+A3+A4+A5`
- Funktionen verschachteln: `=MAX(A1:A5) - MIN(A1:A5)` (Spannweite)

---

## Katas dieser Woche

| # | Titel | Konzepte | Dauer |
|---|-------|----------|-------|
| 1 | Notenschnitt berechnen | `SUM`, `AVERAGE`, `MIN`, `MAX` | ca. 20 min |
| 2 | Statistik-Auswertung | `COUNT`, `COUNTA`, verschachtelte Funktionen | ca. 25 min |

---

## Wichtige Funktionen

| Funktion | Erklärung | Beispiel |
|----------|-----------|----------|
| `=SUM(Bereich)` | Summe aller Werte im Bereich | `=SUM(A1:A5)` |
| `=AVERAGE(Bereich)` | Durchschnitt aller Werte | `=AVERAGE(A1:A5)` |
| `=COUNT(Bereich)` | Zählt nur Zellen mit Zahlen | `=COUNT(A1:A5)` |
| `=COUNTA(Bereich)` | Zählt alle nicht-leeren Zellen | `=COUNTA(A1:A5)` |
| `=MIN(Bereich)` | Kleinster Wert | `=MIN(A1:A5)` |
| `=MAX(Bereich)` | Größter Wert | `=MAX(A1:A5)` |

## Bereichsnotation

| Schreibweise | Bedeutung |
|---------------|-----------|
| `A1:A5` | Alle Zellen von A1 bis A5 |
| `B2:D4` | Alle Zellen im Rechteck B2 bis D4 |
| `A1, B3, C5` | Nur diese drei einzelnen Zellen |
| `A1:A5, C1:C5` | Beide Bereiche (A1:A5 UND C1:C5) |

**Vergleich:**
- Ohne Bereich: `=A1+A2+A3+A4+A5`
- Mit Bereich: `=SUM(A1:A5)`

Viel kürzer und übersichtlicher!

---

## Unterrichtsaufbau

| Phase | Dauer | Inhalt |
|-------|-------|--------|
| Wiederholung | 10 min | Bezüge, Quick-Quiz |
| Theorie: Funktionen | 30 min | Was sind Funktionen? `SUM`, `AVERAGE`, `COUNT`, `MIN`, `MAX` |
| Live-Demo | 15 min | Noten-Tabelle auswerten |
| Kata 1 | 20 min | Notenschnitt |
| Kata 2 | 25 min | Statistik-Auswertung |

---

## Ausblick nächste Woche

**Woche 12:** Logische Funktionen: `IF`, `IFS`, `AND`, `OR`, `NOT`.
