---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# Word – Formatierung & Stile
## DBI 1xHIF

---

## Agenda

1. Direkte Formatierung vs. Stile
2. Vorteile von Stilen
3. Wichtige Tastenkürzel
4. Ein `.docx` ist eigentlich ein ZIP-Archiv
5. Herausforderung: Refactor Challenge

---

## Lernziele

- Ich kenne den Unterschied zwischen direkter Formatierung und Formatvorlagen (Stilen)
- Ich kann integrierte Stile anwenden und anpassen
- Ich kann einen eigenen Stil erstellen
- Ich weiß, dass ein `.docx` intern aus XML-Dateien in einem ZIP-Archiv besteht

---

## Direkte Formatierung vs. Stile

Zwei Überschriften, gleich formatiert: markieren, fett, groß, blau.

**Frage:** Was passiert, wenn ich alle Überschriften von Blau auf Grün ändern will?

- **Direkt formatiert:** jede Überschrift einzeln anfassen
- **Über einen Stil formatiert:** einmal den Stil ändern — fertig

---

## Direkte Formatierung vs. Stile

| Art der Formatierung | Vorgehen | Nachteil |
|---|---|---|
| **Direkt** | Text markieren → Fett → Groß → Blau | Änderungen mühsam, oft inkonsistent |
| **Über Stil** | Text markieren → Stil „Überschrift 1" anwenden | Stil einmal ändern = überall geändert |

---

## Vorteile von Stilen

- **Konsistenz** — alle Überschriften einer Ebene sehen automatisch gleich aus
- **Schnelle Änderung** — ein Stil bearbeiten statt jede Stelle einzeln
- **Automatische Verzeichnisse** — ein Inhaltsverzeichnis erkennt nur echte Überschriften-Stile
- **Navigation** — durchs Dokument über die Überschriftenstruktur springen

---

## Wichtige Tastenkürzel

| Kürzel | Aktion |
|---|---|
| `Strg+Alt+1` | Stil „Überschrift 1" |
| `Strg+Alt+2` | Stil „Überschrift 2" |
| `Strg+Alt+3` | Stil „Überschrift 3" |
| `Strg+Umsch+N` | Stil „Standard" (Fließtext) |
| `Strg+Leertaste` | Direkte Formatierung entfernen, Stil bleibt erhalten |

---

## Ein `.docx` ist eigentlich ein ZIP-Archiv

- Word-Dateien sehen aus wie eine Blackbox — sind es aber nicht
- Intern: ein `.docx` ist ein ZIP-Archiv voller XML-Dateien
- `word/document.xml` enthält den eigentlichen Text, `word/styles.xml` alle Formatvorlagen

<div class="highlight-box">
<p>Live-Demo: Datei umbenennen auf <code>.zip</code>, entpacken, <code>document.xml</code> ansehen.</p>
</div>

---

## Herausforderung: Refactor Challenge

Ihr bekommt ein Dokument, das von Überschrift zu Überschrift anders aussieht — voller
direkter Formatierung.

**Auftrag:** Baut es so um, dass **ausschließlich Formatvorlagen** die Formatierung
bestimmen.

**Erfolgskriterium:** Nach einem Wechsel des Formatvorlagen-Satzes sieht das komplette
Dokument in unter 5 Sekunden konsistent anders aus.

---

## Peer-Test

- Tauscht euer fertiges Dokument mit einem anderen Team
- Führt den 5-Sekunden-Test **am Dokument des anderen Teams** durch
- Meldet zurück: bestanden, oder wo genau nicht?

---

<!-- _class: invert -->

## Summary

- Direkte Formatierung wirkt nur an einer Stelle — Stile wirken überall, wo sie angewendet sind
- Ein Stil einmal ändern, statt jede Textstelle einzeln
- Ein `.docx` ist kein Mysterium, sondern ZIP + XML
- Nächste Woche: Tabellen & Grafiken
