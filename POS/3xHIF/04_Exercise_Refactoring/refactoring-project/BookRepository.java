import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(int id);
    List<Book> findByAuthor(String author);
    List<Book> findByYearRange(int fromYear, int toYear);
}
