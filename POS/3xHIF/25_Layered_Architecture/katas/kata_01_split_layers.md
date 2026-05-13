# Kata 1: Split into Layers

| Field | Value |
|-------|-------|
| Concepts | Repository pattern, separation of concerns |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Given the following monolithic handler code, extract data access into a Repository class:

Monolithic code:
```java
app.get("/api/users", ctx -> {
    var users = new ArrayList<>();
    // data access mixed with handler
    try (var conn = DriverManager.getConnection("...")) {
        var stmt = conn.prepareStatement("SELECT * FROM users");
        var rs = stmt.executeQuery();
        while (rs.next()) {
            users.add(Map.of("id", rs.getLong("id"), "name", rs.getString("name")));
        }
    }
    ctx.json(users);
});
```

Create a UserRepository interface and an InMemoryUserRepository implementation, then refactor the handler to use the repository.

### Example Output

```
// After refactoring:
var repo = new InMemoryUserRepository();
app.get("/api/users", ctx -> ctx.json(repo.findAll()));
```

### Extension

Add a JdbcUserRepository implementation that uses JDBC.
