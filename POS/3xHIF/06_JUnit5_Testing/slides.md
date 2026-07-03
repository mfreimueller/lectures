---
title: 06 - JUnit5_Testing
transition: slide
backgroundTransition: fade
slideNumber: c/t
center: false
hash: true
---

<!-- .slide: class="center title-slide" -->

# 06 - JUnit5_Testing

POS - 3xHIF

Notes: Wiederholung (15 min) — PLÜ 1 Besprechung, Moderne Java-Features: var, Records, Optional, switch, sealed, Text Blocks. Frage: Warum testen? → Sicherheit bei Refactoring, Dokumentation, Qualität

---

## Agenda (1/2)

1. Review: Previous Week <!-- .element: class="fragment" -->
2. Review: Why Testing Matters <!-- .element: class="fragment" -->
3. What is Unit Testing? <!-- .element: class="fragment" -->
4. JUnit 5 Overview <!-- .element: class="fragment" -->
5. Test Lifecycle <!-- .element: class="fragment" -->
6. Lifecycle Example <!-- .element: class="fragment" -->

---

## Agenda (2/2)

7. AssertJ: Fluent Assertions <!-- .element: class="fragment" -->
8. Common AssertJ Methods <!-- .element: class="fragment" -->
9. AssertJ for Collections <!-- .element: class="fragment" -->
10. Parameterized Tests <!-- .element: class="fragment" -->
11. More Parameterized Sources <!-- .element: class="fragment" -->

---

## Learning Objectives

- I can write JUnit 5 tests with proper lifecycle annotations <!-- .element: class="fragment" -->
- I can use AssertJ fluent assertions for readable test code <!-- .element: class="fragment" -->
- I can write parameterized tests with different data sources <!-- .element: class="fragment" -->
- I can test exceptions using assertThrows and assertAll <!-- .element: class="fragment" -->

---

## Review: Previous Week

Last week: Refactoring Exercise

- Improving code structure without changing behavior <!-- .element: class="fragment" -->
- Extract methods, rename variables, simplify conditionals <!-- .element: class="fragment" -->
- Importance of clean code and readability <!-- .element: class="fragment" -->

---

## Review: Why Testing Matters

- Tests catch regressions early <!-- .element: class="fragment" -->
- Tests document expected behavior <!-- .element: class="fragment" -->
- Tests enable safe refactoring <!-- .element: class="fragment" -->
- Without tests, you cannot know if code still works <!-- .element: class="fragment" -->

---

## What is Unit Testing?

- Testing individual units of code (methods, classes) in isolation <!-- .element: class="fragment" -->
- Fast, automated, repeatable <!-- .element: class="fragment" -->
- First line of defense against bugs <!-- .element: class="fragment" -->

> Key idea: A test should fail for only one reason <!-- .element: class="fragment" -->

---

## Discussion: The Cost of Testing

> Writing tests takes time away from writing features. What is the real cost of a bug that reaches production versus the time spent writing tests? Are there situations where testing might not be worth the effort? When does testing become essential?

---

## JUnit 5 Overview

- JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage <!-- .element: class="fragment" -->
- JUnit Jupiter provides the programming model <!-- .element: class="fragment" -->
- Annotations: @Test, @BeforeEach, @AfterEach, @BeforeAll, @AfterAll <!-- .element: class="fragment" -->

<pre class="fragment"><code class="language-java">@Test
void testAddition() {
    assertEquals(4, 2 + 2);
}
</code></pre>

Notes: JUnit 5 Grundlagen (30 min) — Annotationen: @Test, @BeforeEach, @AfterEach, @BeforeAll, @AfterAll. Test-Lifecycle: @BeforeAll → einmal vor allen Tests (static), @BeforeEach → vor jedem Test, @Test → der eigentliche Test, @AfterEach → nach jedem Test, @AfterAll → einmal nach allen Tests (static). Assertions: assertEquals, assertTrue, assertThrows, assertAll. Live Coding: Calculator-Tests mit Given/When/Then

---

## Now Kata 1: Calculator Tests

Write JUnit 5 tests for a Calculator class covering addition, subtraction, multiplication, and division.

---

## Test Lifecycle

- @BeforeAll: runs once before all tests (static) <!-- .element: class="fragment" -->
- @BeforeEach: runs before each test method <!-- .element: class="fragment" -->
- @Test: the test method itself <!-- .element: class="fragment" -->
- @AfterEach: runs after each test method <!-- .element: class="fragment" -->
- @AfterAll: runs once after all tests (static) <!-- .element: class="fragment" -->

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

## Now Kata 2: Test Lifecycle & AssertJ

