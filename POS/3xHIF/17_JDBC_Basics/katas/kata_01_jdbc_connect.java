import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "secret";

        System.out.println("Connecting to " + url + "...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection valid: " + conn.isValid(5));
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }

        System.out.println("Connection closed.");
    }
}
