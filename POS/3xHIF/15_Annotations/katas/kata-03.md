# K3: Annotation-driven JSON Serializer

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Annotation processing, reflection, JSON serialization | 3/5 | 30 min |

## Task

Implement a mini JSON serializer that uses custom annotations to control how objects are serialized.

Define these annotations:
- `@JsonProperty(name)` — maps a field to a custom JSON key name
- `@JsonIgnore` — excludes a field from serialization

```java
public class JsonSerializer {
    public String toJson(Object obj) throws Exception { ... }
}
```

The serializer should:
1. Get all declared fields via reflection
2. Skip fields annotated with `@JsonIgnore`
3. Use `@JsonProperty` name if present, otherwise use field name
4. Build a JSON string representation

## Example Output

```
Input: Person{name='Alice', age=30, internalId='xyz123'}
Output: {"full_name":"Alice","age":30}
```

## Extension

Add support for nested objects — if a field is not a primitive/String, serialize it recursively.
