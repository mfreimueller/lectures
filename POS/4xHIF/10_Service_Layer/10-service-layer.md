---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 10 - Service Layer
## POS - 4xHIF

---

## Layered Architecture Recap

```
Controller (REST-Endpunkte)
    ↓
Service (Geschäftslogik)
    ↓
Repository (Datenbankzugriff)
```

- Jede Schicht hat eine klare Verantwortung
- Service = die "Brain"-Schicht
- Repository = nur Speicher, keine Logik
- Controller = nur HTTP, keine Logik

---

## Was gehört in den Service?

- Geschäftslogik und Validierung
- Orchestrierung mehrerer Repositories
- Transaktionsgrenzen
- Berechtigungsprüfungen
- Mapping zwischen Domain und DTOs

<div class="highlight-box">
<p>NICHT im Service: HTTP-Details, Serialisierung, UI-Logik</p>
</div>

---

## Ohne Service — Anemic Domain Model

```java
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        if (book.getIsbn() == null || book.getIsbn().isBlank()) {
            throw new IllegalArgumentException("ISBN required");
        }
        return bookRepository.save(book);
    }
}
```

Geschäftslogik im Controller = nicht testbar, nicht wiederverwendbar.

---

## Mit Service

```java
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(CreateBookCommand command) {
        if (bookRepository.findByIsbn(command.isbn()).isPresent()) {
            throw new DuplicateIsbnException(command.isbn());
        }
        Book book = new Book(command.isbn(), command.title(), command.year());
        return bookRepository.save(book);
    }
}
```

---

## @Service — Stereotype

- `@Service` ist ein Spezialfall von `@Component`
- Wird vom Component-Scanning erkannt
- Macht semantisch klar: "Hier ist die Business-Logik"
- Ermöglicht AOP (z.B. @Transactional, @Cacheable)

---

## Constructor Injection

```java
@Service
public class LibraryService {

    // Final = unveränderlich, klar erkennbare Abhängigkeiten
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;

    // Spring injiziert automatisch über den Konstruktor
    public LibraryService(BookRepository bookRepository,
                          MemberRepository memberRepository,
                          LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
    }
}
```

Besser als `@Autowired` auf Feldern — testbar, final, explizit.

---

## @Transactional — Warum?

```java
@Service
public class LibraryService {

    public Loan checkOutBook(Long memberId, Long bookId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException(bookId);
        }

        Loan loan = new Loan(book, member, LocalDate.now());
        loanRepository.save(loan);
        return loan;
    }
}
```

Was passiert, wenn `loanRepository.save()` fehlschlägt, aber `bookRepository.findById()` schon gelaufen ist?

---

## @Transactional — Lösung

```java
@Service @Transactional
public class LibraryService {
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() { ... }
    public Loan checkOutBook(Long memberId, Long bookId) { }
}
```

- Entweder alles oder nichts — ACID
- Default: rollback für RuntimeExceptions
- `readOnly = true` optimiert Lese-Transaktionen

---

## Command Objects

```java
// Statt vieler Parameter
public record CreateBookCommand(
    @NotBlank String isbn,
    @NotBlank String title,
    @Min(1900) int year,
    String authorName
) {}

// Besser: 1 Parameter-Objekt statt 4+ Einzelparametern
public Book createBook(CreateBookCommand command) {
    // ...
}

// Aufruf
bookService.createBook(
    new CreateBookCommand("978-3-16-148410-0", "DDD", 2003, null)
);
```

---

## Command Objects — Vorteile

- Änderungen an Parametern = Änderungen am Record, nicht an der Signatur
- Validierung direkt im Command möglich (`@NotBlank`, `@Email`, ...)
- Bessere Lesbarkeit beim Aufruf
- Leicht erweiterbar (neue Felder = neues Feld im Record)

---

## Projekt: Service Layer

<div class="highlight-box">
<ol>
<li>Erstelle <code>LibraryService</code> mit Constructor Injection</li>
<li>Implementiere CRUD-Methoden für Book, Member, Loan</li>
<li>Füge <code>@Transactional</code> hinzu</li>
<li>Erstelle Command-Objekte für komplexe Operationen</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>Service Layer = Geschäftslogik-Schicht</li>
<li>@Service + Constructor Injection</li>
<li>@Transactional für zusammengesetzte Operationen</li>
<li>Command Objects für komplexe Parameter</li>
</ul>
</div>
