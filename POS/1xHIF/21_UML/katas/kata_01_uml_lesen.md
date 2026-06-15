# K1: UML lesen

Gegeben ist folgendes UML-Klassendiagramm einer Bibliothek:

```
┌──────────────────────┐          ┌──────────────────┐
│      Bibliothek      │1         *│       Buch       │
├──────────────────────┤──────────├──────────────────┤
│ - name: String       │          │ - titel: String  │
│ - oeffnungszeiten    │          │ - autor: String  │
├──────────────────────┤          │ - isbn: String   │
│ + Bibliothek(name)   │          ├──────────────────┤
│ + buchHinzufuegen(..)│          │ + Buch(titel,..) │
│ + getBuecher():Buch[]│          │ + getTitel()     │
└──────────────────────┘          └──────────────────┘
```

Schreibe den vollständigen Java-Code für beide Klassen.
- Die Bibliothek kann mehrere Bücher verwalten (Array)
- Achte auf korrekte Kapselung (private Attribute, Getter)