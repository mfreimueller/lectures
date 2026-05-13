# Kata 1: Thymeleaf Template

| Field | Value |
|-------|-------|
| Concepts | th:each, th:text, Model, @Controller |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add the Thymeleaf dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

2. Create a `@Controller` (not `@RestController`):

```java
@Controller
@RequestMapping("/ui/books")
public class BookWebController {

    private final BookService bookService;

    public BookWebController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        model.addAttribute("pageTitle", "Book Library");
        return "books/list";
    }
}
```

3. Create `src/main/resources/templates/books/list.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title th:text="${pageTitle}">Book Library</title>
</head>
<body>
    <h1 th:text="${pageTitle}">Book Library</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="book : ${books}">
                <td th:text="${book.id}">1</td>
                <td th:text="${book.title}">Title</td>
                <td th:text="${book.author}">Author</td>
                <td th:text="${book.year}">2025</td>
            </tr>
        </tbody>
    </table>

    <p th:if="${#lists.isEmpty(books)}">No books found.</p>
</body>
</html>
```

4. Start the app and open `http://localhost:8080/ui/books`

### Extension

Add a search form at the top with a text input and submit button. Use `@RequestParam` to filter books by title. Preserve the search term in the input field after submission.
