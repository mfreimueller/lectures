# Kata 4: String Calculator (TDD)

| Field | Value |
|-------|-------|
| Concepts | TDD, Red-Green-Refactor, JUnit 5, incremental development |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Implement a `StringCalculator` using TDD. Add features one test at a time following the Red-Green-Refactor cycle:

1. Empty string returns 0
2. Single number returns its value
3. Two numbers separated by comma return their sum
4. Unknown amount of numbers (comma-separated) returns sum
5. Newline as separator (in addition to comma)
6. Negative numbers throw `IllegalArgumentException` with message listing all negatives

### Extension

Support custom delimiters specified at the start of the string in format `//[delimiter]\n[numbers]`.
