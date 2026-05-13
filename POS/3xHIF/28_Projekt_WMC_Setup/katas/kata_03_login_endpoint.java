import at.favre.lib.crypto.bcrypt.BCrypt;
import io.javalin.Javalin;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.http.BadRequestResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginEndpoint {
    record LoginRequest(String username, String password) {}
    record AuthResponse(String token, long userId, String username, String role) {}

    public static void main(String[] args) {
        var users = new ConcurrentHashMap<String, UserRecord>();
        var hash = BCrypt.withDefaults().hashToString(12, "secret123".toCharArray());
        users.put("alice", new UserRecord(1L, "alice", hash, "USER"));

        var app = Javalin.create();
        app.post("/api/login", ctx -> {
            var req = ctx.bodyAsClass(LoginRequest.class);
            if (req.username() == null || req.password() == null) {
                throw new BadRequestResponse("Missing username or password");
            }
            var user = users.get(req.username());
            if (user == null) {
                throw new UnauthorizedResponse("Invalid credentials");
            }
            var result = BCrypt.verifyer().verify(req.password().toCharArray(), user.passwordHash());
            if (!result.verified) {
                throw new UnauthorizedResponse("Invalid credentials");
            }
            var token = Jwts.builder()
                .subject(user.id().toString())
                .claim("role", user.role())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86_400_000))
                .signWith(Keys.hmacShaKeyFor("my-super-secret-key-that-is-at-least-256-bits-long!!".getBytes()))
                .compact();
            ctx.json(new AuthResponse(token, user.id(), user.username(), user.role()));
        });
        app.start(7000);
    }

    record UserRecord(Long id, String username, String passwordHash, String role) {}
}
