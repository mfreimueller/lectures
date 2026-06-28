# Kata 2: Auto-Register Routes

| Field | Value |
|-------|-------|
| Concepts | Annotation processing, dynamic route registration, Front Controller |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Write a Java program that:
1. Uses the @Endpoint and @Get annotations from Kata 1
2. Creates a `RouteRegistrar` class that takes a route map and a list of controller instances
3. Processes @Endpoint and @Get annotations to auto-register GET routes
4. Controller methods return String that becomes the response body
5. Demonstrates by starting an embedded Tomcat server with auto-registered routes

### Example Output

```
$ curl http://localhost:8080/api/hello
Hello from annotated endpoint!

$ curl http://localhost:8080/api/status
{"status":"running"}
```

### Extension

Add @Post support for creating resources via POST requests.
