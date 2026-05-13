# Kata 3: Custom Login Page

| Field | Value |
|-------|-------|
| Concepts | Form-based login, login page, logout, CSRF |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Update SecurityConfig for form-based login:

```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/ui/login", "/css/**").permitAll()
            .requestMatchers("/ui/**").authenticated()
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/ui/login")
            .defaultSuccessUrl("/ui/books")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/ui/logout")
            .logoutSuccessUrl("/ui/login?logout")
            .permitAll()
        );
    return http.build();
}
```

2. Create a login controller:

```java
@Controller
@RequestMapping("/ui")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
```

3. Create `templates/login.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head><title>Login</title></head>
<body>
    <h1>Login</h1>
    <div th:if="${param.error}">Invalid credentials</div>
    <div th:if="${param.logout}">You have been logged out</div>
    <form th:action="@{/ui/login}" method="post">
        <div>
            <label>Username:</label>
            <input type="text" name="username" required />
        </div>
        <div>
            <label>Password:</label>
            <input type="password" name="password" required />
        </div>
        <button type="submit">Login</button>
    </form>
</body>
</html>
```

4. Add CSRF token to all Thymeleaf forms (Thymeleaf auto-adds it with `th:action`)

5. Test the full flow: login → redirect to books list → logout → redirect to login page

### Extension

Add \"Remember Me\" functionality. Display the logged-in username in the header using `th:text="${#authentication.name}"`. Add a logout button to the navigation bar.
