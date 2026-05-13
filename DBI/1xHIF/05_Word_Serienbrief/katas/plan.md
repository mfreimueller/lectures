# Katas - Woche 05: Word Serienbrief

---

## Kata 1: Einladungs-Serienbrief aus Excel

| Feld | Wert |
|------|------|
| Konzepte | Excel als Datenquelle, Serienbrief-Assistent, Adressblock, Grußzeile |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle einen Serienbrief für 5 fiktive Gäste zum Schulfest.

#### Schritt 1: Excel-Daten erstellen

1. Öffne Excel
2. Erstelle folgende Tabelle (erste Zeile = Spaltennamen!):

| Anrede | Vorname | Nachname | Strasse | PLZ | Ort | Geschlecht |
|--------|---------|----------|---------|-----|-----|------------|
| Herr | Max | Mustermann | Hauptstr. 1 | 1010 | Wien | m |
| Frau | Anna | Beispieldame | Nebenstr. 5 | 8010 | Graz | w |
| Herr | Peter | Testmann | Testweg 12 | 4020 | Linz | m |
| Frau | Maria | Müller | Musterplatz 3 | 5020 | Salzburg | w |
| Herr | Hans | Huber | Gartenweg 7 | 6020 | Innsbruck | m |

3. Speichere die Excel-Datei unter einem Namen deiner Wahl
4. Schließe Excel (Wichtig: Manchmal gibt es sonst Berechtigungsprobleme!)

#### Schritt 2: Word-Hauptdokument erstellen

1. Neues Word-Dokument
2. Schreibe folgenden Brief-Text (oder eigenen Text):

```
[Hier kommt die Adresse - Platzhalter später]

[Hier kommt die Anrede - Platzhalter später]

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

3. Speichere das Word-Dokument

#### Schritt 3: Serienbrief-Assistent starten

1. Menü: **Sendungen**
2. **Starten des Seriendrucks** → **Schritt-für-Schritt-Seriendruck-Assistent**

Gehe den Assistenten Schritt für Schritt durch:

**Schritt 1:** Dokumenttyp wählen → **Briefe**

**Schritt 2:** Ausgangsdokument → **Aktuelles Dokument verwenden**

**Schritt 3:** Empfänger auswählen:
- **Durchsuchen...**
- Wähle deine gespeicherte Excel-Datei
- Wähle das Arbeitsblatt aus
- **WICHTIG:** Hake an: "Erste Datenzeile enthält Spaltenüberschriften"
- OK
- Im nächsten Dialog: Prüfe, ob alle 5 Empfänger mit Haken markiert sind → OK

**Schritt 4:** Serienbrief-Felder einfügen:

1. Klicke im Text an die Stelle, wo die Adresse sein soll (oben)
2. Rechts im Assistenten: **Adressblock...**
3. Konfiguriere das Aussehen → OK

4. Klicke im Text an die Stelle, wo die Anrede sein soll
5. Rechts im Assistenten: **Grußzeile...**
6. Wähle: "Sehr geehrter Herr X / Sehr geehrte Frau Y" → OK

**Schritt 5:** Vorschau anzeigen:

Klicke auf **"Vorschau anzeigen"** im Assistenten.

Oder: Menü **Sendungen → Vorschau der Ergebnisse**

Blättere mit den Pfeilen (<< / >>) durch alle 5 Datensätze.

Prüfe:
- Passt die Anrede? ("Sehr geehrter Herr" / "Sehr geehrte Frau")
- Passt die Adresse?

**Schritt 6:** Zusammenführen:

Klicke im Assistenten auf **"In einzelne Dokumente zusammenführen"**.

Wähle: **Alle**

→ Word erstellt ein NEUES Dokument mit allen 5 Briefen!

#### Schritt 4: Überprüfen

Das neue Dokument sollte 5 Seiten haben:
- Seite 1: Herr Mustermann, Wien
- Seite 2: Frau Beispieldame, Graz
- Seite 3: Herr Testmann, Linz
- Seite 4: Frau Müller, Salzburg
- Seite 5: Herr Huber, Innsbruck

Jeder Brief hat individuelle Anrede und Adresse, aber der Rest ist gleich.

### Hinweise

- Excel vor dem Serienbrief starten SCHLIESSEN! Sonst kann Word nicht darauf zugreifen
- Erste Zeile in Excel = Spaltennamen (Überschriften)
- Immer zuerst Vorschau machen, bevor zusammengeführt wird
- "In einzelne Dokumente zusammenführen" = fertige Briefe mit echten Daten

---

## Kata 2: Serienbrief mit Wenn-Dann-Regeln

| Feld | Wert |
|------|------|
| Konzepte | Serienbrief-Regeln (Wenn-Dann), bedingter Text |
| Schwierigkeit | 3/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erweitere den vorherigen Serienbrief mit einer Wenn-Dann-Regel.

Situation:
- Gäste aus WIEN bekommen einen Zusatz-Hinweis: "Parkplätze sind sehr begrenzt - kommen Sie bitte mit den Öffis!"
- Gäste aus anderen Orten bekommen diesen Hinweis NICHT

Oder (wenn du neu anfängst):

#### Schritt 1: Neue Excel-Tabelle mit Spalte "Bemerkung"

Erstelle oder erweitere deine Excel-Tabelle:

| Vorname | Nachname | Ort | Bemerkung |
|---------|----------|-----|-----------|
| Max | Mustermann | Wien | Premium-Gast |
| Anna | Beispieldame | Graz | Standard |
| Peter | Testmann | Wien | Premium-Gast |
| Maria | Müller | Salzburg | Standard |

#### Schritt 2: Serienbrief starten

Starte wie gewohnt einen Serienbrief mit dieser Datenquelle.

Schreibe einen Brief-Text, z.B.:

```
[Adresse]
[Anrede]

