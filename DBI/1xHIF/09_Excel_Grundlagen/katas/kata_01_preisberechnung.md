# Kata 1: Preisberechnung Netto/Brutto

## Ziel

Lerne einfache Formeln in Excel zu schreiben, mit `+`, `-`, `*`, `/` zu rechnen und Formeln runterzuziehen.

## Aufgabenstellung

Erstelle eine Tabelle für einen Online-Shop mit Preisberechnung.

---

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle in Excel:

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | **Artikel** | **Netto** | **Menge** | **Netto gesamt** | **MWST (20%)** | **Brutto gesamt** |
| **2** | Laptop | 899 | 1 | | | |
| **3** | Maus | 25 | 3 | | | |
| **4** | Tastatur | 45 | 2 | | | |
| **5** | Monitor | 299 | 1 | | | |
| **6** | | | | | | |
| **7** | **GESAMT** | | | | | |

So sieht das dann bei dir aus:
- In A1 schreibst du: `Artikel`
- In B1: `Netto`
- In C1: `Menge`
- In D1: `Netto gesamt`
- In E1: `MWST (20%)`
- In F1: `Brutto gesamt`

Und in die Zeilen darunter kommen die Werte.

---

### Schritt 2: Formeln erstellen

#### Netto gesamt (Spalte D)

Netto gesamt = Netto pro Artikel × Menge

1. Klicke auf Zelle **D2**
2. Schreibe: `=B2*C2`
3. Drücke `Enter`

**Erklärung:**
- `=` sagt Excel: "Jetzt kommt eine Formel!"
- `B2` bezieht sich auf den Netto-Preis (899)
- `*` bedeutet Multiplikation
- `C2` bezieht sich auf die Menge (1)

Jetzt steht in D2: `899`

**Jetzt das Geniale: Formel runterziehen!**

Du musst die Formel nicht für jede Zeile neu schreiben!

1. Klicke auf Zelle **D2** (sie ist markiert)
2. Suche am rechten unteren Rand der Zelle nach einem **kleinen Quadrat**
3. Wenn du mit der Maus darüber fährst, wird das Mauskreuz zu einem schwarzen Kreuz
4. **Klicke und ziehe** das Quadrat nach unten bis zu Zelle **D5**
5. Lasse los

Fertig! Excel hat die Formel automatisch angepasst:
- D2: `=B2*C2`
- D3: `=B3*C3` (automatisch!)
- D4: `=B4*C4` (automatisch!)
- D5: `=B5*C5` (automatisch!)

---

#### MWST (Spalte E)

MWST = Netto gesamt × 20%

20% kann man schreiben als:
- `20%`
- Oder: `0.2`

1. Klicke auf Zelle **E2**
2. Schreibe: `=D2*20%`
3. Drücke `Enter`
4. Ziehe runter bis E5

In E2 sollte jetzt stehen: `179,8`

---

#### Brutto gesamt (Spalte F)

Brutto = Netto + MWST

Oder direkt: Brutto = Netto × 1.2

**Variante A (einfacher zu verstehen):**
1. Klicke auf **F2**
2. Schreibe: `=D2+E2`
3. Enter
4. Runterziehen

**Variante B (direkter):**
1. Klicke auf **F2**
2. Schreibe: `=D2*1.2`
3. Enter
4. Runterziehen

Beide Varianten sind richtig!

---

### Schritt 3: Gesamtsumme

Jetzt die Gesamtsumme am Ende berechnen.

In Zelle **D7** (Gesamte Netto-Summe):
```excel
=D2+D3+D4+D5
```

Oder du verwendest `=SUM(D2:D5)` (das lernen wir später!).

Ziehe die Formel nach rechts bis F7, oder schreibe sie für E7 und F7 separat:

- E7: `=E2+E3+E4+E5`
- F7: `=F2+F3+F4+F5`

---

### Schritt 4: Testen

Teste, ob Excel automatisch neu berechnet!

1. Ändere in Zelle **C3** (Menge von Maus) die Menge von `3` auf `5`
2. Drücke Enter

Was passiert?
- D3 ändert sich
- E3 ändert sich
- F3 ändert sich
- Sogar die Gesamtsumme in Zeile 7 ändert sich!

**Excel berechnet automatisch neu, wenn sich Werte ändern!**

---

## Kontrolle

Deine Tabelle sollte am Ende so aussehen:

| Artikel | Netto | Menge | Netto gesamt | MWST 20% | Brutto gesamt |
|---------|-------|-------|--------------|----------|---------------|
| Laptop | 899 | 1 | 899 | 179,8 | 1078,8 |
| Maus | 25 | 3 | 75 | 15 | 90 |
| Tastatur | 45 | 2 | 90 | 18 | 108 |
| Monitor | 299 | 1 | 299 | 59,8 | 358,8 |
| | | | | | |
| **GESAMT** | | | **1363** | **272,6** | **1635,6** |

## Hinweise

- **Immer `=` am Anfang einer Formel!**
- `*` = Multiplikation (Mal), nicht `x`
- `/` = Division (Geteilt)
- `+` = Addition
- `-` = Subtraktion
- Kleines Quadrat rechts unten = Formel runterziehen
- **`Strg+S` zum Speichern nicht vergessen!**

## Erweiterung (optional)

Füge weitere Artikel hinzu oder ändere die MWST auf 10% (für Lebensmittel z.B.) und schaue, was passiert.

Oder: Füge eine Spalte "Rabatt" hinzu und berechne:
- Vor Rabatt: Brutto
- Rabatt: 10%
- Nach Rabatt: Brutto × 0.9
