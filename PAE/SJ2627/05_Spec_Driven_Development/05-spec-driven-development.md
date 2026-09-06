---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 05 - Spec-driven Development
## PAE - SJ 2026/27

---

## Wiederholung in 60 Sekunden

- Kontext schlägt Prompt-Tricks: `AGENTS.md`, Skills, Subagents
- Saubere Regeln im Repo wirken messbar (Vorher/Nachher aus Lektion 04)
- Heute: der Prozess drumherum — vom Issue bis zur fertigen, geprüften Änderung

---

## Das Problem mit direktem Prompten

- "Bau mir X" — das Modell rät Anforderungen, Umfang und Randfälle
- Je größer die Aufgabe, desto mehr raten beide Seiten
- Ergebnis: Feature zu 80% fertig — und die letzten 20% fressen 80% der Zeit
- Ingenieur:innen spezifizieren. Genau deshalb existieren Specs.

---

## Die Pipeline

```plaintext
Issue → Spec → Plan → Implement → Verify
       (Was?)  (Wie?)   (Tun)      (Prüfen)
```

- **Spec**: WAS gebaut wird — Anforderungen, Randfälle, Akzeptanzkriterien
- **Plan**: WIE — Schritte, betroffene Dateien, Reihenfolge
- **Implement**: der Agent führt aus, Schritt für Schritt
- **Verify**: gegen die Spec prüfen — nicht gegen das Bauchgefühl

---

## Was in einer guten Spec steht

| Abschnitt | Inhalt |
| --- | --- |
| Ziel | Ein Satz: welches Problem lösen wir? |
| Scope | Drin — und bewusst **draußen** (Out of Scope!) |
| Anforderungen | Nummeriert, überprüfbar formuliert |
| Randfälle | Leere Eingaben, Fehlerfälle, Sonderzeichen |
| Akzeptanzkriterien | Woran erkennen wir: fertig und korrekt? |

---

## Akzeptanzkriterien sind Agentenfutter

- Schwach: "Die Suche soll gut funktionieren"
- Stark: "Suche nach 'mueller' findet auch 'Müller' (Umlaut-Faltung)"
- Jedes Kriterium wird später zum Testfall (Lektion 06)
- Faustregel: **Ein Kriterium, das ihr nicht testen könnt, ist keins**

---

## Plan Modes der Agenten

- Viele Agenten haben einen Plan-/Denkmodus: erst Vorschlag, dann Ausführung
- Ihr reviewt den Plan, **bevor** eine Zeile Code entsteht
- Der billigste Ort für Fehler ist noch der Plan
- Kein Plan-Mode vorhanden? Plan als Datei schreiben lassen
  und explizit abnicken — funktioniert überall

---

## Task-Zerlegung

- Große Specs in unabhängige Teilaufgaben schneiden
- Faustregel: ein Schritt = ein reviewbarer Commit bzw. PR
- Abhängigkeiten explizit machen: "erst Datenmodell, dann Endpoint"
- Kleine Schritte = kleine Fehler = wenig Halluzinationsfläche

---

## Spec ≠ Wasserkopf

<div class="highlight-box warning">
<p>Angst: "Das Spec-Schreiben dauert länger als das Coden." Stimmt fast nie.</p>
</div>

- Kleines Feature: die Spec ist ein Issue mit 5–10 Zeilen
- Größeres Feature: maximal eine Seite
- Rechnung: Eine Stunde Spec spart Stunden Debugging-Chaos —
  und die Spec bleibt als Doku fürs Team *und* für jeden Agenten

---

## Verify treibt die Spec weiter

- Prüfen erzeugt Fragen → Spec präzisieren → erneut prüfen
- Nicht geschaffte Kriterien: offen markieren, nicht wegdiskutieren
- **Definition of Done**: alle Kriterien erfüllt — oder bewusst verschoben, dokumentiert

```plaintext
[ ] AC1: leere Eingabe → leerer Output          ✓
[ ] AC2: verschachtelte Listen korrekt          ✗ offen (Issue #12)
```

---

## Übung Teil 1: Erst die Spec

<div class="highlight-box">
<ol>
<li>Wählt eine Erweiterung für <code>md2html.ts</code>: Links, Code-Blöcke oder Tabellen</li>
<li>Schreibt <code>docs/specs/&lt;feature&gt;.md</code>: Ziel, Scope, nummerierte Anforderungen, Randfälle, Akzeptanzkriterien</li>
<li>Jedes Kriterium muss testbar sein — sonst schärfen oder streichen</li>
<li>Spec im Team reviewen, dann einfrieren (v1.0)</li>
</ol>
</div>

Einfrieren heißt nicht für immer — aber für diesen Durchlauf.

---

## Übung Teil 2: Plan, Implement, Verify

<div class="highlight-box">
<ol>
<li>Agent in den Plan-Modus: Implementationsschritte vorschlagen lassen</li>
<li>Plan reviewen und abnicken — dann erst implementieren lassen</li>
<li>Verify: jedes Akzeptanzkriterium einzeln prüfen (Test oder manuell)</li>
<li>Messen: Iterationen, Dauer, Abweichungen von der Spec — dokumentiert ins Journal</li>
</ol>
</div>

---

## Der große Vergleich

Wir bewerten heute mit derselben Rubrik wie in Lektion 00:

| Runde | Ansatz | Was gemessen wurde |
| --- | --- | --- |
| L00 – Runde 1 | Vibe | Frust-Momente |
| L00 – Runde 2 | Spec light | selbstgebaute Tests |
| **Heute** | **Spec + Plan + Verify** | **erfüllte Akzeptanzkriterien** |

Heute kommt Spalte drei dazu — gleiche Rubrik, gleiche Aufgabenfamilie (`md2html.ts`).

---

## Deliverable & Offenes Lab

**Deliverable heute ins Team-Repo:**

- `docs/specs/<feature>.md` + Feature-Branch mit Implementation
- Messwerte und Beobachtungen im Engineering Journal

**Offenes Lab:** Ein zweites Feature komplett spec-first durchziehen —
diesmal ohne Hilfe der Lehrperson.

---

## Ausblick: Nächste Einheit

- Specs liefern Akzeptanzkriterien — wer wandelt die in automatische Tests?
- **Qualitätssicherung**: Tests als Leitplanken, Pre-Commit-Hooks,
  Code-Reviews durch Agenten
- Bringt eure Spec mit: Sie wird zur Testbasis

---

## Was wir heute gelernt haben

- Pipeline: Issue → Spec → Plan → Implement → Verify
- Gute Specs sind schlank: Ziel, Scope, nummerierte Anforderungen, testbare Kriterien
- Akzeptanzkriterien sind Agentenfutter — und künftige Testfälle
- Plan-Modus nutzen: Fehler im Plan sind am billigsten
- Verify entscheidet — Definition of Done ist verhandlungsresistent dokumentiert
