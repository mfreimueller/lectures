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

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        var cb = em.getCriteriaBuilder();
        var query = cb.createQuery(entityClass);
        query.select(query.from(entityClass));
        return em.createQuery(query).getResultList();
    }

    @Override
    public T save(T entity) {
        if (em.contains(entity)) {
            return em.merge(entity);
        } else {
            em.persist(entity);
            return entity;
        }
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

@Entity
class Student {
    @Id @GeneratedValue
    private Long id;
    private String name;

    public Student() {}
    public Student(String name) { this.name = name; }
    public Long getId() { return id; }
    public String getName() { return name; }
    @Override public String toString() { return "Student{id=" + id + ", name='" + name + "'}"; }
}

class StudentRepository extends JpaRepository<Student, Long> {
    public StudentRepository(EntityManager em) {
        super(em, Student.class);
    }
}

public class GenericRepositoryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-unit");
        EntityManager em = emf.createEntityManager();
        StudentRepository repo = new StudentRepository(em);

        System.out.println("--- Generic Repository ---");

        em.getTransaction().begin();
        var s1 = repo.save(new Student("Alice"));
        var s2 = repo.save(new Student("Bob"));
        em.getTransaction().commit();

        System.out.println("Saved student: " + repo.findById(s1.getId()));
        System.out.println("All students: " + repo.findAll());
        System.out.println("Count: " + repo.count());

        em.getTransaction().begin();
        repo.deleteById(s1.getId());
        em.getTransaction().commit();
        System.out.println("Deleted student 1");
        System.out.println("Count after delete: " + repo.count());

        System.out.println("\n--- Transaction Rollback Test ---");
        em.getTransaction().begin();
        repo.save(new Student("Charlie"));
        System.out.println("Before rollback: " + repo.count() + " students");
        em.getTransaction().rollback();
        System.out.println("After rollback: " + repo.count() + " student (rollback restored original state)");

        em.close();
        emf.close();
    }
}
