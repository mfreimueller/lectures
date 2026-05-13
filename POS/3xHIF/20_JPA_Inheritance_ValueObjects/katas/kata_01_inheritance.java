import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
abstract class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getName() { return name; }
}

@Entity
@DiscriminatorValue("STU")
class Student extends Person {
    private String studentId;
    private int grade;

    public Student() {}
    public Student(String name, String studentId, int grade) {
        super(name); this.studentId = studentId; this.grade = grade;
    }

    @Override public String toString() {
        return "Student{name='" + getName() + "', grade=" + grade + "}";
    }
}

@Entity
@DiscriminatorValue("TCH")
class Teacher extends Person {
    private String employeeId;
    private String subject;

    public Teacher() {}
    public Teacher(String name, String employeeId, String subject) {
        super(name); this.employeeId = employeeId; this.subject = subject;
    }

    @Override public String toString() {
        return "Teacher{name='" + getName() + "', subject='" + subject + "'}";
    }
}

public class InheritanceMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Student("Alice", "S123", 1));
        em.persist(new Teacher("Mr. Smith", "T456", "Math"));
        em.getTransaction().commit();

        System.out.println("--- SINGLE_TABLE Strategy ---");

        var all = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        System.out.println("All persons: " + all);

        var discriminators = em.createNativeQuery(
            "SELECT person_type FROM person").getResultList();
        System.out.println("Discriminator values: " + discriminators);

        em.close();
        emf.close();
    }
}
