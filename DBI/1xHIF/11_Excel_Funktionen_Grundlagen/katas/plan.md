# Katas - Woche 11: Excel Funktionen Grundlagen

---

## Kata 1: Notenschnitt berechnen

| Feld | Wert |
|------|------|
| Konzepte | `SUM`, `AVERAGE`, `MIN`, `MAX`, Bereichsnotation |
| Schwierigkeit | 1/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine Noten-Tabelle und berechne Summe, Durchschnitt, beste und schlechteste Note.

#### Schritt 1: Tabelle erstellen

| | A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|---|
| **1** | **Student** | **Test 1** | **Test 2** | **Test 3** | **Summe** | **Schnitt** | **Note** |
| **2** | Anna Müller | 88 | 92 | 85 | | | |
| **3** | Ben Schmidt | 75 | 68 | 80 | | | |
| **4** | Clara Weber | 95 | 91 | 98 | | | |
| **5** | David Bauer | 45 | 52 | 38 | | | |
| **6** | | | | | | | | |
| **7** | **Beste Note** | | | | | | | |
| **8** | **Schlechteste Note** | | | | | | | |
| **9** | **Durchschnitt Klasse** | | | | | | | |

#### Schritt 2: Summe berechnen

In Zelle **E2** (Summe von Anna):
```excel
=SUM(B2:D2)
```

Oder:
```excel
=B2+C2+D2
```

Ziehe runter bis E5.

#### Schritt 3: Schnitt berechnen

In Zelle **F2** (Durchschnitt von Anna):
```excel
=AVERAGE(B2:D2)
```

Ziehe runter bis F5.

#### Schritt 4: Note (Optional - mit Rundung)

In G2:
```excel
=ROUND(F2; 0)
```

Rundet auf ganze Zahl.

Ziehe runter bis G5.

#### Schritt 5: Beste und schlechteste Note

In **B7** (Beste Note aller Tests):
```excel
=MAX(B2:D5)
```

In **B8** (Schlechteste Note aller Tests):
```excel
=MIN(B2:D5)
```

#### Schritt 6: Durchschnitt der gesamten Klasse

In **B9** (Durchschnitt aller Noten aller Tests):
```excel
=AVERAGE(B2:D5)
```

#### Schritt 7: Testen

Ändere eine Note (z.B. B2 von 88 auf 100). Was passiert?
- Summe ändert sich
- Schnitt ändert sich
- MAX ändert sich (falls 100 die neue Beste ist)

### Erwartete Ergebnisse zur Kontrolle

| Student | Test 1 | Test 2 | Test 3 | Summe | Schnitt | Note (gerundet) |
|---------|--------|--------|--------|-------|---------|-----------------|
| Anna | 88 | 92 | 85 | 265 | 88,33 | 88 |
| Ben | 75 | 68 | 80 | 223 | 74,33 | 74 |
| Clara | 95 | 91 | 98 | 284 | 94,67 | 95 |
| David | 45 | 52 | 38 | 135 | 45 | 45 |

| Statistik | Wert |
|-----------|------|
| Beste Note | 98 |
| Schlechteste Note | 38 |
| Klassenschnitt | 73,08 |

---

## Kata 2: Statistik-Auswertung

| Feld | Wert |
|------|------|
| Konzepte | `COUNT`, `COUNTA`, verschachtelte Funktionen, Bereichsnotation |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Auswertung einer Umfrage unter Schülern.

#### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Name** | **Alter** | **Lieblingsfach** | **Punkte** |
| **2** | Anna | 16 | POS | 85 |
| **3** | Ben | 17 | DBI | 92 |
| **4** | Clara | 16 | | 78 |
| **5** | David | 17 | POS | 65 |
| **6** | Eva | 16 | INF | 88 |
| **7** | Felix | 17 | POS | 95 |
| **8** | | | | |
| **9** | **Statistik** | | | |
| **10** | Teilnehmer gesamt (COUNTA) | | | |
| **11** | Teilnehmer mit Punkten (COUNT) | | | |
| **12** | Höchste Punkte | | | |
| **13** | Niedrigste Punkte | | | |
| **14** | Durchschnittliche Punkte | | | |
| **15** | Durchschnittsalter | | | |
| **16** | Spannweite Punkte (MAX-MIN) | | | |

#### Schritt 2: Auswertung

In **B10** (Teilnehmer gesamt - zählt Namen):
```excel
=COUNTA(A2:A7)
```
Erwartet: 6 (Anna, Ben, Clara, David, Eva, Felix)

In **B11** (Teilnehmer mit Punkten - zählt nur Zahlen):
```excel
=COUNT(D2:D7)
```
Erwartet: 6 (alle haben Punkte)

In **B12** (Höchste Punkte):
```excel
=MAX(D2:D7)
```

In **B13** (Niedrigste Punkte):
```excel
=MIN(D2:D7)
```

In **B14** (Durchschnittliche Punkte):
```excel
=AVERAGE(D2:D7)
```

In **B15** (Durchschnittsalter):
```excel
=AVERAGE(B2:B7)
```

In **B16** (Spannweite = Differenz zwischen höchstem und niedrigstem Wert):
```excel
=MAX(D2:D7) - MIN(D2:D7)
```

#### Schritt 3: Verständnis-Fragen

1. Warum ist `COUNTA(A2:A7)` = 6, aber `COUNT(A2:A7)` = 0?
   - Weil `COUNT` nur Zahlen zählt, und die Namen sind Text!

2. Was passiert, wenn du `=COUNT(C2:C7)` (Lieblingsfächer) eingibst?
   - Ergebnis = 5
   - Warum? Weil Clara kein Lieblingsfach eingetragen hat (C4 ist leer)
   - Und: `COUNT` zählt nur Zahlen... wait, das waren Texte!
   - Richtig: Für Texte braucht man `COUNTA`!

3. `=COUNTA(C2:C7)` = 5 (Clara hat kein Lieblingsfach)
   `=COUNT(C2:C7)` = 0 (es sind Texte, keine Zahlen)

#### Kontrollergebnisse

| Statistik | Wert |
|-----------|------|
| Teilnehmer gesamt (COUNTA Namen) | 6 |
| Teilnehmer mit Punkten (COUNT Punkte) | 6 |
| Höchste Punkte | 95 |
| Niedrigste Punkte | 65 |
| Durchschnittliche Punkte | 83,83 |
| Durchschnittsalter | 16,5 |
| Spannweite | 30 |

---

### Zusammenfassung der Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `SUM(Bereich)` | Addiert alle Werte |
| `AVERAGE(Bereich)` | Berechnet den Durchschnitt |
| `COUNT(Bereich)` | Zählt nur Zellen mit ZAHLEN |
| `COUNTA(Bereich)` | Zählt alle nicht-leeren Zellen (auch Text) |
| `MIN(Bereich)` | Gibt den kleinsten Wert zurück |
| `MAX(Bereich)` | Gibt den größten Wert zurück |

| Bereich | Bedeutung |
|---------|-----------|
| `A1:A5` | Von A1 bis A5 |
| `B2:D4` | Rechteck von B2 bis D4 |
| `A1; C1; E1` | Die Zellen A1, C1, E1 (Semikolon als Trennzeichen) |
