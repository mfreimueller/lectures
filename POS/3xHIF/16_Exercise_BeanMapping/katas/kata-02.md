# K2: Type-converting BeanMapper

| Concept | Difficulty | Duration |
|---------|------------|----------|
| Type conversion, reflection, switch expressions | 2/5 | 30 min |

## Task

Extend the BeanMapper from K1 with automatic type conversion. When the source field type differs from the target field type, convert the value automatically.

Supported conversions:
- Any type → String (via `String.valueOf()`)
- String → int/Integer (via `Integer.parseInt()`)
- String → long/Long
- String → double/Double
- String → boolean/Boolean
- int/Integer → String
- LocalDate → String (via `toString()`)
- String → LocalDate (via `LocalDate.parse()`)

## Example Output

```
Source: Person{name='Alice', age=30, birthDate=2000-05-15}
Target: PersonDto{name='Alice', ageAsString='30', birthDate='2000-05-15'}
```

## Extension

Add support for Enum ↔ String conversion, and for mapping numeric types to each other (int ↔ long ↔ double).
