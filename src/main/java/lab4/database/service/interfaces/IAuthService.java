package lab4.database.service.interfaces;

import jakarta.servlet.http.HttpServletResponse;
import lab4.connection.dto.JwtDTO;
import lab4.database.entity.UserEntity;
import lab4.exception.UserDoesNotExistException;
import lab4.exception.UsernameOccupiedException;

public interface IAuthService {
    JwtDTO registerNewUser(UserEntity userEntity, HttpServletResponse response) throws UsernameOccupiedException, UserDoesNotExistException;
    JwtDTO authUser(UserEntity userEntity, HttpServletResponse response) throws UserDoesNotExistException;
}
