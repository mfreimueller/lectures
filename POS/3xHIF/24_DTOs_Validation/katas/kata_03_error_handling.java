import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

record ErrorResponse(int status, String message, List<String> details) {}

class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Object resourceId;

    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(resourceName + " not found: " + resourceId);
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }

    public String getResourceName() { return resourceName; }
    public Object getResourceId() { return resourceId; }
}

class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Validation failed");
        this.errors = errors;
    }

    public List<String> getErrors() { return errors; }
}

public class ErrorHandlingApp {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.exception(ResourceNotFoundException.class, (e, ctx) -> {
            ctx.status(404).json(new ErrorResponse(404, e.getMessage(),
                List.of(e.getResourceName() + " ID: " + e.getResourceId())));
        });

        app.exception(ValidationException.class, (e, ctx) -> {
            ctx.status(400).json(new ErrorResponse(400, e.getMessage(), e.getErrors()));
        });

        app.exception(Exception.class, (e, ctx) -> {
            var correlationId = UUID.randomUUID().toString();
            ctx.status(500).json(new ErrorResponse(500, "Internal server error",
                List.of("Correlation ID: " + correlationId)));
        });

        app.get("/api/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            throw new ResourceNotFoundException("User", id);
        });

        app.post("/api/users", ctx -> {
            var body = ctx.bodyAsClass(Map.class);
            throw new ValidationException(List.of(
                "Username must not be blank",
                "Invalid email format",
                "Password too short"
            ));
        });

        app.get("/api/error", ctx -> {
            throw new RuntimeException("Unexpected error");
        });
    }
}
