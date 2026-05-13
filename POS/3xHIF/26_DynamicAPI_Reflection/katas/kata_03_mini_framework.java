import io.javalin.Javalin;
import io.javalin.http.Context;
import java.lang.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Controller { String path() default ""; }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Get { String path() default ""; }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Post { String path() default ""; }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface PathVariable { String value(); }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface Body {}

class Framework {
    public static void registerControllers(Javalin app, List<Object> controllers) {
        for (var controller : controllers) {
            var clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(Controller.class)) continue;

            var controllerAnn = clazz.getAnnotation(Controller.class);
            var basePath = controllerAnn.path();

            for (var method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Get.class)) {
                    var path = basePath + method.getAnnotation(Get.class).path();
                    app.get(path, ctx -> handle(controller, method, ctx));
                    System.out.println("GET " + path);
                }
                if (method.isAnnotationPresent(Post.class)) {
                    var path = basePath + method.getAnnotation(Post.class).path();
                    app.post(path, ctx -> handle(controller, method, ctx));
                    System.out.println("POST " + path);
                }
            }
        }
    }

    private static void handle(Object controller, java.lang.reflect.Method method, Context ctx) {
        try {
            var params = method.getParameters();
            var args = new Object[params.length];

            for (int i = 0; i < params.length; i++) {
                if (params[i].isAnnotationPresent(PathVariable.class)) {
                    var pv = params[i].getAnnotation(PathVariable.class);
                    var value = ctx.pathParam(pv.value());
                    args[i] = convert(value, params[i].getType());
                } else if (params[i].isAnnotationPresent(Body.class)) {
                    args[i] = ctx.bodyAsClass(params[i].getType());
                } else if (params[i].getType() == Context.class) {
                    args[i] = ctx;
                }
            }

            var result = method.invoke(controller, args);
            if (result != null) ctx.json(result);
        } catch (Exception e) {
            ctx.status(500).json(Map.of("error", e.getCause() != null ?
                e.getCause().getMessage() : e.getMessage()));
        }
    }

    private static Object convert(String value, Class<?> type) {
        if (type == Long.class || type == long.class) return Long.parseLong(value);
        if (type == Integer.class || type == int.class) return Integer.parseInt(value);
        return value;
    }
}

record UserResponse(long id, String name) {}

@Controller(path = "/api")
class UserController {
    private final Map<Long, String> users = new ConcurrentHashMap<>();

    public UserController() {
        users.put(42L, "Alice");
        users.put(7L, "Bob");
    }

    @Get(path = "/users/{id}")
    public UserResponse getUser(@PathVariable("id") long id) {
        var name = users.get(id);
        if (name == null) throw new RuntimeException("User not found: " + id);
        return new UserResponse(id, name);
    }

    @Get(path = "/users")
    public List<Long> listUsers() {
        return List.copyOf(users.keySet());
    }
}

public class MiniFramework {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);
        Framework.registerControllers(app, List.of(new UserController()));
        System.out.println("Mini-framework server started!");
    }
}
