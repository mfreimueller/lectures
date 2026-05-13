# K1: @LogExecutionTime Annotation

| Concept | Difficulty | Duration |
|---------|------------|----------|
| @interface, @Retention, @Target, Method.invoke, reflection | 1/5 | 20 min |

## Task

Define a `@LogExecutionTime` annotation that can be applied to methods, and write a processor that uses reflection to invoke the method and log how long it took.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
    String unit() default "ms";
}
```

Write an `ExecutionTimer` class with a method `void logTime(Object obj, String methodName, Object... args)` that:
1. Looks up the method via reflection
2. Checks for the `@LogExecutionTime` annotation
3. If present, measures and prints the execution time

## Example Output

```
Executing slowOperation()...
slowOperation took 1005ms
Result: 42
```

## Extension

Add support for logging to a file instead of stdout, configured via a `LogExecutionTime.logToFile()` element.
