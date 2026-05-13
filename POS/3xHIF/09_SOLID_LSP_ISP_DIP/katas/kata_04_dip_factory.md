# Kata 4: DIP with Factory Pattern

| Field | Value |
|-------|-------|
| Concepts | DIP, Factory pattern, dependency injection, abstraction |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Refactor a `ReportGenerator` that directly creates `PdfReport` and `ExcelReport` to depend on a `Report` abstraction.

Steps:
1. Define a `Report` interface with `String generate()` and `String getFormat()`
2. Implement `PdfReport` and `ExcelReport` that implement `Report`
3. Create a `ReportFactory` that creates the correct implementation based on a format string
4. The `ReportGenerator` should depend on the `Report` abstraction (DIP)
5. High-level modules should not depend on low-level concrete classes

### Extension

Add a `CsvReport` implementation without modifying any existing classes (open-closed principle).
