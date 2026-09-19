---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 02a - Lambda Expressions & the :: Operator
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: We Already Used This
2. Motivation: From Anonymous Classes to Lambdas
3. What is a Functional Interface?
4. Lambda Syntax
5. Lambda Syntax Variations
6. Common Functional Interfaces

---

## Agenda (2/2)

7. Variable Capture: Effectively Final
8. The :: Operator: Method References
9. Four Kinds of Method References
10. Method References in Streams
11. Reflection
12. Summary

---

## Learning Objectives

- I can explain what a functional interface is
- I can read and write lambda expressions in their different forms
- I can explain why lambdas may only capture effectively final variables
- I can replace a lambda with a method reference where appropriate
- I can name the four kinds of method references

---

## Review: We Already Used This

```java
List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList();

words.stream().forEach(System.out::println);
```

<div class="highlight-box"><p>In the last lesson, `n -> n % 2 == 0` and `System.out::println` were treated as black boxes. Today: what are they, and why do they work as arguments to filter and forEach?</p></div>

---

## Motivation: From Anonymous Classes to Lambdas

```java
// Before: anonymous inner class
Comparator<String> byLength = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }
};

// After: lambda expression
Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());
```

<div class="highlight-box"><p>Both versions create an object that implements Comparator. The lambda just removes the boilerplate: no class name, no method name, no @Override.</p></div>

---

## What is a Functional Interface?

- An interface with exactly **one abstract method**
- May have any number of default or static methods
- Marked (optionally) with `@FunctionalInterface` -- compiler then enforces the "exactly one" rule

```java
@FunctionalInterface
interface Comparator<T> {
    int compare(T a, T b);   // the single abstract method

    default Comparator<T> reversed() { /* ... */ }  // allowed
}
```

- A lambda expression is only valid where a functional interface is expected

---

## Lambda Syntax

```java
(parameters) -> expression

(parameters) -> {
    statements;
    return value;
}
```

```java
Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());

Predicate<Integer> isEven = (n) -> {
    return n % 2 == 0;
};
```

- Expression body: value is returned automatically, no `return`, no `;`
- Block body: needs `{ }`, `return`, and `;` like a normal method body

---

## Lambda Syntax Variations

```java
(Integer n) -> n % 2 == 0     // explicit parameter type
n -> n % 2 == 0               // type inferred -- preferred
(n) -> n % 2 == 0             // parentheses optional for exactly one param
() -> 42                      // no parameters
(a, b) -> a + b                // multiple parameters, types inferred together
```

<div class="highlight-box"><p>The compiler infers parameter types from the functional interface's abstract method -- this is called target typing.</p></div>

---

## Lambdas Implement Functional Interfaces

```java
interface Greeter {
    String greet(String name);
}

Greeter formal = name -> "Good day, " + name + ".";
Greeter casual = name -> "Hey " + name + "!";

System.out.println(formal.greet("Ada"));  // Good day, Ada.
```

- `numbers.stream().filter(n -> n % 2 == 0)` works because `filter` expects a `Predicate<Integer>`, and `Predicate<T>` declares exactly one abstract method: `boolean test(T t)`

---

## Common Functional Interfaces

From `java.util.function`:

| Interface | Method | Purpose |
|---|---|---|
| `Predicate<T>` | `boolean test(T t)` | a yes/no check |
| `Function<T, R>` | `R apply(T t)` | transform T into R |
| `Consumer<T>` | `void accept(T t)` | do something with T, return nothing |
| `Supplier<T>` | `T get()` | produce a T from nothing |

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
Function<String, Integer> length = s -> s.length();
Consumer<String> print = s -> System.out.println(s);
Supplier<String> greeting = () -> "Hello!";
```

---

## Variable Capture: Effectively Final

```java
int threshold = 10;

Predicate<Integer> aboveThreshold = n -> n > threshold;  // OK: threshold is read, never reassigned

threshold = 20;  // compile error: threshold is used in a lambda,
                  // so it must stay effectively final
```

<div class="highlight-box"><p>A lambda may read a local variable from its enclosing scope, but only if that variable is never reassigned after initialization ("effectively final"). The lambda captures the value, not a live reference to the variable.</p></div>

---

## The :: Operator: Method References

```java
// Lambda that just forwards to an existing method
words.stream().forEach(word -> System.out.println(word));

// Method reference: same thing, shorter
words.stream().forEach(System.out::println);
```

<div class="highlight-box"><p>A method reference is shorthand for a lambda that does nothing but call one existing method (or constructor). Use it whenever the lambda body is just `x -> someMethod(x)`.</p></div>

---

## Four Kinds of Method References

| Kind | Syntax | Equivalent Lambda |
|---|---|---|
| Static method | `Integer::parseInt` | `s -> Integer.parseInt(s)` |
| Instance method, particular object | `System.out::println` | `x -> System.out.println(x)` |
| Instance method, arbitrary object of a type | `String::toUpperCase` | `s -> s.toUpperCase()` |
| Constructor | `ArrayList::new` | `() -> new ArrayList<>()` |

---

## Method References: Examples

```java
Function<String, Integer> parse = Integer::parseInt;         // static
Consumer<String> print = System.out::println;                // particular object
Function<String, String> upper = String::toUpperCase;         // arbitrary object
Supplier<List<String>> factory = ArrayList::new;               // constructor
```

- Same functional interface, same target typing rules as lambdas
- The compiler decides which "kind" applies based on the method's signature and how it's used

---

## Method References in Streams

```java
List<String> upper = words.stream()
    .map(String::toUpperCase)     // arbitrary object of a type
    .toList();

words.stream()
    .forEach(System.out::println); // particular object

List<Integer> lengths = words.stream()
    .map(String::length)           // arbitrary object of a type
    .toList();
```

<div class="highlight-box"><p>Now the code from the last lesson reads directly: filter takes a Predicate, map takes a Function, forEach takes a Consumer -- and lambdas or method references are just values of those types.</p></div>

---

## Reflection

<div class="highlight-box">
<p>A method reference and its equivalent lambda compile to the same thing. So why would you prefer <code>String::toUpperCase</code> over <code>s -> s.toUpperCase()</code>? Is there a point where the lambda is actually clearer?</p>
</div>

---

## Summary

- A lambda is an object implementing a functional interface -- an interface with exactly one abstract method
- `(params) -> expression` or `(params) -> { statements }`
- Lambdas may only capture effectively final local variables
- `::` is shorthand for a lambda that only calls one existing method or constructor -- four kinds: static, particular object, arbitrary object of a type, constructor
- Next: back to Streams, going deeper on filter, map, and flatMap
