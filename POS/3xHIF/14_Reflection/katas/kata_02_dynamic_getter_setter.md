# K2: Dynamic Getter/Setter Invoker

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Method.invoke, getDeclaredMethod, naming conventions | 2/5 | 30 min |

## Task

Implement a generic utility that uses reflection to invoke all getters and setters on any Java object.

A getter is a method starting with `get` or `is`, taking zero parameters, returning a value.
A setter is a method starting with `set`, taking one parameter, returning void.

```java
public class BeanAccessor {
    public void printProperties(Object obj) { ... }
    public void setProperty(Object obj, String propertyName, Object value) { ... }
}
```

## Example Output

```
Person[name=Alice, age=30]
Setting name to Bob
Person[name=Bob, age=30]
```

## Extension

Add support for chained property access, e.g., `getProperty(person, "address.city")` that navigates nested objects.
