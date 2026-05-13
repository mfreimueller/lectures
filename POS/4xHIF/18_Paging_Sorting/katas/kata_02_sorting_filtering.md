# Kata 2: Sorting & Filtering

| Field | Value |
|-------|-------|
| Concepts | Sort.by(), multiple sort criteria, combined filtering |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add a whitelist of allowed sort fields to prevent Sort Injection:

```java
private static final List<String> ALLOWED_SORT_FIELDS =
    List.of("id", "title", "author", "publicationYear");
```

2. Create a method that validates and sanitizes the sort parameter:

```java
private Sort validateSort(Sort sort) {
    return sort.stream()
        .filter(order -> ALLOWED_SORT_FIELDS.contains(order.getProperty()))
        .map(order -> Sort.by(order.getDirection(), order.getProperty()))
        .reduce(Sort::and)
        .orElse(Sort.by("id"));
}
```

3. Add combined filtering with pagination and sorting:

```java
@GetMapping
public Page<BookDTO> search(
        @RequestParam(required = false) String author,
        @RequestParam(required = false) Integer year,
        @PageableDefault(size = 10, sort = "title")
        Pageable pageable) {

    Sort safeSort = validateSort(pageable.getSort());
    Pageable safePageable = PageRequest.of(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        safeSort);

    return service.search(author, year, safePageable);
}
```

4. Add repository methods for filtered queries:

```java
Page<Book> findByAuthorContainingIgnoreCase(
    String author, Pageable pageable);

Page<Book> findByPublicationYear(
    int year, Pageable pageable);

@Query("SELECT b FROM Book b WHERE " +
       "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
       "(:year IS NULL OR b.publicationYear = :year)")
Page<Book> searchBooks(
    @Param("author") String author,
    @Param("year") Integer year,
    Pageable pageable);
```

### Extension

Add a `@SortDefault` annotation to specify the default sort when no sort parameter is provided, and combine it with `@PageableDefault`.
