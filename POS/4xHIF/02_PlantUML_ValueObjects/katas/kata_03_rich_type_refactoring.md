# Kata 3: RichType Refactoring

| Field | Value |
|-------|-------|
| Concepts | primitive obsession, rich types, type safety |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Refactor the following class that suffers from primitive obsession:

```java
public class OrderService {
    public void placeOrder(String customerId, String productId,
                           String quantity, String shippingAddress,
                           String paymentMethod) {
        // customerId is a string like "CUST-001"
        // productId is a string like "PROD-456"
        // quantity is a string like "3"
        // shippingAddress is a string like "123 Main St, Vienna"
        // paymentMethod is a string like "CREDIT_CARD"
    }
}
```

Create RichTypes:
- `CustomerId` — validates the "CUST-" prefix format
- `ProductId` — validates the "PROD-" prefix format
- `Quantity` — positive integer, with `getValue()` method
- `ShippingAddress` — combines street, city, zipCode
- `PaymentMethod` — enum or sealed class

### Extension

Add JUnit tests that prove invalid data cannot be constructed at the type level.
