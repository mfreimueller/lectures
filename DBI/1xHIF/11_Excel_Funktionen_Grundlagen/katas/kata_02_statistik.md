# Kata 2: Statistik-Auswertung

## Ziel

Lerne die feinen Unterschiede zwischen `COUNT()` und `COUNTA()`, und das Verschachteln von Funktionen.

## Der wichtige Unterschied: COUNT vs. COUNTA

| Funktion | Was zählt sie? |
|----------|-----------------|
| `COUNT(Bereich)` | Nur Zellen mit **ZAHLEN** |
| `COUNTA(Bereich)` | Alle **nicht leeren** Zellen (auch Text!) |

**Beispiel:**

| | A |
|---|---|
| 1 | 100 |
| 2 | 200 |
| 3 | Hallo |
| 4 | 300 |
| 5 | (leer) |

- `=COUNT(A1:A5)` = **3** (nur die Zahlen: 100, 200, 300)
- `=COUNTA(A1:A5)` = **4** (alle nicht leeren: 100, 200, Hallo, 300)

**Merke:**
- Zählen von Werten/Punkten/Noten → `COUNT()`
- Zählen von Teilnehmern/Einträgen (auch Namen/Text) → `COUNTA()`

---

## Aufgabenstellung

Auswertung einer Umfrage unter Schüler/innen.

### Schritt 1: Tabelle erstellen

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Name** | **Alter** | **Lieblingsfach** | **Punkte** |
| **2** | Anna Müller | 16 | POS | 85 |
| **3** | Ben Schmidt | 17 | DBI | 92 |
| **4** | Clara Weber | 16 | | 78 |
| **5** | David Bauer | 17 | POS | 65 |
| **6** | Eva Huber | 16 | INF | 88 |
| **7** | Felix Mayer | 17 | POS | 95 |
| **8** | | | | |
| **9** | **Statistik** | | | |
| **10** | Teilnehmer gesamt (COUNTA Namen) | | | |
| **11** | Teilnehmer mit Punkten (COUNT Punkte) | | | |
| **12** | Höchste Punkte | | | |
| **13** | Niedrigste Punkte | | | |
| **14** | Durchschnittliche Punkte | | | |
| **15** | Durchschnittsalter | | | |
| **16** | Spannweite Punkte (MAX - MIN) | | | |

---

### Schritt 2: Auswertung

Gehe die Statistik-Zeilen (10-16) durch.

#### Teilnehmer gesamt

Wir wollen zählen, wie viele Namen in Spalte A stehen.

In Zelle **B10**:
```excel
=COUNTA(A2:A7)
```

**Warum `COUNTA`?** Weil Namen Text sind, keine Zahlen!
- `COUNT(A2:A7)` würde 0 ergeben, weil keine Zahlen in A2:A7 stehen
- `COUNTA(A2:A7)` zählt alle nicht leeren Zellen

Erwartetes Ergebnis: **6**

---

#### Teilnehmer mit Punkten

In Zelle **B11**:
```excel
=COUNT(D2:D7)
```

Oder:
```excel
=COUNTA(D2:D7)
```

Hier wäre beides gleich, weil Punkte Zahlen sind.

Erwartetes Ergebnis: **6**

---

#### Höchste und niedrigste Punkte

In **B12** (Höchste Punkte):
```excel
=MAX(D2:D7)
```

In **B13** (Niedrigste Punkte):
```excel
=MIN(D2:D7)
```

Erwartete Ergebnisse:
- MAX: **95**
- MIN: **65**

---

#### Durchschnitte

In **B14** (Durchschnittliche Punkte):
```excel
=AVERAGE(D2:D7)
```

In **B15** (Durchschnittsalter):
```excel
=AVERAGE(B2:B7)
```

Erwartete Ergebnisse:
- Durchschnitt Punkte: **83,83...**
- Durchschnitt Alter: **16,5**

---

#### Spannweite (verschachtelte Funktionen)

Die Spannweite ist die Differenz zwischen dem höchsten und dem niedrigsten Wert.

In **B16**:
```excel
=MAX(D2:D7) - MIN(D2:D7)
```

Das ist eine **verschachtelte Formel**:
- Zuerst: `MAX(D2:D7)` = 95
- Dann: `MIN(D2:D7)` = 65
- Dann: `95 - 65` = 30

Erwartetes Ergebnis: **30**

---

### Schritt 3: Verständnis-Fragen

Beantworte diese Fragen zur Kontrolle:

1. **Was ist das Ergebnis von `=COUNT(A2:A7)` (Spalte A mit den Namen)?**
   - 0, weil Namen Text sind, keine Zahlen!

2. **Was ist das Ergebnis von `=COUNTA(A2:A7)`?**
   - 6, weil es 6 nicht leere Zellen gibt

3. **Warum ist `=COUNT(C2:C7)` (Lieblingsfach) = 5?**
   - Weil `COUNT` nur Zahlen zählt... wait, das sind Texte!
   - Richtig: `COUNT(C2:C7)` = 0 (keine Zahlen)
   - `COUNTA(C2:C7)` = 5 (Clara hat kein Lieblingsfach eingetragen, Zelle C4 ist leer)

**Teste es selbst!**
- `=COUNT(C2:C7)` in eine leere Zelle schreiben
- `=COUNTA(C2:C7)` in eine andere Zelle schreiben

Stimmen die Ergebnisse?

---

## Kontrolle

Deine Auswertung sollte ergeben:

| Statistik | Wert |
|-----------|------|
| Teilnehmer gesamt | 6 |
| Teilnehmer mit Punkten | 6 |
| Höchste Punkte | 95 |
| Niedrigste Punkte | 65 |
| Durchschnittliche Punkte | 83,83 |
| Durchschnittsalter | 16,5 |
| Spannweite Punkte | 30 |

---

## Zusammenfassung

| Funktion | Was macht sie? | Wann verwenden? |
|----------|----------------|-----------------|
| `SUM()` | Addiert | Gesamtsumme |
| `AVERAGE()` | Mittelwert | Durchschnitt |
| `MIN()` | Kleinster Wert | Schlechteste Note |
| `MAX()` | Größter Wert | Beste Note |
| `COUNT()` | Zählt nur ZAHLEN | Punkte, Noten, Werte |
| `COUNTA()` | Zählt alle nicht leeren Zellen | Namen, Einträge |

### Bereichsnotation

| Schreibweise | Bedeutung |
|--------------|-----------|
| `A1:A5` | Alle Zellen von A1 bis A5 |
| `B2:D4` | Rechteck von B2 bis D4 |
| `A1; C1; E1` | Die Zellen A1, C1, E1 (Semikolon = UND) |

## Erweiterung (optional)

1. Füge eine weitere Schülerin/einen weiteren Schüler hinzu
2. Lasse dir von Excel die 5 besten Punkte anzeigen (Tipp: `LARGE()` Funktion)
3. Lasse dir von Excel die 3 schlechtesten Punkte anzeigen (Tipp: `SMALL()` Funktion)
4. Zähle, wie viele Schüler/innen mehr als 80 Punkte haben (Tipp: `COUNTIF()` - kommt später!)
