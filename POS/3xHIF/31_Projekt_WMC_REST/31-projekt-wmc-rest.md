---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 31 - Projekt WMC REST
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: REST Principles
2. Review: Front Controller
3. Command Structure
4. GET Commands
5. POST Command
6. PUT Command

---

## Agenda (2/2)

7. DELETE Command
8. DTOs: Data Transfer Objects
9. Input Validation
10. Service Layer
11. Error Handling (Front Controller)

---

## Learning Objectives

- I can implement CRUD endpoints using the Command pattern with a Front Controller
- I can create DTO records with static from(Entity) mapping methods
- I can validate input data and return proper 400 error responses
- I can separate business logic into a Service layer between Controllers and Repositories
- I can handle errors consistently using exception handling in the Front Controller

---

## Review: REST Principles

- GET: retrieve resources
- POST: create resources
- PUT: update/replace resources
- DELETE: remove resources
- Resource-based URLs: /api/books, /api/books/{id}

---

## Review: Front Controller

```java
var routes = new HashMap<String, Command>();
Tomcat.addServlet(ctx, "api",
    new FrontControllerServlet(routes));
ctx.addServletMappingDecoded("/api/*", "api");
```

---

## Command Structure

```java
public class BookCommandFactory {
    private final BookService bookService;

    public BookCommandFactory(BookService svc) {
        this.bookService = svc;
    }

    public Map<String, Command> createRoutes() {
        return Map.of(
            "GET:/api/books",       new ListBooksCmd(bookService),
            "GET:/api/books/{id}",   new GetBookCmd(bookService),
            "POST:/api/books",       new CreateBookCmd(bookService),
            "PUT:/api/books/{id}",   new UpdateBookCmd(bookService),
            "DELETE:/api/books/{id}", new DeleteBookCmd(bookService));
    }
}
```

---

## GET Commands

```java
public class ListBooksCmd implements Command {
    public void execute(HttpServletRequest req,
                         HttpServletResponse resp)
            throws Exception {
        var books = bookService.findAll();
        resp.setContentType("application/json");
        new ObjectMapper().writeValue(resp.getWriter(),
            books.stream().map(BookDto::from).toList());
    }
}
```

---

## POST Command

```java
public class CreateBookCmd implements Command {
    public void execute(HttpServletRequest req,
                         HttpServletResponse resp)
            throws Exception {
        var mapper = new ObjectMapper();
        var dto = mapper.readValue(req.getReader(),
            CreateBookDto.class);
        if (dto.title() == null || dto.title().isBlank())
            throw new BadRequestException("Title is required");
        var book = bookService.create(dto);
        resp.setStatus(201);
        mapper.writeValue(resp.getWriter(),
            BookDto.from(book));
    }
}
```

---

## PUT Command

```java
public class UpdateBookCmd implements Command {
    public void execute(HttpServletRequest req,
                         HttpServletResponse resp)
            throws Exception {
        var id = Long.parseLong(
            req.getPathInfo().split("/")[1]);
        var dto = new ObjectMapper().readValue(
            req.getReader(), UpdateBookDto.class);
        var book = bookService.update(id, dto);
        new ObjectMapper().writeValue(
            resp.getWriter(), BookDto.from(book));
    }
}
```

---

## DELETE Command

```java
public class DeleteBookCmd implements Command {
    public void execute(HttpServletRequest req,
                         HttpServletResponse resp)
            throws Exception {
        var id = Long.parseLong(
            req.getPathInfo().split("/")[1]);
        bookService.delete(id);
        resp.setStatus(204);
    }
}
```

---

## DTOs: Data Transfer Objects

```java
public record BookDto(
    Long id, String title, String isbn,
    int publishedYear, String categoryName,
    List<String> authorNames
) {
    public static BookDto from(Book book) {
        return new BookDto(
            book.getId(), book.getTitle(), book.getIsbn(),
            book.getPublishedYear(), book.getCategory().getName(),
            book.getAuthors().stream().map(Author::getName).toList()
        );
    }
}

public record CreateBookDto(
    String title, String isbn, int publishedYear,
    Long categoryId, List<Long> authorIds
) {}
```

---

## Input Validation

```java
private void validate(CreateBookDto dto) {
    var errors = new ArrayList<String>();
    if (dto.title() == null || dto.title().isBlank())
        errors.add("title is required");
    if (dto.isbn() == null || !dto.isbn().matches("\\d{13}"))
        errors.add("isbn must be 13 digits");
    if (!errors.isEmpty())
        throw new BadRequestException(
            String.join("; ", errors));
}
```

---

## Service Layer

```java
public class BookService {
    private final BookRepository bookRepo;
    private final CategoryRepository catRepo;

    public Book create(CreateBookDto dto) {
        var category = catRepo.findById(dto.categoryId())
            .orElseThrow(() -> new NotFoundResponse("Category not found"));
        var book = new Book(dto.title(), dto.isbn(), dto.publishedYear(), category);
        return bookRepo.save(book);
    }
}
```

---

## Discussion: Where Does Business Logic Belong?

<div class="highlight-box">
<p>Why is the Service layer the right place for business logic? What happens when you put business logic in Controllers or Repositories instead?</p>
</div>

---

## Error Handling (Front Controller)

```java
// In FrontControllerServlet.service():
try {
    cmd.execute(req, resp);
} catch (BadRequestException e) {
    resp.setStatus(400);
    resp.setContentType("application/json");
    mapper.writeValue(resp.getWriter(),
        new ErrorDto(e.getMessage()));
} catch (NotFoundException e) {
    resp.setStatus(404);
    mapper.writeValue(resp.getWriter(),
        new ErrorDto(e.getMessage()));
} catch (Exception e) {
    resp.setStatus(500);
    mapper.writeValue(resp.getWriter(),
        new ErrorDto("Internal server error"));
}
```

---

## Summary

<div class="highlight-box">
<ul>
<li>Controller classes with route registration</li>
<li>CRUD endpoints: GET, POST, PUT, DELETE</li>
<li>DTOs for request/response mapping</li>
<li>Input validation</li>
<li>Consistent error handling</li>
</ul>
</div>
