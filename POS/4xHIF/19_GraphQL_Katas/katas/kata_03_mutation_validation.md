# Kata 3: Mutation + Validation

| Field | Value |
|-------|-------|
| Concepts | @MutationMapping, @Validated, input types |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add mutation resolvers to the BookController:

```java
@Controller
public class BookController {

    @MutationMapping
    public BookDTO createBook(@Argument BookInput input) {
        return bookService.create(input);
    }

    @MutationMapping
    public BookDTO updateBook(
            @Argument Long id, @Argument BookInput input) {
        return bookService.update(id, input);
    }

    @MutationMapping
    public boolean deleteBook(@Argument Long id) {
        bookService.delete(id);
        return true;
    }
}
```

2. Create a `BookInput` record matching the schema input type:

```java
public record BookInput(
    @NotBlank String isbn,
    @NotBlank String title,
    @NotNull Long authorId,
    @Min(1900) @Max(2025) int publicationYear
) {}
```

3. Add validation to mutations — throw `GraphQLError` on validation failure:

```java
@MutationMapping
public BookDTO createBook(@Valid @Argument BookInput input) {
    if (bookService.existsByIsbn(input.isbn())) {
        throw new BookAlreadyExistsException(input.isbn());
    }
    return bookService.create(input);
}
```

4. Implement a custom `GraphQLErrorHandler`:

```java
@ControllerAdvice
public class GraphQlExceptionHandler
        extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(
            Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof BookAlreadyExistsException) {
            return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .errorType(ErrorType.BAD_REQUEST)
                .build();
        }
        if (ex instanceof jakarta.validation.ConstraintViolationException) {
            return GraphqlErrorBuilder.newError(env)
                .message("Validation failed")
                .errorType(ErrorType.BAD_REQUEST)
                .build();
        }
        return null; // fall through to default
    }
}
```

5. Test in GraphiQL:

```graphql
mutation {
    createBook(input: {
        isbn: "9783161484100",
        title: "Clean Code",
        authorId: 1,
        publicationYear: 2008
    }) {
        id
        title
        author { name }
    }
}
```

### Extension

Add a `partialUpdateBook` mutation that only updates the fields present in the input (nullable fields = don't change). Add an `addRating` mutation that validates rating between 1-5.
