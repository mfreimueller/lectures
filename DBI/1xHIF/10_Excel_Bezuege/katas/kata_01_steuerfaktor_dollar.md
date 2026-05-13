# Kata 1: Steuerfaktor mit $

## Ziel

Lerne den Unterschied zwischen relativen und absoluten Bezügen in Excel.

## Das Problem

Angenommen du hast diese Tabelle:

| | A | B | C |
|---|---|---|---|
| **1** | **Netto** | **Steuerfaktor 1.2** | **Brutto** |
| **2** | 100 | | `=A2*B1` |
| **3** | 200 | | |

Wenn du die Formel `=A2*B1` von A2 runterziehst auf A3...

...wird daraus `=A3*B2`!

Aber B2 ist leer! Der Steuerfaktor war in B1, aber Excel hat "1" zu "2" hochgezählt.

**Lösung: `$` Dollarzeichen!**

## Aufgabenstellung

Erstelle eine Tabelle mit festem Steuerfaktor in einer extra Zelle.

---

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle:

| | A | B | C | D |
|---|---|---|---|---|
| **1** | **Artikel** | **Netto** | **MWST 20%** | **Brutto** |
| **2** | Laptop | 899 | | |
| **3** | Maus | 25 | | |
| **4** | Tastatur | 45 | | |
| **5** | Monitor | 299 | | |
| **6** | | | | |
| **7** | **Steuerfaktor:** | **1.2** | | |

Der Steuerfaktor 1.2 bedeutet: 100% Netto + 20% MWST = 120% des Nettopreises = Brutto.

---

### Schritt 2: Falsch vs. Richtig

#### Versuch A (FALSCH):

Schreibe in D2: `=B2*B7`

Ziehe runter auf D3 bis D5.

**Was passiert?**
- D2: `=B2*B7` ✓
- D3: `=B3*B8` ✗ (B8 ist leer!)
- D4: `=B4*B9` ✗
- D5: `=B5*B10` ✗

Excel hat den Bezug `B7` mitgezählt: `B7` → `B8` → `B9` → `B10`

Das wollen wir **NICHT**!

#### Versuch B (RICHTIG):

Schreibe in D2: `=B2*$B$7`

Die `$`-Zeichen sagen Excel:
- `$B` = Spalte B soll **NICHT** geändert werden
- `$7` = Zeile 7 soll **NICHT** geändert werden

Also ist der Bezug auf `B7` **absolut** (fest), der Bezug auf `B2` ist **relativ** (ändert sich).

Ziehe runter auf D3 bis D5.

**Was passiert jetzt?**
- D2: `=B2*$B$7` ✓
- D3: `=B3*$B$7` ✓ (`B3` hat sich geändert, `$B$7` bleibt!)
- D4: `=B4*$B$7` ✓
- D5: `=B5*$B$7` ✓

Perfekt!

---

### Schritt 3: F4-Taste (der Zeitsparer!)

Du musst das `$` nicht von Hand schreiben!

1. Schreibe: `=B2*`
2. Klicke auf Zelle `B7` (in der Formel steht jetzt `B7`)
3. Drücke die Taste **`F4`**

**Tada!** `B7` wird automatisch zu `$B$7`!

Wenn du `F4` mehrmals drückst, durchschaltest du verschiedene Varianten:

| `F4` drücken | Ergebnis | Bedeutung |
|---------------|----------|-----------|
| 1. Mal | `$B$7` | Komplett absolut (Spalte und Zeile fest) |
| 2. Mal | `B$7` | Nur Zeile 7 fest |
| 3. Mal | `$B7` | Nur Spalte B fest |
| 4. Mal | `B7` | Komplett relativ |
| 5. Mal | `$B$7` | Wieder von vorne |

**Probier es aus!** `F4` ist superpraktisch!

---

### Schritt 4: MWST berechnen (Spalte C)

In Spalte C soll nur die Steuer (also die 20%) berechnet werden, nicht das gesamte Brutto.

In C2:
```excel
=B2*($B$7-1)
```

Warum `$B$7-1`?
- `$B$7` = 1.2
- `$B$7-1` = 0.2 = 20%

Oder einfacher:
```excel
=B2*0.2
```

Oder auch:
```excel
=D2-B2
```
(Brutto minus Netto = Steuer)

Ziehe runter.

---

### Schritt 5: Test: Faktor ändern

Der Clou an Referenzen:

Ändere in `B7` den Steuerfaktor von `1.2` auf `1.1`.

Was passiert?
- **Alle** berechneten Werte in C und D ändern sich automatisch!

Das ist der Vorteil von Referenzen statt "harter Codierung" von Werten in Formeln.

---

## Zusammenfassung

| Bezug | Was passiert beim Runterziehen? |
|-------|----------------------------------|
| `B7` | Wird zu `B8`, `B9`, ... |
| `$B$7` | Bleibt **immer** `$B$7` |
| `B$7` | Zeile 7 bleibt, Spalte ändert sich |
| `$B7` | Spalte B bleibt, Zeile ändert sich |

| Taste | Wirkung |
|-------|---------|
| `F4` | Schaltet zwischen den verschiedenen Bezugsarten um |

**Merksatz:**
- Ohne `$` = relativ = ändert sich
- Mit `$` = absolut = bleibt fest

## Erweiterung (optional)

1. Füge einen neuen Artikel hinzu
2. Füge einen "Rabatt"-Faktor in einer weiteren Zelle hinzu
3. Berechne: Netto × Steuerfaktor × Rabattfaktor
4. Teste, ob alle Bezüge stimmen, wenn du runterziehst
