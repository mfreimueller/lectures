# Kata 1: Basic Refactoring

| Field | Value |
|-------|-------|
| Concepts | Records, lambdas, streams |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

Refactor the following Java 7 code to use Records, lambdas, and streams:

```java
// Legacy Java 7 code
public class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// Usage
List<Employee> emps = new ArrayList<>();
emps.add(new Employee("Alice", "Engineering", 75000));
emps.add(new Employee("Bob", "Sales", 65000));
// Filter and print Engineering employees
for (Employee e : emps) {
    if (e.getDepartment().equals("Engineering")) {
        System.out.println(e.getName() + ": " + e.getSalary());
    }
}
```

### Extension

Add a method that calculates the total salary per department using streams and Collectors.groupingBy.
