# Kata 1: Unnamed Variables

| Field | Value |
|-------|-------|
| Concepts | unnamed variables, unnamed patterns, _ |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

Refactor the following code to use unnamed variables `_` wherever a variable is declared but not used:

```java
public class Legacy {
    public static void main(String[] args) {
        var items = List.of("a", "b", "c", "d", "e");
        int count = 0;
        for (var item : items) {
            count++;
        }
        System.out.println("Count: " + count);

        try {
            var result = riskyOperation();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Operation failed");
        }

        Object obj = "hello";
        if (obj instanceof String s) {
            System.out.println("It's a string!");
        }
    }

    static String riskyOperation() {
        return "done";
    }
}
```

### Extension

Add a try-with-resources example where the resource variable is unnamed.
