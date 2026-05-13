# Kata 1: Preissuche mit XLOOKUP

## Ziel

Lerne Werte aus einer Tabelle automatisch nachzuschlagen mit `XLOOKUP`.

## Das Szenario

Du hast zwei Tabellen:
1. **Preis-Liste**: Alle Artikel mit ihren Preisen (Stammdaten)
2. **Bestellung**: Was der Kunde bestellt

Statt Preise manuell abzutippen, holst du sie automatisch.

---

## Aufgabenstellung

### Schritt 1: Tabelle erstellen

Erstelle zuerst die **Preis-Liste** ab **Zeile 15**:

| | A | B |
|---|---|---|
| **15** | **Artikel** | **Preis (€)** |
| **16** | Notebook | 1299 |
| **17** | Maus | 49 |
| **18** | Monitor | 349 |
| **19** | Tastatur | 89 |
| **20** | Headset | 129 |
| **21** | Webcam | 79 |

Und nun die **Bestellung** ab **Zeile 1**:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | **Artikel** | **Menge** | **Preis (€)** | **Gesamt (€)** | |
| **2** | Maus | 3 | | | |
| **3** | Monitor | 2 | | | |
| **4** | Notebook | 1 | | | |
| **5** | Tastatur | 4 | | | |
| **6** | Headset | 2 | | | |
| **7** | | | | | |
| **8** | **Summe** | | | **=SUM(D2:D6)** | |

---

### Schritt 2: XLOOKUP lernen

`XLOOKUP` sucht einen Wert und gibt einen anderen Wert aus der selben Zeile zurück.

```excel
=XLOOKUP(Suchwert; Suchbereich; Rückgabebereich; [Wenn_nicht_gefunden])
```

**Beispiel:**
```excel
=XLOOKUP(A2; A16:A21; B16:B21)
```

Bedeutung:
- `A2` → Wonach suchen? ("Maus")
- `A16:A21` → Wo suchen? (Spalte mit den Artikelnamen)
- `B16:B21` → Was zurückgeben? (Spalte mit den Preisen)

---

### Schritt 3: Formel eintragen

**Aber Achtung: Absolutbezüge!**

Wenn du die Formel runterziehen willst, müssen die Preis-Listen-Bereiche **absolut** sein (mit `$`).

**In C2:**
```excel
=XLOOKUP(A2; $A$16:$A$21; $B$16:$B$21)
```

Das `$` vor dem Buchstaben und vor der Zahl macht:
- `$A$16:$A$21` → Dieser Bereich bleibt fest, auch wenn du runterziehst
- `A2` → Das ändert sich zu A3, A4, etc. (ist richtig so)

Jetzt ziehe die Formel von **C2 runter bis C6**.

---

### Schritt 4: Gesamtpreis berechnen

**In D2 (Gesamt):**
```excel
=B2*C2
```

Ziehe runter bis D6.

Die Summe in D8 sollte jetzt automatisch berechnet werden.

---

### Schritt 5: Testen

Ändere einen Preis in der Preis-Liste:
- Ändere in B16 (Notebook) den Preis von 1299 auf 1199

Was passiert mit der Bestellung?
→ Der Preis in C4 ändert sich automatisch!

Das ist der Vorteil von Suchen-Funktionen.

---

### Schritt 6: Mit "Wenn nicht gefunden"

Erweitere die Formel um eine Meldung falls der Artikel nicht existiert:

```excel
=XLOOKUP(A2; $A$16:$A$21; $B$16:$B$21; "Artikel nicht gefunden")
```

Teste es:
- Schreibe in A2 einen nicht vorhandenen Artikel wie `"Drucker"`

Was passiert?

---

## Kontrolle

Deine fertige Bestellung sollte so aussehen:

| Artikel | Menge | Preis (€) | Gesamt (€) |
|---------|-------|-----------|------------|
| Maus | 3 | 49 | 147 |
| Monitor | 2 | 349 | 698 |
| Notebook | 1 | 1299 | 1299 |
| Tastatur | 4 | 89 | 356 |
| Headset | 2 | 129 | 258 |
| | | | |
| **Summe** | | | **2758** |

---

## Zusammenfassung

| Funktion | Syntax |
|----------|--------|
| `XLOOKUP` | `=XLOOKUP(Suchwert; Suchbereich; Rückgabebereich)` |

**Wichtig:**
- `Suchbereich` = Wo soll gesucht werden? (nur die Such-Spalte)
- `Rückgabebereich` = Was soll zurückgegeben werden? (nur die Ergebnis-Spalte)
- Absolutbezüge mit `$` wenn du runterziehen willst

## Erweiterung (optional)

1. Füge einen neuen Artikel zur Preis-Liste hinzu:
   - Artikel: Drucker
   - Preis: 199

2. Füge die Bestellzeile hinzu:
   - Artikel: Drucker
   - Menge: 1

3. Funktioniert die Preissuche automatisch?

4. Recherchiere: Kann `XLOOKUP` auch **rückwärts** suchen?
   - Was wenn die Preis-Spalte LINKS und die Artikel-Spalte RECHTS ist?
   - Probier aus!
