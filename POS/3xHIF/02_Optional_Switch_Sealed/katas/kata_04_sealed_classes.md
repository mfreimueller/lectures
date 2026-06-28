# Kata 3: Sealed Classes

| Field | Value |
|-------|-------|
| Concepts | sealed, permits, exhaustive switch |
| Difficulty | 3/5 |
| Duration | approx. 20 min |

### Task

1. Define a sealed interface `MediaItem` that permits `Movie`, `Song`, and `Podcast`
2. Each implementation is a record with appropriate fields (title, duration, etc.)
3. Write a method `play(MediaItem item)` that uses a pattern matching switch without a default clause
4. Each media type returns a different play description

### Example Output

```
Playing movie: Inception (148 min)
Playing song: Bohemian Rhapsody (5:55)
Playing podcast: Tech Talks (45:00)
```

### Extension

Add a new `Audiobook` record and update the sealed hierarchy and switch. Verify the compiler forces the update.
