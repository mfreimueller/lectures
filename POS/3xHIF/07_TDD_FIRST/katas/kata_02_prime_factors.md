# Kata 2: Prime Factors

| Field | Value |
|-------|-------|
| Concepts | TDD, parameterized tests, prime factorization |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Use TDD to implement a method `List<Integer> primeFactors(int n)` that returns the prime factors of a number in ascending order.

Use parameterized tests to drive the implementation.

### Example Output

```
primeFactors(1) -> []
primeFactors(2) -> [2]
primeFactors(3) -> [3]
primeFactors(4) -> [2, 2]
primeFactors(6) -> [2, 3]
primeFactors(12) -> [2, 2, 3]
```

### Extension

Handle edge cases like negative numbers (throw IllegalArgumentException).
