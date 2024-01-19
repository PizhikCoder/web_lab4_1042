package lab4.security.jwt.service;

import lab4.database.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface IJwtService {
    String generateAccessToken(Authentication authentication);

    String generateAccessToken(String username);
    String getUsernameFromToken(final String token);
    boolean checkTokenExpired(final String token);
}
