import io.javalin.Javalin;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

record BookDto(Long id, String title) {}
record CreateBookDto(String title) {}
record UpdateBookDto(String title) {}

public class CrudController {
    public static void main(String[] args) {
        var books = new ConcurrentHashMap<Long, BookDto>();
        var idCounter = new AtomicLong(1);

        var app = Javalin.create();
        app.get("/api/books", ctx -> {
            ctx.json(books.values());
        });
        app.get("/api/books/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var book = books.get(id);
            if (book == null) throw new NotFoundResponse("Book not found");
            ctx.json(book);
        });
        app.post("/api/books", ctx -> {
            var dto = ctx.bodyAsClass(CreateBookDto.class);
            if (dto.title() == null || dto.title().isBlank())
                throw new BadRequestResponse("Title is required");
            var id = idCounter.getAndIncrement();
            var book = new BookDto(id, dto.title());
            books.put(id, book);
            ctx.status(201).json(book);
        });
        app.put("/api/books/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var dto = ctx.bodyAsClass(UpdateBookDto.class);
            if (!books.containsKey(id)) throw new NotFoundResponse("Book not found");
            var book = new BookDto(id, dto.title());
            books.put(id, book);
            ctx.json(book);
        });
        app.delete("/api/books/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            if (books.remove(id) == null) throw new NotFoundResponse("Book not found");
            ctx.status(204);
        });
        app.start(7000);
    }
}
