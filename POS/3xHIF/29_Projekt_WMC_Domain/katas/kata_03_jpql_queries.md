# Kata 3: JPQL Queries

| Field | Value |
|-------|-------|
| Concepts | JPQL, JOIN, aggregate queries |
| Difficulty | 3/5 |
| Duration | approx. 15 min |

### Task

Write JPQL queries for the following (using a library domain):
1. Find all books by a specific author name
2. Find all active loans for a given user (not yet returned)
3. Count the number of books in each category
4. Find the top 5 most-reviewed books
5. Find all overdue loans (past due date and not returned)

### Example Output

```java
// Query 1:
em.createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :name", Book.class)
    .setParameter("name", "Tolkien")
    .getResultList();
```

### Extension

Write the same queries using the Criteria API.
