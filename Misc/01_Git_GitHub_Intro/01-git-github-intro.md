---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# Git & GitHub
## Eine erste Einführung

---

## Agenda (1/2)

1. Warum Versionsverwaltung?
2. Git und GitHub — zwei verschiedene Dinge
3. Snapshots statt Dateikopien
4. Wo leben deine Änderungen? — Lokal und Remote
5. Der Workflow im Überblick
6. GitHub Desktop — ein erster Überblick
7. Schritt 1: Ändern

---

## Agenda (2/2)

8. Schritt 2: Auswählen (Staging)
9. Schritt 3: Committen
10. Schritt 4: Publizieren (Push)
11. Schritt 5: Aktualisieren (Fetch & Pull)
12. Dateien entfernen
13. .gitignore — was nicht versioniert werden soll
14. Der Kreislauf in der Praxis

---

## Lernziele

- Ich weiß, wofür Git und GitHub jeweils da sind und wie sie zusammenspielen
- Ich verstehe, was "staged" und "committed" bedeuten — unabhängig vom Befehl dahinter
- Ich kann in GitHub Desktop Änderungen auswählen, committen und publizieren
- Ich weiß, warum ich vor dem Arbeiten aktualisieren (pull) sollte

---

## Warum Versionsverwaltung?

- Zwei Personen arbeiten an derselbem Projekt — wer hat die aktuelle Version?
- Wie teile ich meine Änderungen mit?
- Wie sehe ich die Änderungshistorie meines Projekts?

<div class="highlight-box">
<p>Versionsverwaltung löst genau dieses Problem: eine <strong>nachvollziehbare Geschichte</strong> deines Projekts, ohne Dateichaos.</p>
</div>

---

## Git und GitHub — zwei verschiedene Dinge

Diese zwei Begriffe werden oft verwechselt:

- **Git:** Das Werkzeug, das die Versionsgeschichte führt. Läuft **lokal** auf deinem Rechner. Braucht kein Internet.
- **GitHub:** Ein **Onlinedienst**, auf dem du eine Kopie deines Repositories speicherst — damit du sie sichern, teilen und mit anderen daran arbeiten kannst.

<div class="highlight-box">
<p>Git ist das Werkzeug. GitHub ist nur <strong>einer</strong> von mehreren Orten, an denen ein Git-Repository liegen kann (Alternativen: GitLab, Bitbucket, ...).</p>
</div>

---

## Snapshots statt Dateikopien

- Git speichert **keine** ganzen Dateikopien pro Version
- Stattdessen: bei jedem **Commit** ein Snapshot — ein Foto des gesamten Projekts zu diesem Zeitpunkt
- Jeder Snapshot hat einen Zeitpunkt, eine Nachricht und eine eindeutige ID
- Du kannst jederzeit zu jedem früheren Snapshot zurückkehren

---

## Wo leben deine Änderungen? — Lokal und Remote

- **Lokales Repository:** liegt auf deinem Rechner, inklusive der kompletten Geschichte
- **Remote-Repository:** die Kopie auf GitHub

Beide sind zunächst getrennt — sie synchronisieren sich nur, wenn du es aktiv auslöst.

![width:850px Zwei Personen mit lokalem Repository, verbunden über GitHub als Remote](mermaid/team-workflow.svg)

---

## Der Workflow im Überblick

Eine Änderung durchläuft vier Stationen, bevor sie für andere sichtbar ist:

![width:1000px Vom bearbeiteten Ordner bis zu GitHub](mermaid/vier-bereiche.svg)

Diese vier Schritte — ändern, auswählen, committen, publizieren — sehen wir uns jetzt einzeln an.

---

## GitHub Desktop — ein erster Überblick

Wir verwenden **GitHub Desktop** — eine grafische Oberfläche für Git. Du musst dafür (vorerst) keine Befehle auswendig können.

- **Linke Seite:** Tab "Changes" (offene Änderungen) und Tab "History" (bisherige Commits)
- **Änderungsliste:** jede geänderte Datei mit Checkbox
- **Unten links:** Textfelder "Summary" und "Description" + Button "Commit to main"
- **Oben rechts:** Button "Fetch origin" / "Pull origin" / "Push origin"

<div class="highlight-box">
<p>Alles, was hier über GitHub Desktop erklärt wird, funktioniert auch über die Kommandozeile — nur eben mit Befehlen statt Klicks.</p>
</div>

---

## Schritt 1: Ändern

- Du bearbeitest Dateien in deinem Projektordner ganz normal — mit deinem Editor, wie immer
- Git bemerkt automatisch, welche Dateien sich verändert haben
- Solange du nichts weiter tust, ist das erst eine **lokale, unversionierte** Änderung

GitHub Desktop zeigt jede geänderte Datei im Tab **Changes** an, sobald du sie speicherst.

