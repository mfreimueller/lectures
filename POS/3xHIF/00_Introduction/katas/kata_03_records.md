# Kata 2: Records

| Field | Value |
|-------|-------|
| Concepts | Records, immutability, compact constructor |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Define a `Book` record with fields `title` (String), `author` (String), and `year` (int).

1. Add a compact constructor that validates `year` is between 1900 and 2026
2. Create a few Book instances and print them
3. Add a method `age()` that returns how old the book is

### Example Output

```
Book[title=The Hobbit, author=J.R.R. Tolkien, year=1937]
Book[title=Dune, author=Frank Herbert, year=1965]
The Hobbit is 89 years old
Dune is 61 years old
```

### Extension

Add a static factory method `of` that accepts a CSV line and parses it into a Book.
