import java.sql.*;

public class JdbcTransactions {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/school";

        try (Connection conn = DriverManager.getConnection(url, "postgres", "secret")) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO student (name, email, grade) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                String[][] students = {
                    {"David", "david@school.com", "1"},
                    {"Eva", "eva@school.com", "2"},
                    {"Frank", "frank@school.com", "1"},
                    {"Grace", "alice@school.com", "2"}
                };

                System.out.println("Starting batch insert...");
                for (String[] s : students) {
                    System.out.println("Inserting: " + s[0] + " (" + s[1] + ")");
                    pstmt.setString(1, s[0]);
                    pstmt.setString(2, s[1]);
                    pstmt.setInt(3, Integer.parseInt(s[2]));
                    pstmt.executeUpdate();
                }

                conn.commit();
                System.out.println("Transaction committed.");

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Error: " + e.getMessage());
                System.out.println("Transaction rolled back.");
            }

            // Verify count
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM student")) {
                rs.next();
                System.out.println("Student count after rollback: " + rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
