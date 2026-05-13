# Katas - Week 13: Logging

## K1: Logging in Services
**Concepts:** Logger, SLF4J, log levels, parameterized logging
**Task:** Add a Logger to LibraryService. Log at INFO for successful operations, WARN for validation failures, DEBUG for method entry/exit with parameters. Use {} placeholders instead of string concatenation.
**Duration:** 20 min

## K2: Log Configuration
**Concepts:** logback-spring.xml, per-profile config, file appender
**Task:** Configure: dev profile logs to console at DEBUG level, prod profile logs to console + file at INFO level. Add a max file size and rolling policy.
**Duration:** 20 min
