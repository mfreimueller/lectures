# Lecture: Woche 14 - Excel Suchen & Referenzieren

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Welche Funktion summiert mit mehreren Bedingungen?" → `SUMIFS()`
2. "Was ist der Unterschied zwischen `SUMIF` und `SUMIFS` in der Parameter-Reihenfolge?" → Bei `SUMIFS` kommt der Summenbereich zuerst
3. "Was bedeutet das Wildcard-Zeichen `*`?" → Beliebig viele Zeichen

---

## 2. Theorie: Suchen-Funktionen (30 min)

### Das Problem

Stell dir vor, du hast diese zwei Tabellen:

**Tabelle 1: Produkt-Preise (Stammdaten)**

| | A | B |
|---|---|---|
| **5** | **Produkt** | **Preis** |
| **6** | Notebook | 1200 |
| **7** | Maus | 25 |
| **8** | Monitor | 350 |

**Tabelle 2: Bestellung**

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Produkt** | **Menge** | **Preis** | **Gesamt** |
| **2** | Notebook | 2 | ? | ? |
| **3** | Maus | 5 | ? | ? |

Frage: Wie bekommst du den Preis von "Notebook" automatisch in Zelle C2?

**Manuell:** Nachschauen → 1200 → eintippen.
**Problem:** Wenn sich der Preis ändert, musst du überall nachkorrigieren.

→ Lösung: **Suchen-Funktionen**

---

## VLOOKUP: Der Klassiker

`VLOOKUP` = Vertical Lookup (vertikale Suche)

```
=VLOOKUP(Suchwert; Matrix; Spaltenindex; Bereich_Verweis)
```

**Parameter:**
1. `Suchwert`: Wonach suchen? (Zelle mit "Notebook")
2. `Matrix`: Gesamter Bereich der Tabelle (A6:B8)
3. `Spaltenindex`: Welche Spalte zurückgeben? (2 = Preis-Spalte)
4. `Bereich_Verweis`: `FALSCH` = genaue Suche, `WAHR` = ungefähr

**Beispiel:**
```excel
=VLOOKUP(A2; A6:B8; 2; FALSCH)
```

Ergebnis: `1200`

---

### Live-Demo VLOOKUP

Erstelle am Beamer:

**Preis-Tabelle (A6:B8):**
```
A6: Produkt  B6: Preis
A7: Notebook B7: 1200
A8: Maus     B8: 25
A9: Monitor  B9: 350
```

**Bestellung (A1:C4):**
```
A1: Produkt  B1: Menge  C1: Preis
A2: Notebook B2: 2      C2: ?
A3: Maus     B3: 5      C3: ?
```

**In C2:**
```excel
=VLOOKUP(A2; A6:B9; 2; FALSCH)
```

**In D2 (Gesamt):**
```excel
=B2*C2
```

Runterziehen.

---

### Probleme mit VLOOKUP

**Problem 1: Suchspalte muss links sein**

Wenn die Tabelle so aussieht:
```
Preis | Produkt
1200  | Notebook
```
→ VLOOKUP funktioniert nicht, weil die Suchspalte (Produkt) nicht mehr die ERSTE Spalte ist.

**Problem 2: Spaltenindex ist fest**

Wenn zwischen Spalte A und B eine neue Spalte eingefügt wird, bleibt der Spaltenindex 2, aber jetzt ist Spalte B leer!

**Problem 3: Rückwärts-Suche schwer**

VLOOKUP kann nicht "suche in Spalte B und gib Spalte A zurück".

---

## XLOOKUP: Die moderne Alternative

`XLOOKUP` ist seit Excel 2021/Office 365 verfügbar und löst alle Probleme von VLOOKUP.

```
=XLOOKUP(Suchwert; Suchbereich; Rückgabebereich; [Wenn_nicht_gefunden]; [Vergleichsmodus])
```

**Parameter:**
1. `Suchwert`: Wonach suchen?
2. `Suchbereich`: Wo suchen? (NUR die Such-Spalte)
3. `Rückgabebereich`: Was zurückgeben? (NUR die Ergebnis-Spalte)
4. `Wenn_nicht_gefunden`: Optional, Text falls nicht gefunden
5. `Vergleichsmodus`: `0` = genaue Suche (Standard)

**Beispiel:**
```excel
=XLOOKUP(A2; A6:A9; B6:B9; "Nicht gefunden")
```

Ergebnis: `1200`

---

### Vorteile von XLOOKUP

| Vorteil | Erklärung |
|---------|-----------|
| Beliebige Position | Suchspalte kann überall sein (links, rechts, in der Mitte) |
| Spaltenunabhängig | Kein Spaltenindex mehr - wenn Spalten eingefügt werden, bleibt es funktionieren |
| Rückwärts-Suche | Kann nach rechts UND nach links suchen |
| Fehlertext direkt | `"Nicht gefunden"` direkt als Parameter |

