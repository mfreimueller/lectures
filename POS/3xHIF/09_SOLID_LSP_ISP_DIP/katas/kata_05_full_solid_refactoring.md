# Kata 5: Full SOLID Refactoring

| Field | Value |
|-------|-------|
| Concepts | LSP, ISP, DIP combined refactoring |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Given a monolithic `Printer` class that violates multiple SOLID principles:

Violations:
- ISP: Fat interface with print, scan, fax methods that throw `UnsupportedOperationException`
- LSP: Subclasses cannot substitute parent because methods throw exceptions
- DIP: Depends on concrete classes for document storage and network communication

Refactor:
1. Split into focused interfaces: `Printable`, `Scannable`, `Faxable`
2. Create `BasicPrinter` (print only) and `MultiFunctionPrinter` (print + scan + fax)
3. Inject dependencies (`DocumentStorage`, `NetworkManager`) via constructor

### Extension

Write JUnit 5 unit tests for each refactored class.
