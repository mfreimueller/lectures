---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 01 - LLM-Grundlagen & Kosten
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Agent = LLM + Tools + Schleife
- Vibecoding ist kein Engineering: Spec → Plan → Umsetzung → Verifikation
- Wir arbeiten anbieterneutral: ein OpenAI-kompatibler Standard, kostenlose Free-Tiers

Heute schauen wir in die Black Box — und auf den Preis.

---

## Wie funktioniert ein LLM?

- Trainiert auf riesigen Textmengen: lernt Wahrscheinlichkeiten für das **nächste Token**
- Kein "Wissen" wie eine Datenbank — statistische Muster, die wie Wissen wirken
- Das Interface ist absurd simpel: Text rein → Text raus
- Alles, was wir dieses Jahr bauen, sind geschickte Aufrufe dieser einen Schnittstelle

```plaintext
Eingabe: "Die Hauptstadt von Österreich ist"
Modell:  [ Wien: 87% | der: 4% | eine: 2% | ... ]
         → wählt ein Token (Temperatur entscheidet mit)
```

---

## Tokens: die Währung der KI

- Modelle sehen keine Buchstaben oder Wörter — sondern **Tokens**
- Ein Token ≈ ¾ Wort (englisch); Deutsch, Code und Zahlen zerfallen stärker
- Kontextfenster, Abrechnung und Geschwindigkeit — alles zählt in Tokens
- Wer Tokens versteht, versteht Kosten *und* Grenzen von LLMs

```plaintext
"Agentic Engineering macht Spaß"
→ ["Ag", "entic", " Eng", "ineer", "ing", " macht", " Spaß"]

"SELECT * FROM users WHERE id = 42"
→ ca. 10–12 Tokens — Code tokenisiert unfreundlich
```

*(illustrativ — exakt zählen wir gleich selbst nach)*

---

## Kontextfenster: das Arbeitsgedächtnis

- Maximale Anzahl Tokens pro Aufruf — alles muss hineinpassen:
  System-Prompt + gesamte Konversation + Tool-Ergebnisse + deine Antwort
- Wird es zu groß: Ältere Teile fallen heraus oder müssen komprimiert werden
- Moderne Modelle: 100.000+ Tokens — ganze Codebasen passen teilweise rein
- Aber: Langer Kontext ≠ besserer Kontext (Qualität in der Mitte ist oft schwächer)

---

## Temperatur & Sampling

- `temperature`: Zufall bei der Token-Wahl
  - `0` – `0.3`: deterministisch, präzise → **Code, strukturierte Outputs**
  - höher: kreativer, überraschender → Brainstorming, Texte
- `top_p`: begrenzt die Wahrscheinlichkeitsmasse, aus der gewählt wird
- Merksatz: **Für Engineering-Aufgaben drehen wir die Kreativität herunter**

---

## Modellklassen im Überblick

| Klasse | Stärken | Typischer Einsatz |
| --- | --- | --- |
| Klein & schnell | billig, flott | Klassifikation, Extraktion, einfache Transformation |
| Groß | beste Qualität | Refactoring, komplexe Features, Architekturfragen |
| Reasoning | plant mehrschrittig intern | Debugging, Logik, schwierige Fälle |

- Faustregel: **Nimm das kleinste Modell, das die Aufgabe löst**
- Warum das spart? Jetzt kommt die Ökonomie.

---

## Was kostet ein Token?

| Position | Größenordnung (pro 1 Mio. Tokens) |
| --- | --- |
| Input (kleines Modell) | ~€0,15 – €0,50 |
| Input (großes Modell) | ~€1 – €5 |
| Output | oft Faktor 3–5 gegenüber Input |
| Reasoning-Interna | werden als Output abgerechnet |

Größenordnungen, Stand 2026 — echte Preise immer beim Provider nachsehen.
Free-Tiers zeigen euch statt Euro: Rate Limits. Rechnen lernen wir trotzdem.

---

## Beispielrechnung: ein Refactoring

Aufgabe: 200-Zeilen-Modul umbauen lassen

- Prompt inkl. Code: **~4.000 Input-Tokens**
- Antwort mit neuem Code: **~2.500 Output-Tokens**

```plaintext
0,004 × €1,00   = €0,0040  (Input)
0,0025 × €4,00  = €0,0100  (Output)
─────────────────────────
Summe           ≈ €0,014
```

Klingt winzig. Aber: 30 Iterationen × 5 Personen × ganzes Schuljahr...

---

## Die teure Richtung: Output

- Output kostet ein Mehrfaches von Input
- Konsequenz 1: Präzise Antworten fordern — *"Antworte nur mit dem Diff"*
- Konsequenz 2: Chat-Historien werden jeden Turn teurer —
  die ganze bisherige Konversation wandert bei jedem Aufruf **erneut als Input** mit
- Genau deshalb gibt es später Caching und Compaction (Lektion 12)

---

## Prompt Caching: Vorgeschmack

- Identische Prefixes (System-Prompt, lange Doku) kann der Provider cachen
- Gecachte Input-Tokens sind deutlich billiger **und** schneller
- Voraussetzung: der Anfang des Prompts bleibt identisch
- Wie wir das in unseren Harness einbauen: Lektion 12

---

## Energie-Fußabdruck (Teaser)

- Training eines großen Modells: Stromverbrauch im Kleinstadt-Maßstab, monatelang
- Inferenz: jeder einzelne Aufruf klein — aber Milliardenfach pro Tag
- Lokale Modelle verlagern den Verbrauch in eure eigene Steckdose
- Wir rechnen das in Lektion 14 sauber durch (Benchmark lokal vs. Cloud)

---

## Ein Standard, viele Anbieter

```plaintext
POST {BASE_URL}/chat/completions
Authorization: Bearer $API_KEY
```

