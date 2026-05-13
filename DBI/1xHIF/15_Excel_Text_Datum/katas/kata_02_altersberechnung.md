# Kata 2: Altersberechnung

## Ziel

Lerne mit Daten in Excel zu rechnen.

## Wichtig vorab: Daten in Excel

Excel speichert Daten als **Zahlen**:
- Tag 1 = 01.01.1900
- Heute = eine hohe Zahl

Deshalb kannst du mit Daten **rechnen**!

---

## Die Datum-Funktionen

| Funktion | Syntax | Was macht sie? |
|----------|--------|----------------|
| `TODAY` | `=TODAY()` | Heutiges Datum |
| `YEAR` | `=YEAR(Datum)` | Jahr extrahieren |
| `MONTH` | `=MONTH(Datum)` | Monat extrahieren (1-12) |
| `DAY` | `=DAY(Datum)` | Tag extrahieren (1-31) |
| `DATEDIF` | `=DATEDIF(Start; Ende; "Einheit")` | Differenz berechnen |

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | **Name** | **Geburtstag** | **Alter** | **Geburtsjahr** | **Geburtsmonat** | **Tage bis Geburtstag** |
| **2** | Anna | 15.03.2008 | | | | |
| **3** | Ben | 22.11.2007 | | | | |
| **4** | Clara | 08.07.2008 | | | | |
| **5** | David | 30.01.2009 | | | | |

---

### Schritt 2: TODAY ausprobieren

`=TODAY()` gibt das heutige Datum zurück.

Gib in eine leere Zelle ein:
```excel
=TODAY()
```

Es ändert sich jeden Tag automatisch!

---

### Schritt 3: Jahr, Monat, Tag extrahieren

```excel
=YEAR(Datum)    → Jahr
=MONTH(Datum)   → Monat (1-12)
=DAY(Datum)     → Tag (1-31)
```

**In D2 (Geburtsjahr):**
```excel
=YEAR(B2)
```

**In E2 (Geburtsmonat):**
```excel
=MONTH(B2)
```

Ziehe beide Formeln von **D2:E2 runter bis D5:E5**.

---

### Schritt 4: DATEDIF - Das Wichtigste!

`DATEDIF` berechnet die Differenz zwischen zwei Daten.

```excel
=DATEDIF(Startdatum; Enddatum; "Einheit")
```

Einheiten:
- `"y"` = Volle Jahre
- `"m"` = Volle Monate
- `"d"` = Volle Tage

**Alter berechnen:**
```excel
=DATEDIF(Geburtsdatum; Heute; "y")
```

**In C2 (Alter):**
```excel
=DATEDIF(B2; TODAY(); "y")
```

Ziehe runter bis C5.

---

### Schritt 5: Datum-Arithmetik

Da Daten Zahlen sind, kannst du rechnen:

**In 7 Tagen:**
```excel
=TODAY() + 7
```

**Vor 7 Tagen:**
```excel
=TODAY() - 7
```

**Differenz zwischen zwei Daten in Tagen:**
```excel
=B3 - B2
```

(Differenz zwischen Ben's und Anna's Geburtstag)

---

### Schritt 6: Tage bis zum nächsten Geburtstag (Schwer)

Logik:
1. Nimm den Geburtstag dieses Jahr
2. Wenn er schon vorbei ist, nimm nächsten Jahr
3. Berechne Differenz zu heute

**Einfache Version:**
```excel
=DATE(YEAR(TODAY()); MONTH(B2); DAY(B2)) - TODAY()
```

Problem: Wenn der Geburtstag dieses Jahr schon vorbei ist, ist das Ergebnis negativ.

**Bessere Version mit Prüfung:**
```excel
=IF(DATE(YEAR(TODAY()); MONTH(B2); DAY(B2)) >= TODAY();
    DATE(YEAR(TODAY()); MONTH(B2); DAY(B2)) - TODAY();
    DATE(YEAR(TODAY())+1; MONTH(B2); DAY(B2)) - TODAY())
```

Oder als Einzeiler:
```excel
=IF(DATE(YEAR(TODAY());MONTH(B2);DAY(B2))>=TODAY();DATE(YEAR(TODAY());MONTH(B2);DAY(B2))-TODAY();DATE(YEAR(TODAY())+1;MONTH(B2);DAY(B2))-TODAY())
```

---

## Kontrolle

Für 2026:

| Name | Geburtstag | Alter (2026) | Geburtsjahr | Geburtsmonat |
|------|------------|---------------|-------------|--------------|
| Anna | 15.03.2008 | 18 | 2008 | 3 |
| Ben | 22.11.2007 | 18 | 2007 | 11 |
| Clara | 08.07.2008 | 17 | 2008 | 7 |
| David | 30.01.2009 | 17 | 2009 | 1 |

---

## Zusammenfassung

| Funktion | Was macht sie? |
|----------|----------------|
| `=TODAY()` | Heutiges Datum |
| `=YEAR(Datum)` | Jahr extrahieren |
| `=MONTH(Datum)` | Monat extrahieren |
| `=DAY(Datum)` | Tag extrahieren |
| `=DATEDIF(Start; Ende; "y")` | Jahre zwischen Daten |

**Wichtig:** `DATEDIF("Start"; "Ende"; "Einheit")`

| Einheit | Bedeutung |
|---------|-----------|
| `"y"` | Jahre |
| `"m"` | Monate |
| `"d"` | Tage |

## Erweiterung (optional)

1. Füge eine Spalte "Alter in Monaten" hinzu:
   - `=DATEDIF(B2; TODAY(); "m")`

2. Füge eine Spalte "Alter in Tagen" hinzu:
   - `=DATEDIF(B2; TODAY(); "d")`

3. Füge eine Spalte "Nächster runder Geburtstag" hinzu:
   - Wann wird die Person 18, 21, 30?
   - `=DATE(YEAR(B2)+18; MONTH(B2); DAY(B2))`

4. (Schwer) Berechne den Wochentag des Geburtstags:
   - Recherchiere: `=WEEKDAY()` oder `=TEXT(Datum; "TTTT")`
   - `=TEXT(B2; "TTTT")`
