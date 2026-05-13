# Kata 3: Custom Aspect

| Field | Value |
|-------|-------|
| Concepts | @Aspect, @Around, @Before, Pointcut |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add AOP dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

2. Create an execution time logging aspect:

```java
@Aspect
@Component
public class ExecutionTimeAspect {

    private final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("execution(* at.spengergasse..service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        log.info("{} took {} ms", joinPoint.getSignature(), duration);
        return result;
    }
}
```

3. Create a custom annotation `@LogExecutionTime`:

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {}
```

4. Create an aspect that only applies to methods with this annotation:

```java
@Aspect
@Component
public class CustomAnnotationAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long duration = System.nanoTime() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + duration / 1_000_000 + " ms");
        return result;
    }
}
```

5. Use the annotation on specific methods:

```java
@Service
public class BookService {

    @LogExecutionTime
    @Cacheable("books")
    public List<BookDTO> getAll() { ... }
}
```

### Extension

Create a `@AuditLog` annotation that logs the method parameters, return value, and the authenticated user. Use `SecurityContextHolder` to get the current user. Trigger the aspect only for methods in `@Service` beans.
