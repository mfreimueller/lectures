# Lecture: Woche 10 - Excel Bezüge (Relativ vs. Absolut)

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Womit fängt eine Formel an?" → `=`
2. "Zeichen für Multiplikation?" → `*`
3. "Was macht das kleine Quadrat rechts unten?" → Formel runterziehen

---

## 2. Theorie: Relativ vs. Absolut (30 min)

### Was passiert beim Runterziehen?

**Live-Demo:**

Tabelle erstellen:

| | A | B |
|---|---|---|
| **1** | Zahl | Mal 2 |
| **2** | 5 | `=A2*2` |
| **3** | 10 | |
| **4** | 15 | |

Formel in B2: `=A2*2`

Ziehe runter nach B3 und B4.

**Was passiert?**
- B2: `=A2*2`
- B3: `=A3*2`
- B4: `=A4*2`

Excel hat `A2` zu `A3` zu `A4` geändert.
Das ist ein **relativer Bezug**.

---

### Jetzt ein Problem

Neue Tabelle:

| | A | B | C |
|---|---|---|---|
| **1** | Netto | Faktor 20% | Brutto |
| **2** | 100 | | `=A2*1.2` |
| **3** | 200 | | |
| **4** | 300 | | |
| **5** | | | |
| **6** | | | |
| **7** | MWST: | **20%** | |

**Besser:** Der Prozentsatz steht in einer Zelle und wird referenziert!

In C2 schreiben: `=A2*(1+B7)`

Das ist besser, weil:
1. Man sieht, welcher Faktor verwendet wurde
2. Wenn sich der Faktor ändert, ändert sich alles automatisch

**ABER:** Wenn ich runterziehe...

C2: `=A2*(1+B7)`
C3: `=A3*(1+B8)` ← FALSCH! B8 ist leer!
C4: `=A4*(1+B9)` ← FALSCH!

**Was ist passiert?**
- `A2` → `A3` → `A4` (das wollen wir!)
- `B7` → `B8` → `B9` (das wollen wir NICHT!)

---

### Die Lösung: `$` Dollarzeichen

Wenn etwas beim Runterziehen/rechtsziehen **NICHT** ändern soll, setze ein `$` davor.

| Bezug | Beim Runterziehen | Beim Rechtsziehen |
|-------|-------------------|-------------------|
| `A1` | `A2` | `B1` |
| `$A$1` | `$A$1` | `$A$1` |
| `$A1` | `$A2` | `$A1` |
| `A$1` | `A$1` | `B$1` |

---

### Vier Varianten

| Bezug | Bedeutung |
|-------|-----------|
| `A1` | Alles relativ. Zeile und Spalte ändern sich. |
| `$A$1` | Alles absolut. Nichts ändert sich. |
| `$A1` | Spalte A ist absolut, Zeile ist relativ. Spalte bleibt A, Zeile ändert sich. |
| `A$1` | Zeile 1 ist absolut, Spalte ist relativ. Zeile bleibt 1, Spalte ändert sich. |

---

### In unserem Beispiel

Wir wollen:
- `A2` soll zu `A3` zu `A4` werden (also: `A2`, ohne `$`)
- `B7` soll IMMER `B7` bleiben (also: `$B$7`, mit `$` vor B und vor 7)

**Richtig:**
```excel
=A2*(1+$B$7)
```

Oder:
```excel
=A2*1+$B$7
```

Jetzt beim Runterziehen:
- C2: `=A2*(1+$B$7)`
- C3: `=A3*(1+$B$7)` ✓
- C4: `=A4*(1+$B$7)` ✓

Perfekt!

---

## 3. `F4`-Taste (der Hammer!) (15 min)

Du musst das `$` nicht von Hand schreiben!

Markiere in der Formel den Bezug und drücke `F4`.

**Beispiel:**

1. Schreibe: `=A2*(1+B7`
2. Markiere mit der Maus `B7` in der Formel
3. Drücke **`F4`**

**Was passiert, wenn du `F4` mehrmals drückst:**

| Drücke F4 | Ergebnis |
|-----------|----------|
| 1. Mal | `$B$7` |
| 2. Mal | `B$7` |
| 3. Mal | `$B7` |
| 4. Mal | `B7` |
| 5. Mal | `$B$7` (wieder von vorne) |

**Probier es aus!** `F4` ist dein Freund!

---

### Live-Demo: Mengenpreis-Tabelle

Tabelle für verschiedene Mengen mit verschiedenen Rabatten:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | | | **Rabatt-Level** | | |
| **2** | | 0% | 5% | 10% | 15% |
| **3** | **Menge** | | | | |
| **4** | 1 | | | | |
| **5** | 10 | | | | |
| **6** | 100 | | | | |

**Einheitspreis:** z.B. 10 Euro in Zelle `A9`

Formel in `C4`:
```excel
=$A$9*$A4*(1-C$2)
```

Erklärung:
- `$A$9` = Preis ist immer in A9 (komplett absolut)
- `$A4` = Menge ist immer in Spalte A, aber Zeile ändert sich (nur Spalte absolut)
- `C$2` = Rabatt ist immer in Zeile 2, aber Spalte ändert sich (nur Zeile absolut)

Wenn man diese Formel runter und rechts zieht, passt sich alles automatisch an!

---

## 4. Kata 1: Steuerfaktor (20 min)

Kata-Blätter zeigen.

---

## 5. Kata 2: Mengenpreis (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Relativer Bezug (`A1`) | Ändert sich beim Runterziehen/Rechtsziehen |
| Absoluter Bezug (`$A$1`) | Bleibt immer gleich |
| `$` vor Spalte (`$A1`) | Spalte bleibt, Zeile ändert sich |
| `$` vor Zeile (`A$1`) | Zeile bleibt, Spalte ändert sich |
| `F4` | Taste zum Durchschalten der Varianten |

**Merke:**
- Ohne `$` = relativ = ändert sich
- Mit `$` = absolut = bleibt fix

### Ausblick

Nächste Woche: **Funktionen** (`SUM`, `AVERAGE`, `COUNT`, `MIN`, `MAX`)
