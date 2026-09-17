---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 13 - JPA, Entities, Relationships
## POS - 3xHIF

---

## Agenda (1/2)

1. From JDBC to JPA
2. JPA Architecture
3. Persistence Unit Configuration
4. Entity Mapping
5. EntityManager Operations
6. JPQL - JPA Query Language

---

## Agenda (2/2)

7. JPQL vs SQL
8. @OneToOne Relationship
9. @OneToMany / @ManyToOne
10. @ManyToMany Relationship
11. Cascade Types
12. JPA vs JDBC DAO - Comparison

---

## Learning Objectives

- I can explain the JPA architecture and the role of EntityManager
- I can map Java classes to database tables using @Entity, @Table, @Id, and @Column
- I can perform CRUD operations using EntityManager (persist, find, merge, remove)
- I can model entity relationships using @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany
- I can write JPQL queries and understand the difference between JPQL and SQL

---

## From JDBC to JPA

JDBC requires a lot of boilerplate code for common operations.

```java
// JPA: 1 line
entityManager.persist(student);
```

<div class="highlight-box"><p>JPA eliminates boilerplate by mapping Java objects directly to database rows.</p></div>

---

## Reflection: Convenience vs Control

<div class="highlight-box">
<p>JPA eliminates boilerplate but hides the SQL. When would you choose JDBC over JPA, and when is JPA the clear winner? Discuss the trade-off between developer productivity and fine-grained control.</p>
</div>

---

## JPA Architecture

- **EntityManager:** Core interface for persistence operations
- **EntityManagerFactory:** Creates EntityManager instances (one per database)
- **Persistence Context:** First-level cache of managed entities
- **Persistence Unit:** Configuration in persistence.xml

```java
EntityManagerFactory emf =
    Persistence.createEntityManagerFactory("school-unit");
EntityManager em = emf.createEntityManager();
```

---

## Persistence Unit Configuration

```xml
<!-- META-INF/persistence.xml -->
<persistence-unit name="school-unit">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <class>com.school.model.Student</class>
    <properties>
        <property name="jakarta.persistence.jdbc.url"
                  value="jdbc:postgresql://localhost:5432/school"/>
        <property name="jakarta.persistence.jdbc.user" value="postgres"/>
        <property name="jakarta.persistence.jdbc.password" value="secret"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
        <property name="hibernate.show_sql" value="true"/>
    </properties>
</persistence-unit>
```

---

## Entity Mapping

```java
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private int grade;

    // Constructors, getters, setters (required by JPA)
    public Student() {}  // No-arg constructor required

    // getters and setters...
}
```

---

## EntityManager Operations

```java
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

// CREATE
tx.begin();
Student student = new Student("Alice", "alice@school.com", 1);
em.persist(student);   // Makes entity managed
tx.commit();

// READ
Student found = em.find(Student.class, 1L);

// UPDATE (within transaction)
tx.begin();
Student s = em.find(Student.class, 1L);
s.setGrade(2);  // Automatically detected and persisted
tx.commit();

// DELETE
tx.begin();
Student s = em.find(Student.class, 1L);
em.remove(s);
tx.commit();
```

---

## JPQL - JPA Query Language

JPQL queries entities (not tables) using Java class and field names:

```java
String jpql = "SELECT s FROM Student s WHERE s.grade > :minGrade";
List<Student> result = em.createQuery(jpql, Student.class)
    .setParameter("minGrade", 1)
    .getResultList();
```

<div class="highlight-box"><p>JPQL is database-independent - JPA generates the appropriate SQL dialect.</p></div>

---

## JPQL vs SQL

| Feature | JPQL | SQL |
| --- | --- | --- |
| Target | Entity classes and fields | Tables and columns |
| JOIN | s.courses (navigation) | JOIN student_course sc |
| Polymorphic | Yes (inheritance-aware) | No (manual UNION) |
| Portable | Yes (any DB) | Vendor-specific |

```java
// JPQL: Navigate relationships directly
"SELECT s FROM Student s JOIN s.courses c WHERE c.name = :name"

// SQL: Must know join table structure
"SELECT s.* FROM student s JOIN enrollment e ON s.id = e.student_id
 JOIN course c ON e.course_id = c.id WHERE c.name = ?"
```

---

## @OneToOne Relationship

```java
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private ContactInfo contactInfo;
    // ...
}

@Entity
public class ContactInfo {
    @Id @GeneratedValue
    private Long id;

    private String phone;
    private String address;

    @OneToOne(mappedBy = "contactInfo")
    private Student student;  // Inverse side
}
```

---

## @OneToMany / @ManyToOne

```java
@Entity
public class Course {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();
}

@Entity
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private int grade;
}
```

---

## @ManyToMany Relationship

```java
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    // ...

    @ManyToMany
    @JoinTable(
        name = "student_ elective",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "elective_id")
    )
    private List<Elective> electives = new ArrayList<>();
}

@Entity
public class Elective {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int maxStudents;

    @ManyToMany(mappedBy = "electives")
    private List<Student> students = new ArrayList<>();
}
}
```

---

## Cascade Types

| Cascade Type | Description |
| --- | --- |
| PERSIST | Save related entities when parent is saved |
| MERGE | Merge related entities when parent is merged |
| REMOVE | Delete related entities when parent is deleted |
| REFRESH | Refresh related entities when parent is refreshed |
| DETACH | Detach related entities when parent is detached |
| ALL | All of the above |

```java
// CascadeType.ALL propagates every operation
@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,
           orphanRemoval = true)
private List<Enrollment> enrollments;

// Now: persist(course) also persists all enrollments
```

---

## JPA vs JDBC DAO - Comparison

```java
// JDBC DAO: ~15 lines for findById
public Optional<Student> findById(Long id) {
    var sql = "SELECT * FROM student WHERE id = ?";
    try (var conn = dataSource.getConnection();
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setLong(1, id);
        try (var rs = pstmt.executeQuery()) {
            if (rs.next()) return Optional.of(mapRow(rs));
        }
    } catch (SQLException e) { throw new RuntimeException(e); }
    return Optional.empty();
}

// JPA: 1 line
Student student = em.find(Student.class, id);
```

---

## Summary

<div class="highlight-box">
<ul>
<li>JPA maps Java objects to database tables via @Entity</li>
<li>EntityManager handles all CRUD operations</li>
<li>JPQL queries entities, not tables</li>
<li>Relationships: @OneToOne, @OneToMany/@ManyToOne, @ManyToMany</li>
<li>Cascade types control how operations propagate</li>
</ul>
</div>
