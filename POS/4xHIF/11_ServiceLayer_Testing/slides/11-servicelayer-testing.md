---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 11 - Service Layer Testing
## POS - 4xHIF

---

## Unit vs. Integration Tests

|  | Unit-Test | Integration-Test |
| --- | --- | --- |
| Scope | Eine Klasse | Mehrere Schichten |
| Abhängigkeiten | Gemosst | Echt |
| Geschwindigkeit | Millisekunden | Sekunden |
| Datenbank | Nein | Ja |
| Fehlerort | Exakt | Indirekt |

Service-Tests = Unit-Tests mit gemockten Repositories.

---

## Warum Repositories mocken?

- Repository ist schon getestet (Week 05 + 08)
- Service-Logik isoliert testen (nur die Business-Regeln)
- Kein Testcontainers nötig → Tests sind schnell
- Fehler im Service sind sofort sichtbar (nicht im DB-Layer versteckt)

---

## Mockito Annotations

```java
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {
    @Mock BookRepository bookRepository;
    @Mock LoanRepository loanRepository;
    @InjectMocks LibraryService libraryService;
}
```

- `@Mock` — erzeugt einen Mock
- `@InjectMocks` — erzeugt das Service-Objekt und injiziert die Mocks

---

## Stubbing — when/thenReturn

```java
@Test
void findAllBooks_shouldReturnAllBooks() {
    List<Book> expected = List.of(
        new Book("978-3-16-148410-0", "DDD", 2003),
        new Book("978-0-13-468599-1", "Clean Code", 2008)
    );

    when(bookRepository.findAll()).thenReturn(expected);

    List<Book> actual = libraryService.findAllBooks();

    assertEquals(2, actual.size());
    assertEquals(expected, actual);
}
```

---

## doThrow — Exception-Szenarien

```java
@Test
void createBook_withDuplicateIsbn_shouldThrow() {
    CreateBookCommand command = new CreateBookCommand(
        "978-3-16-148410-0", "DDD", 2003);

    when(bookRepository.findByIsbn(command.isbn()))
        .thenReturn(Optional.of(new Book()));

    assertThrows(DuplicateIsbnException.class,
        () -> libraryService.createBook(command));
}
```

---

## verify — Interaktion prüfen

```java
@Test
void deleteBook_shouldCallRepository() {
    Long bookId = 1L;

    when(bookRepository.existsById(bookId)).thenReturn(true);

    libraryService.deleteBook(bookId);

    // Prüfen, dass deleteById() aufgerufen wurde
    verify(bookRepository).deleteById(bookId);
}

@Test
void deleteBook_nonExistent_shouldNotCallDelete() {
    Long bookId = 99L;

    when(bookRepository.existsById(bookId)).thenReturn(false);

    assertThrows(EntityNotFoundException.class,
        () -> libraryService.deleteBook(bookId));

    // Prüfen, dass deleteById() NIEMALS aufgerufen wurde
    verify(bookRepository, never()).deleteById(any());
}
```

---

## ArgumentCaptor

```java
@Test
void createBook_shouldSaveCorrectEntity() {
    CreateBookCommand command = new CreateBookCommand(
        "978-3-16-148410-0", "Domain-Driven Design", 2003);

    libraryService.createBook(command);

    ArgumentCaptor captor = ArgumentCaptor.forClass(Book.class);
    verify(bookRepository).save(captor.capture());

    Book saved = captor.getValue();
    assertEquals("978-3-16-148410-0", saved.getIsbn());
    assertEquals("Domain-Driven Design", saved.getTitle());
    assertEquals(2003, saved.getYear());
}
```

Nützlich, um zu prüfen, WAS genau an das Repository übergeben wurde.

---

## @Transactional testen

```java
@Test
void checkOutBook_whenSaveFails_shouldRollback() {
    Long memberId = 1L;
    Long bookId = 1L;

    when(memberRepository.findById(memberId))
        .thenReturn(Optional.of(new Member()));
    when(bookRepository.findById(bookId))
        .thenReturn(Optional.of(new Book()));

    // Simuliere Fehler beim Speichern des Loans
    when(loanRepository.save(any()))
        .thenThrow(new RuntimeException("DB error"));

    assertThrows(RuntimeException.class,
        () -> libraryService.checkOutBook(memberId, bookId));

    // Prüfen: Keine Side-Effects
    verify(bookRepository, never()).save(any());
}
```

---

## Projekt: Service Tests

<div class="highlight-box">
<ol>
<li>Erstelle <code>LibraryServiceTest</code> mit MockitoExtension</li>
<li>Teste alle CRUD-Methoden (State-Tests)</li>
<li>Teste <code>checkOutBook()</code> (Behavior-Tests mit verify)</li>
<li>Teste Exception-Szenarien (Buch nicht verfügbar, Member nicht gefunden)</li>
</ol>
</div>

---

<div class="highlight-box">
<h2>What We Learned Today</h2>
<ul>
<li>@Mock, @InjectMocks, @ExtendWith(MockitoExtension.class)</li>
<li>when/thenReturn und doThrow zum Stubbing</li>
<li>verify(), times(), never() für Behavior-Tests</li>
<li>ArgumentCaptor für detaillierte Prüfungen</li>
<li>Exception-Szenarien testen</li>
</ul>
</div>
