# Kata 3: Custom Queries

| Field | Value |
|-------|-------|
| Concepts | derived queries, @Query, JPQL |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Add the following custom query methods to your repositories:

1. **BookRepository**:
   - `List<Book> findByAuthorName(String authorName)` — derived query
   - `List<Book> findByYearAfter(int year)` — derived query with comparison
   - `@Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")` — JPQL query
   - `@Query(value = "SELECT * FROM book WHERE year > :year", nativeQuery = true)` — native query, returns books published after a year

2. **LoanRepository**:
   - `List<Loan> findByReturnDateIsNull()` — currently borrowed books
   - `@Query("SELECT l FROM Loan l WHERE l.borrowDate < :date AND l.returnDate IS NULL")` — overdue loans before a given date

### Example

```java
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorName(String authorName);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitle(@Param("keyword") String keyword);
}
```

### Extension

Add `Page<Book> findByAuthorName(String authorName, Pageable pageable)` to test paginated queries with sorting.
