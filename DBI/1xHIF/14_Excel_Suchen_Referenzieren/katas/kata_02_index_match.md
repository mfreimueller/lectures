# Kata 2: INDEX/MATCH für flexible Suche

## Ziel

Lerne das mächtige Duo `INDEX` + `MATCH` - die flexibelste Art zu suchen in Excel.

## Die zwei Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `MATCH` | Findet die **Position** (Zeilennummer) eines Werts |
| `INDEX` | Holt den **Wert** an einer bestimmten Position |

Zusammen ergeben sie eine super flexible Suchfunktion!

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

Artikel-Tabelle mit mehreren Spalten ab **Zeile 15**:

| | A | B | C | D |
|---|---|---|---|---|
| **15** | **Artikel** | **Preis** | **Lagerbestand** | **Lieferzeit** |
| **16** | Notebook | 1299 | 5 | 3 Tage |
| **17** | Maus | 49 | 120 | 1 Tag |
| **18** | Monitor | 349 | 12 | 2 Tage |
| **19** | Tastatur | 89 | 45 | 1 Tag |
| **20** | Headset | 129 | 23 | 2 Tage |

Und die Suchmaske ab **Zeile 1**:

| | A | B | C |
|---|---|---|---|
| **1** | **Suche nach:** | | |
| **2** | Artikel | Monitor | |
| **3** | | | |
| **4** | **Ergebnis:** | | |
| **5** | Preis | | |
| **6** | Lagerbestand | | |
| **7** | Lieferzeit | | |

---

### Schritt 2: MATCH verstehen

`MATCH` sucht einen Wert und sagt dir: **In welcher Zeile steht er?**

```excel
=MATCH(Suchwert; Suchbereich; 0)
```

Die `0` am Ende bedeutet: **genaue Suche**.

**Probier es in einer leeren Zelle:**
```excel
=MATCH(B2; A16:A20; 0)
```

B2 = "Monitor"
A16:A20 = Die Artikel-Spalte

Ergebnis: `3`

Warum? Weil "Monitor" in der **3. Zeile** des Bereichs A16:A20 steht:
- Zeile 1: Notebook
- Zeile 2: Maus
- Zeile 3: Monitor ←
- Zeile 4: Tastatur
- Zeile 5: Headset

---

### Schritt 3: INDEX verstehen

`INDEX` macht das Gegenteil: Du sagst ihm **"gehe zu Zeile X"** und er gibt dir den Wert.

```excel
=INDEX(Bereich; Zeile)
```

**Probier es:**
```excel
=INDEX(B16:B20; 3)
```

B16:B20 = Die Preis-Spalte
3 = Zeile 3

Ergebnis: `349`

Weil in der 3. Zeile von B16:B20 der Preis 349 steht.

---

### Schritt 4: Kombiniert: INDEX + MATCH

Jetzt kombinieren wir beide:

1. `MATCH` findet: In welcher Zeile steht "Monitor"? → Zeile 3
2. `INDEX` holt: Was steht in Zeile 3 der Preis-Spalte? → 349

**In B5 (Preis):**
```excel
=INDEX(B16:B20; MATCH(B2; A16:A20; 0))
```

**Schritt für Schritt:**
```excel
=INDEX(B16:B20; MATCH("Monitor"; A16:A20; 0))
=INDEX(B16:B20; 3)
=349
```

---

### Schritt 5: Weitere Felder

Jetzt die anderen Spalten:

**In B6 (Lagerbestand):**
```excel
=INDEX(C16:C20; MATCH(B2; A16:A20; 0))
```

**In B7 (Lieferzeit):**
```excel
=INDEX(D16:D20; MATCH(B2; A16:A20; 0))
```

---

### Schritt 6: Testen

Jetzt das Coole! Ändere den Such-Artikel in **B2**:

- Schreibe `"Maus"` statt `"Monitor"`
- Schreibe `"Notebook"`
- Schreibe `"Headset"`

Was passiert mit den Ergebnissen in B5, B6, B7?

→ Sie aktualisieren sich automatisch!

---

### Schritt 7: Der große Vorteil von INDEX/MATCH

`VLOOKUP` hat eine große Einschränkung: Die Suchspalte muss die **erste Spalte** sein.

Was wenn unsere Tabelle so aussähe?

| | A | B |
|---|---|---|
| **1** | **Preis** | **Artikel** |
| **2** | 1299 | Notebook |
| **3** | 49 | Maus |

Hier wäre:
- Preis-Spalte = LINKS
- Artikel-Spalte = RECHTS

`VLOOKUP` würde **nicht** funktionieren!

`INDEX/MATCH` funktioniert **immer**:

```excel
=INDEX(A2:A3; MATCH("Notebook"; B2:B3; 0))
```

→ Ergebnis: `1299`

Versuche es! INDEX/MATCH kann in **beide Richtungen** suchen.

---

### Schritt 8: Fehlerbehandlung

Wenn du nach einem Artikel suchst, der nicht existiert, bekommst du `#N/A`.

Mit `IFERROR` kannst du das abfangen:

```excel
=IFERROR(INDEX(B16:B20; MATCH(B2; A16:A20; 0)); "Nicht gefunden")
```

Teste es: Schreibe `"Drucker"` in B2.

---

## Kontrolle

Wenn du nach `"Monitor"` suchst:

| Feld | Wert |
|------|------|
| Preis | 349 |
| Lagerbestand | 12 |
| Lieferzeit | 2 Tage |

Wenn du nach `"Maus"` suchst:

| Feld | Wert |
|------|------|
| Preis | 49 |
| Lagerbestand | 120 |
| Lieferzeit | 1 Tag |

---

## Zusammenfassung

| Funktion | Syntax | Was macht sie? |
|----------|--------|----------------|
| `MATCH` | `=MATCH(Suchwert; Bereich; 0)` | Findet die Zeilennummer |
| `INDEX` | `=INDEX(Bereich; Zeile)` | Holt den Wert |
| Kombiniert | `=INDEX(Rückgabe; MATCH(Suche; Bereich; 0))` | Flexible Suche |

### Vergleich der Suchmethoden

| Methode | Einfachheit | Flexibilität | Kompatibilität |
|---------|-------------|--------------|----------------|
| `VLOOKUP` | Sehr einfach | Niedrig | Alle Versionen |
| `XLOOKUP` | Einfach | Hoch | Excel 2021+ |
| `INDEX/MATCH` | Etwas komplex | Sehr hoch | Alle Versionen |

## Erweiterung (optional)

1. Füge weitere Artikel zur Tabelle hinzu

2. Füge eine Spalte "Kategorie" hinzu und erweitere die Suche:
   - Kann INDEX/MATCH auch nach Kategorie suchen?

3. Recherchiere: Was ist `HLOOKUP`?
   - Wofür wird es verwendet?
   - Gibt es auch `HLOOKUP` + `INDEX/MATCH`?

4. (Schwer) Kann INDEX/MATCH auch in **zwei Dimensionen** suchen?
   - Suche nach Artikel UND nach Feld (Preis, Lager, etc.)
