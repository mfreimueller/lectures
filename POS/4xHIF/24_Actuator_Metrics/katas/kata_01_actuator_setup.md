# Kata 1: Actuator Setup

| Field | Value |
|-------|-------|
| Concepts | Actuator endpoints, configuration, exposure |
| Difficulty | 1/5 |
| Duration | approx. 15 min |

### Task

1. Add the Actuator dependency:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

2. Configure which endpoints are exposed via HTTP:

```yaml
# application.yml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,env,loggers
  endpoint:
    health:
      show-details: always
    env:
      show-values: always
  info:
    build:
      enabled: true
```

3. Add custom info to `application.yml`:

```yaml
info:
  app:
    name: Library Management
    version: 1.0.0
    description: REST API + WebUI for library management
    team: 4xHIF
  build:
    artifact: teamproject
    java:
      version: 17
```

4. Start the app and test:
   - `GET /actuator` — list all available endpoints
   - `GET /actuator/health` — overall health status
   - `GET /actuator/info` — custom info
   - `GET /actuator/metrics` — available metrics

### Extension

Secure the `/actuator/env` endpoint so it's only accessible with an admin role. Add `management.endpoint.env.roles=ADMIN` and test access control.
