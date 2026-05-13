# Kata 2: Inheritance Mapping

| Field | Value |
|-------|-------|
| Concepts | JPA inheritance, JOINED strategy |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Implement JPA inheritance with JOINED strategy:
1. Create an abstract base entity `Media` with id, title, and year
2. Create `Book` subclass with author and isbn
3. Create `DVD` subclass with director and duration
4. All three must be JPA entities with proper inheritance annotations

### Example Output

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private int year;
}
```

### Extension

Add a `Magazine` subclass with issueNumber and publisher.
