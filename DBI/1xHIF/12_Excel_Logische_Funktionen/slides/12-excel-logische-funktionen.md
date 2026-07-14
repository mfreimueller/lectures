---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 12 - Excel Logische Funktionen
## DBI - 1AHIF

---

## Wiederholung: Funktionen

1. Welche Funktion berechnet den Durchschnitt?
2. Was ist der Unterschied zwischen COUNT und COUNTA?
3. Wie berechnet man die Spannweite (Max - Min)?

---

## Vergleichsoperatoren

| Operator | Bedeutung | Beispiel |
| --- | --- | --- |
| = | Gleich | A1=100 |
| <> | Ungleich | A1<>0 |
| > | Größer als | A1>50 |
| < | Kleiner als | A1<50 |
| >= | Größer oder gleich | A1>=90 |
| <= | Kleiner oder gleich | A1<=50 |

---

## Ergebnis ist immer boolean

- Jeder Vergleich liefert **WAHR** oder **FALSCH**
- =A1>50 → WAHR wenn A1 größer als 50 ist
- =A1=100 → WAHR wenn A1 genau 100 ist
- =A1<>0 → WAHR wenn A1 ungleich 0 ist

---

## IF - Einfache Entscheidung

```plaintext
=IF(Bedingung; Wert_wenn_wahr; Wert_wenn_falsch)
```

Beispiel:

```plaintext
=IF(A1>=50; "Bestanden"; "Nicht bestanden")
```

- 1. Parameter: Bedingung (Vergleich)
- 2. Parameter: Ergebnis wenn WAHR
- 3. Parameter: Ergebnis wenn FALSCH

---

## IF - Beispiel

| Punkte | Formel | Ergebnis |
| --- | --- | --- |
| 75 | =IF(A1>=50; "Bestanden"; "Nicht bestanden") | Bestanden |
| 30 | =IF(A1>=50; "Bestanden"; "Nicht bestanden") | Nicht bestanden |
| 50 | =IF(A1>=50; "Bestanden"; "Nicht bestanden") | Bestanden |

---

## Verschachteltes IF

```plaintext
=IF(A1>=90; "Sehr gut"; IF(A1>=80; "Gut";
    IF(A1>=70; "Befriedigend"; "Nicht genügend")))
```

Wichtig: Jedes IF braucht genau 3 Parameter

Bei 3 Bedingungen: 3 Klammern am Ende schließen

---

## IFS - Alternative bei vielen Bedingungen

```plaintext
=IFS(A1>=90; "Sehr gut";
     A1>=80; "Gut";
     A1>=70; "Befriedigend";
     A1>=60; "Genügend";
     WAHR; "Nicht genügend")
```

- Einfacher als verschachteltes IF
- Letzte Bedingung WAHR = sonst-Fall

---

## AND - Alle müssen wahr sein

```plaintext
=AND(A1>50; B1>50; C1>50)
```

- Liefert WAHR, wenn ALLE Bedingungen wahr sind
- Liefert FALSCH, wenn auch nur eine falsch ist

| A1 | B1 | =AND(A1>50; B1>50) |
| --- | --- | --- |
| 60 | 70 | WAHR |
| 60 | 30 | FALSCH |
| 40 | 70 | FALSCH |

---

## OR - Mindestens eine wahr

```plaintext
=OR(A1>90; B1>90; C1>90)
```

- Liefert WAHR, wenn MINDESTENS EINE Bedingung wahr ist
- Liefert FALSCH, wenn alle falsch sind

| A1 | B1 | =OR(A1>90; B1>90) |
| --- | --- | --- |
| 95 | 70 | WAHR |
| 60 | 85 | FALSCH |
| 40 | 95 | WAHR |

---

## NOT - Umkehrung

```plaintext
=NOT(A1>50)
```

- Kehrt das Ergebnis um
- =NOT(A1>50) ist das Gleiche wie A1<=50
- Wird oft mit IF kombiniert: =IF(NOT(A1>50); "Zu wenig"; "OK")

---

## AND vs. OR - Wann verwenden?

- **AND:** Wenn ALLE Bedingungen erfüllt sein müssen
- "Beide Tests bestanden", "Alle Felder ausgefüllt"
- **OR:** Wenn MINDESTENS EINE Bedingung reicht
- "Mindestens ein Test bestanden", "Eines der Kriterien erfüllt"

---

## IF + AND kombinieren

```plaintext
=IF(AND(A1>=50; B1>=50);
    "Beide bestanden";
    "Nicht beide bestanden")
```

Nur wenn beide Tests >= 50 sind, gibt es "Beide bestanden"

---

## IF + OR kombinieren

```plaintext
=IF(OR(A1>=90; B1>=90);
    "Mindestens eine Eins";
    "Keine Eins")
```

Wenn mindestens einer der Tests >= 90 ist, gibt es "Mindestens eine Eins"

---

## Typische Fehler

- **Semikolon vergessen:** =IF(A1>50 "OK") → Fehler
- **Falsche Klammern:** =IF(A1>50;"OK" → Fehler
- **Falsche Bedingung:** =IF(A1=50) statt =IF(A1>=50)
- **Text ohne Anführungszeichen:** =IF(A1>50; OK) → Fehler

---

## Übersicht Logische Funktionen

| Funktion | Erklärung |
| --- | --- |
| =IF(Bedingung; Dann; Sonst) | Wenn-Dann-Entscheidung |
| =IFS(Bed1; Dann1; Bed2; Dann2; ...) | Mehrere Bedingungen |
| =AND(Bed1; Bed2; ...) | Alle Bedingungen müssen wahr sein |
| =OR(Bed1; Bed2; ...) | Mindestens eine Bedingung muss wahr sein |
| =NOT(Bedingung) | Bedingung umkehren |

---

<div class="highlight-box">
<h3 class="centered">Nächste Woche: Bereichsfunktionen</h3>
</div>

SUMIF, COUNTIF, AVERAGEIF, SUMIFS
