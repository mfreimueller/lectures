---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 24 - Markdown II: Tabellen & mehr
## DBI - 1AHIF

---

## Agenda

1. Tabellen - Grundsyntax
2. Tabellen - Ausrichtung
3. Komplexe Tabellen
4. Checkboxen (Task-Listen)
5. Checkboxen - Beispiel
6. Zitate (Blockquotes)
7. Horizontale Linien
8. Rendering-Unterschiede
9. Erweiterte Markdown-Features

---

## Lernziele

- Ich kann Tabellen in Markdown erstellen und ausrichten
- Ich kann Checkboxen (Task-Listen) verwenden
- Ich kann Zitate mit Blockquotes formatieren
- Ich kenne Rendering-Unterschiede zwischen Plattformen (GitHub, GitLab, VS Code, Obsidian)

---

## Recap: Markdown I

1. Wie schreibt man eine Überschrift Ebene 2?
2. Wie macht man Text fett?
3. Was ist der Unterschied zwischen einem Link und einem Bild?

---

## Tabellen - Grundsyntax

```markdown
| Name | Alter | Stadt |
|------|-------|-------|
| Anna | 16    | Wien  |
| Ben  | 17    | Graz  |
| Clara| 16    | Linz  |
```

| Name | Alter | Stadt |
| --- | --- | --- |
| Anna | 16 | Wien |
| Ben | 17 | Graz |
| Clara | 16 | Linz |

---

## Tabellen - Ausrichtung

```markdown
| Links | Zentriert | Rechts |
|:------|:--------:|-------:|
| Text  | Text      | Text   |
| Anna  | 16        | Wien   |
```

- `:---` = linksbündig (Standard)
- `:---:` = zentriert
- `---:` = rechtsbündig

---

## Komplexe Tabellen

- Leere Zellen: Einfach nichts zwischen die Pipe-Zeichen schreiben
- Formatierung in Zellen: **fett**, *kursiv*, `code`
- Links in Tabellen: [Text](URL)
- Zeilenumbrüche in Zellen: 
 (HTML) in manchen Implementierungen

---

## Checkboxen (Task-Listen)

```markdown
- [ ] Noch offene Aufgabe
- [x] Erledigte Aufgabe
- [ ] Wartet auf Rückmeldung
```

- `- [ ]` = nicht erledigt
- `- [x]` = erledigt
- Funktioniert auf GitHub, GitLab, VS Code, Obsidian

---

## Checkboxen - Beispiel

To-Do-Liste für ein Projekt:

```markdown
## Projekt: Webseite

- [x] Repository erstellen
- [x] README.md schreiben
- [ ] HTML-Grundgerüst
- [ ] CSS-Styling
- [ ] Navigation einbauen
- [ ] Responsive Design testen
```

---

## Zitate (Blockquotes)

```markdown
> Das ist ein Zitat.
> Es kann über mehrere Zeilen gehen.

> ## Überschrift im Zitat
> - Auch Listen sind möglich
> - In Zitaten

>> Verschachtelte Zitate
```

> Das ist ein Zitat.

---

## Horizontale Linien

```markdown
---
***
___
```

Alle drei Varianten erzeugen eine horizontale Linie

<hr>

Wird verwendet, um Abschnitte voneinander zu trennen

---

## Rendering-Unterschiede

Nicht alle Markdown-Features funktionieren überall gleich:

| Plattform | Tabellen | Checkboxen | HTML |
| --- | --- | --- | --- |
| GitHub | Ja | Ja | Nein |
| GitLab | Ja | Ja | Nein |
| VS Code | Ja | Ja | Ja |
| Obsidian | Ja | Ja | Ja |

---

## Erweiterte Markdown-Features

Je nach Plattform gibt es zusätzliche Features:

- **GitHub Flavored Markdown (GFM):** Tabellen, Task-Listen, @-Erwähnungen
- **Obsidian:** Interne Links [[Wiki-Links]], Diagramme
- **Typora:** Mathematische Formeln (LaTeX)
- **MkDocs (Material):** Admonitions, Tabs, Diagramme

---

## Zusammenfassung

- Tabellen: `| Spalte | Spalte |`, Ausrichtung mit `:---`, `:---:`, `---:`
- Checkboxen: `- [ ]` offen, `- [x]` erledigt
- Zitate mit `>` für Blockquotes
- Horizontale Linien: `---`, `***`, `___`
- Nicht jedes Feature wird überall gleich gerendert (GitHub, GitLab, VS Code, Obsidian)
