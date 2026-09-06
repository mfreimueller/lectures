---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 06 - Qualitätssicherung: TDD, Hooks & Review
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Pipeline beherrscht: Issue → Spec → Plan → Implement → Verify
- Akzeptanzkriterien sind testbar formuliert — bislang haben wir sie *manuell* geprüft
- Heute werden aus Kriterien automatische Tests. Und Tests werden zur Leitplanke.

---

## Warum Tests jetzt entscheidend werden

- Agenten schreiben Code schneller, als ihr ihn lesen könnt
- Vertrauen entsteht nicht durch Zusehen — sondern durch **Prüfen in Massen**
- Ein Testlauf prüft in Sekunden, was ihr manuell in einer Stunde überfliegen würdet
- Und wenn der Agent iteriert: Tests fangen Regressionen ab, die niemand bemerkt hätte

Merksatz: **Tests sind ausführbare Akzeptanzkriterien.**

---

## TDD in 60 Sekunden

```plaintext
   ┌─── RED: Test schreiben, der fehlschlägt
   │
   ├─── GREEN: minimal implementieren, bis er läuft
   │
   └─── REFACTOR: aufräumen — Tests bleiben grün
         │
         └──────── zurück zu RED (nächste Anforderung)
```

- Der rote Test ist der Auftrag — nicht "bau irgendwas"
- Bei Agenten-Arbeit gilt das doppelt: Der Test ist euer **Vertrag mit dem Modell**

---

## Aus ACs werden Tests

Aus Lektion 05:

> AC2: Leere Eingabe → leerer Output

Wird heute:

```typescript
import test from "node:test";
import assert from "node:assert/strict";
import { mdToHtml } from "./md2html.ts";

test("AC2: leere Eingabe → leerer Output", () => {
  assert.equal(mdToHtml(""), "");
});
```

`node --test` — eingebaut in Node, null Dependencies.

---

## Der rote Test als Auftrag

- Schwach: "Mach die Listen-Unterstützung fertig"
- Stark: "`npm test` hat 1 fehlschlagenden Test: AC3.
  Mach genau diesen grün — ändere nichts anderes."

<div class="highlight-box">
<p>Dieses Muster heißt <strong>Test-Gated Development</strong>: Der Agent darf nichts behaupten, was der Testlauf nicht bestätigt. "Fertig" = Tests grün, nicht "sieht gut aus".</p>
</div>

---

## Refactor mit Netz

- Grüne Tests erlauben aggressives Aufräumen — auch durch den Agenten
- Regel für den Agenten: kleine Schritte, nach jedem Schritt `npm test`
- Bricht ein Test beim Refactoring: sofort stoppen, Ursache klären
- So wird Refactoring vom Risiko zum Routineauftrag

---

## Pre-Commit-Hooks: Politik, automatisiert

```bash
#!/bin/sh
# .git/hooks/pre-commit
npx tsc --noEmit || exit 1
node --test    || exit 1
```

