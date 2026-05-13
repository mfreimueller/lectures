import java.sql.*;
import java.util.*;

record Student(int id, String name, String email, int grade) {}

interface StudentDao {
    Optional<Student> findById(int id);
    List<Student> findAll();
    Student save(Student student);
    void update(Student student);
    void delete(int id);
}

class StudentDaoJdbc implements StudentDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/school";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, "postgres", "secret");
    }

    @Override
    public Optional<Student> findById(int id) {
        var sql = "SELECT * FROM student WHERE id = ?";
        try (var conn = getConnection();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (var rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Student(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getInt("grade")));
                }
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        var sql = "SELECT * FROM student ORDER BY id";
        var result = new ArrayList<Student>();
        try (var conn = getConnection();
             var pstmt = conn.prepareStatement(sql);
             var rs = pstmt.executeQuery()) {
            while (rs.next()) {
                result.add(new Student(rs.getInt("id"), rs.getString("name"),
                                      rs.getString("email"), rs.getInt("grade")));
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return result;
    }

    @Override
    public Student save(Student student) {
        var sql = "INSERT INTO student (name, email, grade) VALUES (?, ?, ?)";
        try (var conn = getConnection();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, student.name());
            pstmt.setString(2, student.email());
            pstmt.setInt(3, student.grade());
            pstmt.executeUpdate();
            try (var keys = pstmt.getGeneratedKeys()) {
                keys.next();
                return new Student(keys.getInt(1), student.name(),
                                  student.email(), student.grade());
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    @Override
    public void update(Student student) {
        var sql = "UPDATE student SET name = ?, email = ?, grade = ? WHERE id = ?";
        try (var conn = getConnection();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.name());
            pstmt.setString(2, student.email());
            pstmt.setInt(3, student.grade());
            pstmt.setInt(4, student.id());
            pstmt.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    @Override
    public void delete(int id) {
        var sql = "DELETE FROM student WHERE id = ?";
        try (var conn = getConnection();
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}

public class StudentDaoDemo {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoJdbc();
        System.out.println("--- Student DAO Test ---");

        Student s1 = dao.save(new Student(0, "Alice", "alice@school.com", 1));
        System.out.println("Saved: " + s1);

        dao.save(new Student(0, "Bob", "bob@school.com", 2));
        dao.save(new Student(0, "Charlie", "charlie@school.com", 1));

        System.out.println("Found by id: " + dao.findById(s1.id()).orElse(null));
        System.out.println("All students: " + dao.findAll());

        dao.update(new Student(s1.id(), "Alice", "alice@school.com", 2));
        System.out.println("Updated grade to 2");

        dao.delete(s1.id());
        System.out.println("After delete: " + dao.findAll().size() + " students remaining");
    }
}
