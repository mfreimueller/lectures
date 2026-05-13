import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    private static final SecretKey KEY = Keys.hmacShaKeyFor(
        "my-super-secret-key-that-is-at-least-256-bits-long!!".getBytes()
    );

    public static String generate(Long userId, String role) {
        return Jwts.builder()
            .subject(userId.toString())
            .claim("role", role)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 86_400_000))
            .signWith(KEY)
            .compact();
    }

    public static String validate(String token) {
        var claims = Jwts.parser()
            .verifyWith(KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload();
        return "sub=" + claims.getSubject()
            + ", role=" + claims.get("role")
            + ", iat=" + claims.getIssuedAt()
            + ", exp=" + claims.getExpiration();
    }

    public static void main(String[] args) {
        var token = generate(42L, "USER");
        System.out.println("Token: " + token);
        System.out.println("Claims: " + validate(token));
    }
}
