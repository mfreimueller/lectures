# Kata 1: Einladungs-Serienbrief aus Excel

## Ziel

Lerne einen Serienbrief mit Excel als Datenquelle zu erstellen.

## Aufgabenstellung

Erstelle einen Serienbrief für 5 fiktive Gäste zum Schulfest.

---

### Schritt 1: Excel-Daten erstellen

Erstelle zuerst die Datenquelle in Excel.

1. Öffne Excel
2. Erstelle folgende Tabelle:

**WICHTIG:** Erste Zeile = Spaltennamen (Überschriften)!

| Anrede | Vorname | Nachname | Strasse | PLZ | Ort | Geschlecht |
|--------|---------|----------|---------|-----|-----|------------|
| Herr | Max | Mustermann | Hauptstr. 1 | 1010 | Wien | m |
| Frau | Anna | Beispieldame | Nebenstr. 5 | 8010 | Graz | w |
| Herr | Peter | Testmann | Testweg 12 | 4020 | Linz | m |
| Frau | Maria | Müller | Musterplatz 3 | 5020 | Salzburg | w |
| Herr | Hans | Huber | Gartenweg 7 | 6020 | Innsbruck | m |

3. Speichere die Excel-Datei:
   - Datei → Speichern unter
   - Name: `Gastliste.xlsx`
   - Merke dir, wo du sie speicherst!

4. **WICHTIG:** Schließe Excel jetzt!
   - Wenn Excel offen bleibt, kann Word oft nicht auf die Datei zugreifen
   - Erst schließen, dann mit Word weitermachen

---

### Schritt 2: Word-Hauptdokument erstellen

1. Neues Word-Dokument
2. Schreibe folgenden Text (oder gestalte deinen eigenen Text):

```
[Hier kommt später die Adresse]

[Hier kommt später die Anrede]

wir laden Sie und Ihre Familie herzlich zu unserem jährlichen Schulfest ein.

Das Fest findet statt am:
  Datum: 15. Juni 2026
  Uhrzeit: 14:00 Uhr
  Ort: HTL Spengergasse

Wir freuen uns auf Ihren Besuch!

Mit freundlichen Grüßen

[Dein Name]
Schulsprecher/in
```

3. Speichere das Word-Dokument als `Einladung_Serienbrief.docx`

---

### Schritt 3: Serienbrief-Assistent starten

Jetzt verbinden wir das Word-Dokument mit der Excel-Datei.

1. Menü: **Sendungen**
2. Klicke auf: **Starten des Seriendrucks**
3. Wähle: **Schritt-für-Schritt-Seriendruck-Assistent**

Auf der rechten Seite öffnet sich der Assistent. Gehe ihn Schritt für Schritt durch:

---

#### Schritt 1 (von 6): Dokumenttyp wählen

- Wähle: **Briefe**
- Klicke unten: **Weiter >**

---

#### Schritt 2: Ausgangsdokument

- Wähle: **Aktuelles Dokument verwenden**
- Klicke: **Weiter >**

---

#### Schritt 3: Empfänger auswählen

Hier wählen wir die Excel-Datei als Datenquelle:

1. Wähle: **Eine vorhandene Liste verwenden**
2. Klicke: **Durchsuchen...**
3. Suche deine gespeicherte Excel-Datei (`Gastliste.xlsx`)
4. Wähle sie aus und klicke **Öffnen**

**Dialog "Tabelle auswählen" erscheint:**
- Wähle das Arbeitsblatt aus (meist: `Tabelle1$` oder `Gastliste$`)
- **WICHTIG:** Hake an: **"Erste Datenzeile enthält Spaltenüberschriften"**
- Klicke **OK**

**Dialog "Empfänger zusammenfassen" erscheint:**
- Hier siehst du alle 5 Gäste aus der Excel-Datei
- Alle sollten einen Haken haben
- Du könntest jetzt hier Empfänger abwählen, sortieren oder filtern
- Klicke **OK**

- Klicke unten: **Weiter >**

---

#### Schritt 4: Serienbrief-Felder einfügen

Jetzt fügen wir die Platzhalter in den Text ein.

**Erstens: Adressblock**

