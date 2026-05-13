# Kata 2: Transactional Service

| Field | Value |
|-------|-------|
| Concept | @Transactional, composite operations, rollback |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Add a `checkOutBook(Long memberId, Long bookId)` method to `LibraryService`:

1. Validate that the member exists
2. Validate that the book exists and is not currently borrowed
3. Create a new `Loan` with borrowDate = today, returnDate = null
4. Save the loan
5. Return the loan

Annotate the method with `@Transactional`:

```java
@Transactional
public Loan checkOutBook(Long memberId, Long bookId) {
    // 1. Find member or throw
    // 2. Find book or throw
    // 3. Check if book is already borrowed
    // 4. Create and save Loan
    // 5. Return loan
}
```

Also implement:
- `void returnBook(Long loanId)` — set returnDate to today
- `List<Loan> findActiveLoansByMember(Long memberId)` — all loans with null returnDate

### Questions to Consider

- What happens if step 4 fails after step 2 and 3 have already modified data?
- Why is `@Transactional` important for `checkOutBook()`?
- When would you use `@Transactional(readOnly = true)`?

### Extension

Use `@Transactional(rollbackFor = CustomException.class)` to roll back on checked exceptions. Create a `BookNotAvailableException` and test that the transaction rolls back when this exception is thrown.
