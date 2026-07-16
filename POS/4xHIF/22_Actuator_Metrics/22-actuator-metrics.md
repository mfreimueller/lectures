---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 22 - Spring Boot Actuator & Metrics
## POS - 4xHIF

---

## Was ist Actuator?

- Production-Ready Features für Spring Boot
- Überwachung, Metriken, Health-Checks
- Endpoints: `/health`, `/info`, `/metrics`, `/env`, `/loggers`
- Einfach per HTTP oder JMX zugreifbar

---

## Actuator Endpoints Übersicht

| Endpoint | Beschreibung |
| --- | --- |
| `/health` | Health-Status der App (UP, DOWN, OUT_OF_SERVICE) |
| `/info` | Custom App-Informationen (Version, Name, ...) |
| `/metrics` | Laufende Metriken (Speicher, CPU, HTTP-Requests) |
| `/env` | Umgebungsvariablen und Properties |
| `/loggers` | Log-Level zur Laufzeit ändern |
| `/prometheus` | Metriken im Prometheus-Format |

---

## Endpoints konfigurieren

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,env
  endpoint:
    health:
      show-details: always
    env:
      show-values: always  # Vorsicht: sensitive Daten!
```

---

## Custom Health Indicator

```java
@Component
public class DatabaseHealthIndicator
        implements HealthIndicator {

    @Override
    public Health health() {
        try (Connection conn = dataSource.getConnection()) {
            if (conn.isValid(1000)) {
                return Health.up()
                    .withDetail("database", "PostgreSQL")
                    .build();
            }
            return Health.down()
                .withDetail("reason", "Connection invalid")
                .build();
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}
```

Jeder HealthIndicator wird automatisch aggregiert.

---

## Micrometer — Metriken erfassen

```java
@Service
public class BookService {

    private final Counter bookCreatedCounter;

    public BookService(MeterRegistry registry) {
        this.bookCreatedCounter = Counter.builder("books.created")
            .description("Number of books created")
            .register(registry);
    }

    public BookDTO create(BookDTO dto) {
        bookCreatedCounter.increment();
        // ...
    }
}
```

---

## Prometheus Endpoint

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

```yaml
management:
  endpoints:
    web:
      exposure:
        include: prometheus
```

```plaintext
# HELP books_created_total Number of books created
# TYPE books_created_total counter
books_created_total 42.0

# HELP books_getAll_duration_seconds Time taken to fetch all books
# TYPE books_getAll_duration_seconds histogram
books_getAll_duration_seconds_count 128.0
```

---

## Projekt: Health-Checks + Metrics

<div class="highlight-box">
<ol>
<li>Füge Actuator zu deinem Projekt hinzu</li>
<li>Konfiguriere sinnvolle Endpoints</li>
<li>Erstelle Custom Health-Indicators (DB, externe API)</li>
<li>Füge Metriken für wichtige Geschäftsereignisse hinzu</li>
<li>Optional: Prometheus-Endpoint aktivieren</li>
</ol>
</div>

---

## What We Learned Today

- Actuator Endpoints (/health, /info, /metrics)
- Custom Health Indicators
- Micrometer Metriken (Counter, Timer, Gauge)
- Prometheus Endpoint
