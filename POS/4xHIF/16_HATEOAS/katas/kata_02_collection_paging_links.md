# Kata 2: Collection & Paging Links

| Field | Value |
|-------|-------|
| Concepts | CollectionModel, pagination links, link relations |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Modify `GET /api/books` to return `CollectionModel<BookDTO>` with a self-link:

```java
@GetMapping
public CollectionModel<BookDTO> getAll() {
    List<BookDTO> books = service.getAll();
    return CollectionModel.of(books,
        linkTo(methodOn(BookController.class).getAll()).withSelfRel());
}
```

2. Add a `create-book` link (templated link pointing to POST endpoint):

```java
Link createLink = Link.of(
    linkTo(methodOn(BookController.class).create(null)).toUri().toString(),
    "create-book"
);
```

3. Simulate pagination without Spring Data — implement manual page/size params and return pagination links:

```java
@GetMapping(params = {"page", "size"})
public CollectionModel<BookDTO> getPage(
        @RequestParam int page,
        @RequestParam int size) {
    // ... pagination logic ...
    return CollectionModel.of(pageContent,
        linkTo(methodOn(BookController.class).getPage(page, size)).withSelfRel(),
        // next/prev/first/last links based on page state
    );
}
```

4. Add navigation links: `next`, `prev`, `first`, `last` based on pagination state

### Example Response

```json
{
    "_embedded": {
        "bookDTOList": [ ... ]
    },
    "_links": {
        "self": { "href": "http://localhost:8080/api/books?page=1&size=5" },
        "next": { "href": "http://localhost:8080/api/books?page=2&size=5" },
        "prev": { "href": "http://localhost:8080/api/books?page=0&size=5" },
        "first": { "href": "http://localhost:8080/api/books?page=0&size=5" },
        "last": { "href": "http://localhost:8080/api/books?page=3&size=5" }
    }
}
```

### Extension

Add an `Affordance` to the `create-book` link that describes the expected request body (POST method, JSON schema).
