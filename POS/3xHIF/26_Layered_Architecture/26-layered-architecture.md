---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 26 - Servlets: Http Servlet, Embedded Tomcat, Request/Response
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: HTTP & REST
2. Servlet Container & Embedded Tomcat
3. HttpServlet & Lifecycle
4. HttpServletRequest – Reading Requests

---

## Agenda (2/2)

5. HttpServletResponse – Writing Responses
6. Practical Example: Todo API
7. Recap & Outlook

---

## Learning Objectives

- I can start an embedded Tomcat server
- I can write an HttpServlet with doGet/doPost
- I can read request data (parameters, headers, body)
- I can manually produce JSON responses
- I understand the servlet lifecycle

---

## Review: HTTP

- HTTP is a stateless request-response protocol
- Methods: `GET` (read), `POST` (create), `PUT` (replace), `DELETE` (delete)
- Status codes: `200` OK, `201` Created, `400` Bad Request, `404` Not Found, `500` Server Error
- REST principle: Address resources via URIs (`/api/todos`)

<div class="highlight-box">
<p>A web server must speak HTTP – servlets are the Java standard API for it.</p>
</div>

---

## Servlet Container

- A servlet container (e.g., Tomcat) is a Java program that hosts servlets
- It receives HTTP requests and forwards them to the appropriate servlet
- Classic: Tomcat is installed, servlets deployed as `.war` files
- Modern: Embedded Tomcat – we start Tomcat from `main()`

---

## Embedded Tomcat

Maven dependency:

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-core</artifactId>
    <version>11.0.23</version>
</dependency>
```

No external Tomcat installation needed – everything in a single `main()` method!

---

## Starting Tomcat

```java
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws Exception {
        var tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        var ctx = tomcat.addContext("", "/");
        Tomcat.addServlet(ctx, "hello", new HelloServlet());
        ctx.addServletMappingDecoded("/hello", "hello");

        tomcat.start();
        tomcat.getServer().await();
    }
}
```

---

## Starting Tomcat – Result

The server runs until we stop it with `Ctrl+C`.

---

## HttpServlet & Lifecycle

```java
public class MyServlet extends HttpServlet {

    @Override
    public void init() {
        // Called once at startup
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) {
        // Called on every GET request
    }

    @Override
    public void destroy() {
        // Called on shutdown
    }
}
```

---

## Servlet Lifecycle in Detail

| Phase | When? | How often? |
| --- | --- | --- |
| `init()` | On first load of the servlet | Once |
| `service()` | On every HTTP request | Thread-safe! |
| `doGet() / doPost()` | Depending on HTTP method | Per request |
| `destroy()` | On shutdown | Once |

<div class="highlight-box">
<p>A servlet is instantiated <strong>once</strong> and serves <strong>all</strong> requests.</p>
</div>

---

## HttpServletRequest – Methods (1)

| Method | Description |
| --- | --- |
| `getMethod()` | HTTP method: GET, POST, PUT, DELETE |
| `getRequestURI()` | Full path: `/api/todos/42` |
| `getPathInfo()` | Path after the servlet mapping |
| `getQueryString()` | Query part: `?name=Alice` |

---

## HttpServletRequest – Methods (2)

| Method | Description |
| --- | --- |
| `getParameter("key")` | Read query/form parameters |
| `getHeader("Name")` | Read HTTP headers |
| `getReader()` | Request body as `BufferedReader` |
| `getContentType()` | Content-Type of the request |

---

## Practice: GET with Query Parameters

```java
@Override
protected void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
        throws IOException {
    var name = req.getParameter("name");
    if (name == null) name = "World";

    resp.setContentType("text/plain");
    resp.setStatus(200);
    resp.getWriter().println("Hello, " + name + "!");
}
```

Test: `curl "http://localhost:8080/hello?name=Alice"`

---

## Practice: POST with Body

```java
@Override
protected void doPost(HttpServletRequest req,
                      HttpServletResponse resp)
        throws IOException {
    var body = req.getReader().lines()
        .collect(Collectors.joining());

    System.out.println("Received: " + body);

    resp.setStatus(201);
    resp.setContentType("text/plain");
    resp.getWriter().println("OK: " + body.length() + " characters");
}
```

Test: `curl -d '{"title":"Learn"}' -H "Content-Type: application/json" http://localhost:8080/todos`

---

## HttpServletResponse – Methods (1/2)

| Method | Description |
| --- | --- |
| `setStatus(int)` | Set HTTP status code |
| `setContentType(String)` | Content-Type: `application/json` |
| `setCharacterEncoding(String)` | Encoding: `UTF-8` |

---

## HttpServletResponse – Methods (2/2)

| Method | Description |
| --- | --- |
| `getWriter()` | Text output stream |
| `getOutputStream()` | Binary output stream |
| `setHeader(String, String)` | Set response header |

---

## Manual JSON Responses

```java
resp.setContentType("application/json");
resp.setCharacterEncoding("UTF-8");
resp.setStatus(200);
resp.getWriter().println("{\"id\":1,\"title\":\"Learn Servlets\"}");
```

