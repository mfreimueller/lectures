---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 16 - Exercise, Bean Mapping
## POS - 3xHIF

---

## Agenda

1. Exercise Overview
2. Core Mapping Logic
3. Type Conversion
4. Annotation-driven Mapping

---

## Learning Objectives

- I can build a BeanMapper that copies fields between objects using reflection
- I can implement automatic type conversion between common Java types
- I can design custom annotations to configure field mappings
- I can understand how ORM frameworks like Hibernate and MapStruct work internally

---

## Exercise Overview

Build a simple ORM-style BeanMapper using reflection:

- Copy fields from a source object to a target object
- Match fields by name (case-insensitive)
- Handle type conversions automatically
- Support annotation-driven mapping configuration

<div class="highlight-box"><p>This mirrors how Hibernate and MapStruct work internally.</p></div>

---

## Reflection: Framework Patterns

<div class="highlight-box">
<p>Frameworks like MapStruct and Hibernate use the exact same reflection patterns you are about to implement. Why is it important to understand these internals rather than just using the framework APIs? What could go wrong if you don't?</p>
</div>

---

## Core Mapping Logic

```java
public class BeanMapper {
    public <T> T map(Object source, Class<T> targetClass)
            throws Exception {
        T target = targetClass.getDeclaredConstructor().newInstance();

        for (Field sourceField : source.getClass().getDeclaredFields()) {
            Field targetField = findField(targetClass, sourceField.getName());
            if (targetField != null) {
                sourceField.setAccessible(true);
                targetField.setAccessible(true);
                Object value = sourceField.get(source);
                targetField.set(target, convert(value, targetField.getType()));
            }
        }
        return target;
    }
}
```

---

## Now Kata 1: Basic BeanMapper

Implement a basic BeanMapper that copies fields from source to target object using reflection

---

## Type Conversion

```java
private Object convert(Object value, Class<?> targetType) {
    if (value == null) return null;
    if (targetType.isAssignableFrom(value.getClass())) {
        return value;
    }
    return switch (targetType.getSimpleName()) {
        case "String" -> String.valueOf(value);
        case "int", "Integer" -> Integer.parseInt(value.toString());
        case "long", "Long" -> Long.parseLong(value.toString());
        case "double", "Double" -> Double.parseDouble(value.toString());
        case "boolean", "Boolean" -> Boolean.parseBoolean(value.toString());
        default -> throw new IllegalArgumentException(
            "Cannot convert " + value.getClass() + " to " + targetType);
    };
}
```

---

## Now Kata 2: Type-converting BeanMapper

Extend BeanMapper with automatic type conversion between common Java types

---

## Annotation-driven Mapping

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mapping {
    String source();
    String target() default "";
}

// Usage:
public class UserDto {
    @Mapping(source = "fullName")
    private String name;

    @Mapping(source = "dateOfBirth")
    private String birthDate;  // LocalDate → String
}
```

---

## Now Kata 3: Annotation-driven BeanMapper with @Mapping

Extend BeanMapper with @Mapping annotation for source/target field name mapping and custom converters

---

## Summary and Goals

- Practice reflection for field access and modification
- Implement type conversion between common Java types
- Design annotation-driven configuration
- Understand ORM mapping fundamentals
- Test the mapper with different object types (TDD)
