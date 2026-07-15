---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 32 - Projekt WMC Testing
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: JUnit 5 Basics
2. Review: TDD Principles
3. Unit Testing with Mockito
4. Repository Testing
5. Integration Testing REST Endpoints

---

## Agenda (2/2)

6. Test Utility: Start/Stop Tomcat
7. Parameterized Tests
8. Validation Testing
9. Test Coverage with JaCoCo

---

## Learning Objectives

- I can write unit tests for services using Mockito mocks and @InjectMocks
- I can write integration tests that start embedded Tomcat and send HTTP requests
- I can write parameterized tests with @CsvSource for validation scenarios
- I can measure test coverage with JaCoCo and interpret the results

---

## Review: JUnit 5 Basics

```java
@Test
void shouldReturnBookWhenFound() {
    var result = bookService.findById(1L);
    assertThat(result).isPresent();
    assertThat(result.get().getTitle()).isEqualTo("The Hobbit");
}
```

---

## Review: TDD Principles

- Red: write a failing test first
- Green: write minimal code to pass
- Refactor: improve code while keeping tests green
- FIRST: Fast, Isolated, Repeatable, Self-validating, Timely

---

## Unit Testing with Mockito

```java
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepo;
    @InjectMocks
    private BookService bookService;

    @Test
    void shouldCreateBook() {
        var dto = new CreateBookDto("Dune", "...", 1965, 1L);
        when(bookRepo.save(any())).thenAnswer(i -> i.getArgument(0));
        var result = bookService.create(dto);
        assertThat(result.getTitle()).isEqualTo("Dune");
    }
}
```

---

## Now Kata 1: Mockito Test

Write JUnit 5 tests for BookService using Mockito mocks for BookRepository.

---

## Repository Testing

```java
@Test
void shouldSaveAndFindBook() {
    var category = new Category("Fiction");
    var book = new PhysicalBook("Dune", "...", 1965, category, "A1", 3);
    bookRepo.save(book);
    var found = bookRepo.findById(book.getId());
}
```

<div class="highlight-box"><p>Use an in-memory H2 database for repository tests.</p></div>

---

## Integration Testing REST Endpoints

```java
@Test
void shouldCreateBookViaApi() throws Exception {
    var tomcat = new Tomcat();
    tomcat.setPort(0);
    var ctx = tomcat.addContext("", "/");
    Tomcat.addServlet(ctx, "api",
        new FrontControllerServlet(routes));
    ctx.addServletMappingDecoded("/api/*", "api");
    tomcat.start();
    var port = ctx.getConnector().getLocalPort();

    var request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:" + port + "/api/books"))
        .POST(BodyPublishers.ofString("{\"title\":\"Dune\"}"))
        .build();
    var response = HttpClient.newHttpClient()
        .send(request, BodyHandlers.ofString());
    assertThat(response.statusCode()).isEqualTo(201);
    tomcat.stop();
}
```

---

## Now Kata 2: REST Endpoint Test

Write an integration test that starts embedded Tomcat, sends HTTP requests, and asserts responses.

---

## Test Utility: Start/Stop Tomcat

```java
private Tomcat tomcat;
private int port;

@BeforeEach
void setup() throws Exception {
    tomcat = new Tomcat();
    tomcat.setPort(0);
    tomcat.getConnector();
    var ctx = tomcat.addContext("", "/");
    Tomcat.addServlet(ctx, "api",
        new FrontControllerServlet(routes));
    ctx.addServletMappingDecoded("/api/*", "api");
    tomcat.start();
    port = ctx.getConnector().getLocalPort();
}

@AfterEach
void teardown() throws Exception {
    tomcat.stop();
}
```

---

## Parameterized Tests

```java
@ParameterizedTest
@CsvSource({
    ", false",
    "'', false",
    "Dune, true"
})
void shouldValidateTitle(String title, boolean expected) {
    var validator = new BookValidator();
    assertThat(validator.isValidTitle(title)).isEqualTo(expected);
}
```

---

## Now Kata 3: Validation Test

Write parameterized JUnit 5 tests for a BookValidator utility using @CsvSource.

---

## Validation Testing

```java
@Test
void shouldRejectInvalidBook() {
    var dto = new CreateBookDto("", "123", 1800, null);
    var errors = BookValidator.validate(dto);
    assertThat(errors)
        .contains("title must not be blank")
        .contains("isbn must be 13 digits");
}
```

---

## Test Coverage with JaCoCo

```xml
    org.jacoco
    jacoco-maven-plugin
    0.8.11
```

<div class="highlight-box"><p>Goal: at least 70% line coverage.</p></div>

---

## Reflection: Is 70% Coverage Enough?

<div class="highlight-box">
<p>Is 70% line coverage a good target? Does high coverage guarantee good tests? What matters more: coverage percentage or test quality?</p>
</div>

---

## Summary

<div class="highlight-box">
<ul>
<li>Unit test services with Mockito</li>
<li>Test repositories with in-memory database</li>
<li>Integration test REST endpoints</li>
<li>Parameterized tests for validation</li>
<li>JaCoCo for coverage measurement</li>
</ul>
</div>
