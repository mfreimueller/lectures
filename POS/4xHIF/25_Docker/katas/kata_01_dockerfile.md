# Kata 1: Dockerfile

| Field | Value |
|-------|-------|
| Concepts | Multi-stage build, Dockerfile, .dockerignore |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create a `.dockerignore` file:

```
target/
.idea/
*.iml
.git/
.gitignore
README.md
```

2. Create a `Dockerfile` with multi-stage build:

```dockerfile
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

3. Build the image:

```bash
docker build -t library-app .
```

4. Run the container:

```bash
docker run -p 8080:8080 library-app
```

5. Verify the app is accessible at `http://localhost:8080`

### Extension

Add a health check to the Dockerfile: `HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:8080/actuator/health || exit 1`. Use a slim distroless base image instead of alpine for even smaller image size.
