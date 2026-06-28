# K1: Class Inspector

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Class object, getDeclaredMethods, getDeclaredFields, getConstructors | 1/5 | 20 min |

## Task

Write a utility class `ClassInspector` that uses reflection to print the structure of any given class.

For a class like:
```java
class Person {
    private String name;
    private int age;
    public Person(String name, int age) { ... }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

Print:
- All declared fields (name, type, modifiers)
- All declared constructors (parameter types)
- All declared methods (name, return type, parameter types)

## Example Output

```
Class: Person
Fields:
  - private java.lang.String name
  - private int age
Constructors:
  - public Person(String, int)
Methods:
  - public java.lang.String getName()
  - public void setName(java.lang.String)
```

## Extension

Include inherited methods and fields from superclasses. Indicate clearly which members are inherited.
