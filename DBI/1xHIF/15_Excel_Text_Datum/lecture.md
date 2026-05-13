# Lecture: Woche 15 - Excel Text & Datum Funktionen

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Welche Funktion ist die moderne Alternative zu VLOOKUP?" → `XLOOKUP()`
2. "Was macht `MATCH()`?" → Findet die Position (Zeilennummer) eines Werts
3. "Was ist der Vorteil von INDEX/MATCH gegenüber VLOOKUP?" → Suchspalte kann überall sein, Rückwärts-Suche möglich

---

## 2. Theorie: Text-Funktionen (15 min)

### Was sind Text-Funktionen?

Oft hat man Text in Zellen, den man bearbeiten will:
- "Anna Müller" → Nur Vorname extrahieren
- "12345-Wien" → PLZ extrahieren
- "a.mueller" → Länge zählen

---

### LEFT: Zeichen von links

```excel
=LEFT(Text; Anzahl_Zeichen)
```

**Beispiel:**
```excel
=LEFT("Anna Müller"; 4)
```
Ergebnis: `"Anna"`

---

### RIGHT: Zeichen von rechts

```excel
=RIGHT(Text; Anzahl_Zeichen)
```

**Beispiel:**
```excel
=RIGHT("Anna Müller"; 6)
```
Ergebnis: `"Müller"`

---

### MID: Zeichen aus der Mitte

```excel
=MID(Text; Startposition; Anzahl_Zeichen)
```

**Wichtig:** Die erste Position ist 1, nicht 0!

**Beispiel:**
```excel
=MID("Hallo Welt"; 7; 4)
```
Ergebnis: `"Welt"`

Aufbau:
- Position 1: H
- Position 2: a
- Position 3: l
- Position 4: l
- Position 5: o
- Position 6: (Leerzeichen)
- Position 7: W ← Start hier
- Position 8: e
- Position 9: l
- Position 10: t

---

### LEN: Länge eines Textes

```excel
=LEN(Text)
```

**Beispiel:**
```excel
=LEN("Hallo")
```
Ergebnis: `5`

```excel
=LEN("Anna Müller")
```
Ergebnis: `11` (zählt auch Leerzeichen!)

---

### Live-Demo Text-Funktionen

Erstelle am Beamer:

| | A | B | C |
|---|---|---|---|
| **1** | **Kompletter Name** | **Vorname** | **Nachname** |
| **2** | Anna Müller | | |
| **3** | Ben Schmidt | | |
| **4** | Clara Weber | | |

**In B2 (Vorname - ersten 4 Zeichen):**
```excel
=LEFT(A2; 4)
```

**In C2 (Nachname - letzten 6 Zeichen):**
```excel
=RIGHT(A2; 6)
```

---

### Text zusammenfügen mit `&`

```excel
=A2 & " " & B2
```

oder mit Text dazwischen:
```excel
="Name: " & A2 & ", Alter: " & B2
```

---

### TEXT: Formatieren als Text

```excel
=TEXT(Wert; Format)
```

**Beispiele:**
```excel
=TEXT(1234.5; "#.##0,00")    → "1.234,50"
=TEXT(TODAY(); "dd.mm.yyyy")  → "13.05.2026"
=TEXT(0.75; "0%")              → "75%"
```

---

## 3. Theorie: Datum-Funktionen (15 min)

### Wichtiges zu Daten in Excel

Excel speichert Daten als **Zahlen**:
- Tag 1 = 01.01.1900
- Tag 46154 = 13.05.2026

Deshalb funktionieren auch Berechnungen mit Daten!

---

### TODAY und NOW

```excel
=TODAY()   → Heutiges Datum (ohne Uhrzeit)
=NOW()     → Heutiges Datum + aktuelle Uhrzeit
```

---

### Jahr, Monat, Tag extrahieren

| Funktion | Erklärung |
|----------|-----------|
| `=YEAR(Datum)` | Gibt das Jahr zurück |
| `=MONTH(Datum)` | Gibt den Monat zurück (1-12) |
| `=DAY(Datum)` | Gibt den Tag zurück (1-31) |

**Beispiel:**
```excel
=YEAR("13.05.2026")   → 2026
=MONTH("13.05.2026")  → 5
=DAY("13.05.2026")    → 13
```

---

### DATEDIF: Differenz zwischen zwei Daten

```excel
=DATEDIF(Startdatum; Enddatum; "Einheit")
```

**Einheiten:**

| Einheit | Bedeutung |
|---------|-----------|
| `"y"` | Volle Jahre |
| `"m"` | Volle Monate |
| `"d"` | Volle Tage |
| `"ym"` | Monate (Jahre ignoriert) |
| `"yd"` | Tage (Jahre ignoriert) |
| `"md"` | Tage (Jahre und Monate ignoriert) |

---

### Altersberechnung

Das wichtigste Beispiel: **Alter berechnen**

```excel
=DATEDIF(Geburtsdatum; TODAY(); "y")
```

**Beispiel:**
```excel
=DATEDIF("15.03.2008"; TODAY(); "y")
```

→ Gibt das aktuelle Alter in Jahren zurück.

---

### Live-Demo Datum-Funktionen

Erstelle am Beamer:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Name** | **Geburtstag** | **Alter** | **Geburtsmonat** |
| **2** | Anna | 15.03.2008 | | |
| **3** | Ben | 22.11.2007 | | |
| **4** | Clara | 08.07.2008 | | |

**In C2 (Alter):**
```excel
=DATEDIF(B2; TODAY(); "y")
```

**In D2 (Geburtsmonat):**
```excel
=MONTH(B2)
```

Runterziehen.

---

### Datum-Arithmetik

Daten sind Zahlen, also kann man rechnen:

| Operation | Ergebnis |
|-----------|----------|
| `=TODAY() + 7` | In 7 Tagen |
| `=TODAY() - 7` | Vor 7 Tagen |
| `=B1 - A1` | Differenz in Tagen zwischen A1 und B1 |

---

## 4. Übersicht aller Funktionen

### Text-Funktionen

| Funktion | Syntax |
|----------|--------|
| `LEFT` | `=LEFT(Text; Anzahl)` |
| `RIGHT` | `=RIGHT(Text; Anzahl)` |
| `MID` | `=MID(Text; Start; Anzahl)` |
| `LEN` | `=LEN(Text)` |
| `TEXT` | `=TEXT(Wert; Format)` |
| `&` | `=A1 & " " & B1` |

### Datum-Funktionen

| Funktion | Syntax |
|----------|--------|
| `TODAY` | `=TODAY()` |
| `NOW` | `=NOW()` |
| `YEAR` | `=YEAR(Datum)` |
| `MONTH` | `=MONTH(Datum)` |
| `DAY` | `=DAY(Datum)` |
| `DATEDIF` | `=DATEDIF(Start; Ende; "Einheit")` |

---

## 5. Kata 1: String-Operationen (25 min)

Kata-Blätter zeigen.

---

## 6. Kata 2: Altersberechnung (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

### Text-Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `LEFT()` | Zeichen von links holen |
| `RIGHT()` | Zeichen von rechts holen |
| `MID()` | Zeichen aus der Mitte holen |
| `LEN()` | Länge zählen |
| `&` | Text zusammenfügen |

### Datum-Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `TODAY()` | Heutiges Datum |
| `DATEDIF()` | Differenz zwischen Daten |
| `YEAR/MONTH/DAY` | Datumsteile extrahieren |

**Wichtig:** Daten sind Zahlen in Excel!

### Ausblick

Nächste Woche: **Bedingte Formatierung & Diagramme**
