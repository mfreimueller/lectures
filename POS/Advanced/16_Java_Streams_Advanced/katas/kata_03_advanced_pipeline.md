# Kata 3: Advanced Pipeline

| Field | Value |
|-------|-------|
| Concepts | groupingBy, teeing, takeWhile, dropWhile, flatMapping, Collectors |
| Difficulty | 4/5 |
| Duration | approx. 45 min |

### Task

Build a multi-stage stream pipeline on a financial transaction dataset using advanced collectors and stateful intermediate operations.

1. Generate a list of `Transaction` objects (id, date, category, amount, currency) — at least 500 entries with random data across 12 months
2. Use `groupingBy` with downstream collectors to compute total spending per category
3. Use `teeing()` to compute **both** total and average per category in a single pass
4. Use `takeWhile` to find the top categories that exceed a certain threshold
5. Use `dropWhile` to skip transactions before a certain date
6. Build a monthly report using nested `groupingBy` + `teeing` + `takeWhile`

### Example Output

```
=== Ausgaben pro Kategorie ===
  Food           : EUR 12450.32
  Transport      : EUR 8231.45
  Entertainment  : EUR 5421.78
  Utilities      : EUR 3200.10
  Shopping       : EUR 9876.54

=== Top 3 Kategorien (takeWhile > 5000) ===
  Food, Transport, Shopping

=== Monatsbericht (groupingBy + teeing) ===
  JANUARY   : EUR 3450.12
  FEBRUARY  : EUR 2890.45
  ...
```

### Extension

Add `flatMapping` to collect all unique currencies used per category. Then use `Gatherers.windowFixed(3)` (Java 22+) to group transactions into batches of 3 and compute the rolling average per batch.
