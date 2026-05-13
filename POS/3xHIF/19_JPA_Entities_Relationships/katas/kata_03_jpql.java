import jakarta.persistence.*;
import java.util.*;

@Entity
@NamedQuery(name = "Student.findByGrade",
    query = "SELECT s FROM Student s WHERE s.grade = :grade")
class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private int grade;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student() {}
    public Student(String name, int grade) { this.name = name; this.grade = grade; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getGrade() { return grade; }
    public List<Enrollment> getEnrollments() { return enrollments; }
}

@Entity
class Course {
    @Id @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}
    public Course(String title) { this.title = title; }
    public Long getId() { return id; }
    public String getTitle() { return title; }
}

@Entity
@Table(name = "enrollment")
class Enrollment {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne @JoinColumn(name = "student_id") private Student student;
    @ManyToOne @JoinColumn(name = "course_id") private Course course;
    private int grade;

    public Enrollment() {}
    public Enrollment(Student s, Course c, int g) { this.student = s; this.course = c; this.grade = g; }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public int getGrade() { return grade; }
}

@Entity
class Elective {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "electives")
    private List<Student> students = new ArrayList<>();

    public Elective() {}
    public Elective(String name) { this.name = name; }
    public String getName() { return name; }
    public List<Student> getStudents() { return students; }
}

public class JpqlQueries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();

        // Setup data (simplified - assumes entities from kata_02 exist)
        em.getTransaction().begin();
        var math = new Course("Mathematics");
        var physics = new Course("Physics");
        em.persist(math); em.persist(physics);

        var alice = new Student("Alice", 1);
        var bob = new Student("Bob", 2);
        var charlie = new Student("Charlie", 1);
        em.persist(alice); em.persist(bob); em.persist(charlie);

        em.persist(new Enrollment(alice, math, 1));
        em.persist(new Enrollment(bob, math, 3));
        em.persist(new Enrollment(alice, physics, 1));

        em.getTransaction().commit();

        System.out.println("--- JPQL Queries ---");

        // 1. Students in a course
        TypedQuery<String> q1 = em.createQuery(
            "SELECT s.name FROM Student s JOIN s.enrollments e WHERE e.course.title = :title", String.class);
        q1.setParameter("title", "Mathematics");
        System.out.println("Students in 'Mathematics': " + q1.getResultList());

        // 2. Average grade per course
        List<Object[]> avgGrades = em.createQuery(
            "SELECT e.course.title, AVG(e.grade) FROM Enrollment e GROUP BY e.course.title", Object[].class)
            .getResultList();
        avgGrades.forEach(row -> System.out.println("Average grade for '" + row[0] + "': " + row[1]));

        // 5. Named query
        TypedQuery<Student> q5 = em.createNamedQuery("Student.findByGrade", Student.class);
        q5.setParameter("grade", 1);
        System.out.println("Grade 1 students: " + q5.getResultList().stream().map(Student::getName).toList());

        em.close();
        emf.close();
    }
}
