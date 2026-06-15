# Kata 2: Datei-Lebenszyklus

| Feld | Wert |
|------|------|
| Konzepte | git diff, git rm, git mv, git status, commit |
| Schwierigkeit | 2/5 |
| Dauer | ca. 30 min |

### Aufgabenstellung

Lerne, wie man Dateien im Git-Workflow erstellt, ändert, löscht und umbenennt.

1. **Repository einrichten**
   - Erstelle ein Repository `file-lifecycle`
   - Erstelle eine Datei `index.html` mit folgendem Inhalt und committe sie:
     ```html
     <!DOCTYPE html>
     <html><head><title>Meine Seite</title></head>
     <body><h1>Willkommen</h1></body></html>
     ```

2. **Datei ändern**
   - Ändere den Titel von "Meine Seite" in "Version 2"
   - Überprüfe mit `git diff`, was sich geändert hat
   - Füge die Änderung zum Staging hinzu
   - Verwende `git diff --staged` — was siehst du?
   - Erstelle einen Commit

3. **Datei umbenennen**
   - Benenne `index.html` mit `git mv` in `index_v2.html` um
   - Überprüfe den Status — was zeigt Git?
   - Erstelle einen Commit

4. **Datei löschen**
   - Lösche `index_v2.html` mit `git rm`
   - Erstelle einen Commit
   - Zeige die vollständige History mit `git log --oneline`

5. **History im Detail**
   - Verwende `git log --oneline --stat` — was zeigt diese Ausgabe zusätzlich?
   - Verwende `git show <commit-hash>` für den ersten Commit — was siehst du?

### Beispiel-Output

```
$ git diff --staged
diff --git a/index.html b/index.html
index e69de29..ab123cd 100644
--- a/index.html
+++ b/index.html
@@ -1,3 +1,3 @@
 <!DOCTYPE html>
 <html><head><title>Meine Seite</title></head>
-<body><h1>Willkommen</h1></body></html>
+<body><h1>Version 2</h1></body></html>

$ git log --oneline --stat
abc1234 Datei gelöscht
 index_v2.html | 0
def5678 Datei umbenannt
 index.html => index_v2.html | 0
f012345 Titel geändert
 index.html | 2 +-
7890abc Initialer Commit
 index.html | 4 ++++
```

### Erweiterung

Erstelle eine neue Datei, füge sie zum Staging hinzu, ändere sie dann erneut (ohne erneutes `git add`) und führe `git status` aus. Erkläre, warum Git sowohl "changes to be committed" als auch "changes not staged for commit" anzeigt.