<div class="highlight-box">
<p>Later we'll use Jackson – for now, string concatenation is enough.</p>
</div>

---

## Setting Status Codes Correctly

| Situation | Status Code |
| --- | --- |
| Resource found (GET) | `200` |
| Resource created (POST) | `201` |
| Validation error | `400` |
| Resource not found | `404` |
| Internal server error | `500` |

```java
if (id == null) {
    resp.sendError(400, "ID is missing");
    return;
}
```

---

## Setting & Reading Headers

```java
// Read request headers
var auth = req.getHeader("Authorization");
var lang = req.getHeader("Accept-Language");

// Set response headers
resp.setHeader("Location", "/api/todos/42");
resp.setHeader("X-API-Version", "1.0");

// CORS headers for browser clients
resp.setHeader("Access-Control-Allow-Origin", "*");
```

---

## A Complete Todo Servlet

```java
public class TodoServlet extends HttpServlet {
    private final Map<Long, String> todos = new HashMap<>();
    private long nextId = 1;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setStatus(200);
        var json = todos.entrySet().stream()
            .map(e -> "{\"id\":" + e.getKey()
                    + ",\"title\":\"" + e.getValue() + "\"}")
            .toList()
            .toString();
        resp.getWriter().println(json);
    }
}
```

---

## POST – Create a Todo

```java
@Override
protected void doPost(HttpServletRequest req,
                      HttpServletResponse resp)
        throws IOException {
    var body = req.getReader().readLine();
    // body = "title=Learn"
    var title = body.replace("title=", "");

    var id = nextId++;
    todos.put(id, title);

    resp.setStatus(201);
    resp.setContentType("application/json");
    resp.getWriter().println(
        "{\"id\":" + id + ",\"title\":\"" + title + "\"}");
}
```

---

## DELETE – Delete a Todo

```java
@Override
protected void doDelete(HttpServletRequest req,
                        HttpServletResponse resp) {
    var path = req.getPathInfo(); // "/42"
    if (path == null || path.equals("/")) {
        resp.setStatus(400);
        return;
    }
    var id = Long.parseLong(path.substring(1));
    if (todos.remove(id) != null) {
        resp.setStatus(204); // No Content
    } else {
        resp.setStatus(404);
    }
}
```

---

## Error Handling in Servlets

```java
@Override
protected void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
        throws IOException {
    try {
        var id = Long.parseLong(req.getParameter("id"));
        var todo = todos.get(id);
        if (todo == null) {
            resp.sendError(404, "Todo not found");
            return;
        }
        // ... write response
    } catch (NumberFormatException e) {
        resp.sendError(400, "Invalid ID");
    }
}
```

---

## Now Kata 1: Add a Service Layer

Add a TodoService interface between Commands and Repository with validation logic.

---

## Registering Multiple Servlets

```java
Tomcat.addServlet(ctx, "todos", new TodoServlet());
ctx.addServletMappingDecoded("/api/todos/*", "todos");
Tomcat.addServlet(ctx, "users", new UserServlet());
ctx.addServletMappingDecoded("/api/users/*", "users");
```

<div class="highlight-box">
<p>Each servlet is responsible for a path range.</p>
</div>

---

## Now Kata 2: Split a Fat Command

Extract a TodoRepository interface from a monolithic ListTodosCmd and implement InMemoryTodoRepository.

---

## ServletConfig & Init Parameters

```java
public class ConfigServlet extends HttpServlet {
    @Override
    public void init() {
        var dbUrl = getServletConfig()
            .getInitParameter("db.url");
        var maxSize = getServletConfig()
            .getInitParameter("max.size");
    }
}

// When registering:
var servlet = Tomcat.addServlet(ctx, "config",
    new ConfigServlet());
servlet.setInitParameter("db.url",
    "jdbc:postgresql://localhost/mydb");
servlet.setInitParameter("max.size", "100");
```

---

## Thread Safety in Servlets

- A servlet is instantiated **once**
- All requests run **in parallel** in their own threads
- Instance variables are shared by **all** threads

<div class="highlight-box">
<p>Thread safety must be considered! Use local variables or synchronization.</p>
</div>

```java
// OK: local variable (per request)
public void doGet(...) {
    var list = fetchFromDatabase(); // local
}

// Dangerous: shared state
private int counter = 0; // not thread-safe!
```

---

## Now Kata 3: Test the Service Layer

Write JUnit 5 tests for TodoService using AssertJ and optionally Mockito.

---

## Discussion: Why is shared mutable state in servlets dangerous?

<div class="highlight-box">
<p>Shared mutable state is one of the most common sources of production bugs in web applications. How do you prevent race conditions when a single servlet instance handles concurrent requests?</p>
</div>

---

## Summary (1/2)

- `HttpServlet` is the Java standard API for HTTP handlers
- Embedded Tomcat starts from `main()` – no external server needed
- `HttpServletRequest` provides access to all request data

---

## Summary (2/2)

- `HttpServletResponse` controls status, headers, and body
- Servlets are registered programmatically (no XML, no annotations)
- Mind thread safety: prefer local variables
