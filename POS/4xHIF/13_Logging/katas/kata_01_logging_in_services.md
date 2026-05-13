# Kata 1: Logging in Services

| Field | Value |
|-------|-------|
| Concepts | Logger, SLF4J, log levels, parameterized logging |
| Difficulty | 2/5 |
| Duration | approx. 20 min |

### Task

1. Add a `private static final Logger` to `LibraryService`:

```java
private static final Logger log = LoggerFactory.getLogger(LibraryService.class);
```

2. Add log statements at appropriate levels:

   - **INFO**: Successful operations (member registered, book added, book checked out)
     ```java
     log.info("Book '{}' checked out by member {}", book.getTitle(), member.getName());
     ```
   - **WARN**: Validation failures, duplicate attempts
     ```java
     log.warn("Attempt to check out already borrowed book: {}", bookId);
     ```
   - **DEBUG**: Method entry/exit with parameters
     ```java
     log.debug("checkOutBook called - memberId: {}, bookId: {}", memberId, bookId);
     ```
   - **ERROR**: Exceptions caught and rethrown
     ```java
     log.error("Failed to check out book {} for member {}", bookId, memberId, ex);
     ```

3. Verify the log output in the console with different active profiles

### Rules

- Use `{}` placeholders — NEVER `+` string concatenation
- Pass exceptions as the LAST parameter
- Log at the CORRECT level — don't log everything at INFO

### Extension

Add MDC (Mapped Diagnostic Context) to include the current user or request ID in every log message. Use a `OncePerRequestFilter` to put values into `MDC.put("userId", ...)`.
