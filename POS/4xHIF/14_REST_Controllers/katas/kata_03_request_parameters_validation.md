# Kata 3: Request Parameters & Validation

| Field | Value |
|-------|-------|
| Concepts | @RequestParam, @PathVariable, @Valid, error handling |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add query parameter filtering to the `GET /api/books` endpoint:
   - `?author=Rowling` — filter by author (partial match, case-insensitive)
   - `?year=2000` — filter by exact publication year
   - `?author=Rowling&year=2000` — combine filters
   - `?page=0&size=10` — simple pagination with defaults

2. Add validation annotations to the `Book` record:
   - `@NotBlank` on `isbn`, `title`, `author`
   - `@Pattern(regexp = "\\\\d{13}")` on `isbn` (13-digit ISBN)
   - `@Min(1900)` and `@Max(2025)` on `publicationYear`
   - Custom error messages for each constraint

3. Add `@Valid` to the `@RequestBody` parameter in POST and PUT endpoints

4. Validate `@PathVariable` `id` — return 400 if id is not a positive number

### Example

```java
@GetMapping
public List<Book> search(
        @RequestParam(required = false) String author,
        @RequestParam(required = false) Integer year,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {

    return repository.search(author, year, page, size);
}
```

### Extension

Create a custom `@ValidIsbn` annotation with a validator that checks the ISBN-13 checksum. Add it to the `Book` record's `isbn` field.
