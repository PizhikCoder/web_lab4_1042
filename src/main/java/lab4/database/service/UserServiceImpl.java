package lab4.database.service;

import lab4.database.entity.UserEntity;
import lab4.database.repository.IUserRepository;
import lab4.database.service.interfaces.IUserService;
import lab4.exception.UserDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private IUserRepository repository;

    @Autowired
    public UserServiceImpl(IUserRepository repository){
        this.repository = repository;
    }

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
