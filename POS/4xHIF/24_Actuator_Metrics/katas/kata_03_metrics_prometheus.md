# Kata 3: Metrics & Prometheus

| Field | Value |
|-------|-------|
| Concepts | Micrometer, MeterRegistry, Counter, Timer, Prometheus |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

1. Add custom metrics to a service:

```java
@Service
public class BookService {

    private final Counter bookCreatedCounter;
    private final Timer getAllBooksTimer;

    public BookService(MeterRegistry meterRegistry) {
        this.bookCreatedCounter = Counter.builder("books.created")
            .description("Number of books created")
            .register(meterRegistry);

        this.getAllBooksTimer = Timer.builder("books.getAll.duration")
            .description("Time taken to fetch all books")
            .publishPercentileHistogram()
            .register(meterRegistry);
    }

    public BookDTO create(BookDTO dto) {
        bookCreatedCounter.increment();
        // ... existing logic
    }

    public List<BookDTO> getAll() {
        return getAllBooksTimer.record(() -> {
            // ... existing logic
        });
    }
}
```

2. Add a custom gauge for the total book count:

```java
@PostConstruct
public void registerGauge() {
    Gauge.builder("books.total", repository, BookRepository::count)
        .description("Total number of books in database")
        .register(meterRegistry);
}
```

3. Add the Prometheus dependency:

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

4. Configure Prometheus endpoint:

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
```

5. Verify: `GET /actuator/prometheus` should show metrics including your custom `books_created_total` and `books_getAll_duration` metrics

### Extension

Add a `@Timed` annotation on controller methods and use `@Timed(value = "books.api.requests", extraTags = {"endpoint", "getAll"})`. Add a Health Metric that tracks the number of consecutive failures of an external API call and exposes it as a gauge.
