---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 04 - Unit Testing JPA mit H2
## POS - 4xHIF

---

## Warum Repositories testen?

- Überprüfen ob JPA Mappings tatsächlich funktionieren
- Regressionen bei Schemaänderungen erkennen
- Benutzerdefinierte Abfragen gegen echtes SQL testen
- In CI ausführen — keine echte Datenbank nötig

---

## @DataJpaTest

- Ein "Slice Test" — lädt nur JPA-beans
- Konfiguriert H2 In-Memory Datenbank automatisch
- Nach jedem Test zurückgesetzt (transaktional)
- Injected TestEntityManager für zusätzliche Kontrolle

---

## Test-Setup

```java
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        book1 = new Book("123-4", "Java Basics", 2020);
        book2 = new Book("567-8", "Spring Boot", 2022);
        bookRepo.saveAll(List.of(book1, book2));
    }
}
```

---

## CRUD testen

```java
@Test
void saveAndFindById_shouldWork() {
    Book saved = bookRepo.save(new Book("000", "Test", 2024));
    assertThat(saved.getId()).isNotNull();
    assertThat(bookRepo.findById(saved.getId())).isPresent();
}

@Test
void findAll_shouldReturnAllBooks() {
    assertThat(bookRepo.findAll()).hasSize(2);
}

@Test
void delete_shouldRemoveBook() {
    bookRepo.delete(book1);
    assertThat(bookRepo.findById(book1.getId())).isEmpty();
}
```

---

## Beziehungen testen

```java
@Test
void cascadePersist_shouldSaveLoans() {
    Member member = new Member("Alice");
    member.addLoan(new Loan(book1, LocalDate.now()));
    memberRepo.save(member);

    assertThat(loanRepo.count()).isEqualTo(1);
}

@Test
@Transactional
void lazyLoading_shouldWorkInTransaction() {
    Member member = memberRepo.findById(member1.getId()).get();
    assertThat(member.getLoans()).hasSize(2); // no LazyInitException
}
```

---

## Benutzerdefinierte Abfragen testen

```java
@Test
void searchByTitle_shouldFindMatches() {
    List<Book> result = bookRepo.searchByTitle("Java");
    assertThat(result)
        .hasSize(1)
        .extracting(Book::getTitle)
        .contains("Java Basics");
}

@Test
void searchByTitle_shouldReturnEmptyForNoMatch() {
    assertThat(bookRepo.searchByTitle("xyz"))
        .isEmpty();
}
```

---

## Was wir heute gelernt haben

- @DataJpaTest für Repository Slice Tests
- H2 In-Memory Datenbank zum Testen
- Testen von CRUD, Beziehungen und benutzerdefinierten Abfragen
- Testisolation und @Transactional Rollback
