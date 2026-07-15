---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 15 - Annotations
## POS - 3xHIF

---

## Agenda (1/2)

1. What are Annotations?
2. Built-in Annotations
3. Defining Custom Annotations
4. @Retention Policy
5. @Target Element Types
6. Annotation Elements
7. Runtime Annotation Processing

---

## Agenda (2/2)

8. Processing Class-level Annotations
9. Processing Field-level Annotations
10. Processing Method-level Annotations
11. Repeatable Annotations
12. Real-world: JPA Annotations
13. Real-world: Jackson
14. Real-world: JUnit

---

## Learning Objectives

- I can explain what annotations are and how they enable declarative programming
- I can define custom annotations with @Retention, @Target, and default values
- I can process annotations at runtime using reflection on classes, fields, and methods
- I can implement repeatable annotations and understand their container pattern
- I can recognize how real-world frameworks like JPA, Jackson, and JUnit use annotations

---

## What are Annotations?

Annotations are metadata attached to Java source code elements (classes, methods, fields, etc.).

- Start with `@` symbol
- Do not directly affect program execution
- Can be processed at compile time, class loading, or runtime

<div class="highlight-box"><p>Annotations enable declarative programming — you say <em>what</em> to do, not <em>how</em>.</p></div>

---

## Discussion: Declarative vs Imperative

<div class="highlight-box">
<p>How do annotations change the way we write code? Does declarative style (“what”) make code easier or harder to understand compared to imperative style (“how”)? Discuss with examples from your own experience.</p>
</div>

---

## Built-in Annotations

```java
@Override           // compiler checks method override
@Deprecated         // marks element as deprecated
@SuppressWarnings   // suppresses compiler warnings
@FunctionalInterface // marks a functional interface
```

These are processed by the compiler (RetentionPolicy.SOURCE or CLASS).

---

## Defining Custom Annotations

```java
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    String unit() default "ms";
}
```

- Use `@interface` keyword
- Define elements like methods
- Provide default values with `default`

---

## @Retention Policy

| Policy | Retained in .class | Available at runtime |
| --- | --- | --- |
| SOURCE | No | No |
| CLASS | Yes | No |
| RUNTIME | Yes | Yes |

Only `RUNTIME` annotations are accessible via reflection.

---

## @Target Element Types

```java
@Target(ElementType.TYPE)       // class, interface, enum
@Target(ElementType.FIELD)      // field
@Target(ElementType.METHOD)     // method
@Target(ElementType.PARAMETER)  // parameter
@Target(ElementType.CONSTRUCTOR) // constructor
@Target(ElementType.ANNOTATION_TYPE) // annotation
@Target({ElementType.FIELD, ElementType.METHOD}) // multiple
```

---

## Annotation Elements

```java
public @interface TaskInfo {
    String author();                    // required
    String description();               // required
    int priority() default 5;           // optional with default
    String[] tags() default {};         // array element
    Status status() default Status.PENDING;  // enum element
}

enum Status { PENDING, IN_PROGRESS, DONE }
```

Valid element types: primitives, String, Class, enum, annotation, arrays of these.

---

## Runtime Annotation Processing

```java
Class<?> clazz = MyService.class;

if (clazz.isAnnotationPresent(LogExecutionTime.class)) {
    LogExecutionTime anno =
        clazz.getAnnotation(LogExecutionTime.class);
    String unit = anno.unit();
    // process annotation...
}
```

Use `isAnnotationPresent()` to check, `getAnnotation()` to retrieve.

---

## Processing Class-level Annotations

```java
for (Class<?> clazz : classes) {
    MyAnnotation anno =
        clazz.getAnnotation(MyAnnotation.class);
    if (anno != null) {
        // process class
    }
}
```

Common in dependency injection and ORM frameworks.

---

## Now Kata 1: @ToString Annotation Processor

Implement a @ToString annotation and processor that generates string representation of annotated objects

---

## Processing Field-level Annotations

```java
for (Field field : clazz.getDeclaredFields()) {
    if (field.isAnnotationPresent(NotNull.class)) {
        field.setAccessible(true);
        Object value = field.get(obj);
        if (value == null) {
            // validation error
        }
    }
}
```

---

## Processing Method-level Annotations

```java
for (Method method : clazz.getDeclaredMethods()) {
    if (method.isAnnotationPresent(LogExecutionTime.class)) {
        long start = System.nanoTime();
        method.invoke(obj);
        long duration = System.nanoTime() - start;
        System.out.println(method.getName()
            + " took " + duration + "ns");
    }
}
```

---

## Now Kata 2: @LogExecutionTime Annotation

Define a @LogExecutionTime annotation and write a processor that measures and logs method execution time

---

## Repeatable Annotations

```java
@Repeatable(Schedules.class)
public @interface Schedule {
    String dayOfWeek();
}

public @interface Schedules {
    Schedule[] value();
}

// Usage:
@Schedule(dayOfWeek = "MON")
@Schedule(dayOfWeek = "WED")
public void weeklyTask() {}
```

---

## Real-world: JPA Annotations

```java
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
}
```

- JPA uses runtime annotation processing to generate SQL
- EntityManager reads annotations to map objects to tables
- Column annotations define database column mappings

---

## Real-world: Jackson

```java
public class Person {
    @JsonProperty("full_name")
    private String name;
    @JsonIgnore
    private String internalId;
}
```

- Jackson uses @JsonProperty, @JsonIgnore for serialization

---

## Now Kata 3: Annotation-driven JSON Serializer

Implement a mini JSON serializer using @JsonProperty and @JsonIgnore annotations

---

## Real-world: JUnit

```java
@Test
@DisplayName("should return 42")
@Tag("fast")
void testAnswer() {
    assertEquals(42, answer());
}
```

- JUnit uses @Test, @DisplayName, @Tag for test discovery

---

## Summary

- Annotations are metadata — `@interface` defines them
- `@Retention` controls lifecycle (SOURCE, CLASS, RUNTIME)
- `@Target` restricts where annotations can be used
- RUNTIME annotations are processed via reflection
- Real-world examples: JPA (@Entity, @Column), Jackson (@JsonProperty), JUnit (@Test)
