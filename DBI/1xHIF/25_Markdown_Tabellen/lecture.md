# Lecture: Woche 25 - Markdown II: Tabellen, Checkboxen, Zitate

---

## Vor der Stunde

- [ ] Beamer bereit
- [ ] VS Code mit Markdown-Vorschau geöffnet
- [ ] Beispiel Tabellen und Task-Listen vorbereitet
- [ ] GitHub-README mit Task-Liste zeigen (Browser-Tab)

---

## 1. Wiederholung: Markdown I (10 min)

**Schnelles Quiz:**

1. "Wie schreibt man eine H2-Überschrift?" → `## Text`
2. "Wie macht man Text **fett**?" → `**Text**`
3. "Wie fügt man einen Link ein?" → `[Text](URL)`
4. "Wie schreibt man Inline-Code?" → `` `code` ``

**Überleitung:** Heute lernen wir erweiterte Features: Tabellen, Checkboxen, Zitate und horizontale Linien.

---

## 2. Theorie: Tabellen in Markdown (20 min)

### Grundlegende Tabellen-Syntax

```markdown
| Spalte 1 | Spalte 2 | Spalte 3 |
|----------|----------|----------|
| Inhalt 1 | Inhalt 2 | Inhalt 3 |
| Inhalt 4 | Inhalt 5 | Inhalt 6 |
```

**Erklärung:**
- `|` trennt die Spalten
- Die **Trennlinie** (`|---|---|`) trennt die Kopfzeile vom Inhalt
- Es müssen nicht alle Striche gleich lang sein — `|---|` reicht

### Ausrichtung von Spalten

```markdown
| Links | Zentriert | Rechts |
|:------|:---------:|-------:|
| Text  |  Text     |   Text |
| Wert  |   Wert    |   Wert |
```

**Syntax:**
- `:---` = linksbündig (Standard)
- `:---:` = zentriert
- `---:` = rechtsbündig

### Tabellen mit leeren Zellen

```markdown
| Name | Alter | Bemerkung |
|------|-------|-----------|
| Anna | 16    |           |
| Ben  | 17    | Fleißig   |
```

Einfach nichts zwischen die Pipes schreiben für leere Zellen.

### Zeilenumbrüche in Tabellen

In Tabellen sind keine Zeilenumbrüche möglich. Verwende `<br>` (HTML) für Umbrüche:

```markdown
| Aufgabe | Details |
|---------|---------|
| Planung | Erste Version<br>Review einplanen |
```

---

## 3. Theorie: Checkboxen, Zitate, Horizontal Rules (15 min)

### Checkboxen / Task-Listen

```markdown
- [ ] Unerledigte Aufgabe
- [x] Erledigte Aufgabe
- [ ] Noch offen
```

**Wichtig:** Checkboxen sind kein Standard-Markdown! Sie gehören zu **GitHub Flavored Markdown (GFM)**.

**Plattform-Unterstützung:**
- GitHub: ✅ — wird als klickbare Checkbox gerendert
- GitLab: ✅
- VS Code: ✅ (nur Anzeige, nicht klickbar)
- Standard Markdown: ❌ (zeigt eckige Klammern an)

### Zitate (Blockquotes)

```markdown
> Das ist ein Zitat.

> Mehrzeiliges Zitat:
> Zeile 2 des Zitats
> Zeile 3 des Zitats

> **Verschachtelt:**
> > Inneres Zitat
```

**Tipp:** Zitate können andere Markdown-Elemente enthalten (fett, Lists, sogar Code!).

### Horizontale Linien

```markdown
---

***

___
```

**Regel:** Mindestens 3 Zeichen, Leerzeichen sind optional. Alle drei Varianten erzeugen das gleiche Ergebnis.

**Achtung:** `---` kann auch für eine H2-Überschrift verwendet werden! Kontextabhängigkeit:

```markdown
Überschrift
---
Das ist Text unter der Linie
```

In diesem Fall ist `---` eine H2-Überschrift (Alternative zu `## Überschrift`). Um Verwirrung zu vermeiden: eine Leerzeile davor und danach macht `---` zur horizontalen Linie.

---

## 4. Live-Demo: Komplexes Beispiel (10 min)

Erstelle eine Datei `demo.md`:

```markdown
# Projektplan: WebAnalyzer

> **Status:** In Entwicklung
> 
> Letztes Update: KW 37

## Aufgaben

- [x] Repository eingerichtet
- [x] Grundstruktur erstellt
- [ ] Tests schreiben
- [ ] Dokumentation fertigstellen

## Meilensteine

| Meilenstein | Datum | Status |
|:------------|:-----:|:------:|
| MVP         | KW 38 | Offen  |
| Beta        | KW 42 | Offen  |
| Release     | KW 45 | ❌     |

---

## Team

| Name | Rolle | E-Mail |
|:-----|:------|:-------|
| Anna | Dev   | anna@example.com |
| Ben  | QA    | ben@example.com  |

> *"Gut geplant ist halb gewonnen."*
```

---

## 5. Kata 1: Dokumentation mit Tabellen (20 min)

Kata-Blätter zeigen.

---

## 6. Kata 2: Checkboxen und mehr (25 min)

Kata-Blätter zeigen.

---

## Zusammenfassung

| Element | Syntax |
|---------|--------|
| Tabelle | `\| Sp1 \| Sp2 \|` + `\|---\|---\|` |
| Ausrichtung | `:---` / `:---:` / `---:` |
| Checkbox | `- [ ]` / `- [x]` |
| Zitat | `> Text` |
| Horizontale Linie | `---` oder `***` oder `___` |

### Ausblick

Nächste Woche: **AsciiDoc I** — eine mächtigere Alternative zu Markdown für technische Dokumentation.
