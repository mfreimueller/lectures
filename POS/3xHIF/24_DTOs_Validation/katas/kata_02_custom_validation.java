import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
    String message() default "Field must not be blank";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MinLength {
    int value();
    String message() default "Field too short";
}

class Validator {
    public static List<String> validate(Object obj) {
        var errors = new ArrayList<String>();
        for (var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                var value = field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.toString().isBlank()) {
                        errors.add(field.getName() + ": " + field.getAnnotation(NotBlank.class).message());
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    var min = field.getAnnotation(MinLength.class).value();
                    if (value == null || value.toString().length() < min) {
                        errors.add(field.getName() + ": " + field.getAnnotation(MinLength.class).message()
                            + " (min " + min + ")");
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add(field.getName() + ": validation error");
            }
        }
        return errors;
    }
}

class CreateUserRequest {
    @NotBlank(message = "Username must not be blank")
    public String username;

    @NotBlank(message = "Email must not be blank")
    public String email;

    @MinLength(value = 8, message = "Password too short")
    public String password;

    public CreateUserRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

public class CustomValidation {
    public static void main(String[] args) {
        var valid = new CreateUserRequest("alice", "alice@test.com", "secret123");
        System.out.println("Validating valid request: " + Validator.validate(valid));

        var invalid = new CreateUserRequest("", "", "short");
        System.out.println("Validating invalid request: " + Validator.validate(invalid));
    }
}
