---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 14 - Lokale Modelle & Ökonomie
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- AI-Features mit Guardrails gebaut — die Intelligenz kam bislang aus der Cloud
- Heute drehen wir den Spatzen: **Was, wenn das Modell bei euch auf dem Rechner läuft?**
- Und was kostet Intelligenz wirklich — in Euro, Tokens und Watt?

---

## Warum lokale Modelle überhaupt?

| Gewinn | Warum es zählt |
| --- | --- |
| Datenschutz | Daten verlassen das Haus nicht — Schule & DSGVO danken |
| Kosten | Kein Metering, keine Rate-Limits, keine Überraschungen |
| Offline | Internet weg ≠ Feature weg |
| Kontrolle | Modell-Version fix → reproduzierbare Ergebnisse |

Der Preis: meist weniger Qualität, weniger Geschwindigkeit, Wartungsaufwand.

---

## Ollama in 90 Sekunden

```bash
ollama run llama3.1        # Modell ziehen + chatten
ollama pull qwen2.5-coder  # nur herunterladen
```

- Läuft lokal als Server: `http://localhost:11434`
- **OpenAI-kompatibel** unter `/v1` — euer `.env`-Muster funktioniert sofort:

```plaintext
BASE_URL=http://localhost:11434/v1
API_KEY=ollama          # Platzhalter — wird nicht geprüft
MODEL=qwen2.5-coder:7b
```

GUI-Alternative mit Modell-Bibliothek: LM Studio. Gleiche Idee.

---

## Quantisierung einfach erklärt

- Modell-Gewichte sind normalerweise 16-Bit-Zahlen (FP16)
- **Quantisierung** presst sie in weniger Bits (Q8, Q5, Q4...)
- Weniger Bits = weniger RAM = schneller = läuft auf eurem Laptop
- Aber: Präzision geht verloren — Q4 ist der übliche Alltagkompromiss

Faustregel: Ein 7B-Modell in Q4 passt in ~4–5 GB RAM.
Die "7B" heißt 7 Milliarden Parameter — die Zahl vor dem B ist euer RAM-Knopf.

---

## Hardware-Realität

| Ausstattung | Was realistisch läuft |
| --- | --- |
| Schul-Laptop (8 GB, CPU) | Kleine Modelle (3–7B, Q4) — geduldig |
| 16 GB + ordentliche CPU | 7–14B komfortabel |
| GPU mit ≥ 12 GB VRAM | Bis ~30B flott |

- GPU beschleunigt massiv, CPU funktioniert auch (nur langsamer)
- Die spürbare Metrik: **Tokens pro Sekunde** — ab ~10 t/s fühlt sich Chat flüssig an

---

## Energie & CO₂ grob gerechnet

- Euer Laptop beim Inferenzieren: ~30–60 Watt
- Desktop-GPU unter Last: 200–350+ Watt
- Cloud-Inferenz: Strom im Rechenzentrum — plus Kühlung, plus Netzwerk,
  plus der Strommix des Standorts
- Training eines großen Modells: Größenordnung Kleinstadt über Monate (L01-Rückruf)

Wir rechnen heute bewusst mit **Annahmen** — und legen sie offen. Das ist ehrlicher als erfundene Präzision.

---

## TCO: Total Cost of Ownership

```plaintext
Cloud :  Kosten pro Nutzung  ·  null Anschaffung  ·  Limits & Datenschutzfragen
Lokal :  einmalig Hardware   ·  Strom + Zeit      ·  volle Kontrolle
```

- Break-even-Denke: Ab welcher Nutzungsmenge lohnt sich eigene Hardware?
- Vergesst nie die unsichtbare Spalte: **den Wert der Daten**, die ihr rausgebt
- Für Schule oft entscheidend: Lokal ist manchmal die *einzige* zulässige Option

---

## Privacy als Feature

