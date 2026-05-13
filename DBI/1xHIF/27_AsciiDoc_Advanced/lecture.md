# Lecture: Woche 27 - AsciiDoc II (Advanced)

---

## 1. Wiederholung AsciiDoc Grundlagen (10 min)

Quick-Quiz:

1. "Welche Syntax für H1 in AsciiDoc?" → `= Titel`
2. "Wie macht man einen Link?" → `link:URL[Text]`
3. "Wie unterscheidet sich AsciiDoc von Markdown?" → Einheitlicher Standard, keine Dialekte, mehr Features eingebaut

---

## 2. Theorie: AsciiDoc Advanced (30 min)

### Inhaltsverzeichnis (TOC)

Das TOC ist in AsciiDoc **eingebaut** -- kein Plugin nötig.

```asciidoc
= Mein Dokument
:toc:
:toc-title: Inhaltsverzeichnis
:toclevels: 3

== Kapitel 1
...
== Kapitel 2
...
```

**Positionen:**
- `:toc:` — Standard (oben, volle Breite)
- `:toc: left` — Links neben dem Inhalt
- `:toc: right` — Rechts neben dem Inhalt

---

### Section-Nummerierung

```asciidoc
= Dokument
:sectnums:

== Einleitung    → 1. Einleitung
=== Details      → 1.1. Details
== Hauptteil     → 2. Hauptteil
```

---

### Cross-References (Interne Verweise)

**Anchor setzen** (Ziel):
```asciidoc
[[installation]]
=== Installation
```

**Darauf verweisen:**
```asciidoc
Siehe <<installation>> für Details.
→ "Siehe installation für Details."

Oder mit eigenem Text:
Siehe <<installation,Installationsanleitung>>.
→ "Siehe Installationsanleitung."

Alternative Syntax:
xref:installation[Installationsanleitung]
```

---

### Includes

Große Dokumente aufteilen:

```asciidoc
= Handbuch
:toc:

include::kapitel_einfuehrung.adoc[]
include::kapitel_installation.adoc[]
include::kapitel_konfiguration.adoc[]
```

**Leveloffset:** Überschriftenebenen anpassen:
```asciidoc
include::kapitel_einfuehrung.adoc[leveloffset=+1]
```
→ Alle Überschriften in der included Datei werden um eine Ebene erhöht.

---

### Konditionelle Inhalte

Inhalte nur für bestimmte Ausgabe-Kanäle:

```asciidoc
= Dokument

ifdef::env-github[]
**Hinweis:** Du siehst dieses Dokument auf GitHub.
endif::[]

ifdef::backend-pdf[]
Diese Info erscheint nur im PDF.
endif::[]
```

**Verfügbare Umgebungen:**
- `env-github` — Gerendert auf GitHub
- `env-gitlab` — Gerendert auf GitLab
- `backend-html5` — HTML5 Ausgabe
- `backend-pdf` — PDF Ausgabe

---

### Tabellen

Einfache Tabelle:
```asciidoc
|===
| Name | Alter | Stadt
| Anna | 16 | Wien
| Ben  | 17 | Graz
| Clara| 16 | Linz
|===
```

Erste Zeile wird automatisch als Kopfzeile erkannt.

---

### Attribute (Variablen)

```asciidoc
:author: Max Mustermann
:email: max@example.com
:version: 1.0

= Handbuch Version {version}
{author} <{email}>
```

Attribute können auch gesetzt und überschrieben werden:
```asciidoc
:show-warning: true

ifdef::show-warning[]
**Warnung:** Dieses Dokument ist noch nicht fertig!
endif::[]
```

---

## 3. Live-Demo (15 min)

Erstelle ein mehrseitiges Dokument `handbuch.adoc`:

```asciidoc
= Benutzerhandbuch
:author: Max Mustermann
:toc: left
:toc-title: Inhalt
:sectnums:

== Einleitung

Dieses Handbuch beschreibt die Installation von {product-name}.

[[installation]]
== Installation

include::installation.adoc[]

[[konfiguration]]
== Konfiguration

include::konfiguration.adoc[]

== Siehe auch

Siehe <<installation,Installationsdetails>> und <<konfiguration,Konfigurationshinweise>>.
```

Erstelle `installation.adoc`:
```asciidoc
=== Voraussetzungen

* Java 17+
* 4 GB RAM
* 500 MB Festplatte

=== Schritte

. Installationsdatei herunterladen
. Ausführen
. Setup abschließen
```

Erstelle `konfiguration.adoc`:
```asciidoc
=== Grundeinstellungen

|===
| Option | Wert | Beschreibung
| port | 8080 | Server-Port
| debug | false | Debug-Modus
|===
```

**Rendern:**
```bash
asciidoctor handbuch.adoc
```

---

## 4. Kata 1: TOC und Cross-References (25 min)

Kata-Blätter zeigen.

Schüler schreiben ein längeres Dokument mit Inhaltsverzeichnis und internen Verweisen.

---

## 5. Kata 2: Include und Conditionals (25 min)

Kata-Blätter zeigen.

Schüler erstellen ein modulares Dokument mit includes, konditionellen Inhalten und Attributen.

---

## Zusammenfassung

| Konzept | Syntax |
|---------|--------|
| TOC | `:toc:`, `:toc: left/right` |
| TOC-Tiefe | `:toclevels: 2` |
| Section-Nummerierung | `:sectnums:` |
| Anchor | `[[id]]` vor Überschrift |
| Cross-Reference | `<<id,Text>>` oder `xref:id[Text]` |
| Include | `include::datei.adoc[]` |
| Conditional | `ifdef::env[] ... endif::[]` |
| Tabelle | `\|=== ... \|===` |
| Attribut definieren | `:name: wert` |
| Attribut verwenden | `{name}` |

### Ausblick

Nächste Woche: **CSV** — Comma-Separated Values.
