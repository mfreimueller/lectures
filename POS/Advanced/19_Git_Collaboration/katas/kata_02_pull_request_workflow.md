# Kata 2: Pull-Request-Workflow simulieren

| Feld | Wert |
|------|------|
| Konzepte | Pull Request, Feature-Branch, Code Review, Merge |
| Schwierigkeit | 3/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Simuliere einen vollständigen Pull-Request-Workflow — vom Feature-Branch bis zum Merge in den Haupt-Branch.

Da wir keinen GitHub-Server haben, arbeiten wir mit einem lokalen Bare-Repo und simulieren den PR-Prozess mit Branches.

1. **Remote-Repo & lokales Repo einrichten**
   ```bash
   mkdir -p ~/git-training
   git init --bare ~/git-training/pr-demo.git
   git clone ~/git-training/pr-demo.git pr-demo
   cd pr-demo
   ```
   - Erstelle eine initiale Datei `app.py`:
     ```python
     def greet(name):
         return f"Hallo, {name}!"

     print(greet("Welt"))
     ```
   - Committe und pushe auf `main`:
     ```bash
     git add app.py && git commit -m "Initialer Commit"
     git push origin main
     ```

2. **Feature-Branch erstellen und pushen**
   - Erstelle einen Branch `feature/english-greeting` und wechsle zu ihm:
     ```bash
     git switch -c feature/english-greeting
     ```
   - Füge eine neue Funktion hinzu:
     ```python
     def greet(name):
         return f"Hallo, {name}!"

     def greet_en(name):
         return f"Hello, {name}!"

     print(greet("Welt"))
     ```
   - Committe und pushe den Branch:
     ```bash
     git add app.py && git commit -m "Neue englische Begrüßungsfunktion"
     git push origin feature/english-greeting
     ```

3. **PR simulieren: Code Review**
   - "Öffne einen PR": Wechsle zu main und erstelle einen Merge-Branch (simuliert den PR):
     ```bash
     git switch main
     git switch -c review/english-greeting
     git merge feature/english-greeting
     ```
   - Jetzt hast du einen Branch, der den gemergten Stand repräsentiert
   - Führe einen "Code Review" durch: lies den Code, finde ein potenzielles Problem (z. B. die alte Funktion wird noch verwendet, obwohl eine neue existiert)
   - Füge einen Verbesserungsvorschlag als Commit hinzu:
     ```python
     def greet(name):
         return f"Hallo, {name}!"

     def greet_en(name):
         return f"Hello, {name}!"

     print(greet_en("Welt"))
     ```
   - Committe: `git commit -am "Review: Nutze englische Version im Hauptprogramm"`

4. **PR mergen (in main)**
   - Wechsle zu main:
     ```bash
     git switch main
     ```
   - Was ist der Stand? main hat noch nicht den neuen Code
   - Merge den Review-Branch:
     ```bash
     git merge review/english-greeting
     ```
   - Pushe auf origin/main:
     ```bash
     git push origin main
     ```

5. **Aufräumen**
   - Lösche die temporären Branches:
     ```bash
     git branch -d feature/english-greeting
     git branch -d review/english-greeting
     git push origin --delete feature/english-greeting
     ```

### Beispiel-Output

```
$ git log --oneline --graph --all
* 789abcd (HEAD -> main) Review: Nutze englische Version im Hauptprogramm
* 456defg Neue englische Begrüßungsfunktion
* 123abcd Initialer Commit
```

### Erweiterung

Öffne einen zweiten "PR" für eine andere Verbesserung (z. B. eine französische Begrüßung). Achte darauf, dass du immer von `main` aus branchst und nach dem Merge wieder auf dem neuesten Stand bist. Simuliere, wie ein PR-Reviewer Änderungen anfordert, und du aktualisierst den PR-Branch mit neuen Commits.
