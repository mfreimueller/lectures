# Kata 2: Bonusberechnung mit AND/OR

## Ziel

Lerne logische Verknüpfungen mit `AND()` und `OR()`.

## Die wichtigsten Logik-Funktionen

| Funktion | Was macht sie? |
|----------|----------------|
| `AND(Bed1; Bed2; ...)` | **Alle** Bedingungen müssen wahr sein |
| `OR(Bed1; Bed2; ...)` | **Mindestens eine** Bedingung muss wahr sein |

**Beispiele:**

```excel
=AND(A1>=50; B1>=50)
```
→ `WAHR` nur wenn BEIDE >= 50 sind.

```excel
=OR(A1>90; B1>90)
```
→ `WAHR` wenn mindestens einer > 90 ist.

---

## Aufgabenstellung

Berechne Mitarbeiter-Boni mit mehreren Bedingungen.

### Schritt 1: Tabelle erstellen

Erstelle folgende Tabelle:

| | A | B | C | D | E | F |
|---|---|---|---|---|---|---|
| **1** | **Mitarbeiter** | **Verkauf** | **Abwesenh.** | **Kunden** | **Bonus 10%** | **Extra-Bonus** |
| **2** | Anna | 12500 | 0 | 45 | | |
| **3** | Ben | 8000 | 2 | 38 | | |
| **4** | Clara | 15000 | 1 | 52 | | |
| **5** | David | 9500 | 0 | 60 | | |
| **6** | Eva | 18000 | 0 | 41 | | |

---

### Die Regeln

**Bonus 10% (Spalte E):**
- 10% des Verkaufsbetrages
- ABER: Nur wenn...
  - Verkauf >= 10.000 Euro
  - UND
  - Abwesenheit = 0 Tage
- Sonst: 0 Euro

**Extra-Bonus (Spalte F):**
- 500 Euro Extra
- ABER: Nur wenn...
  - Verkauf >= 15.000 Euro
  - ODER
  - Kunden >= 50
- Sonst: 0 Euro

---

### Schritt 2: Bonus 10% berechnen

Wir brauchen `AND()` weil **BEIDE** Bedingungen erfüllt sein müssen:

- Verkauf >= 10.000 **UND** Abwesenheit = 0

In Zelle **E2**:
```excel
=IF(AND(B2>=10000; C2=0); B2*0.1; 0)
```

**Erklärung:**
1. `AND(B2>=10000; C2=0)` → Prüft beide Bedingungen
2. Wenn `WAHR`: `B2*0.1` (also 10% des Verkaufs)
3. Wenn `FALSCH`: `0`

Ziehe die Formel von **E2 runter bis E6**.

---

### Schritt 3: Extra-Bonus berechnen

Wir brauchen `OR()` weil **mindestens eine** Bedingung erfüllt sein muss:

- Verkauf >= 15.000 **ODER** Kunden >= 50

In Zelle **F2**:
```excel
=IF(OR(B2>=15000; D2>=50); 500; 0)
```

**Erklärung:**
1. `OR(B2>=15000; D2>=50)` → Prüft ob mindestens eine Bedingung wahr ist
2. Wenn `WAHR`: `500`
3. Wenn `FALSCH`: `0`

Ziehe die Formel von **F2 runter bis F6**.

---

### Schritt 4: Verstehe die Ergebnisse

Geh jede Person durch und verstehe, warum welcher Bonus berechnet wurde:

**Anna (Zeile 2):**
- Verkauf 12500 >= 10000? → Ja
- Abwesenheit 0 = 0? → Ja
- → Bonus 10% = 1250
- Verkauf 12500 >= 15000? → Nein
- Kunden 45 >= 50? → Nein
- → Extra = 0

**Ben (Zeile 3):**
- Verkauf 8000 >= 10000? → Nein
- → Bonus = 0
- Verkauf 8000 >= 15000? → Nein
- Kunden 38 >= 50? → Nein
- → Extra = 0

**Clara (Zeile 4):**
- Verkauf 15000 >= 10000? → Ja
- Abwesenheit 1 = 0? → Nein
- → Bonus = 0 (weil AND: BEIDE müssen wahr sein!)
- Verkauf 15000 >= 15000? → Ja
- → Extra = 500

**David (Zeile 5):**
- Verkauf 9500 >= 10000? → Nein
- → Bonus = 0
- Verkauf 9500 >= 15000? → Nein
- Kunden 60 >= 50? → Ja
- → Extra = 500 (weil OR reicht eine!)

**Eva (Zeile 6):**
- Verkauf 18000 >= 10000? → Ja
- Abwesenheit 0 = 0? → Ja
- → Bonus = 1800
- Verkauf 18000 >= 15000? → Ja
- → Extra = 500

---

## Kontrolle

Deine fertige Tabelle sollte so aussehen:

| Mitarbeiter | Verkauf | Abwesenh. | Kunden | Bonus 10% | Extra-Bonus |
|-------------|---------|-----------|--------|-----------|-------------|
| Anna | 12500 | 0 | 45 | 1250 | 0 |
| Ben | 8000 | 2 | 38 | 0 | 0 |
| Clara | 15000 | 1 | 52 | 0 | 500 |
| David | 9500 | 0 | 60 | 0 | 500 |
| Eva | 18000 | 0 | 41 | 1800 | 500 |

---

## Zusammenfassung

| Funktion | Bedeutung |
|----------|-----------|
| `AND(Bed1; Bed2)` | **Beide** müssen wahr sein |
| `OR(Bed1; Bed2)` | **Mindestens eine** muss wahr sein |
| `IF(AND(...); Dann; Sonst)` | Kombiniert |
| `IF(OR(...); Dann; Sonst)` | Kombiniert |

**Merke:**
- `AND` = UND-Verknüpfung (eng)
- `OR` = ODER-Verknüpfung (locker)

## Erweiterung (optional)

1. Füge eine Spalte "Gesamtbonus" (E+F) hinzu

2. Ändere die Regeln für Bonus 10%:
   - Verkauf >= 10.000
   - UND Abwesenheit = 0
   - UND Kunden >= 40

3. Was ändert sich bei Anna und Eva?
   - Anna: Kunden 45 >= 40? → Ja
   - Eva: Kunden 41 >= 40? → Ja

4. (Schwer) Füge einen "Super-Bonus" hinzu:
   - 1000 Euro
   - Wenn: Verkauf >= 15.000 UND Abwesenheit = 0 UND Kunden >= 50
   - Wer bekommt ihn?
