# Exercise: Build a Mini-Framework (Flipped Classroom)

**Type:** Flipped Classroom (Type 3) — Students create a small project to teach a concept to their peers.

**Domain:** Students choose their own domain and framework idea.

**Assigned:** Week 18 (after Annotations)
**Presentations:** Weeks 19–20

---

## Objective

After learning about Reflection and Annotations, you will build a **mini annotation-based framework** and teach it to the class in a 5-minute lightning talk.

This exercise forces you to understand how real frameworks (Spring, JPA, Jackson, JUnit) work internally — by building a simplified version yourself.

---

## How It Works

1. Work in **pairs** (2 students per project)
2. Choose one framework idea from the list below (or propose your own)
3. Build it over 1–2 weeks
4. Present it in a **5-minute lightning talk** to the class
5. Submit your code as a PR for peer code review

---

## Project Ideas

### 1. `@JsonSerialize` — Object-to-JSON Mapper
- Annotate fields with `@JsonProperty(name = "...")` and `@JsonIgnore`
- Use reflection to read annotated fields and build a JSON string
- Support: String, int, double, boolean, nested objects

### 2. `@CsvBind` — Object-to-CSV Mapper
- Annotate fields with `@CsvColumn(index = N, header = "...")`
- Convert objects to CSV rows and back
- Support: automatic type conversion (String ↔ int ↔ double)

### 3. `@Validate` — Reflection-Based Validator
- Annotations: `@NotBlank`, `@MinLength(n)`, `@Max(n)`, `@Email`, `@NotNull`
- `Validator.validate(object)` returns a list of validation errors
- Support: nested object validation

### 4. `@LogExecutionTime` — AOP-Style Method Logger
- Annotation on methods: `@LogExecutionTime`
- Use reflection to wrap method calls, measure execution time, log results
- Support: configurable log format, threshold warnings

### 5. `@Retry` — Automatic Retry Framework
- Annotation: `@Retry(maxAttempts = 3, delay = 1000)`
- Automatically retry methods that throw exceptions
- Support: configurable retry count, delay, backoff strategy

### 6. `@Cached` — Method Result Cache
- Annotation: `@Cached(ttl = 60)`
- Cache method results based on parameters
- Support: configurable TTL, cache invalidation

### 7. `@Inject` — Mini Dependency Injection Container
- Annotation: `@Inject` on constructor or fields
- Scan classes, resolve dependencies, create instances
- Support: singleton vs. prototype scope

### 8. Your Own Idea
- Propose a different annotation-based framework
- Must use reflection + custom annotations at runtime
- Get approval from the instructor before starting

---

## Deliverables

1. **Working code** — Pushed to GitHub, compiles, has tests (JUnit 5)
2. **README** — Explains what the framework does, how to use it, with examples
3. **5-minute presentation** — Live demo + code walkthrough
4. **Peer code review** — Review another pair's project

---

## Presentation Guidelines

Your 5-minute talk should cover:
1. **What** does your framework do? (30 seconds)
2. **How** does it work internally? (2 minutes)
3. **Demo** — Show it in action (1.5 minutes)
4. **Lessons learned** — What was hard? What surprised you? (1 minute)

---

## Evaluation Criteria

| Criterion | Points |
|-----------|--------|
| Working code with tests | 30% |
| Correct use of reflection + annotations | 25% |
| Clear, engaging presentation | 20% |
| Code quality and documentation | 15% |
| Constructive peer code review | 10% |

---

## Tips

- Start simple — get one annotation working before adding more features
- Write tests for your framework's behavior, not just happy paths
- Practice your presentation — 5 minutes goes fast
- Focus on explaining the "how" — your classmates want to understand the internals
