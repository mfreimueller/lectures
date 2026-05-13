# Kata 1: Mocking Basics

| Field | Value |
|-------|-------|
| Concepts | @Mock, @InjectMocks, MockitoExtension, when/thenReturn |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create a `LibraryServiceTest` using Mockito:

```java
@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private LibraryService libraryService;
}
```

Write these tests:

1. **registerMember_shouldSaveAndReturnMember()**
   - Mock `memberRepository.save()` to return a member with id=1
   - Call `libraryService.registerMember("Alice", "alice@example.com")`
   - Assert the returned member is not null and has the correct name

2. **findAllBooks_shouldReturnAllBooks()**
   - Create a list of 2 books
   - Mock `bookRepository.findAll()` to return that list
   - Call `libraryService.findAllBooks()`
   - Assert the result has size 2

3. **findBookById_notFound_shouldThrow()**
   - Mock `bookRepository.findById(99L)` to return `Optional.empty()`
   - Assert that `libraryService.findBookById(99L)` throws `EntityNotFoundException`

### Example

```java
@Test
void registerMember_shouldSaveAndReturnMember() {
    when(memberRepository.save(any())).thenReturn(new Member(1L, "Alice", "alice@example.com"));

    Member result = libraryService.registerMember("Alice", "alice@example.com");

    assertThat(result.getName()).isEqualTo("Alice");
}
```

### Extension

Add a test for duplicate email detection: mock `memberRepository.findByEmail()` to return an existing member and assert the exception message.
