package lab4.security.jwt.utils;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface IJwtUtil {
    String generateAccessToken(Authentication authentication);

    String generateAccessToken(String username);

    String getUserNameFromToken(String token);

    boolean validateAccessToken(String token);
    long getTokenIssuedAt(String token);
    long getTokenExpiration(String token);
}
