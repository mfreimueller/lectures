# Kata 2: Parallel Stream Benchmarking

| Field | Value |
|-------|-------|
| Concepts | Parallel Stream, ForkJoinPool, Performance Measurement, Spliterator |
| Difficulty | 3/5 |
| Duration | approx. 35 min |

### Task

Write a benchmark that compares sequential vs. parallel stream processing on different data sizes.

1. Implement a CPU-intensive operation (e.g., checking for prime numbers)
2. Create a `BenchmarkResult` record with label, size, sequential time, parallel time, and speedup factor
3. Test on at least 5 different data sizes (e.g., 100, 1.000, 10.000, 100.000, 1.000.000)
4. Warm up the JVM before measuring (run the operation once without timing)
5. Print a formatted table with results

### Example Output

```
=== Parallel Stream Benchmark ===
Operation: isPrime (CPU-intensive)

| Test                              |    Size |      Seq |      Par | Speedup |
|-----------------------------------|---------|----------|----------|---------|
| isPrime range(0, 100)             |     100 |      2ms |      8ms |   0.25x |
| isPrime range(0, 1.000)           |   1.000 |     12ms |     10ms |   1.20x |
| isPrime range(0, 10.000)          |  10.000 |     85ms |     35ms |   2.43x |
| isPrime range(0, 100.000)         | 100.000 |    920ms |    280ms |   3.29x |
| isPrime range(0, 1.000.000)       |1.000.000|  10250ms |   2850ms |   3.60x |
```

### Extension

1. Compare with different `ForkJoinPool` parallelism levels (1, 2, 4, 8)
2. Compare a CPU-heavy operation vs. a lightweight operation (e.g., `n % 2 == 0`) — observe when parallelization hurts
3. Use `System.nanoTime()` instead of `currentTimeMillis()` for more precise measurements
