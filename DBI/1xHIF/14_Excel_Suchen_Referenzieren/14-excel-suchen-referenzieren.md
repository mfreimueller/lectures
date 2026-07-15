---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 14 - Excel Suchen & Referenzieren
## DBI - 1AHIF

---

## Wiederholung: Bereichsfunktionen

1. Wie lautet die Syntax von SUMIF?
2. Was ist der Unterschied zwischen SUMIF und SUMIFS?
3. Welches Wildcard steht für beliebig viele Zeichen?

---

## Problem: Zwei Tabellen

**Produktliste:**

| Produkt | Preis |
| --- | --- |
| Notebook | 1200 |
| Maus | 25 |
| Monitor | 350 |

**Bestellung:**

| Produkt | Menge | Preis |
| --- | --- | --- |
| Notebook | 2 | ? |
| Maus | 5 | ? |

Wie bekommen wir die Preise automatisch in die Bestellung?

---

## Manuelles Nachschlagen

- In Produktliste nach "Notebook" suchen → Preis 1200
- In Produktliste nach "Maus" suchen → Preis 25
- ... bei 100 Produkten wird das mühsam
- Und fehleranfällig (man vertippt sich leicht)

Lösung: Suchen-Funktionen!

---

## VLOOKUP - Syntax

```plaintext
=VLOOKUP(Suchwert; Matrix; Spaltenindex; Bereich_Verweis)
```

- **Suchwert:** Wonach suchen? (z.B. Produktname)
- **Matrix:** In welchem Bereich suchen?
- **Spaltenindex:** Welche Spalte zurückgeben? (1 = erste Spalte)
- **Bereich_Verweis:** FALSCH = genaue Suche, WAHR = ungefähr

---

## VLOOKUP - Beispiel

```plaintext
=VLOOKUP(A2; A5:B7; 2; FALSCH)
```

- Suche den Wert aus A2 in Spalte A (A5:A7)
- Gib den Wert aus Spalte 2 (Spalte B) zurück
- FALSCH = genaue Übereinstimmung
- Ergebnis: Für "Notebook" → 1200

---

## Nachteile von VLOOKUP

- **Suchspalte muss LINKS sein** - keine Rückwärtssuche
- **Spaltenindex ist fest** - bricht wenn Spalte eingefügt wird
- Nur vertikale Suche (daher der Name)

---

## XLOOKUP - Syntax

```plaintext
=XLOOKUP(Suchwert; Suchbereich; Rückgabebereich; [Wenn_nicht_gefunden])
```

- **Suchwert:** Wonach suchen?
- **Suchbereich:** Nur die Suchspalte
- **Rückgabebereich:** Nur die Ergebnisspalte
- **Wenn_nicht_gefunden:** Text falls nicht gefunden (optional)

---

## XLOOKUP - Beispiel

```plaintext
=XLOOKUP(A2; A5:A7; B5:B7; "Nicht gefunden")
```

- Suche A2 in A5:A7
- Gib passenden Wert aus B5:B7 zurück
- Wenn nicht gefunden: "Nicht gefunden"
- Einfacher und flexibler als VLOOKUP

---

## Vorteile von XLOOKUP

- Suchspalte kann **überall** sein (auch rechts)
- Rückgabespalte ist **frei wählbar**
- Rückwärtssuche möglich
- "Wenn nicht gefunden" direkt eingebaut

---

## INDEX allein

```plaintext
=INDEX(Bereich; Zeile; Spalte)
```

Gibt den Wert an einer bestimmten Position zurück

Beispiel:

```plaintext
=INDEX(B5:B7; 2)
```

Gibt den 2. Wert aus B5:B7 zurück = 25 (Maus-Preis)

---

## MATCH allein

```plaintext
=MATCH(Suchwert; Suchbereich; Vergleichstyp)
```

Gibt die **Position** des Suchwerts zurück (nicht den Wert!)

Beispiel:

```plaintext
=MATCH(A2; A5:A7; 0)
```

Wenn A2 = "Maus", Ergebnis = 2 (Maus ist an 2. Position)

---

## INDEX + MATCH kombiniert

```plaintext
=INDEX(Rückgabebereich; MATCH(Suchwert; Suchbereich; 0))
```

MATCH findet die Position, INDEX gibt den Wert zurück

Beispiel:

```plaintext
=INDEX(B5:B7; MATCH(A2; A5:A7; 0))
```

Suche A2 in A5:A7, gib passenden Wert aus B5:B7

---

## Vorteile von INDEX/MATCH

- Sehr flexibel
- Funktioniert in **allen** Excel-Versionen
- Suchspalte kann überall sein
- Horizontal und vertikal kombinierbar

---

## IFERROR - Fehler abfangen

Wenn ein Wert nicht gefunden wird: #N/A

```plaintext
=IFERROR(VLOOKUP(...); "Nicht gefunden")
=IFERROR(XLOOKUP(...); "Nicht gefunden")
=IFERROR(INDEX/MATCH; "Nicht gefunden")
```

Oder mit XLOOKUP direkt: =XLOOKUP(...; "Nicht gefunden")

---

## Vergleich aller Methoden

| Methode | Einfachheit | Flexibilität | Version |
| --- | --- | --- | --- |
| VLOOKUP | Sehr einfach | Niedrig | Alle |
| XLOOKUP | Einfach | Hoch | Excel 2021+ |
| INDEX/MATCH | Etwas komplex | Sehr hoch | Alle |

---

<div class="highlight-box">
<h3 class="centered">Nächste Woche: Text &amp; Datum Funktionen</h3>
</div>

LEFT, RIGHT, MID, LEN, TEXT, TODAY, DATEDIF
