# Kata 1: Spring Boot Setup

| Field | Value |
|-------|-------|
| Concepts | Spring Initializr, Maven/Gradle, project structure |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

1. Open https://start.spring.io/ in your browser
2. Configure the project:
   - Project: Maven (or Gradle — as directed)
   - Language: Java
   - Spring Boot: 3.x latest stable
   - Group: `at.spengergasse`
   - Artifact: `teamproject` (or your team name)
   - Dependencies: `Spring Web`, `Spring Boot DevTools`
3. Generate the project and extract the zip
4. Open the project in IntelliJ and let Maven/Gradle sync
5. Explore the generated structure:
   - `src/main/java/at/spengergasse/...` — main source
   - `src/main/resources/application.properties` — configuration
   - `src/test/java/...` — test source
   - `pom.xml` or `build.gradle` — build file
6. Find and open the main application class (annotated with `@SpringBootApplication`)
7. Run the application — verify it starts without errors

### Extension

Add the `Spring Boot Actuator` dependency and verify the `/actuator/health` endpoint responds.
