# Kata 2: JPA Lazy Loading

| Feld | Wert |
|------|------|
| Konzepte | FetchType.LAZY, N+1 Problem, JOIN FETCH, EntityGraph |
| Schwierigkeit | 3/5 |
| Dauer | ca. 50 min |

### Aufgabenstellung

Erstelle ein JPA-Datenmodell und demonstriere das N+1 Problem mit anschliessender Losung.

1. Definiere die Entitaten:
   - `Author` (id, name, books — @OneToMany LAZY)
   - `Book` (id, title, author — @ManyToOne)

2. Implementiere ein Repository mit Methoden:
   - `findAll()` (verursacht N+1)
   - `findAllWithBooksJoinFetch()` (lost N+1 mit JOIN FETCH)
   - `findAllWithBooksEntityGraph()` (lost N+1 mit EntityGraph)

3. Erstelle eine `CommandLineRunner`-Klasse, die:
   - Testdaten anlegt (3 Autoren mit je 2-3 Buchern)
   - Jede Repository-Methode aufruft
   - Die Anzahl der ausgefuhrten SQL-Queries zahlt (oder Logger-Ausgaben zeigt)

### Beispiel-Output

```
=== N+1 Problem (findAll) ===
Author: Author 1
  Book: Book 1
  Book: Book 2
Authors found: 3
Executed queries: 4 (1 + 3)

=== Losung mit JOIN FETCH ===
Author: Author 1
  Book: Book 1
  Book: Book 2
Authors found: 3
Executed queries: 1 (nur 1 Query mit JOIN)
```

### Erweiterung

Fuge eine dritte Methode mit `@EntityGraph` hinzu und vergleiche alle drei Ansatze.