wir freuen uns auf Ihren Besuch.

[HIER KOMMT DIE REGEL]

Mit freundlichen Grüßen
```

#### Schritt 3: Wenn-Dann-Regel einfügen

1. Klicke im Text an die Stelle, wo der bedingte Text soll
2. Menü: **Sendungen → Regeln → Wenn...Dann...Sonst...**

3. Einstellungen im Dialog:
   - **Feldname:** Ort (oder Bemerkung)
   - **Vergleich:** gleich
   - **Vergleichswert:** Wien (oder Premium-Gast)
   - **Dann diesen Text einfügen:** "Als Gast aus Wien erhalten Sie einen kostenlosen Getränkegutschein!"
   - **Sonst diesen Text einfügen:** (Leer lassen oder Standard-Text)

4. OK

#### Schritt 4: Testen

1. **Vorschau der Ergebnisse** aktivieren
2. Durch die Datensätze blättern
3. Prüfe:
   - Bei "Wien" Gästen: Extra-Text erscheint
   - Bei anderen: Extra-Text erscheint NICHT

#### Schritt 5: Zusammenführen

"In einzelne Dokumente zusammenführen" und prüfe das Ergebnis.

### Hinweise für den Lehrer

- Regeln finden sich unter: Sendungen → Regeln
- Wichtig: Datenquelle muss das entsprechende Feld haben (z.B. "Ort", "Bemerkung")
- Bei komplexeren Regeln: Verschachtelte Wenn-Dann
- Alternative: "Nur wenn"-Regel

### Weitere Regel-Möglichkeiten (Demo)

Weitere nützliche Regeln:
- **Nächstes Datensatz wenn:** Überspringt Datensatz unter bestimmter Bedingung
- **Nur wenn:** Zeigt Text nur wenn Bedingung erfüllt
- **Merke:** Speichert einen Wert zwischen
- **Füge Text ein:** Fügt festen Text ein
