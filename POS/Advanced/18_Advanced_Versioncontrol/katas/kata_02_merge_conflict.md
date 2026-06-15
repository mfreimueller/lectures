# Kata 2: Merge-Konflikt provozieren & auflösen

| Feld | Wert |
|------|------|
| Konzepte | Merge-Konflikt, Konflikt-Marker, git merge, Konflikt-Auflösung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Provoziere bewusst einen Merge-Konflikt und löse ihn korrekt auf.

1. **Ausgangssituation**
   - Erstelle ein neues Repository `merge-conflict-lab`
   - Erstelle eine Datei `index.html` und committe sie:
     ```html
     <!DOCTYPE html>
     <html lang="de">
     <head><meta charset="utf-8"><title>Mein Projekt</title></head>
     <body>
       <h1>Willkommen</h1>
       <p>Dies ist ein Beispielprojekt.</p>
     </body>
     </html>
     ```

2. **Branch A: Haupttitel ändern**
   - Erstelle und wechsle zu Branch `feature/titel-a`
   - Ändere den Titel von `<h1>Willkommen</h1>` in `<h1>Super App</h1>`
   - Committe die Änderung

3. **Branch B: Selbe Zeile, andere Änderung**
   - Wechsle zurück zu `main`
   - Erstelle und wechsle zu Branch `feature/titel-b`
   - Ändere den Titel von `<h1>Willkommen</h1>` in `<h1>Unsere Platform</h1>`
   - Committe die Änderung

4. **Konflikt provozieren**
   - Wechsle zurück zu `main`
   - Merge `feature/titel-a` in main:
     ```bash
     git switch main
     git merge feature/titel-a
     ```
   - Da kein Konflikt mit main selbst besteht, ist dieser Merge erfolgreich
   - Jetzt merge `feature/titel-b`:
     ```bash
     git merge feature/titel-b
     ```
   - **Erwartet: Merge-Konflikt!**
     ```
     Auto-merging index.html
     CONFLICT (content): Merge conflict in index.html
     Automatic merge failed; fix conflicts and commit.
     ```

5. **Konflikt analysieren**
   - Öffne `index.html` mit einem Editor
   - Du siehst die Konflikt-Marker:
     ```html
     <<<<<<< HEAD
       <h1>Super App</h1>
     =======
       <h1>Unsere Platform</h1>
     >>>>>>> feature/titel-b
     ```

6. **Konflikt auflösen**
   - Entscheide dich für eine Bezeichnung (oder kombiniere beide)
   - Entferne die Konflikt-Marker (`<<<<<<<`, `=======`, `>>>>>>>`)
   - Speichere die Datei
   - Prüfe mit `git status`: die Datei ist jetzt "modified" und "unmerged"
   - Füge die aufgelöste Datei zum Staging hinzu: `git add index.html`
   - Erstelle den Merge-Commit: `git commit`

7. **Zweite Herausforderung: Funktion ändern**
   - Erstelle von `main` aus zwei Branches, die eine `printInfo()`-Methode in einer Java-Klasse auf unterschiedliche Weise ändern
   - Erzeuge erneut einen Konflikt und löse ihn auf

### Beispiel-Output

```
$ git merge feature/titel-b
Auto-merging index.html
CONFLICT (content): Merge conflict in index.html
Automatic merge failed; fix conflicts and commit.

# In index.html:
<<<<<<< HEAD
      <h1>Super App</h1>
=======
      <h1>Unsere Platform</h1>
>>>>>>> feature/titel-b

# Nach Auflösung:
      <h1>Super App - Unsere Platform</h1>
```

### Erweiterung

Verwende `git log --oneline --graph --all`, um die Merge-Historie zu betrachten. Versuche danach, denselben Konflikt mit `git merge --abort` abzubrechen und stattdessen mit `git merge -X theirs feature/titel-b` (behalte deren Version bei Konflikten) zu mergen. Was ist der Unterschied?
