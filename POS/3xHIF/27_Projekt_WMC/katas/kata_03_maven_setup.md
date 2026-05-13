# Kata 3: Maven Project Setup

| Field | Value |
|-------|-------|
| Concepts | Maven, project structure, dependencies |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

Create a Maven project skeleton for your POS-WMC project. Include:
1. `pom.xml` with Javalin, Hibernate, PostgreSQL, Jackson, JUnit, and Mockito dependencies
2. Package structure: `com.example.project` with sub-packages `controller`, `service`, `repository`, `model.entity`, `model.dto`, `config`
3. A main application class that starts Javalin
4. A `persistence.xml` or Hibernate configuration file

### Example Output

```
project/
  pom.xml
  src/main/java/com/example/project/
    Main.java
    controller/
    service/
    repository/
    model/entity/
    model/dto/
    config/
  src/main/resources/
    META-INF/persistence.xml
  src/test/java/com/example/project/
```

### Extension

Add a Docker Compose file for PostgreSQL and a Maven task to start the database.
