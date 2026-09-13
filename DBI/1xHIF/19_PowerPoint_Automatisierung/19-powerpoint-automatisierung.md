---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 19 - Automatisiert erzeugen
## DBI - 1xHIF

---

## Agenda

1. Wann lohnt sich Automatisierung?
2. Folien aus Excel-Daten
3. `python-pptx` im Überblick
4. Markdown-Präsentationen mit Marp
5. Klick-Tool oder Code — eine Diskussion

---

## Lernziele

- Ich weiß, wann sich automatisiertes Erzeugen von Folien lohnt
- Ich kenne `python-pptx` als Werkzeug, um Folien aus Code zu erzeugen
- Ich kenne Marp als Weg, Präsentationen aus Markdown zu bauen
- Ich kann begründen, wann ein Klick-Tool und wann Code sinnvoller ist

---

## Wann lohnt sich Automatisierung?

- Immer, wenn **viele ähnliche Folien** aus Daten entstehen sollen (ein Foliensatz pro
  Mitarbeiter:in, Produkt, Kapitel, …)
- Von Hand: mühsam, fehleranfällig, schwer zu aktualisieren
- Mit Code: einmal Vorlage bauen, beliebig oft wiederholen — derselbe Gedanke wie der
  Serienbrief in Word

---

## Folien aus Excel-Daten

- Grundidee: **eine Excel-Zeile = eine Folie**
- Werkzeug: `python-pptx` (Python-Bibliothek) liest die Exceldaten und erzeugt daraus
  `.pptx`-Folien

---

## `python-pptx` im Überblick

```python
from pptx import Presentation

prs = Presentation()
folie = prs.slides.add_slide(prs.slide_layouts[1])
folie.shapes.title.text = "Mitarbeiter des Monats"
folie.placeholders[1].text = "Name: Anna Bauer"
prs.save("ausgabe.pptx")
```

Für jede Zeile in der Exceltabelle eine Schleife → eine neue Folie.

---

## Markdown-Präsentationen mit Marp

- Präsentation als reiner Text schreiben (Markdown), `---` trennt Folien
- Ein Tool (Marp) rendert daraus fertige Folien
- Genau so sind übrigens auch **diese Folien hier** entstanden!

---

## Klick-Tool oder Code — eine Diskussion

| Klick-Tool (PowerPoint) | Code (`python-pptx`/Marp) |
|---|---|
| Schnell für Einzelstücke | Lohnt sich bei Wiederholung |
| Volle visuelle Kontrolle | Versionskontrolle möglich (Git) |
| Mühsam bei vielen ähnlichen Folien | Braucht Programmierkenntnisse |

**Diskussion:** Wann würdet ihr was wählen?

---

## Auftrag (optional, falls Zeit bleibt)

Baut mit `python-pptx` ein kleines Skript, das aus einer Exceltabelle (z. B. Namen +
ein Fakt pro Person) automatisch mehrere Folien erzeugt.

---

<!-- _class: invert -->

## Summary

- Automatisierung lohnt sich bei vielen ähnlichen, datengetriebenen Folien
- `python-pptx` erzeugt Folien aus Python-Code, Marp aus Markdown
- Die Wahl zwischen Klick-Tool und Code hängt von Wiederholung und Datenmenge ab
- Nächste Woche: Vortrag Block 1
