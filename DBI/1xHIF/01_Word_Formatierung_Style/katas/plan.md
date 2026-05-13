# Katas - Woche 01: Word Formatierung & Stile

---

## Kata 1: Protokoll mit Stilen formatieren

| Feld | Wert |
|------|------|
| Konzepte | Integrierte Stile: Überschrift 1/2/3, Standard (Fließtext) |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Ein Schulprotokoll soll mit den integrierten Word-Stilen konsistent formatiert werden.

Gegebener Text (kopieren und in Word einfügen):

```
Protokoll Klassenvorstandssitzung

Ort: Klassenzimmer 3.21
Datum: 12.05.2026
Anwesend: Schülervertreter, Lehrervertreter
Protokollführer: Max M.

1. Tagesordnung

1.1 Begrüßung
Der Klassenvorstand begrüßt alle Anwesenden. Es wird auf die Pünktlichkeit hingewiesen.

1.2 Protokoll letzte Sitzung
Das Protokoll der letzten Sitzung vom 28.04.2026 wurde genehmigt.

1.3 Neue Themen
1.3.1 Fahrtenwoche
Es wird über die Fahrtenwoche im Juni diskutiert. Kostenpunkt: ca. 150 Euro pro Schüler/in.

1.3.2 Projektwoche
Die Projektwoche findet im Herbst statt. Themenvorschläge werden gesammelt.

2. Sonstiges
Nächste Sitzung: 09.06.2026

Ende des Protokolls
```

Schritte:
1. Füge den Text in ein neues Word-Dokument ein
2. Formatieren mit folgenden Stilen:
   - "Protokoll Klassenvorstandssitzung" → **Überschrift 1**
   - "Ort", "Datum", "Anwesend", "Protokollführer" → behalten als Standard, oder erstelle einen "Info"-Stil (Optional)
   - "1. Tagesordnung" und "2. Sonstiges" → **Überschrift 1**
   - "1.1 Begrüßung", "1.2 Protokoll letzte Sitzung", "1.3 Neue Themen" → **Überschrift 2**
   - "1.3.1 Fahrtenwoche", "1.3.2 Projektwoche" → **Überschrift 3**
   - Alle anderen Texte → **Standard** (Fließtext)
3. Zeige die Überschriften-Navigation an: Ansicht → Gliederung

### Erweiterung (optional)

Ändere den Stil "Überschrift 1" (Rechtsklick → Ändern):
- Schriftart: Cambria (oder andere)
- Schriftfarbe: Dunkelblau
- Größe: 14 pt

---

## Kata 2: Formatvorlage anpassen & eigenen Stil erstellen

| Feld | Wert |
|------|------|
| Konzepte | Stil ändern, neuen Stil erstellen, Design-Register nutzen |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Teil A: Integrierten Stil anpassen

1. Neues Dokument erstellen
2. Schreibe:
   ```
   Meine Überschrift
   Und hier ist etwas Fließtext zum Testen.
   ```
3. Wende "Überschrift 1" auf die erste Zeile an
4. Ändere den Stil "Überschrift 1" (Rechtsklick → Ändern):
   - Schriftart: Arial Black
   - Schriftgröße: 16 pt
   - Schriftfarbe: Orange
   - Absatzabstand: 12 pt davor
5. Schreibe eine zweite "Überschrift 1" - sie sollte automatisch das neue Aussehen haben

Teil B: Eigenen Stil "Wichtiger Hinweis" erstellen

1. Schreibe: "ACHTUNG: Dies ist ein wichtiger Hinweis!"
2. Formatiere manuell:
   - Fett
   - Schriftfarbe: Rot
   - Hintergrundfarbe: Gelb
   - Einrückung links: 1 cm
   - Rahmen: Dünner schwarzer Rand
3. Markiere den Text
4. Start → Stile → "Auswahl speichern als neue Schnellformatvorlage"
5. Name: "Wichtiger Hinweis"
6. Klicke: "Ändern" → Hake an: "Auf diesem Dokument basierend neue Dokumente erstellen" (oder nur in diesem Dokument)
7. Teste: Schreibe neuen Text → wende deinen Stil an

Teil C: Design-Register testen

1. Füge mehrere Überschriften und Fließtext hinzu (genug zum Testen)
2. Menü: Design (Entwurf)
3. Klicke auf verschiedene Designs und beobachte:
   - Was ändert sich bei "Überschrift 1"?
   - Was ändert sich bei "Standard"?
   - Probiere auch "Farben" und "Schriftarten" aus

### Erweiterung (optional)

Erstelle einen Stil "Code" für Programmierbeispiele:
- Schriftart: Courier New (Monospace)
- Kleiner (z.B. 9 pt)
- Grauer Hintergrund
- Optional: Zeilennummern

Erstelle dann:
```
Code-Beispiel:
int x = 5;
System.out.println("Hallo");
```

und wende den "Code"-Stil an.
