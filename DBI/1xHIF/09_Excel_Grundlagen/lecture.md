# Lecture: Woche 09 - Excel Grundlagen & Formeln

---

## 1. Wiederholung & Einstieg (15 min)

**Willkommen zurück nach den Ferien!**

Heute starten wir mit Excel.

**Erinnerung aus Digitale Grundbildung:**
- Excel ist ein Tabellenkalkulationsprogramm
- Viele kleine "Zellen"
- In jede Zelle kann man Zahlen, Text oder Formeln schreiben

### Excel-Interface kurz wiederholen

**Zeilen und Spalten:**
- Spalten: A, B, C, D... (oben)
- Zeilen: 1, 2, 3, 4... (links)
- **Zelle:** Schnittstelle aus Spalte und Zeile → `A1`, `B3`, `D17`

**Zelle markieren:** Einfach draufklicken

**Mehrere Zellen markieren:**
- Klicken und ziehen
- Oder: `Strg+A` für alles

**Blätter:**
- Unten: "Tabelle1", "Tabelle2"
- Kann man umbenennen: Rechtsklick → Umbenennen

---

## 2. Theorie: Formeln & Grundrechenarten (25 min)

### Das wichtigste Zeichen: `=`

In Excel fängt **JEDE Formel** mit einem Gleichheitszeichen an!

| ✅ Richtig | ❌ Falsch |
|-----------|-----------|
| `=A1+B1` | `A1+B1` |
| `=5*3` | `5*3` |

Ohne `=` denkt Excel, dass es Text ist.

### Grundrechenarten

| Was | Zeichen | Beispiel |
|-----|---------|----------|
| Addieren | `+` | `=2+3` |
| Subtrahieren | `-` | `=5-2` |
| Multiplizieren | `*` (Sternchen) | `=4*5` |
| Dividieren | `/` (Schrägstrich) | `=10/2` |
| Potenzieren | `^` (Dach) | `=5^2` (5 hoch 2 = 25) |

**Wichtig:** Multiplikation ist `*` (NICHT `x`!)

---

### Live-Demo: Einfache Berechnungen

Tabelle am Beamer:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | Preis | Menge | Gesamt | |
| **2** | 10 | 5 | `=A2*B2` | |
| **3** | 20 | 3 | | |

**Schritt für Schritt:**
1. Klicke auf Zelle `C2`
2. Schreibe: `=A2*B2`
3. Drücke `Enter`
4. Fertig! → Steht da `50`

**Jetzt mit Zellbezügen statt festen Werten:**
- `=A2*B2` ist besser als `=10*5`
- Weil: Wenn sich der Preis ändert, ändert sich automatisch das Ergebnis!

**Test:** Ändere A2 von 10 auf 15 → C2 ändert sich automatisch auf 75!

---

## 3. Theorie: Operatorenrangfolge & Füllen (20 min)

### Punkt vor Strich

Wie in der Mathematik.

| Rechenart | Reihenfolge |
|-----------|-------------|
| `()` Klammern | Höchste Priorität |
| `^` Potenz | |
| `*` `/` | |
| `+` `-` | Niedrigste Priorität |

**Beispiele:**

| Formel | Ergebnis | Erklärung |
|--------|----------|-----------|
| `=2+3*4` | 14 | Erst `3*4=12`, dann `2+12=14` |
| `=(2+3)*4` | 20 | Klammern zuerst: `2+3=5`, dann `5*4=20` |
| `=10/2+3` | 8 | Erst `10/2=5`, dann `5+3=8` |
| `=10/(2+3)` | 2 | Klammern zuerst: `2+3=5`, dann `10/5=2` |

**Merke:** Wenn du eine bestimmte Reihenfolge willst → Klammern verwenden!

---

### Der absolute Hammer: Formel runterziehen

**Situation:**
```
|   A    |  B  |     C     |
|--------|-----|-----------|
| Preis  | Menge| Gesamt    |
|   10   |  5  |  =A2*B2   |
|   20   |  3  |           |
|   15   |  4  |           |
|   25   |  2  |           |
```

Ich muss die Formel `=A2*B2` nicht für jede Zeile neu schreiben!

**So geht's:**

1. Klicke auf Zelle `C2` (wo die Formel drin ist)
2. Suche das **kleine Quadrat** am rechten unteren Rand der Zelle
3. **Klicke und ziehe** es nach unten (bis C5)
4. Fertig!

**Was macht Excel?**
- In `C3`: `=A3*B3` (automatisch angepasst!)
- In `C4`: `=A4*B4`
- In `C5`: `=A5*B5`

**Genial!** Spart sehr viel Zeit!

---

### Weitere Fülloptionen

Kleine Möglichkeiten mit der Füllfunktion:

1. **Datenreihe automatisch erstellen:**
   - Schreibe `1` in A1
   - Schreibe `2` in A2
   - Markiere A1:A2
   - Ziehe nach unten → 1, 2, 3, 4, 5...

2. **Tage, Monate:**
   - Schreibe `Montag`
   - Ziehe nach unten → Montag, Dienstag, Mittwoch...
   - Oder: `Januar`, `Februar`, `März`...

---

## 4. Kata 1: Preisberechnung (20 min)

Kata-Blätter zeigen.

Aufgabe: Eine kleine Tabelle mit Preisen, Mengen, Bruttoberechnung.

---

## 5. Kata 2: Rechenregeln (20 min)

Kata-Blätter zeigen.

Aufgabe: Komplexere Formeln mit Operatorenrangfolge und Klammern.

---

## Wichtige Shortcuts

| Shortcut | Aktion |
|----------|--------|
| `Enter` | Formel bestätigen, eine Zeile runter |
| `Strg+S` | Speichern! |
| `Strg+Z` | Rückgängig |
| `Strg+Y` | Wiederherstellen |
| `Esc` | Eingabe abbrechen |

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| `=` | Jede Formel fängt damit an! |
| `+` `-` `*` `/` `^` | Grundrechenarten |
| Punkt vor Strich | Operatorenrangfolge |
| `()` Klammern | Bestimmen selbst die Reihenfolge |
| Kleines Quadrat ziehen | Formel runter/rechts kopieren |
| `Strg+S` | **Immer wieder speichern!** |

### Ausblick

Nächste Woche: **Bezüge** (relativ vs. absolut mit `$`)
