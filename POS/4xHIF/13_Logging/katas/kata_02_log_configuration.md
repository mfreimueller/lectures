# Kata 2: Log Configuration

| Field | Value |
|-------|-------|
| Concepts | logback-spring.xml, per-profile config, file appender |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Create `src/main/resources/logback-spring.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- Console Appender (alle Profile) -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <!-- File Appender (nur prod) -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>logs/app.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>logs/app.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <springProfile name="dev">
        <root level="DEBUG">
            <appender-ref ref="CONSOLE"/>
        </root>
    </springProfile>

    <springProfile name="prod">
        <root level="INFO">
            <appender-ref ref="CONSOLE"/>
            <appender-ref ref="FILE"/>
        </root>
    </springProfile>
</configuration>
```

2. Configure `application.yml`:
   ```yaml
   logging:
     level:
       at.spengergasse: DEBUG
       org.springframework: WARN
   ```

3. Test by starting the app with:
   - `--spring.profiles.active=dev` → DEBUG on console
   - `--spring.profiles.active=prod` → INFO on console + rolling file

### Extension

Add a JSON appender using `logstash-logback-encoder` for structured logging in the `prod` profile. Verify the output is valid JSON.
