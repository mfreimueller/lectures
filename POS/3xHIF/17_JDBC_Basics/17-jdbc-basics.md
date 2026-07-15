---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 17 - JDBC, Basics
## POS - 3xHIF

---

## Agenda (1/2)

1. What is JDBC?
2. JDBC Architecture
3. JDBC Drivers
4. Establishing a Connection
5. Connection Parameters
6. Statement Interface
7. Processing ResultSet

---

## Agenda (2/2)

8. ResultSet Data Types
9. INSERT with Statement
10. UPDATE and DELETE
11. Handling SQLException
12. Resource Management
13. Complete CRUD Example

---

## Learning Objectives

- I can explain the JDBC architecture and its core interfaces
- I can establish a database connection using DriverManager
- I can execute SQL queries and process ResultSet data
- I can perform CRUD operations using Statement
- I can manage JDBC resources safely with try-with-resources

---

## What is JDBC?

JDBC (Java Database Connectivity) is the standard Java API for database-independent connectivity between Java applications and relational databases.

- Part of java.sql package (since JDK 1.1)
- Provides a vendor-neutral interface
- Database vendors provide JDBC driver implementations

---

## JDBC Architecture

- **DriverManager** - manages JDBC drivers
- **Connection** - represents a database session
- **Statement** - executes SQL statements
- **ResultSet** - represents query results
- **SQLException** - handles database errors

![width:70% JDBC Architecture: DriverManager, Connection, Statement, ResultSet](mermaid/jdbc-architecture.svg)

---

## JDBC Drivers

Type 4 drivers (pure Java) are most common:

```java
// PostgreSQL driver
// Maven dependency
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
</dependency>
```

<div class="highlight-box"><p>PostgreSQL JDBC driver class: org.postgresql.Driver</p></div>

---

## Establishing a Connection

```java
String url = "jdbc:postgresql://localhost:5432/school";
try (Connection conn = DriverManager.getConnection(url, "postgres", "secret")) {
    System.out.println("Connected: " + conn.isValid(5));
}
```

<div class="highlight-box"><p>JDBC URL format: jdbc:postgresql://host:port/database</p></div>

---

## Now Kata 1: JDBC Connection

Write a program that loads the PostgreSQL JDBC driver, establishes a connection, and validates it

---

## Connection Parameters

```java
// Connection properties
Properties props = new Properties();
props.setProperty("user", "postgres");
props.setProperty("password", "secret");
props.setProperty("ssl", "false");
props.setProperty("connectTimeout", "10");

Connection conn = DriverManager
    .getConnection("jdbc:postgresql://localhost:5432/school", props);
```

---

## Statement Interface

Statement is used to execute static SQL queries:

```java
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM student");
int rows = stmt.executeUpdate("UPDATE student SET grade = 1 WHERE id = 101");
```

<div class="highlight-box"><p>executeQuery() returns ResultSet; executeUpdate() returns affected row count.</p></div>

---

## Processing ResultSet

```java
String sql = "SELECT id, name, email FROM student";
try (Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(sql)) {

    while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        System.out.println(id + ": " + name + " (" + email + ")");
    }
}
```

---

## ResultSet Data Types

| SQL Type | Java Method |
| --- | --- |
| INTEGER | getInt() |
| VARCHAR / TEXT | getString() |
| BOOLEAN | getBoolean() |
| DATE | getDate() |
| TIMESTAMP | getTimestamp() |
| DECIMAL / NUMERIC | getBigDecimal() |
| DOUBLE / FLOAT | getDouble() |

---

## INSERT with Statement

```java
String sql = "INSERT INTO student (name, email, grade) VALUES ("
           + "'Alice', 'alice@school.com', 1)";

int rows = stmt.executeUpdate(sql);
System.out.println(rows + " row(s) inserted.");
```

<div class="highlight-box warning"><p>String concatenation in SQL is vulnerable to injection attacks!</p></div>

---

## Reflection: SQL Injection

<div class="highlight-box">
<p>SQL injection remains a top vulnerability decades after it was first documented. Why do developers still concatenate user input into SQL queries? Is it a knowledge gap, time pressure, or something else — and how do we break the cycle?</p>
</div>

---

## UPDATE and DELETE

```java
// UPDATE
String sql = "UPDATE student SET grade = 2 WHERE id = 101";
int updated = stmt.executeUpdate(sql);

// DELETE
String sqlDel = "DELETE FROM student WHERE id = 101";
int deleted = stmt.executeUpdate(sqlDel);

// Check affected rows
if (deleted > 0) {
    System.out.println("Student deleted successfully.");
}
```

---

## Now Kata 2: CRUD Operations

Write a program that performs CRUD operations on a student table using Statement

---

## Handling SQLException

```java
try (Connection conn = DriverManager.getConnection(url, user, pass)) {
    // database operations
} catch (SQLException e) {
    System.err.println("Error Code: " + e.getErrorCode());
    System.err.println("SQL State: " + e.getSQLState());
    System.err.println("Message: " + e.getMessage());

    // Chained exceptions
    Throwable t = e.getNextException();
    while (t != null) {
        System.err.println("Caused by: " + t.getMessage());
        t = t.getNextException();
    }
}
```

---

## Resource Management

Always close JDBC resources to prevent memory/resource leaks:

```java
// Bad: manual close with null checks
Connection conn = null;
Statement stmt = null;
try {
    conn = DriverManager.getConnection(url, user, pass);
    stmt = conn.createStatement();
    // ...
} finally {
    if (stmt != null) stmt.close();
    if (conn != null) conn.close();
}

// Good: try-with-resources (Java 7+)
try (Connection conn = DriverManager.getConnection(url, user, pass);
     Statement stmt = conn.createStatement()) {
     // ...
}
```

---

## Now Kata 3: Transactional Batch Insert

Insert multiple students within a transaction, with rollback on failure

---

## Complete CRUD Example

```java
public class StudentDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/school";

    public List<String> getAllStudents() throws SQLException {
        var students = new ArrayList<String>();
        var sql = "SELECT id, name FROM student ORDER BY id";

        try (var conn = DriverManager.getConnection(URL, "postgres", "secret");
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(rs.getInt("id") + ": " + rs.getString("name"));
            }
        }
        return students;
    }
}
```

---

## Summary

<div class="highlight-box">
<ul>
<li>JDBC provides database-independent Java database access</li>
<li>Connection, Statement, ResultSet are core interfaces</li>
<li>Always use try-with-resources for automatic cleanup</li>
<li>CRUD operations use executeQuery() and executeUpdate()</li>
<li>Handle SQLException with detailed error information</li>
</ul>
</div>
