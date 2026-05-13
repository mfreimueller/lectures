# Kata 3: REST Docs

| Field | Value |
|-------|-------|
| Concepts | Spring REST Docs, Asciidoctor, API-Guard |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add Spring REST Docs dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.springframework.restdocs</groupId>
    <artifactId>spring-restdocs-mockmvc</artifactId>
    <scope>test</scope>
</dependency>
```

2. Write a REST Docs test:

```java
@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
class BookControllerDocumentationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getAllBooks() throws Exception {
        when(bookService.getAll(any(Pageable.class)))
            .thenReturn(new PageImpl<>(List.of(
                new BookDTO(1L, "9783161484100", "Clean Code",
                    "Robert C. Martin", 2008)
            )));

        mockMvc.perform(get("/api/books")
                .param("page", "0")
                .param("size", "10"))
            .andExpect(status().isOk())
            .andDo(document("books/get-all",
                queryParameters(
                    parameterWithName("page").description("Page number"),
                    parameterWithName("size").description("Page size")
                ),
                responseFields(
                    fieldWithPath("content[]").description("List of books"),
                    fieldWithPath("totalElements").description("Total count"),
                    fieldWithPath("totalPages").description("Total pages")
                )
            ));
    }
}
```

3. Add the Asciidoctor plugin to `pom.xml` and generate the HTML documentation:

```xml
<plugin>
    <groupId>org.asciidoctor</groupId>
    <artifactId>asciidoctor-maven-plugin</artifactId>
    <executions>
        <execution>
            <id>generate-docs</id>
            <goals><goal>process-asciidoc</goal></goals>
        </execution>
    </executions>
</plugin>
```

4. Create `src/docs/asciidoc/index.adoc`:

```asciidoc
= Library Management API Documentation

== Getting Started

This is the API documentation generated with Spring REST Docs.

== Book Endpoints

=== Get All Books
++++
include::{snippets}/books/get-all/http-request.adoc[]
++++

Response:
++++
include::{snippets}/books/get-all/response-body.adoc[]
++++
```

5. Run the tests and build the documentation: `mvn verify`

### Extension

Compare the documentation quality and maintenance effort between Swagger UI and REST Docs. Which approach is better for: a) a public API, b) an internal API, c) a microservice? Document your analysis in a short markdown file.
