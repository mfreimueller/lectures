# Lecture: Woche 26 - AsciiDoc I (Grundlagen)

---

## 1. Wiederholung Markdown (10 min)

Quick-Quiz:

1. "Welche Syntax für H1 in Markdown?" → `# Titel`
2. "Wie macht man einen Link?" → `[Text](URL)`
3. "Welches Problem hast du mit Markdown bei Tabellen?" → Unterschiedliche Syntax je nach Dialekt (GFM vs. CommonMark vs. ...)

---

## 2. Theorie: AsciiDoc Grundlagen (30 min)

### Was ist AsciiDoc?

AsciiDoc ist eine **Auszeichnungssprache** -- wie Markdown, aber:
- Mächtiger
- Erweiterbar
- Einheitlicher Standard (keine Dialekte!)
- Älter (2002) als viele denken

**Wichtig:** AsciiDoc ist KEIN Markdown-Dialekt! Es ist ein eigenständiges Format mit eigener Philosophie.

---

### Vision und Ziel

| AsciiDoc | Markdown |
|----------|----------|
| "Eine Datei, viele Ausgabeformate" | "Einfach schreiben können" |
| Built-in: TOC, Cross-Ref, Includes | Braucht Extensions |
| Einheitlich: egal wo du schreibst | Anders auf GitHub, GitLab, StackOverflow |

---

### Syntax im Detail

**Überschriften:**

| Ebene | AsciiDoc | Markdown |
|-------|----------|----------|
| H1 | `= Titel` | `# Titel` |
| H2 | `== Abschnitt` | `## Abschnitt` |
| H3 | `=== Unterabschnitt` | `### Unterabschnitt` |

**Textformatierung:**

| Format | AsciiDoc | Markdown |
|--------|----------|----------|
| Fett | `*fett*` | `**fett**` |
| Kursiv | `_kursiv_` | `*kursiv*` |

> **Achtung:** Fett und Kursiv sind vertauscht im Vergleich zu Markdown!

**Listen:**

| Typ | AsciiDoc | Markdown |
|-----|----------|----------|
| Ungeordnet | `* Punkt` | `- Punkt` oder `* Punkt` |
| Geordnet | `. Schritt` | `1. Schritt` |

**Links:**

| AsciiDoc | Markdown |
|----------|----------|
| `link:https://example.com[Beispiel]` | `[Beispiel](https://example.com)` |

**Bilder:**

| AsciiDoc | Markdown |
|----------|----------|
| `image::foto.jpg[Alt-Text]` | `![Alt-Text](foto.jpg)` |

**Code:**

AsciiDoc: Inline `` `code` `` (gleich wie Markdown).

Code-Block:
```asciidoc
----
console.log("Hello");
----
```

Mit Sprachangabe:
```asciidoc
[source,javascript]
----
console.log("Hello");
----
```

---

### Tooling

| Tool | Beschreibung |
|------|-------------|
| **AsciiDoctor** (Ruby) | Das Original, CLI: `asciidoctor datei.adoc` |
| **AsciiDoctor.js** | Läuft im Browser, für Web-Seiten |
| **VS Code Extension** | "AsciiDoc" von asciidoctor -> Preview, Syntax-Highlighting |
| **GitHub/GitLab** | Rendern .adoc Dateien automatisch |

---

## 3. Live-Demo (15 min)

Erstelle eine Datei `demo.adoc` am Beamer:

```asciidoc
= AsciiDoc Demo
Max Mustermann
:date: 2026

== Einleitung

Dies ist ein *fetter Text* und das ist _kursiv_.

== Listen

* Punkt 1
* Punkt 2
* Punkt 3

. Erster Schritt
. Zweiter Schritt
. Dritter Schritt

== Links und Bilder

link:https://asciidoctor.org[AsciiDoctor Webseite]

image::https://asciidoctor.org/images/asciidoctor-logo.png[Logo]

== Code

[source,java]
----
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, AsciiDoc!");
    }
}
----
```

**Preview in VS Code:** Rechtsklick → "AsciiDoc: Open Preview"

**Als HTML rendern:**
```bash
asciidoctor demo.adoc
# erzeugt demo.html
```

---

## 4. Kata 1: Kurzdokument in AsciiDoc (25 min)

Kata-Blätter zeigen.

Schüler schreiben ein kurzes AsciiDoc-Dokument mit:
- Titel, Autor, Datum
- Mehreren Überschriften
- Fettem und kursivem Text
- Ungeordneten und geordneten Listen
- Link und Bild
- Code-Block mit Sprachangabe

---

## 5. Kata 2: Markdown vs. AsciiDoc (25 min)

Kata-Blätter zeigen.

Schüler erhalten ein Markdown-Dokument und konvertieren es nach AsciiDoc.
Dabei lernen sie die Syntax-Unterschiede kennen.

---

## Zusammenfassung

| Konzept | Erklärung |
|---------|-----------|
| AsciiDoc | Mächtige Auszeichnungssprache, kein Markdown-Dialekt |
| `=`, `==`, `===` | Überschriften (H1, H2, H3) |
| `*fett*`, `_kursiv_` | Textformatierung |
| `*` und `.` | Ungeordnete und geordnete Listen |
| `link:URL[Text]` | Links |
| `image::URL[Alt]` | Bilder |
| `----` / `[source,lang]` | Code-Blöcke |

### Ausblick

Nächste Woche: **AsciiDoc II** — TOC, Cross-References, Includes, Conditionals, Tabellen, Attribute.
