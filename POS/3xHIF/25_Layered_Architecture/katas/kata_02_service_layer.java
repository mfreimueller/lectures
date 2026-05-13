import java.util.List;
import java.util.Optional;

record User(Long id, String name, String email) {}
record CreateUserRequest(String name, String email) {}
record UserResponse(Long id, String name, String email) {}

interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
    boolean delete(Long id);
}

class InMemoryUserRepository implements UserRepository {
    private final java.util.Map<Long, User> users = new java.util.concurrent.ConcurrentHashMap<>();
    private long nextId = 1;

    public List<User> findAll() { return List.copyOf(users.values()); }
    public Optional<User> findById(Long id) { return Optional.ofNullable(users.get(id)); }
    public Optional<User> findByEmail(String email) {
        return users.values().stream().filter(u -> u.email().equals(email)).findFirst();
    }
    public User save(User user) {
        var saved = new User(nextId++, user.name(), user.email());
        users.put(saved.id(), saved);
        return saved;
    }
    public boolean delete(Long id) { return users.remove(id) != null; }
}

interface UserService {
    UserResponse createUser(CreateUserRequest request);
    Optional<UserResponse> getUser(Long id);
    List<UserResponse> getAllUsers();
    boolean deleteUser(Long id);
}

class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse createUser(CreateUserRequest request) {
        if (request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Name must not be blank");
        }
        if (request.email() == null || request.email().isBlank()) {
            throw new IllegalArgumentException("Email must not be blank");
        }
        if (repository.findByEmail(request.email()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        var user = repository.save(new User(null, request.name(), request.email()));
        return new UserResponse(user.id(), user.name(), user.email());
    }

    public Optional<UserResponse> getUser(Long id) {
        return repository.findById(id).map(u -> new UserResponse(u.id(), u.name(), u.email()));
    }

    public List<UserResponse> getAllUsers() {
        return repository.findAll().stream()
            .map(u -> new UserResponse(u.id(), u.name(), u.email()))
            .toList();
    }

    public boolean deleteUser(Long id) {
        return repository.delete(id);
    }
}

public class ServiceLayer {
    public static void main(String[] args) {
        var repo = new InMemoryUserRepository();
        var service = new UserServiceImpl(repo);

        System.out.println("Creating user alice... " + service.createUser(new CreateUserRequest("Alice", "alice@test.com")));

        try {
            service.createUser(new CreateUserRequest("Bob", "alice@test.com"));
        } catch (IllegalArgumentException e) {
            System.out.println("Creating duplicate email... " + e.getMessage());
        }

        System.out.println("Getting user 1... " + service.getUser(1L).orElse(null));
        System.out.println("All users: " + service.getAllUsers());
    }
}
