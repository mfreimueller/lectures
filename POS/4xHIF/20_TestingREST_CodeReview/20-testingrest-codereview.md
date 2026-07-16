---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 20 - Testing REST AP Is & Code Review
## POS - 4xHIF

---

## Testing-Strategien

- **Unit-Tests** — Service-Layer (mit Mockito)
- **Slice-Tests** — Nur ein Teil (z.B. Controller mit @WebMvcTest)
- **Integrationstests** — Ganze Applikation (@SpringBootTest)

Für REST APIs: @WebMvcTest + @SpringBootTest kombinieren

---

## @WebMvcTest — Controller Slice

```java
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getAllBooks_shouldReturn200() throws Exception {
        when(bookService.getAll(any(Pageable.class)))
            .thenReturn(new PageImpl<>(List.of()));

        mockMvc.perform(get("/api/books"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").isArray());
    }
}
```

Nur der Controller wird geladen — Services werden gemockt.

---

## JSON-Path Assertions

```java
mockMvc.perform(get("/api/books/1"))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.id").value(1))
    .andExpect(jsonPath("$.title").value("Clean Code"))
    .andExpect(jsonPath("$.author").isString())
    .andExpect(jsonPath("$.author").value("Robert C. Martin"))
    .andExpect(jsonPath("$.publicationYear").value(2008));

mockMvc.perform(get("/api/books"))
    .andExpect(jsonPath("$.content").isArray())
    .andExpect(jsonPath("$.content.length()").value(3))
    .andExpect(jsonPath("$.content[0].title").value("Clean Code"))
    .andExpect(jsonPath("$.totalElements").value(42));
```

---

## @SpringBootTest — Integrationstest

```java
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void createAndRetrieveBook() {
        var newBook = new BookDTO(null, "9783161484100",
            "Clean Code", "Robert C. Martin", 2008);

        var created = restTemplate.postForEntity(
            "/api/books", newBook, BookDTO.class);

        assertThat(created.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(created.getBody().id()).isNotNull();

        var retrieved = restTemplate.getForEntity(
            "/api/books/" + created.getBody().id(), BookDTO.class);
        assertThat(retrieved.getBody().title()).isEqualTo("Clean Code");
    }
}
```

---

## Code Review — REST-APIs

<div class="highlight-box">
<ul>
<li>Sind alle Statuscodes korrekt? (201, 404, 409)</li>
<li>Sind Fehlerantworten konsistent?</li>
<li>Gibt es HATEOAS-Links?</li>
<li>Ist Pagination implementiert?</li>
<li>Sind DTOs von Entities getrennt?</li>
</ul>
</div>

---

## Code Review — Tests

<div class="highlight-box">
<ul>
<li>Gibt es Controller-Tests mit MockMvc?</li>
<li>Werden Edge Cases getestet? (404, 400, 409)</li>
<li>Gibt es Integrationstests?</li>
</ul>
</div>

---

## Peer Review Ablauf

1. Teams tauschen Repository-Links
2. Jedes Team reviewed das Projekt eines anderen Teams (30 min)
3. Issues als GitHub-Issues dokumentieren oder in einer Tabelle festhalten
4. Besprechung: Jedes Team gibt kurzes Feedback (5 min/Team)
5. Fixes aus dem Code Review in der nächsten Projektarbeit einspielen
