import jakarta.persistence.*;

public class JpqlQueries {
    public static void main(String[] args) {
        System.out.println("JPQL Queries:");
        System.out.println();
        System.out.println("1. Find books by author:");
        System.out.println("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :name");
        System.out.println();
        System.out.println("2. Find active loans for user:");
        System.out.println("SELECT l FROM Loan l WHERE l.user.id = :userId AND l.returned = false");
        System.out.println();
        System.out.println("3. Count books per category:");
        System.out.println("SELECT c.name, COUNT(b) FROM Category c LEFT JOIN c.books b GROUP BY c.name");
        System.out.println();
        System.out.println("4. Top 5 most-reviewed books:");
        System.out.println("SELECT b, COUNT(r) FROM Book b JOIN b.reviews r GROUP BY b ORDER BY COUNT(r) DESC");
        System.out.println();
        System.out.println("5. Overdue loans:");
        System.out.println("SELECT l FROM Loan l WHERE l.dueDate < CURRENT_DATE AND l.returned = false");
    }
}
