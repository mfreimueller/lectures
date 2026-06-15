# Kata 3: .gitignore & Änderungen rückgängig machen

| Feld | Wert |
|------|------|
| Konzepte | .gitignore, git restore, git reset, git revert, git rm --cached |
| Schwierigkeit | 2/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Lerne, wie man das Repository sauber hält und Fehler rückgängig macht.

1. **Projekt mit Build-Artifakten**
   - Erstelle ein neues Repository
   - Erstelle folgende Dateistruktur:
     ```
     src/
       Main.java
     build/
       Main.class
     .idea/
       workspace.xml
     ```
   - Die Inhalte von `Main.java`:
     ```java
     public class Main {
         public static void main(String[] args) {
             System.out.println("Hello Git");
         }
     }
     ```

2. **.gitignore erstellen**
   - Erstelle eine `.gitignore`-Datei mit folgenden Mustern:
     ```
     *.class
     build/
     .idea/
     ```
   - Füge `src/Main.java` und `.gitignore` zum Staging hinzu
   - Überprüfe mit `git status`, ob `build/` und `.idea/` ignoriert werden
   - Erstelle einen Commit

3. **Ignorierte Dateien versehentlich committed**
   - Entferne das Muster `*.class` kurz aus `.gitignore`
   - Erstelle eine Datei `test.class` und führe `git add -A` aus
   - Erstelle einen Commit (der `test.class` enthält)
   - Stelle das `.gitignore`-Muster wieder her

4. **Bereits getrackte ignorierte Dateien entfernen**
   - Verwende `git rm --cached test.class` (entfernt nur aus Git, nicht von der Festplatte)
   - Erstelle einen Commit
   - Überprüfe, dass `test.class` jetzt ignoriert wird

5. **Änderungen rückgängig machen**
   - Füge in `Main.java` eine zweite Zeile hinzu: `System.out.println("Ups");`
   - Ohne zu committen: verwende `git restore src/Main.java`
   - Überprüfe, dass die Änderung weg ist

6. **Commit rückgängig machen**
   - Füge eine neue Datei `todo.txt` hinzu und committe sie mit einer falschen Nachricht
   - Korrigiere mit `git commit --amend -m "Richtige Nachricht"`
   - Erstelle noch einen Commit mit einer sinnlosen Änderung
   - Mache diesen Commit mit `git revert HEAD` rückgängig

### Beispiel-Output

```
$ git status
On branch main
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore
        src/Main.java

build/ und .idea/ werden ignoriert (nicht in Untracked)

$ git rm --cached test.class
rm 'test.class'

$ git log --oneline
d4e5f6f Revert: sinnlose Änderung rückgängig
a1b2c3d Sinnlose Änderung
9a8b7c6 Richtige Nachricht
...
```

### Erweiterung

Erstelle einen Commit, verschiebe dann HEAD mit `git reset --soft HEAD~1` einen Schritt zurück. Überprüfe mit `git status`, was passiert. Wiederhole mit `git reset --mixed HEAD~1` und dann mit `git reset --hard HEAD~1`. Dokumentiere die Unterschiede.
