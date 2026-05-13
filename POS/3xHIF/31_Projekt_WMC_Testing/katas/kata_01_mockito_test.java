import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock BookRepository bookRepo;
    @InjectMocks BookService bookService;

    @Test
    void shouldFindBookById() {
        var book = new Book("Dune");
        when(bookRepo.findById(1L)).thenReturn(Optional.of(book));
        var result = bookService.findById(1L);
        assertThat(result).isPresent();
        assertThat(result.get().getTitle()).isEqualTo("Dune");
    }

    @Test
    void shouldReturnEmptyWhenNotFound() {
        when(bookRepo.findById(99L)).thenReturn(Optional.empty());
        var result = bookService.findById(99L);
        assertThat(result).isEmpty();
    }

    @Test
    void shouldCreateBook() {
        var book = new Book("Dune");
        when(bookRepo.save(any())).thenReturn(book);
        var result = bookService.create(new CreateBookDto("Dune", "...", 1965, 1L));
        assertThat(result.getTitle()).isEqualTo("Dune");
        verify(bookRepo).save(any());
    }
}

class BookService {
    private final BookRepository repo;
    BookService(BookRepository repo) { this.repo = repo; }
    Optional<Book> findById(Long id) { return repo.findById(id); }
    Book create(CreateBookDto dto) { return repo.save(new Book(dto.title())); }
}

record CreateBookDto(String title, String isbn, int publishedYear, Long categoryId) {}
class BookRepository {
    Optional<Book> findById(Long id) { return Optional.empty(); }
    Book save(Book book) { return book; }
}
class Book {
    private final String title;
    Book(String title) { this.title = title; }
    String getTitle() { return title; }
}
