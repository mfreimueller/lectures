---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 00 - Kickoff: Vibe vs. Engineering
## Professional Agentic Engineering · SJ 2026/27

---

## Was ist das für ein Fach?

- **Freigegenstand** für neugierige Informatik-Schüler:innen (4. & 5. Klasse)
- Blockeinheiten: **200 Minuten alle zwei Wochen**
- Unbenotet — ihr arbeitet für euch, nicht für eine Note
- Prinzip Übung (wie an der Uni): kurzer Input von uns, **viel Output von euch**
- Alles dreht sich um ein Jahresprojekt, das ihr in Teams baut

---

## Warum gibt es diesen Kurs?

- KI verändert Softwareentwicklung gerade grundlegend
- Die Frage ist nicht mehr *ob* ihr mit KI arbeitet — sondern **wie gut**
- "Irgendwie prompten bis es geht" funktioniert in Hobby-Projekten
- In der Industrie braucht es: Struktur, Planbarkeit, Messbarkeit, Verantwortung
- Genau dazwischen sitzt dieser Kurs

---

## Unser Leitmotiv

> KI-Nutzung, aber richtig — weg vom Hype (Vibecoding), hin zum ingenieursmäßigen Vorgehen: strukturiert, planbar, messbar dokumentiert.

---

## Zwei Säulen des Kurses

**Säule 1: Software MIT KI bauen**

- Coding-Agents professionell einsetzen
- Jahrzehnte an Best Practices bleiben verpflichtend

**Säule 2: Software FÜR KI bauen**

- KI-ready Software: maschinenlesbar, agenten-tauglich
- Eigene AI-Features und sogar eigene Agenten entwickeln

---

## Vibecoding vs. Agentic Engineering

| Aspekt | Vibecoding | Agentic Engineering |
| --- | --- | --- |
| Ziel | "Irgendwie funktioniert's" | Definierte Anforderungen erfüllen |
| Vorgehen | Drauflos prompten, hoffen | Spec → Plan → Umsetzung → Verifikation |
| Wiederholbar | Nein — jedes Mal anderes Ergebnis | Ja — dokumentierter Prozess |
| Qualität | Augen zu und durch | Tests, Reviews, Evals |
| Kosten | Unbekannt | Gemessen und gesteuert |

---

## Was ist ein Agent?

```plaintext
Agent = LLM + Tools + Schleife
```

- **LLM** trifft Entscheidungen auf Basis von Text
- **Tools** sind Dinge, die er *tun* darf: Dateien lesen, Befehle ausführen, APIs rufen
- **Schleife**: Ergebnis prüfen, weitermachen, bis das Ziel erreicht ist
- Jeder Coding-Agent (Claude Code, Codex, OpenCode, Junie) ist genau das

---

## Begriffe, die uns begleiten (1/2)

| Begriff | Kurz erklärt | Behandelt in |
| --- | --- | --- |
| LLM | Vorhersagt das wahrscheinlichste nächste Token | L01 |
| Token | Textbaustein; die Abrechnungseinheit der KI | L01 |
| Prompting | Systematische Steuerung des Modells | L02 |
| Coding-Agent | Werkzeug, das selbstständig Code liest/schreibt/ausführt | L03 |
| Context Engineering | Der Agent bekommt genau das Wissen, das er braucht | L04 |

---

## Begriffe, die uns begleiten (2/2)

| Begriff | Kurz erklärt | Behandelt in |
| --- | --- | --- |
| Spec-driven Development | Erst Spezifikation, dann Umsetzung | L05 |
| Function Calling / Tools | Funktionen, die das Modell selbst aufrufen darf | L07 |
| MCP | Standard-Protokoll für Tools & Datenquellen | L08 |
| RAG | Wissen aus Dokumenten in den Kontext holen | L09 |
| A2A | Agent-zu-Agent-Kommunikation | L11 |

Keine Sorge: Jeder Begriff wird erklärt, wenn er drankommt.

---

## Kurs-Roadmap: 5 Module

| Modul | Lektionen | Thema |
| --- | --- | --- |
| A - Fundament | 00–02 | Wie LLMs ticken, Kosten, Prompts & Evals |
| B - Professionell arbeiten | 03–06 | Agents vergleichen, Context, Specs, QA |
| C - Eigenbau-Harness | 07–12 | Vom While-Loop zum produktiven Agenten |
| D - Produkt & Gesellschaft | 13–15 | AI-ready Software, Ökonomie, Verantwortung |
| E - Finale | 16–17 | Projekt-Sprint & Demo Day |

---

## Euer Jahresprojekt: der eigene Harness

- Ab Lektion 07 baut ihr euren **eigenen Agenten** von Grund auf — in TypeScript
- Version für Version wird er mächtiger:

| Version | Kann dann... |
| --- | --- |
| v0.1 | Denken + Dateien lesen + Befehle ausführen |
| v0.2 | MCP-Server als Tools nutzen |
| v0.3 | Wissen aus Dokumenten beantworten (RAG) |
| v0.4 | Sicher arbeiten: Permissions & Audit-Log |
| v0.5 | Mehrere Agenten parallel orchestrieren |
| v0.6 | Mit Budget & Kostenkontrolle wirtschaften |

---

## Ablauf einer Blockeinheit (200 min)

| Phase | Zeit | Was passiert |
| --- | --- | --- |
| Standup | 15′ | Teams: was lief seit letztem Mal, Blockaden? |
| Input | 45′ | Konzept + Live-Demo (diese Folien) |
| Geführte Übung | 60′ | Alle bauen dasselbe — angeleitet |
| Offenes Lab | 50′ | Teams arbeiten am eigenen Projekt |
| Retro & Commit | 10′ | Ergebnis pushen, Ausblick |

