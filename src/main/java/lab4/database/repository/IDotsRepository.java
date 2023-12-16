package lab4.database.repository;


import lab4.database.entity.DotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDotsRepository extends CrudRepository<DotEntity, Long> {
    List<DotEntity> findDotEntitiesByOwnerLogin(String ownerLogin);
}
