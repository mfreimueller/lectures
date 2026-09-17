---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 09 - Exercise, CLI, Todo
## POS - 3xHIF

---

## Agenda

1. Exercise Overview
2. Task Record
3. Repository Interface
4. CLI Command Structure

---

## Learning Objectives

- I can design a record-based domain model with enums
- I can define and implement a repository interface using streams
- I can build an interactive CLI shell using switch expressions
- I can apply TDD to design APIs before writing implementation
- I can filter and query data using stream operations

---

## Exercise Overview

Build a CLI Todo application with the following components:

- Task record — domain model
- TaskRepository interface — data access contract
- InMemoryTaskRepository — stream-based implementation
- CLI shell — switch expression command parsing

<div class="highlight-box"><p>Apply TDD throughout the entire exercise.</p></div>

---

## Reflection: TDD and API Design

<div class="highlight-box">
<p>How does writing tests first change the way you think about API design? Before writing any implementation, think about what methods your repository needs — does TDD help you discover a cleaner interface?</p>
</div>

---

## Task Record

```java
public record Task(
    int id,
    String title,
    boolean completed,
    Priority priority
) {}
```

- Compact data carrier with built-in equals/hashCode/toString
- Priority can be an enum: LOW, MEDIUM, HIGH
- dueDate wrapped in Optional when accessed

---

## Repository Interface

```java
public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(int id);
    List<Task> findByCompleted(boolean completed);
    List<Task> findByPriority(Priority priority);
    List<Task> findByTag(String tag);
    Task save(Task task);
    void delete(int id);
}
```

Implement all query methods using streams.

---

## CLI Command Structure

```java
switch (command) {
    case "add"  -> addTask(scanner);
    case "list" -> listTasks(scanner);
    case "done" -> markDone(scanner);
    case "remove" -> removeTask(scanner);
    case "exit" -> { return; }
    default -> System.out.println("Unknown command");
}
```

---

## Summary and Goals

- Practice records, streams, and switch expressions
- Write TDD tests for every component
- Pair programming is recommended
- This app will be extended with JDBC in later weeks
