---
marp: true
theme: spengergasse
paginate: true
size: 16:9
lang: en
---

<!-- _class: lead -->

# 29 - Projekt WMC Setup
## POS - 3xHIF

---

## Agenda (1/2)

1. Review: JPA Entity Basics
2. Review: Servlet Routes
3. User Entity Design
4. Password Hashing with BCrypt
5. JWT Token Authentication
6. JWT Utility Class

---

## Agenda (2/2)

7. Registration Endpoint
8. Login Endpoint
9. AuthService
10. UserRepository
11. Role-Based Access

---

## Learning Objectives

- I can design a User entity with secure password storage using BCrypt
- I can generate and validate JWT tokens with HMAC-SHA256 signing
- I can implement registration and login endpoints that return JWT tokens
- I can build an AuthService that orchestrates user registration and authentication
- I can implement role-based access control using JWT claims

---

## Review: JPA Entity Basics

```java
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private String role;
}
```

---

## Review: Servlet Routes

```java
app.post("/api/register", ctx -> {
    var dto = ctx.bodyAsClass(RegisterRequest.class);
    var user = authService.register(dto);
    ctx.status(201).json(user);
});
```

---

## User Entity Design

- id (Long, auto-generated)
- username (unique, not null)
- email (unique, not null)
- passwordHash (not null - store hash, NOT plaintext)
- role (String - USER or ADMIN)

---

## Password Hashing with BCrypt

```java
String hash = BCrypt.withDefaults()
    .hashToString(12, password.toCharArray());
BCrypt.Result result = BCrypt.verifyer()
    .verify(password.toCharArray(), hash);
```

<div class="highlight-box"><p>Never store plaintext passwords! Always use a strong hashing algorithm like BCrypt.</p></div>

---

## Now Kata 1: Password Hashing

Read a password, hash it with BCrypt, and verify it against the hash.

---

## JWT Token Authentication

- JWT (JSON Web Token) for stateless auth
- Contains: subject (userId), role, issuedAt, expiration
- Signed with a secret key
- Sent via Authorization: Bearer header

---

## Discussion: Stateless JWT vs Server-Side Sessions

<div class="highlight-box">
<p>What are the pros and cons of stateless JWT authentication vs server-side sessions? When would you choose each approach?</p>
</div>

---

## JWT Utility Class

```java
public class JwtUtil {
    private static final String SECRET = "my-secret-key-min-256-bits-long";

    public static String generate(Long userId, String role) {
        return Jwts.builder()
            .subject(userId.toString())
            .claim("role", role)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 86400000))
            .signWith(getKey())
            .compact();
    }

    public static Claims validate(String token) {
        return Jwts.parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}
```

---

## Now Kata 2: JWT Token Utility

Create a JwtUtil class with generate and validate methods using HMAC-SHA256.

---

## Registration Endpoint

```java
app.post("/api/register", ctx -> {
    var req = ctx.bodyAsClass(RegisterRequest.class);
    if (req.username() == null || req.password() == null) {
        throw new BadRequestResponse("Missing fields");
    }
    var user = authService.register(req);
    var token = JwtUtil.generate(user.getId(), user.getRole());
    ctx.status(201).json(new AuthResponse(token, user));
});
```

---

## Login Endpoint

```java
app.post("/api/login", ctx -> {
    var req = ctx.bodyAsClass(LoginRequest.class);
    var user = authService.login(req);
    var token = JwtUtil.generate(user.getId(), user.getRole());
    ctx.json(new AuthResponse(token, user));
});
```

---

## Now Kata 3: Login Endpoint

Implement a POST /api/login servlet that accepts JSON, verifies credentials with BCrypt, and returns a JWT.

---

## AuthService

```java
public class AuthService {
    private final UserRepository userRepo;

    public User register(RegisterRequest req) {
        if (userRepo.findByUsername(req.username()).isPresent()) {
            throw new ConflictResponse("Username already exists");
        }
        var hash = BCrypt.withDefaults()
            .hashToString(12, req.password().toCharArray());
        var user = new User(req.username(), req.email(), hash, "USER");
        return userRepo.save(user);
    }

    public User login(LoginRequest req) {
        var user = userRepo.findByUsername(req.username())
            .orElseThrow(() -> new UnauthorizedResponse("Invalid credentials"));
        var result = BCrypt.verifyer()
            .verify(req.password().toCharArray(), user.getPasswordHash());
        if (!result.verified) {
            throw new UnauthorizedResponse("Invalid credentials");
        }
        return user;
    }
}
```

---

## UserRepository

```java
public class UserRepository {
    private final EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public Optional<User> findByUsername(String username) {
        return em.createQuery("SELECT u FROM User u WHERE u.username = :name", User.class)
            .setParameter("name", username)
            .getResultStream()
            .findFirst();
    }

    public User save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }
}
```

---

## Role-Based Access

- Filter or middleware checks JWT before protected routes
- Admin routes: require role "ADMIN"
- User routes: require role "USER" or "ADMIN"

```java
app.before("/api/admin/*", ctx -> {
    var token = ctx.header("Authorization");
    if (token == null || !token.startsWith("Bearer ")) {
        throw new UnauthorizedResponse("Missing token");
    }
    var claims = JwtUtil.validate(token.substring(7));
});
```

---

## Summary

<div class="highlight-box">
<ul>
<li>User entity with id, username, email, passwordHash, role</li>
<li>BCrypt for secure password hashing</li>
<li>JWT for stateless authentication</li>
<li>Registration and login endpoints</li>
<li>Role-based access control preparation</li>
</ul>
</div>
