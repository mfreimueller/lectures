# Kata 1: Entity Mapping

| Field | Value |
|-------|-------|
| Concepts | @Entity, @Id, @GeneratedValue, CrudRepository |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a `Book` entity with the following fields:
   - `Long id` — auto-generated primary key
   - `String isbn` — unique, not null
   - `String title` — not null
   - `int year` — publication year
2. Create a `BookRepository` interface extending `CrudRepository<Book, Long>`
3. Write a simple command-line test (or use `@SpringBootTest`) to:
   - Save 3 books
   - Find all books
   - Find a book by ID
   - Delete a book

### Example

```java
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    private int year;
    // getters/setters or keep package-private w/ Lombok
}
```

### Extension

Add a `@PrePersist` method that sets a `createdAt` timestamp automatically before saving.
