---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 11 - Excel Funktionen Grundlagen
## DBI - 1AHIF

---

## Wiederholung: Bezüge

1. Was bedeutet $B$7?
2. Welche Taste schaltet die Bezugsarten durch?
3. Was passiert beim Runterziehen von =A2*B7 ohne $-Zeichen?

---

## Problem: Manuelle Formeln

```plaintext
=A1+A2+A3+A4+A5
```

- Was, wenn wir 100 Zellen addieren wollen?
- Fehleranfällig: Kann leicht eine Zelle vergessen
- Unübersichtlich bei großen Bereichen

---

## Lösung: Funktionen

| Manuell | Mit Funktion |
| --- | --- |
| =A1+A2+A3+A4+A5 | =SUM(A1:A5) |
| =(A1+A2+A3+A4+A5)/5 | =AVERAGE(A1:A5) |

- **Kürzer:** Weniger schreiben
- **Übersichtlicher:** Leichter zu verstehen
- **Weniger fehleranfällig**

---

## Aufbau einer Funktion

```plaintext
=Funktionsname(Argument1; Argument2; ...)
```

- = wie bei jeder Formel
- Funktionsname z.B. SUM, AVERAGE
- Klammern () gehören immer dazu!
- Argumente: Bereiche, Zellen oder Werte

---

## Die wichtigsten Grundfunktionen

| Funktion | Erklärung |
| --- | --- |
| =SUM(Bereich) | Summe aller Werte |
| =AVERAGE(Bereich) | Durchschnitt (Mittelwert) |
| =COUNT(Bereich) | Zählt nur Zellen mit Zahlen |
| =COUNTA(Bereich) | Zählt alle nicht-leeren Zellen |
| =MIN(Bereich) | Kleinster Wert |
| =MAX(Bereich) | Größter Wert |

---

## Bereichsnotation

| Schreibweise | Bedeutung |
| --- | --- |
| A1:A5 | Alle Zellen von A1 bis A5 |
| B2:D4 | Alle Zellen im Rechteck B2 bis D4 |
| A1; B3; C5 | Nur diese drei einzelnen Zellen |
| A1:A5; C1:C5 | Beide Bereiche |

---

## Bereiche mit der Maus markieren

1. Schreibe =SUM(
2. Markiere den Bereich mit der Maus
3. Excel trägt den Bereich automatisch ein
4. Klammer schließen und Enter

---

## =SUM() - Summe

```plaintext
=SUM(A1:A5)
```

Addiert alle Zahlen im Bereich A1 bis A5

Statt: =A1+A2+A3+A4+A5

---

## =AVERAGE() - Durchschnitt

```plaintext
=AVERAGE(A1:A5)
```

Berechnet den arithmetischen Mittelwert

Statt: =(A1+A2+A3+A4+A5)/5

---

## =MIN() und =MAX()

```plaintext
=MIN(A1:A5)   // Kleinster Wert
=MAX(A1:A5)   // Größter Wert
```

Spannweite: =MAX(A1:A5) - MIN(A1:A5)

---

## =COUNT() vs =COUNTA()

| Funktion | Zählt... |
| --- | --- |
| =COUNT() | Nur Zellen mit ZAHLEN |
| =COUNTA() | Alle nicht-leeren Zellen (auch Text!) |

Beispiel: =COUNT(A1:A5) bei Werten 100, 200, Hallo, 300, (leer) = 3

=COUNTA(A1:A5) bei denselben Werten = 4

---

## Funktionen verschachteln

```plaintext
=MAX(A1:A5) - MIN(A1:A5)   // Spannweite
```

```plaintext
=AVERAGE(B2:D2) * 2        // Verdoppelter Schnitt
```

---

## AutoSumme-Button

- Start > AutoSumme (Sigma-Zeichen)
- Oder: Formeln > AutoSumme
- Kürzel: Alt + =
- Excel schlägt automatisch einen Bereich vor

---

## AutoSumme-Optionen

- Summe
- Durchschnitt
- Anzahl
- Maximum
- Minimum

---

## Live-Demo: Noten-Tabelle

| Student | Test 1 | Test 2 | Test 3 | Summe | Schnitt |
| --- | --- | --- | --- | --- | --- |
| Anna | 85 | 90 | 88 | =SUM(B2:D2) | =AVERAGE(B2:D2) |
| Ben | 75 | 82 | 78 |  |  |
| Clara | 92 | 88 | 95 |  |  |

---

## Zusammenfassung

| Funktion | Erklärung |
| --- | --- |
| =SUM(A1:A5) | Summe |
| =AVERAGE(A1:A5) | Durchschnitt |
| =COUNT(A1:A5) | Zählt nur Zahlen |
| =COUNTA(A1:A5) | Zählt alle nicht-leeren Zellen |
| =MIN(A1:A5) | Kleinster Wert |
| =MAX(A1:A5) | Größter Wert |

---

<div class="highlight-box">
<h3 class="centered">Nächste Woche: Logische Funktionen</h3>
</div>

IF, AND, OR, NOT
