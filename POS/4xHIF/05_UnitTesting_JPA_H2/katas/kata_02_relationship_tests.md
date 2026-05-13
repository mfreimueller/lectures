# Kata 2: Relationship Tests

| Field | Value |
|-------|-------|
| Concepts | cascade, lazy loading, bidirectional helpers |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write tests for the Member → Loan → Book relationship:

1. **cascadePersist()** — Create a Member, add 2 Loans via `addLoan()`, save the Member. Verify Loans are persisted automatically.
2. **cascadeDelete()** — Save a Member with Loans. Delete the Member. Verify Loans are also deleted.
3. **noCascadeDeleteFromBook()** — Delete a Book that has Loans. Verify Loans remain (with null book reference, depending on configuration).
4. **lazyLoadingWorks()** — Use `@Transactional` to load a Member, access their loans list without LazyInitializationException.

### Example

```java
@Test
void cascadePersist_shouldSaveLoansWithMember() {
    Member member = new Member("Alice");
    member.addLoan(new Loan(book1));
    member.addLoan(new Loan(book2));
    memberRepo.save(member);

    assertThat(loanRepo.findAll()).hasSize(2);
}
```

### Extension

Test what happens when `orphanRemoval = true` is set on the `@OneToMany` annotation.
