import java.time.LocalDateTime;

record User(Long id, String username, String email, String passwordHash, LocalDateTime createdAt) {}
record CreateUserRequest(String username, String email, String password) {}
record UserResponse(Long id, String username, String email) {}

class UserMapper {
    private static long nextId = 1;

    public static User toUser(CreateUserRequest request) {
        var hash = Integer.toHexString(request.password().hashCode());
        return new User(nextId++, request.username(), request.email(),
                        hash, LocalDateTime.now());
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.id(), user.username(), user.email());
    }
}

public class DtoMapping {
    public static void main(String[] args) {
        var request = new CreateUserRequest("alice", "alice@example.com", "secret123");
        System.out.println("Creating user from request: " + request);

        var user = UserMapper.toUser(request);
        System.out.println("User created: " + user);

        var response = UserMapper.toResponse(user);
        System.out.println("Public response: " + response);
    }
}
