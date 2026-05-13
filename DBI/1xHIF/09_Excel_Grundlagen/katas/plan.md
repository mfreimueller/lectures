# Katas - Woche 09: Excel Grundlagen & Formeln

---

## Kata 1: Preisberechnung Netto/Brutto

| Feld | Wert |
|------|------|
| Konzepte | Formeln mit `=`, Multiplikation, Division, Prozentrechnung, Füllen |
| Schwierigkeit | 1/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine kleine Tabelle für einen Online-Shop mit Preisberechnung.

#### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle in Excel:

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | **Artikel** | **Netto** | **Menge** | **Netto gesamt** | **MWST (20%)** | **Brutto gesamt** |
| **2** | Laptop | 899 | 1 | | | |
| **3** | Maus | 25 | 3 | | | |
| **4** | Tastatur | 45 | 2 | | | |
| **5** | Monitor | 299 | 1 | | | |
| **6** | | | | | | |
| **7** | **GESAMT** | | | | | |

#### Schritt 2: Formeln erstellen

**Netto gesamt (Spalte D):**
Netto pro Artikel × Menge

In Zelle `D2`:
```excel
=B2*C2
```

Dann runterziehen bis D5.

**MWST (Spalte E):**
20% Mehrwertsteuer auf den Nettopreis

In Zelle `E2`:
```excel
=D2*20%
```

Oder:
```excel
=D2*0.2
```

Dann runterziehen bis E5.

**Brutto gesamt (Spalte F):**
Netto + MWST

In Zelle `F2`:
```excel
=D2+E2
```

Oder direkt:
```excel
=D2*1.2
```

Dann runterziehen bis F5.

#### Schritt 3: Gesamtsumme

In Zelle `D7` (Gesamte Netto-Summe):
```excel
=D2+D3+D4+D5
```

Oder du verwendest `=SUM(D2:D5)` (kommt später!)

Ziehe die Formel nach rechts bis F7, oder schreibe sie für E7 und F7 separat.

#### Schritt 4: Testen

Ändere in einer Zeile die Menge oder den Preis.
Was passiert mit den berechneten Werten? → Sie sollten sich automatisch ändern!

### Rechenweg zur Kontrolle

| Artikel | Netto | Menge | Netto gesamt | MWST 20% | Brutto |
|---------|-------|-------|--------------|----------|--------|
| Laptop | 899 | 1 | 899 | 179,80 | 1078,80 |
| Maus | 25 | 3 | 75 | 15 | 90 |
| Tastatur | 45 | 2 | 90 | 18 | 108 |
| Monitor | 299 | 1 | 299 | 59,80 | 358,80 |
| **GESAMT** | | | **1363** | **272,60** | **1635,60** |

---

## Kata 2: Rechenregeln & Operatorenrangfolge

| Feld | Wert |
|------|------|
| Konzepte | Punkt vor Strich, Klammern, komplexere Formeln |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine Tabelle und berechne verschiedene Formeln. Achte auf die Operatorenrangfolge!

#### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Formel** | **Berechnung** | **Dein Ergebnis** | **Erwartet** |
| **2** | 2 + 3 * 4 | `=2+3*4` | | 14 |
| **3** | (2 + 3) * 4 | `=(2+3)*4` | | 20 |
| **4** | 10 / 2 + 3 | `=10/2+3` | | 8 |
| **5** | 10 / (2 + 3) | `=10/(2+3)` | | 2 |
| **6** | 5 + 4 * 3 - 2 | `=5+4*3-2` | | 15 |
| **7** | (5 + 4) * (3 - 2) | `=(5+4)*(3-2)` | | 9 |
| **8** | 100 / 2 / 5 | `=100/2/5` | | 10 |
| **9** | 100 / (2 * 5) | `=100/(2*5)` | | 10 |
| **10** | 2 ^ 3 + 4 | `=2^3+4` | | 12 |
| **11** | 2 ^ (3 + 4) | `=2^(3+4)` | | 128 |

#### Schritt 2: Formeln eingeben

Gib in Spalte C die Formeln aus Spalte B ein (aber mit `=` davor!).

Prüfe: Dein Ergebnis in C sollte mit dem erwarteten Wert in D übereinstimmen.

#### Schritt 3: Fragen beantworten

1. Warum ist `=2+3*4` = 14 und nicht 20?
2. Was machen Klammern `()` in einer Formel?
3. Welche Rechenart hat höhere Priorität: Multiplikation oder Addition?

---

### Bonus-Aufgabe: Flächenberechnung

Erstelle eine Tabelle für Flächenberechnungen:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | **Form** | **a** | **b** | **Formel** | **Fläche** |
| **2** | Rechteck | 5 | 8 | `=B2*C2` | |
| **3** | Quadrat | 7 | 7 | `=B3^2` | |
| **4** | Dreieck | 6 | 4 | `=B4*C4/2` | |
| **5** | Kreis (Radius 3) | 3 | | `=B5^2*PI()` | |

**Hinweis:** `PI()` ist eine eingebaute Funktion für π = 3.14159...

Erwartete Ergebnisse:
- Rechteck: 40
- Quadrat: 49
- Dreieck: 12
- Kreis: ca. 28.27

---

### Regeln zum Merken

| Regel | Erklärung |
|-------|-----------|
| **Punkt vor Strich** | `*` und `/` werden vor `+` und `-` berechnet |
| **Klammern zuerst** | `()` ändern die Reihenfolge |
| **Gleiche Priorität** | `*` und `/` von links nach rechts |
| | `+` und `-` von links nach rechts |

**Beispiel:**
`=100/2/5` = `(100/2)/5` = `50/5` = `10` (von links nach rechts)
