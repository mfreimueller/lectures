# Kata 3: Full Mini-Framework

| Field | Value |
|-------|-------|
| Concepts | @Controller, @Get, @Post, @PathVariable, argument resolution |
| Difficulty | 3/5 |
| Duration | approx. 35 min |

### Task

Build a complete mini-framework with:
1. `@Controller(path)` annotation for classes
2. `@Get(path)` and `@Post(path)` annotations for methods
3. `@PathVariable(name)` annotation for method parameters
4. `@Body` annotation for request body parameters
5. A `Framework` class that:
   - Takes a Javalin instance and a list of controller instances
   - Processes all annotations
   - Resolves method arguments (path variables, body)
   - Dynamically invokes handler methods
   - Handles exceptions gracefully

### Example Output

```
$ curl http://localhost:7070/api/users/42
UserResponse[id=42, name=Alice]

$ curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"Bob","email":"bob@test.com"}' \
  http://localhost:7070/api/users
{"id":1,"name":"Bob","email":"bob@test.com"}
```

### Extension

Add @Put and @Delete support, and add automatic JSON serialization of return values.
