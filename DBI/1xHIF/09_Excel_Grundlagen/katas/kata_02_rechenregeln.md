# Kata 2: Rechenregeln & Operatorenrangfolge

## Ziel

Lerne die "Punkt vor Strich"-Regel in Excel und wie Klammern die Reihenfolge ändern.

## In Mathematik gilt: Punkt vor Strich

Genau wie in der Schule:
1. Klammern `()`
2. Potenz `^`
3. Multiplikation `*` und Division `/`
4. Addition `+` und Subtraktion `-`

## Aufgabenstellung

Erstelle eine Tabelle und berechne verschiedene Formeln. Prüfe, ob dein Ergebnis mit dem erwarteten Ergebnis übereinstimmt.

---

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle in Excel:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Formel (als Text)** | **Deine Formel mit =** | **Dein Ergebnis** | **Erwartet** |
| **2** | 2 + 3 * 4 | | | 14 |
| **3** | (2 + 3) * 4 | | | 20 |
| **4** | 10 / 2 + 3 | | | 8 |
| **5** | 10 / (2 + 3) | | | 2 |
| **6** | 5 + 4 * 3 - 2 | | | 15 |
| **7** | (5 + 4) * (3 - 2) | | | 9 |
| **8** | 100 / 2 / 5 | | | 10 |
| **9** | 2 ^ 3 + 4 | | | 12 |
| **10** | 2 ^ (3 + 4) | | | 128 |

---

### Schritt 2: Formeln eingeben

Gib in Spalte C die Formeln aus Spalte A ein.

**WICHTIG: Füge immer `=` am Anfang hinzu!**

**Beispiel für Zeile 2:**

In A2 steht (als Text): `2 + 3 * 4`

In C2 schreibst du (als Formel): `=2+3*4`

Drücke Enter.

Was kommt raus? `14` (NICHT 20!)

**Warum?** Punkt vor Strich!
- Zuerst: `3 * 4 = 12`
- Dann: `2 + 12 = 14`

---

### Schritt 3: Alle Formeln durchgehen

Geh Zeile für Zeile durch und vergleiche mit "Erwartet" in Spalte D.

#### Zeile 2: `=2+3*4`
- Berechnung: `3 * 4 = 12`, dann `2 + 12 = 14`
- Erwartet: 14

#### Zeile 3: `=(2+3)*4`
- Klammern ändern die Reihenfolge!
- Berechnung: `(2+3) = 5`, dann `5 * 4 = 20`
- Erwartet: 20

#### Zeile 4: `=10/2+3`
- Berechnung: `10 / 2 = 5`, dann `5 + 3 = 8`
- Erwartet: 8

#### Zeile 5: `=10/(2+3)`
- Mit Klammern
- Berechnung: `(2+3) = 5`, dann `10 / 5 = 2`
- Erwartet: 2

#### Zeile 6: `=5+4*3-2`
- Punkt vor Strich
- Berechnung: `4 * 3 = 12`, dann `5 + 12 - 2 = 15`
- Erwartet: 15

#### Zeile 7: `=(5+4)*(3-2)`
- Zwei Klammern
- Berechnung: `(5+4) = 9`, `(3-2) = 1`, dann `9 * 1 = 9`
- Erwartet: 9

#### Zeile 8: `=100/2/5`
- Gleicher Rang: von links nach rechts
- Berechnung: `100 / 2 = 50`, dann `50 / 5 = 10`
- Erwartet: 10

#### Zeile 9: `=2^3+4`
- Potenz (`^`) hat höhere Priorität als `+`
- Berechnung: `2^3 = 8`, dann `8 + 4 = 12`
- Erwartet: 12

#### Zeile 10: `=2^(3+4)`
- Mit Klammern
- Berechnung: `(3+4) = 7`, dann `2^7 = 128`
- Erwartet: 128

---

## Zusammenfassung der Regeln

| Priorität | Operator | Erklärung |
|-----------|----------|-----------|
| 1 (höchste) | `()` | Klammern |
| 2 | `^` | Potenz (2^3 = 8) |
| 3 | `*` `/` | Multiplikation, Division |
| 4 (niedrigste) | `+` `-` | Addition, Subtraktion |

**Zusatzregel:**
- Bei gleicher Priorität: von **links nach rechts**
- Beispiel: `100/2/5` = `(100/2)/5` = `10` (nicht `100/(2/5)` = `250`)

---

## Fragen zum Überlegen

1. Warum ist `=2+3*4` = 14 und nicht 20?

2. Was machen Klammern `()` in einer Formel?

3. Welche Rechenart hat höhere Priorität: Multiplikation oder Addition?

4. Was berechnet `^`?

5. Was ist das Ergebnis von `=8/2/2`? Und warum?

---

## Bonus: Flächenberechnung

Versuche diese Tabelle:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Form** | **a** | **b** | **Fläche** |
| **2** | Rechteck | 5 | 8 | `=B2*C2` |
| **3** | Quadrat | 7 | | `=B3^2` |
| **4** | Dreieck | 6 | 4 | `=B4*C4/2` |
| **5** | Kreis (r=3) | 3 | | `=B5^2*PI()` |

Hinweis: `PI()` ist eine eingebaute Funktion für π (Pi = 3.14159...).

Erwartete Ergebnisse:
- Rechteck: 40
- Quadrat: 49
- Dreieck: 12
- Kreis: ca. 28.27

---

## Hinweise

- Wenn du unsicher bist, setze Klammern!
- Klammern machen deine Absicht klarer
- `=2+3*4` vs. `=2+(3*4)` → Gleiches Ergebnis, aber zweites ist lesbarer
- Teste: Wenn du etwas änderst, ändert sich das Ergebnis?
- `Strg+Z` = Rückgängig, falls etwas schiefgeht
