# Kata 1: Endpoint Annotations

| Field | Value |
|-------|-------|
| Concepts | Custom annotations, reflection, class scanning |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Defines a `@Endpoint` annotation for classes (with optional path prefix)
2. Defines a `@Get` annotation for methods (with path suffix)
3. Creates a sample class annotated with `@Endpoint("/api")` and `@Get("/hello")`
4. Uses reflection to discover and print all annotated classes, methods, and their paths
5. Simulates scanning by manually loading the class

### Example Output

```
Found controller: DemoEndpoint (base path: /api)
  GET /api/hello -> sayHello()
```

### Extension

Add `@Post` and `@Delete` annotations and discover them too.
