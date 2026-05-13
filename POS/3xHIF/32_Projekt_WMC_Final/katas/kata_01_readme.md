# Kata 1: README Documentation

| Field | Value |
|-------|-------|
| Concepts | Documentation, README, markdown |
| Difficulty | 1/5 |
| Duration | approx. 20 min |

### Task

Write a README.md for your project. It must include:
1. Project title and short description
2. Domain description and ER diagram (text-based)
3. Technology stack (Java, Javalin, JPA, PostgreSQL, etc.)
4. Setup instructions (clone, configure database, run)
5. API endpoints table
6. Running tests
7. Project structure overview

### Example Output

```markdown
# Library Management API

A REST API for managing a library, built with Java, Javalin, and JPA.

## Domain
Users can borrow books, write reviews, and manage their profile.

## Tech Stack
- Java 17, Javalin 5, Hibernate 6, PostgreSQL, JUnit 5, Mockito

## Setup
1. Clone the repository
2. Create a PostgreSQL database
3. Update persistence.xml
4. Run: ./mvnw compile exec:java
```

### Extension

Add a Changelog section and contribution guidelines.
