# Kata 2: Behavior Verification

| Field | Value |
|-------|-------|
| Concepts | verify(), ArgumentCaptor, @Transactional |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Test the `checkOutBook()` method with behavior verification:

1. **checkOutBook_shouldSaveLoan()**
   ```java
   @Test
   void checkOutBook_shouldSaveLoan() {
       Long memberId = 1L;
       Long bookId = 1L;

       when(memberRepository.findById(memberId))
           .thenReturn(Optional.of(new Member(memberId, "Alice", "alice@test.com")));
       when(bookRepository.findById(bookId))
           .thenReturn(Optional.of(new Book(bookId, "123", "Test Book", 2024)));

       libraryService.checkOutBook(memberId, bookId);

       verify(loanRepository).save(any(Loan.class));
   }
   ```

2. **checkOutBook_shouldSaveCorrectLoan()** — Use `ArgumentCaptor`
   ```java
   ArgumentCaptor<Loan> captor = ArgumentCaptor.forClass(Loan.class);
   verify(loanRepository).save(captor.capture());
   Loan saved = captor.getValue();
   assertThat(saved.getMember().getId()).isEqualTo(memberId);
   assertThat(saved.getBook().getId()).isEqualTo(bookId);
   assertThat(saved.getBorrowDate()).isEqualTo(LocalDate.now());
   ```

3. **checkOutBook_whenBookNotAvailable_shouldThrow()**
   - Mock the book to already be borrowed (check with `findByBookIdAndReturnDateIsNull`)
   - Assert that `save()` was never called on `loanRepository`

4. **checkOutBook_whenSaveFails_shouldNotHaveSideEffects()**
   - Make `loanRepository.save()` throw a `RuntimeException`
   - Assert the exception propagates
   - Verify that no other side effects occurred

### Extension

Use `verify(loanRepository, times(1)).save(any())` and `verify(loanRepository, never()).delete(any())` to precisely assert interaction counts.
