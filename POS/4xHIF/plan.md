# Jahresplan 4xHIF — Programmieren und Software Entwicklung

**Roter Faden:** Vom Domain Model zur Enterprise Application — Studierende entwickeln über das gesamte Schuljahr hinweg in 2-3er Teams eine eigenständige Spring Boot Enterprise-Anwendung. Jede Woche erweitert das Projekt um eine neue Schicht oder ein neues Architekturkonzept.

**Gruppenprojekt:** Selbstgewählte Domäne (z.B. Bibliotheksverwaltung, Fitnessstudio, Restaurant-Reservierung, Hotelbuchung). Ergebnis: Voll funktionsfähige Spring Boot-Anwendung mit REST-API, Thymeleaf-Frontend, Datenbank, Security und CI/CD.

**Format pro Woche:** 2h Theorie + 2h Praxis (flexibel mischbar).

**Sprache:** Java 17+, Spring Boot 3.x.

**Unterrichtssprache:** Deutsch.

---

| Wo. | Theorie (2h) | Katas | Gruppenprojekt |
|-----|-------------|-------|----------------|
| **1** | **Einführung & Spring Boot Setup** — Jahresplanung, Übergang Javalin → Spring Boot, Spring Initializr, Projektstruktur, Maven/Gradle, DevTools. | **K1:** Spring Boot-Projekt erstellen. **K2:** Erster REST-Endpoint (GET /hello). **K3:** GitHub Classroom einrichten, Team-Repo forken. | Gruppen finden. Domain-Ideen sammeln. Repo aufsetzen. |
| **2** | **UML & DDD Intro** — UML-Klassendiagramme (Wiederholung), Assoziationen, Aggregation, Komposition. DDD: Ubiquitous Language, Bounded Context, Entities vs. ValueObjects. | **K1:** UML-Diagramm einer gegebenen Domäne zeichnen. **K2:** DDD-Event-Storming für eine Beispiel-Domäne (Library). | Domain-Brainstorming. Erste UML-Skizze der eigenen Domäne. |
| **3** | **PlantUML, ValueObjects, RichTypes** — PlantUML-Syntax, ValueObjects (immutable, self-validating), RichTypes (Wrapper statt primitiver Typen). | **K1:** PlantUML aus Java-Code generieren. **K2:** ValueObject `Email` implementieren (equals/hashCode, Validation). **K3:** RichType `Kontonummer` oder `Personalnummer`. | Domain-Modell als PlantUML zeichnen. ValueObjects identifizieren. |
| **4** | **Milestone 1: Domain Model & Projekt-Setup** — keine neue Theorie, ganzer Block für Präsentationen. | — | **Präsentation (5-10 min/Team):** Domain-Modell vorstellen. Feedback von Klasse + Lehrer. Spring Boot + JPA-Dependencies einrichten. |
| **5** | **JPA Repositories** — Spring Data JPA: `@Entity`, `@Id`, `@GeneratedValue`, `Repository<T,ID>`, CRUD-Methoden, `@OneToMany`/`@ManyToOne`, Cascade-Types, Fetch-Strategien. | **K1:** Entity + Repository anlegen. **K2:** CRUD über Repository. **K3:** Beziehungen + Cascades. | Domain-Modell als JPA-Entities umsetzen. Repositories anlegen. |
| **6** | **Unit Testing für JPA mit H2** — `@DataJpaTest`, H2 Embedded-DB, `@BeforeEach`, Custom Queries testen, Beziehungen testen. | **K1:** Repository-Tests mit H2. **K2:** Beziehungen testen. **K3:** Custom `@Query` testen. | Tests für alle Repositories schreiben. |
| **7** | **Code Review (JPA-Mapping & Tests)** — Code-Review-Kriterien: N+1-Queries vermeiden, sinnvolle Cascade-Types, Testabdeckung. Peer Review mit Checkliste. | Peer Review: Jedes Team reviewed ein anderes Team. Issues dokumentieren. | Fixes aus Code Review einspielen. |
| **8** | *Herbstferien* |||
| **9** | **Spring Boot Configuration & Profiles** — `application.yml`, `@ConfigurationProperties`, `@Profile`, `@Value`, Umgebungs-spezifische Konfiguration (dev/test/prod). | **K1:** Config-Klasse mit `@ConfigurationProperties`. **K2:** Profile für dev/test/prod. **K3:** Externalisiertes Config-File. | dev-Profil + H2, test-Profil + Testcontainers-Konfiguration vorbereiten. |
| **10** | **Testcontainers for PostgreSQL** — `@Testcontainers`, PostgreSQL-Container, `@DynamicPropertySource`, `TestConfiguration`, warum H2 nicht ausreicht. | **K1:** PostgreSQL-Container im Test starten. **K2:** Tests von H2 auf Testcontainers umstellen. **K3:** Connection-Pool testen. | Repository-Tests auf Testcontainers umstellen. |
| **11** | **Database Migration mit Flyway** — Warum Migrationen?, Flyway-Integration, `V*__*.sql`, Migrations-Strategien, Undo/Repair. | **K1:** Erste Migration (Schema erstellen). **K2:** Zweite Migration (Tabelle erweitern). **K3:** Migrations-Konflikt auflösen. | Initiale Flyway-Migration für eigenes Projekt-Schema. |
| **12** | **Service-Layer Intro** — `@Service`, Geschäftslogik von Persistenz trennen, `@Transactional`, Command-Objekt-Pattern vs. einfache Parameter. | **K1:** Service-Klasse mit CRUD-Delegation. **K2:** Command-Objekt als Parameter. **K3:** `@Transactional` für zusammengesetzte Operationen. | Service-Layer für eigene Domäne implementieren. |
| **13** | **Service-Layer Testing via Mocking** — `@ExtendWith(MockitoExtension.class)`, `@Mock`, `@InjectMocks`, `verify()`, `ArgumentCaptor`, Behavior-Tests vs. State-Tests. | **K1:** Service mit gemocktem Repository testen. **K2:** Verhalten verifizieren (verify). **K3:** Exception-Szenarien testen. | Service-Tests mit Mockito schreiben. |
| **14** | **Exception Handling & Validation** — `@ControllerAdvice`, `@ExceptionHandler`, `@Valid`/`@Validated`, Bean-Validation (`@NotNull`, `@Size`, `@Pattern`), Custom-Validator, `ProblemDetail` (RFC 7807). | **K1:** Globaler Exception-Handler. **K2:** Entity-Validierung (`@Valid`). **K3:** Custom-Validator (z. B. `@EmailDomain`). | Validierung + Exception-Handling im Service testen (ohne REST-Controller). |
| **15** | **Logging + SA1 Vorbereitung** — SLF4J/Logback, Log-Levels (TRACE–ERROR), Logger-Konfiguration, strukturiertes Logging. | **K1:** Logger in Service-Klasse. **K2:** Log-Level-Konfiguration pro Profile. **K3:** Log-Auswertung (grep, Pattern). | Projekt-Code sichten, offene Punkte klären. SA1-Vorbereitung. |
| **16** | **SA 1** — Domain Layer, Persistence Layer, Unit Testing |||
| **17** | *Weihnachtsferien* |||
| **18** | **REST Controllers in Spring** — `@RestController`, `@GetMapping`/`@PostMapping`/etc., Request/Response-Handling, HTTP-Statuscodes, JSON-Serialisierung (Jackson). | **K1:** CRUD-Controller für eine Entity. **K2:** Korrekte Statuscodes (201, 404, 409). **K3:** Request-Parameter + Pfadvariablen validieren. | REST-Controller für eigene Domäne bauen (Service + Controller). |
| **19** | **Mappers mit MapStruct** — DTOs vs. Entities, `@Mapper`, Mapping von Beziehungen, Custom-Mappings, `@Mapping(target = "...", source = "...")`. | **K1:** Einfacher DTO-Mapper. **K2:** Mapping mit Beziehungen (flatten). **K3:** Custom-Mapping (z. B. LocalDateTime → String). | DTO-Schicht + MapStruct-Mapper im Projekt. |
| **20** | **HATEOAS** — HATEOAS-Prinzip (Hypertext as Engine of Application State), Spring HATEOAS: `EntityModel`, `CollectionModel`, `WebMvcLinkBuilder`, Links. | **K1:** Self-Links zu Einzel-Resource. **K2:** Collection-Links + Paging-Links. **K3:** Vollständig navigierbare API (Root → Ressource → Sub-Resource). | HATEOAS-Links zu REST-APIs hinzufügen. |
| **21** | **RestClient & Load Balancing** — `RestClient`, Client-Side Load Balancing, Round-Robin, Service-Discovery-Konzepte. | **K1:** RestClient für externe API (JSONPlaceholder). **K2:** Fehlerbehandlung (`onStatus`). **K3:** Load-Balancing-Simulation (mehrere Instanzen). | Externe API ins Projekt integrieren (z. B. Wetter, Geo, Postleitzahl) oder Client-Komponente bauen. |
| **22** | *Semesterferien* |||
| **23** | **Controllers Paging & Sorting** — `Pageable`, `Page<T>`, `Sort`, `@PageableDefault`, `Sort.by()`, Pagination im Service + Controller. | **K1:** Paging-Endpoint. **K2:** Sortierung + Filter. **K3:** Custom-Page-DTO. | Paging + Sorting für Listen-Endpoints im eigenen Projekt. |
| **24** | **GraphQL (via Katas) + Projektarbeit** — 30-min Überblick: GraphQL vs. REST, Schema, Queries, Mutations. | **K1:** GraphQL-Schema definieren. **K2:** Query-Resolver. **K3:** Mutation + Validation. | Projektarbeit: Fehlende REST-Endpoints fertigstellen. Paging/HATEOAS integrieren. |
| **25** | **API Documentation** — OpenAPI/Swagger (springdoc-openapi), Swagger-UI anpassen, Spring REST Docs, API-First-Ansatz. | **K1:** springdoc-openapi integrieren. **K2:** Swagger-UI mit Custom-Info. **K3:** REST Docs + API-Guard. | API-Dokumentation für eigene REST-API generieren. |
| **26** | **Testing REST APIs + Code Review** — `@WebMvcTest`, MockMvc, `@MockBean`, JSON-Path-Assertions, Integrationstests vs. Slice-Tests. | **K1:** Controller-Test mit MockMvc. **K2:** Exception-Handling testen. **K3:** Vollständiger Integrationstest (`@SpringBootTest`). | **Code Review (Peer Review):** REST-APIs + Tests reviewen. Issues dokumentieren. |
| **27** | **Thymeleaf WebUI** — Thymeleaf-Templating, `th:each`, `th:if`, `th:object`, Form-Binding, Fragment-Layouts, CSS/JS-Einbindung. | **K1:** Thymeleaf-Template mit Daten. **K2:** CRUD-Formular. **K3:** Layout mit Fragments + Navigation. | Thymeleaf-UI für eigene Domäne bauen. |
| **28** | **Milestone 2: Zwischenpräsentation (Projektstand)** — keine neue Theorie. | — | **Präsentation (10-15 min/Team):** Domain, REST-APIs, Thymeleaf-UI, Architektur, Lessons Learned. |
| **29** | *Osterferien* |||
| **30** | **Spring Boot Actuator & Metrics** — Actuator-Endpoints, Health-Indicators, Metrics (Micrometer), Custom-Health-Check, Info-Endpoint. | **K1:** Actuator aktivieren + Endpoints konfigurieren. **K2:** Custom-Health-Indicator (Datenbank + externe API). **K3:** Metrics erfassen + Prometheus-Endpoint. | Actuator + Health-Checks im Projekt. |
| **31** | **Containerization mit Docker** — Dockerfile für Spring Boot, Multi-Stage-Build, `.dockerignore`, docker-compose (App + PostgreSQL), Umgebungsvariablen. | **K1:** Dockerfile schreiben. **K2:** docker-compose.yml (App + DB). **K3:** Docker-Compose mit Profilen. | Projekt containerisieren. docker-compose für dev-Umgebung. |
| **32** | **Spring Security** — Security-Filter-Chain, Authentication/Authorization, In-Memory-User, `@PreAuthorize`, CSRF, Login-Formular mit Thymeleaf. | **K1:** Basic Auth + In-Memory-User. **K2:** Rollen-basierter Zugriff (`@PreAuthorize`). **K3:** Custom Login-Seite mit Thymeleaf. | Security-Layer im Projekt: Login + Rollenkonzept. |
| **33** | **CI/CD Grundlagen** — GitHub Actions, Build/Test/Deploy-Stages, Secrets-Management, Docker-Build + Push. | **K1:** GitHub Actions-Workflow (Build + Test). **K2:** Test-Report + Coverage. **K3:** Docker-Build + Image-Push. | CI/CD-Pipeline für eigenes Projekt. |
| **34** | **Caching & AOP** — `@Cacheable`, `@CacheEvict`, `@CachePut`, Cache-Strategien. AOP: `@Aspect`, `@Around`, Cross-Cutting-Concerns (Logging, Performance). | **K1:** `@Cacheable` für leseintensive Methode. **K2:** `@CacheEvict` bei Update/Delete. **K3:** Custom Aspect für Methoden-Logging. | Caching für leseintensive Endpoints. AOP für Logging/Monitoring. |
| **35** | **SA 2** — SA1-Inhalt + Services + REST APIs |||
| **36** | **Advanced Topics (Katas) + Projektarbeit** — Kata-Katalog: (1) File Upload/Download, (2) `@Async` Tasks, (3) `@Scheduled` Jobs, (4) E-Mail Versand, (5) WebSockets, (6) i18n, (7) RestAssured, (8) Logging Deep-Dive. | Jede Gruppe wählt 2-3 Topics und implementiert sie. Selbstorganisierte Arbeit. | Integration der gewählten Advanced Topics ins Projekt. |
| **37** | **Advanced Topics (Katas) + Projektarbeit** | Fortsetzung Advanced Topics. | Bugfixing, Refactoring, Feinschliff. |
| **38** | **Code Review (final)** — Review-Checkliste: Code-Qualität, Architektur, Testabdeckung, Security, Dokumentation. | Peer Review + Selbstreflexion. | Letzte Issues beheben. Projekt für Abgabe vorbereiten. |
| **39** | **Retrospective & Ausblick 5. Klasse** — Recap Jahresstoff. Ausblick: Microservices, Spring Cloud, Kubernetes, Advanced Security (OAuth2, JWT), WebFlux. | Mind-Map des Jahresstoffs. Feedback-Runde. | Abgabevorbereitung. |
| **40** | **Final Presentations** | — | **Präsentation (15 min + 5 min Fragen):** Voll funktionsfähige Spring-Anwendung live demonstrieren. Architektur, Herausforderungen, Lessons Learned. |
| **41** | **Reserve / Buffer** | Nach Bedarf: Präsentationen nachholen, Zeugnisgespräche. | |

