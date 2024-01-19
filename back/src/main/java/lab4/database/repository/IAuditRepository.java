package lab4.database.repository;

import lab4.database.entity.AuditLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuditRepository extends CrudRepository<AuditLog, Long> {
}
