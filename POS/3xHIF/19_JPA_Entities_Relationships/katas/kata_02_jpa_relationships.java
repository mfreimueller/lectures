import jakarta.persistence.*;
import java.util.*;

@Entity
class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "student_elective",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "elective_id"))
    private List<Elective> electives = new ArrayList<>();

    public Student() {}
    public Student(String name) { this.name = name; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Enrollment> getEnrollments() { return enrollments; }
    public List<Elective> getElectives() { return electives; }
}

@Entity
class Course {
    @Id @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}
    public Course(String title) { this.title = title; }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public List<Enrollment> getEnrollments() { return enrollments; }
}

@Entity
@Table(name = "enrollment")
class Enrollment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private int grade;

    public Enrollment() {}
    public Enrollment(Student student, Course course) {
        this.student = student; this.course = course;
    }

    public Long getId() { return id; }
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

    public Long getId() { return id; }
    public String getName() { return name; }
}

public class JpaRelationships {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        var math = new Course("Mathematics");
        var physics = new Course("Physics");
        em.persist(math); em.persist(physics);

        var alice = new Student("Alice");
        var bob = new Student("Bob");
        em.persist(alice); em.persist(bob);

        var e1 = new Enrollment(alice, math);
        var e2 = new Enrollment(alice, physics);
        var e3 = new Enrollment(bob, math);
        em.persist(e1); em.persist(e2); em.persist(e3);

        var chess = new Elective("Chess");
        var robotics = new Elective("Robotics");
        em.persist(chess); em.persist(robotics);

        alice.getElectives().add(chess);
        bob.getElectives().add(chess);
        bob.getElectives().add(robotics);

        em.getTransaction().commit();

        System.out.println("--- School Relationships ---");
        System.out.println("Course '" + math.getTitle() + "' with " + math.getEnrollments().size() + " enrollments");
        System.out.println("Student '" + alice.getName() + "' enrolled in: " +
            alice.getEnrollments().stream().map(e -> e.getCourse().getTitle()).toList());
        System.out.println("Student '" + bob.getName() + "' chose electives: " +
            bob.getElectives().stream().map(Elective::getName).toList());

        em.close();
        emf.close();
    }
}
