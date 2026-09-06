---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 13 - KI-ready Software & AI-Features
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Modul C ist fertig: Euer Harness (v0.6) kann alles, was professionelle Agenten können
- Heute der Seitenwechsel der zweiten Kurs-Säule:
  Nicht Software **mit** KI bauen — sondern Software, **mit der KI gut arbeiten kann**

---

## Zwei Richtungen heute

1. **KI-ready werden**: eure eigene Software so bauen, dass Agenten sie sauber bedienen können
2. **AI-Features anbieten**: verantwortungsvoll KI in eigene Projekte einbauen — mit Guardrails

Beides betrifft euch sofort: euer POS-Projekt und jedes zukünftige.

---

## Was macht Software agent-tauglich?

- Klare **APIs**, nicht nur GUI — der Agent kann nicht klicken
- Maschinenlesbare Doku: strukturiertes README, OpenAPI/Swagger-Spec
- Hilfreiche Fehlermeldungen (Lektion 07/08-Rückruf): sagen, wie es weitergeht
- Deterministische Endpoints: gleicher Input → gleiches Verhalten
- Idempotenz: zweimal aufrufen führt nicht zu doppelten Daten

---

## Der Agent als Nutzer

| Erwartung | Mensch | Agent |
| --- | --- | --- |
| Zugang | GUI, Klick-Pfade | REST/CLI, Schemas |
| Anleitung | Screenshots, Videos | OpenAPI, README-Abschnitte |
| Bei Fehlern | "Etwas ist schiefgelaufen" toleriert | Präzise Meldung + nächster Schritt |
| Formate | Verzeiht viel | Strenge, dokumentierte Formate |

<div class="highlight-box">
<p>Der Test: Könnte ein Agent euer POS-Projekt selbstständig bedienen? Wenn nein — was genau fehlt?</p>
</div>

---

## OpenAPI: der Vertrag für Maschinen

- Eine Spec-Datei beschreibt Endpoints, Parameter, Antworten maschinenlesbar
- In Spring Boot: `springdoc-openapi` liefert das fast gratis (euer POS-Stack!)
- Und jetzt wird es spannend: **Aus einer OpenAPI-Spec lässt sich ein MCP-Server generieren**
  → Jeder Agent könnte eure API als Tools benutzen (L08-Rückruf)

Gute APIs waren schon immer wertvoll. Für Agenten werden sie zur Eintrittskarte.

---

## AI-Feature richtig gebaut: die Architektur

```plaintext
App ──► Guardrails ──► LLM ──► Schema-Validierung ──► Fallback/Nutzung
        (Scope, PII)          (JSON Schema, strict)    (bei Fehler)
```

Grundregel: **Dem Roh-Output eines Modells vertraut man nicht.**
Er wird validiert, begrenzt und im Fehlerfall abgefangen — immer.

---

## Guardrail 1: Strukturierte Outputs

- JSON Schema mit `strict` (Lektion 02) — das Modell hat keinen Spielraum
- Validierung **in der App** nachprüfen, nicht nur beim Provider hoffen
- Bei Validierungsfehler: Retry mit präziser Fehlermeldung statt stiller Ausfall

```typescript
const parsed = schema.safeParse(JSON.parse(answer));
if (!parsed.success) retryWithFeedback(parsed.error);
```

---

## Guardrail 2: Refusal-Regeln & Scope

- Definiert explizit, was das Feature **nicht** tut:
  - Flashcard-Generator erstellt keine Noten-Bewertungen
  - Zusammenfasser verarbeitet keine personenbezogenen Fremddaten
- Keine sensiblen Daten (Schülerdaten!) in Cloud-Prompts — lokal oder gar nicht
- Rate-Limits pro Nutzer: Ein Feature darf nicht zur Kostenbombe werden (L12-Denke)

---

## Guardrail 3: Human-in-the-Loop & Fallback

- KI-Vorschlag ≠ automatische Ausführung:
  Commit-Message vorschlagen ja — direkt committen nein
- Der Mensch behält den letzten Schritt bei allem Irreversiblen
- **Fallback**: Ist das Modell nicht erreichbar, degradiert das Feature,
  aber die App bleibt voll nutzbar

Eine App, die ohne KI kaputt ist, hat eine Abhängigkeit — kein Feature.

---

## Ideen für eure Übung

| Feature | Kern | Guardrail-Fokus |
| --- | --- | --- |
| Commit-Message-Summarizer | Diff → Vorschlag | Human-in-the-loop |
| Flashcard-Generator | Mitschrieb → Q/A-Paare | Schema-Validierung |
| Mensa-Bot über euren MCP-Server | Frage → Antwort aus Tool | Scope/Refusal |
| PR-Beschreibungs-Generator | Commits → Beschreibung | Fallback offline |

Oder etwas Eigenes — Hauptsache mit allen drei Guardrails.

---

## Übung Teil 1: Erst denken

<div class="highlight-box">
<ol>
<li>Feature wählen — idealerweise ins POS-/Team-Projekt integrierbar</li>
<li>Spec schreiben (L05-Muster): Ziel, Scope, testbare Akzeptanzkriterien</li>
<li>Guardrails designen: JSON-Schema, Refusal-Regeln, Fallback-Verhalten</li>
<li>Kosten abschätzen: Tokens pro Aufruf × erwartete Nutzung</li>
</ol>
</div>

---

## Übung Teil 2: Bauen & missbrauchen

<div class="highlight-box">
<ol>
<li>Implementieren mit dem Agenten — Tests zuerst aus den ACs (L06-Muster)</li>
<li>Guardrails aktiv testen: kaputte Inputs, Themen-Grenzfälle, Netz aus</li>
<li>Demo-fähig machen: CLI-Kommando oder Endpoint, der in 30 Sekunden zeigt, was es tut</li>
<li><strong>Cross-Team-Testing</strong>: Anderes Team versucht, euer Feature zu missbrauchen</li>
</ol>
</div>

---

## Deliverable & Offenes Lab

**Deliverable heute:** Feature-Branch mit Spec, Tests und live-demobarem
Ergebnis + Missbrauchsbericht vom Partner-Team im Journal.

**Offenes Lab:** Missbrauchsbefunde fixen; Feature in die Projektarchitektur
sauber integrieren (Konfiguration via `.env`-Muster, kein hartkodiertes Modell).

---

## Ausblick: Nächste Einheit

- Eine Frage war immer offen: Muss die Intelligenz aus der Cloud kommen?
- **Lokale Modelle & Ökonomie**: Ollama, Quantisierung, Energie, TCO
- Ihr benchmarkt lokal vs. Cloud — mit Zahlen, nicht mit Meinungen

Bringt einen Laptop mit (RAM-Größe hilft) und Neugier auf Stromrechnungen.

---

## Was wir heute gelernt haben

- KI-ready = APIs, maschinenlesbare Doku, hilfreiche Fehler, Determinismus
- OpenAPI macht eure API zum Agenten-Angebotsfenster (→ generierbarer MCP)
- AI-Features leben von drei Guardrails: Schema, Scope/Refusal, HITL/Fallback
- Sensible Daten gehören nicht in Cloud-Prompts — lokal oder gar nicht
- Dem Roh-Output vertraut man nie: validieren, begrenzen, abfangen
