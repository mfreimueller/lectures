# Kata 1: Self-Links

| Field | Value |
|-------|-------|
| Concepts | EntityModel, WebMvcLinkBuilder, linkTo, methodOn |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add the Spring HATEOAS dependency to your project:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

2. Modify `BookDTO` to extend `RepresentationModel<BookDTO>` (or add the fields manually):

```java
public class BookDTO extends RepresentationModel<BookDTO> {
    // existing fields...
}
```

3. Refactor `GET /api/books/{id}` to return `EntityModel<BookDTO>` with a self-link:

```java
@GetMapping("/{id}")
public EntityModel<BookDTO> getById(@PathVariable Long id) {
    BookDTO dto = service.getById(id);
    return EntityModel.of(dto,
        linkTo(methodOn(BookController.class).getById(id)).withSelfRel());
}
```

4. If the book has an author, add an `author` link to `GET /api/authors/{authorId}`

5. Test with curl or httpie — verify the `_links` section appears in the JSON response

### Example Response

```json
{
    "id": 1,
    "title": "Clean Code",
    "authorName": "Robert C. Martin",
    "_links": {
        "self": { "href": "http://localhost:8080/api/books/1" },
        "author": { "href": "http://localhost:8080/api/authors/1" }
    }
}
```

### Extension

Add an `all` link pointing to `GET /api/books` to allow clients to navigate back to the collection.
