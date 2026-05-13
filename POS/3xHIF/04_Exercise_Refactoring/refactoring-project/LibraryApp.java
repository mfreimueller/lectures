import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LibraryApp {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();

        // Create books
        final List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Clean Code", "Robert C. Martin", "978-0132350884", 2008, true));
        books.add(new Book(2, "Effective Java", "Joshua Bloch", "978-0321356680", 2018, true));
        books.add(new Book(3, "Refactoring", "Martin Fowler", "978-0201485677", 1999, false));
        books.add(new Book(4, "Design Patterns", "Gang of Four", "978-0201633610", 1994, true));
        books.add(new Book(5, "The Pragmatic Programmer", "Andy Hunt", "978-0201616224", 1999, true));

        // Create in-memory repository
        BookRepository bookRepo = new BookRepository() {
            public List<Book> findAll() { return books; }
            public Book findById(int id) {
                for (Book b : books) {
                    if (b.getId() == id) return b;
                }
                return null;
            }
            public List<Book> findByAuthor(String author) {
                List<Book> result = new ArrayList<Book>();
                for (Book b : books) {
                    if (b.getAuthor().equalsIgnoreCase(author)) result.add(b);
                }
                return result;
            }
            public List<Book> findByYearRange(int from, int to) {
                List<Book> result = new ArrayList<Book>();
                for (Book b : books) {
                    if (b.getYear() >= from && b.getYear() <= to) result.add(b);
                }
                return result;
            }
        };

        // Create members
        cal.set(2023, Calendar.SEPTEMBER, 1);
        Date sep1 = cal.getTime();
        cal.set(2024, Calendar.JANUARY, 15);
        Date jan15 = cal.getTime();
        cal.set(2024, Calendar.MARCH, 1);
        Date mar1 = cal.getTime();

        final List<Member> members = new ArrayList<Member>();
        members.add(new Member(1, "Alice Wonderland", "alice@example.com", sep1));
        members.add(new Member(2, "Bob Builder", "bob@example.com", jan15));
        members.add(new Member(3, "Charlie Brown", "charlie@example.com", mar1));

        MemberRepository memberRepo = new MemberRepository() {
            public List<Member> findAll() { return members; }
            public Member findById(int id) {
                for (Member m : members) {
                    if (m.getId() == id) return m;
                }
                return null;
            }
            public List<Member> findByName(String name) {
                List<Member> result = new ArrayList<Member>();
                for (Member m : members) {
                    if (m.getName().toLowerCase().contains(name.toLowerCase())) result.add(m);
                }
                return result;
            }
        };

        // Create loans
        cal.set(2024, Calendar.JANUARY, 15);
        Date loan1 = cal.getTime();
        cal.set(2024, Calendar.JANUARY, 28);
        Date ret1 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 1);
        Date loan2 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 10);
        Date loan3 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 20);
        Date ret3 = cal.getTime();

        List<Loan> loans = new ArrayList<Loan>();
        loans.add(new Loan(1, 1, 1, loan1, ret1));
        loans.add(new Loan(2, 3, 1, loan2, null));
        loans.add(new Loan(3, 5, 2, loan3, ret3));

        LibraryService service = new LibraryService(bookRepo, memberRepo, loans);

        // Print report
        System.out.println("=== Library Management System ===");
        System.out.println();
        System.out.println("Books available:");
        for (Book book : books) {
            System.out.println("  - " + service.formatBookStatus(book));
        }
        System.out.println();
        System.out.println("Overdue books:");
        List<Book> overdue = service.findOverdueBooks();
        if (overdue.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Book book : overdue) {
                System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
            }
        }
        System.out.println();
        System.out.println("Search results for 'clean':");
        List<Book> searchResults = service.searchBooks("clean");
        for (Book book : searchResults) {
            System.out.println("  - " + book.getTitle());
        }
        System.out.println();
        System.out.println("Late fees owed: $" + String.format("%.2f", service.calculateLateFees()));
        System.out.println();
        System.out.println("Member report for Alice:");
        System.out.println(service.getMemberReport(1));
    }
}
