# Kata 2: Gesamtübung Funktionen (IF, SUMIF, VLOOKUP)

## Ziel

Wiederhole die wichtigsten Funktionen für die PLÜ.

## Checkliste

- [ ] `IF(Bedingung; Dann; Sonst)`
- [ ] `COUNTIF(Bereich; Kriterium)`
- [ ] `SUMIF(Bereich; Kriterium; Summenbereich)`
- [ ] `VLOOKUP(Suchwert; Matrix; Spalte; FALSCH)`

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

Erstelle drei Tabellen-Bereiche:

**Bereich 1: Noten-Tabelle (A1:D9)**

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Schüler** | **Punkte** | **Note** | **Bestanden** |
| **2** | Anna | 88 | | |
| **3** | Ben | 65 | | |
| **4** | Clara | 45 | | |
| **5** | David | 92 | | |
| **6** | Eva | 52 | | |
| **7** | Felix | 28 | | |
| **8** | Greta | 77 | | |

**Bereich 2: Notenschlüssel (F1:G7)**

| | F | G |
|---|---|---|
| **1** | **Von** | **Note** |
| **2** | 88 | 1 |
| **3** | 75 | 2 |
| **4** | 63 | 3 |
| **5** | 50 | 4 |
| **6** | 0 | 5 |

**Bereich 3: Auswertung (I1:J6)**

| | I | J |
|---|---|---|
| **1** | **Auswertung** | **Wert** |
| **2** | Schüler bestanden | |
| **3** | Schüler nicht bestanden | |
| **4** | Durchschnitt Punkte | |
| **5** | Beste Note | |
| **6** | Schlechteste Note | |

---

### Schritt 2: Note berechnen

Es gibt mehrere Möglichkeiten:

**Möglichkeit A: Mit `IF` (verschachtelt)**

```excel
=IF(B2>=88; 1; IF(B2>=75; 2; IF(B2>=63; 3; IF(B2>=50; 4; 5))))
```

**Möglichkeit B: Mit `VLOOKUP` (ungefähre Suche)**

Für Notenschlüssel mit "Von-Punkten" verwendet man `WAHR` (ungefähre Suche):

```excel
=VLOOKUP(B2; $F$2:$G$6; 2; WAHR)
```

**Wichtig:**
- `FALSCH` = genaue Suche (z.B. bei Namen)
- `WAHR` = ungefähre Suche (z.B. bei Notenschlüsseln)

Entscheide dich für eine Variante und schreibe sie in **C2**. Ziehe runter bis C8.

---

### Schritt 3: Bestanden? mit `IF`

**In D2:**
```excel
=IF(B2>=50; "Ja"; "Nein")
```

Ziehe runter bis D8.

---

### Schritt 4: Auswertung mit `COUNTIF`

**Schüler bestanden (J2):**
Zähle alle "Ja" in Spalte D:
```excel
=COUNTIF(D2:D8; "Ja")
```

**Schüler nicht bestanden (J3):**
```excel
=COUNTIF(D2:D8; "Nein")
```

---

### Schritt 5: Statistik-Funktionen

**Durchschnitt Punkte (J4):**
```excel
=AVERAGE(B2:B8)
```

**Beste Note (J5):**
Die beste Note ist die **kleinste** Zahl (1 ist besser als 5):
```excel
=MIN(C2:C8)
```

**Schlechteste Note (J6):**
Die schlechteste Note ist die **größte** Zahl:
```excel
=MAX(C2:C8)
```

---

### Kontrolle

Deine Noten-Tabelle sollte so aussehen:

| Schüler | Punkte | Note | Bestanden |
|---------|--------|------|-----------|
| Anna | 88 | 1 | Ja |
| Ben | 65 | 3 | Ja |
| Clara | 45 | 5 | Nein |
| David | 92 | 1 | Ja |
| Eva | 52 | 4 | Ja |
| Felix | 28 | 5 | Nein |
| Greta | 77 | 2 | Ja |

Deine Auswertung sollte so aussehen:

| Auswertung | Wert |
|------------|------|
| Schüler bestanden | 5 |
| Schüler nicht bestanden | 2 |
| Durchschnitt Punkte | 63,86 |
| Beste Note | 1 |
| Schlechteste Note | 5 |

---

## PLÜ-Check: Die wichtigsten Funktionen

| Funktion | Syntax | Beispiel |
|----------|--------|----------|
| `IF` | `=IF(Bed; Dann; Sonst)` | `=IF(A1>=50; "Ja"; "Nein")` |
| `COUNTIF` | `=COUNTIF(Bereich; Krit)` | `=COUNTIF(A1:A10; "Ja")` |
| `SUMIF` | `=SUMIF(Bereich; Krit; Summe)` | `=SUMIF(A1:A10; "POS"; B1:B10)` |
| `VLOOKUP` (genau) | `=VLOOKUP(Wert; Matrix; Spalte; FALSCH)` | `=VLOOKUP(A1; D1:E10; 2; FALSCH)` |
| `VLOOKUP` (ungefähr) | `=VLOOKUP(Wert; Matrix; Spalte; WAHR)` | `=VLOOKUP(A1; D1:E10; 2; WAHR)` |

## Wichtige Regeln

1. **Immer `=` am Anfang**
2. **Trennzeichen ist `;`** (nicht `,`)
3. **Absolutbezüge mit `$`** wenn Bereich fest bleiben soll
4. **VLOOKUP genaue Suche: `FALSCH`**
5. **Vergleiche in Anführungszeichen:** `">50"`

---

## Erweiterung (optional)

1. Füge weitere Schüler zur Tabelle hinzu

2. Berechne die **Gesamtpunktzahl aller bestandenen Schüler**:
   - Tipp: `=SUMIF(D2:D8; "Ja"; B2:B8)`

3. Berechne den **Durchschnitt der bestandenen Schüler**:
   - Tipp: `=AVERAGEIF(D2:D8; "Ja"; B2:B8)`

4. Zähle, **wie viele Schüler die Note 1 haben**:
   - Tipp: `=COUNTIF(C2:C8; 1)`

5. (Schwer) Erstelle eine neue Auswertung:
   - Durchschnitt der Note 1-Schüler
   - Durchschnitt der Note 5-Schüler
