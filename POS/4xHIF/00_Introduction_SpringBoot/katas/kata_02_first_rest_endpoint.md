# Kata 2: First REST Endpoint

| Field | Value |
|-------|-------|
| Concepts | @RestController, @GetMapping, JSON, HTTP |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a new class `HelloController` in the project package
2. Annotate it with `@RestController`
3. Add a method `sayHello()` that returns a `String` and is mapped to `GET /hello`
4. The method should return `Hello from Spring Boot!`
5. Add a second method `sayHelloName(@PathVariable String name)` mapped to `GET /hello/{name}`
6. Return a personalised greeting like `Hello, Alice!`
7. Start the application and test both endpoints in the browser:
   - `http://localhost:8080/hello`
   - `http://localhost:8080/hello/Alice`
8. Change the return type from `String` to a `record` with a `message` field and observe how the response changes to JSON

### Example Output

```
GET http://localhost:8080/hello
{"message": "Hello from Spring Boot!"}

GET http://localhost:8080/hello/Alice
{"message": "Hello, Alice!"}
```

### Extension

Add a third endpoint `GET /info` that returns a JSON object with `teamName`, `members` (as a list), and `version`.
