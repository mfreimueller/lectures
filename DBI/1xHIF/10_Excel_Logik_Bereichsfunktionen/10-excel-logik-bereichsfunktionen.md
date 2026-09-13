---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 10 - Excel Logische & Bereichsfunktionen
## DBI - 1AHIF

---

## Agenda (1/3)

1. Vergleichsoperatoren
2. Ergebnis ist immer boolean
3. IF - Einfache Entscheidung
4. Verschachteltes IF
5. IFS - Alternative bei vielen Bedingungen

---

## Agenda (2/3)

6. AND, OR, NOT
7. IF + AND / IF + OR kombinieren
8. Typische Fehler
9. Problem: Bedingte Summe
10. SUMIF, COUNTIF, AVERAGEIF

---

## Agenda (3/3)

11. Kriterien-Formate & Wildcards
12. SUMIFS - Mehrere Bedingungen
13. COUNTIFS

---

## Lernziele

- Ich kann Entscheidungen mit IF und IFS treffen und IF verschachteln
- Ich kann AND, OR und NOT zur Verknüpfung von Bedingungen nutzen
- Ich kann Summen, Durchschnitte und Anzahlen mit einer oder mehreren Bedingungen berechnen (SUMIF/S, AVERAGEIF, COUNTIF/S)
- Ich kenne den Unterschied in der Argumentreihenfolge zwischen SUMIF und SUMIFS

---

## Wiederholung: Bezüge & Funktionen

1. Was bedeutet `$B$7`? Welche Taste schaltet die Bezugsarten durch?
2. Welche Funktion berechnet den Durchschnitt eines Bereichs?
3. Was ist der Unterschied zwischen `COUNT` und `COUNTA`?

---

## Vergleichsoperatoren

| Operator | Bedeutung | Beispiel |
| --- | --- | --- |
| `=` | Gleich | `A1=100` |
| `<>` | Ungleich | `A1<>0` |
| `>` | Größer als | `A1>50` |
| `<` | Kleiner als | `A1<50` |
| `>=` | Größer oder gleich | `A1>=90` |
| `<=` | Kleiner oder gleich | `A1<=50` |

---

## Ergebnis ist immer boolean

- Jeder Vergleich liefert **WAHR** oder **FALSCH**
- `=A1>50` → WAHR, wenn A1 größer als 50 ist
- `=A1=100` → WAHR, wenn A1 genau 100 ist
- `=A1<>0` → WAHR, wenn A1 ungleich 0 ist

---

## IF - Einfache Entscheidung

```plaintext
=IF(Bedingung; Wert_wenn_wahr; Wert_wenn_falsch)
```

Beispiel:

```plaintext
=IF(A1>=50; "Bestanden"; "Nicht bestanden")
```

- 1. Parameter: Bedingung
- 2. Parameter: Ergebnis wenn WAHR
- 3. Parameter: Ergebnis wenn FALSCH

---

## Verschachteltes IF

```plaintext
=IF(A1>=90; "Sehr gut"; IF(A1>=80; "Gut";
    IF(A1>=70; "Befriedigend"; "Nicht genügend")))
```

Wichtig: Jedes IF braucht genau 3 Parameter — bei 3 Bedingungen also 3 Klammern am Ende schließen.

---

## IFS - Alternative bei vielen Bedingungen

```plaintext
=IFS(A1>=90; "Sehr gut";
     A1>=80; "Gut";
     A1>=70; "Befriedigend";
     A1>=60; "Genügend";
     WAHR; "Nicht genügend")
```

Einfacher als verschachteltes IF — letzte Bedingung `WAHR` = sonst-Fall.

---

## AND, OR, NOT

| Funktion | Bedeutung |
| --- | --- |
| `=AND(A1>50; B1>50)` | WAHR nur wenn **alle** Bedingungen wahr sind |
| `=OR(A1>90; B1>90)` | WAHR wenn **mindestens eine** Bedingung wahr ist |
| `=NOT(A1>50)` | Kehrt das Ergebnis um — gleich wie `A1<=50` |

**Faustregel:** AND = "alle müssen", OR = "einer reicht".

---

## IF + AND / IF + OR kombinieren

```plaintext
=IF(AND(A1>=50; B1>=50); "Beide bestanden"; "Nicht beide bestanden")
```

```plaintext
=IF(OR(A1>=90; B1>=90); "Mindestens eine Eins"; "Keine Eins")
```

---

## Typische Fehler

- **Semikolon vergessen:** `=IF(A1>50 "OK")` → Fehler
- **Falsche Klammern:** `=IF(A1>50;"OK"` → Fehler
- **Text ohne Anführungszeichen:** `=IF(A1>50; OK)` → Fehler

---

## Problem: Bedingte Summe

„Summiere nur die Verkäufe aus der Kategorie POS"

| Kategorie | Betrag |
| --- | --- |
| POS | 1200 |
| DBI | 800 |
| POS | 950 |

Manuell: `=B2+B4` → mühsam bei vielen Zeilen

---

## SUMIF, COUNTIF, AVERAGEIF

| Normal | Bedingt |
| --- | --- |
| `=SUM(A2:A10)` | `=SUMIF(Bereich; Kriterium; Summenbereich)` |
| `=COUNT(A2:A10)` | `=COUNTIF(Bereich; Kriterium)` |
| `=AVERAGE(A2:A10)` | `=AVERAGEIF(Bereich; Kriterium; Mittelbereich)` |

Beispiel: `=SUMIF(A2:A10; "POS"; B2:B10)` → summiert nur Zeilen mit Kategorie "POS"

---

## Kriterien-Formate & Wildcards

| Kriterium | Bedeutung |
| --- | --- |
| `"POS"` | Genau "POS" |
| `">50"` | Größer als 50 |
| `"<>0"` | Ungleich 0 |
| `"P*"` | Beginnt mit P (`*` = beliebig viele Zeichen) |
| `"*POS*"` | Enthält "POS" an beliebiger Stelle |

---

## SUMIFS - Mehrere Bedingungen

```plaintext
=SUMIFS(Summenbereich; Bereich1; Kriterium1; Bereich2; Kriterium2)
```

**Wichtig:** Bei `SUMIFS` kommt der Summenbereich **zuerst** — anders als bei `SUMIF`, wo er optional am Ende steht.

```plaintext
=SUMIFS(C2:C10; A2:A10; "POS"; B2:B10; ">50")
```

---

## COUNTIFS

```plaintext
=COUNTIFS(Bereich1; Kriterium1; Bereich2; Kriterium2)
```

Zählt Zeilen, die **alle** Bedingungen erfüllen:

```plaintext
=COUNTIFS(A2:A10; "POS"; B2:B10; ">50")
```

---

## Zusammenfassung

| Funktion | Erklärung |
| --- | --- |
| `=IF(Bedingung; Dann; Sonst)` | Wenn-Dann-Entscheidung |
| `=IFS(...)` / `=AND(...)` / `=OR(...)` / `=NOT(...)` | Mehrere bzw. verknüpfte Bedingungen |
| `=SUMIF/COUNTIF/AVERAGEIF(B; K; ...)` | Aggregation mit 1 Bedingung |
| `=SUMIFS/COUNTIFS(...)` | Aggregation mit mehreren Bedingungen |
