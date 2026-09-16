---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 18 - Prepared Statement, DAO
## POS - 3xHIF

---

## Agenda (1/2)

1. SQL Injection - The Problem
2. SQL Injection Demo
3. PreparedStatement to the Rescue
4. PreparedStatement Benefits
5. Using PreparedStatement - INSERT
6. Using PreparedStatement - SELECT

---

## Agenda (2/2)

7. Batch Processing
8. DAO Pattern - Motivation
9. DAO Interface
10. DAO Implementation
11. DAO in Practice
12. DAO with Connection Pooling

---

## Learning Objectives

- I can explain how SQL injection works and why string concatenation in SQL is dangerous
- I can replace vulnerable Statement code with parameterized PreparedStatement queries
- I can use batch processing to improve bulk operation performance
- I can implement the DAO pattern to separate data access from business logic
- I can integrate a DAO with connection pooling for production-ready data access

---

## SQL Injection - The Problem

SQL injection occurs when untrusted user input is concatenated directly into SQL queries.

```java
// Vulnerable code
String username = request.getParameter("username"); // user input: ' OR '1'='1
String sql = "SELECT * FROM users WHERE name = '" + username + "'";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql); // Returns ALL users!
```

<div class="highlight-box danger"><p>The input ' OR '1'='1 transforms the WHERE clause into: WHERE name = '' OR '1'='1' - which is always TRUE!</p></div>

---

## SQL Injection Demo

Input: `'; DROP TABLE students; --`

```sql
-- Original query
SELECT * FROM students WHERE name = '';

-- After concatenation
SELECT * FROM students WHERE name = ''; DROP TABLE students; --'
```

<div class="highlight-box danger"><p>This deletes the entire students table! This is known as a "SQL injection attack."</p></div>

---

## Discussion: Why Does SQL Injection Persist?

<div class="highlight-box">
<p>SQL injection is still in the OWASP Top 10 despite being well-understood and easily preventable. Why? Discuss the human, organizational, and technical factors that keep this vulnerability alive.</p>
</div>

---

## PreparedStatement to the Rescue

PreparedStatement uses parameterized queries - SQL and data are sent separately.

```java
// Safe: parameterized query
String sql = "SELECT * FROM users WHERE name = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, username); // User input is treated as data, not SQL
ResultSet rs = pstmt.executeQuery();
```

<div class="highlight-box"><p>The database driver escapes the input automatically, preventing injection.</p></div>

---

## PreparedStatement Benefits

- **Security:** Prevents SQL injection via parameter separation
- **Performance:** Precompiled queries are cached by the database
- **Type safety:** setString(), setInt(), setDate() enforce types
- **Readability:** SQL stays clean without string concatenation

---

## Using PreparedStatement - INSERT

```java
String sql = "INSERT INTO student (name, email, grade) VALUES (?, ?, ?)";

try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setString(1, "Bob");
    pstmt.setString(2, "bob@school.com");
    pstmt.setInt(3, 2);

    int rows = pstmt.executeUpdate();
    System.out.println(rows + " row(s) inserted.");
}
```

---

## Using PreparedStatement - SELECT

```java
String sql = "SELECT id, name, email FROM student WHERE grade = ?";

try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    pstmt.setInt(1, 1); // Find all grade 1 students

    try (ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ": " +
                               rs.getString("name"));
        }
    }
}
```

---

## Batch Processing

Execute multiple statements as a batch for better performance:

```java
String sql = "INSERT INTO student (name, email) VALUES (?, ?)";

try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    for (var student : students) {
        pstmt.setString(1, student.name());
        pstmt.setString(2, student.email());
        pstmt.addBatch(); // Add to batch
    }

    int[] results = pstmt.executeBatch();
    System.out.println("Inserted: " + results.length + " students");
}
```

---

## DAO Pattern - Motivation

DAO (Data Access Object) separates data access logic from business logic:

- Interface defines the contract
- Implementation hides SQL details
- Business code depends on abstraction, not database
- Easier testing with mock implementations

---

## DAO Interface

```java
public interface StudentDao {
    Optional<Student> findById(int id);
    List<Student> findAll();
    Student save(Student student);
    void update(Student student);
    void delete(int id);
}
```

<div class="highlight-box"><p>Interfaces keep the data access contract database-independent.</p></div>

---

## DAO Implementation

```java
public class StudentDaoImpl implements StudentDao {
    private static final String URL = "jdbc:postgresql://...";

    @Override
    public Optional<Student> findById(int id) {
        var sql = "SELECT * FROM student WHERE id = ?";
        try (var conn = DriverManager.getConnection(URL, user, pass);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapStudent(rs));
                }
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return Optional.empty();
    }

    private Student mapStudent(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("id"), rs.getString("name"),
                          rs.getString("email"), rs.getInt("grade"));
    }
}
}
```

---

## DAO in Practice

```java
// Business layer uses DAO interface
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao; // Dependency injection
    }

    public void promoteStudent(int id) {
        var student = studentDao.findById(id)
            .orElseThrow(() -> new NotFoundException("Student not found"));

        var promoted = new Student(id, student.name(),
                                   student.email(), student.grade() - 1);
        studentDao.update(promoted);
    }
}
```

---

## DAO with Connection Pooling

```java
// Real applications use connection pools (HikariCP)
public class StudentDaoImpl implements StudentDao {
    private final DataSource dataSource;

    public StudentDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Student> findAll() {
        var sql = "SELECT * FROM student";
        try (var conn = dataSource.getConnection();
             var pstmt = conn.prepareStatement(sql);
             var rs = pstmt.executeQuery()) {

            var result = new ArrayList<Student>();
            while (rs.next()) result.add(mapStudent(rs));
            return result;
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}
}
```

---

## Summary

<div class="highlight-box">
<ul>
<li>SQL injection is a serious security vulnerability</li>
<li>PreparedStatement prevents injection via parameterized queries</li>
<li>Batch processing improves bulk operation performance</li>
<li>DAO pattern provides clean abstraction over data access</li>
<li>Always depend on DAO interfaces, not implementations</li>
</ul>
</div>
