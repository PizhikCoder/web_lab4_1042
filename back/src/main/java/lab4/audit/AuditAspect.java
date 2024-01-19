package lab4.audit;

import lab4.database.entity.AuditLog;
import lab4.database.service.interfaces.IAuditService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Aspect
@Component
@AllArgsConstructor
public class AuditAspect {
    private final IAuditService auditService;

    @Before(value = "@annotation(MakeLog)")
    public void createLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AuditLog auditLog = new AuditLog();
        auditLog.setTime(ZonedDateTime.now().toLocalTime().toString());
        auditLog.setMethodName(signature.getMethod().getName());
        auditService.save(auditLog);
    }
}
