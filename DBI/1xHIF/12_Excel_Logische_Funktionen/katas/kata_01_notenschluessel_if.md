# Kata 1: Notenschlüssel mit IF

## Ziel

Lerne Entscheidungen in Excel mit `IF()`, `IFS()`, und Vergleichsoperatoren.

## Die Vergleichsoperatoren

Zuerst: Wie vergleicht man Werte?

| Operator | Bedeutung | Beispiel |
|----------|-----------|----------|
| `=` | Gleich | `A1=100` |
| `<>` | Ungleich | `A1<>0` |
| `>` | Größer als | `A1>50` |
| `<` | Kleiner als | `A1<50` |
| `>=` | Größer oder gleich | `A1>=90` |
| `<=` | Kleiner oder gleich | `A1<=50` |

---

## Aufgabenstellung

Wandle Punkte in Noten und Text-Beurteilungen um.

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | **Student** | **Punkte** | **Note (1-5)** | **Texturteil** | **Bestanden?** |
| **2** | Anna Müller | 88 | | | |
| **3** | Ben Schmidt | 65 | | | |
| **4** | Clara Weber | 45 | | | |
| **5** | David Bauer | 92 | | | |
| **6** | Eva Huber | 52 | | | |
| **7** | Felix Mayer | 28 | | | |

---

### Notenschlüssel

Nach diesem Schlüssel soll ausgewertet werden:

| Punkte | Note | Texturteil |
|--------|------|------------|
| >= 88 | 1 | Sehr gut |
| >= 75 | 2 | Gut |
| >= 63 | 3 | Befriedigend |
| >= 50 | 4 | Genügend |
| < 50 | 5 | Nicht genügend |

---

### Schritt 2: Die IF-Funktion

Die wichtigste Funktion für Entscheidungen:

```excel
=IF(Bedingung; Dann-Wert; Sonst-Wert)
```

**Einfaches Beispiel:**
```excel
=IF(B2>=50; "Bestanden"; "Nicht bestanden")
```

Wenn B2 >= 50 ist: "Bestanden"
Sonst: "Nicht bestanden"

---

### Schritt 3: Note berechnen (Spalte C)

Für eine Note von 1-5 brauchen wir **mehrere Bedingungen**.

Es gibt zwei Möglichkeiten:

#### Möglichkeit A: Verschachteltes IF

Man kann `IF()` in `IF()` "verschachteln":

```excel
=IF(B2>=88; 1; IF(B2>=75; 2; IF(B2>=63; 3; IF(B2>=50; 4; 5))))
```

#### Möglichkeit B: IFS (einfacher lesen!)

Seit Excel 2019 gibt es `IFS()`:

```excel
=IFS(B2>=88; 1; B2>=75; 2; B2>=63; 3; B2>=50; 4; WAHR; 5)
```

`IFS()` prüft der Reihe nach:
- Ist B2 >= 88? Dann 1
- Sonst: Ist B2 >= 75? Dann 2
- Sonst: Ist B2 >= 63? Dann 3
- Sonst: Ist B2 >= 50? Dann 4
- Sonst (`WAHR` ist immer wahr): 5

**Entscheide dich für eine Variante und schreibe sie in Zelle C2.**

Ziehe dann die Formel von C2 runter bis C7.

---

### Schritt 4: Texturteil (Spalte D)

Gleich wie Note, aber mit Text statt Zahlen:

In **D2**:
```excel
=IFS(B2>=88; "Sehr gut"; B2>=75; "Gut"; B2>=63; "Befriedigend"; B2>=50; "Genügend"; WAHR; "Nicht genügend")
```

Ziehe runter bis D7.

---

### Schritt 5: Bestanden? (Spalte E)

Einfaches `IF` für die Frage "Hat die Person bestanden?"

In **E2**:
```excel
=IF(B2>=50; "Ja"; "Nein")
```

Ziehe runter bis E7.

---

### Schritt 6: Testen

Teste, ob deine Formeln funktionieren:

1. Ändere in **B2** (Anna) die Punkte von `88` auf `87`
   - Was passiert mit Note?
   - Was passiert mit Texturteil?

2. Ändere in **B4** (Clara) die Punkte von `45` auf `50`
   - Was passiert mit "Bestanden?"

---

## Kontrolle

Deine fertige Tabelle sollte so aussehen:

| Student | Punkte | Note | Texturteil | Bestanden? |
|---------|--------|------|------------|------------|
| Anna Müller | 88 | 1 | Sehr gut | Ja |
| Ben Schmidt | 65 | 3 | Befriedigend | Ja |
| Clara Weber | 45 | 5 | Nicht genügend | Nein |
| David Bauer | 92 | 1 | Sehr gut | Ja |
| Eva Huber | 52 | 4 | Genügend | Ja |
| Felix Mayer | 28 | 5 | Nicht genügend | Nein |

---

## Zusammenfassung

| Funktion | Was macht sie? |
|----------|----------------|
| `IF(Bed; Dann; Sonst)` | Einfache Wenn-Dann-Entscheidung |
| `IFS(Bed1; D1; Bed2; D2; ...)` | Mehrere Bedingungen der Reihe nach |
| Vergleichsoperatoren | `=`, `<>`, `>`, `<`, `>=`, `<=` |

## Erweiterung (optional)

1. Füge eine Spalte "Runde" hinzu:
   - Runde >= 70: "Aufsteiger"
   - Runde >= 50: "Bestanden"
   - Sonst: "Nicht bestanden"

2. Füge eine weitere Person hinzu:
   - Name: Lisa
   - Punkte: 74
   - Welche Note bekommt sie?