| Anbieter | BASE_URL | Beispiel-Modell |
| --- | --- | --- |
| Groq | `api.groq.com/openai/v1` | `llama-3.3-70b-versatile` |
| Gemini (OpenAI-Modus) | `generativelanguage.googleapis.com/v1beta/openai` | `gemini-2.5-flash` |
| Mistral | `api.mistral.ai/v1` | `mistral-small-latest` |
| OpenCode Zen | `opencode.ai/zen/v1` | wechselnd — Modellliste prüfen |
| Ollama (lokal) | `localhost:11434/v1` | z.B. `llama3.1:8b` |

Derselbe Request, dieselbe Response — nur die `.env` ändert sich.

---

## Anatomie des Requests

```json
{
  "model": "llama-3.3-70b-versatile",
  "messages": [
    { "role": "system", "content": "Du bist ein präziser Assistent." },
    { "role": "user", "content": "Nenne drei Eigenschaften von Tokens." }
  ],
  "temperature": 0.2
}
```

- `system`: dauerhafte Verhaltensregeln · `user`: die Aufgabe
- Die Rolle `assistant` kommt später in mehrstufigen Konversationen dazu

---

## Anatomie der Response

```json
{
  "choices": [{
    "message": { "role": "assistant", "content": "Tokens sind ..." }
  }],
  "usage": {
    "prompt_tokens": 27,
    "completion_tokens": 84,
    "total_tokens": 111
  }
}
```

`usage` ist unser **Metering-Zähler** — darauf bauen alle Kostenanalysen in diesem Kurs.

---

## Minimaler Client in TypeScript

```typescript
const res = await fetch(`${process.env.BASE_URL}/chat/completions`, {
  method: "POST",
  headers: {
    Authorization: `Bearer ${process.env.API_KEY}`,
    "Content-Type": "application/json",
  },
  body: JSON.stringify({
    model: process.env.MODEL,
    messages: [{ role: "user", content: process.argv[2] ?? "Hallo!" }],
  }),
});

const data = await res.json();
console.log(data.choices[0].message.content);
console.error(data.usage); // Metering!
```

Start: `npx tsx --env-file=.env chat.ts "Deine Frage"`

---

## .env — der Anbieterwechsel

```plaintext
# .env — NIEMALS committen!
BASE_URL=https://api.groq.com/openai/v1
API_KEY=gsk_hier_steht_dein_key
MODEL=llama-3.3-70b-versatile
```

- Anbieter wechseln = drei Zeilen ändern — der Code bleibt gleich
- Warnung aus der Praxis: **GitHub Models wurde im Juli 2026 eingestellt**.
  Wer die URL hartkodiert hatte, musste alles umschreiben.
- Wir nicht: Konfiguration gehört ins Environment, nie in den Code.

---

## Streaming: warum sich KI schnell anfühlt

- Non-streaming: ganze Antwort kommt am Stück — lange Wartezeit, dann Plotz
- Streaming (`"stream": true`): Tokens trudeln per Server-Sent Events ein
- Gefühlt sofort — gleiche Kosten, nur die Übertragung ändert sich
- Für unseren Harness später auch praktisch: Fortschritt live sehen

---

## Übung Teil 1: Mini-Chat-Client

<div class="highlight-box">
<ol>
<li>Ordner <code>apps/chat-client/</code> im Team-Repo anlegen</li>
<li>CLI-Chat in TypeScript: Frage als Argument, Antwort auf stdout</li>
<li>Nur <code>fetch</code> — kein SDK! Ihr sollt die API roh sehen</li>
<li>Credentials in <code>.env</code>: <code>BASE_URL</code>, <code>API_KEY</code>, <code>MODEL</code></li>
<li>Stretch-Ziel: <code>"stream": true</code> und Live-Ausgabe</li>
</ol>
</div>

---

## Übung Teil 2: Token-Metering & Kostenreport

<div class="highlight-box">
<ol>
<li>Loggt <code>usage</code> jedes Calls nach <code>usage.log</code> (JSON Lines)</li>
<li>Preistabelle als Config (<code>prices.json</code>): Input/Output je Modellklasse</li>
<li>Skript <code>cost-report.ts</code>: summiert Tokens, rechnet simulierte Euro daraus</li>
<li>Misst dieselbe Frage an zwei Modellklassen (klein vs. groß) — vergleicht</li>
<li>Dokumentiert Zahlen + Erkenntnisse in <code>docs/cost-report.md</code></li>
<li>Stretch: <code>429 Too Many Requests</code> sauber behandeln — Retry nach <code>retry-after</code></li>
</ol>
</div>

Gemessen statt gefühlt — das ist der Unterschied zum Vibecoding.

---

## Deliverable & Offenes Lab

**Deliverable heute ins Team-Repo:**

- `apps/chat-client/` — euer Client inkl. Metering
- `docs/cost-report.md` — gemessene Zahlen, nicht Bauchgefühle

**Offenes Lab:** Client ausbauen — REPL-Modus, Modellwahl per Flag, Streaming.

---

## Ausblick: Nächste Einheit

- Wir machen aus Prompting eine Ingenieursdisziplin
- Strukturierte Outputs, Few-Shot, Anti-Patterns
- Und das wichtigste Werkzeug gegen Bauchgefühl: **Evals**

Bringt euren Chat-Client mit — wir bauen darauf auf.

---

## Was wir heute gelernt haben

- LLMs vorhersagen das nächste Token — mehr Magie ist nicht drin
- Tokens bestimmen Kontextfenster, Geschwindigkeit und Preis
- Output kostet deutlich mehr als Input; Historien wachsen mit
- Temperatur runter für Engineering-Aufgaben
- Erster eigener API-Client mit Token-Metering in TypeScript
