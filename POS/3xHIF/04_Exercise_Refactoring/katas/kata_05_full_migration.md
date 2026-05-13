# Kata 5: Full Modern Java Migration

| Field | Value |
|-------|-------|
| Concepts | Records, sealed, pattern matching, switch expressions, text blocks, var |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Given legacy code with verbose POJOs, if-else chains, and string concatenation, migrate to modern Java 17+ idioms.

Legacy class:

```java
class Order {
    private String id;
    private double amount;
    private String status; // "PENDING", "PAID", "CANCELLED"

    public Order(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
}
```

1. Convert the class to a Record
2. Use a sealed interface for the status with pattern matching
3. Replace if-else with a switch expression
4. Use a text block to format the output message
5. Use `var` for local variables

### Example Output

```
Order[orderId=ORD-001, amount=$149.99, status=PAID]
Your payment of $149.99 has been received. Thank you!
```

### Extension

Apply Optional where null is returned from lookup methods.