---

## Organisation: Teams & Repo

- Teams aus **2–3 Personen**, ein gemeinsames Team-Repo fürs ganze Jahr
- Alle Übungs-Ergebnisse und Harness-Versionen landen dort
- **Engineering Journal**: kurze Einträge pro Einheit (was haben wir gelernt, was war schwierig?)
- Nicht benotet — aber euer Repo ist am Ende euer Portfolio

---

## Tooling-Setup

- **Node.js ≥ 22 LTS** + npm
- Editor: VS Code (oder IntelliJ mit Node-Plugin)
- Git + GitHub-Account (habt ihr ohnehin)
- Kostenloser API-Key eines Anbieters (Groq, Gemini, Mistral oder OpenCode) — gleich mehr dazu
- `npx tsx` zum direkten Ausführen von TypeScript

---

## Modell-Zugang: euer Gratis-Labor

| Lane | Was bietet sie? | Anmeldung |
| --- | --- | --- |
| Groq | offene Modelle, sehr schnell | nur Account |
| Google AI Studio (Gemini) | Flash-Modelle, großzügig | Google-Account |
| Mistral (Experiment) | EU-Anbieter, Coding-Modelle | Account + SMS |
| OpenCode Zen | wechselnde Gratis-Modelle | nur Account |
| Ollama (lokal) | null Cloud, null Kosten | Installation |

- Alle sprechen denselben Standard: **OpenAI-kompatibel**
- Merksatz: **Wer den Standard spricht, kann jeden Anbieter wechseln**

GitHub Models wurde im Juli 2026 ersatzlos eingestellt — genau deshalb bauen wir anbieterneutral.

---

## Keys & Secrets: eiserne Regeln

<div class="highlight-box danger">
<ul>
<li>Keys gehören in <code>.env</code> — niemals direkt in den Code</li>
<li><code>.env</code> steht in <code>.gitignore</code> — und zwar VOR dem ersten Commit</li>
<li>Nie Keys in Screenshots, Slides, Chats oder READMEs zeigen</li>
<li>Key versehentlich geleakt? Sofort beim Anbieter widerrufen und einen neuen erzeugen</li>
</ul>
</div>

Das gilt für diesen Kurs — und für euer gesamtes Berufsleben.

---

## Demo: Ein Coding-Agent live

Schauen wir einem Agenten bei der Arbeit zu:

- Aufgabe stellen und beobachten: Was macht er selbstständig?
- Wann fragt er nach? Wann entscheidet er allein?
- Wie sieht die Änderung am Ende aus?

*Live-Demo durch die Lehrperson*

---

## Die Aufgabe (für beide Runden)

Schreibe ein Node-Skript `md2html.ts`, das Markdown nach HTML umwandelt:

- Unterstützt: `#`, `##`, `###` Überschriften, Absätze, `**fett**`, `*kursiv*`
- Unterstützt: Listen mit `-`
- Leere Eingabedatei → leere Ausgabe
- Aufruf: `npx tsx md2html.ts input.md > output.html`

---

## Übung Teil 1: Die Vibe-Challenge

<div class="highlight-box warning">
<ol>
<li>Löse die Aufgabe rein intuitiv — prompte einfach drauflos</li>
<li>Kein Plan, keine Requirements, kein Testen vor dem Prompten</li>
<li>Weiter iterieren, bis der Output "irgendwie funktioniert"</li>
<li>Notiere dabei: Anzahl Prompts, Zeit, Frust-Momente</li>
</ol>
</div>

20 Minuten — danach: Stop, auch wenn es unvollendet ist.

---

## Übung Teil 2: Die Spec-Variante

<div class="highlight-box">
<ol>
<li>Schreibe zuerst 5–8 konkrete Anforderungen (deine Spec)</li>
<li>Leite daraus Testfälle ab: Beispieldateien + erwartetes HTML</li>
<li>Dann erst prompten — mit der Spec als Kontext im Prompt</li>
<li>Jede Iteration gegen deine Tests prüfen</li>
<li>Abschluss: Diff reviewen — würdest du das selbst mergen?</li>
</ol>
</div>

Gleiche Aufgabe, gleiche Zeit — aber strukturiertes Vorgehen.

---

## Debriefing: Was haben wir gesehen?

- Welche Runde hatte am Ende mehr Vertrauen in den Code?
- Wie viele Iterationen brauchte jede Runde?
- War das Ergebnis der Spec-Runde reproduzierbar?
- Was fehlte dem Vibe-Ergebnis alles? (Tests? Fehlerfälle? Doku?)
- Merksatz: **Die Qualität steckt nicht im Prompt — sondern im Prozess drumherum**

Wir wiederholen diesen Vergleich in Lektion 05 — dann mit echten Agents.

---

## Ausblick: Nächste Einheit

- **L01 – LLM-Grundlagen & Kosten:** Was wirklich beim Aufruf eines Modells passiert
- Tokens, Kontextfenster, Temperatur — und was das alles kostet
- Wir bauen unseren ersten eigenen API-Client in TypeScript

Bis dahin: Setup fertigstellen, falls heute etwas geklemmt hat.

---

## Was wir heute gelernt haben

- Kursaufbau: 18 Blockeinheiten, 5 Module, Jahresprojekt eigener Harness
- Unterschied Vibecoding vs. Agentic Engineering
- Agent = LLM + Tools + Schleife
- Erste Übung: strukturierter Prozess schlägt drauflos-Prompten
- Setup: Node, API-Key eines Free-Providers, Secrets-Regeln
