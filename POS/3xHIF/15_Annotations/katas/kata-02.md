# K2: @ToString Annotation Processor

| Field | Value |
|-------|-------|
| Concepts | @interface, @Retention, @Target, annotation-processing, Field.get/set |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Implement a `@ToString` annotation and a processor that automatically generates a string representation of an object.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ToString {
    boolean includeFields() default true;
    String[] excludeFields() default {};
}
```

Write a `ToStringProcessor` class with a method:
```java
public static String toString(Object obj) throws Exception
```

The processor shall:
1. Check if the class is annotated with `@ToString`
2. Read all declared fields via reflection
3. Skip fields listed in `excludeFields()`
4. If `includeFields=false`, output only the class name
5. Produce a string in the format `ClassName{field1=value1, field2=value2, ...}`

### Example Output

```
Person{name=Alice, age=30}
```

### Extension

Add a `@ToStringExclude` annotation that can be applied to individual fields to exclude them from the output, independently of the class-level annotation.
