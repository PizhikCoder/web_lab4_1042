package lab4.security.jwt.service;

public interface IJwtService {
    String generateAccessToken(String username);
    String getUsernameFromToken(final String token);
}
