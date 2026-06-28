# Kata 2: String Utility Parameterized Tests

| Field | Value |
|-------|-------|
| Concepts | @ParameterizedTest, @CsvSource, AssertJ |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create a `StringUtils` class with methods:
- `String reverse(String input)`
- `boolean isPalindrome(String input)`
- `int countVowels(String input)`

Then write a `StringUtilsTest` class using JUnit 5 parameterized tests:
- Use `@CsvSource` to test `reverse` with at least 4 cases
- Use `@CsvSource` to test `isPalindrome` with palindromes AND non-palindromes
- Use `@ParameterizedTest` + `@ValueSource` to test `countVowels`

Use AssertJ (`assertThat`) for all assertions.

### Example Output

```
Tests passed: 12/12
  - testReverse("hello") -> "olleh"
  - testReverse("Java") -> "avaJ"
  - testIsPalindrome("racecar") -> true
  - testIsPalindrome("hello") -> false
  - testCountVowels("hello") -> 2
```

### Extension

Add a method `int countConsonants(String input)` and write parameterized tests.
