# Kata 1: Branches & Mergen (konfliktfrei)

| Feld | Wert |
|------|------|
| Konzepte | git branch, git merge, git log --graph, 3-Way-Merge |
| Schwierigkeit | 2/5 |
| Dauer | ca. 25 min |

### Aufgabenstellung

Lerne, Branches zu erstellen und ohne Konflikte zu mergen.

1. **Repository vorbereiten**
   - Erstelle ein neues Repository `branch-merge`
   - Erstelle eine Datei `index.html` mit Basis-Inhalt und committe sie:
     ```html
     <h1>Startseite</h1>
     <p>Willkommen auf unserer Seite.</p>
     ```

2. **Feature-Branch erstellen**
   - Erstelle und wechsle zu einem Branch `feature/navigation`:
     ```bash
     git switch -c feature/navigation
     ```
   - Füge in `index.html` einen Navigationsbereich hinzu:
     ```html
     <nav><a href="/">Home</a> | <a href="/about">About</a></nav>
     <h1>Startseite</h1>
     <p>Willkommen auf unserer Seite.</p>
     ```
   - Erstelle einen Commit

3. **Weiterer Commit auf dem Branch**
   - Füge einen Footer in `index.html` hinzu:
     ```html
     <nav><a href="/">Home</a> | <a href="/about">About</a></nav>
     <h1>Startseite</h1>
     <p>Willkommen auf unserer Seite.</p>
     <footer>&copy; 2026</footer>
     ```
   - Erstelle einen Commit

4. **Parallelarbeit auf main**
   - Wechsle zurück zu `main`
   - Ändere den Titel in `index.html`:
     ```html
     <h1>Willkommen!</h1>
     <p>Willkommen auf unserer Seite.</p>
     ```
   - Erstelle einen Commit
   - Der Graph sieht jetzt so aus:
     ```
     main:     A---B
              /
     feature: A---C---D
     ```

5. **Mergen (3-Way-Merge)**
   - Merge den `feature/navigation`-Branch in `main`:
     ```bash
     git switch main
     git merge feature/navigation
     ```
   - Da unterschiedliche Bereiche geändert wurden, sollte dieser Merge <strong>konfliktfrei</strong> sein
   - Ein Editor öffnet sich für die Commit-Nachricht — speichere und schließe ihn

6. **Ergebnis prüfen**
   - Zeige die History graphisch an: `git log --oneline --graph --all`

### Beispiel-Output

```
$ git log --oneline --graph --all
*   e5f6a7c (HEAD -> main) Merge branch 'feature/navigation'
|\
| * d4c3b2a (feature/navigation) Footer hinzugefügt
| * c3b2a1b Navigation hinzugefügt
* | b2a1b0c Titel geändert
|/
* a1b0c9d Initialer Commit
```

### Erweiterung

Lösche den gemergten Branch mit `git branch -d feature/navigation`. Überprüfe mit `git branch -a`, ob er noch existiert. Was passiert, wenn du nicht gemergte Änderungen auf einem Branch hast und `-d` verwendest?
