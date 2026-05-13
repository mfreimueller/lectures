# Katas - Week 07: Configuration_Profiles

## K1: Configuration Properties
**Concepts:** @ConfigurationProperties, @Validated, external config
**Task:** Create an `AppConfig` record with `@ConfigurationProperties(prefix = "app")` that reads title, version, and contact email from application.yml. Add validation.
**Duration:** 20 min

## K2: Profiles
**Concepts:** @Profile, application-{profile}.yml, profile activation
**Task:** Create dev/prod profiles. Dev uses H2, prod uses PostgreSQL. Add profile-specific log levels and verify switching between profiles.
**Duration:** 25 min
