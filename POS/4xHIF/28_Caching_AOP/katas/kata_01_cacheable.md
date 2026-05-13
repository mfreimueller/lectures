# Kata 1: @Cacheable

| Field | Value |
|-------|-------|
| Concepts | @Cacheable, CacheManager, caching |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Enable caching:

```java
@Configuration
@EnableCaching
public class CacheConfig {}
```

2. Add caching to service methods:

```java
@Service
public class BookService {

    @Cacheable("books")
    public List<BookDTO> getAll() {
        // slow database query
        return repository.findAll().stream()
            .map(mapper::toDto)
            .toList();
    }

    @Cacheable(value = "books", key = "#id")
    public BookDTO getById(Long id) {
        return repository.findById(id)
            .map(mapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
```

3. Configure TTL (time-to-live):

```java
@Bean
public CacheManager cacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();
    cacheManager.setCaches(List.of(
        new ConcurrentMapCache("books") {
            @Override
            public Object get(Object key) {
                // Custom TTL could be added here
                return super.get(key);
            }
        }
    ));
    return cacheManager;
}
```

### Extension

Replace `ConcurrentMapCache` with Caffeine (production-ready). Add Caffeine dependency and configure maximum size, TTL, and statistics: `Caffeine.newBuilder().maximumSize(100).expireAfterWrite(60, TimeUnit.SECONDS).recordStats().build()`.
