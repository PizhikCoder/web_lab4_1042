package lab4.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "audit")
@Data
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String methodName;

    @Column
    private String time;
}
