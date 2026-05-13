# Kata 4: Custom Collector

| Field | Value |
|-------|-------|
| Concepts | Collector interface, custom collector, statistics |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Implement a custom `StatisticsCollector` that collects statistics from a numeric stream.

Create:
- `StatisticsResult` record with `long count`, `double sum`, `double min`, `double max`, `double average`
- A `Collector<Double, StatisticsCollector, StatisticsResult>` with proper:
  - `supplier()` -- creates a new accumulator
  - `accumulator()` -- adds a single element
  - `combiner()` -- merges two accumulators (for parallel streams)
  - `finisher()` -- converts accumulator to final result

### Extension

Add a `toString()` method to `StatisticsResult` that returns a formatted summary like:
`Count: 5, Sum: 150.0, Min: 10.0, Max: 50.0, Avg: 30.0`
