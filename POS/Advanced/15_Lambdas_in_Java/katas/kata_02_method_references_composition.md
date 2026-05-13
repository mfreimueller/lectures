# Kata 2: Methodenreferenzen & Komposition

| Field | Value |
|-------|-------|
| Concepts | Method References, Function Composition, andThen, compose |
| Difficulty | 3/5 |
| Duration | approx. 35 min |

### Task

Build an email processing pipeline using method references and function composition.

1. Create a list of email addresses (some valid, some invalid, some null)
2. Use a **static method reference** (`Class::staticMethod`) to validate emails (check for `@`)
3. Use an **instance method reference** on a specific object (`instance::method`) to extract the domain part
4. Use an **instance method reference of a class** (`Class::instanceMethod`) like `String::toLowerCase`
5. Use a **constructor reference** (`Class::new`) to create `StringBuilder` or custom objects
6. Compose two functions using `andThen()` and `compose()` to build a normalization pipeline
7. Combine `Predicate` with `and()`/`or()` for multi-step filtering

### Example Output

```java
List<String> emails = List.of(
    "alice@example.com", "bob@gmail.com",
    "invalid-email", null, "dave@gmail.com"
);

// After filtering and transforming:
// Valid:    [alice@example.com, bob@gmail.com, dave@gmail.com]
// Domains:  [example.com, gmail.com, gmail.com]
// Unique:   2 domains
```

### Extension

Create a report using `Collectors.joining()` and method references. Count how many emails per domain and print a summary. Use `Function.identity()` and `Function::andThen` to create reusable pipeline stages.
