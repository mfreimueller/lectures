# Kata 2: Relationships

| Field | Value |
|-------|-------|
| Concepts | @OneToMany, @ManyToOne, cascade, fetch |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Add `Member` and `Loan` entities to the library domain:

1. **Member**: id (auto), name (String), email (String), `@OneToMany` loans
2. **Loan**: id (auto), borrowDate (LocalDate), returnDate (LocalDate, nullable), `@ManyToOne` book, `@ManyToOne` member
3. Configure cascade:
   - Saving a Member should cascade to its Loans
   - Deleting a Book should NOT delete Loans referencing it
4. Create repositories: `MemberRepository`, `LoanRepository`
5. Test: create a Member, create a Book, create a Loan linking them, verify the relationship works

### Questions to Consider

- Should the relationship be bidirectional? When would you use `mappedBy`?
- What happens if you delete a Member that has active Loans?
- Why is `LAZY` the default fetch type for `@OneToMany`?

### Extension

Add a `@ManyToMany` relationship between Book and Category with a join table.
