---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 08 - Testcontainers & Postgre SQL
## POS - 4xHIF

---

## The H2 Problem

- H2 ist nicht 100% PostgreSQL-kompatibel
- Unterschiede in: SQL-Dialekt, Datentypen, Constraints
- Tests können grün sein — Produktion crasht trotzdem
- "It works on my machine" — nur mit H2 im Test!

---

## H2 vs PostgreSQL — Beispiele

| Feature | H2 | PostgreSQL |
| --- | --- | --- |
| Boolean | TINYINT (0/1) | BOOLEAN |
| JSON | VARCHAR | JSONB |
| UUID | VARCHAR | UUID native |
| Sequences | Simuliert | Native SEQUENCE |
| ARRAY | Nicht unterstützt | Native Arrays |

Fazit: Teste gegen die gleiche DB wie in Produktion!

---

## Testcontainers — Idee

- Startet Docker-Container programmatisch in JUnit-Tests
- Unterstützt PostgreSQL, MySQL, Redis, Kafka, ...
- Container wird vor den Tests gestartet, nach den Tests gestoppt
- Benötigt nur eine laufende Docker-Umgebung

---

## Testcontainers — Vorteile

- Echte Datenbank, kein Simulator
- Isolierte Tests — jeder Testlauf frischer Container
- Konfigurierbar (Version, Port, Init-Script)
- CI-kompatibel (Docker-in-Docker, Testcontainers Cloud)

---

## Dependency

```xml
<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>testcontainers</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>postgresql</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <scope>test</scope>
</dependency>
```

Ohne Version — wird via BOM von Spring Boot verwaltet.

---

## PostgreSQLContainer — Setup

```java
@DataJpaTest @Testcontainers
class BookRepositoryTest {
    @Container static PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16")
            .withDatabaseName("testdb").withUsername("test").withPassword("test");
}
```

- @Testcontainers aktiviert automatische Lifecycle-Verwaltung
- @Container markiert das Container-Objekt
- Static = Container wird einmal pro Testklasse gestartet

---

## @DynamicPropertySource

```java
@DataJpaTest
@Testcontainers
class BookRepositoryTest {

    @Container
    static PostgreSQLContainer postgres =
        new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void configureProperties(
            DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
            postgres::getJdbcUrl);
        registry.add("spring.datasource.username",
            postgres::getUsername);
        registry.add("spring.datasource.password",
            postgres::getPassword);
    }
}
```

Überschreibt die application.yml-Werte dynamisch zur Laufzeit.

---

## Ablauf im Detail

1. JUnit startet die Testklasse
2. @Testcontainers erkennt @Container und startet PostgreSQL
3. Container meldet sich mit dynamischem Port; @DynamicPropertySource injiziert JDBC-URL + Credentials
4. Spring konfiguriert DataSource; Tests laufen gegen echte PostgreSQL-Datenbank
5. Nach allen Tests: Container wird gestoppt

---

## Abstract Test Base Class

```java
@DataJpaTest
@Testcontainers
public abstract class RepositoryTest {

    private static final PostgreSQLContainer postgres =
        new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void configureProperties(
            DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
            postgres::getJdbcUrl);
        registry.add("spring.datasource.username",
            postgres::getUsername);
        registry.add("spring.datasource.password",
            postgres::getPassword);
    }
}
```

Alle Repository-Tests erben einfach von dieser Basisklasse.

---

## Mit Flyway-Konfiguration

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

@AutoConfigureTestDatabase.Replace.NONE verhindert, dass Spring H2 verwendet.

---

## Projekt: Tests migrieren

<div class="highlight-box">
<ol>
<li>Füge Testcontainers-Dependencies zu pom.xml hinzu</li>
<li>Erstelle eine abstrakte Basisklasse <code>RepositoryTest</code></li>
<li>Migriere alle <code>@DataJpaTest</code>-Klassen von H2 auf Testcontainers</li>
<li>Stelle sicher, dass alle Tests grün sind</li>
<li>Optional: Füge einen Test hinzu, der einen PostgreSQL-spezifischen Feature testet</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Warum H2 für JPA-Tests nicht ausreicht</li>
<li>Testcontainers für PostgreSQL-Container in Tests</li>
<li>@Container, @Testcontainers, @DynamicPropertySource</li>
<li>Abstracte Test-Basisklasse für Wiederverwendung</li>
<li>Integration mit Flyway</li>
</ul>
</div>
