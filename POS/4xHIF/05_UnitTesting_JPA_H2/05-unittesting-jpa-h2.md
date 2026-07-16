---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 05 - Unit Testing JPA with H2
## POS - 4xHIF

---

## Why Test Repositories?

- Verify your JPA mappings actually work
- Catch regression when schema changes
- Test custom queries against real SQL
- Run in CI — no real database needed

---

## @DataJpaTest

- A "slice test" — only loads JPA-related beans
- Auto-configures H2 in-memory database
- Rolls back after each test (transactional)
- Injects TestEntityManager for additional control

---

## Test Setup

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

## Testing CRUD

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

## Testing Relationships

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

## Testing Custom Queries

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

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>@DataJpaTest for repository slice tests</li>
<li>H2 in-memory database for testing</li>
<li>Testing CRUD, relationships, and custom queries</li>
<li>Test isolation and @Transactional rollback</li>
</ul>
</div>
