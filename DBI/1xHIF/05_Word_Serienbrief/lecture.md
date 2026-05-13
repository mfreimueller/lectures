# Lecture: Woche 05 - Word Serienbrief

---

## 1. Wiederholung (10 min)

Quick-Quiz:

1. "Voraussetzung für automatisches Inhaltsverzeichnis?" → **Überschriften-Stile!**
2. "Tastenkürzel für Überschrift 1?" → `Strg+Alt+1`
3. "Wie aktualisiere ich ein Inhaltsverzeichnis?" → Rechtsklick → Feld aktualisieren oder `F9`

---

## 2. Theorie: Serienbrief Konzept (15 min)

### Problem-Story

**Ich habe ein Problem:**

Ich muss 50 Einladungen zum Schulfest verschicken.

Alle 50 Einladungen sind fast gleich:
- Datum des Schulfests: Gleich
- Ort: Gleich
- Text: Gleich

Aber:
- `Herr/Frau [Nachname]` ist anders
- Adresse ist anders
- "Sehr geehrter Herr" vs. "Sehr geehrte Frau"

**Wie löse ich das?**

**Möglichkeit A (schlecht):**
- Ein Dokument erstellen
- 50 mal kopieren
- In jedem Kopie Namen und Adresse von Hand ändern

→ **Probleme:** Langsam, Fehleranfällig, spätere Korrekturen mühsam

**Möglichkeit B (gut):**
- **Serienbrief!**

---

### Was ist ein Serienbrief?

**Analogie:** Ausfüllbogen

Stell dir vor, du hast:
1. **Ein leeres Formular** (der "Brief-Rumpf" mit allen festen Texten)
2. **Einen Stapel Zettel** mit jeweils den Daten von einer Person

Der Serienbrief macht jetzt:
- Nimmt Formular
- Nimmt Zettel 1 → Schreibt die Daten ins Formular → Fertig
- Nimmt Zettel 2 → Schreibt die Daten ins Formular → Fertig
- ...
- Nimmt Zettel 50 → Schreibt die Daten ins Formular → Fertig

### Die drei Komponenten

| Name | Erklärung |
|------|-----------|
| **1. Hauptdokument** | Der Brief mit festem Text. Da kommen Platzhalter rein: `<<Name>>` |
| **2. Datenquelle** | Eine Tabelle mit allen individuellen Daten (Excel, Word, Outlook...) |
| **3. Zusammenführung** | Word kombiniert automatisch: 1 Zeile aus Tabelle = 1 fertiger Brief |

### Live-Demo: Mini-Serienbrief

**Datenquelle (Beispiel):**

| Vorname | Nachname | Geschlecht | Ort |
|---------|----------|------------|-----|
| Max | Mustermann | m | Wien |
| Anna | Beispiel | w | Graz |
| Peter | Test | m | Linz |

**Hauptdokument:**
```
Sehr geehrter <<Nachname>>,

hiermit laden wir Sie zum Schulfest nach <<Ort>> ein.

...
```

**Zusammengeführt (3 fertige Briefe):**

Brief 1:
```
Sehr geehrter Mustermann,

hiermit laden wir Sie zum Schulfest nach Wien ein.
```

Brief 2:
```
Sehr geehrte Beispiel,

hiermit laden wir Sie zum Schulfest nach Graz ein.
```

Brief 3:
```
Sehr geehrter Test,

hiermit laden wir Sie zum Schulfest nach Linz ein.
```

---

## 3. Theorie: Serienbrief-Assistent (35 min)

Menü: **Sendungen**

### Schritt für Schritt Demo

#### 1. Vorbereitung: Daten in Excel

Erstelle oder öffne eine Excel-Tabelle:

| Name | Adresse | PLZ | Ort | Geschlecht |
|------|---------|-----|-----|------------|
| Herr Max Mustermann | Hauptstraße 1 | 1010 | Wien | m |
| Frau Anna Beispieldame | Nebenstraße 5 | 8010 | Graz | w |

**Wichtig:**
- Erste Zeile = Spaltennamen (Überschriften)
- Ab dann = Daten
- Leere Zeilen vermeiden
- Speichern!

#### 2. In Word: Serienbrief starten

1. Neues Dokument oder Brief-Text schreiben
2. Menü: **Sendungen**
3. **Starten des Seriendrucks** → **Schritt-für-Schritt-Seriendruck-Assistent**

**Assistent geht auf auf der rechten Seite auf:**

**Schritt 1 (von 6): Dokumenttyp wählen**
- Briefe (für Papier-Briefe)
- E-Mail-Nachrichten (für Versand per E-Mail)
- Etiketten
- Umschläge
- Katalog

