# Kata 1: External API

| Field | Value |
|-------|-------|
| Concepts | RestClient, REST client, external API consumption |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a `TodoRecord` matching the JSONPlaceholder todo structure:
```java
public record Todo(Long userId, Long id, String title, boolean completed) {}
```

2. Create a `RestClient` bean in your configuration:
```java
@Bean
public RestClient restClient(RestClient.Builder builder) {
    return builder
        .baseUrl("https://jsonplaceholder.typicode.com")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
}
```

3. Create a `TodoService` that uses `RestClient` to:
   - Fetch all todos: `GET /todos`
   - Fetch a single todo by ID: `GET /todos/{id}`

4. Create a `TodoController` with endpoints:
   - `GET /api/external/todos` — list all todos
   - `GET /api/external/todos/{id}` — get one todo

5. Test the endpoints — verify the data from JSONPlaceholder is returned

### Example

```java
@Service
public class TodoService {

    private final RestClient restClient;

    public TodoService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Todo> findAll() {
        return restClient.get()
            .uri("/todos")
            .retrieve()
            .body(new ParameterizedTypeReference<>() {});
    }

    public Todo findById(Long id) {
        return restClient.get()
            .uri("/todos/{id}", id)
            .retrieve()
            .body(Todo.class);
    }
}
```

### Extension

Add a `POST /api/external/todos` endpoint that creates a new todo via the external API. Use `restClient.post().body(todo).retrieve()`.
