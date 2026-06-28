# Exercise: Refactoring an Invoice System (Post-SOLID)

**Type:** Refactoring (Type 1) — Given a working but poorly designed codebase, students refactor it to follow SOLID principles.

**Domain:** Invoice System (Invoice, InvoiceItem, Customer, Payment) — intentionally different from the e-commerce theme used in katas.

**Assigned:** Week 11 (after SOLID Part 2)
**Due:** Before PLÜ 2 (Week 14)

---

## Objective

You receive a working invoice management system. It compiles, runs, and produces correct results. But it is **terribly designed** — it violates every single SOLID principle. Your job is to:

1. Identify each violation
2. Write tests to secure the existing behavior
3. Refactor step by step
4. Submit your refactored code as a PR for peer review

---

## The Codebase

The starter code is available as a Maven module in the live-coding repo: `exercise-solid-refactoring`.

It implements a simple invoice system with the following features:
- Create invoices with line items
- Calculate totals (subtotal, tax, discount, total)
- Process payments (credit card, PayPal, bank transfer)
- Print invoices (plain text, HTML)
- Save/load invoices from a file
- Send invoice notifications

The codebase contains **~12 classes** with deliberate violations of all 5 SOLID principles.

---

## SOLID Violations to Find & Fix

### SRP (Single Responsibility Principle)
- Look for classes that do too many things (calculate + format + persist + notify)
- Each class should have one reason to change

### OCP (Open-Closed Principle)
- Look for `if-else` chains that check types or strings to decide behavior
- These should be replaced with polymorphism (interfaces, strategy pattern)

### LSP (Liskov Substitution Principle)
- Look for subclasses that break the contract of their parent
- Check for overridden methods that throw exceptions, return incompatible values, or change behavior unexpectedly

### ISP (Interface Segregation Principle)
- Look for "fat" interfaces that force implementers to define methods they don't need
- Split into smaller, focused interfaces

### DIP (Dependency Inversion Principle)
- Look for classes that instantiate their dependencies with `new`
- Replace with constructor injection against abstractions

---

## Requirements

1. **Write tests first** — Before changing any production code, write tests that capture the current behavior. Use JUnit 5 + AssertJ.
2. **Refactor incrementally** — Fix one principle at a time. Run tests after each change.
3. **Document your decisions** — In your PR description, explain:
   - Which violations you found
   - What you changed and why
   - How you tested each refactoring step
4. **Code review** — Review another student's PR. Leave at least 5 meaningful comments.

---

## Evaluation Criteria

| Criterion | Points |
|-----------|--------|
| All SOLID violations identified and fixed | 40% |
| Tests written before refactoring (TDD approach) | 20% |
| Code is clean, readable, and well-structured | 20% |
| PR documentation explains decisions | 10% |
| Constructive peer code review | 10% |

---

## Hints

- Start with SRP — it's usually the most obvious violation
- Use the existing tests (if any) as a safety net, but write more
- Don't try to fix everything at once — one principle per refactoring pass
- Remember: the code works. Your tests must prove it still works after each change
