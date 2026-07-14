---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 24 - DT Os, Validation
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: Servlets Recap
2. Review: Current Limitations
3. What are DTOs?
4. DTO Example
5. Manual Validation
6. Custom Validation Annotations

---

## Agenda (2/2)

7. Validation with Reflection
8. Annotated DTO
9. Integration with Servlets
10. Structured Error Responses
11. Exception Handling in Front Controller

---

## Learning Objectives

- I can explain why DTOs separate API contracts from domain models
- I can define request and response DTOs using Java records
- I can create custom validation annotations with retention and target
- I can implement a reflection-based validator that reads annotations
- I can build structured error responses and centralized exception handling

---

## Review: Servlets Recap

- HttpServlet handles doGet, doPost, doPut, doDelete
- req.getReader() reads the request body
- resp.getWriter() writes the response body
- Front Controller dispatches to Command objects by route

---

## Review: Current Limitations

<div class="highlight-box">
<p>Currently we accept any data from clients -- but what if data is invalid?</p>
</div>

- Empty title? Negative price? Missing email?
- API should reject invalid data with clear error messages
- We need validation and structured error handling

---

## What are DTOs?

- Data Transfer Objects carry data between processes
- Separate API contracts from internal domain models
- DTOs can differ from entities (hide fields, combine data)
- Request DTOs: what the client sends
- Response DTOs: what the server returns

---

## Reflection: Are DTOs always necessary?

<div class="highlight-box">
<p>When can you safely expose entities directly to the API? What risks do you take when you skip the DTO layer?</p>
</div>

---

## DTO Example

```java
// Request DTO (what client sends)
public record CreateUserRequest(String username, String email, String password) {}

// Response DTO (what server returns)
public record UserResponse(Long id, String username, String email) {}
```

<div class="highlight-box">
<p>Note: passwordHash is in the entity but NOT in any DTO!</p>
</div>

---

## Now Kata 1: DTO Mapping

Define User, CreateUserRequest, and UserResponse records and implement mapping between them.

---

## Manual Validation

```java
var mapper = new ObjectMapper();
var request = mapper.readValue(
    req.getReader(), CreateUserRequest.class);
var errors = new ArrayList<String>();

if (request.username() == null || request.username().isBlank())
    errors.add("Username is required");
if (request.email() == null || !request.email().contains("@"))
    errors.add("Valid email is required");
if (request.password() == null
    || request.password().length() < 8)
    errors.add("Password must be 8+ characters");

if (!errors.isEmpty()) {
    resp.setStatus(400);
    resp.setContentType("application/json");
    mapper.writeValue(resp.getWriter(),
        Map.of("errors", errors));
}
```

---

## Custom Validation Annotations

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotBlank {
    String message() default "Field must not be blank";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MinLength {
    int value();
    String message() default "Field too short";
}
```

---

## Validation with Reflection

```java
class Validator {
    public static List<String> validate(Object obj) {
        var errors = new ArrayList<String>();
        for (var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            var value = field.get(obj);

            if (field.isAnnotationPresent(NotBlank.class)
                    && (value == null || value.toString().isBlank())) {
                errors.add(field.getName() + ": "
                    + field.getAnnotation(NotBlank.class).message());
            }
            if (field.isAnnotationPresent(MinLength.class)
                    && (value == null
                    || value.toString().length()
                    < field.getAnnotation(MinLength.class).value())) {
                errors.add(field.getName() + ": too short");
            }
        }
        return errors;
    }
}
```

---

## Now Kata 2: Custom Validation Annotations

Define @NotBlank and @MinLength annotations and implement a Validator using reflection.

---

## Annotated DTO

```java
public class CreateUserRequest {
    @NotBlank(message = "Username is required")
    public String username;

    @NotBlank(message = "Email is required")
    public String email;

    @MinLength(value = 8, message = "Password must be at least 8 characters")
    public String password;
}
```

---

## Integration with Servlets

```java
var mapper = new ObjectMapper();
var request = mapper.readValue(
    req.getReader(), CreateUserRequest.class);
var errors = Validator.validate(request);

if (!errors.isEmpty()) {
    resp.setStatus(400);
    resp.setContentType("application/json");
    mapper.writeValue(resp.getWriter(),
        Map.of("errors", errors));
    return;
}
var user = userService.create(request);
resp.setStatus(201);
mapper.writeValue(resp.getWriter(),
    new UserResponse(user.id(), user.username()));
```

---

## Structured Error Responses

```java
public record ErrorResponse(
    int status,
    String message,
    List<String> details
) {}

// Inside a Command:
var user = userService.findById(id);
if (user == null) {
    resp.setStatus(404);
    resp.setContentType("application/json");
    mapper.writeValue(resp.getWriter(), new ErrorResponse(
        404, "User not found",
        List.of("No user exists with id " + id)));
    return;
}
mapper.writeValue(resp.getWriter(),
    new UserResponse(user.id(), user.username()));
```

---

## Exception Handling in Front Controller

```java
class UserNotFoundException extends RuntimeException {
    private final long userId;
    public UserNotFoundException(long userId) {
        super("User not found: " + userId);
        this.userId = userId;
    }
    public long getUserId() { return userId; }
}

// Front Controller's service():
try { cmd.execute(req, resp); }
catch (UserNotFoundException e) {
    resp.setStatus(404);
    resp.setContentType("application/json");
    mapper.writeValue(resp.getWriter(),
        new ErrorResponse(404, e.getMessage(),
            List.of("User ID: " + e.getUserId())));
}
```

---

## Now Kata 3: Error Handling Framework

Build an error handling framework with ErrorResponse, custom exceptions, and JSON error responses.

---

## Summary

- DTOs separate API contracts from domain models
- Request DTOs define what clients send; Response DTOs define what servers return
- Manual validation works but becomes repetitive
- Custom annotations + reflection enable reusable validation
- Exception mappers centralize error handling
