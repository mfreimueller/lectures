# Kata 1: springdoc-openapi

| Field | Value |
|-------|-------|
| Concepts | OpenAPI, springdoc-openapi, Swagger UI |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

1. Add the springdoc-openapi dependency:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

2. Start the application

3. Open the following URLs:
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - OpenAPI JSON: `http://localhost:8080/v3/api-docs`

4. Explore the generated documentation — note how all endpoints, models, and response types are automatically detected

5. Test an endpoint directly from Swagger UI (click "Try it out")

### Extension

Add a `springdoc.swagger-ui.path=/docs` property to `application.yml` to customize the Swagger UI path. Add `springdoc.api-docs.path=/api-docs` to customize the API docs path.
