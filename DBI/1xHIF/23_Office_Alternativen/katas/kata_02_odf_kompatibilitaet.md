# Kata 2: ODF Kompatibilität

## Ziel

Lerne, wie man eine ODS-Datei (Tabellenkalkulation) in LibreOffice Calc erstellt, als XLSX exportiert und die Kompatibilität mit Microsoft Excel testet.

---

## Aufgabenstellung

### Schritt 1: Tabelle in LibreOffice Calc erstellen

Starte **LibreOffice Calc** und erstelle folgende Tabelle:

| | A | B | C | D | E |
|---|---|---|---|---|---|
| **1** | **Produkt** | **Januar** | **Februar** | **März** | **Gesamt** |
| **2** | Laptop | 12.000 | 15.000 | 14.500 | |
| **3** | Maus | 3.500 | 4.200 | 3.800 | |
| **4** | Tastatur | 2.800 | 3.100 | 2.900 | |
| **5** | Monitor | 8.000 | 8.500 | 9.200 | |
| **6** | | | | | |
| **7** | **Gesamt** | | | | |
| **8** | **Durchschnitt** | | | | |
| **9** | **Maximum** | | | | |

---

### Schritt 2: Formeln eingeben

**Gesamt pro Produkt (Spalte E):**

In **E2**: `=SUM(B2:D2)` — ziehe runter bis **E5**

**Gesamt pro Monat (Zeile 7):**

In **B7**: `=SUM(B2:B5)` — ziehe rüber bis **D7**

**Durchschnitt pro Monat (Zeile 8):**

In **B8**: `=AVERAGE(B2:B5)` — ziehe rüber bis **D8**

**Maximum pro Monat (Zeile 9):**

In **B9**: `=MAX(B2:B5)` — ziehe rüber bis **D9**

**Gesamtsumme (Zelle E7):**

In **E7**: `=SUM(B2:D5)`

---

### Schritt 3: Formatierung

1. Formatiere die Zahlen als **Währung (€)**:
   - Markiere B2:D9
   - Rechtsklick → **Zellen formatieren**
   - Kategorie: **Währung**
   - Format: **€ 1.234,00**

2. Mache die Überschriften (Zeile 1) **fett**

3. Markiere die Ergebnis-Zeilen (7-9) mit einer **Hintergrundfarbe** (z.B. hellgrau)

4. Speichere als **umsaetze.ods**

---

### Schritt 4: Als XLSX exportieren

1. Gehe auf **Datei → Speichern unter**
2. Wähle als Dateityp: **Microsoft Excel (.xlsx)**
3. Dateiname: **umsaetze.xlsx**
4. **ACHTUNG:** Es erscheint eine Warnung zur Kompatibilität — lies sie!
   - Welche Formatierungen könnten verloren gehen?
   - Notiere die Warnung.

---

### Schritt 5: In Excel öffnen und testen

Öffne **umsaetze.xlsx** in Microsoft Excel.

**Teste folgende Punkte:**

| Test | Erwartet | OK? |
|------|----------|-----|
| Sind alle Zahlen korrekt? | Ja | ☐ |
| Funktionieren alle Formeln? | Ja | ☐ |
| Ist das Währungsformat erhalten? | Ja/Nein | ☐ |
| Sind die Hintergrundfarben da? | Ja/Nein | ☐ |
| Wird eine Kompatibilitätswarnung angezeigt? | Ja/Nein | ☐ |

**Dokumentiere** in einer Textdatei (`kompatibilitaet.txt`), was funktioniert und was nicht.

---

### Schritt 6: Umgekehrt testen (optional)

1. Erstelle eine neue Tabelle in **Excel**
2. Gib einige Werte und Formeln ein
3. Speichere als **xlsx**
4. Öffne die Datei in **LibreOffice Calc**
5. Funktioniert alles gleich?

---

## Hinweise

- LibreOffice Calc verwendet **Semikolon (;)** als Argumenttrenner in Formeln (Excel verwendet Komma)
- Die Kompatibilitätswarnung beim XLSX-Export zeigt an, welche Features nicht unterstützt werden
- Währungsformate werden oft korrekt übernommen, aber benutzerdefinierte Formate können verloren gehen
- Einige Excel-Funktionen (z.B. `XLOOKUP`) sind in Calc nicht verfügbar

## Erweiterung (optional)

1. Füge ein **Diagramm** in Calc hinzu und prüfe, ob es im XLSX erhalten bleibt
2. Teste **bedingte Formatierung** (grün/rot für Werte über/unter 5.000)
3. Öffne die ODS-Datei mit einem **Texteditor/Entpacker** (wie eine ZIP-Datei) und sieh dir die XML-Struktur an