1. Klicke im Text an die Stelle, wo später die Adresse steht (ganz oben)
2. Klicke im Assistenten rechts: **Adressblock...**
3. Im Dialog kannst du das Aussehen der Adresse konfigurieren
4. Klicke **OK**

Jetzt steht im Text: `«Adressblock»`

**Zweitens: Grußzeile**

1. Klicke im Text an die Stelle, wo die Anrede steht
2. Klicke im Assistenten rechts: **Grußzeile...**
3. Konfiguriere:
   - Für "Herr": "Sehr geehrter Herr"
   - Für "Frau": "Sehr geehrte Frau"
4. Klicke **OK**

Jetzt steht im Text: `«Grußzeile»`

- Klicke unten: **Weiter >**

---

#### Schritt 5: Vorschau anzeigen

Jetzt prüfen wir, ob alles passt!

1. Klicke im Assistenten: **Vorschau anzeigen**

Oder alternativ:
- Menü **Sendungen → Vorschau der Ergebnisse** (Button klicken, sodass er hervorgehoben ist)

Jetzt solltest du sehen:
- Statt `«Adressblock»` steht jetzt eine echte Adresse
- Statt `«Grußzeile»` steht jetzt "Sehr geehrter Herr Mustermann:"

Blättere durch alle Datensätze:
- Menü Sendungen: Pfeile >> und << für "Nächster Datensatz", "Vorheriger Datensatz"
- Oder im Assistenten: Pfeile klicken

Prüfe:
- Alle 5 Gäste sollten da sein
- Anrede sollte passen ("Herr" oder "Frau")
- Adressen sollten korrekt sein

- Klicke unten: **Weiter >**

---

#### Schritt 6: Zusammenführen

Endspurt: Die fertigen Briefe erstellen!

Du hast mehrere Optionen:

| Option | Was passiert |
|--------|--------------|
| **In einzelne Dokumente zusammenführen** | Neues Word-Dokument mit allen Briefen (gut zum Nachbearbeiten) |
| **Drucken** | Direkt an Drucker senden |
| **E-Mail senden** | Per E-Mail verschicken (braucht E-Mail-Feld in Daten) |

Wir wählen: **In einzelne Dokumente zusammenführen**

1. Klicke darauf
2. Dialog "Zusammenführen in neues Dokument":
   - Wähle: **Alle**
   - OK

Word erstellt jetzt ein **NEUES Dokument** mit allen 5 Briefen!

---

### Schritt 4: Ergebnis prüfen

Das neue Dokument sollte haben:
- **Seite 1:** Herr Mustermann aus Wien
- **Seite 2:** Frau Beispieldame aus Graz
- **Seite 3:** Herr Testmann aus Linz
- **Seite 4:** Frau Müller aus Salzburg
- **Seite 5:** Herr Huber aus Innsbruck

Jeder Brief hat:
- Individuelle Adresse
- Individuelle Anrede
- Aber: Der Rest des Textes ist gleich

**Geschafft!** 🎉

Speichere das Ergebnis als `Einladung_Fertig.docx`

---

## Hinweise

- **Excel schließen:** Immer Excel schließen, bevor Word auf die Datei zugreift! Sonst gibt es oft Fehler.
- **Erste Zeile in Excel:** Muss immer die Spaltennamen (Überschriften) enthalten
- **Vorschau:** IMMER erst Vorschau machen, bevor zusammengeführt wird!
- **"In einzelne Dokumente zusammenführen":** Das ist die sicherste Option, weil du vor dem Drucken noch einmal prüfen kannst

## Erweiterung (optional)

### Versuche auch:

1. **Andere Felder einfügen:**
   - Menü Sendungen → **Serienbrief einfügen**
   - Wähle ein einzelnes Feld wie `«Vorname»` oder `«Ort»`
   - Füge es im Text ein: `"Liebe/r «Vorname»,"`

2. **Sortieren/Filtern:**
   - Vor der Zusammenführung: Menü Sendungen → **Empfängerliste bearbeiten**
   - Sortiere nach Namen oder PLZ
   - Filtere: Nur Gäste aus "Wien" anzeigen

3. **Eigene Felder:**
   - Füge in Excel eine neue Spalte hinzu: `Rabatt`
   - Trage Werte ein: "10%", "15%", etc.
   - Füge das Feld `«Rabatt»` im Serienbrief ein
