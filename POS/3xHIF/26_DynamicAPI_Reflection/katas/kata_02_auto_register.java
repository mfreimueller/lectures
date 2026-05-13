import io.javalin.Javalin;
import java.lang.annotation.*;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Endpoint { String path() default ""; }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Get { String path() default ""; }

@Endpoint(path = "/api")
class HelloEndpoint {
    @Get(path = "/hello")
    public String sayHello() { return "Hello from annotated endpoint!"; }
}

@Endpoint(path = "/api")
class StatusEndpoint {
    @Get(path = "/status")
    public String getStatus() { return "{\"status\":\"running\"}"; }
}

class RouteRegistrar {
    public static void register(Javalin app, List<Object> controllers) {
        for (var controller : controllers) {
            var clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(Endpoint.class)) continue;

            var endpoint = clazz.getAnnotation(Endpoint.class);
            var basePath = endpoint.path();

            for (var method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Get.class)) {
                    var get = method.getAnnotation(Get.class);
                    var fullPath = basePath + get.path();

                    app.get(fullPath, ctx -> {
                        var result = method.invoke(controller);
                        if (result != null) ctx.result(result.toString());
                    });

                    System.out.println("Registered: GET " + fullPath);
                }
            }
        }
    }
}

public class AutoRegister {
    public static void main(String[] args) {
        var app = Javalin.create().start(7070);

        var controllers = List.of(
            new HelloEndpoint(),
            new StatusEndpoint()
        );

        RouteRegistrar.register(app, controllers);
        System.out.println("Server started with auto-registered routes!");
    }
}
