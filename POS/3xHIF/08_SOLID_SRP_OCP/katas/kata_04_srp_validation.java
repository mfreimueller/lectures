import java.util.List;
import java.util.ArrayList;

class User {
    String name;
    String email;
    int age;
}

class UserController {
    private final List<User> database = new ArrayList<>();

    public String handleRegistration(User user) {
        System.out.println("HTTP POST /users received");

        if (user == null || user.name == null || user.name.trim().isEmpty()
                || user.email == null || !user.email.contains("@")
                || user.age < 0) {
            return "400 Bad Request: Invalid user data";
        }

        database.add(user);
        System.out.println("User saved: " + user.name);

        return "201 Created: User registered";
    }

    public static void main(String[] args) {
        UserController controller = new UserController();

        User alice = new User();
        alice.name = "Alice";
        alice.email = "alice@example.com";
        alice.age = 30;
        System.out.println(controller.handleRegistration(alice));

        User invalid = new User();
        invalid.name = "";
        invalid.email = "bad";
        invalid.age = -1;
        System.out.println(controller.handleRegistration(invalid));
    }
}
