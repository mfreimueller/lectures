# Kata 1: Mein erstes Git-Repository

| Feld | Wert |
|------|------|
| Konzepte | git init, git add, git commit, git status, git log |
| Schwierigkeit | 1/5 |
| Dauer | ca. 20 min |

### Aufgabenstellung

Erstelle ein lokales Git-Repository und mache die ersten Schritte mit der Versionsverwaltung.

1. **Repository initialisieren**
   - Erstelle ein Verzeichnis `mein-projekt` und initialisiere darin ein Git-Repository (`git init`)
   - Überprüfe, dass das `.git/`-Verzeichnis erstellt wurde

2. **Git konfigurieren**
   - Setze deinen Namen und deine E-Mail-Adresse global (`git config --global`)

3. **Erste Datei erstellen und versionieren**
   - Erstelle eine Datei `readme.txt` mit dem Inhalt `# Mein erstes Projekt`
   - Überprüfe den Status (`git status`) — die Datei sollte als "untracked" erscheinen
   - Füge die Datei zum Staging hinzu (`git add readme.txt`)
   - Erstelle deinen ersten Commit (`git commit -m "Initialer Commit: README"`)

4. **Weitere Dateien hinzufügen**
   - Erstelle eine Datei `hello.py` mit dem Inhalt:
     ```python
     print("Hello Git!")
     ```
   - Füge die Datei hinzu und erstelle einen Commit
   - Überprüfe den Status nach dem Commit — er sollte "clean" anzeigen

5. **History anzeigen**
   - Zeige die Commit-Historie mit `git log` und `git log --oneline` an

### Beispiel-Output

```
$ git init
Initialized empty Git repository in /pfad/zu/mein-projekt/.git/

$ git status
On branch main

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        readme.txt

$ git log --oneline
e4a2d1c (HEAD -> main) Hello Python-Datei hinzugefügt
a1b2c3d Initialer Commit: README
```

### Erweiterung

Erstelle einen weiteren Commit, in dem du `hello.py` änderst (z. B. eine zweite print-Anweisung hinzufügst). Beobachte dabei `git diff` vor dem Hinzufügen und `git diff --staged` nach dem Hinzufügen.
