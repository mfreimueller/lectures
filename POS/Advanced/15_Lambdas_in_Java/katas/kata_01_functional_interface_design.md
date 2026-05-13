# Kata 1: Functional Interface Design

| Field | Value |
|-------|-------|
| Concepts | Functional Interface, @FunctionalInterface, Consumer, Function, Predicate, Supplier |
| Difficulty | 2/5 |
| Duration | approx. 30 min |

### Task

Design a small validation framework using functional interfaces.

1. Define your own `@FunctionalInterface` named `Validator<T>` with a method `boolean isValid(T value)`
2. Add default methods `and(Validator)` and `or(Validator)` for composition, plus a static `not(Validator)` method
3. Create a `ValidationFramework` class that collects multiple `Validator<String>` instances and runs them against a value, returning a `List<String>` of error messages
4. Use the standard functional interfaces (`Predicate`, `Function`, `Consumer`, `Supplier`) as adapters — wrap them into your `Validator` type

### Example Output

```java
Validator<String> nonNull = s -> s != null;
Validator<String> nonEmpty = s -> !s.isEmpty();
Validator<String> maxLen = s -> s.length() <= 10;

Validator<String> nameValidator = nonNull.and(nonEmpty).and(maxLen);

nameValidator.isValid("Alice")           // true
nameValidator.isValid(null)              // false
nameValidator.isValid("")                // false

// With framework
ValidationFramework fw = new ValidationFramework();
fw.add(s -> s != null && s.length() >= 3)
  .add(s -> s.matches("[a-zA-Z]+"))
  .add(Validator.not(s -> s.startsWith("X")));

fw.validate("Alice")    // []
fw.validate("Xavier")   // ["Validation 2 failed for: Xavier"]
```

### Extension

Add a `Transformer<T, R>` functional interface that converts a value and collect all transformed results. Then build a pipeline that validates a value and transforms errors into a report string.
