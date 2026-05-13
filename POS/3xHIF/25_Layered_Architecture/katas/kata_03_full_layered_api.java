import io.javalin.Javalin;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

record Todo(Long id, String title, boolean completed) {}
record CreateTodoRequest(String title, boolean completed) {}
record UpdateTodoRequest(String title, Boolean completed) {}
record TodoResponse(Long id, String title, boolean completed) {}

interface TodoRepository {
    List<Todo> findAll();
    Optional<Todo> findById(Long id);
    Todo save(Todo todo);
    Todo update(Todo todo);
    boolean delete(Long id);
}

class InMemoryTodoRepository implements TodoRepository {
    private final ConcurrentHashMap<Long, Todo> todos = new ConcurrentHashMap<>();
    private long nextId = 1;

    public List<Todo> findAll() { return List.copyOf(todos.values()); }
    public Optional<Todo> findById(Long id) { return Optional.ofNullable(todos.get(id)); }
    public Todo save(Todo todo) {
        var saved = new Todo(nextId++, todo.title(), todo.completed());
        todos.put(saved.id(), saved);
        return saved;
    }
    public Todo update(Todo todo) {
        todos.put(todo.id(), todo);
        return todo;
    }
    public boolean delete(Long id) { return todos.remove(id) != null; }
}

interface TodoService {
    TodoResponse createTodo(CreateTodoRequest request);
    Optional<TodoResponse> getTodo(Long id);
    List<TodoResponse> getAllTodos(Boolean completed);
    Optional<TodoResponse> updateTodo(Long id, UpdateTodoRequest request);
    boolean deleteTodo(Long id);
}

class TodoServiceImpl implements TodoService {
    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) { this.repository = repository; }

    public TodoResponse createTodo(CreateTodoRequest request) {
        if (request.title() == null || request.title().isBlank())
            throw new IllegalArgumentException("Title must not be blank");
        var todo = repository.save(new Todo(null, request.title(), request.completed()));
        return new TodoResponse(todo.id(), todo.title(), todo.completed());
    }

    public Optional<TodoResponse> getTodo(Long id) {
        return repository.findById(id).map(t -> new TodoResponse(t.id(), t.title(), t.completed()));
    }

    public List<TodoResponse> getAllTodos(Boolean completed) {
        var todos = repository.findAll().stream()
            .map(t -> new TodoResponse(t.id(), t.title(), t.completed()));
        if (completed != null) todos = todos.filter(t -> t.completed() == completed);
        return todos.toList();
    }

    public Optional<TodoResponse> updateTodo(Long id, UpdateTodoRequest request) {
        return repository.findById(id).map(existing -> {
            var title = request.title() != null ? request.title() : existing.title();
            var completed = request.completed() != null ? request.completed() : existing.completed();
            var updated = repository.update(new Todo(id, title, completed));
            return new TodoResponse(updated.id(), updated.title(), updated.completed());
        });
    }

    public boolean deleteTodo(Long id) { return repository.delete(id); }
}

class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) { this.service = service; }

    public void registerRoutes(Javalin app) {
        app.get("/api/todos", ctx -> {
            var completedParam = ctx.queryParam("completed");
            Boolean completed = completedParam != null ? Boolean.parseBoolean(completedParam) : null;
            ctx.json(service.getAllTodos(completed));
        });

        app.get("/api/todos/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var todo = service.getTodo(id);
            if (todo.isPresent()) ctx.json(todo.get());
            else ctx.status(404).json("{\"error\":\"Todo not found\"}");
        });

        app.post("/api/todos", ctx -> {
            var request = ctx.bodyAsClass(CreateTodoRequest.class);
            try {
                var created = service.createTodo(request);
                ctx.status(201).json(created);
            } catch (IllegalArgumentException e) {
                ctx.status(400).json("{\"error\":\"" + e.getMessage() + "\"}");
            }
        });

        app.put("/api/todos/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var request = ctx.bodyAsClass(UpdateTodoRequest.class);
            var updated = service.updateTodo(id, request);
            if (updated.isPresent()) ctx.json(updated.get());
            else ctx.status(404).json("{\"error\":\"Todo not found\"}");
        });

        app.delete("/api/todos/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            if (service.deleteTodo(id)) ctx.status(204);
            else ctx.status(404).json("{\"error\":\"Todo not found\"}");
        });
    }
}

public class FullLayeredApi {
    public static void main(String[] args) {
        var repository = new InMemoryTodoRepository();
        var service = new TodoServiceImpl(repository);
        var controller = new TodoController(service);

        var app = Javalin.create().start(7070);
        controller.registerRoutes(app);
    }
}
