import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibraryService {
    private BookRepository bookRepo;
    private MemberRepository memberRepo;
    private List<Loan> loans;

    public LibraryService(BookRepository bookRepo, MemberRepository memberRepo, List<Loan> loans) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        this.loans = loans;
    }

    public List<Book> findOverdueBooks() {
        List<Book> overdue = new ArrayList<Book>();
        Date now = new Date();
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null) {
                long diff = now.getTime() - loan.getLoanDate().getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diff);
                if (days > 14) {
                    Book book = bookRepo.findById(loan.getBookId());
                    if (book != null) {
                        overdue.add(book);
                    }
                }
            }
        }
        return overdue;
    }

    public List<Loan> getBorrowingHistory(int memberId) {
        List<Loan> history = new ArrayList<Loan>();
        for (Loan loan : loans) {
            if (loan.getMemberId() == memberId) {
                history.add(loan);
            }
        }
        return history;
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<Book>();
        List<Book> allBooks = bookRepo.findAll();
        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        Collections.sort(results, new Comparator<Book>() {
            public int compare(Book a, Book b) {
                return a.getTitle().compareTo(b.getTitle());
            }
        });
        return results;
    }

    public double calculateLateFees() {
        double total = 0.0;
        Date now = new Date();
        for (Loan loan : loans) {
            if (loan.getReturnDate() == null) {
                long diff = now.getTime() - loan.getLoanDate().getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diff);
                if (days > 14) {
                    total += (days - 14) * 0.50;
                }
            } else {
                long diff = loan.getReturnDate().getTime() - loan.getLoanDate().getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diff);
                if (days > 14) {
                    total += (days - 14) * 0.50;
                }
            }
        }
        return total;
    }

    public String formatBookStatus(Book book) {
        String status;
        if (book.isAvailable()) {
            status = "available";
        } else {
            status = "on loan";
        }
        return book.getTitle() + " (" + book.getAuthor() + ") - " + status;
    }

    public String getMemberReport(int memberId) {
        Member member = memberRepo.findById(memberId);
        if (member == null) {
            return "Member not found.";
        }
        String report = "Member: " + member.getName() + "\n";
        report += "Email: " + member.getEmail() + "\n";
        report += "Member since: " + member.getMemberSince() + "\n";
        List<Loan> history = getBorrowingHistory(memberId);
        report += "Books borrowed: " + history.size() + "\n";
        for (Loan loan : history) {
            Book book = bookRepo.findById(loan.getBookId());
            String bookTitle = (book != null) ? book.getTitle() : "Unknown";
            report += "  - " + bookTitle + " (borrowed: " + loan.getLoanDate();
            if (loan.getReturnDate() != null) {
                report += ", returned: " + loan.getReturnDate();
            } else {
                report += ", not yet returned";
            }
            report += ")\n";
        }
        return report;
    }
}