Test a ShoppingCart class using @BeforeEach/@AfterEach lifecycle methods and AssertJ fluent assertions.

---

## AssertJ: Fluent Assertions

- AssertJ provides readable, fluent assertion methods <!-- .element: class="fragment" -->
- Static import: `import static org.assertj.core.api.Assertions.*;` <!-- .element: class="fragment" -->

<pre class="fragment"><code class="language-java">assertThat(result)
    .isEqualTo(42)
    .isNotNull()
    .isInstanceOf(Integer.class);
</code></pre>

Notes: AssertJ — Fluent Assertions (25 min) — assertThat(actual).isEqualTo(expected), assertThat(list).hasSize(3).contains("a"), assertThat(obj).extracting("name").isEqualTo("Alice"), assertThat(exception).isInstanceOf(IllegalArgumentException.class), assertAll() für gruppierte Assertions. Live Coding: ShoppingCart-Tests mit AssertJ

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

## Now Kata 3: Exception Testing

Test a BankAccount class using assertThrows for expected exceptions and assertAll for grouped assertions.

---

## Parameterized Tests

- Run the same test with different inputs <!-- .element: class="fragment" -->
- Reduces boilerplate code <!-- .element: class="fragment" -->

<pre class="fragment"><code class="language-java">@ParameterizedTest
@CsvSource({ "1, 1, 2", "2, 3, 5" })
void testAddition(int a, int b, int expected) {
    assertEquals(expected, a + b);
}
</code></pre>

Notes: Parameterized Tests (25 min) — @ParameterizedTest + @ValueSource, @CsvSource, @CsvFileSource, @MethodSource. Beispiel: @ParameterizedTest @CsvSource({"hello, 5", "world, 5", "", 0"}) void testLength(String input, int expected) { assertThat(input.length()).isEqualTo(expected); }. Live Coding: String-Utility mit parameterisierten Tests

---

## Now Kata 4: Test Coverage & Boundary Analysis

Write parameterized tests for a TemperatureConverter class covering boundary cases and edge conditions.

---

## More Parameterized Sources

- @ValueSource: supply literal values <!-- .element: class="fragment" -->
- @CsvSource: CSV-style inline data <!-- .element: class="fragment" -->
- @CsvFileSource: load from CSV file <!-- .element: class="fragment" -->
- @MethodSource: return Stream of Arguments <!-- .element: class="fragment" -->

<pre class="fragment"><code class="language-java">@ParameterizedTest
@ValueSource(strings = { "racecar", "radar", "madam" })
void testPalindrome(String word) {
    assertThat(isPalindrome(word)).isTrue();
}
</code></pre>

---

## Now Kata 5: String Utility Parameterized Tests

Write parameterized tests for a StringUtils class using @CsvSource to test multiple input/output pairs.

---

## Summary

- JUnit 5 is the standard testing framework for Java <!-- .element: class="fragment" -->
- Lifecycle annotations control setup and teardown <!-- .element: class="fragment" -->
- AssertJ provides fluent, readable assertions <!-- .element: class="fragment" -->
- Parameterized tests reduce duplication <!-- .element: class="fragment" -->

Notes: Test-Best-Practices (15 min) — One assertion per test (oder assertAll für zusammengehörige). Aussagekräftige Testnamen: shouldReturnEmptyWhenListIsEmpty. Given/When/Then-Struktur. Tests isolieren — keine Abhängigkeiten zwischen Tests. Ab jetzt in ALLEN Übungen: Tests schreiben! Katas: K1 Calculator Tests, K2 ShoppingCart Lifecycle, K3 Exception Testing, K4 Boundary Testing, K5 StringUtils Parameterized

---

## Best Practices

- Test one thing per test method <!-- .element: class="fragment" -->
- Use descriptive test method names <!-- .element: class="fragment" -->
- Write tests before code (TDD) <!-- .element: class="fragment" -->
- Keep tests fast and independent <!-- .element: class="fragment" -->
- Tests are code too -- keep them clean <!-- .element: class="fragment" -->

---

<!-- .slide: class="center" -->

## Outlook

Next week: TDD and FIRST Principles

Write tests first, then implement!

Notes: Wrap-up (10 min) — Nächste Woche: TDD — Red-Green-Refactor. Hausübung: Bestehende Klasse testen, parameterisierte Tests. Häufige Fehler: assertEquals(expected, actual) → Reihenfolge vertauscht! (AssertJ: assertThat(actual).isEqualTo(expected)), @BeforeAll ohne static → wird nicht ausgeführt, Tests mit Seiteneffekten → Reihenfolge-abhängig, Zu viele Assertions in einem Test → unklar, was schiefging, assertThrows ohne Lambda → falsche Syntax
