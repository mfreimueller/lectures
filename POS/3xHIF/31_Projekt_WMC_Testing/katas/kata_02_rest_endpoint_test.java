import io.javalin.Javalin;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

record BookDto(Long id, String title) {}

class RestEndpointTest {

    @Test
    void testGetAllBooks() {
        var app = Javalin.create();
        app.get("/api/books", ctx -> ctx.json(List.of(
            new BookDto(1L, "The Hobbit")
        )));
        app.start(0);
        try {
            var port = app.port();
            var response = Unirest.get("http://localhost:" + port + "/api/books").asString();
            assertThat(response.getStatus()).isEqualTo(200);
            assertThat(response.getBody()).contains("The Hobbit");
        } finally {
            app.stop();
        }
    }

    @Test
    void testCreateBook() {
        var app = Javalin.create();
        app.post("/api/books", ctx -> {
            var dto = ctx.bodyAsClass(CreateBookDto.class);
            ctx.status(201).json(new BookDto(1L, dto.title()));
        });
        app.start(0);
        try {
            var port = app.port();
            var response = Unirest.post("http://localhost:" + port + "/api/books")
                .header("Content-Type", "application/json")
                .body("{\"title\":\"Dune\"}")
                .asString();
            assertThat(response.getStatus()).isEqualTo(201);
            assertThat(response.getBody()).contains("Dune");
        } finally {
            app.stop();
        }
    }
}

record CreateBookDto(String title) {}
