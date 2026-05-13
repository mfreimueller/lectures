# Kata 4: File Processor with Files API

| Field | Value |
|-------|-------|
| Concepts | Files.readString/writeString, Files.walk, Streams, unnamed variables |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Write a program that walks a directory tree using `Files.walk`
2. Find all `.txt` files in the tree
3. Read each file using `Files.readString`
4. Count the number of words in each file
5. Write a summary to `summary.txt` using `Files.writeString`
6. Use `_` for unused variables in catch blocks and lambda parameters

### Example Output (summary.txt)

```
./notes.txt: 120 words
./docs/readme.txt: 45 words
./data/sample.txt: 230 words
Total: 395 words
```

### Extension

Add recursive search with `Files.walk` (already recursive by default - note this).
