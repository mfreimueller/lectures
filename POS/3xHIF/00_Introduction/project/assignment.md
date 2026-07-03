# Student Grades Refactoring

## Part A — Explore & Discuss

Open the Maven project in IntelliJ via `pom.xml` and explore the three classes.

Discuss the following questions with your partner:

1. What does each class do? Trace the flow from `Main` through `GradeCalculator` to `StudentGrade`.
2. How much of the `StudentGrade` class is actual data versus boilerplate code?
3. What patterns do you notice about the variable declarations in `GradeCalculator` and `Main`?
4. Are these classes mutable or immutable? What are the trade-offs?
5. What problems could arise from having setters on `StudentGrade`?
6. If you were to write this project from scratch, what would you do differently?

---

## Part B — Refactor

Apply what you learned about `var` and `records`:

### Step 1: Bump Java Version

Change `pom.xml` so the project uses Java 25 instead of Java 11:

```xml
<maven.compiler.source>25</maven.compiler.source>
<maven.compiler.target>25</maven.compiler.target>
```

### Step 2: Identify structure that could be converted into a Record

Think about any classes in the project that act essentially as data carriers
and that don't rely on mutable data.

### Step 3: Replace Explicit Types with `var`

Identify variable declarations with explicit types and convert them to `var`.

### Step 4: Verify

Run `mvn clean compile` and confirm the project builds successfully. Then run the `Main` class directly from IntelliJ.

### Discuss After Refactoring

1. How many lines of code were removed from `StudentGrade`?
2. Does the code still behave the same way?
3. When does `var` make code easier to read? When might it make it harder?
4. What happens if you try to call `setGrade` on a record?
