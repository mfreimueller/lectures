---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 28 - Projekt WMC
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Layered Architecture
2. Review: Front Controller & Servlets
3. POS-WMC Project Overview
4. Project Requirements
5. Choosing a Domain

---

## Agenda (2/2)

6. Database Model: 6 Tables Minimum
7. Entity Relationships
8. Maven Project Setup
9. Layered Architecture
10. Project Deliverables This Week

---

## Learning Objectives

- I can choose a suitable project domain with at least 6 tables
- I can design an ER diagram with 1:1, 1:n, and inheritance relationships
- I can set up a Maven project with Tomcat, Hibernate, PostgreSQL, and Jackson dependencies
- I can plan a layered architecture with Controller, Service, Repository, and Model packages

---

## Review: Layered Architecture

- Controller: handles HTTP requests and responses
- Service: contains business logic
- Repository: data access layer (JPA)
- DTO: data transfer objects for request/response

---

## Review: Front Controller & Servlets

```java
var routes = new HashMap<String, Command>();
routes.put("GET:/api/items", (req, resp) -> {
    resp.setContentType("application/json");
    new ObjectMapper().writeValue(
        resp.getWriter(), itemService.findAll());
});
Tomcat.addServlet(ctx, "api",
    new FrontControllerServlet(routes));
```

---

## POS-WMC Project Overview

- Solo project: REST API + Web Frontend
- POS: backend (REST API with Servlets + JPA)
- WMC: frontend (web UI)
- Duration: weeks 28 to 33
- Your own domain, your own database model

---

## Project Requirements

- At least 6 database tables
- At least one 1:n relationship
- At least one inheritance case
- Authentication (login/registration)
- Full CRUD for all entities

---

## Reflection: Why Do These Requirements Exist?

<div class="highlight-box">
<p>Why do the project requirements (6 tables, inheritance, authentication) mirror real-world enterprise project constraints? What would happen if you skipped any of these in a production system?</p>
</div>

---

## Choosing a Domain

Possible domains:

- Library management system
- Fitness studio / gym
- Restaurant / cafe
- Hotel reservation system
- E-commerce / shop

---

## Now Kata 1: Project Domain Brainstorming

Brainstorm 3 different project domains with tables, relationships, and inheritance.

---

## Database Model: 6 Tables Minimum

Example: Library

- User (auth)
- Book, Author, Category
- Loan (1:n between User and Book)
- Review (1:n between User and Book)
- Inheritance: PhysicalBook vs EBook

---

## Now Kata 2: ER Diagram

Draw an ER diagram for your chosen project domain with at least 6 entities and all relationship types.

---

## Entity Relationships

- **1:1** - e.g. User - Address
- **1:n** - e.g. Category - Book
- **Inheritance** - e.g. Book (PhysicalBook, EBook)

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Book { }

@Entity
public class PhysicalBook extends Book { }

@Entity
public class EBook extends Book { }
```

---

## Maven Project Setup

```xml
<dependencies>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-core</artifactId>
        <version>10.1.28</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.2.0</version>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.6.0</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.17.0</version>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.4.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## Now Kata 3: Maven Project Setup

Create a Maven project skeleton with proper package structure and dependencies.

---

## Layered Architecture

```
src/main/java/com/example/project/
  ├── controller/
  ├── service/
  ├── repository/
  └── model/
```

<div class="highlight-box"><p>Controller - Service - Repository: each layer has a clear responsibility.</p></div>

---

## Project Deliverables This Week

- Domain decision and brief description
- ER diagram (at least 6 tables)
- Maven project skeleton with dependencies
- Architecture plan (plan.md)

---

## Summary

<div class="highlight-box">
<ul>
<li>Choose your own project domain</li>
<li>Define a database model with 6+ tables</li>
<li>Set up the project with Maven, JPA, Servlets</li>
<li>Plan the layered architecture</li>
</ul>
</div>
