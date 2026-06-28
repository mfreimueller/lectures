# Speaker Notes — 21: Exercise JPA Repository

**Woche 24** | **Theorie 2h | Praxis 3h** | **Typ: Übung**

---

## 0. Wiederholung (10 min)

- JPA: Entities, Relationships, Inheritance, Value Objects
- Repository Pattern: Generic Repository<T, ID>
- **Frage:** Welche Inheritance-Strategie für welches Szenario?

## 1. Übungseinleitung (15 min)

- Ziel: Komplette Data Layer für School Management System
- **Domain:**
  - Person → Student, Teacher (Inheritance)
  - Address, Email (Value Objects)
  - Course ↔ Enrollment ↔ Student (Relationships)
  - Student ↔ Elective (n:m)
- **Tech:** JPA mit H2 in-memory für Tests

## 2. Kata 1: Entity Layer (30 min)

- Entity-Klassen mit Vererbung (Person → Student, Teacher)
- Value Objects (Address, Email)
- Relationships: Course*--*Enrollment*--*Student, Student*--*Elective
- @OneToMany, @ManyToOne, @ManyToMany mit Cascade
- persistence.xml für H2 konfigurieren

## 3. Kata 2: Repository Layer (30 min)

- Generic JpaRepository<T, ID> mit CRUD-Operationen
- Concrete Repositories mit custom JPQL-Queries
- Transaction Management (begin, commit, rollback)
- TDD: Repository-Methoden testen

## 4. Kata 3: Testing (30 min)

- H2 in-memory Database (create-drop schema strategy)
- Integration Tests für Repository-Layer
- Test-Daten mit @BeforeEach einfügen
- Assertions für CRUD-Operationen und Relationships

## 5. Besprechung (20 min)

- Musterlösungen zeigen
- H2 vs. PostgreSQL für Tests diskutieren
- Fragen beantworten

## 6. Wrap-up (10 min)

- Nächste Woche: HTTP & REST
- PLÜ 3 in Woche 27 — Stoff: Todo App, Markdown, Reflection, JDBC, JPA, Servlets, REST

---

## Häufige Fehler

- H2-Dialekt in persistence.xml falsch → SQL-Fehler
- Cascade-Types falsch gesetzt → orphaned records
- @ManyToMany ohne @JoinTable → Default-Tabelle mit falschem Namen
- Tests ohne Transaction-Rollback → Test-Daten bleiben in DB
- JPQL mit Tabellen-Namen statt Entity-Namen → Query-Fehler
- EntityManager in Tests nicht geschlossen → Resource Leak
