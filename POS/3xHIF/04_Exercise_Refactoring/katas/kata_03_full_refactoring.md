# Kata 3: Full Refactoring

| Field | Value |
|-------|-------|
| Concepts | Records, streams, sealed classes, pattern matching, Optional |
| Difficulty | 4/5 |
| Duration | approx. 30 min |

### Task

Refactor the following legacy order processing system. The code uses Java 7 style with lots of boilerplate. Your goal is to rewrite it using modern Java features.

```java
public class Order {
    private int id;
    private String customer;
    private List<OrderItem> items;
    private String status; // PENDING, SHIPPED, DELIVERED, CANCELLED

    // getters, setters, constructor...

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public String getStatusLabel() {
        String label;
        switch (status) {
            case "PENDING":
                label = "Pending";
                break;
            case "SHIPPED":
                label = "Shipped";
                break;
            case "DELIVERED":
                label = "Delivered";
                break;
            case "CANCELLED":
                label = "Cancelled";
                break;
            default:
                label = "Unknown";
        }
        return label;
    }
}
```

### Requirements

1. Use Records for OrderItem and Order (where immutable)
2. Use sealed interface/enum for OrderStatus
3. Use stream operations for total calculation
4. Use switch expression for status label
5. Use Optional for methods that might not return a value

### Extension

Implement a method `findOrderById(int id)` that returns `Optional<Order>` and demonstrate its usage.
