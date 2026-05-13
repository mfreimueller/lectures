# Kata 5: Stream Pipeline with Peek

| Field | Value |
|-------|-------|
| Concepts | peek, stream debugging, intermediate operations, pipeline analysis |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Write a complex stream pipeline that processes a list of `Transaction` objects.

Define `Transaction` record with `String customerName`, `double amount`, `String currency`.

Pipeline steps:
1. Filter transactions with amount > 100
2. Map to customer name
3. Sort alphabetically
4. Collect to a list

Use `peek()` at each stage to print intermediate results for debugging purposes.

Then implement a custom `DebugCollector` that logs each element as it is added to the result collection.

### Extension

Create a generic `DebugCollector<T>` that accepts a `Consumer<T>` logging function and reports when elements are added, enabling conditional breakpoints in streams.
