package lab4.database.service;

import jakarta.servlet.http.HttpServletResponse;
import lab4.connection.dto.JwtDTO;
import lab4.database.entity.UserEntity;
import lab4.database.service.interfaces.IAuthService;
import lab4.database.service.interfaces.IUserService;
import lab4.exception.UserDoesNotExistException;
import lab4.exception.UsernameOccupiedException;
import lab4.security.jwt.service.IJwtService;
import lab4.security.verifier.IVerifier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final IUserService userService;
    private final IJwtService jwtService;
    private final IVerifier<UserEntity> userVerifier;

    @Override
    public synchronized JwtDTO registerNewUser(UserEntity userEntity, HttpServletResponse response) throws UsernameOccupiedException, UserDoesNotExistException {
        if (!userService.isUserExist(userEntity.getUsername())) {
            userService.addUser(userEntity);
            return authUser(userEntity, response);
        }
        throw new UsernameOccupiedException();
    }

    @Override
    public JwtDTO authUser(UserEntity userEntity, HttpServletResponse response) throws UserDoesNotExistException {
        if (userVerifier.verify(userEntity)) {
            final String token = jwtService.generateAccessToken(userEntity.getUsername());
            return new JwtDTO(userEntity.getUsername(), token);
        }
        throw new UserDoesNotExistException();
    }
}
