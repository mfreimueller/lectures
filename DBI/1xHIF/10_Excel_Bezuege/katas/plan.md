# Katas - Woche 10: Excel Bezüge

---

## Kata 1: Steuerfaktor mit $

| Feld | Wert |
|------|------|
| Konzepte | Absoluter Bezug `$B$7`, F4-Taste, runterziehen |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine Tabelle mit festem Steuerfaktor in einer extra Zelle.

#### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Artikel** | **Netto** | **MWST 20%** | **Brutto** |
| **2** | Laptop | 899 | | |
| **3** | Maus | 25 | | |
| **4** | Tastatur | 45 | | |
| **5** | Monitor | 299 | | |
| **6** | | | | |
| **7** | **Steuerfaktor:** | **1.2** | | |

Der Steuerfaktor steht in Zelle `B7`: `1.2` (das ist 100% + 20% MWST = 120%).

#### Schritt 2: Formel mit Bezug auf den Steuerfaktor

In Zelle `D2` soll die Formel hin, die Netto × Steuerfaktor berechnet.

**Versuch 1 (falsch!):**
```excel
=B2*1.2
```
→ Das funktioniert, aber der Faktor ist "hart codiert". Wenn du ihn später von 20% auf 10% ändern willst, musst du jede Formel ändern!

**Versuch 2 (auch falsch!):**
```excel
=B2*B7
```
→ Wenn du runterziehst, wird aus `B7` → `B8` → `B9`... und die sind leer!

**Versuch 3 (RICHTIG!):**
```excel
=B2*$B$7
```
→ Die `$`-Zeichen machen den Bezug auf `B7` absolut. Er bleibt beim Runterziehen immer `B7`!

#### So geht es Schritt für Schritt:

1. Klicke auf Zelle `D2`
2. Schreibe: `=B2*`
3. Klicke auf Zelle `B7`
4. Drücke die Taste **`F4`** (dadurch wird `B7` zu `$B$7`)
5. Drücke `Enter`

Oder schreibe von Hand: `=B2*$B$7`

#### Schritt 3: Runterziehen

1. Klicke auf `D2`
2. Ziehe das kleine Quadrat rechts unten runter bis `D5`

Jetzt prüfe die Formeln:
- D2: `=B2*$B$7`
- D3: `=B3*$B$7` ✓
- D4: `=B4*$B$7` ✓
- D5: `=B5*$B$7` ✓

Perfekt! `B7` ist immer noch `B7`!

#### Schritt 4: MWST in Spalte C

In C2 soll nur die Steuer (also die 20%) berechnet werden:

1. Klicke auf `C2`
2. Schreibe: `=B2*($B$7-1)`
   - Oder: `=B2*0.2`
   - Oder: `=D2-B2`

3. Runterziehen

#### Schritt 5: Test: Faktor ändern

Der Clou: Ändere den Steuerfaktor in `B7` von `1.2` auf `1.1` (also nur 10% MWST).

Was passiert?
- Alle berechneten Werte in C und D ändern sich automatisch!

Das ist der Vorteil von Referenzen!

---

## Kata 2: Mengenpreis-Tabelle

| Feld | Wert |
|------|------|
| Konzepte | Kombination relativer und absoluter Bezüge, $ nur vor Spalte ODER nur vor Zeile |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle eine Preiskalkulation für verschiedene Mengen mit verschiedenen Rabatt-Stufen.

#### Schritt 1: Tabelle erstellen

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | | **Rabatt-Stufen** | | | | |
| **2** | | 0% | 3% | 5% | 10% | |
| **3** | **Einheitspreis:** | **10** | | | | |
| **4** | | | | | | |
| **5** | **Menge** | **Preis 0%** | **Preis 3%** | **Preis 5%** | **Preis 10%** |
| **6** | 1 | | | | |
| **7** | 10 | | | | |
| **8** | 50 | | | | |
| **9** | 100 | | | | |
| **10** | 500 | | | | |

#### Schritt 2: Formel überlegen

Der Preis für eine Zelle berechnet sich so:
```
Einheitspreis × Menge × (1 - Rabatt)
```

Oder mit den Zellen:
```
$B$3 × $A6 × (1 - B$2)
```

Erklärung:
- `$B$3` = Einheitspreis steht IMMER in B3 → komplett absolut mit `$B$3`
- `$A6` = Menge steht IMMER in Spalte A, aber die Zeile ändert sich (6, 7, 8...) → nur Spalte absolut mit `$A`
- `B$2` = Rabatt steht IMMER in Zeile 2, aber die Spalte ändert sich (B, C, D, E...) → nur Zeile absolut mit `$2`

Also die Formel für Zelle `B6`:
```excel
=$B$3*$A6*(1-B$2)
```

#### Schritt 3: Formel eingeben und ausfüllen

1. Klicke auf Zelle `B6`
2. Schreibe die Formel: `=$B$3*$A6*(1-B$2)`
   - Tipp: Benutze `F4` um die `$` zu setzen
3. Drücke `Enter`

4. Zuerst **runterziehen** bis B10

5. Dann markiere B6 bis B10 und **ziehe nach rechts** bis E10

#### Schritt 4: Prüfe die Formeln

Klicke auf verschiedene Zellen und schau in der Formelleiste:

- **B6:** `=$B$3*$A6*(1-B$2)`
- **C6:** `=$B$3*$A6*(1-C$2)` → Spalte C hat sich geändert (wegen `B$2`, nur Zeile 2 ist absolut)
- **B7:** `=$B$3*$A7*(1-B$2)` → Zeile 7 hat sich geändert (wegen `$A6`, nur Spalte A ist absolut)
- **D9:** `=$B$3*$A9*(1-D$2)` → Passt!

#### Schritt 5: Test: Einheitspreis ändern

Ändere in `B3` den Einheitspreis von `10` auf `20`.

Was passiert? → Alle Preise ändern sich automatisch!

---

### Zusammenfassung der verschiedenen `$`

| Formel | Was bleibt fest? | Was ändert sich? |
|--------|------------------|------------------|
| `$B$3` | Alles (Spalte B und Zeile 3) | Nichts |
| `$A6` | Spalte A | Zeile (6, 7, 8...) |
| `B$2` | Zeile 2 | Spalte (B, C, D...) |
| `A1` | Nichts | Alles |

### Tipp: F4-Taste

Markiere einen Bezug in der Formel und drücke `F4`:

| F4 drücken | Ergebnis |
|-------------|----------|
| 1. Mal | `$A$1` |
| 2. Mal | `A$1` |
| 3. Mal | `$A1` |
| 4. Mal | `A1` |
