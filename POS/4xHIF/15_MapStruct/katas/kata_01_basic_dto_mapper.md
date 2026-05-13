# Kata 1: Basic DTO Mapper

| Field | Value |
|-------|-------|
| Concepts | @Mapper, @Mapping, DTO pattern |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a `Book` entity (JPA) with fields: `Long id`, `String isbn`, `String title`, `String author`, `int publicationYear`, `int version`

2. Create a `BookDTO` record with fields: `Long id`, `String isbn13`, `String title`, `String author`, `int year`

3. Add the MapStruct dependency to your `pom.xml` or `build.gradle`:

```xml
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.5.Final</version>
</dependency>
```

4. Create a `BookMapper` interface annotated with `@Mapper(componentModel = "spring")`:
   - Map `isbn` → `isbn13`
   - Map `publicationYear` → `year`
   - Ignore `version`

5. Write a test that creates a `Book` entity, maps it to `BookDTO`, and verifies the mapping

### Example

```java
@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "isbn", target = "isbn13")
    @Mapping(source = "publicationYear", target = "year")
    @Mapping(target = "version", ignore = true)
    BookDTO toDto(Book book);

    @Mapping(source = "isbn13", target = "isbn")
    @Mapping(source = "year", target = "publicationYear")
    Book toEntity(BookDTO dto);
}
```

### Extension

Add a `List<BookDTO> toDtoList(List<Book> books)` method — MapStruct generates the collection mapping automatically.
