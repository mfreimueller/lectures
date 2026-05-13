import io.javalin.Javalin;
import java.util.Map;

public class HelloJavalin {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        app.get("/hello", ctx -> {
            ctx.result("Hello from Javalin!");
        });

        app.get("/status", ctx -> {
            ctx.json(Map.of("status", "running"));
        });
    }
}
