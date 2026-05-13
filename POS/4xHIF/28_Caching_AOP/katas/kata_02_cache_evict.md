# Kata 2: @CacheEvict

| Field | Value |
|-------|-------|
| Concepts | @CacheEvict, @CachePut, cache invalidation |
| Difficulty | 2/5 |
| Duration | approx. 25 min |

### Task

1. Add cache eviction to write operations:

```java
@Service
public class BookService {

    @CachePut(value = "books", key = "#result.id()")
    @CacheEvict(value = "books", key = "'all'")
    public BookDTO create(BookDTO dto) {
        // create and return
    }

    @CacheEvict(value = "books", key = "#id")
    public BookDTO update(Long id, BookDTO dto) {
        // update and return
    }

    @CacheEvict(value = "books", allEntries = true)
    public void delete(Long id) {
        // delete
    }
}
```

2. Test the cache behavior:
   - First call to `getAll()` → slow (cache miss)
   - Second call to `getAll()` → fast (cache hit)
   - Call `create(...)` → cache evicted
   - Call `getAll()` again → slow (cache miss after eviction)

### Extension

Add conditional caching with `@Cacheable(value = "books", condition = "#id > 100")`. Add `@CacheConfig(cacheNames = "books")` at class level to avoid repeating the cache name.
