# Kata 3: Payroll System Refactoring

| Field | Value |
|-------|-------|
| Concepts | SRP, OCP, strategy pattern |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Refactor the following `Payroll` class that violates both SRP and OCP.

```java
class Payroll {
    double calculatePay(String type, double baseSalary) {
        if (type.equals("fulltime")) {
            return baseSalary;
        } else if (type.equals("parttime")) {
            return baseSalary * 0.5;
        } else if (type.equals("intern")) {
            return baseSalary * 0.3;
        }
        throw new IllegalArgumentException("Unknown type");
    }

    void generatePayslip(String name, double pay) {
        System.out.println("Payslip for " + name + ": " + pay);
    }

    void saveToDatabase(String name, double pay) {
        System.out.println("Saving to DB: " + name + " - " + pay);
    }
}
```

Requirements:
- Apply SRP: separate pay calculation, payslip generation, and persistence
- Apply OCP: new employee types should not require changing existing code
- Use a strategy pattern or interface for payment calculation

### Extension

Add a "contractor" type (rate * hours) without modifying existing code.
