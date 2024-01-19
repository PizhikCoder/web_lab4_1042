package lab4.database.service.interfaces;

import lab4.database.entity.UserEntity;
import lab4.exception.UserDoesNotExistException;
import org.springframework.security.core.userdetails.UserDetails;


public interface IUserService {
    UserEntity findUserByUserName(String username) throws UserDoesNotExistException;

    boolean isUserExist(String username);

    void addUser(UserEntity userEntity);
}