---

### XLOOKUP vs. VLOOKUP im Vergleich

**VLOOKUP:**
```excel
=VLOOKUP(A2; A6:B9; 2; FALSCH)
```

**XLOOKUP:**
```excel
=XLOOKUP(A2; A6:A9; B6:B9)
```

**XLOOKUP mit Fehlertext:**
```excel
=XLOOKUP(A2; A6:A9; B6:B9; "Produkt nicht gefunden")
```

---

## INDEX + MATCH: Das flexible Duo

Wenn man ältere Excel-Versionen braucht oder maximale Flexibilität will: `INDEX` + `MATCH`.

### MATCH: Findet die Position

```excel
=MATCH(Suchwert; Suchbereich; Vergleichstyp)
```

Gibt die **Nummer der Zeile** zurück, wo der Suchwert gefunden wurde.

**Beispiel:**
```excel
=MATCH("Notebook"; A6:A9; 0)
```
Ergebnis: `1` (weil "Notebook" in der 1. Zeile des Bereichs A6:A9 steht)

---

### INDEX: Holt den Wert an einer Position

```excel
=INDEX(Bereich; Zeile; [Spalte])
```

Gibt den Wert aus einer bestimmten Zeile/Spalte zurück.

**Beispiel:**
```excel
=INDEX(B6:B9; 1)
```
Ergebnis: `1200` (der Wert aus der 1. Zeile von B6:B9)

---

### Kombiniert: INDEX + MATCH

```excel
=INDEX(Rueckgabebereich; MATCH(Suchwert; Suchbereich; 0))
```

**Beispiel:**
```excel
=INDEX(B6:B9; MATCH(A2; A6:A9; 0))
```

So funktioniert es:
1. `MATCH(A2; A6:A9; 0)` → Findet: Zeile 1
2. `INDEX(B6:B9; 1)` → Holt: 1200

Ergebnis: `1200`

---

### Vorteile von INDEX/MATCH

| Vorteil | Erklärung |
|---------|-----------|
| Kompatibel | Funktioniert in ALLEN Excel-Versionen |
| Flexibel | Suchspalte kann überall sein |
| Mächtig | Kann mit horizontalen/vertikalen Bereichen kombiniert werden |
| Stabil | Ändern sich Spalten, bleibt es funktionieren (wenn mit absoluten Bezügen) |

---

## Vergleich aller drei Methoden

| Merkmal | VLOOKUP | XLOOKUP | INDEX/MATCH |
|---------|---------|---------|--------------|
| Einfachheit | Sehr einfach | Einfach | Etwas komplexer |
| Suchspalte links? | Muss sein | Egal | Egal |
| Rückwärts-Suche | Nein | Ja | Ja |
| Fehlertext | Braucht IFERROR | Direkt dabei | Braucht IFERROR |
| Kompatibilität | Alle Versionen | Excel 2021+ | Alle Versionen |

---

## IFERROR: Fehler abfangen

Wenn ein Produkt nicht gefunden wird, bekommt man `#N/A`.

Das kann man mit `IFERROR` abfangen:

```excel
=IFERROR(VLOOKUP(A2; A6:B9; 2; FALSCH); "Produkt nicht gefunden")
```

```excel
=IFERROR(INDEX(B6:B9; MATCH(A2; A6:A9; 0)); "Produkt nicht gefunden")
```

Bei XLOOKUP ist es einfacher - direkt als Parameter:
```excel
=XLOOKUP(A2; A6:A9; B6:B9; "Produkt nicht gefunden")
```

---

## 3. Kata 1: Preissuche mit XLOOKUP (25 min)

Kata-Blätter zeigen.

---

## 4. Kata 2: INDEX/MATCH (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Methode | Syntax | Wann verwenden? |
|---------|--------|-----------------|
| `VLOOKUP` | `=VLOOKUP(Suchwert; Matrix; Spalte; FALSCH)` | Einfache Fälle, Kompatibilität mit alten Excel-Versionen |
| `XLOOKUP` | `=XLOOKUP(Suchwert; Suchbereich; Rückgabebereich)` | Modern, flexibel, Excel 2021+ |
| `INDEX/MATCH` | `=INDEX(Rückgabe; MATCH(Suchwert; Suche; 0))` | Maximale Flexibilität, alle Excel-Versionen |

### Parameter im Detail

| Funktion | Wichtige Parameter |
|----------|-------------------|
| `VLOOKUP` | Letzter Parameter = `FALSCH` für genaue Suche |
| `XLOOKUP` | Suchbereich und Rückgabebereich getrennt |
| `MATCH` | Letzter Parameter = `0` für genaue Suche |

### Ausblick

Nächste Woche: **Text & Datum Funktionen**
