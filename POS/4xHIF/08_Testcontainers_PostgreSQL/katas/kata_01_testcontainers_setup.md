# Kata 1: Testcontainers Setup

| Field | Value |
|-------|-------|
| Concepts | @Testcontainers, PostgreSQLContainer, @DynamicPropertySource |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add Testcontainers dependencies to your `pom.xml`:
   - `org.testcontainers:testcontainers`
   - `org.testcontainers:postgresql`
   - `org.testcontainers:junit-jupiter`

2. Create an abstract base class `RepositoryTest`:
   - Annotate with `@DataJpaTest` and `@Testcontainers`
   - Create a `static PostgreSQLContainer<?>` with `postgres:16`
   - Add a `@DynamicPropertySource` method that injects the container's JDBC URL, username, and password

3. Create a simple `BookRepositoryTest` that extends `RepositoryTest` and verifies:
   - A book can be saved and found by ID
   - All books can be retrieved

### Example

```java
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class RepositoryTest {

    private static final PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
```

### Extension

Add a Flyway-enabled variant: start the container with an init SQL script that creates the schema before Flyway runs.
