# Kata 4: Static Interface Methods

| Field | Value |
|-------|-------|
| Concepts | static interface methods, utility interfaces |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

1. Create an interface `MathUtils` with static helper methods:
   - `factorial(int n)` returns long
   - `isPrime(int n)` returns boolean
   - `gcd(int a, int b)` returns int
2. Write a `Main` class that calls these methods directly using the interface name
3. Do NOT implement the interface - call methods via `MathUtils.factorial(...)`

### Example Output

```
Factorial of 5: 120
Is 17 prime? true
GCD of 48 and 18: 6
```

### Extension

Add a `isEven(int n)` default method to the interface.
