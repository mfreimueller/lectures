# Kata 2: Formatvorlage anpassen & eigenen Stil erstellen

## Ziel

Lerne einen bestehenden Stil zu ändern, einen eigenen Stil zu erstellen und das Design-Register zu nutzen.

## Aufgabenstellung

### Teil A: Integrierten Stil anpassen

1. Erstelle ein neues Word-Dokument
2. Schreibe folgenden Text:
   ```
   Meine Überschrift
   Und hier ist etwas Fließtext zum Testen.
   ```
3. Wende den Stil "Überschrift 1" auf die erste Zeile an (Strg+Alt+1)
4. Rechtsklicke auf "Überschrift 1" im Stil-Menü → **Ändern**
5. Passe folgenden Eigenschaften an:
   - Schriftart: Arial Black
   - Schriftgröße: 16 pt
   - Schriftfarbe: Orange
   - Menü: **Format** → **Absatz** → Abstand davor: 12 pt
6. Bestätige mit OK

**Test:** Schreibe eine weitere Zeile und wende "Überschrift 1" an. Sie sollte automatisch das neue Aussehen haben!

---

### Teil B: Eigenen Stil "Wichtiger Hinweis" erstellen

1. Schreibe: `"ACHTUNG: Dies ist ein wichtiger Hinweis!"`
2. Formatiere diesen Text manuell:
   - Fett (Strg+F)
   - Schriftfarbe: Rot
   - Menü: Start → Textmarkerfarbe: Gelb
   - Menü: Layout → Einzug: Linker Einzug 1 cm
   - Menü: Start → Rahmen → Durchgehender Rahmen (dünner schwarzer Rand)
3. Markiere den gesamten formatierten Text
4. Gehe zu: Start → Stile → **Auswahl speichern als neue Schnellformatvorlage**
5. Gib als Namen ein: `"Wichtiger Hinweis"`
6. Optional: Klicke auf **Ändern** um weitere Einstellungen zu treffen

**Test:** 
- Schreibe einen neuen Text: `"Noch ein Hinweis!"`
- Markiere ihn und wende deinen Stil "Wichtiger Hinweis" an

---

### Teil C: Design-Register testen

1. Füge genügend Inhalt zum Testen hinzu:
   - Mehrere Überschriften (Überschrift 1, Überschrift 2)
   - Etwas Fließtext darunter
2. Gehe zum Menü: **Design** (bzw. "Entwurf" in manchen Versionen)
3. Probiere verschiedene Designs aus (das ist der Kasten mit "Office", "Einfach", "Schwarz und Weiß", etc.)
4. Beobachte:
   - Was ändert sich bei den Überschriften?
   - Was ändert sich beim Fließtext?
5. Probiere auch:
   - **Farben:** Anderes Farbschema wählen
   - **Schriftarten:** Anderes Schriftarten-Paket wählen
   - **Absatzabstand:** Vordefinierte Abstände testen

## Hinweise

- Wenn du deinen Stil später ändern möchtest: Rechtsklick → Ändern
- Änderungen am Stil wirken auf alle Stellen im Dokument, wo dieser Stil verwendet wurde
- Designs sind "Pakete": Ein Klick = Komplettes Dokument umgestalten

## Erweiterung (optional)

Erstelle einen Stil "Code" für Programmierbeispiele:

1. Schreibe einen Code-Schnipsel:
   ```
   int x = 5;
   System.out.println("Hallo");
   ```
2. Formatiere:
   - Schriftart: Courier New (Monospace-Schrift)
   - Größe: 9 pt
   - Hintergrundfarbe: Hellgrau
   - Optional: Dünner Rand
3. Speichere als Stil "Code"

Teste ihn mit weiteren Code-Zeilen!
