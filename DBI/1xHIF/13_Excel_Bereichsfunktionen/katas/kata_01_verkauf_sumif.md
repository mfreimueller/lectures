# Kata 1: Verkaufsauswertung mit SUMIF

## Ziel

Lerne Daten nach Kriterien auszuwerten mit `SUMIF`, `COUNTIF`, und `AVERAGEIF`.

## Das Problem

`SUM()` summiert ALLE Werte.
`COUNT()` zählt ALLE Werte.

Aber was wenn ich nur bestimmte Werte will?
→ **Nur** Umsatz von Kategorie "POS"
→ **Nur** Produkte mit Umsatz > 1000

---

## Aufgabenstellung

Erstelle eine Verkaufs-Tabelle und werte sie nach Kategorien aus.

### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Kategorie** | **Produkt** | **Stück** | **Umsatz** |
| **2** | POS | Notebook A7 | 3 | 2400 |
| **3** | DBI | Maus Pro | 12 | 300 |
| **4** | POS | Monitor 24" | 5 | 1750 |
| **5** | INF | Tastatur RGB | 8 | 360 |
| **6** | DBI | Headset 7.1 | 6 | 480 |
| **7** | POS | Notebook B5 | 2 | 1800 |
| **8** | INF | Webcam HD | 4 | 320 |
| **9** | DBI | Maus Basic | 15 | 225 |
| **10** | | | | |
| **11** | **Auswertung** | | | |
| **12** | Umsatz POS gesamt | | | |
| **13** | Umsatz DBI gesamt | | | |
| **14** | Umsatz INF gesamt | | | |
| **15** | | | | |
| **16** | Anzahl POS-Produkte | | | |
| **17** | Anzahl DBI-Produkte | | | |
| **18** | | | | |
| **19** | Durchschnittsumsatz POS | | | |
| **20** | Produkte > 1000 Umsatz | | | |

---

### Schritt 2: SUMIF kennenlernen

`SUMIF` = Summe mit Bedingung.

```excel
=SUMIF(Wo_pruefen; Was_muss_gelten; Was_summieren)
```

**Beispiel:**

```excel
=SUMIF(A2:A9; "POS"; D2:D9)
```

Bedeutung:
- `A2:A9` → Wo soll ich prüfen? (Kategorie-Spalte)
- `"POS"` → Was muss dort stehen?
- `D2:D9` → Was soll summiert werden? (Umsatz)

**In Zelle B12 schreiben:**
```excel
=SUMIF(A2:A9; "POS"; D2:D9)
```

Ergebnis: 2400 + 1750 + 1800 = 5950

---

### Schritt 3: Weitere SUMIF

**In B13 (Umsatz DBI):**
```excel
=SUMIF(A2:A9; "DBI"; D2:D9)
```

**In B14 (Umsatz INF):**
```excel
=SUMIF(A2:A9; "INF"; D2:D9)
```

---

### Schritt 4: COUNTIF - Zählen mit Bedingung

`COUNTIF` ist einfacher als `SUMIF` - es braucht keinen Summenbereich weil es nur zählt.

```excel
=COUNTIF(Wo_pruefen; Was_muss_gelten)
```

**In B16 (Anzahl POS-Produkte):**
```excel
=COUNTIF(A2:A9; "POS")
```

**In B17 (Anzahl DBI-Produkte):**
```excel
=COUNTIF(A2:A9; "DBI")
```

---

### Schritt 5: AVERAGEIF - Durchschnitt mit Bedingung

Genau wie `SUMIF`:

```excel
=AVERAGEIF(Wo_pruefen; Was_muss_gelten; Durchschnittsbereich)
```

**In B19 (Durchschnittsumsatz POS):**
```excel
=AVERAGEIF(A2:A9; "POS"; D2:D9)
```

Ergebnis: 5950 / 3 = 1983,33

---

### Schritt 6: Mit Zahlen vergleichen

Man kann auch nach "größer als" oder "kleiner als" suchen.

**Wichtig:** Vergleichsoperatoren brauchen Anführungszeichen!

**In B20 (Produkte mit Umsatz > 1000):**
```excel
=COUNTIF(D2:D9; ">1000")
```

Probier auch:
- `">=1000"`
- `"<500"`
- `"<=300"`

---

### Schritt 7: Wildcards - Muster suchen

Man kann auch nach Teilen eines Textes suchen:

| Wildcard | Bedeutung |
|----------|-----------|
| `*` | Beliebig viele Zeichen (auch 0) |
| `?` | Genau ein Zeichen |

**Versuche:**

"Zähle alle Produkte die mit 'Notebook' anfangen"
```excel
=COUNTIF(B2:B9; "Notebook*")
```

"Zähle alle Produkte die 'Maus' enthalten"
```excel
=COUNTIF(B2:B9; "*Maus*")
```

---

## Kontrolle

Deine Auswertung sollte ergeben:

| Auswertung | Ergebnis |
|------------|----------|
| Umsatz POS gesamt | 5950 |
| Umsatz DBI gesamt | 1005 |
| Umsatz INF gesamt | 680 |
| Anzahl POS-Produkte | 3 |
| Anzahl DBI-Produkte | 3 |
| Durchschnittsumsatz POS | 1983,33 |
| Produkte > 1000 | 3 |
| Produkte mit "Maus" | 2 |

---

## Zusammenfassung

| Funktion | Was macht sie? |
|----------|----------------|
| `SUMIF` | Summe mit EINER Bedingung |
| `COUNTIF` | Zählen mit EINER Bedingung |
| `AVERAGEIF` | Durchschnitt mit EINER Bedingung |

| Kriterium | Bedeutung |
|-----------|-----------|
| `"POS"` | Genau "POS" |
| `">1000"` | Größer als 1000 (mit Anführungszeichen!) |
| `"P*"` | Beginnt mit P |
| `"*Maus*"` | Enthält "Maus" |

## Erweiterung (optional)

1. Zähle wie viele Produkte genau 5 Zeichen lang sind (Tipp: `"?????"`)

2. Berechne den Gesamtwert aller Produkte, aber nur wenn die Stückzahl > 5 ist
   - Hinweis: `=SUMIF(C2:C9; ">5"; D2:D9)`

3. Füge weitere Produkte zur Tabelle hinzu und prüfe, ob die Auswertung automatisch aktualisiert wird
