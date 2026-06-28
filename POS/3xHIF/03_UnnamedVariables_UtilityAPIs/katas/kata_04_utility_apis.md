# Kata 3: Utility APIs

| Field | Value |
|-------|-------|
| Concepts | String API, Files API, Collection factory methods |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

Write a program that:

1. Reads a text file using `Files.readString()`
2. Splits the content into lines and counts words per line using `String.lines()` and `isBlank()`
3. Filters out blank lines
4. Writes a report using `Files.writeString()` showing each line number and word count
5. Uses `List.of()` and `Map.of()` for any constant data

### Example Output

Given a file with:
```
Hello world
Java is great
```

The output file should contain:
```
Line 1: 2 words
Line 2: 3 words
```

### Extension

Add a feature that finds and prints the most common word across all lines using streams and Map.of for static configuration.
