# Kata 1: CRUD Controller

| Field | Value |
|-------|-------|
| Concepts | @RestController, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @RequestBody |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Create a `Book` record with fields: `Long id`, `String isbn`, `String title`, `String author`, `int publicationYear`

2. Create a `BookRepository` (`@Repository`) that stores books in a `ConcurrentHashMap<Long, Book>` with an atomic ID counter

3. Create a `BookController` (`@RestController`, `@RequestMapping("/api/books")`) with the following endpoints:
   - `GET` — list all books
   - `GET /{id}` — get a single book by ID
   - `POST` — create a new book (accept JSON body)
   - `PUT /{id}` — update an existing book
   - `DELETE /{id}` — delete a book

### Example

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }
}
```

### Extension

Add a `PATCH /{id}` endpoint that only updates the fields present in the request body (partial update). Implement a custom `@ExceptionHandler` for `IllegalArgumentException` that returns a 400 Bad Request.
