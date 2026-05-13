# Kata 3: reduce Pipeline

| Field | Value |
|-------|-------|
| Concepts | reduce, Optional, complex pipelines |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write a `ReduceTasks` class using stream pipelines with reduce:

1. `int sumOfLengths(List<String> strings)` -- sum of all string lengths using reduce
2. `String longestString(List<String> strings)` -- longest string using reduce (return "" if empty)
3. `int factorial(int n)` -- compute factorial using IntStream.range and reduce
4. `String concatenateWithDelimiter(List<String> strings, String delimiter)` -- concatenate with delimiter using reduce

### Example Output

```java
sumOfLengths(["a", "bb", "ccc"])          -> 6
longestString(["a", "bb", "ccc"])         -> "ccc"
factorial(5)                              -> 120
concatenateWithDelimiter(["a", "b", "c"], ",") -> "a,b,c"
```

### Extension

Implement `String shortestString(List<String> strings)` using reduce. Then combine both longest and shortest into a single pipeline that returns both.
