---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 02 - Prompt Engineering & Evals
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- LLM = nächste-Token-Vorhersage; Tokens sind die Abrechnungseinheit
- Output ist teurer als Input — präzise Antworten fordern!
- Euer Chat-Client mit `usage`-Metering liegt im Team-Repo

Heute: Prompting von Glaskugel-Raten zu einer Ingenieursdisziplin.

---

## Prompting ist Ingenieursarbeit

- Ein Prompt ist **Code**: er hat eine Funktion, man kann ihn testen
- Also behandeln wir Prompts wie Code: versionieren, dokumentieren, messen
- "Bei mir hat es gerade funktioniert" ist kein Qualitätssiegel
- Ziel heute: Prompts, deren Qualität ihr **beweisen** könnt

---

## Anatomie eines guten Prompts

| Baustein | Beantwortet | Beispiel |
| --- | --- | --- |
| Rolle | Wer ist das Modell? | "Du bist ein erfahrener Code-Reviewer." |
| Aufgabe | Was genau soll getan werden? | "Reviewe den folgenden Diff auf Bugs." |
| Kontext | Was muss es dafür wissen? | Projekt-Standards, relevante Dateien |
| Constraints | Welche Grenzen gelten? | "Nur echte Bugs, kein Style-Nitpicking." |
| Output-Format | Wie soll die Antwort aussehen? | "JSON-Liste: {zeile, schwere, begründung}" |

---

## System-Prompt vs. User-Prompt

- `system`: dauerhafte Verhaltensregeln — die "Hausordnung" des Modells
- `user`: die jeweilige konkrete Aufgabe
- `assistant`: frühere Antworten des Modells (Konversationsverlauf)
- Im Harness wird der System-Prompt später eure wichtigste Stellschraube

```plaintext
messages[0]  → system:   "Du bist ein präziser Assistent..."
messages[-1] → user:     "Analysiere diese Datei..."
```

---

## Zero-Shot vs. Few-Shot

- **Zero-Shot**: Aufgabe beschreiben, fertig
- **Few-Shot**: 2–5 Beispiele mit gewünschtem Input *und* Output mitliefern
- Few-Shot lohnt sich bei: Format-Fragen, Grenzfällen, Hausstil
- Aber: Jedes Beispiel kostet Input-Tokens — gezielt einsetzen

```plaintext
Beispiel 1: Eingabe "super gelaufen"  → {"sentiment":"positiv"}
Beispiel 2: Eingabe "geht so"         → {"sentiment":"neutral"}
Jetzt: Eingabe "<neue Nachricht>"     → ?
```

---

## Chain-of-Thought

- Anweisung: *"Denke Schritt für Schritt, bevor du antwortest"*
- Hilft bei Logik, Mathe, mehrstufigen Aufgaben
- Reasoning-Modelle denken ohnehin intern — dort wirkt der Trick schwächer
- Achtung: sichtbares Denken kostet **Output-Tokens**

---

## Strukturierte Outputs: JSON Schema

```typescript
body: JSON.stringify({
  model: process.env.MODEL,   // aus .env — Anbieter egal
  messages,
  response_format: {
    type: "json_schema",
    json_schema: {
      name: "sentiment",
      strict: true,
      schema: {
        type: "object",
        properties: {
          sentiment: { type: "string",
                       enum: ["positiv", "neutral", "negativ"] },
          confidence: { type: "number" }
        },
        required: ["sentiment", "confidence"],
        additionalProperties: false
      }
    }
  }
})
```

---

## Warum strukturierte Outputs entscheidend sind

- Maschinenlesbar → **testbar** → automatisierbar
- Parse-Fehler sofort erkennbar, statt stiller Halluzinationen im Fließtext
- Basis für Function Calling (L07) und MCP (L08)
- Nicht jedes Modell unterstützt strenge Schemas —
  Fallback: Schema in den Prompt schreiben und Antwort selbst validieren

---

## Kontext-Hygiene: Delimiter

- Trenne Anweisung klar von Daten: `"""..."""`, `<dokument>...</dokument>`
- Das Modell weiß dann, was Anweisung ist — und was nur Material
- Erster Schutz gegen Prompt Injection (vertiefen wir in Lektion 10)