```bash
# Was im Hintergrund passiert (informativ):
git status
```

---

## Schritt 2: Auswählen (Staging)

Nicht jede Änderung soll sofort in denselben Commit. **Staging** heißt: du wählst aus, was *gemeinsam* eine sinnvolle Einheit ergibt.

- In GitHub Desktop: Checkbox neben einer Datei (oder sogar neben einzelnen Zeilen!) aktivieren
- Nur ausgewählte Änderungen landen im nächsten Commit
- Der Rest bleibt einfach bestehen — für einen späteren Commit

<div class="highlight-box">
<p>Staging ist keine Formalität, sondern eine bewusste Entscheidung: "Diese Änderungen gehören zusammen."</p>
</div>

```bash
git add server.js
```

---

## Schritt 3: Committen

Ein **Commit** ist ein Wegpunkt in der Geschichte deines Projekts — ein Snapshot der ausgewählten Änderungen mit einer Nachricht dazu.

- **Summary:** kurze Zusammenfassung ("Was habe ich gemacht?")
- **Description:** optional, für Details
- Button **"Commit to main"** erstellt den Snapshot lokal

<div class="highlight-box">
<p>Ein Commit ist zunächst nur <strong>lokal</strong> gespeichert — noch niemand sonst sieht ihn!</p>
</div>

```bash
git commit -m "Aufgabe 3 gelöst"
```

---

## Schritt 4: Publizieren (Push)

Ein Commit bleibt lokal, bis du ihn **veröffentlichst**.

- Button **"Push origin"** überträgt deine lokalen Commits nach GitHub
- Erst danach können andere (z. B. deine Lehrperson oder dein Team) die Änderung sehen
- Ohne Push: dein Fortschritt existiert nur auf deinem eigenen Rechner

<div class="highlight-box">
<p>Push = "veröffentlichen". Erst dieser Schritt macht deine Arbeit für andere sichtbar.</p>
</div>

```bash
git push origin main
```

---

## Schritt 5: Aktualisieren (Fetch & Pull)

Andere können ebenfalls Commits nach GitHub pushen. Um diese zu bekommen:

- **Fetch:** prüft, ob es Neuigkeiten auf GitHub gibt (lädt sie noch nicht in dein Projekt)
- **Pull:** holt diese Neuigkeiten **und** übernimmt sie in dein lokales Repository
- Button **"Fetch origin"** wird automatisch zu **"Pull origin"**, sobald es etwas zu holen gibt

<div class="highlight-box warning">
<p>Beginne jede Arbeitssitzung mit einem Pull — sonst arbeitest du möglicherweise auf einem veralteten Stand.</p>
</div>

```bash
git fetch origin
git pull origin main
```

---

## Dateien entfernen

Eine Datei aus dem Projekt zu entfernen ist selbst wieder eine Änderung, die committet werden muss.

- Datei im Explorer/Finder löschen (oder in GitHub Desktop rechtsklicken → "Delete")
- Die Löschung erscheint im Tab **Changes** wie jede andere Änderung
- Erst Commit + Push machen die Löschung auch für andere endgültig

```bash
git rm server_alt.js
git commit -m "Alte Abgabe entfernt"
```

---

## .gitignore — was nicht versioniert werden soll

Manche Dateien gehören **nie** ins Repository: automatisch generierte Dateien, IDE-Einstellungen, Kompilate.

- Eine Datei `.gitignore` listet Muster, die Git ignorieren soll
- Beispiele: `*.class`, `build/`, `.idea/`, `.DS_Store`
- Ignorierte Dateien tauchen erst gar nicht im Tab **Changes** auf

<div class="highlight-box">
<p>Bereits getrackte Dateien verschwinden durch <code>.gitignore</code> nicht automatisch — es wirkt nur auf neue, ungetrackte Dateien.</p>
</div>

---

## Der Kreislauf in der Praxis

Ein typischer Arbeitsablauf sieht so aus:

1. **Pull** — aktuellen Stand von GitHub holen
2. **Ändern** — an den Dateien arbeiten
3. **Auswählen** — passende Änderungen zum Commit hinzufügen
4. **Committen** — mit aussagekräftiger Nachricht
5. **Push** — Änderungen veröffentlichen

Und dann wieder von vorn.

---

## Zusammenfassung

- **Git** verwaltet Versionen lokal, **GitHub** ist der Ort in der Cloud, an dem du sie teilst
- Ein Commit ist ein **Snapshot**, keine Dateikopie
- **Staging** = bewusst auswählen, was in einen Commit gehört
- **Commit** = lokal speichern, **Push** = veröffentlichen, **Pull** = aktuellen Stand holen
- `.gitignore` hält unnötige Dateien draußen
- GitHub Desktop macht all das über Klicks möglich — die Befehle dahinter lernen wir später
