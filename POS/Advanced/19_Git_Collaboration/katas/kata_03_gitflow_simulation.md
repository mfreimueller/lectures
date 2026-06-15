# Kata 3: GitFlow-Simulation

| Feld | Wert |
|------|------|
| Konzepte | GitFlow, feature/*, release/*, hotfix/*, develop, main |
| Schwierigkeit | 4/5 |
| Dauer | ca. 45 min |

### Aufgabenstellung

Simuliere einen vollständigen GitFlow-Zyklus: Feature-Entwicklung, Release-Vorbereitung und einen dringenden Hotfix parallel zur laufenden Entwicklung.

1. **Repository vorbereiten**
   ```bash
   mkdir -p ~/git-training
   git init ~/git-training/gitflow-demo
   cd ~/git-training/gitflow-demo
   ```
   - Erstelle eine Datei `version.txt` mit `v0.1.0` und committe sie auf `main`
   - Erstelle und wechsle zu `develop`:
     ```bash
     git switch -c develop
     ```
   - Pushe beide Branches zu einem Bare-Repo (faket ein Remote):
     ```bash
     git init --bare ~/git-training/gitflow-demo.git
     git remote add origin ~/git-training/gitflow-demo.git
     git push origin main develop
     ```

2. **Feature 1: Login-Funktion (Entwickler A)**
   - Erstelle einen Feature-Branch von `develop`:
     ```bash
     git switch -c feature/login develop
     ```
   - Erstelle eine Datei `login.py`:
     ```python
     def login(username, password):
         if username == "admin" and password == "secret":
             return True
         return False
     ```
   - Committe und pushe:
     ```bash
     git add login.py && git commit -m "Login-Funktion implementiert"
     git push origin feature/login
     ```
   - Merge in develop:
     ```bash
     git switch develop
     git merge feature/login
     git push origin develop
     ```

3. **Feature 2: Registrierung (Entwickler B)**
   - Erstelle einen Feature-Branch von `develop`:
     ```bash
     git switch -c feature/registration develop
     ```
   - Erstelle eine Datei `register.py`:
     ```python
     def register(username, password):
         if len(password) < 8:
             return False, "Password zu kurz"
         return True, "Benutzer registriert"
     ```
   - Committe und pushe
   - Merge in develop (`git switch develop && git merge feature/registration`)

4. **Release vorbereiten**
   - Erstelle einen Release-Branch von `develop`:
     ```bash
     git switch -c release/1.0.0 develop
     ```
   - Aktualisiere `version.txt` auf `v1.0.0` und committe:
     ```bash
     echo "v1.0.0" > version.txt
     git add version.txt && git commit -m "Version auf 1.0.0 gesetzt"
     ```
   - Merge in main:
     ```bash
     git switch main
     git merge release/1.0.0
     git tag -a v1.0.0 -m "Release 1.0.0"
     git push origin main --tags
     ```
   - Merge zurück in develop:
     ```bash
     git switch develop
     git merge release/1.0.0
     git push origin develop
     ```
   - Lösche den Release-Branch:
     ```bash
     git branch -d release/1.0.0
     ```

5. **Hotfix neben laufender Entwicklung**
   - Im Produktiv-Code (main) wurde ein kritischer Bug gefunden
   - Währenddessen arbeiten andere an `feature/profile` (von develop)
   - Erstelle Hotfix von main:
     ```bash
     git switch -c hotfix/1.0.1 main
     ```
   - Es gibt einen kritischen Bug in `login.py` (existiert nicht auf main!) — also erstelle `login.py` mit dem Bugfix:
     ```python
     def login(username, password):
         # Fix: Korrekte Authentifizierung
         if username == "admin" and password == "secure123":
             return True
         return False
     ```
   - Committe, merge in main und tagge:
     ```bash
     git add login.py && git commit -m "Hotfix: Login-Passwort korrigiert"
     git switch main
     git merge hotfix/1.0.1
     git tag -a v1.0.1 -m "Hotfix 1.0.1"
     ```
   - Merge auch in develop (damit der Fix nicht im nächsten Release fehlt):
     ```bash
     git switch develop
     git merge hotfix/1.0.1
     ```
   - Lösche den Hotfix-Branch

6. **Historie betrachten**
   ```bash
   git log --oneline --graph --all --decorate
   ```

### Beispiel-Output

```
$ git log --oneline --graph --all --decorate
*   9a8b7c6 (HEAD -> develop) Merge branch 'hotfix/1.0.1' into develop
|\
| * 8f7e6d5 (tag: v1.0.1, main) Hotfix: Login-Passwort korrigiert
* |   7e6d5c4 Merge branch 'release/1.0.0' into develop
|\ \
| |/
|/|
* | 6d5c4b3 (tag: v1.0.0) Version auf 1.0.0 gesetzt
* |   5c4b3a2 Merge branch 'feature/registration' into develop
|\ \
| |/
|/|
* | 4b3a2b1 Registrierung implementiert
* |   3a2b1a0 Merge branch 'feature/login' into develop
|\ \
| |/
|/|
* | 2b1a0b9 Login-Funktion implementiert
|/
* 1a0b9c8 Initialer Commit (v0.1.0)
```

### Erweiterung

Simuliere eine parallele Feature-Entwicklung: Während `feature/profile` noch in Arbeit ist, wird ein dringender Hotfix notwendig. Zeige, wie der Hotfix in develop gemergt wird, und wie `feature/profile` nach dem Hotfix-Merge in develop aktualisiert werden kann (durch Mergen von develop in den Feature-Branch oder durch Rebase).
