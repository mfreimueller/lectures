# Katas - Woche 03: Word Layout & Seitenaufbau

---

## Kata 1: Seitenzahlen mit Abschnittswechsel

| Feld | Wert |
|------|------|
| Konzepte | Abschnittswechsel, Seitenzahlen (römisch/arabisch), "Mit vorherigem verknüpfen" trennen |
| Schwierigkeit | 3/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Erstelle ein Dokument mit verschiedenen Seitenzahlen-Formaten:

1. **Seite 1 (Titelblatt):** Ohne Seitenzahl
2. **Seiten 2-3 (Inhaltsverzeichnis):** Römische Zahlen I, II
3. **Seite 4 ff. (Hauptteil):** Arabische Zahlen 1, 2, 3...

#### Schritt 1: Dokument erstellen

Neues Dokument erstellen und genügend Seiten füllen:

1. Schreibe auf Seite 1:
   ```
   TITELBLATT
   
   Meine Hausarbeit
   
   HTL Spengergasse
   2026
   ```

2. Menü: Layout → Umbrüche → **Nächste Seite** (Abschnittswechsel!)

3. Auf Seite 2 schreibe:
   ```
   Inhaltsverzeichnis
   
   1. Einleitung ............... 1
   2. Hauptteil ................. 2
   ```

4. Wieder: Layout → Umbrüche → **Nächste Seite**

5. Auf Seite 4 schreibe:
   ```
   1. Einleitung
   
   Hier steht die Einleitung...
   
   [Seitenumbruch: Strg+Enter]
   
   2. Hauptteil
   
   Und hier der Hauptteil...
   ```

Du hast jetzt:
- Abschnitt 1: Seite 1 (Titelblatt)
- Abschnitt 2: Seiten 2-3 (Inhaltsverzeichnis)
- Abschnitt 3: Seiten 4+ (Hauptteil)

#### Schritt 2: Kopf- und Fußzeilen öffnen

**WICHTIG: Gehe Abschnitt für Abschnitt vor!**

##### Für Abschnitt 1 (Titelblatt):

1. Doppelklick auf Seitenrand im Bereich der Fußzeile (unten)
2. Setze Häkchen bei: **Verschieden auf erster Seite**
3. Jetzt hat die erste Seite KEINE Kopf-/Fußzeile → perfekt für Titelblatt

##### Für Abschnitt 2 (Inhaltsverzeichnis, römisch):

1. Klicke auf Seite 2 (Inhaltsverzeichnis) in die Fußzeile
2. ⚠️ **WICHTIGSTER SCHRITT:** Klicke auf den Button **"Mit vorherigem verknüpfen"** im Menü "Kopf- und Fußzeile", sodass er NICHT hervorgehoben ist!
3. Jetzt: Einfügen → Seitenzahlen → Seitenende → Einfaches (oder eine Vorlage)
4. Dann: Einfügen → Seitenzahlen → **Seitenzahlen formatieren**
5. Wähle: `I, II, III...` (römisch)
6. Start bei: `I`

##### Für Abschnitt 3 (Hauptteil, arabisch):

1. Klicke auf Seite 4 (Hauptteil) in die Fußzeile
2. ⚠️ **WIEDER:** "Mit vorherigem verknüpfen" AUSSCHALTEN!
3. Einfügen → Seitenzahlen → Seitenende → Einfaches
4. Einfügen → Seitenzahlen → **Seitenzahlen formatieren**
5. Wähle: `1, 2, 3...` (arabisch)
6. ⚠️ **Start bei: 1** (NICHT "Fortfahren von vorherigem Abschnitt"!)

#### Schritt 3: Überprüfen

- Seite 1: Keine Seitenzahl ✓
- Seite 2: I (römisch) ✓
- Seite 3: II (römisch) ✓
- Seite 4: 1 (arabisch) ✓
- Seite 5: 2 (arabisch) ✓

### Häufige Fehler

1. "Mit vorherigem verknüpfen" vergessen auszuschalten → Änderung wirkt auf ganze Dokument
2. "Start bei 1" vergessen → Hauptteil fängt bei 4 oder höher an
3. Abschnittswechsel mit "Seitenumbruch" statt "Nächste Seite" erstellt → Seitenumbruch ist kein Abschnittswechsel!

---

## Kata 2: Kopf- & Fußzeile gestalten

| Feld | Wert |
|------|------|
| Konzepte | Kopfzeile, Fußzeile, verschiedene auf erster Seite, Grafiken in Kopfzeile |
| Schwierigkeit | 2/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle eine "offizielle" Dokumentenvorlage mit Firmen-Layout:

#### Schritt 1: Neues Dokument

Neues leeres Dokument.

#### Schritt 2: Kopfzeile gestalten

1. Doppelklick in den oberen Rand → Kopfzeile öffnet sich
2. Oder: Einfügen → Kopfzeile → "Leer"

Gestalte:
- **Links:** Füge ein kleines Bild/Logo ein (z.B. "HTL Spengergasse" oder dein eigenes "Logo")
- **Zentriert:** Schreibe fett: `"HAUSARBEIT"` oder `"OFFIZIELL"`
- **Rechts:** Schreibe klein: `"Entwurf"` oder `"Vertraulich"`

Tipp: Nutze Tabulatoren oder eine Tabelle (ohne Rahmen) für die Ausrichtung!

#### Schritt 3: Fußzeile gestalten

1. Menü: Kopf- und Fußzeile → Zu Fußzeile wechseln

Gestalte:
- **Links:** `"Name: [Dein Name]"`
- **Zentriert:** `Seitenzahl` (Einfügen → Seitenzahlen)
- **Rechts:** `"Datum: 12.05.2026"` (oder nutze das Feld "Datum")

#### Schritt 4: Verschieden auf erster Seite

1. Häkchen setzen bei: **Verschieden auf erster Seite**
2. Jetzt kannst du die ERSTE Seite (Titelblatt) ganz ohne Kopf-/Fußzeile gestalten

#### Schritt 5: Testen

Schreibe etwas mehr Text (oder füge Seitenumbrüche mit `Strg+Enter` hinzu) und überprüfe:
- Seite 1: Keine Kopf-/Fußzeile (oder nur Titelblatt-Text)
- Seiten 2+: Deine gestaltete Kopf-/Fußzeile mit Seitenzahl

### Erweiterung (optional)

1. **Füge ein Wasserzeichen hinzu:**
   - Layout → Wasserzeichen → Benutzerdefiniertes Wasserzeichen
   - Text: `"ENTWURF"`
   - Diagonal, Hellgrau

2. **Tabellarische Kopfzeile:**
   - Erstelle eine 3-Spalten Tabelle in der Kopfzeile
   - Spalte 1: Logo (links)
   - Spalte 2: Dokumentname (zentriert)
   - Spalte 3: Datum/Status (rechts)
   - Entferne die Tabellenrahmen
