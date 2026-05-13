import jakarta.persistence.*;
import java.util.*;

interface Repository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(T entity);
    void deleteById(ID id);
    long count();
}

class JpaRepository<T, ID> implements Repository<T, ID> {
    protected final EntityManager em;
    private final Class<T> entityClass;

    public JpaRepository(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override public T findById(ID id) { return em.find(entityClass, id); }

    @Override
    public List<T> findAll() {
        var cb = em.getCriteriaBuilder();
        var query = cb.createQuery(entityClass);
        query.select(query.from(entityClass));
        return em.createQuery(query).getResultList();
    }

    @Override
    public T save(T entity) {
        if (em.contains(entity)) return em.merge(entity);
        else { em.persist(entity); return entity; }
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) delete(entity);
    }

    @Override
    public long count() {
        var cb = em.getCriteriaBuilder();
        var query = cb.createQuery(Long.class);
        query.select(cb.count(query.from(entityClass)));
        return em.createQuery(query).getSingleResult();
    }
}

class StudentRepository extends JpaRepository<Student, Long> {
    public StudentRepository(EntityManager em) { super(em, Student.class); }

    public List<Student> findByGrade(int grade) {
        return em.createQuery("SELECT s FROM Student s WHERE s.grade = :grade", Student.class)
            .setParameter("grade", grade).getResultList();
    }

    public List<Student> findWithNoEnrollments() {
        return em.createQuery("SELECT s FROM Student s WHERE s.enrollments IS EMPTY", Student.class)
            .getResultList();
    }

    public List<Student> findByElective(String electiveName) {
        return em.createQuery(
            "SELECT s FROM Student s JOIN s.electives e WHERE e.name = :name", Student.class)
            .setParameter("name", electiveName).getResultList();
    }
}

class TeacherRepository extends JpaRepository<Teacher, Long> {
    public TeacherRepository(EntityManager em) { super(em, Teacher.class); }

    public List<Teacher> findBySubject(String subject) {
        return em.createQuery("SELECT t FROM Teacher t WHERE t.subject = :subject", Teacher.class)
            .setParameter("subject", subject).getResultList();
    }

    public List<Teacher> findWithSalaryAbove(double amount) {
        return em.createQuery(
            "SELECT t FROM Teacher t WHERE t.salary.amount > :amount", Teacher.class)
            .setParameter("amount", java.math.BigDecimal.valueOf(amount)).getResultList();
    }
}

class CourseRepository extends JpaRepository<Course, Long> {
    public CourseRepository(EntityManager em) { super(em, Course.class); }

    public List<Course> findByTeacher(Teacher teacher) {
        return em.createQuery("SELECT c FROM Course c WHERE c.teacher = :teacher", Course.class)
            .setParameter("teacher", teacher).getResultList();
    }

    public List<Object[]> findWithEnrollmentCount() {
        return em.createQuery(
            "SELECT c.title, COUNT(e) FROM Course c LEFT JOIN c.enrollments e GROUP BY c.title", Object[].class)
            .getResultList();
    }
}

public class RepositoryLayerDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-test");
        EntityManager em = emf.createEntityManager();

        var studentRepo = new StudentRepository(em);
        var teacherRepo = new TeacherRepository(em);
        var courseRepo = new CourseRepository(em);

        em.getTransaction().begin();
        var t1 = teacherRepo.save(new Teacher("Mr. Smith", new Email("smith@school.com"),
            new Address("1st St", "Vienna", "1010", "AT"), "T001", "Math", new Money(new java.math.BigDecimal("50000"), "EUR")));
        var t2 = teacherRepo.save(new Teacher("Ms. Jones", new Email("jones@school.com"),
            new Address("2nd St", "Vienna", "1020", "AT"), "T002", "Physics", new Money(new java.math.BigDecimal("52000"), "EUR")));

        var c1 = courseRepo.save(new Course("Mathematics", t1));
        var c2 = courseRepo.save(new Course("Physics", t2));
        var c3 = courseRepo.save(new Course("Chemistry", t2));

        var s1 = studentRepo.save(new Student("Alice", new Email("alice@school.com"), null, "S001", 1));
        var s2 = studentRepo.save(new Student("Bob", new Email("bob@school.com"), null, "S002", 2));
        var s3 = studentRepo.save(new Student("Charlie", new Email("charlie@school.com"), null, "S003", 1));

        new Enrollment(s1, c1, 1, "WS2026");
        new Enrollment(s2, c1, 2, "WS2026");
        new Enrollment(s1, c2, 1, "WS2026");
        em.getTransaction().commit();

        System.out.println("--- Repository Layer ---");
        System.out.println("Created " + studentRepo.count() + " students, " + teacherRepo.count() + " teachers, " + courseRepo.count() + " courses");
        System.out.println("Students in grade 1: " + studentRepo.findByGrade(1).stream().map(Student::getName).toList());
        System.out.println("Teachers of Math: " + teacherRepo.findBySubject("Math").stream().map(Teacher::getName).toList());
        System.out.print("Courses with enrollments: ");
        courseRepo.findWithEnrollmentCount().forEach(row -> System.out.print(row[0] + "(" + row[1] + ") "));

        em.close();
        emf.close();
    }
}