```plaintext
Fasse das folgende Ticket zusammen:

<ticket>
{inhalt aus dem Ticketsystem}
</ticket>
```

---

## Anti-Patterns

<div class="highlight-box warning">
<ul>
<li>Vage Aufgaben: "mach das besser"</li>
<li>Überladene Mega-Prompts: zehn Aufgaben in einem</li>
<li>Widersprüchliche Constraints: "kurz, aber erzähl alles vollständig"</li>
<li>Format vergessen — dann rät das Modell einfach</li>
<li>Beispiele, die das Gegenteil des Gewünschten zeigen</li>
<li>Zauberworte wie "SEHR WICHTIG!!!" — Wirkung unzuverlässig</li>
</ul>
</div>

---

## Die Schlüsselfrage

**Woher weißt du, dass dein Prompt gut ist?**

- Weil du zweimal Glück hattest? Das war Vibecoding.
- Wir wollen: dieselbe Frage, 100 Fälle, objektive Antwort
- Genau das leisten **Evals** — automatisierte Tests für Prompts

---

## Evals: Golden Sets & Assertions

- **Golden Set**: kuratierte Testfälle mit erwarteten Ergebnissen
  - inklusive hässlicher Grenzfälle (leere Eingabe, Fremdsprache, Ironie)
- **Assertions**: maschinelle Prüfung pro Fall
  - Schema konform? Pflichtfelder vorhanden? Inhalt korrekt?
- **Metriken**: Pass-Rate, Ø Tokens, Ø Dauer pro Fall

---

## Eval-Runner in TypeScript

```typescript
for (const c of cases) {
  const out = await runPrompt(systemPrompt, c.input);
  results.push({
    id: c.id,
    schemaOk: matchesSchema(out, schema),
    contentOk: checkExpectations(out, c.expect),
  });
}

const passRate =
  results.filter(r => r.schemaOk && r.contentOk).length / cases.length;
console.log(`Pass-Rate: ${(passRate * 100).toFixed(1)}%`);
```

Jede Prompt-Änderung → Eval laufen lassen → Regression sofort sichtbar.

---

## Übung Teil 1: Der Prompt-Katalog

<div class="highlight-box">
<ol>
<li>Fünf Micro-Tasks: Klassifikation, Extraktion, Transformation, Generierung, Review-Anweisung</li>
<li>Je Task ein bester Prompt nach der Anatomie (Rolle, Aufgabe, Kontext, Constraint, Format)</li>
<li>Überall strukturierte Outputs (JSON Schema)</li>
<li>Ablage: <code>prompt-library/&lt;task&gt;/prompt.md</code> + <code>schema.json</code></li>
<li>System-/User-Anteil sauber trennen</li>
</ol>
</div>

---

## Übung Teil 2: Das Eval-Skript

<div class="highlight-box">
<ol>
<li>Pro Task mindestens 5 Testfälle — davon 2 Grenzfälle</li>
<li>Eval-Runner in TypeScript: lädt Prompt + Cases, ruft Modell, validiert Antworten</li>
<li>Metriken je Task: Pass-Rate, Ø Tokens, Ø Dauer</li>
<li>Den schwächsten Prompt iterativ verbessern bis Pass-Rate 100%</li>
<li>Jede Iteration committen — die Historie ist der Beweis</li>
</ol>
</div>

---

## Deliverable & Offenes Lab

**Deliverable heute ins Team-Repo:**

- `prompt-library/` — 5 Tasks mit Prompts, Schemas, Cases, `results.json`

**Offenes Lab:** Schwächsten Task weiter härten; Grenzfälle sammeln.

Nächste Einheit: **Coding-Agent-Shootout** — Claude Code vs. Codex vs. OpenCode vs. Junie.
Bringt einen Laptop mit, auf dem ihr Tools installieren dürft.

---

## Was wir heute gelernt haben

- Prompt-Anatomie: Rolle, Aufgabe, Kontext, Constraint, Format
- System-Prompt steuert dauerhaft, User-Prompt stellt die Aufgabe
- Few-Shot und CoT gezielt einsetzen — beides kostet Tokens
- JSON Schema macht Outputs testbar — Basis für alles Weitere
- Evals verwandeln Bauchgefühl in messbare Pass-Rate
