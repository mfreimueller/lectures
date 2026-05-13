# Kata 5: Test Coverage & Boundary Analysis

| Field | Value |
|-------|-------|
| Concepts | boundary tests, parameterized tests, @CsvSource, edge cases |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Write a `TemperatureConverter` class with:
- `double celsiusToFahrenheit(double c)`
- `double fahrenheitToCelsius(double f)`

Write parameterized JUnit 5 tests using `@CsvSource` that cover:
1. Freezing point: 0C = 32F
2. Boiling point: 100C = 212F
3. Absolute zero: -273.15C = -459.67F
4. Body temperature: 37C = 98.6F
5. Equality point: -40C = -40F
6. Room temperature: 25C = 77F

Also test round-trip conversion: C -> F -> C returns the original value.

### Extension

Test with `@ValueSource` for invalid inputs (NaN, infinity) and verify that the operations handle them gracefully.
