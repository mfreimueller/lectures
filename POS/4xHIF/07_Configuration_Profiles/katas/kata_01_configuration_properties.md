# Kata 1: Configuration Properties

| Field | Value |
|-------|-------|
| Concepts | @ConfigurationProperties, @Validated, external config |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a record `AppConfig` annotated with `@ConfigurationProperties(prefix = "app")`
2. Add the following fields:
   - `String title` — not blank
   - `String version` — not blank  
   - `String contactEmail` — must be a valid email format
3. Add `@Validated` to enable validation
4. Create an `application.yml` with:
   ```yaml
   app:
     title: "Library Manager"
     version: 1.0.0
     contact-email: admin@library.com
   ```
5. Create a `@Service` that injects `AppConfig` and prints all values on startup
6. Enable `@EnableConfigurationProperties(AppConfig.class)` in the main class

### Example

```java
@ConfigurationProperties(prefix = "app")
@Validated
public record AppConfig(
    @NotBlank String title,
    @NotBlank String version,
    @Email String contactEmail
) {}
```

### Extension

Add a nested `DatasourceConfig` record inside `AppConfig` with fields `url`, `username`, and `password`. Add validation (`@NotBlank` on all fields). Structure the YAML accordingly.
