---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 23 - Docker
## POS - 4xHIF

---

## Warum Container?

- "It works on my machine" — nie wieder!
- Reproduzierbare Umgebungen (dev = test = prod)
- Isolation: App + DB + Services getrennt
- Einfacher Deploy, Skalierung, Rollbacks

---

## Dockerfile Basics

```dockerfile
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## Multi-Stage Build

```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Ergebnis: ~200MB statt 800MB (Maven + JDK nur im Build-Stage)

---

## docker-compose — App + DB

```yaml
services:
  app:
    build: .
    ports: ["8080:8080"]
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/library
    depends_on:
      db: { condition: service_healthy }

  db:
    image: postgres:16-alpine
    volumes: ["pgdata:/var/lib/postgresql/data"]
    healthcheck: { test: ["CMD", "pg_isready"] }

volumes: { pgdata: }
```

---

## Projekt: Containerisierung

<div class="highlight-box">
<ol>
<li>Dockerfile mit Multi-Stage-Build erstellen</li>
<li>.dockerignore anlegen</li>
<li>docker-compose.yml für App + PostgreSQL</li>
<li>docker-compose Profiles für dev/prod</li>
<li>Mit .env Datei für Secrets</li>
</ol>
</div>
