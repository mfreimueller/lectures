---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 02 - Streams, Intro
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Modern Java Core Features
2. Motivation: The Problem with Loops
3. What is a Stream?
4. Stream Pipeline
5. From Loop to Stream: Filtering

---

## Agenda (2/2)

6. From Loop to Stream: Transforming
7. From Loop to Stream: Counting & Summing
8. forEach
9. Reflection: Loops vs. Streams
10. Summary

---

## Learning Objectives

- I can explain what a Stream is and how it differs from a loop
- I can recognize common Java 7 loop patterns: filtering, transforming, counting
- I can rewrite simple imperative loops as Stream pipelines
- I can use forEach, filter, and map for basic Stream operations

---

## Review: Modern Java Core Features

- var, Records, Optional, switch expressions
- Pattern matching, sealed classes, text blocks
- Today: a new way to process collections

---

## Motivation: The Problem with Loops

```java
// Java 7 style: find even numbers
List<Integer> even = new ArrayList<>();
for (Integer n : numbers) {
    if (n % 2 == 0) {
        even.add(n);
    }
}
```

<div class="highlight-box"><p>Every loop repeats the same shape: create a container, iterate, check a condition, mutate. The intent gets buried in bookkeeping.</p></div>

---

## What is a Stream?

- A sequence of elements supporting sequential/parallel operations
- Not a data structure -- it processes data from a source
- Supports pipelining: chain operations together
- Lazy evaluation: intermediate ops are not executed until a terminal op is called

---

## Stream Pipeline

```java
List<String> result = list.stream()
    .filter(s -> s.startsWith("A"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

![width:75% Stream Pipeline: Source, Intermediate Operations, Terminal Operation](mermaid/stream-pipeline.svg)

---

## From Loop to Stream: Filtering

```java
// Before (Java 7)
List<Integer> even = new ArrayList<>();
for (Integer n : numbers) {
    if (n % 2 == 0) {
        even.add(n);
    }
}

// After
List<Integer> even = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList();
```

---

## From Loop to Stream: Transforming

```java
// Before (Java 7)
List<String> upper = new ArrayList<>();
for (String word : words) {
    upper.add(word.toUpperCase());
}

// After
List<String> upper = words.stream()
    .map(String::toUpperCase)
    .toList();
```

---

## From Loop to Stream: Counting & Summing

```java
// Before (Java 7)
int sum = 0;
int count = 0;
for (Integer n : numbers) {
    if (n > 0) {
        sum += n;
        count++;
    }
}

// After
long count = numbers.stream().filter(n -> n > 0).count();
int sum = numbers.stream().filter(n -> n > 0).mapToInt(n -> n).sum();
```

---

## forEach

```java
// Before (Java 7)
for (String word : words) {
    System.out.println(word);
}

// After
words.stream().forEach(System.out::println);
```

<div class="highlight-box"><p>forEach is a terminal operation -- it doesn't return a new Stream.</p></div>

---

## Reflection: Loops vs. Streams

<div class="highlight-box">
<p>Every Stream pipeline in this lesson could also be written as a loop. So why bother? What does the Stream version communicate that the loop version doesn't? Is there a point where a loop is still the better choice?</p>
</div>

---

## Summary

- Streams turn "how to iterate" into "what to compute"
- filter selects, map transforms, forEach acts on each element
- Intermediate operations are lazy; nothing runs until a terminal op
- Next: going deeper on filter, map, and flatMap
