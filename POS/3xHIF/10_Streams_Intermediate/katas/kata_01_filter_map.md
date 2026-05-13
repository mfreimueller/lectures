# Kata 1: Filter and Map

| Field | Value |
|-------|-------|
| Concepts | Stream, filter, map, toList |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a `StreamTasks` class with the following static methods using streams:

1. `List<Integer> evenSquares(List<Integer> numbers)` -- filter even numbers, then square them
2. `List<String> shortNamesToUpper(List<String> names, int maxLength)` -- filter by length, then convert to uppercase
3. `List<Integer> positiveLengths(List<String> strings)` -- filter non-null strings, map to their length, filter lengths > 0

### Example Output

```java
evenSquares([1, 2, 3, 4, 5])       -> [4, 16]
shortNamesToUpper(["Alice", "Bo", "Charlie"], 3) -> ["BO"]
positiveLengths(["hi", "", null, "hello"]) -> [2, 5]
```

### Extension

Add a method that chains three filters and two maps.