- Lokale Inferenz: Mitschriebe, Projektdaten, Feedback-Texte bleiben im Gebäude
- Genau deshalb ist Lektion 13s Regel ("Schülerdaten nicht in Cloud-Prompts")
  kein Verbot von KI — sondern eine **Architektur-Anforderung**
- Muster: sensibles RAG lokal, allgemeine Aufgaben in der Cloud — Routing kennt ihr schon (L12)

Vertiefung der Rechts-Seite: nächste Einheit (Ethik, Recht & Verantwortung).

---

## Der Benchmark-Plan

Identische Coding-Task, mehrere Modelle, gleicher Rechner:

| Messwert | Wie? |
| --- | --- |
| Latenz | Zeit bis erstes Token + Gesamtzeit |
| Qualität | Rubrik 0–5: kompiliert? Tests grün? Ansatz sinnvoll? |
| Verbrauch | Tokens aus `usage`, simulierte € aus `prices.json` |
| Tempo | Tokens/Sekunde |

Kandidaten lokal: `qwen2.5-coder:7b`, `llama3.1:8b` — Cloud: ein Free-Tier (Groq/Gemini/Mistral).

---

## Fair benchmarken (L03 lässt grüßen)

- Gleicher Prompt für alle — inklusive identischem Kontext
- Temperatur fix (0.2), `n = 3` Läufe pro Kombination
- Rubrik **vorher** festgelegt, nicht nachher gerechtfertigt
- Alle Runs auf demselben Rechner, sonst vergleicht ihr Hardware statt Modelle

Ergebnis-Tabelle zuerst, Empfehlung danach — nie umgekehrt.

---

## Übung Teil 1: Setup & Skript

<div class="highlight-box">
<ol>
<li>Ollama installieren, zwei Modelle pullen, Smoke-Test über <code>/v1</code></li>
<li>Zweites <code>.env</code>-Profil (<code>.env.local</code>) — euer Code merkt nichts</li>
<li>Benchmark-Skript bauen: Task × Modell × Run, sammelt Latenz/Usage/Tokens-per-Sekunde</li>
<li>Rubrik schriftlich fixieren (0–5, vier Kriterien)</li>
</ol>
</div>

---

## Übung Teil 2: Matrix fahren

<div class="highlight-box">
<ol>
<li>3 Modelle × 3 Läufe durchziehen — Zwischenstände live ins Dashboard (L12!)</li>
<li>Qualität je Run rubrizieren — zwei Personen bewerten unabhängig</li>
<li>Alles in <code>docs/local-vs-cloud.md</code>: Tabelle, Annahmen, Auffälligkeiten</li>
<li>Empfehlung schreiben: Wofür wäre lokal sinnvoll? Wo niemals?</li>
</ol>
</div>

---

## Deliverable & Offenes Lab

**Deliverable heute:** `docs/local-vs-cloud.md` — Benchmark-Matrix mit
Annahmen und begründeter Empfehlung.

**Offenes Lab:** Euer L13-AI-Feature gegen das lokale Modell getestet —
hält es die Guardrails auch dort? Oder: RAG-Corpus lokal embedden (L09-Rückruf)
und Recall vergleichen.

---

## Ausblick: Nächste Einheit

- Die Technik beherrscht ihr jetzt — aber **dürft** ihr all das?
- Urheberrecht, DSGVO, Verantwortung, Berufsbild
- Und: Abgabe eurer Projekt-Spec — der Startschuss zum Demo Day

---

## Was wir heute gelernt haben

- Lokale Modelle: Datenschutz, Kostenkontrolle, Offline-Fähigkeit — gegen Qualität und Tempo
- Ollama spricht OpenAI-kompatibel: `.env`-Wechsel, null Code-Änderung
- Quantisierung tauscht Bits gegen RAM/Geschwindigkeit; 7B-Q4 ≈ 4–5 GB
- TCO rechnet Hardware + Strom + Zeit gegen Token-Kosten und Datenwert
- Faire Benchmarks: fixe Rubrik, n=3, gleicher Rechner — Zahlen statt Glaubenskriege
