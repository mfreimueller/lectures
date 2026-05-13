# POS-WMC Project - Week 30: REST API, CRUD Endpoints

## Task

Implement all REST API endpoints for your project entities with CRUD operations and DTO mapping.

### Requirements

1. Create controller classes for all entities with route registration
2. Implement GET (list + single), POST, PUT, DELETE for each entity
3. Create request and response DTOs for each entity
4. Implement input validation for all write operations
5. Use proper HTTP status codes (200, 201, 204, 400, 404)
6. Implement consistent error handling with exception mappers
7. Wire controllers, services, and repositories together in the main application

### Example Output

```
GET  /api/books       → 200 [{id:1, title:"The Hobbit", ...}]
GET  /api/books/1     → 200 {id:1, title:"The Hobbit", ...}
POST /api/books       → 201 {id:2, title:"Dune", ...}
PUT  /api/books/2     → 200 {id:2, title:"Dune (Revised)", ...}
DELETE /api/books/2   → 204
```

### Extension

Add filtering, sorting, and pagination query parameters for list endpoints.
