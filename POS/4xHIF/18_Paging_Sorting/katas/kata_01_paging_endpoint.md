# Kata 1: Paging Endpoint

| Field | Value |
|-------|-------|
| Concepts | Pageable, Page, @PageableDefault |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Modify the `BookRepository` to extend `PagingAndSortingRepository` or `JpaRepository` (already includes pagination):

```java
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
}
```

2. Update the `BookService` to accept `Pageable`:

```java
public Page<BookDTO> getAll(Pageable pageable) {
    return repository.findAll(pageable)
        .map(mapper::toDto);
}
```

3. Update the controller to accept pagination parameters:

```java
@GetMapping
public Page<BookDTO> getAll(
        @PageableDefault(size = 10, sort = "title")
        Pageable pageable) {
    return service.getAll(pageable);
}
```

4. Test with:
   - `GET /api/books?page=0&size=5`
   - `GET /api/books?page=1&size=3&sort=author,asc`
   - `GET /api/books?sort=publicationYear,desc&sort=title,asc`

### Example Response

```json
{
    "content": [ ... ],
    "pageable": { "pageNumber": 0, "pageSize": 5, "sort": { ... } },
    "totalElements": 42,
    "totalPages": 9,
    "last": false,
    "first": true,
    "number": 0,
    "size": 5
}
```

### Extension

Add `@PageableDefault(page = 0, size = 20, sort = "id", direction = Sort.Direction.ASC)` and verify the defaults apply when no parameters are provided.
