# K1: Basic BeanMapper

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Reflection, Field.set/get, Constructor.newInstance | 1/5 | 20 min |

## Task

Implement a basic `BeanMapper` that copies fields from a source object to a new target object instance using reflection.

```java
public class BeanMapper {
    public <T> T map(Object source, Class<T> targetClass) throws Exception { ... }
}
```

Rules:
1. Create a new instance of targetClass using the no-arg constructor
2. Iterate over all declared fields of the source
3. Find a field with the same name in the target class (ignore case)
4. Copy the value from source to target
5. Skip static fields

## Example Output

```
Source: Person{name='Alice', age=30}
Target: PersonDto{name='Alice', age=30}
```

## Extension

Support mapping between fields with different names if annotated, and handle null source values gracefully.
