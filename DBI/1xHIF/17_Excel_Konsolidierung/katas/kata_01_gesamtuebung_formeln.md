# Kata 1: Gesamtübung Formeln & Bezüge

## Ziel

Wiederhole die Grundlagen: Formeln, Bezüge, und die wichtigsten Funktionen.

## Checkliste vor dem Start

- [ ] Jede Formel beginnt mit `=`
- [ ] Trennzeichen ist `;` (Semikolon), nicht Komma
- [ ] Absolutbezüge mit `$` wenn etwas fest bleiben soll

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

| | A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|---|
| **1** | **Produkt** | **Einzelpreis** | **Menge** | **Gesamtpreis** | **Rabatt 10%** | **Endpreis** | |
| **2** | Notebook | 1200 | 2 | | | | |
| **3** | Maus | 49 | 5 | | | | |
| **4** | Monitor | 349 | 2 | | | | |
| **5** | Tastatur | 89 | 4 | | | | |
| **6** | | | | | | | |
| **7** | **Steuerfaktor** | 1.2 | | | | | |
| **8** | | | | | | | |
| **9** | **Gesamtsumme** | | | | | | |
| **10** | **Durchschnitt** | | | | | | |
| **11** | **Teuerster Artikel** | | | | | | |
| **12** | **Billigster Artikel** | | | | | | |
| **13** | **Anzahl Produkte** | | | | | | |

---

### Schritt 2: Gesamtpreis berechnen

Gesamtpreis = Einzelpreis * Menge

**In D2:**
```excel
=B2*C2
```

Ziehe die Formel von **D2 runter bis D5**.

---

### Schritt 3: Rabatt berechnen

Rabatt 10% = Gesamtpreis * 0.9

**In E2:**
```excel
=D2*0.9
```

Oder so (gleichwertig):
```excel
=D2-D2*10%
```

Ziehe runter bis E5.

---

### Schritt 4: Endpreis mit Steuer (Wichtig: Absoluter Bezug!)

Endpreis = Preis nach Rabatt * Steuerfaktor

Der Steuerfaktor steht in **B7** und soll sich beim Runterziehen **nicht** ändern!

→ Brauchen einen **absoluten Bezug** mit `$`.

Ohne `$`:
- `B7` würde zu `B8`, `B9`, `B10`...

Mit `$`:
- `$B$7` bleibt immer `$B$7`

**In F2:**
```excel
=E2*$B$7
```

Ziehe runter bis F5.

**Test:** Klicke auf F3. Da sollte stehen:
```excel
=E3*$B$7
```

**Nicht:**
```excel
=E3*B8  ← Falsch!
```

---

### Schritt 5: Grundfunktionen anwenden

Jetzt die Statistik in den Zeilen 9-13 ausfüllen.

**Gesamtsumme (B9):**
Summe aller Endpreise:
```excel
=SUM(F2:F5)
```

**Durchschnitt (B10):**
Durchschnitt aller Endpreise:
```excel
=AVERAGE(F2:F5)
```

**Teuerster Artikel (B11):**
Höchster Endpreis:
```excel
=MAX(F2:F5)
```

**Billigster Artikel (B12):**
Niedrigster Endpreis:
```excel
=MIN(F2:F5)
```

**Anzahl Produkte (B13):**
Zähle die Einträge:
```excel
=COUNT(F2:F5)
```

Oder (da es Texte in A gibt):
```excel
=COUNTA(A2:A5)
```

---

### Die wichtigsten Funktionen im Überblick

| Funktion | Was macht sie? | Beispiel |
|----------|----------------|----------|
| `=SUM()` | Addiert | `=SUM(A1:A5)` |
| `=AVERAGE()` | Durchschnitt | `=AVERAGE(A1:A5)` |
| `=MIN()` | Kleinster Wert | `=MIN(A1:A5)` |
| `=MAX()` | Größter Wert | `=MAX(A1:A5)` |
| `=COUNT()` | Zählt Zahlen | `=COUNT(A1:A5)` |
| `=COUNTA()` | Zählt alles | `=COUNTA(A1:A5)` |

---

### Kontrolle

Deine Tabelle sollte am Ende so aussehen:

| Produkt | Einzelpreis | Menge | Gesamtpreis | Rabatt 10% | Endpreis |
|---------|-------------|-------|-------------|------------|----------|
| Notebook | 1200 | 2 | 2400 | 2160 | 2592 |
| Maus | 49 | 5 | 245 | 220,5 | 264,6 |
| Monitor | 349 | 2 | 698 | 628,2 | 753,84 |
| Tastatur | 89 | 4 | 356 | 320,4 | 384,48 |

| Statistik | Wert |
|-----------|------|
| Gesamtsumme | 3994,92 |
| Durchschnitt | 998,73 |
| Teuerster Artikel | 2592 |
| Billigster Artikel | 264,6 |
| Anzahl Produkte | 4 |

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| `=` | Jede Formel fängt damit an |
| `+` `-` `*` `/` | Grundrechenarten |
| `$A$1` | Absoluter Bezug (bleibt fest) |
| `A1` | Relativer Bezug (ändert sich) |
| `;` | Trennzeichen zwischen Parametern |

## Erweiterung (optional)

1. Ändere den Steuerfaktor in B7 von 1.2 auf 1.1
   - Was passiert mit den Endpreisen?

2. Füge einen Rabatt-Parameter hinzu:
   - Setze in eine Zelle: `Rabatt: 10%`
   - Verwende einen absoluten Bezug darauf

3. Füge weitere Produkte zur Tabelle hinzu
   - Kopfhörer: Preis 129, Menge 3
   - Webcam: Preis 79, Menge 2
   - Passe die Formeln in der Statistik an

4. (Schwer) Berechne den Gesamterlös ohne Steuer:
   - Tipp: `=SUM(E2:E5)` oder `=SUM(D2:D5)*0.9`
