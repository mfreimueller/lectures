class Student {
    private String name;
    private int id;
    private int[] grades;
    private int gradeCount;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new int[20];
        this.gradeCount = 0;
    }

    public void addGrade(int grade) {
        if (grade >= 1 && grade <= 5 && gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Ungueltige Note oder voll!");
        }
    }

    public double getAvg() {
        if (gradeCount == 0) return 0.0;
        int sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return (double) sum / gradeCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int[] getGrades() {
        int[] result = new int[gradeCount];
        for (int i = 0; i < gradeCount; i++) {
            result[i] = grades[i];
        }
        return result;
    }
}

class Course {
    private String title;
    private String teacher;
    private int maxStudents;
    private Student[] students;
    private int studentCount;

    public Course(String title, String teacher, int maxStudents) {
        this.title = title;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.students = new Student[maxStudents];
        this.studentCount = 0;
    }

    public boolean addStudent(Student s) {
        if (studentCount < maxStudents) {
            students[studentCount] = s;
            studentCount++;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }
}

public class UmlToCode {
    public static void main(String[] args) {
        Student s1 = new Student("Anna", 1001);
        Student s2 = new Student("Bob", 1002);

        s1.addGrade(1);
        s1.addGrade(2);
        s1.addGrade(1);
        s2.addGrade(3);
        s2.addGrade(2);

        Course course = new Course("Mathematik", "Dr. Weber", 30);
        course.addStudent(s1);
        course.addStudent(s2);

        System.out.println("Kurs: " + course.getTitle());
        System.out.println("Student: " + s1.getName() + ", Notendurchschnitt: " + s1.getAvg());
        System.out.println("Student: " + s2.getName() + ", Notendurchschnitt: " + s2.getAvg());
    }
}