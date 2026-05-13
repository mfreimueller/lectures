# Kata 2: Custom Health Indicator

| Field | Value |
|-------|-------|
| Concepts | HealthIndicator, Health, health check |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Create a custom health indicator for the database:

```java
@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    public DatabaseHealthIndicator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(1000)) {
                return Health.up()
                    .withDetail("database", "PostgreSQL")
                    .withDetail("status", "connected")
                    .build();
            } else {
                return Health.down()
                    .withDetail("database", "PostgreSQL")
                    .withDetail("status", "connection invalid")
                    .build();
            }
        } catch (Exception e) {
            return Health.down(e)
                .withDetail("database", "PostgreSQL")
                .build();
        }
    }
}
```

2. Create a health indicator for the external JSONPlaceholder API:

```java
@Component
public class ExternalApiHealthIndicator implements HealthIndicator {

    private final RestClient restClient;

    @Override
    public Health health() {
        try {
            var response = restClient.get()
                .uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .toBodilessEntity();
            return Health.up()
                .withDetail("api", "JSONPlaceholder")
                .withDetail("status", response.getStatusCode().value())
                .build();
        } catch (Exception e) {
            return Health.down(e)
                .withDetail("api", "JSONPlaceholder")
                .build();
        }
    }
}
```

3. Test: check `/actuator/health` — the response should now include both custom indicators:

```json
{
    "status": "UP",
    "components": {
        "database": { "status": "UP", "details": { ... } },
        "externalApi": { "status": "UP", "details": { ... } },
        "db": { "status": "UP" }
    }
}
```

### Extension

Create a composite `LivenessHealthIndicator` and `ReadinessHealthIndicator` using Spring's `Kubernetes` health groups. Configure separate liveness and readiness probes.
