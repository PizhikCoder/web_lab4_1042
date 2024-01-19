package lab4.database.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lab4.connection.dto.JwtDTO;
import lab4.database.entity.UserEntity;
import lab4.database.service.interfaces.IAuthService;
import lab4.database.service.interfaces.IUserService;
import lab4.exception.UserDoesNotExistException;
import lab4.exception.UsernameOccupiedException;
import lab4.security.jwt.service.IJwtService;
import lab4.security.verifier.IVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private final int COOKIE_MAX_AGE = 3600;
    private final IUserService userService;
    private final IJwtService jwtService;
    private final IVerifier<UserEntity> userVerifier;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(IUserService userService, IJwtService jwtService, IVerifier<UserEntity> userVerifier, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.jwtService = jwtService;
        this.userVerifier = userVerifier;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public JwtDTO registerNewUser(UserEntity userEntity, HttpServletResponse response) throws UsernameOccupiedException, UserDoesNotExistException {
        if (!userService.isUserExist(userEntity.getUsername())){
            userService.addUser(userEntity);
            return authUser(userEntity, response);
        }
        throw new UsernameOccupiedException();
    }

    @Override
    public JwtDTO authUser(UserEntity userEntity, HttpServletResponse response) throws UserDoesNotExistException {
        if(userVerifier.verify(userEntity)){
            String token = jwtService.generateAccessToken(userEntity.getUsername());
            Cookie cookie = new Cookie("Token", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(COOKIE_MAX_AGE);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new JwtDTO(jwtService.getUsernameFromToken(token), token);
        }
        throw new UserDoesNotExistException();
    }

    private Cookie createCookie(String token){
        Cookie cookie = new Cookie("Token", token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(COOKIE_MAX_AGE);
        cookie.setPath("/");
        return cookie;
    }
}
