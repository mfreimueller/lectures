# Kata 1: FizzBuzz

| Field | Value |
|-------|-------|
| Concepts | TDD, Red-Green-Refactor, JUnit 5 |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Implement the FizzBuzz problem using strict TDD (Red-Green-Refactor cycle).

Write a method `String fizzBuzz(int n)` that returns:
- `"Fizz"` when n is divisible by 3
- `"Buzz"` when n is divisible by 5
- `"FizzBuzz"` when n is divisible by both 3 and 5
- The number as a string otherwise

Follow the TDD cycle: write the test first, then the implementation.

### Example Output

```
fizzBuzz(1) -> "1"
fizzBuzz(3) -> "Fizz"
fizzBuzz(5) -> "Buzz"
fizzBuzz(15) -> "FizzBuzz"
```

### Extension

Add support for additional divisors: fizzBuzz(7) returns "Bang", fizzBuzz(21) returns "FizzBang".
