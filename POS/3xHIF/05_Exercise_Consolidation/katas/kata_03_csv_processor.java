import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class CsvProcessor {
    public static void main(String[] args) throws Exception {
        var path = Path.of("employees.csv");
        var employees = Files.readString(path).lines()
            .skip(1) // skip header
            .filter(line -> !line.isBlank())
            .map(CsvProcessor::parseEmployee)
            .flatMap(Optional::stream)
            .toList();

        var highest = employees.stream()
            .max(Comparator.comparingDouble(EmployeeCsv::salary));
        highest.ifPresent(e ->
            System.out.println("Highest paid: " + e.name() + " (" + e.salary() + ")"));

        System.out.println("Average salary per department:");
        employees.stream()
            .collect(Collectors.groupingBy(
                EmployeeCsv::department,
                Collectors.averagingDouble(EmployeeCsv::salary)
            ))
            .forEach((dept, avg) ->
                System.out.println("  " + dept + ": " + avg));

        System.out.println("Employees older than 30:");
        employees.stream()
            .filter(e -> e.age() > 30)
            .forEach(e -> System.out.println("  " + e.name() + " (" + e.age() + ")"));
    }

    static Optional<EmployeeCsv> parseEmployee(String line) {
        try {
            var parts = line.split(",");
            return Optional.of(new EmployeeCsv(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2]),
                parts[3],
                Double.parseDouble(parts[4])
            ));
        } catch (Exception e) {
            System.err.println("Skipping invalid line: " + line);
            return Optional.empty();
        }
    }
}
