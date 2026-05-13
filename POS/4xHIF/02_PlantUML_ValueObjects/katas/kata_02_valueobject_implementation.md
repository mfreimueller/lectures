# Kata 2: ValueObject Implementation

| Field | Value |
|-------|-------|
| Concepts | immutability, equals/hashCode, factory methods, validation |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Implement an `Email` value object:

1. Make it a `record` (immutable by design)
2. Validate in the constructor: must contain `@`, must have a domain part with a dot
3. Provide a static factory method `Email.of(String value)` that throws an `IllegalArgumentException` for invalid input
4. Ensure structural equality (records do this automatically)

Then implement a `Money` value object:

1. Fields: `BigDecimal amount`, `Currency currency`
2. Cannot be negative
3. Methods: `add(Money other)`, `subtract(Money other)`, `multiply(double factor)`
4. Different currencies cannot be added (throw `IllegalArgumentException`)

### Example Usage

```java
Email email = Email.of("user@example.com");       // OK
Email invalid = Email.of("not-an-email");          // throws

Money price = new Money(new BigDecimal("29.99"), Currency.getInstance("EUR"));
Money tax = price.multiply(0.2);
Money total = price.add(tax);
```

### Extension

Add a `toString()` that returns the formatted amount with currency symbol (e.g., "€29.99").
