# Kata 3: Exception-Handling Utility

| Field | Value |
|-------|-------|
| Concepts | Checked Exceptions, Wrapper Pattern, ThrowingFunction, ThrowingConsumer |
| Difficulty | 3/5 |
| Duration | approx. 40 min |

### Task

Implement a utility for handling checked exceptions inside lambdas.

1. Define `ThrowingFunction<T, R>` — a `@FunctionalInterface` whose `apply()` can throw `Exception`
2. Define `ThrowingConsumer<T>` and `ThrowingPredicate<T>` analogously
3. Create a `ThrowingWrapper` utility class with static `wrap()` methods that convert each throwing interface into its standard counterpart by catching checked exceptions and rethrowing them as `RuntimeException`
4. Use the wrapper in a stream pipeline that reads file content or parses strings into objects
5. Demonstrate at least three different approaches: (a) inline try-catch, (b) generic wrapper, (c) specialized wrapper for `IOException`

### Example Output

```java
// Names that may be null or blank
List<String> names = List.of("Alice", "Bob", "", null, "Charlie");

// With wrapper:
List<String> greetings = names.stream()
    .map(ThrowingWrapper.wrap(this::readGreeting))
    .toList();
// "Hello, Alice!", "Hello, Bob!", (exception wrapped), (exception wrapped), "Hello, Charlie!"

// With fallback:
List<String> safeGreetings = names.stream()
    .map(name -> {
        try { return safeGreeting.apply(name); }
        catch (RuntimeException e) { return "Fallback: " + name; }
    }).toList();
```

### Extension

Create a `ThrowingWrapper.wrapWithFallback()` that takes a fallback value and returns it instead of throwing. Also implement a version for `BiFunction<T, U, R>`.
