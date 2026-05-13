# Kata 5: Full SOLID Refactoring

| Field | Value |
|-------|-------|
| Concepts | LSP, ISP, DIP combined refactoring |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Given a monolithic `Printer` class that violates multiple SOLID principles:

Answer:
1. Which SOLID principles are violated and why?

Refactor:
1. Split into focused interfaces: `Printable`, `Scannable`, `Faxable`
2. Create `BasicPrinter` (print only) and `MultiFunctionPrinter` (print + scan + fax)
3. Inject dependencies (`DocumentStorage`, `NetworkManager`) via constructor

### Extension

Write JUnit 5 unit tests for each refactored class.
