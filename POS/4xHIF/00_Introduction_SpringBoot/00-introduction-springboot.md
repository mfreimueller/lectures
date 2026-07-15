---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 00 - Introduction & Spring Boot
## POS - 4xHIF

---

## Course Overview

- 4th Grade POS: Enterprise Software Engineering
- Focus: Spring Boot ecosystem
- Year-long group project in teams of 2-3
- Two centralized exams (SA1, SA2)
- Final project presentation at year end

---

## Grading

- 2 SA (schriftliche Arbeiten) — centrally defined
- Group project — milestones, code reviews, final presentation
- Katas and exercises — ongoing assessment
- Code reviews — 3 peer reviews throughout the year

---

## The Group Project

- Choose your own domain (library, gym, restaurant, hotel, ...)
- Build a full Spring Boot application over the year
- REST API + Thymeleaf frontend + PostgreSQL + Docker
- Milestones every 6-7 weeks (presentations + code reviews)
- Final product: fully functional enterprise application

---

## Recap: 3rd Grade Stack

- Java 21+ (Records, Streams, Optional, Pattern Matching)
- JUnit 5, Mockito, AssertJ
- SOLID Principles, TDD, Layered Architecture
- JDBC, JPA, Hibernate, PostgreSQL
- HTTP, REST, Jakarta Servlet API (manual request handling, routing, JSON serialization)

---

## From Jakarta Servlet to Spring Boot

You've built REST endpoints with doGet/doPost, manual JSON parsing, and explicit status codes

Spring Boot eliminates the boilerplate while keeping full control over HTTP semantics

<div class="highlight-box">
<p>Same HTTP/REST concepts — declarative instead of imperative</p>
</div>

---

## Before: Jakarta Servlet

```java
@WebServlet("/api/books")
public class BookServlet extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws IOException {
        Book book = mapper.readValue(req.getInputStream(), Book.class);
        // ... save to database ...
        resp.setContentType("application/json");
        resp.setStatus(201);
        mapper.writeValue(resp.getOutputStream(), book);
    }
}
```

---

## After: Spring Boot

```java
@RestController
@RequestMapping("/api/books")
public class BookController {

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        // ... save to database ...
        return ResponseEntity.status(201).body(book);
    }
}
```

No manual JSON, no `setContentType`, no `InputStream` — Spring handles it all.

---

## Why Spring Boot?

- Convention over Configuration — sensible defaults
- Embedded Tomcat — no separate server needed
- Massive ecosystem: Security, Data, Cloud, Actuator
- Industry standard in Austrian enterprises
- Relevant for Matura and internships
- Servlet Filters → Spring Security FilterChain (same concept, declarative config)

---

## Spring Initializr

- https://start.spring.io/
- Configure: Maven/Gradle, Java, Spring Boot version
- Select dependencies (start with Spring WebMVC + DevTools)
- Generate → download → extract → open in IDE

---

## Project Structure

```plaintext
project/
├── pom.xml                          (or build.gradle)
├── src/
│   ├── main/
│   │   ├── java/at/spengergasse/
│   │   │   └── TeamprojectApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/at/spengergasse/
│           └── TeamprojectApplicationTests.java
```

---

## pom.xml Essentials

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>4.1.0</version>
</parent>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webmvc</artifactId>
    </dependency>
</dependencies>
```

---

## First REST Controller

```java
package at.spengergasse;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
}
```

---

## Path Variables

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
```

---

## Returning JSON

```java
// Using a record
public record Greeting(String message) {}

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Greeting sayHello() {
        return new Greeting("Hello from Spring Boot!");
    }
}
```

Spring Boot automatically serializes records to JSON via Jackson.

---

## Testing in the Browser

```bash
./mvnw spring-boot:run
curl http://localhost:8080/hello
curl http://localhost:8080/hello/Alice
```

Or simply open http://localhost:8080/hello in your browser.

---

## Spring Boot DevTools

- Automatic restart when files change
- LiveReload browser extension (optional)
- Disabled in production by default
- Included via `spring-boot-devtools` dependency

---

## GitHub Classroom Setup

- Accept the invitation link
- Create or join your team
- Clone the repository
- Push your Spring Boot project
- Verify: all team members can pull, modify, push

---

## Team Workflow

```bash
git clone <repo-url>
git add .
git commit -m "Initial project setup"
git push
git pull
git add .
git commit -m "Added greeting endpoint"
git push
```

---

## What We Learned Today

- Course structure and the year-long project
- Why Spring Boot improves on manual Servlet programming
- Creating a Spring Boot project with Initializr
- Writing a REST controller with @GetMapping
- Returning JSON responses using records
