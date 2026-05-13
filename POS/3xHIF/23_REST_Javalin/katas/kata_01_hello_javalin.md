# Kata 1: Hello Javalin

| Field | Value |
|-------|-------|
| Concepts | Javalin setup, GET endpoint, routing |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Creates a Javalin server listening on port 7070
2. Defines a GET endpoint at `/hello` that returns "Hello from Javalin!"
3. Defines a GET endpoint at `/status` that returns JSON: `{"status": "running"}`
4. Start the server and test with curl

### Example Output

```
$ curl http://localhost:7070/hello
Hello from Javalin!

$ curl http://localhost:7070/status
{"status":"running"}
```

### Extension

Add a `/hello/{name}` endpoint that returns a personalized greeting.
