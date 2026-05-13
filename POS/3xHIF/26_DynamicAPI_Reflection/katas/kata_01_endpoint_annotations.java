import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Endpoint {
    String path() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Get {
    String path() default "";
}

@Endpoint(path = "/api")
class DemoEndpoint {
    @Get(path = "/hello")
    public String sayHello() {
        return "Hello!";
    }
}

public class EndpointAnnotations {
    public static void main(String[] args) {
        var clazz = DemoEndpoint.class;

        if (clazz.isAnnotationPresent(Endpoint.class)) {
            var endpoint = clazz.getAnnotation(Endpoint.class);
            System.out.println("Found controller: " + clazz.getSimpleName()
                + " (base path: " + endpoint.path() + ")");

            for (var method : clazz.getMethods()) {
                if (method.isAnnotationPresent(Get.class)) {
                    var get = method.getAnnotation(Get.class);
                    System.out.println("  GET " + endpoint.path() + get.path()
                        + " -> " + method.getName() + "()");
                }
            }
        }
    }
}
