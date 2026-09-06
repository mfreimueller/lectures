---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 03 - Coding-Agent-Shootout
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Prompting ist Ingenieursarbeit: Anatomie, strukturierte Outputs, Evals mit Pass-Rate
- JSON Schema macht Antworten maschinenprüfbar
- Heute vergleichen wir die Werkzeuge, die mit all dem arbeiten — fair und messbar

---

## Was ist ein Coding-Agent?

- Ein Werkzeug, das selbstständig Code liest, schreibt und Befehle ausführt
- Ihr kennt die Formel: **Agent = LLM + Tools + Schleife** (Lektion 00)
- Läuft im Terminal oder in der IDE — direkt auf eurem Repo
- Unterschied zum Chat-Fenster: Der Agent **handelt**, er berät nicht nur

---

## Die Landschaft 2026

| Agent | Herkunft | Form | Besonderheit |
| --- | --- | --- | --- |
| Claude Code | Anthropic | Terminal | Terminal-first, AGENTS/CLAUDE.md |
| Codex CLI | OpenAI | Terminal | OpenAI-Ökosystem |
| OpenCode | Open Source | Terminal / IDE | Beliebiger Provider, rotierende Gratis-Modelle |
| Junie | JetBrains | IntelliJ & Co. | Tief in die IDE integriert |
| GitHub Copilot | GitHub | IDE + CLI | **Copilot Student: gratis** für verifizierte Schüler |

Keiner davon ist "der beste" — sie sind verschieden. Das zu erkennen ist die Aufgabe.

---

## Interaktionsmodelle

- **Terminal**: Agent arbeitet direkt auf Dateien & Git, ihr schaut ihm über die Schulter
- **IDE-integriert**: Kontext aus dem Editor, Diff-Ansichten, Klick-Buttons
- Frage dahinter: **Wer behält die Kontrolle?**
- Autopilot fühlt sich schnell an — bis man nachvollziehen muss, was passiert ist

---

## Permission-Modelle

Jeder Agent muss fragen: Darf ich das?

- Stufe 1: **Alles nachfragen** — sicher, mühsam
- Stufe 2: **Pro Session merken** — guter Alltagston
- Stufe 3: **Vollauto mit Allowlist** — nur für vertraute, begrenzte Aufgaben

<div class="highlight-box danger">
<p>Kursregel: In fremden Repos niemals Vollauto. Ihr seid verantwortlich, was auf eurer Maschine läuft.</p>
</div>

Genau so ein Permission-System bauen wir in Lektion 10 selbst.

---

## Konfigurationsflächen

- `AGENTS.md` / `CLAUDE.md` — Projektregeln im Repo (**nächste Einheit!**)
- Settings: erlaubte Tools, Modellwahl, Hooks
- MCP-Server als Tool-Nachschub (Lektion 08)
- Wer seine Regeln schreibt, bekommt bessere Ergebnisse — bei jedem dieser Tools

---

## Was kostet der Spaß?

- Modelle: Free-Tiers (L01) vs. Abo vs. Pay-per-Token
- Agenten selbst: OpenCode ist open source; Copilot Student gratis; anderes teils Abo
- Faustregel: **Die Lizenz macht nicht die Qualität — Prozess und Kontext tun es**
- Exakte Kosten pro Aufgabe rechnen wir in Lektion 12 durch

---

## Methodik: Fair vergleichen

- Identische Aufgabe, identischer Startzustand (gleiches Repo, gleicher Commit)
- Bewertungsrubrik **vorher** festlegen — nicht nachher rechtfertigen!
- Messen statt meckern: Zeit, Iterationen, Ergebnis prüfen

| Kriterium | Frage |
| --- | --- |
| Korrektheit | Macht es, was es soll? Tests grün? |
| Diff-Qualität | Minimal, lesbar, kein Over-Engineering? |
| Dauer | Wall-Clock vom ersten Prompt bis "fertig" |
| Interaktionen | Wie viele Nachfragen und Handfixes? |

