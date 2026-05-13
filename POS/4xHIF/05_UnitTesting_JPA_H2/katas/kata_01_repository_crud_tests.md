# Kata 1: Repository CRUD Tests

| Field | Value |
|-------|-------|
| Concepts | @DataJpaTest, save, findById, findAll, delete |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a JUnit 5 test class for `BookRepository`:

1. Annotate with `@DataJpaTest`
2. Inject `BookRepository` and `TestEntityManager`
3. In `@BeforeEach`, create 3 test books with different titles and years
4. Test methods:
   - `saveAndFindById()` — save a book, verify it has an ID, find it by ID
   - `findAll()` — save 3 books, verify findAll returns 3
   - `updateBook()` — save a book, change title, save again, verify update
   - `deleteBook()` — save a book, delete it, verify it's gone

### Example

```java
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private TestEntityManager entityManager;

    private Book book1, book2, book3;

    @BeforeEach
    void setUp() {
        book1 = bookRepo.save(new Book("123-4", "Java Basics", 2020));
        book2 = bookRepo.save(new Book("567-8", "Spring Boot", 2022));
        book3 = bookRepo.save(new Book("901-2", "JPA Deep Dive", 2023));
    }

    @Test
    void findAll_shouldReturnAllBooks() {
        assertThat(bookRepo.findAll()).hasSize(3);
    }
}
```

### Extension

Add a test for `existsById()` and `count()`.
