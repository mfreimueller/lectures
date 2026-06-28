# K3: Private Field Accessor with Validation

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Field.get/set, setAccessible, validation | 3/5 | 30 min |

## Task

Build a validation framework that uses reflection to read private fields and check for constraints.

Define a `@NotNull` annotation and a `Validator` class:

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {}

class Validator {
    public List<String> validate(Object obj) { ... }
}
```

The validator reads all fields annotated with `@NotNull` via reflection, checks if the value is null, and returns a list of validation errors.

## Example Output

```
Validating Person[name=null, age=30]
Errors:
  - name is null but marked @NotNull
```

## Extension

Add support for `@Min(value)` and `@Max(value)` annotations for numeric fields, and validate them in the same pass.
