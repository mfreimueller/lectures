# Week 11 - ServiceLayer_Testing

**Index:** 11
**Week in year:** 13
**Theory:** 2h | **Practice:** 2h

---

## Previously Learned Content

| Index | Week | Topics |
|-------|------|--------|
| 10 | Service Layer | @Service, @Transactional, Command objects |

## Learning Objectives

- Write unit tests for service classes by mocking repositories
- Use Mockito annotations: `@Mock`, `@InjectMocks`, `@ExtendWith(MockitoExtension.class)`
- Verify interactions with `verify()` and `ArgumentCaptor`
- Differentiate behaviour tests from state tests

## Presentation (slides/)

Covers Mockito-based testing of service classes: mocking dependencies, verifying behaviour, testing exception scenarios, and using ArgumentCaptor for complex verifications.

## Katas (katas/)

1. **K1: Mocking Basics** — Test a service method with mocked repositories using @Mock and @InjectMocks.
2. **K2: Behavior Verification** — Test a transactional service method and verify correct repository interactions.

## Materials

- Mockito Reference: https://site.mockito.org/
- Baeldung: Mockito with Spring
