---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 21 - Exercise, JPA, Repository
## POS - 3xHIF

---

## Agenda (1/2)

1. JPA Recap - Entities and Relationships
2. JPA Recap - Inheritance and Value Objects
3. Exercise: School Management Data Layer
4. Domain Model

---

## Agenda (2/2)

5. Testing with H2
6. Deliverables

---

## Learning Objectives

- I can define JPA entity classes with inheritance strategies
- I can model relationships using @OneToMany, @ManyToMany, and @OneToOne
- I can create embeddable value objects for Address, Email, and Money
- I can implement generic and concrete Repository interfaces
- I can write integration tests using H2 in-memory database

---

## JPA Recap - Entities and Relationships

- @Entity, @Id, @GeneratedValue for entity mapping
- EntityManager: persist(), find(), createQuery(), remove()
- JPQL queries entities with dot-notation navigation
- Relationships: @OneToOne, @OneToMany/@ManyToOne, @ManyToMany
- Cascade types control operation propagation

---

## JPA Recap - Inheritance and Value Objects

- SINGLE_TABLE: one table, discriminator column, nullable columns
- JOINED: normalized tables, JOIN for queries
- TABLE_PER_CLASS: separate tables, UNION for polymorphic queries
- @Embeddable/@Embedded for value objects (Address, Money, Email)
- Repository pattern with generic type-safe CRUD

---

## Exercise: School Management Data Layer

Build a complete data layer for a school management system using JPA with H2 in-memory database.

- **Domain:** Students, Teachers, Courses, Enrollments, Electives
- **Inheritance:** Person base with Student and Teacher subclasses
- **Value Objects:** Address, Email, Money (for teacher salary)
- **Relationships:** @ManyToMany (students->electives), @OneToMany (course->enrollments)
- **Testing:** H2 in-memory database with integration tests

---

## Reflection: How do you approach a complex domain model?

<div class="highlight-box">
<p>Why start with entities before repositories? What happens if you define queries before you understand the relationships between your domain objects?</p>
</div>

---

## Domain Model

```java
// Inheritance: Person -> Student, Teacher
// Value Objects: Address, Email (embeddable)
// Relationships:
//   Course 1---* Enrollment *---1 Student
//   Student *---* Elective
//   Teacher *---1...* Course

Repository<T, ID> (interface)
  +-- JpaRepository<T, ID> (generic impl)
  +-- StudentRepository (extends JpaRepository)
  +-- TeacherRepository (extends JpaRepository)
  +-- CourseRepository (extends JpaRepository)
```

---

## Now Kata 1: Entity Layer

Define all entity classes for a school management system with inheritance, value objects, and relationships.

---

## Testing with H2

```java
// persistence.xml for H2 testing
<persistence-unit name="school-test">
    <properties>
        <property name="jakarta.persistence.jdbc.url"
                  value="jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"/>
        <property name="jakarta.persistence.jdbc.user" value="sa"/>
        <property name="jakarta.persistence.jdbc.password" value=""/>
        <property name="hibernate.hbm2ddl.auto" value="create-drop"/>
        <property name="hibernate.dialect"
                  value="org.hibernate.dialect.H2Dialect"/>
    </properties>
</persistence-unit>
```

---

## Now Kata 2: Repository Layer

Implement a Repository layer with generic JpaRepository and custom JPQL query methods.

---

## Deliverables

- Entity classes with proper annotations and relationships
- Embeddable value objects (Address, Email)
- Repository interface and generic implementation
- Concrete repositories for Student, Teacher, Course
- Integration tests verifying CRUD, relationships, queries

---

## Now Kata 3: Integration Tests

Write JUnit Jupiter integration tests for the Repository layer using H2 in-memory database.
