# Kata 1: Mockito Test

| Field | Value |
|-------|-------|
| Concepts | Mockito, unit testing, mocking |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a JUnit 5 test for `BookService` using Mockito:
1. Mock the `BookRepository`
2. Test `findById` when the book exists (return Optional.of)
3. Test `findById` when the book does not exist (return Optional.empty())
4. Test `create` method
5. Verify that repository methods are called correctly

### Example Output

```java
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock BookRepository bookRepo;
    @InjectMocks BookService bookService;

    @Test
    void shouldFindBookById() {
        when(bookRepo.findById(1L)).thenReturn(Optional.of(new Book("Dune")));
        var result = bookService.findById(1L);
        assertThat(result.getTitle()).isEqualTo("Dune");
    }
}
```

### Extension

Add a test that expects an exception when the book is not found.
