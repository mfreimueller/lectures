---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: de
---

<!-- _class: lead -->

# 28 - Caching & AOP
## POS - 4xHIF

---

## Warum Caching?

- Datenbank-Requests sind teuer (I/O, Netzwerk)
- Häufig gelesene, selten geänderte Daten cachen
- Reduziert Latenz und Datenbank-Last

---

## @Cacheable

```java
@Cacheable(value = "books", key = "#id")
public BookDTO getById(Long id) { ... }

@Cacheable("books")
public List<BookDTO> getAll() { ... }
```

---

## @CacheEvict

```java
@CacheEvict(value = "books", allEntries = true)
public BookDTO create(BookDTO dto) { ... }

@CacheEvict(value = "books", key = "#id")
public BookDTO update(Long id, BookDTO dto) { ... }
```

---

## AOP — @Aspect

```java
@Aspect @Component
public class ExecutionTimeAspect {
    @Around("execution(* at.spengergasse..service.*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        log.info("{} took {} ms", pjp.getSignature(),
            System.currentTimeMillis() - start);
        return result;
    }
}
```
