---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 20 - JPA, Inheritance, Value Objects
## POS - 3xHIF

---

## Agenda (1/2)

1. JPA Inheritance Overview
2. SINGLE_TABLE Strategy
3. SINGLE_TABLE - Table Structure
4. JOINED Strategy
5. JOINED - SQL Query
6. JOINED - Table Structure
7. TABLE_PER_CLASS Strategy
8. TABLE_PER_CLASS - Table Structure

---

## Agenda (2/2)

9. Inheritance Strategy Comparison
10. Value Objects with @Embeddable
11. Using @Embedded
12. Value Object Examples
13. Repository Pattern
14. Generic Repository Implementation
15. Transaction Management

---

## Learning Objectives

- I can explain the three JPA inheritance strategies and their trade-offs
- I can map a class hierarchy using SINGLE_TABLE, JOINED, or TABLE_PER_CLASS
- I can create value objects with @Embeddable and embed them with @Embedded
- I can implement a generic JPA Repository for type-safe data access
- I can manage transactions with explicit begin/commit/rollback boundaries

---

## JPA Inheritance Overview

JPA supports three strategies for mapping class inheritance to database tables:

- **SINGLE_TABLE:** One table for the entire hierarchy
- **JOINED:** One table per class, joined via foreign keys
- **TABLE_PER_CLASS:** One table per concrete class

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {
    @Id @GeneratedValue
    private Long id;
}
```

---

## SINGLE_TABLE Strategy

All classes in the hierarchy map to one database table.

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

@Entity
@DiscriminatorValue("STU")
public class Student extends Person {
    private String studentId;
    private int grade;
}

@Entity
@DiscriminatorValue("TCH")
public class Teacher extends Person {
    private String employeeId;
    private String subject;
}
```

---

## SINGLE_TABLE - Table Structure

| id | person_type | name | studentId | grade | employeeId | subject |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | STU | Alice | S123 | 1 | NULL | NULL |
| 2 | TCH | Mr. Smith | NULL | NULL | T456 | Math |

<div class="highlight-box">
<strong>Pros:</strong> No JOINs, fast queries<br/>
<strong>Cons:</strong> Many nullable columns, violates normalization
</div>

---

## JOINED Strategy

Each class gets its own table; subclasses reference the parent via foreign key.

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

@Entity
public class Student extends Person {
    private String studentId;
    private int grade;
}
```

---

## JOINED - SQL Query

```sql
-- Queries require JOIN between person and student tables
SELECT p.id, p.name, s.studentId, s.grade
FROM Person p JOIN Student s ON p.id = s.id
```

---

## JOINED - Table Structure

<table>
<tr><th colspan="2">person</th></tr>
<tr><td>id (PK)</td><td>name</td></tr>
<tr><td>1</td><td>Alice</td></tr>
</table>

<table>
<tr><th colspan="3">student</th></tr>
<tr><td>id (PK, FK)</td><td>studentId</td><td>grade</td></tr>
<tr><td>1</td><td>S123</td><td>1</td></tr>
</table>

<div class="highlight-box">
<strong>Pros:</strong> Normalized, no nulls<br/>
<strong>Cons:</strong> JOINs required for queries
</div>

---

## TABLE_PER_CLASS Strategy

Each concrete class has its own complete table.

```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;
}

@Entity
public class Student extends Person {
    private String studentId;
    private int grade;
}

