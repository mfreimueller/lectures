# Kata 1: Remote-Zusammenarbeit simulieren

| Feld | Wert |
|------|------|
| Konzepte | git clone, git remote, git push, git pull, Non-Fast-Forward |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Simuliere eine Teamarbeit mit zwei Entwicklern über ein gemeinsames Remote-Repository.

1. **Zentrales Repository erstellen (Bare Repo)**
   - Erstelle ein Bare-Repository (ein Repository ohne Working Tree):
     ```bash
     mkdir -p ~/git-training
     cd ~/git-training
     git init --bare team-projekt.git
     ```
   - Ein Bare-Repo dient als "Server" — hier wird nur gepusht, nicht direkt gearbeitet

2. **Entwickler A: Repository klonen und arbeiten**
   - Klone das Bare-Repo:
     ```bash
     git clone ~/git-training/team-projekt.git dev-a
     cd dev-a
     ```
   - Erstelle eine Datei `readme.md` mit Inhalt und committe:
     ```bash
     echo "# Team Projekt" > readme.md
     git add readme.md && git commit -m "Initialer Commit"
     ```
   - Pushe die Änderungen zum Remote:
     ```bash
     git push origin main
     ```

3. **Entwickler B: Repository klonen und arbeiten**
   - Öffne ein zweites Terminal (oder wechsle das Verzeichnis)
   - Klone dasselbe Repository:
     ```bash
     git clone ~/git-training/team-projekt.git dev-b
     cd dev-b
     ```
   - `dev-b` hat jetzt denselben Stand wie `dev-a`
   - Erstelle eine Datei `contributors.md` und pushe:
     ```bash
     echo "- Alice" > contributors.md
     git add contributors.md && git commit -m "Contributors hinzugefügt"
     git push origin main
     ```

4. **Entwickler A: Pull & Konfliktfrei weiterarbeiten**
   - Wechsle zurück zu `dev-a`
   - Ändere `readme.md` und committe:
     ```bash
     echo "## Überblick" >> readme.md
     git add readme.md && git commit -m "Überblick hinzugefügt"
     ```
   - Versuche zu pushen — **das schlägt fehl!** (Entwickler B hat Änderungen)
   - Ziehe die Änderungen von B:
     ```bash
     git pull origin main
     ```
   - Das sollte ein Fast-Forward sein (kein Konflikt)
   - Jetzt pushen: `git push origin main`

5. **Entwickler B: Nicht-Fast-Forward erleben**
   - Wechsle zu `dev-b`
   - Beide haben jetzt denselben Stand
   - Ändere `contributors.md`, committe (lokal), aber push nicht
   - Ändere eine andere Datei, committe (lokal)
   - Jetzt push — und beobachte die Ausgabe

### Beispiel-Output

```
# Fehlgeschlagener Push
$ git push origin main
To /Users/.../team-projekt.git
 ! [rejected]        main -> main (non-fast-forward)
error: failed to push some refs
hint: Updates were rejected because the remote contains work that you do not
hint: have locally. This is usually caused by another repository pushing ...

# Erfolgreicher Pull
$ git pull origin main
From /Users/.../team-projekt
   123abc..456def  main -> origin/main
Updating 123abc..456def
Fast-forward
 contributors.md | 1 +
 1 file changed, 1 insertion(+)

$ git push origin main
Success - everything up-to-date
```

### Erweiterung

Simuliere einen Konflikt: Beide Entwickler ändern dieselbe Zeile in derselben Datei. Entwickler A pusht zuerst (erfolgreich). Entwickler B zieht (`git pull`) — es kommt zum Merge-Konflikt. Löse ihn auf und pushe.
