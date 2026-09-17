---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 04 - Streams, Intermediate
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Refactoring Exam
2. Review: From Loops to Pipelines
3. filter
4. filter with Objects
5. map
6. map with Method References

---

## Agenda (2/2)

7. flatMap
8. flatMap Example: Words
9. forEach
10. reduce
11. reduce: Finding Max
12. Summary

---

## Learning Objectives

- I can use filter and map to transform collections declaratively
- I can use flatMap to flatten nested data structures
- I can use reduce to combine stream elements into a single value
- I can choose between loops and streams based on readability

---

## Review: Refactoring Exam

- You refactored a Java 7 application to modern Java
- Records, var, Optional, switch expressions, pattern matching
- JUnit Jupiter to verify the refactored code still works

---

## Review: From Loops to Pipelines

- Streams Intro: rewriting simple loops as Stream pipelines
- forEach, filter, map -- declarative instead of imperative
- Today: going deeper on filter, map, and flatMap

---

## filter

Selects elements that match a predicate.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList();

// Result: [2, 4, 6]
```

---

## filter with Objects

```java
List<Person> adults = people.stream()
    .filter(p -> p.age() >= 18)
    .toList();

List<Person> named = people.stream()
    .filter(p -> p.name() != null)
    .filter(p -> !p.name().isEmpty())
    .toList();
```

---

## map

Transforms each element using a function.

```java
List<String> names = List.of("alice", "bob", "charlie");

List<String> upper = names.stream()
    .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
    .toList();

// Result: ["Alice", "Bob", "Charlie"]
```

---

## map with Method References

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

List<Integer> lengths = names.stream()
    .map(String::length)
    .toList();

// Result: [5, 3, 7]
```

---

## flatMap

Flattens nested structures into a single stream.

```java
List<List<Integer>> nested = List.of(
    List.of(1, 2), List.of(3, 4), List.of(5, 6)
);

List<Integer> flat = nested.stream()
    .flatMap(List::stream)
    .toList();

// Result: [1, 2, 3, 4, 5, 6]
```

---

## flatMap Example: Words

```java
List<String> sentences = List.of(
    "Hello world", "Java streams"
);

List<String> words = sentences.stream()
    .flatMap(s -> Arrays.stream(s.split(" ")))
    .toList();

// Result: ["Hello", "world", "Java", "streams"]
```

---

## Reflection: Streams vs. Loops

<div class="highlight-box">
<p>Do streams make code more readable or more cryptic? When would you prefer a traditional for-loop over a stream pipeline? Discuss with your neighbor: what makes a stream pipeline "good" vs. "over-engineered"?</p>
</div>

---

## forEach

Performs an action on each element (terminal operation).

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
names.stream()
    .filter(n -> n.length() > 3)
    .forEach(System.out::println);
```

<div class="highlight-box">
<p>Prefer toList() over forEach for collecting results!</p>
</div>

---

## reduce

Combines all elements into a single value.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);

int product = numbers.stream()
    .reduce(1, (a, b) -> a * b);

// sum = 15, product = 120
```

---

## reduce: Finding Max

```java
List<Integer> numbers = List.of(3, 7, 2, 9, 5);

Optional<Integer> max = numbers.stream()
    .reduce(Integer::max);

max.ifPresent(System.out::println); // 9
```

---

## Summary

- Streams enable declarative data processing
- Intermediate ops: filter, map, flatMap
- Terminal ops: forEach, reduce, collect
- Lazy evaluation makes pipelines efficient
