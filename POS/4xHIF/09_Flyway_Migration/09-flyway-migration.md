---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 09 - Flyway & Database Migration
## POS - 4xHIF

---

## The Schema Problem

- Wer hat die letzte Änderung an der DB gemacht?
- Welche Tabellen gibt es in Produktion, welche nicht?
- Warum funktioniert der Code lokal, aber nicht auf dem Server?
- Lösung: Schema-Migrationen — versioniert, reproduzierbar, automatisiert

---

## Manuelle Schema-Änderungen — Probleme

- SQL-Skripte werden per E-Mail/Chat geteilt
- Niemand weiß, welche Skripte schon ausgeführt wurden
- Produktion und Entwicklung laufen auseinander
- Kein Rollback möglich
- Keine Versionierung im Git

---

## Flyway — Überblick

- Versionierung für Datenbank-Schemata
- SQL-Dateien werden der Reihe nach ausgeführt
- Flyway merkt sich in einer Tabelle (`flyway_schema_history`), welche Migrationen schon gelaufen sind
- Integriert sich nahtlos in Spring Boot

---

## Flyway — Konzept

```
V1__Initial_schema.sql   ✅ ausgeführt
V2__Add_members.sql      ✅ ausgeführt
V3__Add_loans.sql        ⏳ wird beim nächsten Start ausgeführt
V4__Add_indexes.sql      ⏳ wartet
```

- Dateien in `src/main/resources/db/migration/`
- Namenskonvention: `V{Version}__{Beschreibung}.sql`
- Versionen sind durchnummeriert (1, 2, 3, ... oder 1.1, 1.2, ...)
- Bereits ausgeführte Migrationen werden NIEMALS geändert

---

## Dependency

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```

Spring Boot konfiguriert Flyway automatisch, wenn die Dependency auf dem Classpath ist.

---

## V1__Initial_Schema.sql

```sql
CREATE TABLE book (
    id          BIGSERIAL PRIMARY KEY,
    isbn        VARCHAR(13)  NOT NULL UNIQUE,
    title       VARCHAR(255) NOT NULL,
    year        INT          NOT NULL,
    created_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE member (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE loan (
    id           BIGSERIAL PRIMARY KEY,
    book_id      BIGINT NOT NULL REFERENCES book(id),
    member_id    BIGINT NOT NULL REFERENCES member(id),
    borrow_date  DATE NOT NULL,
    return_date  DATE
);
```

---

## Spring Boot — Auto-Konfiguration

```yaml
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration
    baseline-on-migrate: true

  jpa:
    hibernate:
      ddl-auto: validate  # WICHTIG: nicht update/create!
```

`ddl-auto: validate` prüft, ob Entities zum Schema passen — ohne selbst Änderungen zu machen.

---

## V2__Add_Phone_And_Category.sql

```sql
-- Spalte hinzufügen
ALTER TABLE member
    ADD COLUMN phone VARCHAR(20);

-- Neue Tabelle
CREATE TABLE category (
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL UNIQUE
);

-- Neue Join-Tabelle (Many-to-Many Buch ↔ Kategorie)
CREATE TABLE book_category (
    book_id     BIGINT NOT NULL REFERENCES book(id),
    category_id BIGINT NOT NULL REFERENCES category(id),
    PRIMARY KEY (book_id, category_id)
);
```

---

## Migration-Ablauf

1. App startet, Flyway prüft `flyway_schema_history`
2. Neue Migrationen werden erkannt (noch nicht ausgeführt)
3. Flyway führt sie der Reihe nach aus (V1, V2, V3, ...)
4. Jede erfolgreiche Migration wird in der History-Tabelle vermerkt
5. Spring Boot startet erst, wenn alle Migrationen durch sind

---

## Checksum — Integrität

- Flyway berechnet einen SHA-256 Checksum jeder Migrations-Datei
- Wird eine bereits ausgeführte Migration verändert → Checksum-Mismatch → App startet nicht!
- Regel: Niemals eine bereits ausgeführte Migration editieren — immer eine NEUE Migration schreiben

---

## Repair — Wenn was schiefgeht

```bash
./mvnw flyway:info

# Fehlgeschlagene Migration reparieren
./mvnw flyway:repair

./mvnw flyway:migrate
```

- `flyway:repair` löscht fehlgeschlagene Einträge aus der History
- Danach kann die Migration korrigiert und neu gestartet werden

---

## Flyway in Tests

```java
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class RepositoryTest {

    private static final PostgreSQLContainer postgres =
        new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.flyway.enabled", () -> "true");
    }
}
```

Flyway läuft auch in Tests — das Schema wird vor jedem Testlauf frisch aufgesetzt.

---

## Projekt: Eigene Migrationen

<div class="highlight-box">
<ol>
<li>Füge Flyway-Dependency zu pom.xml hinzu</li>
<li>Setze <code>spring.jpa.hibernate.ddl-auto: validate</code></li>
<li>Erstelle <code>V1__Initial_Schema.sql</code> mit deinem Domänen-Modell</li>
<li>Starte die App — Flyway erstellt das Schema</li>
<li>Erstelle <code>V2__...</code> mit einer Erweiterung</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Warum Schema-Migrationen notwendig sind</li>
<li>Flyway: versionierte SQL-Dateien</li>
<li>Namenskonvention V{Version}__{Beschreibung}.sql</li>
<li>ddl-auto: validate statt update/create</li>
<li>Checksum-Integrität und Repair</li>
</ul>
</div>
