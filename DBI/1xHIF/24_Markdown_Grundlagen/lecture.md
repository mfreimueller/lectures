# Lecture: Woche 24 - Markdown I: Grundsyntax

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] VS Code (oder anderer Editor) mit Markdown-Vorschau geöffnet
- [ ] Beispiel-README.md vorbereitet
- [ ] GitHub-Repository mit README.md zeigen (Browser-Tab)

---

## 1. Einführung: Was ist Markdown? (10 min)

**Frage an die Klasse:**
"Wer hat schon mal eine README.md Datei gesehen?"

**Definition:**
Markdown ist eine **einfache Auszeichnungssprache** (Markup Language), die:
- Als **reiner Text** lesbar ist
- **Schnell zu schreiben** ist
- In **HTML und andere Formate** umgewandelt werden kann

**Wofür wird Markdown verwendet?**
- README-Dateien auf GitHub/GitLab
- Dokumentation (z.B. mkdocs, docusaurus)
- Foren (Reddit, Stack Overflow)
- Notizen (Obsidian, Joplin)
- Static Site Generatoren (Jekyll, Hugo, Astro)
- Diese Kursmaterialien sind auch in Markdown geschrieben!

**Vorteile:**
- Kein spezielles Programm nötig (jeder Texteditor reicht)
- Leicht zu lernen (Grundsyntax in 15 Minuten)
- Plattformunabhängig
- Versionierung mit Git funktioniert perfekt (reiner Text)

---

## 2. Theorie: Markdown-Grundsyntax (30 min)

### Überschriften

Mit `#` erzeugt man Überschriften. Ein `#` pro Ebene:

```markdown
# Überschrift 1 (H1)
## Überschrift 2 (H2)
### Überschrift 3 (H3)
#### Überschrift 4 (H4)
##### Überschrift 5 (H5)
###### Überschrift 6 (H6)
```

**Regel:** In den meisten Dokumenten gibt es nur EIN `# H1` (der Titel).

---

### Textformatierung

```markdown
**fetter Text** oder __fetter Text__
*kursiver Text* oder _kursiver Text_
***fett und kursiv***
~~durchgestrichener Text~~
```

**Anzeige:**
- **fetter Text**
- *kursiver Text*
- ***fett und kursiv***
- ~~durchgestrichener Text~~

---

### Listen

**Ungeordnete Liste** (mit `-`, `*` oder `+`):

```markdown
- Punkt 1
- Punkt 2
  - Unterpunkt 2.1
  - Unterpunkt 2.2
- Punkt 3
```

**Geordnete Liste** (mit `1.`, `2.`, ...):

```markdown
1. Erster Schritt
2. Zweiter Schritt
3. Dritter Schritt
```

**Wichtig:** Bei geordneten Listen zählt Markdown automatisch. Du kannst überall `1.` schreiben:

```markdown
1. Schritt 1
1. Schritt 2
1. Schritt 3
```

Ergebnis: 1, 2, 3 — Markdown zählt selbst!

---

### Links

```markdown
[Anzeigetext](https://example.com)

[Link mit Titel](https://example.com "Titel beim Überfahren")

[Relative Links](seite.html)
```

**Beispiel:**
```markdown
[Google](https://google.com)
```

---

### Bilder

```markdown
![Alt-Text](bild.jpg)

![Alt-Text](bild.jpg "Bildunterschrift")
```

**Unterschied zu Links:** Ein `!` vor der Klammer macht aus einem Link ein Bild.

---

### Code

**Inline-Code** (für einzelne Befehle):

```markdown
Verwende `print("Hello World")` in Python.
```

**Code-Block** (für mehrere Zeilen):

````markdown
```python
def hallo():
    print("Hello World")
```
````

**Ohne Sprachangabe:**

````markdown
```
echo "Hallo Welt"
```
````

---

### Live-Demo (10 min)

1. VS Code öffnen
2. Neue Datei: `README.md`
3. Markdown-Code schreiben:
   ```markdown
   # Mein Projekt
   
   ## Beschreibung
   Das ist mein erstes **Markdown**-Projekt.
   
   ## Features
   - Einfach zu schreiben
   - Lesbar als Text
   - Wird automatisch formatiert
   
   ## Installation
   1. Repository klonen
   2. `npm install` ausführen
   3. Fertig!
   
   Mehr Infos auf [meiner Website](https://example.com).
   ```
4. **Vorschau zeigen:** Rechtsklick → "Vorschau" oder `Cmd+Shift+V`

---

## 3. Kata 1: README.md schreiben (20 min)

Kata-Blätter zeigen. Schüler schreiben ihr erstes README.

---

## 4. Kata 2: Listen und Code (25 min)

Kata-Blätter zeigen. Schüler vertiefen Listen und Code-Blöcke.

---

## Zusammenfassung

| Element | Syntax |
|---------|--------|
| Überschrift | `#` bis `######` |
| Fett | `**Text**` |
| Kursiv | `*Text*` |
| Ungeordnete Liste | `- ` |
| Geordnete Liste | `1. ` |
| Link | `[Text](URL)` |
| Bild | `![Alt](URL)` |
| Inline-Code | `` `code` `` |
| Code-Block | ` ``` ... ``` ` |

### Ausblick

Nächste Woche: **Markdown II** — Tabellen, Checkboxen, Zitate, Horizontal Rules.
