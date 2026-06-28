# Speaker Notes — 12: Exercise CLI Todo App

**Woche 15** | **Theorie 2h | Praxis 3h** | **Typ: Übung**

---

## 0. Wiederholung (10 min)

- Streams: filter, map, flatMap, reduce, groupingBy, partitioningBy
- SOLID, TDD, Testing
- **Frage:** Was war die schwierigste Stream-Operation?

## 1. Übungseinleitung (20 min)

- Ziel: CLI Todo App mit In-Memory-Repository
- **Domain:** Task-Record (id, title, completed, priority, dueDate, tags)
- **Architektur:**
  - `Task` — Record mit Priority-Enum
  - `TaskRepository` — Interface mit Stream-basierten Queries
  - `InMemoryTaskRepository` — Implementierung mit Streams
  - CLI-Shell mit switch-Expression für Commands
- **Wird in Woche 20–24 mit JDBC erweitert!**

## 2. Kata 1: Task Record (20 min)

- Task-Record erstellen: id, title, completed, priority, dueDate (Optional), tags
- Priority-Enum: LOW, MEDIUM, HIGH
- Validierung im kompakten Konstruktor
- Statische Factory-Methode `of(title, priority)`

## 3. Kata 2: InMemoryTaskRepository (30 min)

- Interface: `findByCompleted()`, `findByPriority()`, `findByTag()`, `findAll()`, `save()`, `delete()`
- Implementierung mit Streams: filter, sorted, groupingBy, partitioningBy
- TDD: Tests für jede Query-Methode schreiben

## 4. Kata 3: CLI Shell (30 min)

- Scanner für Benutzereingaben
- switch-Expression für Command-Routing: add, list, done, remove, exit
- Formatierung der Ausgabe (Tabelle, farbig wenn möglich)
- TDD: CLI-Logik separat testen

## 5. Besprechung (20 min)

- Musterlösungen zeigen
- Architektur-Diskussion: Warum Interface? → Austauschbar (später JDBC)
- Fragen beantworten

## 6. Wrap-up (10 min)

- Nächste Woche: Markdown → HTML Converter
- Todo App aufheben — wird mit JDBC erweitert!

---

## Häufige Fehler

- Task-Record ohne Validierung → leere Titel erlaubt
- Repository ohne Interface → später nicht austauschbar
- Streams zu komplex → aufteilen in benannte Methoden
- CLI: Scanner nicht schließen → Resource Leak
- dueDate als null statt Optional → NPE-Gefahr
