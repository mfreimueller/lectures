# Kata 4: Streams Refactoring

| Field | Value |
|-------|-------|
| Concepts | streams, lambdas, method references, refactoring |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Given the following imperative code, refactor it to use streams, lambdas, and method references:

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<Integer> result = new ArrayList<>();
for (int n : numbers) {
    if (n % 2 == 0) {
        result.add(n * n);
    }
}
Collections.sort(result);
System.out.println(result);
```

Rewrite this using the Streams API:
1. Filter even numbers using a lambda
2. Square them using `map`
3. Collect to a sorted list using method references
4. Print the result

### Example Output

```
[4, 16, 36, 64, 100]
```

### Extension

Add parallel stream processing using `parallelStream()`.
