---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 04 - Context Engineering: Skills & Subagents
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Agenten vergleicht man fair: Rubrik, identischer Startzustand, echte Messung
- Eure Shootout-Matrizen liegen vor — gleiche Tools, teils unterschiedliche Qualität
- Heute klären wir, warum. Und die Antwort ist keine Modellfrage.

---

## Die wichtigste Erkenntnis zuerst

- Derselbe Agent, dieselbe Aufgabe — verschiedene Ergebnisqualität
- Der Unterschied war selten das Modell, sondern der **Kontext**
- Kontext = alles, was das Modell beim Zug sieht: Regeln, Doku, Dateien, Verlauf
- **Context Engineering**: Kontext kuratieren statt drauflos hoffen

---

## Warum "mehr" nicht "besser" ist

- Das Kontextfenster ist endlich und kostet Geld (Lektion 01)
- Irrelevanter Kontext lenkt ab und verschlechtert Ergebnisse messbar
- Die Goldene Mitte: genau das Wissen, das die aktuelle Aufgabe braucht
- Merksatz: **Kontext ist eine Ressource — budgetiert sie**

---

## AGENTS.md — die Hausordnung für Agenten

- Eine Markdown-Datei im Repo-Root, die viele Agenten automatisch lesen
- `CLAUDE.md` funktioniert für Claude Code analog
- Inhalt: Stack & Versionen, Befehle, Konventionen, Verbote
- Liegt in Git → Regeln gelten fürs ganze Team, reviewbar wie Code

```markdown
# AGENTS.md

## Build & Test
- `npm test` — muss vor jedem Commit grün sein

## Konventionen
- TypeScript strict, kein `any`
- Code auf Englisch, Fehlermeldungen auf Deutsch

## Nie tun
- Keine neuen Dependencies ohne Absprache
- `.env` niemals committen
```

---

## Was gehört rein — und was nicht?

**Rein:** überprüfbare Fakten, Befehle, harte Grenzen

**Nicht rein:** Wünsche, Romane, sich widersprechende Regeln

<div class="highlight-box">
<p>Der Kollegen-Test: Könnte ein neuer Mitarbeiter allein damit arbeiten? Wenn nicht, ist eure AGENTS.md noch nicht fertig.</p>
</div>

---

## Doku für Maschinen

- Agenten lieben Struktur: klare README-Abschnitte, Beispiele, Typen
- Gute Fehlermeldungen sind Doku für Modelle *und* Menschen zugleich
- Was maschinenlesbar ist, wird von Agenten korrekt benutzt
- Vorschau: In Lektion 13 machen wir das zum Programm ("KI-ready Software")

---

## Skills: gepacktes Wissen

- Skill = Paket aus Anweisungen (+ optional Skripten), das der Agent bei Bedarf lädt
- Beispiel "pdf-report": welche Bibliothek, welche Stilregeln, welcher Ablauf
- Vorteil: Der Kontext wird nur geladen, wenn die Aufgabe ihn braucht
- Die Umsetzung ist toolspezifisch — die Idee kennen sie alle:
  **Wissen auslagern, on-demand nachladen**

---

## Subagents: Spezialisten rufen

- Der Hauptagent delegiert an einen Subagent mit eigenem, sauberem Kontext
- Zwei Gewinne:
  - **Isolation**: Recherche verschmutzt den Hauptkontext nicht
  - **Parallelität**: mehrere Subagents arbeiten gleichzeitig
- Klassiker: Ein Reviewer-Subagent, der *nur* den Diff bekommt — nichts anderes
- Wir bauen genau das in Lektion 11 selbst nach

---

## Memory: was bleibt

- Manche Tools merken sich Dinge über Sessions hinweg
- Gefahr: Falsches wird festgehalten — und immer wieder verstärkt
- Regel: Memory regelmäßig reviewen, nie blind vertrauen
- Unser Ersatz im Kurs: `AGENTS.md` + Engineering Journal im Repo —
  transparent, versioniert, vom ganzen Team geprüft

---

## Anti-Pattern: Kontext-Müll

<div class="highlight-box warning">
<ul>
<li>Eine AGENTS.md mit 500 Zeilen, die niemand mehr pflegt</li>
<li>Widersprüchliche Regeln: "immer Tests schreiben" vs. "bei Kleinigkeiten egal"</li>
<li>Tote Links, alte Versionsnummern, längst entfernte Befehle</li>
<li>Sensible Daten im Kontext: .env-Inhalte oder Keys in Chatverläufe pasten</li>
</ul>
</div>

Kontext-Müll wirkt wie schlechte Dokumentation: schlimmer als keine.

---

## Übung Teil 1: Das Chaos-Repo

<div class="highlight-box">
<ol>
<li>Klont das Sample-Repo <code>chaos-shop</code> — bewusst schlecht dokumentiert</li>
<li>Zuerst: Standardtask laufen lassen, OHNE etwas anzupassen (Zeit &amp; Ergebnis notieren)</li>
<li>Dann: <code>AGENTS.md</code> schreiben — Befehle, Konventionen, Verbote</li>
<li>Denselben Task wiederholen und alles erneut messen</li>
</ol>
</div>

Vorher/Nachher am selben Task — sonst ist der Vergleich wertlos.

---

## Übung Teil 2: Messen wie Ingenieur:innen

<div class="highlight-box">
<ol>
<li>Metriken: Dauer, Iterationen, Diff-Zeilen, Tests grün?</li>
<li>Ergebnisse in <code>docs/context-experiment.md</code> tabellieren</li>
<li>Mindestens zwei Tasks pro Messung</li>
<li>Reihenfolge zwischen Teammitgliedern tauschen — gegen den Reihenfolge-Effekt</li>
</ol>
</div>

Vergleicht mit euren Shootout-Werten: Erkennt ihr denselben Effekt?

---

## Deliverable & Offenes Lab

**Deliverable heute:**

- PR gegen `chaos-shop`: `AGENTS.md` + minimale Doku-Korrekturen
- `docs/context-experiment.md` mit Vorher/Nachher-Messung

**Offenes Lab:** Eigenes Team-Repo agent-ready machen —
`AGENTS.md` v1 landet dort und begleitet euer Harness bis zum Demo Day.

---

## Ausblick: Nächste Einheit

- Kontext geregelt, Werkzeug konfiguriert — jetzt der Prozess dazwischen
- **Spec-driven Development**: erst Spezifikation, dann Plan, dann Code
- Wir kehren zurück zu `md2html.ts` — und machen aus dem Vibe-Ergebnis Ingenieursarbeit

---

## Was wir heute gelernt haben

- Kontextqualität schlägt Prompt-Tricks — messbar
- `AGENTS.md`: Befehle, Konventionen, Verbote — versioniert im Repo
- Skills laden Wissen on-demand; Subagents isolieren und parallelisieren
- Memory kritisch prüfen; Kontext-Müll vermeiden
- Vorher/Nachher-Messung macht Context-Engineering beweisbar
