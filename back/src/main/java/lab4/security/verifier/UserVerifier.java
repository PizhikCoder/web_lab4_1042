package lab4.security.verifier;

import lab4.database.entity.UserEntity;
import lab4.database.service.interfaces.IUserService;
import lab4.exception.UserDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserVerifier implements IVerifier<UserEntity>{

    private final IUserService userService;

    @Override
    public boolean verify(UserEntity entity) {
        try{
            UserEntity user = userService.findUserByUserName(entity.getUsername());
            return user.getUsername().equals(entity.getUsername())
                    && user.getPassword().equals(entity.getPassword());
        }
        catch (UserDoesNotExistException exception){
            return false;
        }
    }
}
