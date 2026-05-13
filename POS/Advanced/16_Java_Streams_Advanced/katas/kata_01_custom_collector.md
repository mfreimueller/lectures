# Kata 1: Custom Collector

| Field | Value |
|-------|-------|
| Concepts | Collector Interface, Supplier, Accumulator, Combiner, Finisher, Characteristics |
| Difficulty | 3/5 |
| Duration | approx. 35 min |

### Task

Implement a custom `Collector<T, A, R>` that builds a histogram (frequency map) of elements.

1. Implement two variants: (a) using `Collector.of()` factory, (b) implementing `Collector<T, Map<T,Integer>, Map<T,Integer>>` as a class
2. The collector should count occurrences of each distinct element
3. Add an overload that returns a **sorted** list of entries (by frequency descending, then by key)
4. Use the `UNORDERED` and `IDENTITY_FINISH` characteristics where appropriate
5. Test on a list of words, on random dice rolls (IntStream), and on a list of Person objects grouped by city

### Example Output

```java
List<String> words = List.of("apple", "banana", "apple", "cherry",
    "banana", "apple", "date", "banana", "apple", "elderberry");

Map<String, Integer> histogram = words.stream().collect(toHistogram());
// {apple=4, banana=3, cherry=1, date=1, elderberry=1}

List<Map.Entry<String, Integer>> sorted = words.stream()
    .collect(toSortedHistogram());
// [apple=4, banana=3, cherry=1, date=1, elderberry=1]
```

### Extension

Implement a `toInverseMap()` collector that creates a `Map<V, List<K>>` from a `Stream<Map.Entry<K, V>>`, grouping by value. Then chain it with `toHistogram()` to find which elements have the same frequency.
