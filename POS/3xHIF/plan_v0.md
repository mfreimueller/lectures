# Jahresplan 3xHIF — Programmieren und Software Entwicklung

**Roter Faden:** Progression der Abstraktionsebenen — Sprachebene (Java 8+) → Designebene (SOLID, TDD) → Datenebene (Streams, Projekte) → Metaebene (Reflection) → Persistenzebene (JDBC, DAO/Repository) → Kommunikationsebene (REST API).

**Mini-Projekte:** CLI Todo App (Woche 15), Markdown → HTML Converter (Woche 16).

**Format pro Woche:** 2h Theorie + 2h Praxis (flexibel mischbar).

**Sprache:** Java (ab Java 17).

**Unterrichtssprache:** Deutsch.

---

| Wo. | Theorie (2h) | Übung / Katas | Notes |
|-----|-------------|---------------|-------|
| **1** | **Setup & Modern Java Intro** — IntelliJ, Git, Maven/Gradle-Quickstart. Java-Evolution 7 → 8 → 11 → 17. `var` (Local Variable Type Inference). Records (kompakte Datenklassen). | **K1:** Eigenes Repo aufsetzen, erstes Maven-Projekt. **K2:** `Record` für einfache Datenklassen (z. B. `Person`, `Book`). **K3:** `var` in lokalen Schleifen/Streams. | — |
| **2** | **Interfaces, Pattern Matching, Text Blocks** — Default Methods & static Methods in Interfaces. Pattern Matching für `instanceof`. Text Blocks (`"""`). | **K1:** Interface mit Default-Methoden erweitern. **K2:** `instanceof`-Pattern umschreiben. **K3:** Mehrzeilige Strings mit Text Blocks. | — |
| **3** | **Optional, switch, sealed** — `Optional<T>`: Erzeugung, `map`, `flatMap`, `filter`, `orElse`, `orElseThrow`. `switch`-Expressions (Pfeil-Syntax, `yield`). Sealed Classes (`sealed`, `permits`). | **K1:** Null-Checks durch Optional ersetzen. **K2:** Alte switch-Blöcke als Expressions umschreiben. **K3:** Sealed Class-Hierarchie modellieren (z. B. `Shape` → `Circle`, `Rect`). | — |
| **4** | **Unnamed Variables, Flexible Constructor Bodies, moderne APIs** — Unnamed Variables `_` in Catch/Pattern/Lambda. Flexible Constructor Bodies (Code vor `super()`). Moderne APIs: `String::formatted`, `String::strip`, `Files.readString/writeString`, `List.copyOf`, `Map.copyOf`, `Collectors.toList()` etc. | **K1:** Code mit `_`-Variablen bereinigen. **K2:** Validierung im Constructor vor `super()`. **K3:** Datei-IO mit `Files.readString/writeString`. | — |
| **5** | **Übung: Refactoring Java 7 → Modern Java** — Workshop: Gegeben ist Java-7-Code aus 1./2. Klasse. Ziel: Records, `var`, Optional, switch-Expressions, Pattern Matching, Text Blocks anwenden. | **K1:** Klasse → Record. **K2:** Null-Handling → Optional. **K3:** If-else-Kaskade → switch-Expression. **K4:** `String.format` → Text Blocks. | Pair Programming empfohlen. |
| **6** | **Übung** — Gemischte Aufgaben zu Wochen 1–5. | Wiederholung aller modernen Java-Features anhand kleiner Aufgaben. PLÜ-Vorbereitung. | — |
| **7** | *PLÜ 1* | — | Stoff: Wochen 1–6. |
| **8** | **Unit Testing** — JUnit 5: `@Test`, `@BeforeEach`, `@AfterEach`, `assertAll`, `assertThrows`. AssertJ: fließende Assertions (`assertThat(...).isEqualTo().hasSize().extracting()`). Test-Organisation (Given/When/Then). Parameterized Tests (`@CsvSource`, `@ValueSource`). | **K1:** Bestehende Klasse testen (z. B. Record-Tests). **K2:** Parameterisierte Tests für Grenzfälle. **K3:** AssertJ statt `assertEquals`. | Testing wird ab jetzt in ALLEN Übungen vorausgesetzt. |
| **9** | **TDD** — Red-Green-Refactor-Zyklus. FIRST-Prinzipien (Fast, Isolated, Repeatable, Self-validating, Timely). Demonstration: String Calculator Kata. Baby Steps. | **K1:** FizzBuzz im TDD. **K2:** String Calculator (Inkrementell). **K3:** Leere-Tests zuerst schreiben. | Pair Programming (Driver/Navigator). |
| **10** | **SOLID I (SRP, OCP)** — Single Responsibility Principle: Eine Klasse, ein Grund zu ändern. Open-Closed Principle: Offen für Erweiterung, geschlossen für Modifikation. | **K1:** Aufgeblähte Klasse nach SRP aufsplitten. **K2:** Strategie-Pattern als OCP-Beispiel. **K3:** Refactoring mit Tests absichern. | — |
| **11** | **SOLID II (LSP, ISP, DIP)** — Liskov Substitution: Untertypen müssen Basis-Typen ersetzbar machen. Interface Segregation: Kleine, fokussierte Interfaces. Dependency Inversion: Abhängigkeiten zu Abstraktionen, nicht zu Konkretionen. | **K1:** LSP-Verletzung in Vererbungshierarchie finden & fixen. **K2:** Fat Interface aufsplitten (ISP). **K3:** `new` durch Constructor Injection ersetzen (DIP). | — |
| **12** | **Streams I** — Intermediate Ops: `filter`, `map`, `flatMap`, `distinct`, `sorted`, `peek`. Terminal Ops: `forEach`, `count`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`. | **K1:** For-Schleifen → Streams umschreiben. **K2:** flatMap für verschachtelte Listen. **K3:** Optional in Streams: `flatMap(Optional::stream)`. | — |
| **13** | **Streams II** — `reduce`, `collect` mit `Collectors.toList/toSet/toMap/toUnmodifiableList`. `groupingBy`, `partitioningBy`, `joining`, `summarizingInt/Long/Double`. | **K1:** Datenanalyse mit groupingBy. **K2:** Eigene Collector-Implementierung. **K3:** Partitioning (erfüllt/nicht erfüllt). | PLÜ-Vorbereitung. |
| **14** | *PLÜ 2* | — | Stoff: Wochen 8–13 (Testing, TDD, SOLID, Streams). |
| | *Weihnachtspause* | | |
| **15** | **Übung: CLI Todo App** — `Task`-Record (id, title, completed, priority, dueDate, tags). `TaskRepository`-Interface. `InMemoryTaskRepository`. CLI mit `switch`-Expression für Commands (add, list, done, remove). Streams für Filtern/Sortieren/Gruppieren. | Todo App MVP bauen: In-Memory-Speicher, CLI-basiert, TDD für Repository & CLI. Fokus: Records, Optional (dueDate), Streams (filter, sort). | Pair Programming. Wird in Woche 20–24 mit JDBC-Backend erweitert. |
| **16** | **Übung: Markdown → HTML Converter** — Tokenizer → Parser → Renderer. Records für AST: `Heading`, `Paragraph`, `Bold`, `Italic`, `CodeBlock`, `ListItem`, `Link`. Streams für zeilenweises Processing. | Mini-Markdown-Parser: Unterstützt `# Heading`, `**bold**`, `*italic*`, `` `code` ``, `- list`. TDD für jedes Element. | Code Review am Ende. |
| **17** | **Reflection I** — `Class<?>`, `getMethods()`, `getDeclaredFields()`, `getConstructors()`, `newInstance()`, `Method.invoke()`, `Field.get/set()`. | **K1:** Objekt-Struktur zur Laufzeit inspizieren. **K2:** Getter/Setter dynamisch aufrufen. **K3:** Private Felder lesen/schreiben (`setAccessible`). | — |
| **18** | **Reflection II & Annotations** — Eigene Annotationen: `@interface`, `@Retention`, `@Target`. Runtime-Processing mit Reflection. Wiederholbare Annotationen. | **K1:** `@LogExecutionTime`-Annotation bauen & auswerten. **K2:** `@NotNull`-Validierung zur Laufzeit. **K3:** Annotation-gesteuertes JSON-Serialisieren. | — |
| **19** | **Übung: Bean Mapping via Reflection** — Simple Objekt-Mapper (wie mapstruct, aber selbst gebaut). Kopiert Felder zwischen kompatiblen Typen. | `BeanMapper.map(source, targetClass)` implementieren: Felder via Reflection finden, Werte kopieren, Typkonvertierung (int → String etc.). | Abschluss Reflection-Phase. |
| **20** | **JDBC & PostgreSQL** — `DriverManager`, `Connection`, `Statement`, `ResultSet`. PostgreSQL lokal/Docker einrichten. CRUD: INSERT, SELECT, UPDATE, DELETE. | **K1:** PostgreSQL-Container starten, Datenbank anlegen. **K2:** Erste SQL-Query via JDBC. **K3:** CRUD-Operationen für eine Tabelle. | — |
| **21** | **PreparedStatement & DAO Pattern** — SQL-Injection verhindern. `PreparedStatement`, Batch-Updates. DAO (Data Access Object) Pattern: `UserDao`, `findById()`, `findAll()`, `save()`, `delete()`. | **K1:** Statement → PreparedStatement umbauen. **K2:** DAO für eine Entität schreiben. **K3:** DAO testen (mit Test-DB oder Embedded). | — |
| **22** | **Repository Pattern & Transaktionen** — Repository als Abstraktion über DAO. Transaktionen: `commit`, `rollback`, `setAutoCommit(false)`. Savepoints. Connection Pooling (HikariCP). | **K1:** Repository-Interface + JDBC-Implementierung. **K2:** Transaktionsgesteuerte Operationen (Überweisung). **K3:** HikariCP einrichten. | — |
| **23** | **Übung: DAO/Repository Layer** — Todo App mit JDBC-Backend erweitern. `JdbcTaskRepository` implementiert `TaskRepository`. | **K1:** Schema erstellen (CREATE TABLE). **K2:** `JdbcTaskRepository` implementieren. **K3:** Alle Tests mit Test-DB laufen lassen. | Vorhandene Todo App (W15) wird erweitert! |
| **24** | **Übung: DAO/Repository mit Tests** — Validierung, Error Handling, komplexere Queries (JOINs, gruppierte Aggregationen). | **K1:** Data Validation in der Repository-Schicht. **K2:** JOINs über mehrere Tabellen. **K3:** Testabdeckung für Edge Cases. | — |
| **25** | **HTTP & REST** — HTTP-Methoden (GET, POST, PUT, DELETE), Statuscodes (200, 201, 400, 404, 500), Headers, REST-Prinzipien (Resource-orientiert, zustandslos, einheitliches Interface). Java `HttpClient`: `send()`, `BodyHandlers`, `BodyPublishers`. | **K1:** Public API mit HttpClient aufrufen (z. B. JSONPlaceholder). **K2:** Daten parsen und darstellen. **K3:** Eigene Requests bauen. | — |
| **26** | **REST API mit Javalin** — Routing, Handler, Request/Response, JSON-Serialisierung (Jackson/Gson). CRUD-Endpunkte für eine Resource. | **K1:** Javalin-App starten, erster GET-Endpoint. **K2:** POST/PUT/DELETE implementieren. **K3:** Todo App als REST API exposen. | Todo App-REST-API = Todo App (W15) + JDBCTaskRepository (W23) als Backend. |
| **27** | *PLÜ 3* | — | Stoff: Wochen 15–26 (Todo App, Markdown Converter, Reflection, JDBC, REST). |
| **28** | **DTOs, Commands & Validation** — DTOs vs. Domain Models. Command-Pattern für Requests. Validierung (manuell + Annotationen). Error Handling: Fehler-Response-Objekte, Exception Mapper. | **K1:** DTO-Schicht einführen (Request/Response-DTOs). **K2:** Validierung mit eigenen Annotationen. **K3:** `ExceptionHandler` für konsistente Fehlerantworten. | — |
| **29** | **Layered Architecture** — Controller (HTTP) → Service (Business Logic) → Repository (Data Access). Dependency Injection von Hand (Constructor Injection, manuelles Wiring). | **K1:** Todo App in 3 Schichten aufteilen. **K2:** Constructor Injection für lose Kopplung. **K3:** Testbarkeit durch Interfaces pro Schicht. | — |
| **30** | **Dynamic API mit Reflection** — Wie Spring Boot intern funktioniert: Klassen scannen, Annotationen erkennen, Routes automatisch registrieren. Mini-Framework bauen. | **K1:** `@Endpoint`-Annotation definieren. **K2:** Classpath scannen und annotierte Klassen finden. **K3:** Automatisch Routes in Javalin registrieren. | Abschluss Reflection-API-Brückenthema. |
| **31** | **Projekt WMC** | Eigenständiges Projekt. Themenvergabe, Setup, Architektur-Planung. | |
| **32** | **Projekt WMC** | Sprint 2: Implementierung Kernfunktionalität. | |
| **33** | **Projekt WMC** | Sprint 3: Datenhaltung + Tests. | |
| **34** | **Projekt WMC** | Sprint 4: API + Integration. | |
| **35** | **Projekt WMC** | Sprint 5: Feinschliff, Abnahmetests. | |
| **36** | **Projekt WMC** | Sprint 6: Abgabe, Präsentation. | |
| **37** | **Retrospective & Outlook** — Recap: Was haben wir gelernt? Java 8–17 Features, SOLID, TDD, Streams, Reflection, JDBC, REST. Ausblick 4. Klasse: Spring Boot, Dependency Injection, Microservices, Security, fortgeschrittenes Testing. | Feedback-Runde. Jahresrückblick. Vorfreude auf 4. Klasse. | Keine neue Theorie. |

