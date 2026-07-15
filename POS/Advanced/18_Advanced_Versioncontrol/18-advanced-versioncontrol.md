---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 18 - Advanced Version Control
## POS - Advanced

---

## Agenda (1/2)

1. Branches — Was und warum?
2. Mit Branches arbeiten
3. Mergen: Fast-Forward
4. Mergen: 3-Way-Merge
5. Merge-Konflikte — Ursachen
6. Merge-Konflikte auflösen
7. Merge-Konflikt — Vorbereitung

---

## Agenda (2/2)

8. Merge-Konflikt — Auflösung
9. Merge-Tools & Strategien
10. git rebase — Lineare Historie (1/2)
11. git rebase — Lineare Historie (2/2)
12. Rebase vs. Merge
13. git stash — Arbeit Zwischenspeichern
14. git reset & git revert
15. Tagging — Versionen markieren

---

## Lernziele

- Ich kann mit Branches arbeiten und sie mergen (Fast-Forward und 3-Way)
- Ich kann Merge-Konflikte erkennen und auflösen
- Ich kenne den Unterschied zwischen rebase und merge
- Ich kann git stash, git reset und git revert gezielt einsetzen
- Ich kann Versionen mit Tags markieren

---

## Branches — Was und warum?

- **Branch:** Ein beweglicher Zeiger auf einen Commit
- Ermöglicht parallele Entwicklung ohne sich zu stören
- Typische Einsatzbereiche: Features, Bugfixes, Experimente
- Haupt-Branch heißt standardmäßig `main` (früher `master`)

![width:650px Branch main mit abzweigendem feature-Branch](mermaid/branches-basic.svg)

---

## Mit Branches arbeiten

```bash
# Branches auflisten
git branch

# Branch wechseln (bestehender)
git switch feature/neues-feature

# Erstellen & wechseln
git switch -c feature/neues-feature
```

- `git branch` (ohne Argument) zeigt den aktuellen Branch mit * an
- Wechsel zwischen Branches: `git switch main`

---

## Mergen: Fast-Forward

![width:600px Fast-Forward-Merge: main zeigt jetzt auf denselben Commit wie feature](mermaid/fast-forward.svg)

```bash
git switch main
git merge feature
```

- Fast-Forward: main war seit dem Branch-Start unverändert
- Der Branch-Zeiger wird einfach nach vorne verschoben
- Kein eigener Merge-Commit nötig

---

## Mergen: 3-Way-Merge

![width:600px 3-Way-Merge: Merge-Commit M mit zwei Eltern](mermaid/three-way-merge.svg)

```bash
git switch main
git merge feature
```

- Beide Branches haben seit der Abzweigung Änderungen
- Git erzeugt einen **Merge-Commit** (M) mit zwei Eltern
- Die Historie bleibt erhalten — alle Entwicklungslinien sichtbar

---

## Merge-Konflikte — Ursachen

- Ein Konflikt entsteht, wenn zwei Branches **dieselbe Stelle** in derselben Datei unterschiedlich ändern
- Git kann nicht entscheiden, welche Version richtig ist
- **Du musst den Konflikt manuell lösen!**

```plaintext
$ git merge feature
Auto-merging readme.txt
CONFLICT (content): Merge conflict in readme.txt
Automatic merge failed; fix conflicts and commit.
```

---

## Merge-Konflikte auflösen

Git markiert Konflikte in der Datei mit:

```plaintext
<<<<<<< HEAD
Inhalt von main
=======
Inhalt vom feature-Branch
>>>>>>> feature
```

1. Datei öffnen — die Konflikt-Marker (`<<<`, `===`, `>>>`) anpassen
2. Gewünschten Inhalt behalten, Marker entfernen
3. `git add` → `git commit` (Merge-Commit erstellen)

---

## Merge-Konflikt — Vorbereitung

```bash
echo "Zeile 1" > datei.txt && git add . && git commit -m "init"
git switch -c feature
echo "Feature-Änderung" > datei.txt && git add . && git commit -m "feature"
git switch main
echo "Main-Änderung" > datei.txt && git add . && git commit -m "main"
```

- Zwei Branches ändern **dieselbe Zeile** derselben Datei
- Das führt beim Merge zwangsläufig zu einem Konflikt

---

## Merge-Konflikt — Auflösung