---

## Aufbau einer typischen Woche

| Phase | Dauer | Inhalt |
|-------|-------|--------|
| Theorie | 20 min | Wiederholung letzte Woche, Hausübung besprechen, offene Fragen |
| Theorie | 40 min | Neuer Input, Live-Coding, Architektur-Diskussion |
| Theorie/Praxis | 20 min | Mini-Kata / Architektur-Übung / Debugging-Demo |
| Praxis | 40 min | Katas in Gruppenarbeit oder geführte Übung |
| Praxis | 2 h | Projektarbeit — Gruppenprojekt um neue Konzepte erweitern |

Die Aufteilung ist flexibel — Theorie- und Praxisblöcke können je nach Thema getauscht oder gemischt werden.

## Meilensteine (bewertet)

| Woche | Typ | Beschreibung |
|-------|-----|-------------|
| 4 | Präsentation | Domain Model & Projekt-Setup |
| 7 | Code Review | JPA-Mapping & Repository-Tests |
| 26 | Code Review | REST-APIs & Tests |
| 28 | Präsentation | Zwischenpräsentation (Projektstand vor Ostern) |
| 38 | Code Review | Finale Qualitätskontrolle |
| 40 | Präsentation | Finale Projektpräsentation |

## Advanced Topics Kata-Katalog (Wochen 36–37)

Jedes Team wählt 2-3 Topics und implementiert sie eigenständig:

1. **File Upload/Download** — `MultipartFile`, `Resource`, Datei-Speicherung, Download-Endpoint
2. **@Async Tasks** — Asynchrone Methodenausführung, `AsyncConfigurer`, Future-Rückgabewerte
3. **@Scheduled Jobs** — Cron-Jobs, Scheduled Tasks, Reporting/Aufräum-Jobs
4. **E-Mail Versand** — JavaMailSender, E-Mail-Templates mit Thymeleaf
5. **WebSockets** — STOMP, WebSocket-Controller, Live-Updates im Frontend
6. **Internationalisierung (i18n)** — MessageSources, Locale-Resolver, i18n in Thymeleaf
7. **Advanced Testing** — RestAssured, WireMock, Contract-Testing
8. **Logging Deep-Dive** — Logback-Konfiguration, Appender, MDC, Logstash
