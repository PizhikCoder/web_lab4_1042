package lab4.database.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "dots")
@Data
public class DotEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private short x;

    @Column(nullable = false)
    private short y;

    @Column(nullable = false)
    private short r;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String execTime;

    @Column(nullable = false)
    private boolean result;

    @Column(nullable = false)
    private String ownerLogin;
}
