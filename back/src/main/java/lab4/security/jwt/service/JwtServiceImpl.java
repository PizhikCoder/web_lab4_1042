package lab4.security.jwt.service;

import lab4.dotslogic.interfaces.IValidator;
import lab4.security.jwt.utils.IJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class JwtServiceImpl implements IJwtService, IValidator<String> {
    private final IJwtUtil jwtUtil;

    @Autowired
    public JwtServiceImpl(IJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String generateAccessToken(String username) {
        return jwtUtil.generateAccessToken(username);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return jwtUtil.getUserNameFromToken(token);
    }


    @Override
    public boolean validate(String token) {
        return StringUtils.hasText(token) && jwtUtil.validateAccessToken(token);
    }
}
