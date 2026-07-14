---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 13 - Excel Bereichsfunktionen
## DBI - 1AHIF

---

## Wiederholung: Logische Funktionen

1. Wie lautet die Syntax von IF?
2. Was ist der Unterschied zwischen AND und OR?
3. Wozu verwendet man IFS?

---

## Problem: Bedingte Summe

"Summiere nur die Verkäufe aus der Kategorie POS"

| Kategorie | Betrag |
| --- | --- |
| POS | 1200 |
| DBI | 800 |
| POS | 950 |
| NWT | 500 |

Manuell: =B2+B4 → mühsam bei vielen Zeilen

---

## Lösung: Bereichsfunktionen

| Normal | Bedingt | Macht... |
| --- | --- | --- |
| =SUM() | =SUMIF() | Summe mit Bedingung |
| =COUNT() | =COUNTIF() | Zählen mit Bedingung |
| =AVERAGE() | =AVERAGEIF() | Durchschnitt mit Bedingung |

---

## SUMIF - Syntax

```plaintext
=SUMIF(Bereich; Kriterium; Summenbereich)
```

- **Bereich:** Wo wird die Bedingung geprüft?
- **Kriterium:** Was muss gelten? (z.B. "POS", >50)
- **Summenbereich:** Was soll summiert werden? (optional)

---

## SUMIF - Beispiel

```plaintext
=SUMIF(A2:A10; "POS"; B2:B10)
```

- Prüft in A2:A10, ob der Wert "POS" ist
- Summiert die passenden Werte aus B2:B10
- Ergebnis: 1200 + 950 = 2150

---

## COUNTIF

```plaintext
=COUNTIF(Bereich; Kriterium)
```

Zählt, wie oft das Kriterium im Bereich vorkommt

Beispiel:

```plaintext
=COUNTIF(A2:A10; "POS")
```

Zählt, wie oft "POS" in A2:A10 vorkommt = 2

---

## AVERAGEIF

```plaintext
=AVERAGEIF(Bereich; Kriterium; Durchschnittsbereich)
```

Beispiel:

```plaintext
=AVERAGEIF(A2:A10; "POS"; B2:B10)
```

Durchschnitt der POS-Beträge: (1200 + 950) / 2 = 1075

---

## Vergleich: Normal vs. Bedingt

| Normal | Bedingt |
| --- | --- |
| =SUM(A2:A10) | =SUMIF(A2:A10; "POS"; B2:B10) |
| =COUNT(A2:A10) | =COUNTIF(A2:A10; "POS") |
| =AVERAGE(A2:A10) | =AVERAGEIF(A2:A10; "POS"; B2:B10) |

---

## Kriterien-Formate

| Kriterium | Bedeutung |
| --- | --- |
| "POS" | Genau "POS" |
| ">50" | Größer als 50 |
| "<100" | Kleiner als 100 |
| ">=90" | Größer oder gleich 90 |
| "<>0" | Ungleich 0 |

---

## Wildcards in Kriterien

| Kriterium | Bedeutung |
| --- | --- |
| "P*" | Beginnt mit P (* = beliebig viele Zeichen) |
| "?OS" | Genau 3 Zeichen (? = genau 1 Zeichen) |
| "*POS*" | Enthält "POS" an beliebiger Stelle |

---

## SUMIFS - Mehrere Bedingungen

```plaintext
=SUMIFS(Summenbereich; Bereich1; Kriterium1; Bereich2; Kriterium2)
```

**Wichtig:** Bei SUMIFS kommt der Summenbereich **zuerst**!

Im Gegensatz zu SUMIF, wo der Summenbereich optional am Ende steht

---

## SUMIFS - Beispiel

```plaintext
=SUMIFS(C2:C10; A2:A10; "POS"; B2:B10; ">50")
```

- Summiere C2:C10
- Nur wo A2:A10 = "POS" **UND**
- Nur wo B2:B10 > 50

---

## COUNTIFS

```plaintext
=COUNTIFS(Bereich1; Kriterium1; Bereich2; Kriterium2)
```

Zählt Zeilen, die ALLE Bedingungen erfüllen

Beispiel:

```plaintext
=COUNTIFS(A2:A10; "POS"; B2:B10; ">50")
```

Zählt Zeilen wo Kategorie = "POS" UND Betrag > 50

---

## Übersicht Bereichsfunktionen

| Funktion | Beschreibung |
| --- | --- |
| =SUMIF(B; K; [S]) | Summe mit 1 Bedingung |
| =COUNTIF(B; K) | Zählen mit 1 Bedingung |
| =AVERAGEIF(B; K; [M]) | Durchschnitt mit 1 Bedingung |
| =SUMIFS(S; B1; K1; B2; K2) | Summe mit mehreren Bedingungen |
| =COUNTIFS(B1; K1; B2; K2) | Zählen mit mehreren Bedingungen |

---

<div class="highlight-box">
<h3 class="centered">Nächste Woche: Suchen &amp; Referenzieren</h3>
</div>

VLOOKUP, XLOOKUP, INDEX/MATCH
