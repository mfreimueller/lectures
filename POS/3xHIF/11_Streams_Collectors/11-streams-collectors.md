---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 11 - Streams, Collectors
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Stream Intermediate Operations
2. Review: Terminal Operations
3. What is collect?
4. Collectors.toList()
5. Collectors.toSet()
6. Collectors.toMap()
7. Collectors.joining()

---

## Agenda (2/2)

8. Collectors.groupingBy()
9. groupingBy: Downstream Collector
10. groupingBy: Mapping Downstream
11. Collectors.partitioningBy()
12. partitioningBy with Downstream
13. Summary

---

## Learning Objectives

- I can use toList, toSet, toMap, and joining collectors to gather stream results
- I can use groupingBy to classify data into categories
- I can use partitioningBy to split data into two groups based on a predicate
- I can chain downstream collectors for powerful aggregations
- I can implement a custom Collector for specialized accumulation

---

## Review: Stream Intermediate Operations

- filter: select elements by predicate
- map: transform elements
- flatMap: flatten nested streams
- Intermediate ops are lazy -- nothing happens until a terminal op is called

---

## Review: Terminal Operations

- forEach: perform action on each element
- reduce: combine into single value
- collect: gather into a mutable container (our focus today)

---

## What is collect?

The collect method is a terminal operation that accumulates stream elements into a mutable result container.

```java
<R, A> R collect(Collector<? super T, A, R> collector);
```

- Works with Collector implementations in java.util.stream.Collectors
- More flexible than reduce for mutable accumulation

---

## Now Kata 1: Custom Collector

Implement a StatisticsCollector that collects count, sum, min, max, and average from a stream of numbers.

---

## Collectors.toList()

```java
List<String> filtered = stream
    .filter(s -> s.length() > 3)
    .collect(Collectors.toList());
```

Since Java 16: `.toList()` is shorter and returns an unmodifiable list.

---

## Collectors.toSet()

```java
Set<String> unique = stream
    .map(String::toLowerCase)
    .collect(Collectors.toSet());
// Removes duplicates
```

---

## Collectors.toMap()

```java
List<Person> people = /* ... */;

Map<Integer, String> idToName = people.stream()
    .collect(Collectors.toMap(
        Person::id,      // key mapper
        Person::name     // value mapper
    ));
```

Be careful with duplicate keys -- will throw IllegalStateException!

---

## Reflection: Duplicate Keys in toMap

<div class="highlight-box">
<p>What happens when two elements produce the same key in toMap? The default behavior throws an exception — is that the right choice, or should it silently overwrite? How would you handle duplicates in a real application?</p>
</div>

---

## Collectors.joining()

```java
List<String> names = List.of("Alice", "Bob", "Charlie");

String result = names.stream()
    .collect(Collectors.joining(", "));

// "Alice, Bob, Charlie"
```

Supports prefix and suffix: `joining(", ", "[", "]")` -> "[Alice, Bob, Charlie]"

---

## Now Kata 2: Collect to List, Set, Map, String

Write methods using toList, toSet, toMap, and joining collectors to transform streams into various collection types.

---

## Collectors.groupingBy()

Groups elements by a classifier function into a Map.

```java
List<Person> people = /* ... */;

Map<String, List<Person>> byCity = people.stream()
    .collect(Collectors.groupingBy(Person::city));
```

---

## groupingBy: Downstream Collector

```java
// Count people per city
Map<String, Long> countByCity = people.stream()
    .collect(Collectors.groupingBy(
        Person::city,
        Collectors.counting()
    ));

// Average age per city
Map<String, Double> avgAgeByCity = people.stream()
    .collect(Collectors.groupingBy(
        Person::city,
        Collectors.averagingInt(Person::age)
    ));
```

---

## Now Kata 3: Multi-level Grouping

Use multi-level grouping with downstream collectors on Employee records to build complex data classifications.

---

## groupingBy: Mapping Downstream

```java
// Names per city (collect to List)
Map<String, List<String>> namesByCity = people.stream()
    .collect(Collectors.groupingBy(
        Person::city,
        Collectors.mapping(Person::name, Collectors.toList())
    ));
```

---

## Now Kata 4: GroupingBy for Data Classification

Group people by city, count per city, and extract names by city using groupingBy with downstream collectors.

---

## Collectors.partitioningBy()

Splits elements into two groups based on a Predicate.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

Map<Boolean, List<Integer>> evenOdd = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));

// {false=[1, 3, 5], true=[2, 4, 6]}
```

---

## partitioningBy with Downstream

```java
// Count even vs odd
Map<Boolean, Long> countEvenOdd = numbers.stream()
    .collect(Collectors.partitioningBy(
        n -> n % 2 == 0,
        Collectors.counting()
    ));
// {false=3, true=3}
```

---

## Now Kata 5: PartitioningBy with Downstream

Partition products by price threshold using various downstream collectors like counting, summing, and averaging.

---

## Summary

- collect is the most flexible terminal operation
- toList, toSet, toMap, joining for simple collections
- groupingBy for multi-level classification
- partitioningBy for binary splits
- Downstream collectors enable powerful aggregations
