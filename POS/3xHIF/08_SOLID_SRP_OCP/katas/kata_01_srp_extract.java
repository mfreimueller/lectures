import java.util.List;
import java.util.ArrayList;

class User {
    String name;
    String email;
}

public class UserService {
    private final List<User> database = new ArrayList<>();
    private final List<String> log = new ArrayList<>();

    void registerUser(String name, String email) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Validation failed: name is required");
            return;
        }
        if (email == null || !email.contains("@") || !email.contains(".")) {
            System.out.println("Validation failed: invalid email");
            return;
        }
        for (User u : database) {
            if (u.email.equals(email)) {
                System.out.println("Validation failed: email already exists");
                return;
            }
        }

        User user = new User();
        user.name = name;
        user.email = email;
        database.add(user);
        System.out.println("User saved to database: " + name);

        System.out.println("Sending welcome email to: " + email);
        System.out.println("Email body: Welcome " + name + "!");

        log.add("User registered: " + name + " (" + email + ")");
        System.out.println("Log: User registered: " + name);
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        service.registerUser("Alice", "alice@example.com");
        service.registerUser("Bob", "invalid");
        service.registerUser("Alice", "alice@example.com"); // duplicate
    }
}
