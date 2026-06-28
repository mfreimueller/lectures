# Kata 4: Exception Testing

| Field | Value |
|-------|-------|
| Concepts | assertThrows, assertAll, custom exceptions, edge cases |
| Difficulty | 2/5 |
| Duration | approx. 15 min |

### Task

Write a `BankAccount` class with:
- `BankAccount(double initialBalance)` constructor
- `void withdraw(double amount)` -- throws `InsufficientFundsException` when amount exceeds balance
- `double getBalance()`

Write JUnit 5 tests using `assertThrows` that verify:
1. Withdrawal succeeds with sufficient funds
2. Exception is thrown for overdraft
3. Exception message is correct (contains balance and required amount)
4. Use `assertAll` to group related assertions
5. Balance is unchanged after a failed withdrawal

### Extension

Test edge cases: withdrawing exactly the balance (should succeed), withdrawing zero or negative amounts.
