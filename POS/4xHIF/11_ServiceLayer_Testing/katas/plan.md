# Katas - Week 11: ServiceLayer_Testing

## K1: Mocking Basics
**Concepts:** @Mock, @InjectMocks, MockitoExtension, when/thenReturn
**Task:** Write a `LibraryServiceTest` that tests `registerMember()`, `addBook()`, and `getAllBooks()`. Mock the repositories and verify correct delegation.
**Duration:** 20 min

## K2: Behavior Verification
**Concepts:** verify(), ArgumentCaptor, @Transactional
**Task:** Test `checkOutBook()`: mock both BookRepository and LoanRepository. Verify that save was called with correct arguments. Test that an exception triggers rollback (no save).
**Duration:** 25 min
