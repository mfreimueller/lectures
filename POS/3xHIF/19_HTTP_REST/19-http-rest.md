---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 19 - HTTP, REST
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: JDBC Recap
2. Review: Repository Pattern
3. What is HTTP?
4. HTTP Structure
5. HTTP Methods
6. HTTP Status Codes

---

## Agenda (2/2)

7. REST Principles
8. REST Resource Design
9. Java HttpClient
10. HttpClient: GET Request
11. HttpClient: POST Request
12. Parsing JSON with Records

---

## Learning Objectives

- I can explain the HTTP request-response model and its components
- I can choose the correct HTTP method and status code for a given operation
- I can design RESTful resource URIs following best practices
- I can use Java HttpClient to send GET and POST requests
- I can parse JSON responses into Java records

---

## Review: JDBC Recap

- JDBC provides database access via Connection, Statement, ResultSet
- PreparedStatement prevents SQL injection
- DAO pattern separates data access from business logic
- JPA provides ORM: entities, relationships, JPQL queries

---

## Review: Repository Pattern

- Repository abstracts data access behind an interface
- Enables switching implementations (in-memory, JDBC, JPA)
- Key methods: findById, findAll, save, delete

<div class="highlight-box">
<p>Today we move from data persistence to network communication.</p>
</div>

---

## What is HTTP?

- Hypertext Transfer Protocol
- Client-server protocol for distributed systems
- Request-response model
- Stateless: each request is independent

```http
GET /api/users HTTP/1.1
Host: jsonplaceholder.typicode.com
Accept: application/json
```

---

## HTTP Structure

- Request: Method + URL + Headers + Body (optional)
- Response: Status Code + Headers + Body
- Headers carry metadata (content type, auth, caching)
- Body carries payload (JSON, XML, form data)

---

## HTTP Methods

| Method | Purpose | CRUD |
| --- | --- | --- |
| GET | Retrieve a resource | Read |
| POST | Create a new resource | Create |
| PUT | Update/replace a resource | Update |
| DELETE | Delete a resource | Delete |
| PATCH | Partial update | Update |

---

## HTTP Status Codes

| Code | Meaning |
| --- | --- |
| 200 | OK (successful GET/PUT) |
| 201 | Created (successful POST) |
| 204 | No Content (successful DELETE) |
| 400 | Bad Request (client error) |
| 404 | Not Found |
| 500 | Internal Server Error |

---

## REST Principles

- Resource-oriented: everything is a resource (users, posts, products)
- Each resource has a unique URI
- Standard HTTP methods for CRUD operations
- Stateless: server does not store client state
- Representations: JSON, XML, etc.

---

## Reflection: Is REST the only way to build APIs?

<div class="highlight-box">
<p>When might you choose RPC or GraphQL instead of REST? What trade-offs do you make with each approach?</p>
</div>

---

## REST Resource Design

```http
GET    /api/users        # List all users
GET    /api/users/1      # Get user with id 1
POST   /api/users        # Create a new user
PUT    /api/users/1      # Update user with id 1
DELETE /api/users/1      # Delete user with id 1
```

<div class="highlight-box">
<p>Resources are nouns, not verbs. Use /users not /getUsers.</p>
</div>

---

## Java HttpClient

Introduced in Java 11. Modern, non-blocking HTTP client.

```java
var client = HttpClient.newHttpClient();

var request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/users"))
    .GET()
    .build();

HttpResponse<String> response =
    client.send(request, HttpResponse.BodyHandlers.ofString());
```

---

## HttpClient: GET Request

```java
var client = HttpClient.newHttpClient();
var request = HttpRequest.newBuilder()
    .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
    .header("Accept", "application/json")
    .GET()
    .build();

var response = client.send(request, BodyHandlers.ofString());
System.out.println("Status: " + response.statusCode());
System.out.println("Body: " + response.body());
```

---

## HttpClient: POST Request

```java
var json = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

var request = HttpRequest.newBuilder()
    .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
    .header("Content-Type", "application/json")
    .POST(BodyPublishers.ofString(json))
    .build();

var response = client.send(request, BodyHandlers.ofString());
System.out.println(response.statusCode()); // 201
```

---

## Parsing JSON with Records

```java
public record Post(int userId, int id, String title, String body) {}

// Using Jackson ObjectMapper
var mapper = new ObjectMapper();
var post = mapper.readValue(response.body(), Post.class);
System.out.println(post.title());

// Manual parsing with string operations (simple case)
var title = response.body()
    .replaceAll(".*\"title\":\"([^\"]+)\".*", "$1");
```

---

## Summary

- HTTP is a stateless request-response protocol
- REST uses HTTP methods for CRUD on resources
- Java HttpClient provides a modern API for HTTP requests
- JSON responses can be parsed into Java records

---

## Best Practices

- Use meaningful resource URIs (plural nouns)
- Return appropriate status codes
- Handle errors gracefully (try-catch around HTTP calls)
- Use timeouts to avoid blocking indefinitely
- Set proper headers (Content-Type, Accept)
