import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.List;

public record Post(int id, int userId, String title, String body) {}

public class PostApi {
    private static final List<Post> posts = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.post("/api/posts", ctx -> {
            var post = ctx.bodyAsClass(Post.class);
            var created = new Post(nextId++, post.userId(), post.title(), post.body());
            posts.add(created);
            ctx.status(201).json(created);
        });

        app.get("/api/posts", ctx -> {
            var userIdParam = ctx.queryParam("userId");
            var searchParam = ctx.queryParam("search");
            var result = posts.stream();

            if (userIdParam != null) {
                var userId = Integer.parseInt(userIdParam);
                result = result.filter(p -> p.userId() == userId);
            }
            if (searchParam != null) {
                var search = searchParam.toLowerCase();
                result = result.filter(p ->
                    p.title().toLowerCase().contains(search) ||
                    p.body().toLowerCase().contains(search));
            }
            ctx.json(result.toList());
        });

        app.get("/api/posts/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            posts.stream()
                .filter(p -> p.id() == id)
                .findFirst()
                .ifPresentOrElse(
                    ctx::json,
                    () -> ctx.status(404).json("{\"error\":\"Post not found\",\"status\":404}")
                );
        });

        app.delete("/api/posts/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            if (posts.removeIf(p -> p.id() == id)) {
                ctx.status(204);
            } else {
                ctx.status(404).json("{\"error\":\"Post not found\",\"status\":404}");
            }
        });
    }
}
