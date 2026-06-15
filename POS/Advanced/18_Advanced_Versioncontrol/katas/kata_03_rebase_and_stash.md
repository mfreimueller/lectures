# Kata 3: Rebase & Stash

| Feld | Wert |
|------|------|
| Konzepte | git rebase, git stash, git stash pop, lineare Historie |
| Schwierigkeit | 3/5 |
| Dauer | ca. 35 min |

### Aufgabenstellung

Lerne, wie man mit Rebase eine lineare Historie erstellt und mit Stash Arbeit zwischenspeichert.

1. **Repository vorbereiten**
   - Erstelle ein Repository `rebase-lab`
   - Erstelle eine Datei `calc.py` und committe sie:
     ```python
     def add(a, b):
         return a + b

     print(add(3, 4))
     ```
   - Erstelle einen weiteren Commit auf main, der eine `subtract`-Funktion hinzufügt

2. **Feature-Branch mit mehreren Commits**
   - Erstelle und wechsle zu Branch `feature/multiply`
   - Füge eine `multiply`-Funktion hinzu und committe
   - Füge eine `divide`-Funktion hinzu und committe
   - Der Graph zeigt jetzt:
     ```
     main:     A---B
              /
     feature: A---C---D
     ```

3. **Weitere Commits auf main**
   - Wechsle zurück zu `main`
   - Füge eine `power`-Funktion hinzu und committe
   - Der Graph:
     ```
     main:     A---B---E
              /
     feature: A---C---D
     ```

4. **Rebase des Feature-Branches**
   - Wechsle zu `feature/multiply`
   - Führe Rebase auf main durch:
     ```bash
     git rebase main
     ```
   - Der Graph sollte jetzt so aussehen:
     ```
     main:     A---B---E
                        \
     feature:            C'---D'
     ```
   - Die Commits C und D wurden neu aufgesetzt (neue SHA-1 Hashes!)

5. **Merge (Fast-Forward)**
   - Wechsle zurück zu `main` und merge den Feature-Branch:
     ```bash
     git switch main
     git merge feature/multiply
     ```
   - Da main nach E keine weiteren Commits hat, ist das ein Fast-Forward-Merge
   - Die Historie ist jetzt <strong>vollkommen linear</strong>:
     ```
     main:     A---B---E---C'---D'
     ```

6. **Stash — Arbeit zwischenspeichern**
   - Füge in `calc.py` eine unvollständige `modulo`-Funktion hinzu (noch nicht fertig, nicht commitbar)
   - Du musst dringend einen Bugfix auf main machen
   - Verschwinde die Änderungen mit `git stash`
   - Wechsle zu main, erstelle einen Bugfix-Commit
   - Wechsle zurück zu `feature/multiply`
   - Hole die gestashten Änderungen zurück mit `git stash pop`
   - Vervollständige die `modulo`-Funktion und committe

### Beispiel-Output

```
# Rebase
$ git rebase main
Successfully rebased and updated refs/heads/feature/multiply.

# Lineare Historie nach dem Merge
$ git log --oneline --graph
* d4e5f6f (HEAD -> main) divide-Funktion
* c3d4e5f multiply-Funktion
* b2c3d4e power-Funktion
* a1b2c3d subtract-Funktion
* 9a8b7c6 Initialer Commit mit add

# Stash
$ git stash
Saved working directory and index state WIP on feature/multiply: ...

$ git stash pop
On branch feature/multiply
Changes not staged for commit:
  modified:   calc.py
```

### Erweiterung

Erstelle zwei Feature-Branches von main, rebase beide auf main und merge sie nacheinander. Vergleiche das Ergebnis graphisch mit einer Variante, in der du beide Feature-Branches ohne Rebase mit 3-Way-Merge in main zusammengeführt hast. Welche Variante ist übersichtlicher?
