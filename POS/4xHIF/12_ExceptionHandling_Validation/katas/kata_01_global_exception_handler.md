# Kata 1: Global Exception Handler

| Field | Value |
|-------|-------|
| Concepts | @ControllerAdvice, @ExceptionHandler, ProblemDetail, HTTP status codes |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create a `GlobalExceptionHandler`:

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail handleNotFound(EntityNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(404, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleBadRequest(IllegalArgumentException ex) {
        return ProblemDetail.forStatusAndDetail(400, ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleConflict(DataIntegrityViolationException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(409);
        problem.setTitle("Data integrity violation");
        problem.setDetail("This operation violates a database constraint");
        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {
        // Collect all field errors and return as ProblemDetail
    }
}
```

Write a test using `MockMvc`:

```java
@WebMvcTest(SomeController.class)
class ExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNonExistentMember_shouldReturn404() throws Exception {
        mockMvc.perform(get("/api/members/99"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.title").value("Entity not found"));
    }
}
```

### Extension

Add a handler for `HttpMessageNotReadableException` (malformed JSON body) that returns 400 with a clear error message.
