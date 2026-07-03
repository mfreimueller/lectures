package pos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StudentGrade> grades = new ArrayList<>();
        grades.add(new StudentGrade("Alice", "Math", 1));
        grades.add(new StudentGrade("Bob", "Math", 3));
        grades.add(new StudentGrade("Charlie", "Math", 5));
        grades.add(new StudentGrade("Diana", "Math", 2));
        grades.add(new StudentGrade("Eve", "Math", 4));

        GradeCalculator calculator = new GradeCalculator();

        double average = calculator.calculateAverage(grades);
        int maxGrade = calculator.findMaxGrade(grades);
        int minGrade = calculator.findMinGrade(grades);
        long passed = calculator.countPassed(grades);

        System.out.println("=== Grade Report ===");
        System.out.println("Students: " + grades.size());
        System.out.println("Average grade: " + average);
        System.out.println("Best grade: " + maxGrade);
        System.out.println("Worst grade: " + minGrade);
        System.out.println("Passed (grade >= 4): " + passed);

        System.out.println();
        System.out.println("All grades:");
        for (StudentGrade grade : grades) {
            System.out.println(grade);
        }
    }
}
