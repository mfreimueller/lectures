---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 04 - Exercise, Refactoring
## POS - 3xHIF

---

## Agenda

1. Legacy Code Example
2. Refactoring Targets
3. Demo: Person to Record
4. Demo: Anonymous Class to Lambda
5. Exercise Workflow

---

## Learning Objectives

- I can identify refactoring opportunities in legacy Java code
- I can replace verbose classes with Records where appropriate
- I can convert anonymous inner classes to lambda expressions
- I can apply modern Java features incrementally while preserving behavior

---

## Legacy Code Example

```java
// Java 7 style: verbose, lots of boilerplate
public class Person {
    private String name;
    private int age;
    // getters, setters, equals, hashCode, toString...
}
```

<div class="highlight-box"><p>Today we refactor this to modern Java.</p></div>

---

## Refactoring Targets

- Replace classes with Records where appropriate
- Replace anonymous inner classes with lambdas
- Replace if-else instanceof chains with pattern matching
- Replace traditional switch with switch expressions
- Use Optional instead of null checks

---

## Reflection: Refactoring Without Tests

<div class="highlight-box">
<p>Refactoring legacy code without a test suite is like defusing a bomb blindfolded. Why is it so dangerous? How should a team approach legacy code that has no tests? Should you write tests first, or refactor incrementally?</p>
</div>

---

## Demo: Person to Record

```java
// After: 3 lines instead of 30+
public record Person(String name, int age) {}
```

---

## Demo: Anonymous Class to Lambda

```java
// Before
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked!");
    }
});

// After
button.addActionListener(e -> System.out.println("Clicked!"));
```

---

## Exercise Workflow

1. Review the legacy code
2. Apply one refactoring at a time
3. Run tests after each step
4. Compare before and after
