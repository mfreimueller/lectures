# Kata 2: @PreAuthorize

| Field | Value |
|-------|-------|
| Concepts | @PreAuthorize, @EnableMethodSecurity, role-based access |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Enable method security:

```java
@Configuration
@EnableMethodSecurity
public class MethodSecurityConfig {}
```

2. Secure the service layer with `@PreAuthorize`:

```java
@Service
public class BookService {

    @PreAuthorize("hasRole('ADMIN')")
    public BookDTO create(BookDTO dto) { ... }

    @PreAuthorize("hasRole('ADMIN')")
    public BookDTO update(Long id, BookDTO dto) { ... }

    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Long id) { ... }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Cacheable("books")
    public List<BookDTO> getAll() { ... }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public BookDTO getById(Long id) { ... }
}
```

3. Test role-based access:
   - `curl -u user:user -X POST http://localhost:8080/api/books` — 403 Forbidden
   - `curl -u admin:admin -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d '{...}'` — 201 Created
   - `curl -u user:user http://localhost:8080/api/books` — 200 OK

### Extension

Add a custom permission evaluator: `@PreAuthorize("hasPermission(#id, 'Book', 'READ')")`. Implement a `PermissionEvaluator` that checks if the user owns the resource.
