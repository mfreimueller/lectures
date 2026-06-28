# Kata 1: Hello Servlet

| Field | Value |
|-------|-------|
| Concepts | Embedded Tomcat, HttpServlet, doGet |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Write a Java program that:
1. Starts an embedded Tomcat server on port 8080
2. Registers a servlet at `/hello` that returns "Hello, Servlets!" as plain text
3. Registers a servlet at `/status` that returns `{"status":"running"}` as JSON

### Example Output

```
$ curl http://localhost:8080/hello
Hello, Servlets!

$ curl http://localhost:8080/status
{"status":"running"}
```

### Extension

Add a `/hello?name=Alice` query parameter so the servlet returns "Hello, Alice!".