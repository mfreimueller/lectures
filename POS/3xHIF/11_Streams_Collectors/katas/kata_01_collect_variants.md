# Kata 1: Collect to List, Set, Map, String

| Field | Value |
|-------|-------|
| Concepts | Collectors.toList, toSet, toMap, joining |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a `CollectTasks` class with methods that use different collectors:

1. `List<String> getUniqueWords(String text)` -- split text into words, collect to Set, return as List
2. `Map<String, Integer> toMapById(List<Item> items)` -- convert list of Items (with id and name) into Map<String, Integer> mapping id to name length
3. `String joinNames(List<String> names, String delimiter)` -- join names with delimiter using joining

Use this record:
```java
record Item(String id, String name) {}
```

### Example Output

```java
getUniqueWords("hello world hello") -> ["hello", "world"]
toMapById([Item("1","Alice"), Item("2","Bob")]) -> {"1"=5, "2"=3}
joinNames(["Alice", "Bob", "Charlie"], " | ") -> "Alice | Bob | Charlie"
```

### Extension

Use `toCollection(TreeSet::new)` to collect unique words in sorted order.
