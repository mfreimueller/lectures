import java.sql.*;

public class SqlInjection {
    static final String URL = "jdbc:postgresql://localhost:5432/school";

    public static void main(String[] args) throws Exception {
        String malicious = "' OR '1'='1";

        System.out.println("--- Vulnerable version (Statement) ---");
        findStudentByNameVulnerable(malicious);

        System.out.println("\n--- Fixed version (PreparedStatement) ---");
        findStudentByNameSafe(malicious);
    }

    static void findStudentByNameVulnerable(String name) {
        String sql = "SELECT name FROM student WHERE name = '" + name + "'";
        try (Connection conn = DriverManager.getConnection(URL, "postgres", "secret");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("SQL: " + sql);
            var names = new java.util.ArrayList<String>();
            while (rs.next()) names.add(rs.getString("name"));
            System.out.println("Result: " + (names.isEmpty() ? "No students" : "ALL students returned! (SQL injection successful!)"));
            System.out.println("Students: " + names);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void findStudentByNameSafe(String name) {
        String sql = "SELECT name FROM student WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(URL, "postgres", "secret");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            System.out.println("SQL: " + sql + " (with parameter)");
            try (ResultSet rs = pstmt.executeQuery()) {
                var names = new java.util.ArrayList<String>();
                while (rs.next()) names.add(rs.getString("name"));
                System.out.println("Result: " + (names.isEmpty() ? "No students found. (Injection prevented!)" : names));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
