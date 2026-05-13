# Kata 2: docker-compose

| Field | Value |
|-------|-------|
| Concepts | docker-compose, services, volumes, networks |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Create `docker-compose.yml`:

```yaml
version: '3.8'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/library
      SPRING_DATASOURCE_USERNAME: app_user
      SPRING_DATASOURCE_PASSWORD: secret
    depends_on:
      db:
        condition: service_healthy
    networks:
      - library-network

  db:
    image: postgres:16-alpine
    ports:
      - "5432:5432"
    environment:
      POSTGRES_DB: library
      POSTGRES_USER: app_user
      POSTGRES_PASSWORD: secret
    volumes:
      - pgdata:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U app_user -d library"]
      interval: 5s
      timeout: 5s
      retries: 5
    networks:
      - library-network

volumes:
  pgdata:

networks:
  library-network:
```

2. Start the stack:

```bash
docker compose up -d
```

3. Verify both containers are running:

```bash
docker compose ps
```

4. Check the app health: `curl http://localhost:8080/actuator/health`

5. Stop and clean up:

```bash
docker compose down -v
```

### Extension

Add a `adminer` service for database administration (Adminer UI on port 8081). Add a `prometheus` service that scrapes metrics from the app's `/actuator/prometheus` endpoint.