---

## Setup-Checkliste

- Baseline-Repo `shootout-baseline` geklont (bekommt ihr)
- Tests laufen aktuell: 2 von 3 grün — **1 roter Test = der Bug**
- Je Teammitglied ein anderer Agent installiert und eingeloggt
  - OpenCode: läuft mit Gratis-Modellen (Anleitung: opencode.ai/docs)
  - Copilot: Student-Lizenz aktivieren (GitHub Education)
- Nur einer pro Agent — sonst vergleich ihr nichts

---

## Die drei Aufgaben

Im Baseline-Repo (kleine Node-App mit Tests):

- **Task A – Bugfix**: Eine Funktion rechnet falsch; der rote Test zeigt wo
- **Task B – Feature**: Durchschnittswert-Funktion inkl. neuem Test
- **Task C – Refactor light**: Duplikatcode zusammenführen, alle Tests bleiben grün

<div class="highlight-box warning">
<p>Harte Regel: Ihr editiert nichts von Hand — alles läuft über den Agenten. Sonst verfälscht ihr eure eigenen Messwerte.</p>
</div>

---

## Übung Teil 1: Runde 1

<div class="highlight-box">
<ol>
<li>Pro Person ein anderer Agent, alle am selben Baseline-Stand</li>
<li>Task A lösen — ausschließlich über euren Agenten</li>
<li>Stopwatch ab erstem Prompt bis "ich traue dem Ergebnis"</li>
<li>Rubrik sofort ausfüllen: Korrektheit, Diff-Qualität, Dauer, Interaktionen</li>
</ol>
</div>

Ehrlich bleiben: Ein hübscher Diff, der die Tests rot lässt, ist 0 Punkte.

---

## Übung Teil 2: Runden 2 und 3

<div class="highlight-box">
<ol>
<li>Rotieren: Task B und Task C, wieder je Person ein anderer Agent</li>
<li>Nach jeder Runde Rubrik ausfüllen — aus dem Gedächtnis wird nichts</li>
<li>Am Ende stehen pro Agent drei bewertete Läufe in eurer Matrix</li>
<li>Notiert auch kuriose Momente — daraus wird die Diskussion</li>
</ol>
</div>

---

## Debriefing: das Klassen-Leaderboard

- Jedes Team trägt seine Matrix in die gemeinsame Klassentabelle ein
- Wo waren sich alle einig? Wo gehen die Meinungen auseinander?
- Vorsicht Interpretation: 3 Läufe sind keine Statistik — aber ein erster Eindruck
- Eure Daten begleiten uns durchs ganze Jahr: Stimmt der Eindruck noch in Lektion 12?

---

## Deliverable & Offenes Lab

**Deliverable heute ins Team-Repo:**

- `docs/agent-shootout.md` — eure Matrix: 3 Agenten × 3 Tasks × Rubrik
- Eintrag in die gemeinsame Klassen-Leaderboard-Tabelle

**Offenes Lab:** Konfigurationsfläche eines Agenten erkunden —
Settings, erlaubte Tools, Modellwahl. Was lässt sich dort regeln,
was wir heute manuell überwacht haben?

---

## Ausblick: Nächste Einheit

- Derselbe Agent, dieselbe Aufgabe — und plötzlich deutlich bessere Ergebnisse
- Was hat sich geändert? Nicht das Modell.
- **Context Engineering**: AGENTS.md, Skills, Subagents

Bringt eure Shootout-Ergebnisse mit — wir brauchen sie als Vorher-Werte.

---

## Was wir heute gelernt haben

- Agenten-Landschaft: Claude Code, Codex CLI, OpenCode, Junie, Copilot
- Unterscheidungsmerkmale: Interaktion, Permissions, Konfiguration, Kosten
- Faire Vergleiche brauchen Rubrik + identischen Startzustand + echte Messung
- Erst messen, dann urteilen — im Kurs wie im Berufsleben
