# Kata 2: Markdown vs. AsciiDoc

## Ziel

Lerne die Syntax-Unterschiede zwischen Markdown und AsciiDoc, indem du ein Markdown-Dokument manuell nach AsciiDoc konvertierst.

## Wichtig: AsciiDoc ist kein Markdown-Dialekt

AsciiDoc ist ein **eigenständiges Format** mit eigener Syntax. Die Ähnlichkeiten sind oberflächlich. Viele Dinge, die in Markdown umständlich oder nur via Extensions möglich sind, sind in AsciiDoc eingebaut.

---

## Aufgabenstellung

Konvertiere ein Markdown-Dokument nach AsciiDoc.

### Schritt 1: Markdown-Dokument erstellen

Kopiere diesen Markdown-Code in eine Datei `reise.md`:

```markdown
# Meine letzte Reise

## Reiseziel: Wien

Letzten Sommer war ich in **Wien**. Die Stadt ist *wirklich* beeindruckend.

### Sehenswürdigkeiten

- Stephansdom
- Schloss Schönbrunn
- Prater mit Riesenrad

### Gegessenes Essen

1. Wiener Schnitzel
2. Sachertorte
3. Apfelstrudel

Mehr Infos unter [Wien Tourismus](https://www.wien.info).

![Wien](https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Wien_01.jpg/300px-Wien_01.jpg)

Hier ist ein Code-Beispiel:

\```python
print("Wien ist schön!")
\```
```

---

### Schritt 2: Nach AsciiDoc konvertieren

Erstelle eine Datei `reise.adoc` und übersetze den Inhalt.

**Die Konvertierungstabelle:**

| Markdown | AsciiDoc |
|----------|----------|
| `# Titel` | `= Titel` |
| `## H2` | `== H2` |
| `### H3` | `=== H3` |
| `**fett**` | `*fett*` |
| `*kursiv*` | `_kursiv_` |
| `- Punkt` oder `* Punkt` | `* Punkt` |
| `1. Schritt` | `. Schritt` |
| `[Text](URL)` | `link:URL[Text]` |
| `![Alt](URL)` | `image::URL[Alt]` |
| Codefence ` ``` ` | `----` |
| Codefence mit Sprache ` ```python ` | `[source,python]` + `----` |

**Achtung bei diesen häufigsten Fehlern:**

- Fett/Kursiv sind **vertauscht**: AsciiDoc `*fett*` (ein Stern) = Markdown `**fett**` (zwei Sterne)
- Links brauchen `link:` Prefix
- Bilder brauchen `image::` (zwei Doppelpunkte!)
- Code-Blöcke: `[source,python]` kommt in eine **eigene Zeile** vor `----`

---

### Schritt 3: AsciiDoc-Features hinzufügen

Füge Features hinzu, die es in Markdown nicht (oder nicht standardisiert) gibt:

**Autor und Datum als Attribut:**
```asciidoc
= Meine letzte Reise
Vorname Nachname
:date: 2026-09-20
```

**Attribut im Text verwenden:**
```asciidoc
Letzten Sommer ({date}) war ich in *Wien*.
```

**Tabelle:**
```asciidoc
=== Preise

|===
| Sehenswürdigkeit | Eintrittspreis
| Stephansdom | gratis
| Schloss Schönbrunn | 22 EUR
| Prater | frei (Eintritt)
|===
```

---

### Schritt 4: Vergleichen

Rendere beide Versionen:

Markdown mit Pandoc:
```bash
pandoc reise.md -o reise.html
```

AsciiDoc mit AsciiDoctor:
```bash
asciidoctor reise.adoc
```

**Vergleiche die Ergebnisse:**
- Welche Version sieht besser aus?
- Welche Version war einfacher zu schreiben?
- Welche Features hat die AsciiDoc-Version, die die Markdown-Version nicht hat?

---

## Kontrolle

- [ ] `= Titel` statt `# Titel`
- [ ] `==` / `===` für H2/H3
- [ ] `*fett*` statt `**fett**`
- [ ] `_kursiv_` statt `*kursiv*`
- [ ] `* Punkt` für ungeordnete Listen
- [ ] `. Schritt` für geordnete Listen
- [ ] `link:URL[Text]` für Links
- [ ] `image::URL[Alt]` für Bilder
- [ ] `[source,python]` + `----` für Code-Blöcke
- [ ] Autor und Datum unter dem Titel
- [ ] HTML-Ausgabe funktioniert mit `asciidoctor`

## Erweiterung (optional)

1. Füge ein Inhaltsverzeichnis hinzu: `:toc:` direkt nach dem Titel
2. Füge eine zweite Reise hinzu (z.B. `== Reiseziel: Paris`) mit eigenem Inhalt
3. Füge einen Cross-Reference-Link von einem Abschnitt zum anderen hinzu (Tipp: `<<id,Text>>` -- das kommt nächste Woche!)
4. Baue absichtlich einen Fehler ein (z.B. `image:` mit nur einem Doppelpunkt) und schau, wie AsciiDoctor reagiert
