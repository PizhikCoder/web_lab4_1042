package lab4.database.service;

import lab4.database.entity.UserEntity;
import lab4.database.repository.IUserRepository;
import lab4.database.service.interfaces.IUserService;
import lab4.exception.UserDoesNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private IUserRepository repository;

    @Override
    public UserEntity findUserByUserName(String username) throws UserDoesNotExistException {
        return repository.getByUsername(username).orElseThrow(UserDoesNotExistException::new);
    }

    @Override
    public boolean isUserExist(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        repository.save(userEntity);
    }
}
