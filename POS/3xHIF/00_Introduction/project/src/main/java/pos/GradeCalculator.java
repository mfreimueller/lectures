package pos;

import java.util.List;

public class GradeCalculator {

    public double calculateAverage(List<StudentGrade> grades) {
        double sum = 0.0;
        for (StudentGrade grade : grades) {
            sum = sum + grade.getGrade();
        }
        return sum / grades.size();
    }

    public int findMaxGrade(List<StudentGrade> grades) {
        int max = Integer.MIN_VALUE;
        for (StudentGrade grade : grades) {
            if (grade.getGrade() > max) {
                max = grade.getGrade();
            }
        }
        return max;
    }

    public int findMinGrade(List<StudentGrade> grades) {
        int min = Integer.MAX_VALUE;
        for (StudentGrade grade : grades) {
            if (grade.getGrade() < min) {
                min = grade.getGrade();
            }
        }
        return min;
    }

    public long countPassed(List<StudentGrade> grades) {
        long count = 0;
        for (StudentGrade grade : grades) {
            if (grade.getGrade() >= 4) {
                count++;
            }
        }
        return count;
    }
}
