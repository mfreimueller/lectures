# Kata 1: Notenschnitt berechnen

## Ziel

Lerne die wichtigsten Excel-Grundfunktionen: `SUM`, `AVERAGE`, `MIN`, `MAX`.

## Aufgabenstellung

Erstelle eine Noten-Tabelle für eine Schülerklasse und berechne Summe, Durchschnitt, beste und schlechteste Note.

---

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle:

| | A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|---|
| **1** | **Student** | **Test 1** | **Test 2** | **Test 3** | **Summe** | **Schnitt** | **Note** |
| **2** | Anna Müller | 88 | 92 | 85 | | | |
| **3** | Ben Schmidt | 75 | 68 | 80 | | | |
| **4** | Clara Weber | 95 | 91 | 98 | | | |
| **5** | David Bauer | 45 | 52 | 38 | | | |
| **6** | | | | | | | |
| **7** | **Beste Note** | | | | | | |
| **8** | **Schlechteste Note** | | | | | | |
| **9** | **Durchschnitt Klasse** | | | | | | |

Tipp für das Aussehen:
- Überschriften (Zeile 1 und Zeilen 7-9) fett machen
- Farbliche Abgrenzung für die Statistik (Zeilen 7-9)

---

### Schritt 2: Summe berechnen

Die Summe aller drei Test-Ergebnisse pro Schüler.

In Zelle **E2** (Summe von Anna):

```excel
=SUM(B2:D2)
```

Oder du schreibst von Hand:
```excel
=B2+C2+D2
```

**Was ist der Unterschied?**
- `=SUM(B2:D2)` = Funktion, kürzer
- `=B2+C2+D2` = Manuelle Addition

Beide sind richtig! `SUM()` ist nur praktischer bei vielen Werten.

**Tipp: Maus-Markierung**
1. Schreibe `=SUM(`
2. Markiere mit der Maus den Bereich B2 bis D2
3. Schließe die Klammer: `)`
4. Drücke Enter

Excel hat den Bereich `B2:D2` automatisch eingetragen!

Wenn du fertig bist, ziehe die Formel von **E2 runter bis E5**.

---

### Schritt 3: Durchschnitt (Schnitt) berechnen

Der Durchschnitt ist die Summe geteilt durch die Anzahl der Werte.

In Zelle **F2** (Durchschnitt von Anna):

```excel
=AVERAGE(B2:D2)
```

Was macht `AVERAGE`?
- Addiert alle Werte: `88 + 92 + 85 = 265`
- Teilt durch die Anzahl der Werte: `265 / 3 = 88,33...`

Ziehe runter bis F5.

---

### Schritt 4: Note (Optional, mit Rundung)

Wenn du den Durchschnitt auf eine ganze Zahl runden möchtest:

In Zelle **G2**:

```excel
=ROUND(F2, 0)
```

Erklärung:
- `F2` = Der Wert zum Runden (der Durchschnitt)
- `0` = Anzahl der Nachkommastellen (0 = ganze Zahl)

Beispiele:
- `=ROUND(88,33; 0)` = 88
- `=ROUND(94,67; 0)` = 95
- `=ROUND(74,33; 0)` = 74

Ziehe runter bis G5.

---

### Schritt 5: Beste und schlechteste Note

**Höchste Punktzahl in allen Tests:**

In Zelle **B7**:
```excel
=MAX(B2:D5)
```

`MAX()` sucht den größten Wert in einem Bereich.

**Niedrigste Punktzahl in allen Tests:**

In Zelle **B8**:
```excel
=MIN(B2:D5)
```

`MIN()` sucht den kleinsten Wert in einem Bereich.

---

### Schritt 6: Klassenschnitt

Durchschnitt aller Punkte aller Tests aller Schüler:

In Zelle **B9**:
```excel
=AVERAGE(B2:D5)
```

`AVERAGE()` berechnet den Durchschnitt aller Werte im Bereich `B2:D5`.

---

### Schritt 7: Testen

Teste, ob alles funktioniert:

Ändere in Zelle **B2** die Note von `88` auf `100`.

Was passiert?
- E2 (Summe) ändert sich
- F2 (Durchschnitt) ändert sich
- G2 (Note) ändert sich
- B7 (Beste Note) ändert sich (wenn 100 die neue Höchstnote ist)
- B9 (Klassenschnitt) ändert sich

**Das ist das Tolle an Excel:** Alle zusammenhängenden Berechnungen aktualisieren sich automatisch!

---

## Kontrolle

Deine Tabelle sollte am Ende so aussehen:

| Student | Test 1 | Test 2 | Test 3 | Summe | Schnitt | Note (gerundet) |
|---------|--------|--------|--------|-------|---------|-----------------|
| Anna Müller | 88 | 92 | 85 | 265 | 88,33 | 88 |
| Ben Schmidt | 75 | 68 | 80 | 223 | 74,33 | 74 |
| Clara Weber | 95 | 91 | 98 | 284 | 94,67 | 95 |
| David Bauer | 45 | 52 | 38 | 135 | 45 | 45 |

| Statistik | Wert |
|-----------|------|
| Beste Note | 98 |
| Schlechteste Note | 38 |
| Durchschnitt Klasse | 73,08 |

---

## Zusammenfassung der Funktionen

| Funktion | Erklärung | Beispiel |
|----------|-----------|----------|
| `=SUM(Bereich)` | Addiert alle Werte | `=SUM(B2:D2)` |
| `=AVERAGE(Bereich)` | Berechnet den Durchschnitt | `=AVERAGE(B2:D2)` |
| `=MIN(Bereich)` | Gibt den kleinsten Wert zurück | `=MIN(B2:D5)` |
| `=MAX(Bereich)` | Gibt den größten Wert zurück | `=MAX(B2:D5)` |
| `=ROUND(Wert; Stellen)` | Rundet einen Wert | `=ROUND(F2; 0)` |

## Tipp: AutoSumme-Button

Den schnellsten Weg gibt's über den Button:

**Start → AutoSumme (Σ)**

Oder Shortcut: **`Alt+=`**

1. Klicke in die Zelle, wo das Ergebnis hin soll
2. Drücke `Alt+=`
3. Excel schlägt automatisch einen Bereich vor
4. Drücke Enter

Probier es aus!

## Erweiterung (optional)

1. Füge weitere Schüler/innen zur Tabelle hinzu
2. Füge einen 4. Test hinzu (Spalte E)
3. Passe die Formeln an
4. Füge eine Bedingte Formatierung hinzu (kommt später):
   - Alle Noten unter 50 rot färben
   - Alle Noten über 90 grün färben
