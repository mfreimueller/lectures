# Kata 3: Navigable API

| Field | Value |
|-------|-------|
| Concepts | API root, resource discovery, sub-resources |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a root endpoint `GET /api` that returns links to all top-level resources:

```java
@RestController
@RequestMapping("/api")
public class ApiRootController {

    @GetMapping
    public CollectionModel<Void> root() {
        return CollectionModel.of(List.of(),
            linkTo(methodOn(ApiRootController.class).root()).withSelfRel(),
            linkTo(methodOn(BookController.class).getAll()).withRel("books"),
            linkTo(methodOn(AuthorController.class).getAll()).withRel("authors")
        );
    }
}
```

2. Add sub-resource links to individual resources. For example, when fetching a book, include links to:
   - Reviews of this book: `/api/books/{id}/reviews`
   - Author of this book: `/api/books/{id}/author`
   - Loan history: `/api/books/{id}/loans`

3. Create a `ReviewController` and wire up the sub-resource links properly

4. Verify the API is fully navigable — a client should be able to start at `/api` and discover every endpoint by following links (no hardcoded URIs needed):

```
/api
├── books → /api/books
│   ├── {id} → /api/books/1
│   │   ├── reviews → /api/books/1/reviews
│   │   ├── author → /api/books/1/author
│   │   └── self
│   └── self
├── authors → /api/authors
│   └── {id} → /api/authors/1
└── self
```

### Example Root Response

```json
{
    "_links": {
        "self": { "href": "http://localhost:8080/api" },
        "books": { "href": "http://localhost:8080/api/books" },
        "authors": { "href": "http://localhost:8080/api/authors" },
        "loans": { "href": "http://localhost:8080/api/loans" }
    }
}
```

### Extension

Add a Swagger/OpenAPI link to the root response pointing to the API documentation. Add a `profile` link (RFC 6906) that points to a description of the API's media type.
