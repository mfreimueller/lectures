# Kata 1: Basic Auth + In-Memory Users

| Field | Value |
|-------|-------|
| Concepts | SecurityFilterChain, InMemoryUserDetailsManager, roles |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add Spring Security dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. Create a security configuration class:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/books/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails admin = users
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();
        UserDetails user = users
            .username("user")
            .password("user")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
```

3. Test with Basic Auth:
   - `curl -u user:user http://localhost:8080/api/books` — should work
   - `curl http://localhost:8080/api/books` — should return 401

### Extension

Extract usernames and passwords to `application.yml` using `@ConfigurationProperties`. Add password encoding with `BCryptPasswordEncoder` instead of `{noop}`.
