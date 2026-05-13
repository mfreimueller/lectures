import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        var repo = new ContactRepository();

        repo.addContact(new Contact("Alice", "alice@example.com", "123-4567"));
        repo.addContact(new Contact("Bob", "bob@example.com", ""));
        repo.addContact(new Contact("Charlie", "charlie@example.com", "987-6543"));

        System.out.println("All contacts:");
        repo.allContacts().forEach(c ->
            System.out.println("  " + c.name() + " (" + c.email() + ")"));

        System.out.println("\nSearch results for \"alice\":");
        var aliceResults = repo.search("alice");
        if (aliceResults.isEmpty()) {
            System.out.println("  No contacts found");
        } else {
            aliceResults.forEach(c ->
                System.out.println("  " + c.name() + " (" + c.email() + ")"));
        }

        System.out.println("\nSearch results for \"nonexistent\":");
        var noneResults = repo.search("nonexistent");
        if (noneResults.isEmpty()) {
            System.out.println("  No contacts found");
        }
    }
}
