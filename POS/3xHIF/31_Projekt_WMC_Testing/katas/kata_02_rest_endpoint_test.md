# Kata 2: REST Endpoint Test

| Field | Value |
|-------|-------|
| Concepts | Integration testing, Javalin, HTTP |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write an integration test that:
1. Starts a Javalin app with a `GET /api/books` endpoint
2. Sends an HTTP request to the endpoint
3. Asserts the response status code and body
4. Stops the app after the test

### Example Output

```java
@Test
void testGetAllBooks() {
    var app = Javalin.create();
    app.get("/api/books", ctx -> ctx.json(List.of(
        new BookDto(1L, "The Hobbit")
    )));
    app.start(0);
    var port = app.port();
    var response = Unirest.get("http://localhost:" + port + "/api/books").asString();
    assertThat(response.getStatus()).isEqualTo(200);
    assertThat(response.getBody()).contains("The Hobbit");
    app.stop();
}
```

### Extension

Test POST, PUT, and DELETE endpoints as well, using a test request body.
