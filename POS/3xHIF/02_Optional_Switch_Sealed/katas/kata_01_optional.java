public class OptionalKata {
    public static void main(String[] args) {
        var repo = new UserRepository();

        // orElse
        var user = repo.findById(1).orElse(new UserOptional(0, "Guest", "guest@example.com"));
        System.out.println("Found: " + user.name() + " (" + user.email() + ")");

        // ifPresent
        repo.findById(42).ifPresent(u -> System.out.println("Found: " + u.name()));

        // orElseThrow
        var found = repo.findById(99).orElseThrow(() -> new RuntimeException("User with ID 99 not found!"));
    }
}
