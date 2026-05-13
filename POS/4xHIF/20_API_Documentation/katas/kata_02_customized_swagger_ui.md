# Kata 2: Customized Swagger UI

| Field | Value |
|-------|-------|
| Concepts | @OpenAPIDefinition, @Operation, @ApiResponse, tags |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Create a configuration class for the OpenAPI definition:

```java
@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Library Management API",
        version = "1.0.0",
        description = "REST API for managing books, authors, and loans",
        contact = @Contact(
            name = "4xHIF Team",
            email = "team@spengergasse.at"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Development"),
        @Server(url = "https://api.prod.example.com", description = "Production")
    }
)
public class OpenApiConfig {}
```

2. Add `@Operation` and `@ApiResponse` annotations to each endpoint:

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    @Operation(summary = "Get all books",
               description = "Returns a paginated list of all books")
    @ApiResponse(responseCode = "200", description = "List of books")
    public Page<BookDTO> getAll(@PageableDefault(size = 20) Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID")
    @ApiResponse(responseCode = "200", description = "Book found")
    @ApiResponse(responseCode = "404", description = "Book not found")
    public BookDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new book")
    @ApiResponse(responseCode = "201", description = "Book created")
    @ApiResponse(responseCode = "400", description = "Validation error")
    @ApiResponse(responseCode = "409", description = "Duplicate ISBN")
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO dto) {
        // ...
    }
}
```

3. Group endpoints with `@Tag`:

```java
@RestController
@RequestMapping("/api/books")
@Tag(name = "Books", description = "Book management endpoints")
public class BookController { ... }

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors", description = "Author management endpoints")
public class AuthorController { ... }
```

### Extension

Add `@Schema` annotations to your DTOs to document field constraints (e.g., `@Schema(description = "ISBN-13 number", example = "9783161484100", minLength = 13, maxLength = 13)`). Configure `springdoc.swagger-ui.tryItOutEnabled=true` so "Try it out" is enabled by default.
