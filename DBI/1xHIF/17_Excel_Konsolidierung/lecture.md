# Lecture: Woche 17 - Excel Konsolidierung PLÜ-Vorbereitung

---

## 1. Überblick: Alle Excel-Themen (10 min)

Die Excel Phase ist zu Ende. Nächste Woche: **PLÜ-Prüfung**!

Hier wiederholen wir ALLE wichtigen Themen.

---

## 2. Themen-Überblick (20 min)

### Thema 1: Grundlagen & Formeln

| Konzept | Erklärung |
|---------|-----------|
| `=` | Jede Formel fängt mit `=` an |
| `+` `-` `*` `/` | Grundrechenarten |
| `()` | Klammern ändern die Reihenfolge |

**Operatorenrangfolge:**
1. Klammern `()`
2. Potenz `^`
3. Multiplikation `*` und Division `/`
4. Addition `+` und Subtraktion `-`

**Beispiel:**
```excel
=2+3*4   → 14 (nicht 20!)
=(2+3)*4 → 20
```

---

### Thema 2: Bezüge

| Typ | Schreibweise | Was passiert beim Runterziehen? |
|-----|--------------|---------------------------------|
| Relativ | `A1` | Ändert sich: A1 → A2 → A3 |
| Absolut | `$A$1` | Bleibt fest: `$A$1` |
| Gemischt | `$A1` oder `A$1` | Teilweise fest |

**Tipp:** Taste `F4` durchschaltet die Bezugsarten!

**Beispiel:**
```excel
=A2*$B$7
```
- `A2` ändert sich zu A3, A4...
- `$B$7` bleibt immer B7

---

### Thema 3: Grundfunktionen

| Funktion | Erklärung |
|----------|-----------|
| `=SUM(A1:A5)` | Summe aller Werte |
| `=AVERAGE(A1:A5)` | Durchschnitt |
| `=COUNT(A1:A5)` | Zählt nur ZAHLEN |
| `=COUNTA(A1:A5)` | Zählt ALLE nicht-leeren Zellen |
| `=MIN(A1:A5)` | Kleinster Wert |
| `=MAX(A1:A5)` | Größter Wert |

**Wichtiger Unterschied COUNT vs. COUNTA:**
- `COUNT()` → Nur Zahlen
- `COUNTA()` → Alle nicht-leeren Zellen (auch Text)

---

### Thema 4: Logische Funktionen

| Funktion | Erklärung |
|----------|-----------|
| `=IF(Bed; Dann; Sonst)` | Wenn-Dann-Entscheidung |
| `=AND(Bed1; Bed2)` | Beide müssen wahr sein |
| `=OR(Bed1; Bed2)` | Mind. einer muss wahr sein |

**Vergleichsoperatoren:**
- `=` Gleich
- `<>` Ungleich
- `>` Größer
- `<` Kleiner
- `>=` Größer oder gleich
- `<=` Kleiner oder gleich

**Beispiel IF:**
```excel
=IF(A1>=50; "Bestanden"; "Nicht bestanden")
```

**Beispiel IF mit AND:**
```excel
=IF(AND(A1>=50; B1>=50); "Beide bestanden"; "Nicht beide bestanden")
```

---

### Thema 5: Bereichsfunktionen

| Funktion | Erklärung |
|----------|-----------|
| `=SUMIF(Bereich; Krit; Summe)` | Summe mit Bedingung |
| `=COUNTIF(Bereich; Krit)` | Zählen mit Bedingung |
| `=SUMIFS(Summe; Bed1; Krit1; Bed2; Krit2)` | Summe mit mehreren Bedingungen |

**Wichtiger Unterschied SUMIF vs. SUMIFS:**

| Funktion | Reihenfolge |
|----------|-------------|
| `SUMIF` | `(Bereich; Kriterium; Summe)` |
| `SUMIFS` | `(Summe; Bereich1; Krit1; Bereich2; Krit2)` |

**Beispiel:**
```excel
=SUMIF(A2:A10; "POS"; C2:C10)
=SUMIFS(C2:C10; A2:A10; "POS"; B2:B10; ">100")
```

**Kriterien-Formate:**
- `"POS"` → Genau "POS"
- `">100"` → Größer als 100 (mit Anführungszeichen!)
- `"P*"` → Beginnt mit P

---

