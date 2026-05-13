# Kata 1: README.md schreiben

## Ziel

Lerne die grundlegende Markdown-Syntax, indem du ein README.md für ein fiktives Projekt erstellst.

---

## Aufgabenstellung

Erstelle eine Datei namens `README.md` für ein Projekt namens **"WebAnalyzer"** — ein Tool, das Webseiten analysiert.

### Schritt 1: Titel und Einleitung

Beginne mit einem Titel (H1) und einer kurzen Beschreibung:

```markdown
# WebAnalyzer

Ein **einfaches** Tool zur Analyse von *Webseiten*. Es prüft Ladezeiten, SEO-Tags und Barrierefreiheit.
```

**Achte darauf:**
- `**einfaches**` = fett
- `*Webseiten*` = kursiv

### Schritt 2: Features (ungeordnete Liste)

Füge eine Liste der Hauptfunktionen hinzu:

```markdown
## Features

- Ladezeit-Analyse
- SEO-Prüfung
- Barrierefreiheits-Check
- Kompatibel mit allen gängigen Browsern
```

### Schritt 3: Installation (geordnete Liste)

```markdown
## Installation

1. Repository klonen: `git clone https://github.com/example/webanalyzer.git`
2. In das Verzeichnis wechseln: `cd webanalyzer`
3. Abhängigkeiten installieren: `npm install`
4. Programm starten: `npm start`
```

**Beachte:** Inline-Code mit Backticks!

### Schritt 4: Verwendung (Überschrift + Code-Block)

```markdown
## Verwendung

Führe folgenden Befehl aus:

```bash
node index.js --url https://example.com
```
```

### Schritt 5: Link und Autor

```markdown
## Autor

Erstellt von **[Dein Name]()**

Mehr Infos auf der [offiziellen Dokumentation](https://example.com/docs).
```

### Schritt 6: Vorschau prüfen

Öffne die Datei in VS Code und drücke **`Cmd+Shift+V`** (macOS) oder **`Ctrl+Shift+V`** (Windows).

**Prüfe:**
- Sieht die H1-Überschrift größer aus als H2?
- Sind `**fett**` und `*kursiv**` korrekt formatiert?
- Funktioniert der Link?
- Sind die Listen richtig eingerückt?
- Sieht der Code-Block formatiert aus?

---

## Hinweise

- In Markdown musst du keine schließenden Tags schreiben (wie in HTML)
- Die Syntax ist absichtlich einfach gehalten — weniger ist mehr
- Verwende einen **Texteditor** (VS Code, Notepad++, Sublime) — kein Word!
- Die Dateiendung **.md** ist wichtig (manchmal auch .markdown)
- Es gibt viele "Flavors" von Markdown — die Grundsyntax ist aber immer gleich

## Erweiterung (optional)

1. Füge ein Badge-Bild hinzu: `![Build Status](https://img.shields.io/badge/build-passing-green)`
2. Erstelle einen Abschnitt "Lizenz" mit `MIT License`
3. Füge eine Tabelle mit unterstützten Versionen hinzu (kommt nächste Woche!)
