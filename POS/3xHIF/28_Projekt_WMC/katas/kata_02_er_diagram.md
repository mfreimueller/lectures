# Kata 2: ER Diagram

| Field | Value |
|-------|-------|
| Concepts | Entity-relationship modeling, database design |
| Difficulty | 2/5 |
| Duration | approx. 30 min |

### Task

Draw an ER diagram for your chosen project domain. Include:
1. At least 6 entities (tables)
2. Primary keys and foreign keys for each entity
3. At least one 1:1 relationship
4. At least one 1:n relationship
5. At least one inheritance hierarchy
6. All attributes with appropriate data types

### Example Output

```
USER (id PK, username, email, password_hash, role, created_at)
  |
  | 1:1
  v
ADDRESS (id PK, user_id FK, street, city, zip, country)
  |
CATEGORY (id PK, name, description)
  |
  | 1:n
  v
BOOK (id PK, title, isbn, category_id FK, published_year)
  |
  | Inheritance (JOINED)
  v
PHYSICAL_BOOK (book_id PK/FK, shelf_location, copies_available)
E_BOOK (book_id PK/FK, file_format, file_size_mb, download_url)
  |
AUTHOR (id PK, name, biography)
BOOK_AUTHOR (book_id FK, author_id FK) [n:m]
  |
LOAN (id PK, user_id FK, book_id FK, loan_date, due_date, returned)
REVIEW (id PK, user_id FK, book_id FK, rating, comment, created_at)
```

### Extension

Add indexes, check constraints, and default values to your diagram.
