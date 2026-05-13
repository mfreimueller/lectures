import java.util.List;

record BookDto(Long id, String title, String isbn, int publishedYear, String categoryName, List<String> authorNames) {
    public static BookDto from(Book book) {
        return new BookDto(
            book.id(), book.title(), book.isbn(), book.publishedYear(),
            book.category().name(),
            book.authors().stream().map(Author::name).toList()
        );
    }
}

record CreateBookDto(String title, String isbn, int publishedYear, Long categoryId, List<Long> authorIds) {}

record CategoryDto(Long id, String name, String description, int bookCount) {
    public static CategoryDto from(Category category) {
        return new CategoryDto(category.id(), category.name(), category.description(), category.bookCount());
    }
}

record Book(Long id, String title, String isbn, int publishedYear, Category category, List<Author> authors) {}
record Category(Long id, String name, String description, int bookCount) {}
record Author(Long id, String name) {}

public class DtoMapping {
    public static void main(String[] args) {
        var cat = new Category(1L, "Fiction", "Fiction books", 5);
        var author = new Author(1L, "Tolkien");
        var book = new Book(1L, "The Hobbit", "9780547928227", 1937, cat, List.of(author));
        var dto = BookDto.from(book);
        System.out.println(dto);
    }
}
