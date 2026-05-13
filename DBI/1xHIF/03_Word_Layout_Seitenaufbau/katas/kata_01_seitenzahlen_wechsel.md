# Kata 1: Seitenzahlen mit Abschnittswechsel

## Ziel

Lerne Abschnittswechsel zu erstellen und verschiedene Seitenzahlen-Formate (römisch/arabisch) in einem Dokument zu verwenden. Dies ist wichtig für wissenschaftliche Arbeiten!

## Aufgabenstellung

Erstelle ein Dokument mit folgender Seitenzahlen-Struktur:

1. **Seite 1 (Titelblatt):** Ohne Seitenzahl
2. **Seiten 2-3 (Inhaltsverzeichnis):** Römische Zahlen I, II
3. **Seite 4 ff. (Hauptteil):** Arabische Zahlen 1, 2, 3...

---

### Schritt 1: Dokument mit Abschnitten erstellen

Zuerst brauchst du 3 **Abschnitte** (nicht nur Seiten!).

1. Neues Word-Dokument
2. Auf Seite 1 schreibe:
   ```
   TITELBLATT
   
   Meine Hausarbeit
   
   HTL Spengergasse
   2026
   ```

3. **WICHTIG:** Cursor ans Ende von Seite 1 setzen
4. Menü: **Layout → Umbrüche → Nächste Seite**
   → Das erstellt einen **Abschnittswechsel** (nicht nur einen Seitenumbruch!)

5. Jetzt bist du in **Abschnitt 2**. Schreibe:
   ```
   Inhaltsverzeichnis
   
   1. Einleitung ............... 1
   2. Hauptteil ................. 2
   ```

6. Füge eine Leerseite hinzu (oder mehr Text):  
   `Strg+Enter` (Seitenumbruch, kein Abschnittswechsel!)

7. Jetzt: Cursor ans Ende von Abschnitt 2 setzen
8. Wieder: **Layout → Umbrüche → Nächste Seite**
   → Jetzt bist du in **Abschnitt 3**

9. Schreibe in Abschnitt 3:
   ```
   1. Einleitung
   
   Hier steht die Einleitung...
   
   [Strg+Enter]
   
   2. Hauptteil
   
   Und hier der Hauptteil...
   ```

**Überprüfung:** Unten links im Word-Fenster sollte bei Klick in verschiedene Bereiche stehen:
- "Seite 1 Abschnitt 1"
- "Seite 2 Abschnitt 2"
- "Seite 4 Abschnitt 3"

---

### Schritt 2: Abschnitt 1 (Titelblatt) - Ohne Seitenzahl

1. Doppelklick auf den unteren Rand (Fußzeile) von Seite 1
2. Im Menü "Kopf- und Fußzeile" setze Häkchen bei:
   - **Verschieden auf erster Seite**

3. Schließe den Kopf-/Fußzeilen-Modus (Doppelklick im Text)

**Ergebnis:** Seite 1 hat keine Kopf-/Fußzeile.

---

### Schritt 3: Abschnitt 2 (Inhaltsverzeichnis) - Römische Zahlen

 **DAS IST DER WICHTIGSTE SCHRITT!** 

1. Klicke auf Seite 2 (Inhaltsverzeichnis)
2. Doppelklick in die Fußzeile
3.  **SOFORT:** Klicke im Menü auf den Button **"Mit vorherigem verknüpfen"**
   - Der Button darf **NICHT** hervorgehoben sein!
   - Wenn er hervorgehoben ist, klicke ihn an, damit er ausgeht
   - **Warum?** Sonst änderst du mit Abschnitt 2 gleichzeitig auch Abschnitt 1!

4. Jetzt erst: Seitenzahlen einfügen:
   - Menü: **Einfügen → Seitenzahlen → Seitenende → Einfaches**

5. Seitenzahlen formatieren:
   - Rechtsklick auf die Seitenzahl
   - Oder: **Einfügen → Seitenzahlen → Seitenzahlen formatieren**
   - Wähle: `I, II, III...` (römisch, groß)
   - Start bei: `I`

6. Schließen

---

### Schritt 4: Abschnitt 3 (Hauptteil) - Arabische Zahlen

 **WIEDER DER WICHTIGSTE SCHRITT!** 

1. Klicke auf Seite 4 (Hauptteil)
2. Doppelklick in die Fußzeile
3.  **WIEDER:** Klicke auf **"Mit vorherigem verknüpfen"**, damit er NICHT hervorgehoben ist!

4. Seitenzahlen einfügen:
   - **Einfügen → Seitenzahlen → Seitenende → Einfaches**

5. Seitenzahlen formatieren:
   - **Einfügen → Seitenzahlen → Seitenzahlen formatieren**
   - Wähle: `1, 2, 3...` (arabisch)
   -  **Start bei: 1** (NICHT "Fortfahren von vorherigem Abschnitt"!)

---

### Schritt 5: Überprüfen

| Seite | Erwartete Seitenzahl |
|-------|----------------------|
| 1 | keine |
| 2 | I |
| 3 | II |
| 4 | 1 |
| 5 | 2 |

## Hinweise

- **"Mit vorherigem verknüpfen" ist der wichtigste Button überhaupt!**
- Immer zuerst die Verknüpfung trennen, dann Seitenzahlen ändern
- Abschnittswechsel = `Layout → Umbrüche → Nächste Seite`
- Seitenumbruch = `Strg+Enter` (kein neuer Abschnitt!)

Häufigste Fehler:
1. Vergessen, "Mit vorherigem verknüpfen" auszuschalten
2. "Start bei 1" vergessen → Hauptteil fängt bei 4 an
3. Seitenumbruch statt Abschnittswechsel verwendet

## Erweiterung (optional)

1. Füge eine vierte Seite mit Querformat hinzu (mitten im Dokument):
   - Abschnittswechsel vor und nach der Seite
   - Nur in diesem Abschnitt: Layout → Ausrichtung → Querformat

2. Füge ein **Inhaltsverzeichnis** ein (automatisch aus Überschriften-Stilen generiert - kommt nächste Woche!).
