# Kata 2: HTTP Status Codes

| Field | Value |
|-------|-------|
| Concepts | ResponseEntity, HTTP status codes, error responses |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

1. Refactor the CRUD controller from K1 to return `ResponseEntity` instead of bare domain objects

2. Implement proper HTTP status codes:
   - `GET /api/books` → `200 OK` with body
   - `GET /api/books/{id}` → `200 OK` if found, `404 Not Found` if missing
   - `POST /api/books` → `201 Created` with location header and body
   - `PUT /api/books/{id}` → `200 OK` if updated, `201 Created` if new resource
   - `DELETE /api/books/{id}` → `204 No Content`
   - `POST /api/books` with duplicate ISBN → `409 Conflict`

3. Create a consistent error response DTO:

```json
{
    "timestamp": "2025-03-10T14:30:00",
    "status": 404,
    "error": "Not Found",
    "message": "Book with id 42 not found",
    "path": "/api/books/42"
}
```

### Example

```java
@PostMapping
public ResponseEntity<Book> create(@RequestBody Book book) {
    // Check for duplicate ISBN
    if (repository.existsByIsbn(book.isbn())) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    Book saved = repository.save(book);
    URI location = URI.create("/api/books/" + saved.id());
    return ResponseEntity.created(location).body(saved);
}
```

### Extension

Add a `@ControllerAdvice` that catches `ResponseStatusException` and `MethodArgumentNotValidException` globally, returning consistent error responses in the format shown above.
