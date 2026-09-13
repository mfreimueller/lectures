---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 09 - Excel Bezüge & Funktionen
## DBI - 1AHIF

---

## Agenda (1/3)

1. Kurz-Check: Was ihr schon könnt
2. Blitz-Wiederholung: Formeln & Rechenzeichen
3. Formel runterziehen (Füllfunktion)
4. Problem: Was passiert beim Runterziehen wirklich?
5. Relativer Bezug

---

## Agenda (2/3)

6. Das Problem mit einem fixen Wert
7. Die Lösung: `$` Dollarzeichen
8. Vier Varianten von Bezügen
9. `F4`-Taste
10. Live-Demo: Mengenpreis-Tabelle

---

## Agenda (3/3)

11. Problem: Manuelle Formeln
12. Aufbau einer Funktion
13. Die wichtigsten Grundfunktionen
14. Bereichsnotation & AutoSumme
15. Live-Demo: Noten-Tabelle

---

## Lernziele

- Ich kenne den Unterschied zwischen relativem und absolutem Bezug
- Ich kann `$` bzw. `F4` gezielt einsetzen, damit ein Bezug beim Ziehen fix bleibt
- Ich kann SUM, AVERAGE, MIN, MAX, COUNT und COUNTA anwenden
- Ich kann Funktionen verschachteln und die AutoSumme nutzen

---

## Kurz-Check: Was ihr schon könnt

Aus der Digitalen Grundbildung solltet ihr das schon kennen:

- Zellen, Zeilen, Spalten, Tabellenblätter
- Eine Formel beginnt mit `=`
- Grundrechenarten `+ - * /`
- Werte eintippen, Zellen markieren

**Wenn euch davon etwas fehlt:** meldet euch — heute bauen wir direkt darauf auf.

---

## Blitz-Wiederholung: Formeln & Rechenzeichen

| Was | Zeichen | Beispiel |
|-----|---------|----------|
| Addieren | `+` | `=2+3` |
| Subtrahieren | `-` | `=5-2` |
| Multiplizieren | `*` | `=4*5` |
| Dividieren | `/` | `=10/2` |
| Potenzieren | `^` | `=5^2` |

Punkt-vor-Strich gilt wie in der Mathematik — Klammern `()` erzwingen eine andere Reihenfolge: `=(2+3)*4` = 20, nicht 14.

---

## Formel runterziehen (Füllfunktion)

**Situation:** `=A2*B2` steht in `C2`, soll aber auch für Zeile 3, 4, 5 gelten.

1. Zelle `C2` anklicken
2. Kleines Quadrat unten rechts an der Zelle
3. Klicken und nach unten ziehen

**Excel passt die Formel automatisch an:**
- `C3` → `=A3*B3`
- `C4` → `=A4*B4`
- `C5` → `=A5*B5`

---

## Problem: Was passiert beim Runterziehen wirklich?

Neue Tabelle:

| | A | B | C |
|---|---|---|---|
| **1** | Netto | | Brutto |
| **2** | 100 | | `=A2*(1+B7)` |
| **3** | 200 | | |
| **7** | MWST: | **20%** | |

Der Steuersatz steht **einmal** in `B7` und wird referenziert — besser als ihn in jede Zeile neu zu tippen.

---

## Relativer Bezug

Beim Runterziehen von `=A2*(1+B7)`:

- `C3`: `=A3*(1+B8)` ← **falsch!** `B8` ist leer
- `C4`: `=A4*(1+B9)` ← **falsch!**

**Was ist passiert?**
- `A2` → `A3` → `A4` — das wollen wir (relativer Bezug)
- `B7` → `B8` → `B9` — das wollen wir **nicht**

---

## Das Problem mit einem fixen Wert

Wir brauchen zwei unterschiedliche Verhaltensweisen in **derselben Formel**:

- `A2` soll sich beim Runterziehen anpassen (relativ)
- `B7` soll **immer** `B7` bleiben (fix)

Ein normaler Bezug (`A1`) kann das nicht — beide Teile ändern sich immer gemeinsam.

---

## Die Lösung: `$` Dollarzeichen

Ein `$` vor Spalte oder Zeile verhindert, dass sich genau dieser Teil beim Ziehen ändert.

