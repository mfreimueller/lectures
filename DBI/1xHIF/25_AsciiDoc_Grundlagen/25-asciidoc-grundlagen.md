---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 25 - AsciiDoc Grundlagen
## DBI - 1AHIF

---

## Agenda (1/2)

1. Was ist AsciiDoc?
2. Markdown vs. AsciiDoc
3. Überschriften in AsciiDoc
4. Textformatierung
5. Listen
6. Links

---

## Agenda (2/2)

7. Bilder
8. Code
9. Markdown vs. AsciiDoc - Vergleich
10. AsciiDoctor
11. VS Code Extension
12. Ausgabeformate

---

## Lernziele

- Ich weiß, was AsciiDoc ist und wie es sich von Markdown unterscheidet
- Ich kann Überschriften, Textformatierung und Listen in AsciiDoc schreiben
- Ich kann Links, Bilder und Code-Blöcke in AsciiDoc einfügen
- Ich kenne AsciiDoctor und die VS Code Extension für AsciiDoc
- Ich kenne die verschiedenen Ausgabeformate von AsciiDoc (HTML, PDF, EPUB, DocBook)

---

## Recap: Markdown

1. Wie erstellt man eine Tabelle in Markdown?
2. Was bedeuten `- [ ]` und `- [x]`?
3. Welche horizontalen Linien kennst du?

---

## Was ist AsciiDoc?

- Eine **Auszeichnungssprache** wie Markdown
- Aber **mächtiger** und **erweiterbarer**
- Einheitlicher Standard (keine Dialekte wie bei Markdown)
- Erstellt von Stuart Rackham (2002)

---

## Markdown vs. AsciiDoc

| Feature | Markdown | AsciiDoc |
| --- | --- | --- |
| Standard | Viele Dialekte | Einheitlich |
| Tabellen | Umständlich (|) | Einfach (|===) |
| Cross-References | Nicht standardisiert | <<id,Text>> |
| TOC | Via Extension | :toc: |
| Includes | Nicht standardisiert | include::datei.adoc[] |

---

## Überschriften in AsciiDoc

```asciidoc
= Überschrift 1 (H1)

== Überschrift 2 (H2)

=== Überschrift 3 (H3)

==== Überschrift 4 (H4)
```

Anders als Markdown: = statt #

---

## Textformatierung

```asciidoc
*fetter Text*        (anders als Markdown!)
_kursiver Text_      (anders als Markdown!)
`code`               (gleich wie Markdown)
*_fett und kursiv_*
```

**Achtung:** In AsciiDoc ist * für fett, in Markdown für kursiv!

---

## Listen

```asciidoc
* Ungeordnete Liste
** Verschachtelt
*** Noch tiefer

. Geordnete Liste
.. Verschachtelt
... Noch tiefer
```

Ungeordnet: * (wie Markdown), geordnet: . (anders als Markdown)

---

## Links

```asciidoc
link:https://example.com[Anzeigetext]

link:https://example.com[Text mit "Titel"]

link:seite.html[Relativer Link]
```

Anders als Markdown: link:URL[Text] statt [Text](URL)

---

## Bilder

```asciidoc
image::foto.jpg[Alt-Text]

image::foto.jpg[Alt-Text, 400, 300]

image:logo.png[Logo, 24]
```

image:: mit Doppel-Doppelpunkt = Block, image: mit einfachem = Inline

---

## Code

Inline-Code (gleich wie Markdown):

```asciidoc
Verwende `printf()` in C.
```

Code-Block:

```asciidoc
----
echo "Hallo Welt"
----
```

Mit Sprachangabe:

```asciidoc
[source,java]
----
System.out.println("Hallo");
----
```

---

## Markdown vs. AsciiDoc - Vergleich

| Element | Markdown | AsciiDoc |
| --- | --- | --- |
| H1 | # Text | = Text |
| Fett | **Text** | *Text* |
| Kursiv | *Text* | _Text_ |
| Ungeordnete Liste | - Text | * Text |
| Link | [Text](URL) | link:URL[Text] |
| Bild | ![Alt](URL) | image::URL[Alt] |
| Code-Block | ``` | ---- |

---

## AsciiDoctor

- Der Standard-Converter für AsciiDoc
- Geschrieben in Ruby
- AsciiDoctor.js für den Browser
- Wandelt .adoc in HTML, PDF, EPUB, DocBook um

---

## VS Code Extension

- "AsciiDoc" Extension von Joao Pinto installieren
- Live-Vorschau wie bei Markdown
- Syntax-Highlighting für .adoc-Dateien
- Export nach HTML/PDF direkt aus VS Code

---

## Ausgabeformate

| Format | Befehl | Verwendung |
| --- | --- | --- |
| HTML | asciidoctor dokument.adoc | Webseiten, Docs |
| PDF | asciidoctor-pdf dokument.adoc | Druck, Weitergabe |
| EPUB | asciidoctor-epub3 dokument.adoc | E-Books |
| DocBook | asciidoctor -b docbook dokument.adoc | Weiterverarbeitung |

---

## Zusammenfassung

| Element | Syntax |
| --- | --- |
| H1 | = Text |
| H2 | == Text |
| H3 | === Text |
| Fett | *Text* |
| Kursiv | _Text_ |
| Ungeordnete Liste | * Punkt |
| Geordnete Liste | . Schritt |
| Link | link:URL[Text] |
| Bild | image::URL[Alt] |
| Inline-Code | `code` |
| Code-Block | ---- |
| Code mit Sprache | [source,java] ---- |
