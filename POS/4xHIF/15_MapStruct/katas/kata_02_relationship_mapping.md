# Kata 2: Relationship Mapping

| Field | Value |
|-------|-------|
| Concepts | Nested mapping, flattening, @Mapping with nested targets |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Extend the domain model with an `Author` entity:
   - `Long id`, `String name`, `int birthYear`
   - `Book` gets a `ManyToOne` relationship to `Author`

2. Create an `AuthorDTO` record with: `Long id`, `String name`, `int birthYear`

3. Create an `AuthorMapper` interface (basic mapping)

4. Update `BookDTO` to include author information in two ways:

   **Variant A — Flattened (recommended for this kata):**
   ```java
   public record BookDTO(
       Long id,
       String isbn13,
       String title,
       String authorName,   // from book.author.name
       int authorBirthYear  // from book.author.birthYear
   ) {}
   ```

   **Variant B — Nested:**
   ```java
   public record BookDTO(
       Long id,
       String isbn13,
       String title,
       AuthorDTO author     // nested DTO
   ) {}
   ```

5. Update `BookMapper`:
   - For flattened: use `@Mapping(target = "authorName", source = "author.name")`
   - For nested: MapStruct auto-maps matching fields, use `@Mapping(target = "author", source = "author")` with `uses = AuthorMapper.class`

### Example

```java
// Flattened mapping
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "isbn", target = "isbn13")
    @Mapping(source = "publicationYear", target = "year")
    @Mapping(target = "version", ignore = true)
    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "author.birthYear", target = "authorBirthYear")
    BookDTO toDto(Book book);
}
```

### Extension

Handle null author gracefully — if `book.author` is `null`, `authorName` and `authorBirthYear` should be `null` in the DTO (not throw NPE). Test this case.
