# Kata 2: flatMap Nested Collections

| Field | Value |
|-------|-------|
| Concepts | flatMap, method chaining, lambda |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Write a `FlatMapTasks` class with these methods:

1. `List<Integer> flatten(List<List<Integer>> nested)` -- flatten a list of lists into a single list
2. `List<String> extractWords(List<String> sentences)` -- split sentences into words and flatten
3. `List<String> uniqueChars(List<String> words)` -- get unique characters from all words using flatMap

### Example Output

```java
flatten([[1,2], [3,4,5], [6]])     -> [1, 2, 3, 4, 5, 6]
extractWords(["Hello world", "Java streams"]) -> ["Hello", "world", "Java", "streams"]
uniqueChars(["hello", "world"])     -> ['h', 'e', 'l', 'o', 'w', 'r', 'd']
```

### Extension

Given a list of orders (each with List of items), use flatMap to get all items ordered across all orders.
