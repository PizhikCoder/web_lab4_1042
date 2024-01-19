package lab4.database.repository;

import lab4.database.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> getByUsername(String username);
    boolean existsByUsername(String username);
}
