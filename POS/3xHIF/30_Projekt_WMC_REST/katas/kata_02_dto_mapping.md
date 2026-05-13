# Kata 2: DTO Mapping

| Field | Value |
|-------|-------|
| Concepts | DTOs, records, mapping |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Create DTO records and mapper methods for `Book` and `Category` entities:
1. `BookDto` with fields: id, title, isbn, publishedYear, categoryName, authorNames
2. `CreateBookDto` with fields: title, isbn, publishedYear, categoryId, authorIds
3. `CategoryDto` with fields: id, name, description, bookCount
4. Static `from(Entity)` methods to map entities to DTOs

### Example Output

```java
public static BookDto from(Book book) {
    return new BookDto(
        book.getId(), book.getTitle(), book.getIsbn(),
        book.getPublishedYear(), book.getCategory().getName(),
        book.getAuthors().stream().map(Author::getName).toList()
    );
}
```

### Extension

Add a `toEntity()` method that creates or updates an entity from a DTO.