### Thema 6: Suchen-Funktionen

| Funktion | Erklärung |
|----------|-----------|
| `=VLOOKUP(Suchwert; Matrix; Spalte; FALSCH)` | Klassiker |
| `=XLOOKUP(Suchwert; Suche; Rückgabe)` | Modern |

**VLOOKUP - Wichtig:**
- Suchspalte muss die ERSTE Spalte der Matrix sein
- Letzter Parameter = `FALSCH` für genaue Suche!

```excel
=VLOOKUP(A2; D2:E10; 2; FALSCH)
```

**XLOOKUP - Besser:**
```excel
=XLOOKUP(A2; D2:D10; E2:E10)
```

---

### Thema 7: Text & Datum

| Funktion | Erklärung |
|----------|-----------|
| `=LEFT(Text; N)` | N Zeichen von links |
| `=RIGHT(Text; N)` | N Zeichen von rechts |
| `=MID(Text; Start; N)` | N Zeichen ab Start |
| `=LEN(Text)` | Anzahl der Zeichen |
| `=TODAY()` | Heutiges Datum |
| `=DATEDIF(Start; Ende; "y")` | Jahre zwischen Daten |

---

## 3. Häufige Fehlerquellen (10 min)

### Fehler 1: Falsche Trennzeichen

Falsch:
```excel
=SUM(A1,A2,A3)
```

Richtig:
```excel
=SUM(A1;A2;A3)
```

→ Semikolon `;` ist der Trenner in Excel!

---

### Fehler 2: VLOOKUP ohne FALSCH

Falsch:
```excel
=VLOOKUP(A2; D2:E10; 2)
```

Richtig:
```excel
=VLOOKUP(A2; D2:E10; 2; FALSCH)
```

Ohne `FALSCH` macht VLOOKUP eine ungefähre Suche und liefert falsche Ergebnisse!

---

### Fehler 3: Vergleich ohne Anführungszeichen

Falsch:
```excel
=COUNTIF(A1:A10; >50)
```

Richtig:
```excel
=COUNTIF(A1:A10; ">50")
```

Bei Vergleichsoperatoren braucht es Anführungszeichen!

---

### Fehler 4: Bezüge vergessen

Falsch (beim Runterziehen):
```excel
=SUMIF(A2:A10; "POS"; C2:C10)
```

Richtig:
```excel
=SUMIF($A$2:$A$10; "POS"; $C$2:$C$10)
```

Ohne `$` verschieben sich die Bereiche beim Runterziehen!

---

## 4. PLÜ-Checkliste

Vor der Prüfung:

- [ ] Jede Formel fängt mit `=` an
- [ ] Trennzeichen ist `;` (Semikolon), nicht Komma
- [ ] Bei VLOOKUP: Letzter Parameter = `FALSCH`
- [ ] Bei COUNTIF/SUMIF mit Vergleich: Anführungszeichen um das Kriterium
- [ ] Absolutbezüge mit `$` wenn Bereich fest bleiben soll
- [ ] Bei `IF`: Drei Parameter: `=IF(Bedingung; Dann; Sonst)`
- [ ] `COUNT` zählt nur Zahlen, `COUNTA` zählt alles

---

## 5. Kata 1: Gesamtübung Formeln (25 min)

Kata-Blätter zeigen.

---

## 6. Kata 2: Gesamtübung Funktionen (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

### Die wichtigsten Funktionen

| Kategorie | Funktionen |
|-----------|------------|
| Grundlagen | `SUM`, `AVERAGE`, `MIN`, `MAX`, `COUNT`, `COUNTA` |
| Logik | `IF`, `AND`, `OR` |
| Bereiche | `SUMIF`, `COUNTIF` |
| Suchen | `VLOOKUP`, `XLOOKUP` |

### Die wichtigsten Regeln

1. Formeln beginnen mit `=`
2. Trennzeichen ist `;` (nicht `,`)
3. VLOOKUP braucht `;FALSCH` am Ende
4. Absolutbezüge mit `$`
5. Vergleichsoperatoren in Anführungszeichen: `">50"`

### Erfolg in der PLÜ

- Ruhe bewahren
- Schritt für Schritt arbeiten
- Jede Formel mit Enter abschließen und prüfen
- Bei Fehler: Formel nochmal durchlesen, Zeichen für Zeichen
