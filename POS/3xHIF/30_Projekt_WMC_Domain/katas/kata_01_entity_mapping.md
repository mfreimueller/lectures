# Kata 1: Entity Mapping

| Field | Value |
|-------|-------|
| Concepts | JPA entities, @Entity, @OneToOne, @OneToMany |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Define 3 JPA entities for a library system:
1. `Member` entity with id, name, email, and a 1:1 relationship to `MembershipCard`
2. `MembershipCard` entity with id, cardNumber, issuedDate, validUntil
3. `Loan` entity with id, loanDate, dueDate, and a 1:n relationship to `Member`

### Example Output

```java
@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private MembershipCard card;
    @OneToMany(mappedBy = "member")
    private List<Loan> loans = new ArrayList<>();
}
```

### Extension

Add a `@PrePersist` method to set default values and validation annotations.
