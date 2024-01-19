package lab4.database.service.interfaces;

import lab4.database.entity.AuditLog;

public interface IAuditService {
    void save(AuditLog log);
}
