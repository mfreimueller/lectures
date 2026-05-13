# Kata 3: Profiles + Compose

| Field | Value |
|-------|-------|
| Concepts | Docker profiles, environment variables, profiles |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Extend `docker-compose.yml` with dev and prod profiles:

```yaml
version: '3.8'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_PROFILES_ACTIVE: ${SPRING_PROFILES_ACTIVE:-dev}
    profiles:
      - dev
      - prod

  app-dev:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_PROFILES_ACTIVE: dev
      SPRING_DATASOURCE_URL: jdbc:h2:mem:devdb
      SPRING_DATASOURCE_USERNAME: sa
      SPRING_DATASOURCE_PASSWORD:
    profiles:
      - dev

  app-prod:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_PROFILES_ACTIVE: prod
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/library
      SPRING_DATASOURCE_USERNAME: ${DB_USER}
      SPRING_DATASOURCE_PASSWORD: ${DB_PASS}
    depends_on:
      db:
        condition: service_healthy
    profiles:
      - prod

  db:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: library
      POSTGRES_USER: ${DB_USER}
      POSTGRES_PASSWORD: ${DB_PASS}
    volumes:
      - pgdata:/var/lib/postgresql/data
    profiles:
      - prod

volumes:
  pgdata:
```

2. Create a `.env` file for production secrets (do NOT commit!):

```
DB_USER=app_user
DB_PASS=supersecret
SPRING_PROFILES_ACTIVE=prod
```

3. Start dev profile:

```bash
docker compose --profile dev up -d
```

4. Start prod profile:

```bash
docker compose --profile prod up -d
```

### Extension

Add a `docker-compose.override.yml` that mounts the local Maven `target/` directory as a volume for live-reload during development. Use `spring-boot-devtools` for hot reload inside the container.
