# Kata 1: CRUD Controller

| Field | Value |
|-------|-------|
| Concepts | Javalin, REST, CRUD |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Implement a Javalin controller with full CRUD for a `Book` entity:
1. `GET /api/books` - list all books
2. `GET /api/books/{id}` - get book by ID
3. `POST /api/books` - create a new book
4. `PUT /api/books/{id}` - update an existing book
5. `DELETE /api/books/{id}` - delete a book

Use a hardcoded in-memory list for data storage.

### Example Output

```
GET /api/books → 200 [{"id":1,"title":"The Hobbit"},...]
POST /api/books {"title":"Dune"} → 201 {"id":2,"title":"Dune"}
GET /api/books/2 → 200 {"id":2,"title":"Dune"}
PUT /api/books/2 {"title":"Dune (Revised)"} → 200 {"id":2,"title":"Dune (Revised)"}
DELETE /api/books/2 → 204
```

### Extension

Add pagination support with query parameters `?page=0&size=10`.
