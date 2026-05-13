# Kata 2: Expression Evaluator

| Field | Value |
|-------|-------|
| Concepts | sealed classes, pattern matching, switch expressions, Records |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Build a simple arithmetic expression evaluator using a sealed class hierarchy:

1. Define a sealed interface `Expr` with records `Constant(int value)`, `Add(Expr left, Expr right)`, `Multiply(Expr left, Expr right)`
2. Write a method `int eval(Expr expr)` using a switch expression with pattern matching
3. Write a method `String toExprString(Expr expr)` that produces a readable string representation

### Example Usage

```java
// (3 + 4) * 2
Expr expr = new Multiply(new Add(new Constant(3), new Constant(4)), new Constant(2));
System.out.println(eval(expr));           // 14
System.out.println(toExprString(expr));   // (3 + 4) * 2
```

### Extension

Add `Subtract` and `Divide` operations and handle division by zero.
