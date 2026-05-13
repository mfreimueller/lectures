# Kata 5: Code Analysis and Anti-Pattern Fix

| Field | Value |
|-------|-------|
| Concepts | code review, anti-patterns, refactoring, modern Java idioms |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Review the following code containing common anti-patterns:

```java
public class OrderProcessor {
    private String status;

    public String process(String input) {
        if (input == null) return null;
        if (input.equals("PAID")) status = "paid";
        else if (input.equals("PENDING")) status = "pending";
        else if (input.equals("CANCELLED")) status = "cancelled";
        String msg = "";
        for (int i = 0; i < 10; i++) {
            msg = msg + ".";
        }
        return "Order " + input + " is " + status + msg;
    }
}
```

Identify the issues and rewrite using proper modern Java idioms:
1. Null returns instead of Optional
2. Mutable field when not needed
3. If-else chain instead of switch expression
4. Verbose loop instead of String.repeat
5. String concatenation instead of text blocks or formatted strings

Document what was changed and why in comments.

### Extension

Add test cases to verify the refactored code.