Wir wählen: **Briefe**

**Schritt 2: Ausgangsdokument**
- Aktuelles Dokument verwenden
- Oder: Vorlage oder anderes Dokument

Wir wählen: **Aktuelles Dokument verwenden**

**Schritt 3: Empfänger auswählen**
- Eine vorhandene Liste verwenden → Wir nehmen unsere Excel-Tabelle!
- Aus Outlook-Kontakten wählen
- Neue Liste eingeben

Wir wählen: **Durchsuchen...** → Excel-Datei auswählen

**Dialog "Tabelle auswählen":**
- Wähle das Arbeitsblatt aus, wo die Daten drin sind
- Haken: "Erste Datenzeile enthält Spaltenüberschriften" → WICHTIG!

**Jetzt: "Empfänger zusammenfassen" Dialog**
- Hier kannst du:
  - Empfänger abwählen (Haken entfernen)
  - Sortieren
  - Filtern
- OK

**Schritt 4: Serienbrief-Felder einfügen**

Jetzt kannst du Platzhalter in deinen Text einfügen:

Optionen:
1. **Adressblock:** Ein fertiger Baustein für die Adresse
2. **Grußzeile:** Ein fertiger Baustein für die Anrede
3. **Serienbrief einfügen:** Einzelne Felder: `<<Vorname>>`, `<<Nachname>>`, etc.

**Demo:**
- Klicke an die Stelle im Text, wo die Adresse soll
- **Adressblock** → Aussehen konfigurieren → OK
- Klicke an die Stelle für die Anrede
- **Grußzeile** → Konfigurieren: "Sehr geehrter Herr/Frau..."
- Optional: Einzelne Felder mit **Serienbrief einfügen**

**Was passiert jetzt?**
- Du siehst Platzhalter wie `«Adressblock»` oder `«Vorname»`
- Noch keine echten Namen!

**Schritt 5: Vorschau anzeigen**

Jetzt auf **"Vorschau anzeigen"** klicken im Assistenten.

Oder: Menü Sendungen → **Vorschau der Ergebnisse**

Jetzt solltest du sehen:
- Statt `«Adressblock»` steht jetzt eine echte Adresse
- Mit den Pfeilen (<<, >>) kannst du durch alle Datensätze blättern

Überprüfe: Passt alles?

**Schritt 6: Zusammenführen**

Fertig! Jetzt kannst du:

1. **In einzelne Dokumente zusammenführen:**
   - Jeder Brief wird ein eigenes Dokument
   - Oder: Alle in einem Dokument (pro Seite ein Brief)
   - Gute Wahl, wenn du nachbearbeiten möchtest

2. **Drucken:**
   - Direkt an den Drucker

3. **Als E-Mail senden:**
   - Wenn E-Mail-Feld in Datenquelle ist

**Wir wählen:** "In einzelne Dokumente zusammenführen"

**Dialog:**
- Alle
- Oder: Nur bestimmte Datensätze

→ Word erstellt ein neues Dokument mit allen Briefen!

---

## 4. Theorie: Serienbrief-Regeln (10 min)

Manchmal brauchst du "Wenn-Dann" im Serienbrief.

Beispiel:
- Wenn `Geschlecht = "m"` → "Sehr geehrter Herr"
- Wenn `Geschlecht = "w"` → "Sehr geehrte Frau"

Oder:
- Wenn `Rabatt` > 10% → Extra-Text: "Sie erhalten einen Sonderrabatt!"

Menü: **Sendungen → Regeln**

Mögliche Regeln:
- Wenn...dann...Sonst...
- Nächstes Datensatz wenn
- Nur wenn
- etc.

**Kurz-Demo:** Einfache Wenn-Dann-Regel.

---

## 5. Kata 1: Einladungs-Serienbrief (25 min)

Kata-Blätter zeigen.

Hinweise:
- Zuerst die Excel-Daten erstellen
- Dann in Word den Serienbrief starten
- Assistent Schritt für Schritt durchgehen

---

## 6. Kata 2: Serienbrief mit Regeln (20 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| Serienbrief | Ein Text + Viele Daten = Viele fertige Briefe |
| Hauptdokument | Der "Rumpf"-Brief mit Platzhaltern |
| Datenquelle | Tabelle mit individuellen Daten (Excel, Word...) |
| Sendungen → Seriendruck-Assistent | Schritt für Schritt zum Ziel |
| Vorschau der Ergebnisse | Prüfen, ob alles passt |
| In einzelne Dokumente zusammenführen | Fertigstellen

### Ausblick

Nächste Woche: **PLÜ**!

Danach (nach Ferien): Lebenslauf, Bewerbungsschreiben
