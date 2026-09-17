---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 20 - Dynamic API, Reflection
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Reflection
2. Review: Annotations
3. Motivation
4. Annotation Design
5. Using the Annotations
6. Classpath Scanning

---

## Agenda (2/2)

7. Recursive Directory Scan
8. Processing @Controller
9. Resolving Handler Arguments
10. @PathVariable Support
11. Putting It All Together

---

## Learning Objectives

- I can define custom annotations for endpoint and HTTP method mapping
- I can scan the classpath to find annotated classes at runtime
- I can use reflection to process annotations and auto-register routes
- I can resolve handler method arguments from HTTP requests
- I can build a mini-framework that mimics Spring's auto-discovery

---

## Review: Reflection

- Reflection allows inspecting classes, methods, fields at runtime
- Class.forName(), obj.getClass(), Class<?> API
- Method.invoke() for dynamic method calls
- Field.get() / Field.set() for reading/writing fields

```java
Method method = obj.getClass().getMethod("sayHello");
String result = (String) method.invoke(obj);
```

---

## Review: Annotations

- Annotations add metadata to code (classes, methods, fields)
- @Retention(RUNTIME) makes them available at runtime
- @Target specifies where annotations can be used
- Processing: obj.getClass().isAnnotationPresent(MyAnnotation.class)

---

## Motivation

- Spring Boot uses annotations like @RestController, @GetMapping
- Routes are auto-discovered without manual registration
- This is called "convention over configuration"
- Today we build our own mini version of this!

<div class="highlight-box">
<p>We will create a framework that scans for annotations and auto-registers commands in the Front Controller.</p>
</div>

---

## Reflection: Convention over Configuration — what's the trade-off?

<div class="highlight-box">
<p>Auto-discovery feels like magic — but magic can be hard to debug. When does explicit manual registration become the better choice?</p>
</div>

---

## Annotation Design

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
    String path() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Get {
    String path() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Post {
    String path() default "";
}
```

---

## Using the Annotations

```java
@Controller(path = "/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }
    @Get(path = "/{id}")
    public UserResponse getUser(long id) {
        return service.getUser(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("User", id));
    }
    @Post
    public UserResponse createUser(CreateUserRequest request) {
        return service.createUser(request);
    }
}
```

---

## Classpath Scanning

```java
public static List<Class<?>> scan(String packageName)
        throws Exception {
    var classes = new ArrayList<Class<?>>();
    var packagePath = packageName.replace('.', '/');
    var urls = Thread.currentThread()
        .getContextClassLoader()
        .getResources(packagePath);
    while (urls.hasMoreElements()) {
        var url = urls.nextElement();
        scanDirectory(new File(url.toURI()),
            packageName, classes);
    }
    return classes;
}
```

---

## Recursive Directory Scan

```java
private static void scanDirectory(File dir, String pkg,
        List<Class<?>> classes) {
    for (var file : dir.listFiles()) {
        if (file.isDirectory()) {
            scanDirectory(file, pkg + "." + file.getName(),
                classes);
        } else if (file.getName().endsWith(".class")) {
            var className = pkg + "."
                + file.getName().replace(".class", "");
            classes.add(Class.forName(className));
        }
    }
}
```

---

## Processing @Controller

```java
void registerCommands(
        Map<String, Command> routes,
        List<Class<?>> classes) throws Exception {
    for (var clazz : classes) {
        if (!clazz.isAnnotationPresent(Controller.class)) continue;
        var basePath = clazz.getAnnotation(Controller.class).path();
        var instance = clazz.getDeclaredConstructor().newInstance();
        for (var method : clazz.getMethods()) {
            if (!method.isAnnotationPresent(Get.class)) continue;
            var p = basePath + method.getAnnotation(Get.class).path();
            routes.put("GET:" + p, (req, resp) -> {
                var result = method.invoke(instance,
                    resolveArguments(req, method));
                new ObjectMapper().writeValue(
                    resp.getWriter(), result); }); } } }
```

---

## Resolving Handler Arguments

```java
private static Object[] resolveArguments(
        HttpServletRequest req, Method method) {
    var types = method.getParameterTypes();
    var args = new Object[types.length];
    var mapper = new ObjectMapper();
    for (int i = 0; i < types.length; i++) {
        if (types[i] == String.class)
            args[i] = req.getReader().lines()
                .reduce("", String::concat);
        else if (types[i] == Long.class || types[i] == long.class)
            args[i] = Long.parseLong(
                req.getPathInfo().split("/")[1]);
        else
            args[i] = mapper.readValue(
                req.getReader(), types[i]);
    }
    return args;
}
```

---

## @PathVariable Support

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface PathVariable {
    String value();
}

// Enhanced argument resolver:
if (param.isAnnotationPresent(PathVariable.class)) {
    var pathVar = param.getAnnotation(PathVariable.class);
    var value = req.getPathInfo()
        .split("/")[1]; // simplified
    if (paramType == Long.class || paramType == long.class)
        args[i] = Long.parseLong(value);
    else if (paramType == Integer.class || paramType == int.class)
        args[i] = Integer.parseInt(value);
    else
        args[i] = value;
}
```

---

## Putting It All Together

```java
public class App {
    public static void main(String[] args) throws Exception {
        var routes = new HashMap<String, Command>();
        var classes = ClasspathScanner.scan("com.example.controllers");
        RouteRegistrar.registerCommands(routes, classes);

        var tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        var ctx = tomcat.addContext("", "/");
        Tomcat.addServlet(ctx, "api",
            new FrontControllerServlet(routes));
        ctx.addServletMappingDecoded("/api/*", "api");
        tomcat.start();
        tomcat.getServer().await();
    }
}
```

This is how Spring Boot discovers @RestController classes!

---

## Summary

- Custom annotations define metadata for route mapping
- Classpath scanning finds annotated classes at startup
- Reflection processes annotations and dynamically invokes methods
- Front Controller commands are registered programmatically based on annotations
- This pattern is the foundation of Spring Boot, Micronaut, Quarkus