- Rote Tests? Dann gibt es **keinen Commit**. Ohne Diskussion.
- Achtung: `.git/hooks` liegt nur lokal — teilen via
  [husky](https://typicode.github.io/husky/) oder Setup-Skript im Repo
- Das ist dieselbe Idee wie Agent-Permissions (L03):
  Regeln, die maschinell durchgesetzt werden, muss niemand erinnern

---

## Code-Review: Was darf der Agent?

| Der Agent reviewt gut | Der Mensch reviewt allein |
| --- | --- |
| Fehlende Randfälle | Passt es zum eigentlichen Ziel? |
| Vergessene Fehlerbehandlung | Ist der Ansatz richtig — oder nur schnell? |
| Stilbrüche, Duplikate | Security-Bewertung, Datenschutz |
| Inkonsistente Namensgebung | Architektur-Entscheidungen |

Der Agent ist ein fleißiger Ersthelfer — die Verantwortung bleibt bei euch.

---

## Review-Ergebnis strukturiert (L02 lässt grüßen)

```plaintext
Reviewe diesen Diff. Prüfe ausschließlich:
Fehlerbehandlung, Randfälle, Sicherheitsprobleme.
Antworte als JSON-Liste:
[{ "datei": "...", "zeile": 0, "problem": "...", "schwere": "hoch|mittel|niedrig" }]
Keine Style-Nitpicks, keine Lobhudelei.
```

- Maschinenlesbares Ergebnis → lässt sich zählen, filtern, tracken
- Und: Der Reviewer-Subagent bekommt **nur den Diff** (L04)

---

## Halluzinierte APIs erkennen

Symptome: Paket existiert, Funktion nicht. Signaturen fast richtig. Importpfade erfunden.

Verteidigung in drei Stufen:

1. **Compiler**: `tsc --noEmit` — existiert das Symbol wirklich?
2. **Tests**: verhält sich der Code wie versprochen?
3. **Doku**: offizielle Quelle checken, nicht die Selbstsicherheit des Modells

<div class="highlight-box danger">
<p>Selbstbewusster Ton ist kein Beweis. Compiler und Tests sind die Wahrheit.</p>
</div>

---

## Definition of Done

Ein Commit ist fertig, wenn:

- [ ] Alle Tests grün (`node --test`)
- [ ] Typcheck sauber (`tsc --noEmit`)
- [ ] Diff von jemandem (Mensch *oder* Agent + Mensch) reviewt
- [ ] Keine Secrets, keine toten Kommentare, Doku angepasst
- [ ] Akzeptanzkriterien der Spec abgehakt

Gilt für euch — und für jeden Agenten, der für euch schreibt.

---

## Übung Teil 1: Rot mit Absicht

<div class="highlight-box">
<ol>
<li>Nehmt drei Akzeptanzkriterien aus eurer L05-Spec (<code>md2html.ts</code>)</li>
<li>Schreibt daraus drei Tests — zuerst müssen sie <strong>rot</strong> sein</li>
<li>Lasst den Agenten genau diese grün machen: "nur diesen Test, nichts anderes"</li>
<li>Zählt die Iterationen — vergleicht mit dem Wildwuchs aus L00</li>
</ol>
</div>

---

## Übung Teil 2: Leitplanken montieren

<div class="highlight-box">
<ol>
<li>Installiert den Pre-Commit-Hook (Typcheck + Tests) und macht ihn teamfähig</li>
<li>Beweist, dass er funktioniert: kaputten Test committen wollen → abgewiesen?</li>
<li>Lasst einen Agenten den Branch eines Teamkollegen reviewen (JSON-Format)</li>
<li>Überführt die Review-Punkte in <code>docs/review-checklist.md</code></li>
</ol>
</div>

---

## Deliverable & Offenes Lab

**Deliverable heute ins Team-Repo:**

- Getestetes Feature: rote Tests → grüne Implementation
- Teamweiter Hook + `docs/review-checklist.md`

**Offenes Lab:** Checklist gegen das eigene Repo scharf stellen —
was würde sie bei eurem aktuellen Stand anmeckern? Notieren, fixen.

---

## Ausblick: Nächste Einheit

- Ihr habt Agents benutzt, verglichen, gezähmt — Zeit für die Umkehrung:
- **Ab heute baut ihr selbst einen.** Loop, Tools, Transkript.
- Euer Harness-Projekt startet: v0.1 entsteht in dieser Einheit

Bringt funktionierendes Setup mit — heute wird viel getippt.

---

## Was wir heute gelernt haben

- Tests sind ausführbare Akzeptanzkriterien — und Verträge mit dem Modell
- Red-Green-Refactor mit Agenten: der rote Test ist der Auftrag
- Pre-Commit-Hooks setzen Regeln maschinell durch
- Agent-Reviews strukturieren (JSON), Verantwortung bleibt beim Menschen
- Halluzinationen erkennt man per Compiler, Tests und Doku — nie am Ton
