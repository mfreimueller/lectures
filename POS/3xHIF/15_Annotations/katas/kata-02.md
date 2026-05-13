# K2: @NotNull Field Validation

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Field-level annotations, setAccessible, reflection validation | 2/5 | 30 min |

## Task

Build a validation framework with a `@NotNull` annotation and a `Validator` class.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {}
```

The `Validator.validate(Object obj)` method should:
1. Get all declared fields via reflection
2. For fields annotated with `@NotNull`, read the value
3. If the value is null, add an error message to the result list
4. Return a list of validation error strings

## Example Output

```
Validating Person{name='null', email='test@example.com'}
Errors:
  - Field 'name' is null but marked @NotNull
```

## Extension

Add a `@NotEmpty` annotation for String fields that checks the string is not empty after trimming.
