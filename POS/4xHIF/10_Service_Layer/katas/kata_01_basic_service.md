# Kata 1: Basic Service

| Field | Value |
|-------|-------|
| Concepts | @Service, constructor injection, CRUD delegation |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create a `LibraryService` with constructor injection:

```java
@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanRepository loanRepository;

    public LibraryService(/* inject all three repositories */) {
        // constructor
    }
}
```

Implement these methods:

1. **Member management:**
   - `Member registerMember(String name, String email)` — save a new member
   - `List<Member> findAllMembers()` — return all members
   - `Member findMemberById(Long id)` — throw if not found

2. **Book management:**
   - `Book addBook(String isbn, String title, int year)` — save a new book
   - `List<Book> findAllBooks()` — return all books
   - `Book findBookById(Long id)` — throw if not found

### Extension

Add validation: check that email is not duplicate before saving a member. Throw an `IllegalArgumentException` if it already exists.
