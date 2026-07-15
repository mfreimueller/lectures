---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 24 - Markdown Grundlagen
## DBI - 1AHIF

---

## Agenda (1/2)

1. Was ist Markdown?
2. Wofür wird Markdown verwendet?
3. Vorteile von Markdown
4. Überschriften
5. Textformatierung
6. Ungeordnete Listen

---

## Agenda (2/2)

7. Geordnete Listen
8. Links
9. Bilder
10. Inline-Code
11. Code-Blöcke
12. Live-Demo

---

## Lernziele

- Ich weiß, was Markdown ist und wofür es verwendet wird
- Ich kann Überschriften, Textformatierung und Listen in Markdown schreiben
- Ich kann Links und Bilder einfügen
- Ich kann Inline-Code und Code-Blöcke mit Syntax-Highlighting verwenden
- Ich kann eine einfache Markdown-Datei erstellen und in der Vorschau prüfen

---

## Was ist Markdown?

- Eine **einfache Auszeichnungssprache** (Markup Language)
- Als **reiner Text** lesbar und schreibbar
- Wird automatisch in **HTML** umgewandelt
- Erfunden von John Gruber (2004)

---

## Wofür wird Markdown verwendet?

- README-Dateien auf GitHub/GitLab
- Foren (Reddit, Stack Overflow)
- Dokumentation (MkDocs, Docusaurus)
- Notizen (Obsidian, Joplin)
- Static Site Generatoren (Jekyll, Hugo, Astro)
- Diese Kursmaterialien sind auch in Markdown!

---

## Vorteile von Markdown

- Kein spezielles Programm nötig (jeder Texteditor reicht)
- Leicht zu lernen (Grundsyntax in 15 Minuten)
- Plattformunabhängig
- Perfekt für Git (reiner Text = gute Versionsverwaltung)

---

## Überschriften

```markdown
# Überschrift 1 (H1)
## Überschrift 2 (H2)
### Überschrift 3 (H3)
#### Überschrift 4 (H4)
##### Überschrift 5 (H5)
###### Überschrift 6 (H6)
```

**Regel:** Nur ein H1 pro Dokument (der Titel)

---

## Textformatierung

```markdown
**fetter Text** oder __fetter Text__
*kursiver Text* oder _kursiver Text_
***fett und kursiv***
~~durchgestrichener Text~~
```

- ****fetter Text****
- **kursiver Text**
- ~~durchgestrichener Text~~

---

## Ungeordnete Listen

```markdown
- Punkt 1
- Punkt 2
  - Unterpunkt 2.1
  - Unterpunkt 2.2
- Punkt 3
```

- Punkt 1
- Punkt 2
  - Unterpunkt 2.1
  - Unterpunkt 2.2
- Punkt 3

---

## Geordnete Listen

```markdown
1. Erster Schritt
2. Zweiter Schritt
3. Dritter Schritt
```

Markdown zählt automatisch - du kannst überall "1." schreiben:

```markdown
1. Schritt 1
1. Schritt 2
1. Schritt 3
```

Ergebnis: 1, 2, 3

---

## Links

```markdown
[Anzeigetext](https://example.com)

[Link mit Titel](https://example.com "Titel beim Überfahren")

[Relative Links](seite.html)
```

Beispiel: [Google](https://google.com)

---

## Bilder

```markdown
![Alt-Text](bild.jpg)

![Alt-Text](bild.jpg "Bildunterschrift")
```

**Unterschied zu Links:** Ein Ausrufezeichen vor der eckigen Klammer macht aus einem Link ein Bild

---

## Inline-Code

Für einzelne Befehle oder kurze Code-Schnipsel:

```markdown
Verwende `print("Hello World")` in Python.
```

Ergebnis: Verwende `print("Hello World")` in Python.

---

## Code-Blöcke

Für mehrere Zeilen Code:

```markdown
```python
def hallo():
    print("Hello World")
```
```

Mit Sprachangabe für Syntax-Highlighting

Ohne Sprachangabe:

```markdown
```
echo "Hallo Welt"
```
```

---

## Live-Demo

1. VS Code öffnen
2. Neue Datei: README.md
3. Markdown schreiben und speichern
4. Vorschau: Rechtsklick > "Vorschau" oder Cmd+Shift+V

---

## Zusammenfassung

| Element | Syntax |
| --- | --- |
| Überschrift | # bis ###### |
| Fett | **Text** |
| Kursiv | *Text* |
| Ungeordnete Liste | - Text |
| Geordnete Liste | 1. Text |
| Link | [Text](URL) |
| Bild | ![Alt](URL) |
| Inline-Code | `code` |
| Code-Block | ``` ... ``` |
