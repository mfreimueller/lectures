# Kata 1: JDBC Connection

| Field | Value |
|-------|-------|
| Concepts | DriverManager, Connection, try-with-resources |
| Difficulty | 1/5 |
| Duration | approx. 10 min |

### Task

Write a Java program that:
1. Loads the PostgreSQL JDBC driver
2. Establishes a connection to a database named `school` on localhost:5432
3. Prints whether the connection is valid using `conn.isValid(5)`
4. Closes the connection properly using try-with-resources

### Example Output

```
Connecting to jdbc:postgresql://localhost:5432/school...
Connection valid: true
Connection closed.
```

**Note:** The DDL script to set up the database is available at `katas/init.sql`.

### Extension

Read connection parameters (url, user, password) from environment variables.
