---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 14 - Reflection
## POS - 3xHIF

---

## Agenda (1/2)

1. What is Reflection?
2. The Class Object
3. Inspecting Class Metadata
4. Inspecting Methods
5. Inspecting Fields
6. Inspecting Constructors
7. Dynamic Method Invocation

---

## Agenda (2/2)

8. Dynamic Field Access
9. Working with Constructors
10. setAccessible and Encapsulation
11. Arrays via Reflection
12. Performance Considerations
13. Practical Use Cases

---

## Learning Objectives

- I can explain what Reflection is and why frameworks depend on it
- I can inspect classes, methods, fields, and constructors at runtime using the Class object
- I can invoke methods and access fields dynamically without compile-time type knowledge
- I can create instances dynamically using Constructor.newInstance()
- I can evaluate the performance and security trade-offs of using setAccessible()

---

## What is Reflection?

Reflection is the ability of a program to inspect and modify its own structure and behavior at runtime.

- Inspect classes, methods, fields, constructors at runtime
- Invoke methods and access fields dynamically
- Create instances without compile-time type knowledge

<div class="highlight-box"><p>Reflection is the foundation of frameworks like Spring, JPA, and Jackson.</p></div>

---

## The Class Object

Every Java class has a corresponding `Class<?>` object that contains metadata.

```java
// Three ways to get a Class object
Class<String> c1 = String.class;
Class<?> c2 = "hello".getClass();
Class<?> c3 = Class.forName("java.lang.String");
```

The Class object is the entry point for all reflection operations.

---

## Inspecting Class Metadata

```java
Class<?> clazz = Person.class;

String name = clazz.getName();        // fully qualified
String simpleName = clazz.getSimpleName();  // simple name
Package pkg = clazz.getPackage();     // package
int mods = clazz.getModifiers();      // public, abstract, etc.
Class<?> superClass = clazz.getSuperclass();
Class<?>[] interfaces = clazz.getInterfaces();
```

---

## Inspecting Methods

```java
Class<?> clazz = Person.class;

Method[] methods = clazz.getMethods();
// all public methods including inherited

Method[] declared = clazz.getDeclaredMethods();
// all methods declared in this class

Method m = clazz.getDeclaredMethod("getName");
Method m2 = clazz.getDeclaredMethod(
    "setName", String.class);
```

---

## Inspecting Fields

```java
Class<?> clazz = Person.class;

Field[] fields = clazz.getFields();
// all public fields including inherited

Field[] declared = clazz.getDeclaredFields();
// all fields declared in this class

Field f = clazz.getDeclaredField("name");
```

---

## Inspecting Constructors

```java
Class<?> clazz = Person.class;

Constructor<?>[] ctors = clazz.getConstructors();
Constructor<?> ctor = clazz.getDeclaredConstructor(
    String.class, int.class);

// Inspect parameter types
Class<?>[] paramTypes = ctor.getParameterTypes();
```

---

## Now Kata 1: Class Inspector

Write a utility class that uses reflection to print the structure of any given class (fields, constructors, methods)

---

## Dynamic Method Invocation

```java
Person p = new Person("Alice", 30);
Class<?> clazz = p.getClass();

Method getName = clazz.getDeclaredMethod("getName");
String name = (String) getName.invoke(p);
// → "Alice"

Method setName = clazz.getDeclaredMethod(
    "setName", String.class);
setName.invoke(p, "Bob");
// p.getName() → "Bob"
```

---

## Dynamic Field Access

```java
Person p = new Person("Alice", 30);
Class<?> clazz = p.getClass();

Field nameField = clazz.getDeclaredField("name");
nameField.setAccessible(true);  // bypass private

String name = (String) nameField.get(p);
nameField.set(p, "Bob");
```

---

## Now Kata 2: Dynamic Getter/Setter Invoker

Implement a generic utility that uses reflection to invoke all getters and setters on any Java object

---

## Working with Constructors

```java
Class<?> clazz = Class.forName("Person");

Constructor<?> ctor =
    clazz.getDeclaredConstructor(String.class, int.class);
Object person = ctor.newInstance("Alice", 30);

// Equivalent to: new Person("Alice", 30)
```

---

## setAccessible and Encapsulation

- `setAccessible(true)` suppresses access control checks
- Allows access to private, protected, and package-private members
- Introduced in Java 9: module system restricts reflective access by default
- `--add-opens` JVM flag to open packages for reflection
- Use with caution — breaks encapsulation and can impact security

---

## Now Kata 3: Private Field Accessor with Validation

Build a validation framework that uses reflection to read private fields and check for @NotNull constraints

---

## Reflection: Is setAccessible Justified?

<div class="highlight-box">
<p>Is bypassing access control with setAccessible ever justified in production code? Consider frameworks like Spring, JPA, and Jackson — they all rely on it. Where do you draw the line between framework infrastructure and application code?</p>
</div>

---

## Arrays via Reflection

```java
// Create an array dynamically
int[] array = (int[]) Array.newInstance(
    int.class, 5);

// Set and get values
Array.set(array, 0, 42);
int value = (int) Array.get(array, 0);
// → 42
```

The `java.lang.reflect.Array` utility class provides dynamic array operations.

---

## Performance Considerations

- Reflection is slower than direct code — method invocation is ~100x slower
- Caching reflected Method/Field objects improves performance
- JVM can inline reflective calls after warmup (in some cases)
- Use `MethodHandles` (Java 7+) for better performance
- `invokedynamic` (Java 7+) enables efficient dynamic calls

<div class="highlight-box"><p>Prefer static types when possible. Use reflection only when necessary.</p></div>

---

## Practical Use Cases

- Dependency injection frameworks (Spring, Guice)
- Object-relational mapping (JPA, Hibernate)
- Serialization/deserialization (Jackson, Gson)
- Testing frameworks (JUnit, TestNG)
- Dynamic proxies (AOP, Spring aspects)

---

## Summary

- `Class<?>` is the entry point for all reflection
- Inspect methods, fields, constructors via `getDeclared*`
- Invoke methods with `Method.invoke()`
- Access fields with `Field.get()` / `Field.set()`
- Create instances with `Constructor.newInstance()`
