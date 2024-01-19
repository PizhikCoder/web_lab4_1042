package lab4.security.jwt.utils;

public interface IJwtUtil {

    String generateAccessToken(String username);

    String getUserNameFromToken(String token);

    boolean validateAccessToken(String token);
    long getTokenIssuedAt(String token);
    long getTokenExpiration(String token);
}
