# Kata 1: String-Operationen

## Ziel

Lerne Text zu bearbeiten mit `LEFT`, `RIGHT`, `MID`, `LEN`.

## Die wichtigsten Text-Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `=LEFT(Text; N)` | Die ersten N Zeichen von links |
| `=RIGHT(Text; N)` | Die letzten N Zeichen von rechts |
| `=MID(Text; Start; N)` | N Zeichen ab Position "Start" |
| `=LEN(Text)` | Die Anzahl der Zeichen |
| `&` | Text zusammenfügen |

**Wichtig:** Die erste Position ist 1, nicht 0!

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

| | A | B | C | D | E | F | G |
|---|---|---|---|---|---|---|---|
| **1** | **Kompletter Name** | **PLZ Ort** | **E-Mail** | **Vorname** | **Nachname** | **PLZ** | **User** |
| **2** | Anna Müller | 1010 Wien | a.mueller@htl.at | | | | |
| **3** | Ben Schmidt | 1100 Wien | b.schmidt@htl.at | | | | |
| **4** | Clara Weber | 1200 Wien | c.weber@htl.at | | | | |
| **5** | David Bauer | 1210 Wien | d.bauer@htl.at | | | | |

---

### Schritt 2: LEFT - Vorname extrahieren

`LEFT` holt Zeichen von **links**.

```excel
=LEFT(Text; Anzahl_Zeichen)
```

**Beispiel:**
```excel
=LEFT("Anna Müller"; 4)
```

Ergebnis: `"Anna"`

**In D2 (Vorname):**
```excel
=LEFT(A2; 4)
```

Ziehe die Formel von **D2 runter bis D5**.

Was passiert mit den anderen Namen?
- "Ben Schmidt" → "Ben" (nur 3 Zeichen, also "Ben")
- "Clara Weber" → "Clar" (ersten 4)
- "David Bauer" → "Davi" (ersten 4)

---

### Schritt 3: LEFT nochmal - PLZ extrahieren

Die PLZ in Spalte B steht am **Anfang**: "1010 Wien"

Wir brauchen die ersten 4 Zeichen.

**In F2 (PLZ):**
```excel
=LEFT(B2; 4)
```

Ziehe runter bis F5.

Ergebnis:
- "1010"
- "1100"
- "1200"
- "1210"

---

### Schritt 4: LEN - Länge zählen

`LEN` zählt die Zeichen.

```excel
=LEN(Text)
```

**Probier es in einer leeren Zelle:**
```excel
=LEN("Hallo")
```
→ 5

```excel
=LEN(A2)
```
→ 11 ("Anna Müller" hat 11 Zeichen, inkl. Leerzeichen!)

Zähle die Zeichen: A-n-n-a-_-M-ü-l-l-e-r = 11

---

### Schritt 5: MID - Zeichen aus der Mitte

`MID` holt Zeichen aus der **Mitte**.

```excel
=MID(Text; Startposition; Anzahl_Zeichen)
```

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

### Schritt 6: Text zusammenfügen mit `&`

Mit `&` kannst du mehrere Texte zu einem verbinden.

```excel
=A2 & " " & B2
```

Oder mit eigenem Text dazwischen:

```excel
="Name: " & A2
```

**Versuche:** Erstelle "Nachname, Vorname"

```excel
=RIGHT(A2; 6) & ", " & LEFT(A2; 4)
```

Ergebnis für Anna: `"Müller, Anna"`

---

## Kontrolle

Deine Tabelle sollte so aussehen:

| Kompletter Name | PLZ Ort | E-Mail | Vorname (4 Zeichen) | PLZ |
|-----------------|---------|--------|---------------------|-----|
| Anna Müller | 1010 Wien | a.mueller@htl.at | Anna | 1010 |
| Ben Schmidt | 1100 Wien | b.schmidt@htl.at | Ben | 1100 |
| Clara Weber | 1200 Wien | c.weber@htl.at | Clar | 1200 |
| David Bauer | 1210 Wien | d.bauer@htl.at | Davi | 1210 |

---

## Zusammenfassung

| Funktion | Syntax | Beispiel |
|----------|--------|----------|
| `LEFT` | `=LEFT(Text; N)` | `=LEFT(A1; 3)` |
| `RIGHT` | `=RIGHT(Text; N)` | `=RIGHT(A1; 4)` |
| `MID` | `=MID(Text; Start; N)` | `=MID(A1; 2; 3)` |
| `LEN` | `=LEN(Text)` | `=LEN(A1)` |
| `&` | `=A1 & B1` | `=A1 & ", " & B1` |

## Erweiterung (optional)

1. Recherchiere: Was macht `FIND()` oder `SEARCH()`?
   - Wie kann man die Position eines Zeichens (z.B. des Leerzeichens) finden?
   - Damit könnte man den Vornamen automatisch finden, egal wie lang er ist!

2. Versuche: Extrahiere den User aus der E-Mail (alles vor dem @)
   - E-Mail: "a.mueller@htl.at"
   - User: "a.mueller"

3. Füge weitere Namen zur Tabelle hinzu und teste die Formeln

4. (Schwer) Kannst du den Nachnamen automatisch extrahieren (alles nach dem Leerzeichen)?
   - Tipp: `FIND(" "; A2)` gibt die Position des Leerzeichens
   - Dann: `MID(A2; Position+1; LEN(A2)-Position)`
