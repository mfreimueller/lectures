import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTestBase {
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    protected StudentRepository studentRepo;
    protected TeacherRepository teacherRepo;
    protected CourseRepository courseRepo;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("school-test");
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        studentRepo = new StudentRepository(em);
        teacherRepo = new TeacherRepository(em);
        courseRepo = new CourseRepository(em);
    }

    @AfterEach
    void teardown() {
        if (em != null) em.close();
    }

    @AfterAll
    static void teardownFactory() {
        if (emf != null) emf.close();
    }
}

class StudentRepositoryTest extends RepositoryTestBase {

    @Test
    void testSaveAndFindStudent() {
        em.getTransaction().begin();
        var s = studentRepo.save(new Student("Alice",
            new Email("alice@school.com"), null, "S001", 1));
        em.getTransaction().commit();

        var found = studentRepo.findById(s.getId());
        assertNotNull(found);
        assertEquals("Alice", found.getName());
        assertEquals(1, found.getGrade());
    }

    @Test
    void testUpdateStudent() {
        em.getTransaction().begin();
        var s = studentRepo.save(new Student("Bob",
            new Email("bob@school.com"), null, "S002", 2));
        em.getTransaction().commit();

        em.getTransaction().begin();
        var managed = studentRepo.findById(s.getId());
        managed.setGrade(1);
        em.getTransaction().commit();

        var updated = studentRepo.findById(s.getId());
        assertEquals(1, updated.getGrade());
    }

    @Test
    void testDeleteStudent() {
        em.getTransaction().begin();
        var s = studentRepo.save(new Student("Charlie",
            new Email("charlie@school.com"), null, "S003", 1));
        em.getTransaction().commit();

        em.getTransaction().begin();
        studentRepo.deleteById(s.getId());
        em.getTransaction().commit();

        var found = studentRepo.findById(s.getId());
        assertNull(found);
    }

    @Test
    void testFindByGrade() {
        em.getTransaction().begin();
        studentRepo.save(new Student("A", new Email("a@x.com"), null, "S1", 1));
        studentRepo.save(new Student("B", new Email("b@x.com"), null, "S2", 2));
        studentRepo.save(new Student("C", new Email("c@x.com"), null, "S3", 1));
        em.getTransaction().commit();

        var grade1 = studentRepo.findByGrade(1);
        assertEquals(2, grade1.size());
    }

    @Test
    void testRollback() {
        em.getTransaction().begin();
        long before = studentRepo.count();
        studentRepo.save(new Student("Rollback", new Email("r@x.com"), null, "S99", 1));
        em.getTransaction().rollback();

        long after = studentRepo.count();
        assertEquals(before, after, "Rollback should restore count");
    }
}

class CourseRepositoryTest extends RepositoryTestBase {

    @Test
    void testCourseWithTeacher() {
        em.getTransaction().begin();
        var teacher = teacherRepo.save(new Teacher("Mr. Smith",
            new Email("smith@school.com"),
            new Address("St", "City", "ZIP", "AT"),
            "T001", "Math", new Money(BigDecimal.valueOf(50000), "EUR")));
        var course = courseRepo.save(new Course("Mathematics", teacher));
        em.getTransaction().commit();

        var found = courseRepo.findByTeacher(teacher);
        assertEquals(1, found.size());
        assertEquals("Mathematics", found.get(0).getTitle());
    }
}

public class IntegrationTests {
    public static void main(String[] args) {
        System.out.println("Run these tests with JUnit 5.");
        System.out.println("See StudentRepositoryTest and CourseRepositoryTest classes.");
    }
}
