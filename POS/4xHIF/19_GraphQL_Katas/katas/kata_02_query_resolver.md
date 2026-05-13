# Kata 2: Query Resolver

| Field | Value |
|-------|-------|
| Concepts | @QueryMapping, @SchemaMapping, DataLoader |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create a `BookController` as a GraphQL query resolver:

```java
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<BookDTO> books() {
        return bookService.getAll();
    }

    @QueryMapping
    public BookDTO bookById(@Argument Long id) {
        return bookService.getById(id);
    }

    @QueryMapping
    public List<BookDTO> booksByAuthor(@Argument String authorName) {
        return bookService.searchByAuthor(authorName);
    }
}
```

2. Create an `AuthorController` with a `@SchemaMapping` to resolve the author field on Book:

```java
@Controller
public class AuthorController {

    private final AuthorService authorService;

    @SchemaMapping(typeName = "Book", field = "author")
    public AuthorDTO getAuthor(BookDTO book) {
        return authorService.getById(book.authorId());
    }
}
```

3. Start the app and open GraphiQL at `http://localhost:8080/graphiql`

4. Test the following query:

```graphql
query {
    books {
        id
        title
        author {
            name
        }
        publicationYear
    }
}
```

### Extension

Add a `@SchemaMapping` that resolves `books` on `Author`. Test the N+1 problem — then solve it using `@BatchMapping` or a DataLoader.
