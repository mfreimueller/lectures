---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 03 - J Unit5, Testing
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Why Testing Matters
2. What is Unit Testing?
3. JUnit Jupiter Overview
4. Test Lifecycle
5. Lifecycle Example

---

## Agenda (2/2)

6. AssertJ: Fluent Assertions
7. Common AssertJ Methods
8. AssertJ for Collections
9. Parameterized Tests
10. More Parameterized Sources

---

## Learning Objectives

- I can write JUnit Jupiter tests with proper lifecycle annotations
- I can use AssertJ fluent assertions for readable test code
- I can write parameterized tests with different data sources
- I can test exceptions using assertThrows and assertAll

---

## Review: Why Testing Matters

- Tests catch regressions early
- Tests document expected behavior
- Tests enable safe refactoring
- Without tests, you cannot know if code still works

---

## What is Unit Testing?

- Testing individual units of code (methods, classes) in isolation
- Fast, automated, repeatable
- First line of defense against bugs

<div class="highlight-box">
<p>Key idea: A test should fail for only one reason</p>
</div>

---

## Discussion: The Cost of Testing

<div class="highlight-box">
<p>Writing tests takes time away from writing features. What is the real cost of a bug that reaches production versus the time spent writing tests? Are there situations where testing might not be worth the effort? When does testing become essential?</p>
</div>

---

## Structure of a Unit Test

- Arrange (also: Given)
- Act (also: When)
- Assert (also: Then)

Note, that sometimes those can be fluent.

---

## Arrange

- Prepare your test objects
- Example: Get a student, a desk and a bottle

```java
@Test
void ensureThatDivideProperlyDividesTwoNumbers() {
    // arrange
    var calculator = new Calculator();
    int x = 100, y = 10;
}
```

---

## Act

- Perform your test
- Example: Force the student to flip the bottle

```java
@Test
void ensureThatDivideProperlyDividesTwoNumbers() {
    // ...
    // act
    var result = calculator.divide(x, y);
}
```

---

## Assert

- Compare result with your expectations
- Example: The bottle stands without falling.

```java
@Test
void ensureThatDivideProperlyDividesTwoNumbers() {
    // ...
    // assert
    assertThat(result).isEqualTo(10);
}
```

---

## Two Paths

**Happy Path**

- The `happy path` tests that your function does what you expect it to do.

**Edge Case**

- The `edge case` tests that your function fails *expectedly*
- Example: Hand the student a pen to flip and *expect* them to refuse.

---

## JUnit Jupiter Overview

- JUnit Jupiter = JUnit Platform + JUnit Jupiter + JUnit Vintage
- JUnit Jupiter provides the programming model
- Annotations: @Test, @BeforeEach, @AfterEach, @BeforeAll, @AfterAll

```java
@Test
void testAddition() {
    assertEquals(4, 2 + 2);
}
```

---

## Test Lifecycle

- @BeforeAll: runs once before all tests (static)
- @BeforeEach: runs before each test method
- @Test: the test method itself
- @AfterEach: runs after each test method
- @AfterAll: runs once after all tests (static)

---

## Lifecycle Example

```java
class LifecycleTest {

    @BeforeAll
    static void initAll() { /* once */ }

    @BeforeEach
    void init() { /* before each */ }

    @Test
    void test1() { /* test */ }

    @Test
    void test2() { /* test */ }

    @AfterEach
    void tearDown() { /* after each */ }

    @AfterAll
    static void tearDownAll() { /* once */ }
}
```

---

## AssertJ: Fluent Assertions

- AssertJ provides readable, fluent assertion methods
- Static import: `import static org.assertj.core.api.Assertions.*;`

```java
assertThat(result)
    .isEqualTo(42)
    .isNotNull()
    .isInstanceOf(Integer.class);
```

---

## Common AssertJ Methods

```java
assertThat(actual).isEqualTo(expected);
assertThat(actual).isNotEqualTo(other);
assertThat(actual).isNull();
assertThat(actual).isNotNull();
assertThat(list).hasSize(3);
assertThat(list).contains("a", "b");
assertThat(str).startsWith("Hello");
assertThat(str).contains("World");
```

---

## AssertJ for Collections

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

assertThat(names)
    .hasSize(3)
    .contains("Alice")
    .doesNotContain("Dave")
    .allMatch(name -> name.length() > 2);
```

---

## Parameterized Tests

- Run the same test with different inputs
- Reduces boilerplate code

```java
@ParameterizedTest
@CsvSource({ "1, 1, 2", "2, 3, 5" })
void testAddition(int a, int b, int expected) {
    assertEquals(expected, a + b);
}
```

---

## More Parameterized Sources

- @ValueSource: supply literal values
- @CsvSource: CSV-style inline data
- @CsvFileSource: load from CSV file
- @MethodSource: return Stream of Arguments

```java
@ParameterizedTest
@ValueSource(strings = { "racecar", "radar", "madam" })
void testPalindrome(String word) {
    assertThat(isPalindrome(word)).isTrue();
}
```

---

## Summary

- JUnit Jupiter is the standard testing framework for Java
- Lifecycle annotations control setup and teardown
- AssertJ provides fluent, readable assertions
- Parameterized tests reduce duplication

---

## Best Practices

- Test one thing per test method
- Use descriptive test method names
- Write tests before code (TDD)
- Keep tests fast and independent
- Tests are code too -- keep them clean
