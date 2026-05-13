# Kata 3: Custom Query Tests

| Field | Value |
|-------|-------|
| Concepts | derived queries, @Query, edge cases |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write tests for the custom queries in BookRepository:

1. **findByAuthorName()** — Create books by "Martin Fowler" and "Uncle Bob". Verify searching by each author returns correct books.
2. **searchByTitle()** — Create books with "Java" in the title and without. Verify keyword search returns only matches.
3. **Overdue loans** — Create loans with borrowDate in the past and no returnDate. Verify they appear as overdue.
4. **Edge cases**:
   - Empty result for a non-matching query
   - Case insensitivity of search
   - Null parameter handling

### Example

```java
@Test
void searchByTitle_shouldFindMatchingBooks() {
    List<Book> result = bookRepo.searchByTitle("Java");
    assertThat(result)
        .hasSize(1)
        .extracting(Book::getTitle)
        .allMatch(title -> title.contains("Java"));
}

@Test
void searchByTitle_shouldReturnEmptyForNoMatch() {
    List<Book> result = bookRepo.searchByTitle("NonExistent");
    assertThat(result).isEmpty();
}
```

### Extension

Write a parameterized test using `@CsvSource` to test multiple search keywords in one test method.
