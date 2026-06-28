# K3: Annotation-driven BeanMapper with @Mapping

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Custom annotations, annotation processing, reflection | 3/5 | 30 min |

## Task

Extend the BeanMapper with a `@Mapping` annotation that specifies source/target field name mapping and optional custom converters.

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Mapping {
    String source();
    Class<? extends Converter> converter() default DefaultConverter.class;
}

public interface Converter {
    Object convert(Object value);
}
```

When a target field is annotated with `@Mapping`, use the specified `source` field name from the source object. If a `converter` is specified, apply it before setting the value.

## Example Output

```
Source: Person{fullName='Alice Johnson', year=1993}
Target: PersonDto{name='Alice Johnson', birthYear='1993'}
```

## Extension

Add a `@MappedCollection` annotation that maps lists of nested objects recursively.
