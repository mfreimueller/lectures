import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int grade;

    public Student() {}
    public Student(String name, String email, int grade) {
        this.name = name; this.email = email; this.grade = grade;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', grade=" + grade + "}";
    }
}

public class JpaEntityCrud {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();

        System.out.println("--- JPA Entity CRUD ---");

        // CREATE
        em.getTransaction().begin();
        var s1 = new Student("Alice", "alice@school.com", 1);
        var s2 = new Student("Bob", "bob@school.com", 2);
        var s3 = new Student("Charlie", "charlie@school.com", 1);
        em.persist(s1); em.persist(s2); em.persist(s3);
        em.getTransaction().commit();
        System.out.println("Persisted: " + s1);
        System.out.println("Persisted: " + s2);
        System.out.println("Persisted: " + s3);

        // READ ALL (JPQL)
        List<Student> all = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println("All students: " + all);

        // FIND BY ID
        Student found = em.find(Student.class, 2L);
        System.out.println("Found by id: " + found);

        // UPDATE
        em.getTransaction().begin();
        found.setGrade(1);
        em.getTransaction().commit();
        System.out.println("Updated Bob's grade to 1");

        // DELETE
        em.getTransaction().begin();
        em.remove(em.find(Student.class, 3L));
        em.getTransaction().commit();
        long count = em.createQuery("SELECT COUNT(s) FROM Student s", Long.class).getSingleResult();
        System.out.println("After remove: " + count + " students remaining");

        em.close();
        emf.close();
    }
}
