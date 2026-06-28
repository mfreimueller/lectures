# Speaker Notes — 20: JPA Inheritance & Value Objects

**Woche 23** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- JPA: @Entity, EntityManager, JPQL
- Relationships: @OneToOne, @OneToMany, @ManyToOne, @ManyToMany
- **Frage:** Wie speichert man eine Vererbungshierarchie in einer relationalen DB?

## 1. JPA Inheritance-Strategien (35 min)

### SINGLE_TABLE
- Eine Tabelle für alle Klassen
- @DiscriminatorColumn, @DiscriminatorValue
- **Vorteil:** Schnellste Queries (kein JOIN)
- **Nachteil:** Nullable Spalten für Subtyp-Felder

### JOINED
- Eine Tabelle pro Klasse, FK-Beziehungen
- **Vorteil:** Normalisiert, keine Null-Spalten
- **Nachteil:** JOINs bei polymorphen Queries

### TABLE_PER_CLASS
- Eine Tabelle pro konkreter Klasse
- **Vorteil:** Keine Null-Spalten, keine JOINs für konkrete Typen
- **Nachteil:** UNION für polymorphe Queries

- **Live Coding:** PaymentMethod-Hierarchie mit JOINED-Strategie

## 2. Value Objects (20 min)

- **@Embeddable** — Wertobjekt definieren (Address, Money, Email)
- **@Embedded** — In Entität einbetten
- **@AttributeOverrides** — Spaltennamen überschreiben (wenn mehrfach eingebettet)
- **Keine eigene Identität** — gehört zur Parent-Entität
- **Live Coding:** Address-Embeddable in Customer-Entity

## 3. Repository Pattern (15 min)

- **Generic Repository<T, ID>** — CRUD-Operationen für alle Entitäten
- EntityManager-Operationen hinter Interface versteckt
- **Transaction Management:** EntityTransaction (begin, commit, rollback)
- **Live Coding:** JpaRepository<T, ID> mit generischen CRUD-Methoden

## 4. Praxis-Übergang (10 min)

- Katas: K1 Inheritance, K2 Value Objects, K3 Repository

## 5. Wrap-up (10 min)

- Nächste Woche: JPA Repository Übung
- Hausübung: Inheritance-Strategie für eigenes Projekt wählen

---

## Häufige Fehler

- SINGLE_TABLE: Subtyp-Felder als nullable → DB-Constraint fehlt
- JOINED: Performance-Probleme bei vielen JOINs → Index prüfen
- TABLE_PER_CLASS: Polymorphe Queries mit UNION → langsam
- @Embeddable ohne @Embedded → wird nicht persistiert
- @AttributeOverrides vergessen → Spaltennamen-Kollision bei mehrfachem Embed
- Transaction nicht committed → Änderungen nicht gespeichert
- Repository ohne generischen Typ → Code-Duplikation
