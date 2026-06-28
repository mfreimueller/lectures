# Kata 2: REST Endpoint Test

| Field | Value |
|-------|-------|
| Concepts | Integration testing, embedded Tomcat, HTTP |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Write an integration test that:
1. Starts an embedded Tomcat server with a `GET /api/books` endpoint
2. Sends an HTTP request using Java HttpClient
3. Asserts the response status code and body
4. Stops Tomcat after the test

### Example Output

```java
@Test
void testGetAllBooks() throws Exception {
    var tomcat = new Tomcat();
    tomcat.setPort(0);
    var ctx = tomcat.addContext("", "/");
    Tomcat.addServlet(ctx, "api",
        new FrontControllerServlet(routes));
    ctx.addServletMappingDecoded("/api/*", "api");
    tomcat.start();
    var port = ctx.getConnector().getLocalPort();

    var request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:" + port + "/api/books"))
        .GET().build();
    var response = HttpClient.newHttpClient()
        .send(request, BodyHandlers.ofString());
    assertThat(response.statusCode()).isEqualTo(200);
    assertThat(response.body()).contains("The Hobbit");
    tomcat.stop();
}
```

### Extension

Test POST, PUT, and DELETE endpoints as well, using a test request body.