| Bezug | Beim Runterziehen | Beim Rechtsziehen |
|-------|-------------------|-------------------|
| `A1` | `A2` | `B1` |
| `$A$1` | `$A$1` | `$A$1` |
| `$A1` | `$A2` | `$A1` |
| `A$1` | `A$1` | `B$1` |

**Richtig für unser Beispiel:** `=A2*(1+$B$7)`

---

## Vier Varianten von Bezügen

| Bezug | Bedeutung |
|-------|-----------|
| `A1` | Alles relativ — Zeile und Spalte ändern sich |
| `$A$1` | Alles absolut — nichts ändert sich |
| `$A1` | Spalte fix (A), Zeile relativ |
| `A$1` | Zeile fix (1), Spalte relativ |

---

## `F4`-Taste

Das `$` muss man nicht von Hand tippen: Bezug in der Formel markieren, `F4` drücken.

| `F4` gedrückt | Ergebnis |
|-----------|----------|
| 1× | `$B$7` |
| 2× | `B$7` |
| 3× | `$B7` |
| 4× | `B7` |
| 5× | wieder `$B$7` |

---

## Live-Demo: Mengenpreis-Tabelle

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | | | **Rabatt-Level** | | |
| **2** | | 0% | 5% | 10% | 15% |
| **4** | Menge 1 | | | | |

Einheitspreis in `A9`, Formel in `C4`:

```plaintext
=$A$9*$A4*(1-C$2)
```

`$A$9` komplett fix, `$A4` nur Spalte fix, `C$2` nur Zeile fix — so passt sich beim Runter- **und** Rechtsziehen alles richtig an.

---

## Problem: Manuelle Formeln

```plaintext
=A1+A2+A3+A4+A5
```

- Was, wenn wir 100 Zellen addieren wollen?
- Fehleranfällig — man vergisst leicht eine Zelle
- Unübersichtlich bei großen Bereichen

---

## Aufbau einer Funktion

```plaintext
=Funktionsname(Argument1; Argument2; ...)
```

- `=` wie bei jeder Formel
- Funktionsname, z. B. `SUM`, `AVERAGE`
- Klammern `()` gehören immer dazu
- Argumente: Bereiche, Zellen oder Werte

---

## Die wichtigsten Grundfunktionen

| Funktion | Erklärung |
| --- | --- |
| `=SUM(Bereich)` | Summe aller Werte |
| `=AVERAGE(Bereich)` | Durchschnitt (Mittelwert) |
| `=COUNT(Bereich)` | Zählt nur Zellen mit Zahlen |
| `=COUNTA(Bereich)` | Zählt alle nicht-leeren Zellen |
| `=MIN(Bereich)` | Kleinster Wert |
| `=MAX(Bereich)` | Größter Wert |

---

## Bereichsnotation & AutoSumme

| Schreibweise | Bedeutung |
| --- | --- |
| `A1:A5` | Alle Zellen von A1 bis A5 |
| `B2:D4` | Alle Zellen im Rechteck B2 bis D4 |
| `A1; B3; C5` | Nur diese drei einzelnen Zellen |

**AutoSumme:** Start → Σ (Sigma), Kürzel `Alt +` `=` — Excel schlägt automatisch einen Bereich vor (auch für Durchschnitt, Anzahl, Max, Min).

---

## Live-Demo: Noten-Tabelle

| Student | Test 1 | Test 2 | Test 3 | Summe | Schnitt |
| --- | --- | --- | --- | --- | --- |
| Anna | 85 | 90 | 88 | `=SUM(B2:D2)` | `=AVERAGE(B2:D2)` |
| Ben | 75 | 82 | 78 | | |
| Clara | 92 | 88 | 95 | | |

Verschachtelt: Spannweite = `=MAX(B2:D2) - MIN(B2:D2)`

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Relativer Bezug (`A1`) | Ändert sich beim Ziehen |
| Absoluter Bezug (`$A$1`) | Bleibt immer gleich |
| `F4` | Schaltet durch die vier Bezugsarten |
| `=SUM/AVERAGE/COUNT/COUNTA/MIN/MAX(...)` | Grundfunktionen statt manueller Formeln |
| `A1:A5` | Bereichsnotation |
