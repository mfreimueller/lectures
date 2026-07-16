---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 03 - JPA Repositories
## POS - 4xHIF

---

## JPA Wiederholung

- ORM = Object-Relational Mapping
- JPA = Jakarta Persistence API (Spezifikation)
- Hibernate = beliebteste JPA Implementierung
- Mappt Java Klassen auf Datenbanktabellen

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

Spring Data generiert die Implementierung zur Laufzeit!

---

## CRUD Operationen

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

## Bidirektionale Beziehung

Hilfsmethoden halten beide Seiten konsistent:

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

## Cascade Typen

| Cascade | Wirkung |
| --- | --- |
| PERSIST | Elternteil speichern → Kinder speichern |
| MERGE | Elternteil aktualisieren → Kinder aktualisieren |
| REMOVE | Elternteil löschen → Kinder löschen |
| ALL | alles oben genannte |

```java
@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
// but be careful: do you always want to delete Loans with Member?
```

---

## Fetch Strategien

| Fetch Typ | Verhalten |
| --- | --- |
| LAZY (Standard für @OneToMany) | Bei Bedarf laden (Proxy) |
| EAGER (Standard für @ManyToOne) | Sofort laden |

Achtung vor dem **N+1 Problem**:

```java
// 1 query for members + N queries for loans = N+1!
for (Member m : memberRepo.findAll()) {
    m.getLoans().size();  // triggers lazy load
}
```

---

## Benutzerdefinierte Abfragen

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

## Was wir heute gelernt haben

- JPA Entity Mapping mit @Entity, @Id
- Spring Data Repositories für CRUD
- @OneToMany, @ManyToOne, Cascade & Fetch
- Abgeleitete Abfragen und @Query