---

## Aufbau einer typischen Woche

| Phase | Dauer | Inhalt |
|-------|-------|--------|
| Theorie | 20 min | Wiederholung letzte Woche + Hausübung besprechen |
| Theorie | 40 min | Neuer Input, Live-Coding |
| Theorie/Praxis | 20 min | Theoretische Übung / Mini-Kata |
| Praxis | 40 min | Katas solo oder im Pair-Programming |
| Praxis | 2 h | Übung vertiefen, Projektarbeit |

Die Aufteilung ist flexibel — Theorie- und Praxisblöcke können je nach Thema getauscht oder gemischt werden.

## Projekt WMC (Wochen 31–36)

6-wöchiges Abschlussprojekt. Die Schüler:innen arbeiten eigenständig an einer vorgegebenen Aufgabenstellung. Betreuung durch wöchentliche Check-ins (Stand-ups), Code Reviews und gezielte Hilfestellung.

## Bewertungsvorschlag

- **PLÜs** (schriftlich, 3×): Prozentanteil nach Schulvorgabe
- **Mini-Projekte** (Todo App, Markdown Converter): 20 %
- **Übungen/Katas** (stichprobenartig eingesammelt oder Vorführung): 15 %
- **Projekt WMC** (Wochen 31–36, Abgabe inkl. Präsentation): 35 %
- **Mitarbeit** (aktiv, Code Reviews, Pair Programming): 10 %
