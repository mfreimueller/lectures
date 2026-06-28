# Kata 2: API Documentation

| Field | Value |
|-------|-------|
| Concepts | API documentation, markdown tables |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Create an API documentation table listing all endpoints of your project:
1. List all endpoints grouped by entity
2. Include HTTP method, URL, description, authentication requirement, request body, and response
3. Use a markdown table format

### Example Output

```markdown
## API Endpoints

### Authentication
| Method | URL | Description | Auth | Request Body | Response |
|--------|-----|-------------|------|-------------|----------|
| POST | /api/register | Register new user | No | {username, email, password} | 201 {token, user} |
| POST | /api/login | Login | No | {username, password} | 200 {token, user} |

### Books
| Method | URL | Description | Auth | Request Body | Response |
|--------|-----|-------------|------|-------------|----------|
| GET | /api/books | List all books | Yes | - | 200 [{id, title, ...}] |
| POST | /api/books | Create book | Admin | {title, isbn, ...} | 201 {id, title, ...} |
```

### Extension

Add example curl commands for each endpoint.
