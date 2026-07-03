package pos;

import java.util.Objects;

public class StudentGrade {
    private String studentName;
    private String subject;
    private int grade;

    public StudentGrade(String studentName, String subject, int grade) {
        this.studentName = studentName;
        this.subject = subject;
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGrade that = (StudentGrade) o;
        return grade == that.grade
            && Objects.equals(studentName, that.studentName)
            && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, subject, grade);
    }

    @Override
    public String toString() {
        return "StudentGrade{"
            + "studentName='" + studentName + '\''
            + ", subject='" + subject + '\''
            + ", grade=" + grade
            + '}';
    }
}
