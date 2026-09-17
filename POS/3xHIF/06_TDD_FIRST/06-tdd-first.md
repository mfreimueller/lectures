---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 06 - TDD, FIRST
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: JUnit Jupiter
2. Review: Why Write Tests?
3. What is TDD?
4. Why TDD?
5. The TDD Cycle: Red
6. The TDD Cycle: Green
7. The TDD Cycle: Refactor

---

## Agenda (2/2)

8. FIRST Principles
9. Fast Tests
10. Isolated Tests
11. Live Coding: FizzBuzz
12. Live Coding: Full FizzBuzz
13. Common Pitfalls

---

## Learning Objectives

- I can explain the TDD Red-Green-Refactor cycle
- I can apply FIRST principles to write better tests
- I can write fast, isolated unit tests without external dependencies
- I can implement FizzBuzz using strict TDD
- I can use Mockito to isolate services for testing

---

## Review: JUnit Jupiter

- @Test, @BeforeEach, @AfterEach
- AssertJ for fluent assertions
- @ParameterizedTest for multiple inputs

---

## Review: Why Write Tests?

- Catch regressions early
- Document expected behavior
- Enable safe refactoring

---

## What is TDD?

Test-Driven Development is a software development process where you write tests before production code.

- Write a failing test (Red)
- Write the simplest code to pass (Green)
- Refactor to improve quality (Refactor)

---

## Why TDD?

- Forces you to think about design before coding
- Every line of code is tested
- Safe refactoring with instant feedback
- Reduces debugging time

---

## Reflection: Does TDD Really Improve Design?

<div class="highlight-box">
<p>Does writing tests first really produce better design, or does it just slow you down? Think about a time you wrote code without tests first — was the API cleaner or messier than when you wrote tests first?</p>
</div>

---

## The TDD Cycle: Red

<div class="highlight-box">
<p>Write a test that fails.</p>
</div>

```java
@Test
void testFizzBuzz() {
    assertEquals("Fizz", fizzBuzz(3));
    // This won't compile yet -- no FizzBuzz class!
}
```

The test failure proves the test can detect the missing feature.

---

## The TDD Cycle: Green

<div class="highlight-box">
<p>Write the simplest code to make the test pass.</p>
</div>

```java
String fizzBuzz(int n) {
    return "Fizz";  // simplest thing that works
}
```

Do not add extra functionality yet!

---

## The TDD Cycle: Refactor

<div class="highlight-box">
<p>Improve code without changing behavior.</p>
</div>

- Remove duplication
- Improve readability
- Extract methods
- All tests must stay green

---

## FIRST Principles

| Letter | Meaning |
| --- | --- |
| F | **Fast** -- tests run quickly |
| I | **Isolated** -- no test depends on another |
| R | **Repeatable** -- same result every time |
| S | **Self-validating** -- pass/fail clearly |
| T | **Timely** -- written before production code |

---

## Fast Tests

- Unit tests must run in milliseconds
- Avoid database, network, file I/O in unit tests
- If a test suite takes 10 minutes, developers stop running it

---

## Isolated Tests

- Each test should be independent
- No shared state between tests
- Use @BeforeEach to create fresh objects
- Tests should run in any order

---

## Live Coding: FizzBuzz

```java
// Step 1: Write test for "Fizz"
@Test
void testFizz() {
    assertEquals("Fizz", FizzBuzz.of(3));
}

// Step 2: Simplest code
class FizzBuzz {
    static String of(int n) { return "Fizz"; }
}

// Step 3: Add more tests, generalize...
```

---

## Live Coding: Full FizzBuzz

```java
@ParameterizedTest
@CsvSource({"1,1","2,2","3,Fizz","5,Buzz","15,FizzBuzz"})
void testFizzBuzz(int input, String expected) {
    assertThat(FizzBuzz.of(input)).isEqualTo(expected);
}
```

---

## Summary

- TDD = Red, Green, Refactor
- FIRST principles guide good test design
- Tests drive the design, not the other way around
- Start simple, then generalize

---

## Common Pitfalls

- Writing too much code in the Green phase
- Skipping the Refactor phase
- Writing tests that are too large
- Not running tests frequently enough
