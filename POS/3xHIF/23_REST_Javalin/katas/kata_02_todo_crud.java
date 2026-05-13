import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.List;

public record Todo(int id, String title, boolean completed) {}

public class TodoCrudApi {
    private static final List<Todo> todos = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.get("/api/todos", ctx -> {
            ctx.json(todos);
        });

        app.get("/api/todos/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var todo = todos.stream().filter(t -> t.id() == id).findFirst();
            if (todo.isPresent()) {
                ctx.json(todo.get());
            } else {
                ctx.status(404).result("Todo not found");
            }
        });

        app.post("/api/todos", ctx -> {
            var todo = ctx.bodyAsClass(Todo.class);
            var created = new Todo(nextId++, todo.title(), todo.completed());
            todos.add(created);
            ctx.status(201).json(created);
        });

        app.put("/api/todos/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var updated = ctx.bodyAsClass(Todo.class);
            var index = -1;
            for (int i = 0; i < todos.size(); i++) {
                if (todos.get(i).id() == id) index = i;
            }
            if (index >= 0) {
                todos.set(index, new Todo(id, updated.title(), updated.completed()));
                ctx.json(todos.get(index));
            } else {
                ctx.status(404);
            }
        });

        app.delete("/api/todos/{id}", ctx -> {
            var id = Integer.parseInt(ctx.pathParam("id"));
            var removed = todos.removeIf(t -> t.id() == id);
            if (removed) ctx.status(204);
            else ctx.status(404);
        });
    }
}
