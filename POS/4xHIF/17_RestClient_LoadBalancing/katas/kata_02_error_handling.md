# Kata 2: Error Handling

| Field | Value |
|-------|-------|
| Concepts | onStatus, error handling, retry, fallback |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Enhance the RestClient with error handling using `onStatus`:

```java
restClient.get()
    .uri("/todos/{id}", id)
    .retrieve()
    .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Todo with id " + id + " not found");
        }
        throw new ResponseStatusException(
            (HttpStatus) response.getStatusCode(), "Client error");
    })
    .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
        throw new ExternalServiceException("External API error: "
            + response.getStatusCode());
    })
    .body(Todo.class);
```

2. Create a custom `ExternalServiceException` (unchecked)

3. Add a `@ControllerAdvice` to handle `ExternalServiceException` → `502 Bad Gateway`

4. Add retry logic (3 attempts with exponential backoff) using Spring Retry:
   - Add `spring-retry` dependency
   - Add `@EnableRetry` to your configuration
   - Add `@Retryable` to the service method

5. Add connection and read timeouts:

```java
@Bean
public RestClient restClient() {
    return RestClient.builder()
        .requestFactory(new JdkClientHttpRequestFactory(
            HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build()))
        .build();
}
```

### Extension

Implement a Circuit Breaker pattern using Resilience4j: track failure count and skip external calls after 3 consecutive failures (open circuit). Reset after 30 seconds (half-open).
