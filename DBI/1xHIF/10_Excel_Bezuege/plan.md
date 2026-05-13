# Woche 10 - Excel: Bezüge (Relativ vs. Absolut)

**Index:** 10
**Woche im Jahr:** 19
**Dauer:** 2h

---

## Bisher gelernte Inhalte

| Index | Thema | Konzepte |
|-------|-------|----------|
| 09 | Excel Grundlagen | Formeln mit `=`, `+` `-` `*` `/`, runterziehen |

---

## Lernziele dieser Woche

- Unterschied: Relativer vs. absoluter Bezug
- Wann brauche ich `$` (Dollarzeichen)?
- `$A$1` (komplett absolut) vs. `$A1` (Spalte absolut, Zeile relativ) vs. `A$1` (Zeile absolut, Spalte relativ)
- `F4`-Taste zum Durchschalten der verschiedenen Bezugsarten
- Praktische Anwendung: Fester Steuerfaktor, Rabatt, etc.

---

## Katas dieser Woche

| # | Titel | Konzepte | Dauer |
|---|-------|----------|-------|
| 1 | Steuerfaktor mit $ | Absoluter Bezug auf einen festen Prozentsatz | ca. 20 min |
| 2 | Mengenpreis-Tabelle | Kombination aus relativen und absoluten Bezügen | ca. 25 min |

---

## Wichtige Konzepte

### Was passiert beim Runterziehen?

Standardmäßig (ohne `$`) ist der Bezug **relativ**.

| In Zelle | Nach runterziehen auf A2 |
|----------|---------------------------|
| `=A1` | `=A2` (Zeile ändert sich) |
| `=B1` | `=B2` |

Nach rechtsziehen:
| In Zelle | Nach rechtsziehen auf B1 |
|----------|---------------------------|
| `=A1` | `=B1` (Spalte ändert sich) |

### Absoluter Bezug mit `$`

Wenn du etwas **NICHT** ändern lassen willst, setze ein `$` davor.

| Bezug | Bedeutung |
|-------|-----------|
| `A1` | Relativ: Alles ändert sich |
| `$A$1` | Absolut: Nichts ändert sich |
| `$A1` | Spalte A ist fix, Zeile ändert sich |
| `A$1` | Zeile 1 ist fix, Spalte ändert sich |

### `F4`-Taste

Markiere in der Formel den Bezug (z.B. `A1`) und drücke `F4`:

| Drücke F4 | Ergebnis |
|-----------|----------|
| 1. Mal | `$A$1` |
| 2. Mal | `A$1` |
| 3. Mal | `$A1` |
| 4. Mal | `A1` |

---

## Unterrichtsaufbau

| Phase | Dauer | Inhalt |
|-------|-------|--------|
| Wiederholung | 10 min | Formeln, runterziehen, Quick-Quiz |
| Theorie: Relativ vs. Absolut | 30 min | Was passiert beim Runterziehen? `$` Erklärung, `F4` |
| Live-Demo | 15 min | Beispiel: Steuerfaktor in Zelle B7 |
| Kata 1 | 20 min | Steuerfaktor-Übung |
| Kata 2 | 25 min | Mengenpreis-Tabelle |

---

## Praktisches Beispiel

**Situation:**
- Steuerfaktor ist immer 20%
- Er steht in Zelle `B7`
- Alle Preise sollen mit diesem Faktor berechnet werden

| | A | B |
|---|---|---|
| **1** | Preis Netto | Preis Brutto |
| **2** | 100 | `=A2*B7` |
| **3** | 200 | |
| **4** | 300 | |
| **5** | | |
| **6** | | |
| **7** | Steuer: | 20% |

**Problem:**
Wenn ich `=A2*B7` auf A3 runterziehe, wird daraus `=A3*B8`!
Aber B8 ist leer!

**Lösung:**
`=A2*$B$7`

Jetzt bleibt `B7` beim Runterziehen immer `B7`.

---

## Ausblick nächste Woche

**Woche 11:** Funktionen: `SUM`, `AVERAGE`, `COUNT`, `MIN`, `MAX`.
