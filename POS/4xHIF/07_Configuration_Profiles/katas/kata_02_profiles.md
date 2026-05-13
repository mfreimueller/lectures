# Kata 2: Profiles

| Field | Value |
|-------|-------|
| Concepts | @Profile, application-{profile}.yml, profile activation |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Create three profile-specific configuration files:
   - `application-dev.yml`: H2 in-memory database, debug logging, port 8080
   - `application-test.yml`: H2 file-based database, info logging, port 8081
   - `application-prod.yml`: PostgreSQL database, warn logging, port 8080

2. Create two `@Service` implementations for a `GreetingService` interface:
   - `DevGreetingService` with `@Profile("dev")`: returns `"[DEV] Hallo aus der Entwicklungsumgebung!"`
   - `ProdGreetingService` with `@Profile("prod")`: returns `"Hallo aus der Produktion!"`

3. Create a `@RestController` that injects `GreetingService` and exposes a `GET /greeting` endpoint

4. Test:
   - Start the app with `--spring.profiles.active=dev` and verify the dev greeting
   - Start the app with `--spring.profiles.active=prod` and verify the prod greeting

### Example

```java
public interface GreetingService {
    String greet();
}

@Service
@Profile("dev")
public class DevGreetingService implements GreetingService {
    public String greet() {
        return "[DEV] Hallo aus der Entwicklungsumgebung!";
    }
}

@Service
@Profile("prod")
public class ProdGreetingService implements GreetingService {
    public String greet() {
        return "Hallo aus der Produktion!";
    }
}
```

### Extension

Add a third profile `test` that uses an H2 file database. Configure Spring to activate the `dev` profile by default in `application.yml`, but allow override via environment variable `SPRING_PROFILES_ACTIVE`.
