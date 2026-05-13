# Week 13 - Logging

**Index:** 13
**Week in year:** 15
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 10-12 | Service Layer + Validation | Services, Mocking, Exception Handling |

## Learning Objectives

- Understand SLF4J/Logback logging levels (TRACE, DEBUG, INFO, WARN, ERROR)
- Configure log levels per package and per profile
- Add meaningful log statements to service classes
- Use parameterized logging (avoid string concatenation)
- Prepare for SA 1

## Presentation (slides/)

Covers logging fundamentals: SLF4J as facade, Logback as implementation, log levels, configuration via application.yml, structured logging, and best practices for production logging.

## Katas (katas/)

1. **K1: Logging in Services** — Add appropriate log statements at INFO, WARN, and DEBUG levels to service methods.
2. **K2: Log Configuration** — Configure different log levels for dev and prod profiles. Add a log file appender.

## Materials

- SLF4J Documentation: https://www.slf4j.org/manual.html
- Logback Documentation: https://logback.qos.ch/documentation.html
