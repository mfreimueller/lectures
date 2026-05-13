# POS-WMC Project - Week 31: Testing, Validation, Error Handling

## Task

Write comprehensive tests for your project and implement robust validation and error handling.

### Requirements

1. Write unit tests for all service classes using Mockito (at least 10 test methods)
2. Write repository tests using an in-memory database (H2)
3. Write integration tests for REST endpoints (at least 5 test methods)
4. Write parameterized tests for validation logic (at least 3 parameterized test methods)
5. Implement JaCoCo for test coverage measurement
6. Achieve at least 70% line coverage
7. Implement consistent error handling with Javalin exception handlers
8. Ensure all error responses follow a consistent format

### Example Output

```java
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock BookRepository bookRepo;
    @InjectMocks BookService bookService;

    @Test
    void shouldThrowNotFoundWhenBookMissing() {
        when(bookRepo.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> bookService.findById(99L))
            .isInstanceOf(NotFoundResponse.class);
    }
}
```

### Extension

Add a CI pipeline (GitHub Actions) that runs tests and generates coverage reports on every push.
