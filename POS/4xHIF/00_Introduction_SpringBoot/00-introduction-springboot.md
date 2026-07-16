---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 00 - Einführung & Spring Boot
## POS - 4xHIF

---

## Kursübersicht

- 4. Klasse POS: Enterprise Software Engineering
- Schwerpunkt: Spring Boot Ökosystem
- Ganzjähriges Gruppenprojekt in 2-3er Teams
- Zwei zentrale Prüfungen (SA1, SA2)
- Abschlusspräsentation am Jahresende

---

## Bewertung

- 2 SA (schriftliche Arbeiten) — zentral definiert
- Gruppenprojekt — Meilensteine, Code Reviews, Abschlusspräsentation
- Katas und Übungen — laufende Bewertung
- Code Reviews — 3 Peer Reviews über das Jahr verteilt

---

## Das Gruppenprojekt

- Eigenes Domain auswählen (Bibliothek, Fitnessstudio, Restaurant, Hotel, ...)
- Über das Jahr eine vollständige Spring Boot Anwendung entwickeln
- REST API + Thymeleaf Frontend + PostgreSQL + Docker
- Meilensteine alle 6-7 Wochen (Präsentationen + Code Reviews)
- Endergebnis: voll funktionsfähige Enterprise Anwendung

---

## Wiederholung: Stack der 3. Klasse

- Java 21+ (Records, Streams, Optional, Pattern Matching)
- JUnit 5, Mockito, AssertJ
- SOLID Prinzipien, TDD, Layered Architecture
- JDBC, JPA, Hibernate, PostgreSQL
- HTTP, REST, Jakarta Servlet API (manuelles Request-Handling, Routing, JSON Serialisierung)

---

## Von Jakarta Servlet zu Spring Boot

Ihr habt REST Endpunkte mit doGet/doPost, manuellem JSON-Parsing und expliziten Status Codes gebaut

Spring Boot eliminiert den Boilerplate-Code bei vollem Zugriff auf HTTP-Semantik

<div class="highlight-box">
<p>Gleiche HTTP/REST Konzepte — deklarativ statt imperativ</p>
</div>

---

## Vorher: Jakarta Servlet

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

## Nachher: Spring Boot

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

Kein manuelles JSON, kein `setContentType`, kein `InputStream` — Spring erledigt alles.

---

## Warum Spring Boot?

- Convention over Configuration — sinnvolle Standardwerte
- Embedded Tomcat — kein separater Server nötig
- Riesiges Ökosystem: Security, Data, Cloud, Actuator
- Industriestandard in österreichischen Unternehmen
- Relevant für Matura und Praktika
- Servlet Filters → Spring Security FilterChain (gleiches Konzept, deklarative Konfiguration)

---

## Spring Initializr

- https://start.spring.io/
- Konfigurieren: Maven/Gradle, Java, Spring Boot Version
- Abhängigkeiten auswählen (starten mit Spring WebMVC + DevTools)
- Generieren → downloaden → entpacken → im IDE öffnen

---

## Projektstruktur

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

## pom.xml Grundlagen

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

## Erster REST Controller

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

## JSON zurückgeben

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

Spring Boot serialisiert Records automatisch zu JSON via Jackson.

---

## Testen im Browser

```bash
./mvnw spring-boot:run
curl http://localhost:8080/hello
curl http://localhost:8080/hello/Alice
```

Oder einfach http://localhost:8080/hello im Browser öffnen.

---

## Spring Boot DevTools

- Automatischer Restart bei Dateiänderungen
- LiveReload Browser Extension (optional)
- Standardmäßig in Produktion deaktiviert
- Wird über `spring-boot-devtools` Abhängigkeit eingebunden

---

## GitHub Classroom Setup

- Einladungslink annehmen
- Team erstellen oder beitreten
- Repository klonen
- Spring Boot Projekt pushen
- Überprüfen: Alle Teammitglieder können pullen, ändern, pushen

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

## Was wir heute gelernt haben

- Kursstruktur und das ganzjährige Projekt
- Warum Spring Boot die manuelle Servlet Programmierung verbessert
- Erstellen eines Spring Boot Projekts mit Initializr
- Schreiben eines REST Controllers mit @Mapping
- JSON Antworten mit Records zurückgeben
