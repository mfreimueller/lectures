import java.sql.*;
import java.util.*;
import java.lang.reflect.*;

record Student(int id, String name, String grade) {}
record Course(int id, String title, int credits) {}

interface BaseDao<T> {
    Optional<T> findById(int id);
    List<T> findAll();
    T save(T entity);
    void update(T entity);
    void deleteById(int id);
}

abstract class AbstractBaseDao<T> implements BaseDao<T> {
    protected final Connection conn;
    protected final String tableName;
    protected final Class<T> entityClass;

    public AbstractBaseDao(Connection conn, String tableName, Class<T> entityClass) {
        this.conn = conn;
        this.tableName = tableName;
        this.entityClass = entityClass;
    }

    protected abstract T mapRow(ResultSet rs) throws SQLException;
    protected abstract void setParams(PreparedStatement pstmt, T entity) throws SQLException;

    @Override
    public Optional<T> findById(int id) {
        var sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (var rs = pstmt.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    @Override
    public List<T> findAll() {
        var sql = "SELECT * FROM " + tableName + " ORDER BY id";
        try (var pstmt = conn.prepareStatement(sql);
             var rs = pstmt.executeQuery()) {
            var result = new ArrayList<T>();
            while (rs.next()) result.add(mapRow(rs));
            return result;
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    @Override
    public void deleteById(int id) {
        var sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}

class StudentDao extends AbstractBaseDao<Student> {
    public StudentDao(Connection conn) {
        super(conn, "student", Student.class);
    }

    @Override
    protected Student mapRow(ResultSet rs) throws SQLException {
        return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
    }

    @Override
    protected void setParams(PreparedStatement pstmt, Student s) throws SQLException {
        pstmt.setString(1, s.name());
        pstmt.setString(2, s.grade());
    }

    @Override
    public Student save(Student s) {
        var sql = "INSERT INTO student (name, grade) VALUES (?, ?)";
        try (var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setParams(pstmt, s);
            pstmt.executeUpdate();
            try (var keys = pstmt.getGeneratedKeys()) { keys.next(); return new Student(keys.getInt(1), s.name(), s.grade()); }
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    @Override
    public void update(Student s) {
        var sql = "UPDATE student SET name = ?, grade = ? WHERE id = ?";
        try (var pstmt = conn.prepareStatement(sql)) {
            setParams(pstmt, s);
            pstmt.setInt(3, s.id());
            pstmt.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}

public class GenericDaoDemo {
    public static void main(String[] args) throws Exception {
        var conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/school", "postgres", "secret");

        var studentDao = new StudentDao(conn);

        studentDao.save(new Student(0, "Alice", "1"));
        studentDao.save(new Student(0, "Bob", "2"));

        System.out.println("--- Generic DAO Test ---");
        System.out.println("Students: " + studentDao.findAll());

        conn.close();
    }
}
