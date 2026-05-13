# Kata 2: File System Visitor

| Feld | Wert |
|------|------|
| Konzepte | Composite + Visitor, Traversierung, Zustand im Visitor |
| Schwierigkeit | 3/5 |
| Dauer | ca. 45 min |

### Aufgabenstellung

Implementiere ein einfaches Dateisystem mit dem Composite Pattern und wende das Visitor Pattern fur verschiedene Operationen an.

1. Definiere das Interface `FileSystemElement` mit:
   - `String getName()`
   - `void accept(FileSystemVisitor visitor)`

2. Definiere das Interface `FileSystemVisitor` mit:
   - `void visitFile(File file)`
   - `void visitDirectory(Directory dir)`

3. Implementiere die konkreten Elemente:
   - `File` mit Attributen `name, sizeInBytes`
   - `Directory` mit Attributen `name, children` (Liste von `FileSystemElement`)

   Wichtig: In `Directory.accept()` musst du zuerst den Visitor fur das Directory selbst aufrufen und dann bei allen Kindern `accept` aufrufen.

4. Implementiere drei konkrete Visitor:
   - `SizeCalculator` — berechnet die Gesamtgroße (summiert alle File-Großen)
   - `ListingVisitor` — gibt einen baumartigen Verzeichnisbaum aus (mit Einruckung)
   - `SearchVisitor` — sucht nach Dateien mit einem bestimmten Namen

5. Teste in einer `main`-Methode.

### Beispiel-Output

```
/root/
  docs/
    readme.txt (1024 bytes)
    notes.txt (2048 bytes)
  src/
    main.java (4096 bytes)
    utils.java (3072 bytes)

Total size: 10240 bytes

Search for 'readme.txt':
  /root/docs/readme.txt (1024 bytes)
```
