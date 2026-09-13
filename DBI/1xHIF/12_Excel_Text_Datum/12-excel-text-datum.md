---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 12 - Excel Text & Datum Funktionen
## DBI - 1AHIF

---

## Agenda (1/2)

1. =LEFT() - Zeichen von links
2. =RIGHT() - Zeichen von rechts
3. =MID() - Zeichen ab Position
4. =LEN() - Textlänge
5. =TEXT() - Formatieren
6. Text zusammenfügen

---

## Agenda (2/2)

7. =TODAY() und =NOW()
8. =YEAR(), =MONTH(), =DAY()
9. =DATEDIF() - Datumsdifferenz
10. DATEDIF-Einheiten
11. Datum-Arithmetik
12. Live-Demo: Altersberechnung

---

## Lernziele

- Ich kann Texte mit LEFT, RIGHT und MID extrahieren
- Ich kann die Textlänge mit LEN ermitteln und Texte verketten
- Ich kann Werte mit TEXT() formatieren
- Ich kann Datumsbestandteile mit YEAR, MONTH, DAY extrahieren
- Ich kann Datumsdifferenzen mit DATEDIF berechnen

---

## Wiederholung: Suchen-Funktionen

1. Was sind die Nachteile von VLOOKUP?
2. Welche Vorteile bietet XLOOKUP?
3. Aus welchen zwei Teilen besteht INDEX/MATCH?

---

## =LEFT() - Zeichen von links

```plaintext
=LEFT(Text; Anzahl)
```

Gibt die ersten N Zeichen eines Textes zurück

Beispiel:

```plaintext
=LEFT("Hallo"; 2) → "Ha"
=LEFT("Excel"; 3) → "Exc"
```

---

## =RIGHT() - Zeichen von rechts

```plaintext
=RIGHT(Text; Anzahl)
```

Gibt die letzten N Zeichen eines Textes zurück

Beispiel:

```plaintext
=RIGHT("Hallo"; 2) → "lo"
=RIGHT("Excel"; 3) → "cel"
```

---

## =MID() - Zeichen ab Position

```plaintext
=MID(Text; Start; Anzahl)
```

Gibt N Zeichen ab einer bestimmten Position zurück

Beispiel:

```plaintext
=MID("Hallo"; 2; 3) → "all"
=MID("Excel"; 3; 2) → "ce"
```

---

## =LEN() - Textlänge

```plaintext
=LEN(Text)
```

Gibt die Anzahl der Zeichen zurück

Beispiel:

```plaintext
=LEN("Hallo") → 5
=LEN("")      → 0
=LEN("Excel ist toll") → 14
```

---

## =TEXT() - Formatieren

```plaintext
=TEXT(Wert; Format)
```

Formatiert einen Wert als Text

Beispiel:

```plaintext
=TEXT(1234.5; "#.##0,00") → "1.234,50"
=TEXT(A1; "TT.MM.JJJJ")   → "12.05.2026"
```

---

## Text zusammenfügen

Mit & (Kaufmanns-Und):

```plaintext
=A2 & " " & B2
```

Wenn A2 = "Max" und B2 = "Mustermann":

Ergebnis: "Max Mustermann"

Mit TEXTJOIN (Excel 2019+):

```plaintext
=TEXTJOIN(", "; WAHR; A2:A5)
```

---

## =TODAY() und =NOW()

```plaintext
=TODAY()
```

Gibt das heutige Datum zurück (aktualisiert sich täglich)

```plaintext
=NOW()
```

Gibt Datum + Uhrzeit zurück (aktualisiert sich bei jeder Änderung)

---

## =YEAR(), =MONTH(), =DAY()

```plaintext
=YEAR(A1)  → 2026
=MONTH(A1) → 5
=DAY(A1)   → 12
```

Extrahiert einzelne Bestandteile aus einem Datum

---

## =DATEDIF() - Datumsdifferenz

```plaintext
=DATEDIF(Start; Ende; "Einheit")
```

Berechnet die Differenz zwischen zwei Daten

Beispiel:

```plaintext
=DATEDIF(A1; TODAY(); "y")  → Alter in Jahren
```

---

## DATEDIF-Einheiten

| Einheit | Bedeutung |
| --- | --- |
| "y" | Volle Jahre |
| "m" | Volle Monate |
| "d" | Volle Tage |
| "ym" | Monate (Jahre ignoriert) |
| "yd" | Tage (Jahre ignoriert) |
| "md" | Tage (Jahre und Monate ignoriert) |

---

## Datum-Arithmetik

| Operation | Ergebnis |
| --- | --- |
| =A1 + 7 | 7 Tage später |
| =A1 - 7 | 7 Tage früher |
| =B1 - A1 | Differenz in Tagen |

Excel speichert Daten intern als Zahlen (Tage seit 01.01.1900)

---

## Live-Demo: Altersberechnung

```plaintext
=DATEDIF(A1; TODAY(); "y")
```

Geburtsdatum in A1 = 01.01.2010

Heute = 12.05.2026

Ergebnis: 16 (Jahre)

---

## Zusammenfassung (1/2)

| Funktion | Beschreibung |
| --- | --- |
| =LEFT(Text; N) | N Zeichen von links |
| =RIGHT(Text; N) | N Zeichen von rechts |
| =MID(Text; Start; N) | N Zeichen ab Position |
| =LEN(Text) | Anzahl Zeichen |
| =TEXT(Wert; Format) | Wert als Text formatieren |
| =A1 & " " & B1 | Text zusammenfügen |

---

## Zusammenfassung (2/2)

| Funktion | Beschreibung |
| --- | --- |
| =TODAY() | Heutiges Datum |
| =NOW() | Datum + Uhrzeit |
| =YEAR(Datum) | Jahr extrahieren |
| =MONTH(Datum) | Monat extrahieren |
| =DAY(Datum) | Tag extrahieren |
| =DATEDIF(S; E; "E") | Differenz zwischen Daten |
