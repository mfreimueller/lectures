# Kata 2: Factory Method - Document Factory

| Feld | Wert |
|------|------|
| Konzepte | Factory Method, abstrakte Creator-Klasse, Vererbung |
| Schwierigkeit | 3/5 |
| Dauer | ca. 30 min |

## Aufgabenstellung

Implementieren Sie das Factory Method Pattern fur verschiedene Dokumenttypen.

1. Erstellen Sie ein Interface `Document` mit den Methoden `void open()`, `void save()` und `void close()`.
2. Implementieren Sie drei konkrete Dokumente: `PdfDocument`, `WordDocument` und `HtmlDocument`.
3. Erstellen Sie eine abstrakte Klasse `DocumentCreator` mit der Factory-Methode `Document createDocument()` und einer Vorlagenmethode `void newDocument()`, die createDocument() aufruft und dann open(), Inhalt schreiben, save() und close() ausfuhrt.
4. Implementieren Sie die konkreten Creator: `PdfCreator`, `WordCreator` und `HtmlCreator`.

### Beispiel-Output

```
DocumentCreator creator = new PdfCreator();
creator.newDocument();
// Output:
// Creating PDF document...
// Opening PDF document...
// Writing PDF content...
// Saving PDF document...
// Closing PDF document...
```

### Erweiterung

Fugen Sie einen `MarkdownCreator` hinzu. Stellen Sie sicher, dass das Open/Closed-Prinzip eingehalten wird — der bestehende Code darf nicht geandert werden mussen.