```plaintext
In datei.txt:
<<<<<<< HEAD
Main-Änderung
=======
Feature-Änderung
>>>>>>> feature
```

<div class="highlight-box">
<p>Lösung: Beide Änderungen kombinieren → <code>Main-Änderung + Feature-Änderung</code></p>
</div>

---

## Merge-Tools & Strategien

- Mit `git mergetool` kann ein externes Tool (VS Code, IntelliJ, KDiff3) Konflikte visuell darstellen
- **git merge --abort:** Bricht den Merge ab, Working Tree bleibt unverändert
- **Strategien:**
  - `git merge -s ours` — unsere Version behalten
  - `git merge -X theirs` — ihre Version bei Konflikten bevorzugen

---

## git rebase — Lineare Historie (1/2)

<div style="display:flex; gap:2em; align-items:center; justify-content:center;">
  <div style="text-align:center">
    <strong>Vor Rebase</strong><br>
    <img src="mermaid/rebase-before.svg" width="380">
  </div>
  <div style="text-align:center">
    <strong>Nach Rebase</strong><br>
    <img src="mermaid/rebase-after.svg" width="380">
  </div>
</div>

```bash
git switch feature
git rebase main
```

D' und E' sind neue Commits (andere SHA-1 Hashes)

---

## git rebase — Lineare Historie (2/2)

- Rebase setzt Commits eines Branches **oben auf** einen anderen Branch
- Erzeugt eine **lineare** Historie (leichter nachvollziehbar)
- Aber: **Niemals** auf gemeinsamen/veröffentlichten Branches rebasen!

---

## Rebase vs. Merge

| Merge | Rebase |
| --- | --- |
| Historie bleibt erhalten | Historie wird umgeschrieben |
| Merge-Commit sichtbar | Lineare Historie |
| Sicher für shared Branches | Nur für lokale Branches |
| Einfach zu verstehen | Mehr Kontrolle über Historie |
| `git merge feature` | `git rebase main` |

<div class="highlight-box">
<p>Faustregel: Merge für shared Branches, Rebase für lokale/halte-private Branches</p>
</div>

---

## git stash — Arbeit Zwischenspeichern

```bash
# Aktuelle Änderungen weglegen
git stash

# Liste aller Stashes
git stash list

# Neuesten Stash anwenden (und löschen)
git stash pop

# Bestimmten Stash anwenden
git stash apply stash@{2}
```

- Praktisch, um kurz den Branch zu wechseln, ohne zu committen
- Nützlich bei `git pull`, wenn lokale Änderungen stören

---

## git reset & git revert

```bash
# Soft Reset — HEAD verschieben, staged & modified bleiben
git reset --soft HEAD~1

# Mixed Reset (default) — HEAD verschieben, modified bleibt
git reset --mixed HEAD~1

# Hard Reset — Änderungen vernichten (Vorsicht!)
git reset --hard HEAD~1

# Sicherer: Revert erzeugt neuen Commit
git revert HEAD
```

<div class="highlight-box">
<p><code>git revert</code> ist sicher für geteilte Branches — die Historie wird nicht umgeschrieben</p>
</div>

---

## Tagging — Versionen markieren

```bash
# Leichten Tag (nur Name)
git tag v1.0.0

# Annotierten Tag (Name + Nachricht + Datum + Autor)
git tag -a v1.0.0 -m "Version 1.0.0"

# Tags auflisten
git tag -n

# Tag (und Commit) zu Remote pushen
git push origin v1.0.0
```

- Tags sind **unveränderlich** — sie verweisen fix auf einen Commit
- Typisch für Releases: `v1.0.0`, `v2.3.1-rc1`
- Annotierte Tags enthalten Metadaten (empfohlen für Releases)

---

## Zusammenfassung

- **Branches:** Parallele Entwicklungslinien
- **Merge:** Fast-Forward (linear) vs. 3-Way-Merge (eigener Commit)
- **Merge-Konflikte:** Entstehen bei parallelen Änderungen an derselben Stelle — manuell lösen!
- **Rebase:** Lineare Historie, aber gefährlich für gemeinsame Branches
- **Stash:** Arbeit temporär weglegen
- **Reset vs. Revert:** Revert ist sicher für Shared Branches
- **Tags:** Releases markieren
