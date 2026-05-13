import java.sql.*;

public class JdbcCrud {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/school";

        try (Connection conn = DriverManager.getConnection(url, "postgres", "secret");
             Statement stmt = conn.createStatement()) {

            // CREATE
            stmt.executeUpdate("INSERT INTO student (name, email, grade) VALUES " +
                               "('Alice', 'alice@school.com', 1)");
            stmt.executeUpdate("INSERT INTO student (name, email, grade) VALUES " +
                               "('Bob', 'bob@school.com', 2)");
            stmt.executeUpdate("INSERT INTO student (name, email, grade) VALUES " +
                               "('Charlie', 'charlie@school.com', 1)");
            System.out.println("Inserted 3 students.");

            // READ
            ResultSet rs = stmt.executeQuery("SELECT id, name, email, grade FROM student ORDER BY id");
            System.out.println("All students:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name") +
                                   " (" + rs.getString("email") + ") - Grade " + rs.getInt("grade"));
            }
            rs.close();

            // UPDATE
            stmt.executeUpdate("UPDATE student SET grade = 2 WHERE id = 1");
            System.out.println("Updated grade for student 1.");

            // DELETE
            stmt.executeUpdate("DELETE FROM student WHERE id = 2");
            System.out.println("Deleted student 2.");

            // READ again
            rs = stmt.executeQuery("SELECT COUNT(*) FROM student");
            rs.next();
            System.out.println("Remaining: " + rs.getInt(1) + " students.");
            rs.close();

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
