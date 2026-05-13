import java.util.*;

public class BasicRefactoring {
    public static void main(String[] args) {
        var employees = List.of(
            new Employee("Alice", "Engineering", 75000),
            new Employee("Bob", "Sales", 65000),
            new Employee("Charlie", "Engineering", 82000)
        );

        employees.stream()
            .filter(e -> e.department().equals("Engineering"))
            .forEach(e -> System.out.println(e.name() + ": " + e.salary()));
    }
}
