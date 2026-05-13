# Kata 2: OCP -- Reporting System

| Field | Value |
|-------|-------|
| Concepts | OCP, interfaces, polymorphism |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

You have a `ReportGenerator` that only generates text reports. Apply OCP by introducing a `ReportFormatter` interface so new formats can be added without modifying existing code.

Create:
1. A `ReportFormatter` interface with method `String format(String title, String content)`
2. A `TextFormatter` implementation
3. An `HtmlFormatter` implementation
4. A `CsvFormatter` implementation
5. Modify `ReportGenerator` to accept any `ReportFormatter`

Answer:
1. Why does `ReportGenerator` violate OCP?

### Example Output

```
Title: Sales Report
Content: Q1 revenue increased by 20%

Text format:
=== Sales Report ===
Q1 revenue increased by 20%

HTML format:
<h1>Sales Report</h1>
<p>Q1 revenue increased by 20%</p>
```

### Extension

Add a `JsonFormatter` without modifying any existing classes.
