# Kata 2: Produktauswertung mit SUMIFS

## Ziel

Lerne Auswertungen mit MEHREREN Bedingungen mit `SUMIFS` und `COUNTIFS`.

## Der Unterschied

| Funktion | Bedingungen | Reihenfolge |
|----------|-------------|-------------|
| `SUMIF` | 1 Bedingung | `(Bereich; Kriterium; Summenbereich)` |
| `SUMIFS` | Mehrere Bedingungen | `(Summenbereich; Bereich1; Kriterium1; ...)` |

**Wichtig:** Bei `SUMIFS` kommt der Summenbereich zuerst!

---

## Aufgabenstellung

Auswertung mit mehreren Bedingungen.

### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Kategorie** | **Region** | **Mitarbeiter** | **Umsatz** |
| **2** | POS | Nord | Anna | 2400 |
| **3** | DBI | Süd | Ben | 300 |
| **4** | POS | Süd | Anna | 1750 |
| **5** | INF | Ost | Clara | 360 |
| **6** | DBI | West | Ben | 480 |
| **7** | POS | Nord | Clara | 1800 |
| **8** | INF | Süd | Anna | 320 |
| **9** | DBI | Ost | Ben | 225 |
| **10** | POS | West | Clara | 950 |
| **11** | | | | |
| **12** | **Auswertung** | | | |
| **13** | POS Umsatz gesamt | | | |
| **14** | POS Umsatz NUR Nord | | | |
| **15** | POS Umsatz NORD + Anna | | | |
| **16** | | | | |
| **17** | Umsatz > 1000 in POS | | | |
| **18** | Umsatz Anna (alle Kategorien) | | | |

---

### Schritt 2: SUMIF vs. SUMIFS

Zuerst: Einfacher Vergleich mit nur EINER Bedingung.

**Mit SUMIF:**
```excel
=SUMIF(A2:A10; "POS"; D2:D10)
```

**Mit SUMIFS (gleiches Ergebnis):**
```excel
=SUMIFS(D2:D10; A2:A10; "POS")
```

Beide ergeben: 6900

Schreibe eine der Varianten in **B13**.

---

### Schritt 3: Zwei Bedingungen

Jetzt: **POS** UND **Region = Nord**

Mit `SUMIFS` kann man mehrere Bedingungen kombinieren.

```excel
=SUMIFS(Summenbereich; Bereich1; Kriterium1; Bereich2; Kriterium2)
```

**In B14:**
```excel
=SUMIFS(D2:D10; A2:A10; "POS"; B2:B10; "Nord")
```

**Erklärung:**
- `D2:D10` → Was summieren?
- `A2:A10; "POS"` → Bedingung 1: Kategorie = POS
- `B2:B10; "Nord"` → Bedingung 2: Region = Nord

**UND-Verknüpfung:** Beide Bedingungen müssen erfüllt sein!

Welche Zeilen sind das?
- Zeile 2: POS, Nord, Anna → Ja
- Zeile 7: POS, Nord, Clara → Ja
- Ergebnis: 2400 + 1800 = 4200

---

### Schritt 4: Drei Bedingungen

Jetzt: **POS** UND **Nord** UND **Anna**

**In B15:**
```excel
=SUMIFS(D2:D10; A2:A10; "POS"; B2:B10; "Nord"; C2:C10; "Anna")
```

Ergebnis: 2400 (nur Zeile 2)

---

### Schritt 5: Zahlen als Bedingung

Umsätze über 1000 Euro, aber nur in Kategorie POS.

**In B17:**
```excel
=SUMIFS(D2:D10; A2:A10; "POS"; D2:D10; ">1000")
```

Welche POS-Produkte haben Umsatz > 1000?
- 2400 → Ja
- 1750 → Ja
- 1800 → Ja
- 950 → Nein

Ergebnis: 2400 + 1750 + 1800 = 5950

---

### Schritt 6: COUNTIFS

Zählen mit mehreren Bedingungen:

"Wie viele POS-Verkäufe gibt es in Region Nord?"

Gib in eine leere Zelle ein:
```excel
=COUNTIFS(A2:A10; "POS"; B2:B10; "Nord")
```

Ergebnis: 2

---

## Kontrolle

| Auswertung | Formel | Ergebnis |
|------------|--------|----------|
| POS Umsatz gesamt | `=SUMIF(A2:A10; "POS"; D2:D10)` | 6900 |
| POS Umsatz NUR Nord | `=SUMIFS(D2:D10; A2:A10; "POS"; B2:B10; "Nord")` | 4200 |
| POS Umsatz NORD + Anna | `=SUMIFS(D2:D10; A2:A10; "POS"; B2:B10; "Nord"; C2:C10; "Anna")` | 2400 |
| Umsatz > 1000 in POS | `=SUMIFS(D2:D10; A2:A10; "POS"; D2:D10; ">1000")` | 5950 |
| Umsatz Anna (alle) | `=SUMIF(C2:C10; "Anna"; D2:D10)` | 4470 |

---

## Zusammenfassung

| Funktion | Was macht sie? |
|----------|----------------|
| `SUMIF` | Summe mit **EINER** Bedingung |
| `SUMIFS` | Summe mit **MEHREREN** Bedingungen (UND) |
| `COUNTIF` | Zählen mit **EINER** Bedingung |
| `COUNTIFS` | Zählen mit **MEHREREN** Bedingungen (UND) |

**Wichtige Syntax-Unterschiede:**

| Funktion | Parameter-Reihenfolge |
|----------|------------------------|
| `SUMIF` | `(Bereich; Kriterium; Summenbereich)` |
| `SUMIFS` | `(Summenbereich; Bereich1; Krit1; Bereich2; Krit2)` |

Merke:
- `SUMIF` (ein Kriterium): Bereich zuerst
- `SUMIFS` (mehrere Kriterien): Summenbereich zuerst

## Erweiterung (optional)

1. Berechne den Umsatz von Ben in Region Süd:
   - Mitarbeiter = "Ben" UND Region = "Süd"

2. Zähle wie viele Verkäufe von Clara in POS stattfanden:
   - Mitarbeiter = "Clara" UND Kategorie = "POS"

3. Berechne den durchschnittlichen Umsatz von POS-Produkten mit Umsatz > 1000:
   - `=AVERAGEIFS(D2:D10; A2:A10; "POS"; D2:D10; ">1000")`

4. (Schwer) Finde heraus: Gibt es auch `OR` mit SUMIFS?
   - Recherchiere: Wie macht man ODER-Verknüpfungen?
   - Tipp: `=SUMIF(...) + SUMIF(...)`
