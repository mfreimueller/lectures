# Kata 2: Mengenpreis-Tabelle

## Ziel

Lerne komplexere Tabellen mit verschiedenen Arten von Bezügen:
- Komplett absolut: `$B$3`
- Nur Spalte absolut: `$A6`
- Nur Zeile absolut: `B$2`

## Aufgabenstellung

Erstelle eine Preiskalkulation für verschiedene Mengen mit verschiedenen Rabatt-Stufen.

So soll das Ergebnis aussehen:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | | **Rabatt-Stufen** | | | |
| **2** | | 0% | 3% | 5% | 10% |
| **3** | **Einheitspreis:** | **10** | | | |
| **4** | | | | | |
| **5** | **Menge** | **Preis 0%** | **Preis 3%** | **Preis 5%** | **Preis 10%** |
| **6** | 1 | 10,00 | 9,70 | 9,50 | 9,00 |
| **7** | 10 | 100,00 | 97,00 | 95,00 | 90,00 |
| **8** | 50 | 500,00 | 485,00 | 475,00 | 450,00 |
| **9** | 100 | 1000,00 | 970,00 | 950,00 | 900,00 |
| **10** | 500 | 5000,00 | 4850,00 | 4750,00 | 4500,00 |

Das Ziel: Schreibe NUR EINMAL die Formel in Zelle `B6` und ziehe sie dann runter UND rechts. Excel soll den Rest automatisch machen.

---

### Schritt 1: Tabelle erstellen

Erstelle die Tabelle genau wie oben, aber ohne die berechneten Preise in B6 bis E10.

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | | **Rabatt-Stufen** | | | |
| **2** | | 0% | 3% | 5% | 10% |
| **3** | **Einheitspreis:** | **10** | | | |
| **4** | | | | | |
| **5** | **Menge** | **Preis 0%** | **Preis 3%** | **Preis 5%** | **Preis 10%** |
| **6** | 1 | | | | |
| **7** | 10 | | | | |
| **8** | 50 | | | | |
| **9** | 100 | | | | |
| **10** | 500 | | | | |

---

### Schritt 2: Formel überlegen

Der Preis berechnet sich so:

```
Preis = Einheitspreis × Menge × (1 - Rabatt)
```

Mit unseren Zellen:
- `Einheitspreis` steht in `B3`
- `Menge` steht in Spalte `A` (A6, A7, A8...)
- `Rabatt` steht in Zeile `2` (B2, C2, D2, E2)

Also in Zelle `B6` brauchen wir:
```
Einheitspreis (B3) × Menge (A6) × (1 - Rabatt (B2))
```

Aber Achtung: Wir wollen die Formel später:
1. **Runterziehen** auf B7, B8, B9, B10
2. **Rechtsziehen** auf C6, D6, E6

Was muss also **fest** bleiben und was muss sich **ändern**?

| Bezug | Beim Runterziehen | Beim Rechtsziehen | Soll... |
|-------|-------------------|-------------------|---------|
| Einheitspreis `B3` | `B4` | `C3` | **Fest bleiben!** |
| Menge `A6` | `A7` | `B6` | **Nur Zeile ändern!** |
| Rabatt `B2` | `B3` | `C2` | **Nur Spalte ändern!** |

Also:
- `B3` → `$B$3` (komplett absolut)
- `A6` → `$A6` (nur Spalte A absolut, Zeile ändert sich)
- `B2` → `B$2` (nur Zeile 2 absolut, Spalte ändert sich)

**Die perfekte Formel:**
```excel
=$B$3*$A6*(1-B$2)
```

Wow!

---

### Schritt 3: Formel eingeben

1. Klicke auf Zelle **B6**
2. Schreibe die Formel:
   ```excel
   =$B$3*$A6*(1-B$2)
   ```
   
   Tipp für `$`:
   - Gib `B3` ein, markiere es und drücke `F4` → `$B$3`
   - Gib `A6` ein, markiere es und drücke **3 mal** `F4` → `$A6`
   - Gib `B2` ein, markiere es und drücke **2 mal** `F4` → `B$2`

3. Drücke `Enter`

In B6 sollte jetzt `10` stehen (10 × 1 × (1-0) = 10).

---

### Schritt 4: Runterziehen

1. Klicke auf **B6**
2. Ziehe das kleine Quadrat rechts unten **runter bis B10**

Prüfe die Formeln:
- B6: `=$B$3*$A6*(1-B$2)`
- B7: `=$B$3*$A7*(1-B$2)` ✓
- B8: `=$B$3*$A8*(1-B$2)` ✓
- usw.

`$A6` wird zu `$A7`, `$A8`, etc. (Spalte A bleibt, Zeile ändert sich)
`$B$3` und `B$2` bleiben gleich!

---

### Schritt 5: Rechtsziehen

1. Markiere die Zellen **B6 bis B10** (alle Preise in Spalte B)
2. Ziehe das Quadrat am rechten unteren Rand von **B10 nach rechts bis E10**

Prüfe eine Formel in C7 (Menge 10, Rabatt 3%):
- C7: `=$B$3*$A7*(1-C$2)` ✓

- `$B$3` = Immer noch Einheitspreis
- `$A7` = Immer noch aus Spalte A, jetzt Zeile 7
- `C$2` = Jetzt aus Spalte C, immer noch Zeile 2 (3% Rabatt)

Perfekt!

---

### Schritt 6: Test: Einheitspreis ändern

Der Clou:

Ändere in `B3` den Einheitspreis von `10` auf `20`.

Was passiert? **ALLE** Preise ändern sich automatisch!

---

## Zusammenfassung der verschiedenen Bezugsarten

| Formel | Bedeutung |
|--------|-----------|
| `A1` | Relativ: Alles ändert sich |
| `$A$1` | Absolut: Nichts ändert sich |
| `$A1` | Spalte A bleibt, Zeile ändert sich |
| `A$1` | Zeile 1 bleibt, Spalte ändert sich |

### Beispiel für diese Tabelle

| Bezug | Warum? |
|-------|--------|
| `$B$3` | Einheitspreis steht IMMER in B3 |
| `$A6` | Menge steht IMMER in Spalte A, aber Zeile ändert sich (6, 7, 8...) |
| `B$2` | Rabatt steht IMMER in Zeile 2, aber Spalte ändert sich (B, C, D, E...) |

## Erweiterung (optional)

1. Füge eine weitere Rabatt-Stufe hinzu (z.B. 15%)
2. Ziehe die Formel weiter nach rechts
3. Füge weitere Mengen hinzu
4. Ändere den Einheitspreis und schaue, ob alles aktualisiert wird
5. Füge eine Spalte "Versandkosten" hinzu und integriere sie in die Formel
