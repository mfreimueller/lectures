# Kata 3: Custom Mapping

| Field | Value |
|-------|-------|
| Concepts | @Named, default methods, Expression-based mapping |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add a `LocalDateTime createdAt` field to the `Book` entity (set automatically via `@PrePersist`)

2. Add a `String createdAtFormatted` field to `BookDTO`

3. Create a custom mapping method in the mapper annotated with `@Named("formatTimestamp")`:

```java
@Named("formatTimestamp")
default String formatLocalDateTime(LocalDateTime dateTime) {
    if (dateTime == null) return null;
    return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
}
```

4. Use the custom mapper in `@Mapping`:

```java
@Mapping(target = "createdAtFormatted", source = "createdAt", qualifiedByName = "formatTimestamp")
```

5. Add a computed field `fullTitle` in `BookDTO` that combines `title` and `authorName` using expression-based mapping:

```java
@Mapping(target = "fullTitle", expression = "java(book.title() + \" by \" + book.author().name())")
```

6. Write a test that verifies the timestamp format and the computed field

### Example

```java
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "isbn", target = "isbn13")
    @Mapping(source = "publicationYear", target = "year")
    @Mapping(target = "version", ignore = true)
    @Mapping(source = "createdAt", target = "createdAtFormatted",
             qualifiedByName = "formatTimestamp")
    @Mapping(target = "fullTitle",
             expression = "java(book.getTitle() + \" by \" + book.getAuthor().getName())")
    BookDTO toDto(Book book);

    @Named("formatTimestamp")
    default String formatLocalDateTime(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
    }
}
```

### Extension

Create a separate `DateMapper` class/interface with `@Named` methods, then reference it via `uses = DateMapper.class` in `@Mapper`. This allows reusing the same mapping logic across multiple mappers.
