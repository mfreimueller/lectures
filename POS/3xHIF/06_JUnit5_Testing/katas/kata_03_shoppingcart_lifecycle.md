# Kata 3: Test Lifecycle & AssertJ

| Field | Value |
|-------|-------|
| Concepts | @BeforeEach, @AfterEach, AssertJ fluent assertions |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Create a `ShoppingCart` class that manages items:
- `void addItem(String name, double price)`
- `void removeItem(String name)` -- throws if not found
- `double getTotal()`
- `int getItemCount()`
- `void clear()`

Write a `ShoppingCartTest` class that:
1. Uses `@BeforeEach` to initialize a fresh cart before each test
2. Uses `@AfterEach` to log the cart state after each test
3. Uses AssertJ for ALL assertions (fluent style)
4. Tests: add items, remove items, get total, clear cart, and edge cases (empty cart, duplicate items)

Track the lifecycle with a counter: verify that `@BeforeEach` is called before each test.

### Example Output

```
Tests passed: 7/7
  - testAddItem
  - testAddMultipleItems
  - testRemoveItem
  - testRemoveItemNotFound (expects exception)
  - testGetTotal
  - testClear
  - testLifecycleInvocationCount
```

### Extension

Add a `@RepeatedTest(3)` that tests adding random items, ensuring the cart is fresh each repetition.
