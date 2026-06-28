# Kata 3: Validation Test

| Field | Value |
|-------|-------|
| Concepts | Parameterized tests, validation |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write parameterized JUnit 5 tests for a validation utility:
1. Create a `BookValidator` class with methods like `isValidTitle`, `isValidIsbn`, `isValidYear`
2. Use `@CsvSource` to test multiple inputs for each method
3. Test edge cases: null, empty, valid values, invalid values

### Example Output

```java
@ParameterizedTest
@CsvSource({
    "The Hobbit, true",
    "'', false",
    ", false",
    "A, true"
})
void shouldValidateTitle(String title, boolean expected) {
    assertThat(BookValidator.isValidTitle(title)).isEqualTo(expected);
}
```

### Extension

Add a `@MethodSource` test that generates test cases dynamically.
