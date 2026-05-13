import java.util.List;
import java.util.Optional;

record User(Long id, String name, String email) {}

interface UserRepository {
    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    boolean delete(Long id);
}

class InMemoryUserRepository implements UserRepository {
    private final java.util.Map<Long, User> users = new java.util.concurrent.ConcurrentHashMap<>();
    private long nextId = 1;

    public List<User> findAll() {
        return List.copyOf(users.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public User save(User user) {
        var saved = new User(nextId++, user.name(), user.email());
        users.put(saved.id(), saved);
        return saved;
    }

    public boolean delete(Long id) {
        return users.remove(id) != null;
    }
}

public class SplitLayers {
    public static void main(String[] args) {
        var repo = new InMemoryUserRepository();

        repo.save(new User(null, "Alice", "alice@test.com"));
        repo.save(new User(null, "Bob", "bob@test.com"));

        System.out.println("All users: " + repo.findAll());
        System.out.println("User 1: " + repo.findById(1L));
        System.out.println("Delete user 1: " + repo.delete(1L));
        System.out.println("After delete: " + repo.findAll());
    }
}
