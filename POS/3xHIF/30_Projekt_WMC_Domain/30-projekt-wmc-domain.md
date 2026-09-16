---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 30 - Projekt WMC Domain
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: JPA Annotations
2. Review: EntityManager
3. 1:1 Relationship
4. 1:n Relationship
5. n:m Relationship

---

## Agenda (2/2)

6. JPA Inheritance: JOINED
7. Embeddable Value Objects
8. Repository Pattern
9. JPQL Queries
10. Entity Design Summary

---

## Learning Objectives

- I can map 1:1, 1:n, and n:m relationships using JPA annotations
- I can implement JPA inheritance with the JOINED strategy
- I can use @Embeddable value objects to reuse column groups across entities
- I can write JPQL queries for filtering, joining, and aggregating data
- I can design a complete entity model with relationships and inheritance

---

## Review: JPA Annotations

```java
@Entity
@Table(name = "books")
public class Book {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
}
```

---

## Review: EntityManager

```java
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
em.persist(entity);
em.getTransaction().commit();
em.close();
```

---

## 1:1 Relationship

```java
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}

@Entity
public class Address {
    @Id @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "address")
    private User user;
}
```

---

## 1:n Relationship

```java
@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();
}

@Entity
public class Book {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
```

---

## n:m Relationship

```java
@Entity
public class Book {
    @ManyToMany
    @JoinTable(name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();
}
```

---

## Reflection: Why Join Tables for n:m?

<div class="highlight-box">
<p>Why are separate join tables necessary for many-to-many relationships? What problems arise if you try to model n:m without a join table?</p>
</div>

---

## JPA Inheritance: JOINED

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Book {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String isbn;
}

@Entity
public class PhysicalBook extends Book {
    private String shelfLocation;
    private int copiesAvailable;
}

@Entity
public class EBook extends Book {
    private String fileFormat;
    private double fileSizeMb;
}
```

---

## Embeddable Value Objects

```java
@Embeddable
public class Money {
    private BigDecimal amount;
    private String currency;
}

@Entity
public class Book {
    @Embedded
    private Money price;
}
```

---

## Repository Pattern

```java
public class BookRepository {
    private final EntityManager em;

    public BookRepository(EntityManager em) { this.em = em; }

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class)
            .getResultList();
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    public Book save(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        return book;
    }
}
```

---

## JPQL Queries

```java
// Find by category
em.createQuery("SELECT b FROM Book b WHERE b.category.name = :cat", Book.class)
    .setParameter("cat", "Fiction")
    .getResultList();

// Find with join fetch
em.createQuery("SELECT b FROM Book b JOIN FETCH b.authors WHERE b.id = :id", Book.class)
    .setParameter("id", 1L)
    .getSingleResult();

// Count
em.createQuery("SELECT COUNT(b) FROM Book b", Long.class)
    .getSingleResult();
```

---

## Entity Design Summary

- User - Address (1:1)
- Category - Book (1:n)
- Book - Author (n:m via join table)
- Book - PhysicalBook / EBook (inheritance)
- User - Loan - Book (1:n on both sides)

---

## Summary

<div class="highlight-box">
<ul>
<li>Define all JPA entities with @Entity, @Table, @Id</li>
<li>Map 1:1 with @OneToOne, 1:n with @OneToMany/@ManyToOne</li>
<li>Implement inheritance with @Inheritance(JOINED)</li>
<li>Create repositories for each entity</li>
<li>Write JPQL queries for data access</li>
</ul>
</div>
