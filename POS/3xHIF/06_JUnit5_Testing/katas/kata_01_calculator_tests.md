# Kata 1: Calculator Tests

| Field | Value |
|-------|-------|
| Concepts | JUnit 5, @Test, assertEquals, assertTrue |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Create a `Calculator` class with the following methods:
- `int add(int a, int b)`
- `int subtract(int a, int b)`
- `int multiply(int a, int b)`
- `int divide(int a, int b)` -- throws `ArithmeticException` when dividing by zero

Then write a `CalculatorTest` class using JUnit 5 that tests all four methods. Include edge cases like negative numbers and division by zero.

### Example Output

```
Tests passed: 6/6
  - testAddPositive
  - testAddNegative
  - testSubtract
  - testMultiply
  - testDivide
  - testDivideByZero
```

### Extension

Add a `modulo` method and write tests for it.
