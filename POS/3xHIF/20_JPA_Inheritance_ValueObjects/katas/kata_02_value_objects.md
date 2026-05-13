# Kata 2: Value Objects

| Field | Value |
|-------|-------|
| Concepts | @Embeddable, @Embedded, @AttributeOverrides, value semantics |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Create value objects and embed them in entities:

1. Define `Address` as @Embeddable with street, city, zipCode, country
2. Define `Email` as @Embeddable with validation in constructor
3. Define `Money` as @Embeddable with amount and currency
4. Embed Address and Email in `Student`, with @AttributeOverrides for a second address
5. Embed Money and Address in `Teacher`
6. Persist and query entities with embedded values

### Example Output

```
--- Value Objects ---
Student: Alice, lives at 123 Main St, Vienna, 1010, AT
Student (parent): 456 Parent Rd, Vienna, 1020, AT
Teacher: Mr. Smith, salary: EUR 45000.00
```

### Extension

Add an `@Embeddable PhoneNumber` with country code and number, embed it as a `List<PhoneNumber>` using an element collection.
