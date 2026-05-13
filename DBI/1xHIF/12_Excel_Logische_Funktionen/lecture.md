# Lecture: Woche 12 - Excel Logische Funktionen

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] Excel offen

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Welche Funktion berechnet den Durchschnitt?" → `AVERAGE()`
2. "Was ist der Unterschied zwischen `COUNT()` und `COUNTA()`?" → `COUNT` zählt nur Zahlen, `COUNTA` zählt alle nicht-leeren Zellen
3. "Was bedeutet `A1:A5`?" → Bereich von A1 bis A5
4. "Wie gibt man den kleinsten Wert zurück?" → `MIN()`

---

## 2. Theorie: Logische Funktionen (30 min)

### Vergleichsoperatoren

Zuerst: Wie vergleicht man Werte in Excel?

| Operator | Bedeutung | Beispiel |
|----------|-----------|----------|
| `=` | Gleich | `A1=100` |
| `<>` | Ungleich | `A1<>0` |
| `>` | Größer als | `A1>50` |
| `<` | Kleiner als | `A1<50` |
| `>=` | Größer oder gleich | `A1>=90` |
| `<=` | Kleiner oder gleich | `A1<=50` |

**Wichtig:**
- Vergleiche ergeben entweder `WAHR` oder `FALSCH`
- `=A1>50` → Wenn A1=75, dann ist das Ergebnis `WAHR`
- `=A1=100` → Wenn A1=99, dann ist das Ergebnis `FALSCH`

---

### Die IF-Funktion (Wenn-Dann)

Die wichtigste logische Funktion:

```
=IF(Bedingung; Dann-Wert; Sonst-Wert)
```

**Aufbau:**
1. `Bedingung` → etwas, das `WAHR` oder `FALSCH` ergibt
2. `Dann-Wert` → was passiert, wenn Bedingung wahr ist
3. `Sonst-Wert` → was passiert, wenn Bedingung falsch ist

**Einfaches Beispiel:**

| | A |
|---|---|
| **1** | 75 |

```excel
=IF(A1>=50; "Bestanden"; "Nicht bestanden")
```

Ergebnis: `"Bestanden"` (weil 75 >= 50)

**Noch ein Beispiel:**

| | A | B |
|---|---|---|
| **1** | Punkte | 75 |

```excel
=IF(B1>=90; "Sehr gut"; IF(B1>=80; "Gut"; "Genügend"))
```

Dieses Konzept nennt man **verschachteltes IF**.

---

### Live-Demo 1: Noten

Erstelle am Beamer:

| | A | B | C |
|---|---|---|---|
| **1** | Student | Punkte | Note |
| **2** | Anna | 88 | |
| **3** | Ben | 65 | |
| **4** | Clara | 45 | |

**In C2:**
```excel
=IF(B2>=50; "Bestanden"; "Nicht bestanden")
```

Runterziehen auf C3, C4.

Ergebnis:
- Anna: Bestanden
- Ben: Bestanden
- Clara: Nicht bestanden

---

### Verschachteltes IF für Notenstufen

Angenommen:
- >= 90 → "Sehr gut"
- >= 80 → "Gut"
- >= 70 → "Befriedigend"
- >= 50 → "Genügend"
- < 50 → "Nicht genügend"

```excel
=IF(B2>=90; "Sehr gut"; IF(B2>=80; "Gut"; IF(B2>=70; "Befriedigend"; IF(B2>=50; "Genügend"; "Nicht genügend"))))
```

Man liest es von innen nach außen.

---

### IFS: Einfacher bei vielen Bedingungen

Seit Excel 2019 gibt es `IFS()`:

```excel
=IFS(Bedingung1; Dann1; Bedingung2; Dann2; Bedingung3; Dann3; ...)
```

Das Gleiche wie oben, aber lesbarer:

```excel
=IFS(B2>=90; "Sehr gut"; B2>=80; "Gut"; B2>=70; "Befriedigend"; B2>=50; "Genügend"; WAHR; "Nicht genügend")
```

**Wichtig:** `IFS` prüft der Reihe nach. Die erste wahre Bedingung gewinnt.

Das letzte `WAHR; "Nicht genügend"` ist der "Sonst-Fall".

---

### AND, OR, NOT

Manchmal braucht man mehrere Bedingungen gleichzeitig.

#### AND: Alle Bedingungen müssen wahr sein

```excel
=AND(Bedingung1; Bedingung2; Bedingung3; ...)
```

Beispiel: "Hat Anna BEIDE Tests bestanden?"

```excel
=AND(B2>=50; C2>=50)
```

Ergebnis:
- Wenn beide >= 50 → `WAHR`
- Wenn auch nur einer < 50 → `FALSCH`

#### OR: Mindestens eine Bedingung wahr

```excel
=OR(Bedingung1; Bedingung2; ...)
```

Beispiel: "Hat Anna in mindestens einem Test über 90 Punkte?"

```excel
=OR(B2>90; C2>90)
```

Ergebnis:
- Wenn mindestens einer > 90 → `WAHR`
- Wenn beide <= 90 → `FALSCH`

#### NOT: Bedingung umkehren

```excel
=NOT(Bedingung)
```

Beispiel:
```excel
=NOT(B2>=50)
```
→ Das Gleiche wie `B2<50`

---

### Kombiniert: IF + AND/OR

"Wenn Anna BEIDE Tests bestanden hat, dann 'Kompetent', sonst 'Wiederholung nötig':"

```excel
=IF(AND(B2>=50; C2>=50); "Kompetent"; "Wiederholung nötig")
```

"Wenn Anna in MINDESTENS einem Test über 90 ist, dann 'Auszeichnung':"

```excel
=IF(OR(B2>90; C2>90); "Auszeichnung"; "Keine Auszeichnung")
```

---

### Live-Demo 2: Bonusberechnung

Tabelle am Beamer:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | Mitarbeiter | Verkauf | Abwesenheit | Bonus |
| **2** | Anna | 12500 | 0 | |
| **3** | Ben | 8000 | 2 | |
| **4** | Clara | 15000 | 1 | |

Regeln:
- Bonus = 10% des Verkaufs, ABER
- Nur wenn Verkauf >= 10.000 UND Abwesenheit = 0

In D2:
```excel
=IF(AND(B2>=10000; C2=0); B2*0.1; 0)
```

Ergebnis:
- Anna: 1250 (10% von 12500)
- Ben: 0 (Verkauf zu niedrig)
- Clara: 0 (war abwesend)

---

## 3. Kata 1: Notenschlüssel mit IF (25 min)

Kata-Blätter zeigen.

---

## 4. Kata 2: Bonusberechnung (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Vergleichsoperatoren | `=`, `<>`, `>`, `<`, `>=`, `<=` |
| `IF()` | Wenn-Dann-Entscheidung |
| `IFS()` | Mehrere Bedingungen der Reihe nach |
| `AND()` | Alle Bedingungen müssen wahr sein |
| `OR()` | Mindestens eine Bedingung wahr |
| `NOT()` | Bedingung umkehren |
| Verschachtelung | `IF()` in `IF()` |

### Alle Funktionen im Überblick

| Funktion | Aufbau |
|----------|--------|
| `IF` | `=IF(Bedingung; Dann; Sonst)` |
| `IFS` | `=IFS(Bed1; Dann1; Bed2; Dann2; ...)` |
| `AND` | `=AND(Bed1; Bed2; ...)` |
| `OR` | `=OR(Bed1; Bed2; ...)` |
| `NOT` | `=NOT(Bedingung)` |

### Ausblick

Nächste Woche: **Bereichsfunktionen** (`SUMIF`, `COUNTIF`, etc.)
