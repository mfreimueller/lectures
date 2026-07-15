---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 04 - JPA Repositories
## POS - 4xHIF

---

## JPA Recap

- ORM = Object-Relational Mapping
- JPA = Jakarta Persistence API (specification)
- Hibernate = most popular JPA implementation
- Maps Java classes to database tables

---

## @Entity

```java
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    private int year;
    // getters, setters, constructors
}
```

---

## Spring Data Repository

```java
public interface BookRepository
    extends CrudRepository<Book, Long> {
    // Inherited methods:
    // save(entity), findById(id), findAll(),
    // count(), delete(entity), existsById(id)
}
```

Spring Data generates the implementation at runtime!

---

## CRUD Operations

```java
@Service
public class LibraryService {
    private final BookRepository bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Optional<Book> findBook(Long id) {
        return bookRepo.findById(id);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepo.findAll();
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
```

---

## @OneToMany / @ManyToOne

```java
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();
}

@Entity
public class Loan {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
```

---

## Bidirectional Relationship

Helper methods keep both sides consistent:

```java
@Entity
public class Member {
    // ...

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setMember(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setMember(null);
    }
}
```

---

## Cascade Types

| Cascade | Effect |
| --- | --- |
| PERSIST | Save parent → save children |
| MERGE | Update parent → update children |
| REMOVE | Delete parent → delete children |
| ALL | All of the above |

```java
@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
// but be careful: do you always want to delete Loans with Member?
```

---

## Fetch Strategies

| Fetch Type | Behavior |
| --- | --- |
| LAZY (default for @OneToMany) | Loaded on demand (proxy) |
| EAGER (default for @ManyToOne) | Loaded immediately |

Watch out for the **N+1 problem**:

```java
// 1 query for members + N queries for loans = N+1!
for (Member m : memberRepo.findAll()) {
    m.getLoans().size();  // triggers lazy load
}
```

---

## Custom Queries

```java
public interface BookRepository
    extends JpaRepository<Book, Long> {

    // Derived query (Spring Data parses method name)
    List<Book> findByAuthorName(String authorName);

    // JPQL query
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitle(@Param("keyword") String keyword);

    // Native SQL query
    @Query(value = "SELECT * FROM books WHERE year > :year",
           nativeQuery = true)
    List<Book> findBooksAfterYear(@Param("year") int year);
}
```

---

## Project: Apply JPA to Your Domain

- Add `@Entity` to ALL your domain classes
- Configure relationships with correct cascade/fetch
- Create Repository interfaces for each aggregate root
- Add helper methods for bidirectional relationships

Next week: Unit testing your repositories with H2!

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>JPA entity mapping with @Entity, @Id</li>
<li>Spring Data Repositories for CRUD</li>
<li>@OneToMany, @ManyToOne, cascade &amp; fetch</li>
<li>Derived queries and @Query</li>
</ul>
</div>
