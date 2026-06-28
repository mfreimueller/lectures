# Speaker Notes — 19: JPA Entities & Relationships

**Woche 22** | **Theorie 2h | Praxis 3h**

---

## 0. Wiederholung (15 min)

- JDBC: Connection, Statement, PreparedStatement
- DAO Pattern: Interface + Implementierung
- **Frage:** Wie viel Boilerplate-Code für eine einfache CRUD-Operation? → Viel!

## 1. JPA-Architektur (20 min)

- **JPA** = Jakarta Persistence API (ehemals Java Persistence API)
- **ORM** = Object-Relational Mapping — Objekte ↔ Tabellen
- **Komponenten:**
  - EntityManagerFactory → EntityManager
  - Persistence Context → verwaltet Entitäten
  - Persistence Unit → Konfiguration (persistence.xml)
- **Provider:** Hibernate (Standard)
- **Vergleich:** JPA-Code vs. JDBC-DAO — Seite an Seite zeigen

## 2. Entity-Mapping (25 min)

- **@Entity** — Klasse als Entität markieren
- **@Table(name = "...")** — Tabellenname (optional)
- **@Id** — Primärschlüssel
- **@GeneratedValue(strategy = ...)** — Auto-Increment
- **@Column(name = "...", nullable = ...)** — Spalten-Mapping
- **@Transient** — Nicht persistieren
- **Live Coding:** Article-Entity mit @Entity, @Id, @Column

## 3. EntityManager (25 min)

- **persist()** — Neue Entität speichern (INSERT)
- **find()** — Entität laden (SELECT)
- **merge()** — Entität aktualisieren (UPDATE)
- **remove()** — Entität löschen (DELETE)
- **createQuery()** — JPQL-Queries
- **Live Coding:** EntityManager CRUD für Article

## 4. JPQL (15 min)

- **Entity-orientierte Queries** — nicht SQL!
  ```java
  em.createQuery("SELECT a FROM Article a WHERE a.price > :minPrice", Article.class)
    .setParameter("minPrice", 10.0)
    .getResultList();
  ```
- **JOIN** via Navigation, nicht SQL-JOIN-Syntax
- **Named Parameters** mit `:name`

## 5. Praxis-Übergang (10 min)

- Katas: K1 JPA Entity, K2 JPQL, K3 JPA Relationships
- persistence.xml einrichten

## 6. Wrap-up (10 min)

- Nächste Woche: JPA Inheritance & Value Objects
- Hausübung: JPA CRUD mit Relationships

---

## Häufige Fehler

- @Entity vergessen → Klasse wird nicht als Entität erkannt
- @Id vergessen → "No identifier specified for entity"
- JPQL vs. SQL verwechselt → JPQL verwendet Entity-Namen, nicht Tabellen!
- persistence.xml fehlt oder falsch → PersistenceUnit nicht gefunden
- EntityManager nicht geschlossen → Resource Leak
- @GeneratedValue ohne strategy → Standard ist AUTO, aber explizit besser
