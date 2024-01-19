package lab4.database.service;

import lab4.database.entity.AuditLog;
import lab4.database.repository.IAuditRepository;
import lab4.database.service.interfaces.IAuditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements IAuditService {
    private final IAuditRepository repository;

    @Override
    public void save(AuditLog log) {
        repository.save(log);
    }
}