@Entity
public class Teacher extends Person {
    private String employeeId;
    private String subject;
}
```

---

## TABLE_PER_CLASS - Table Structure

<table>
<tr><th colspan="4">student</th></tr>
<tr><td>id</td><td>name</td><td>studentId</td><td>grade</td></tr>
<tr><td>1</td><td>Alice</td><td>S123</td><td>1</td></tr>
</table>

<table>
<tr><th colspan="4">teacher</th></tr>
<tr><td>id</td><td>name</td><td>employeeId</td><td>subject</td></tr>
<tr><td>2</td><td>Mr. Smith</td><td>T456</td><td>Math</td></tr>
</table>

<div class="highlight-box">
<strong>Pros:</strong> No JOINs, no nullable columns<br/>
<strong>Cons:</strong> Duplicate columns, UNION for polymorphic queries
</div>

---

## Inheritance Strategy Comparison

| Feature | SINGLE_TABLE | JOINED | TABLE_PER_CLASS |
| --- | --- | --- | --- |
| Tables | 1 | N (per class) | N (per concrete) |
| NULL columns | Many | None | None |
| Query speed | Fastest | JOIN required | UNION for poly |
| Normalized | No | Yes | Partial |
| Polymorphic | Native | JOIN | UNION |

---

## Reflection: Choosing an Inheritance Strategy

<div class="highlight-box">
<p>There is no universally best inheritance strategy. Which would you choose for a real project — and why? Consider query performance, schema evolution, nullability, and team familiarity. When would you change your mind?</p>
</div>

---

## Value Objects with @Embeddable

Value objects have no identity - they are defined solely by their attributes.

```java
@Embeddable
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;

    // Required: no-arg constructor
    public Address() {}

    public Address(String street, String city, String zip, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zip;
        this.country = country;
    }
    // getters...
}
```

---

## Using @Embedded

```java
@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street", column = @Column(name = "parent_street")),
        @AttributeOverride(name = "city",   column = @Column(name = "parent_city")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "parent_zip")),
        @AttributeOverride(name = "country", column = @Column(name = "parent_country"))
    })
    private Address parentAddress;
    // ...
}
```

---

## Value Object Examples

```java
@Embeddable
public class Money {
    private BigDecimal amount;
    private String currency; // ISO 4217 (EUR, USD)

    public Money() {}
    public Money(BigDecimal amount, String currency) { ... }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency))
            throw new IllegalArgumentException("Currency mismatch");
        return new Money(this.amount.add(other.amount), this.currency);
    }
}

@Embeddable
public class Email {
    @Column(name = "email_address")
    private String value;

    public Email() {}
    public Email(String value) {
        if (!value.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        this.value = value;
    }
}
```

---

## Repository Pattern

A Repository mediates between the domain and data mapping layers.

```java
public interface Repository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
    long count();
}
```

<div class="highlight-box"><p>The Repository pattern provides a collection-like interface for domain objects.</p></div>

---

## Generic Repository Implementation

```java
public class JpaRepository<T, ID> implements Repository<T, ID> {

    private final EntityManager em;
    private final Class<T> entityClass;

    public JpaRepository(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        var cb = em.getCriteriaBuilder();
        var query = cb.createQuery(entityClass);
        query.select(query.from(entityClass));
        return em.createQuery(query).getResultList();
    }

    @Override
    public T save(T entity) {
        if (em.contains(entity)) {
            return em.merge(entity);
        } else {
            em.persist(entity);
            return entity;
        }
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
    // ...
}
```

---

## Transaction Management

```java
public class StudentService {
    private final Repository<Student, Long> studentRepo;
    private final EntityManager em;

    public StudentService(EntityManager em,
                          Repository<Student, Long> studentRepo) {
        this.em = em;
        this.studentRepo = studentRepo;
    }

    public void transferStudent(Long studentId, Course from, Course to) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Student student = studentRepo.findById(studentId);
            student.removeCourse(from);
            student.addCourse(to);
            studentRepo.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Transfer failed", e);
        }
    }
}
```

---

## Summary

<div class="highlight-box">
<ul>
<li>Three inheritance strategies: SINGLE_TABLE, JOINED, TABLE_PER_CLASS</li>
<li>Each strategy has different trade-offs for schema and performance</li>
<li>@Embeddable/@Embedded model value objects without identity</li>
<li>Repository pattern provides clean, type-safe data access</li>
<li>Use EntityTransaction for explicit transaction boundaries</li>
</ul>
</div>
