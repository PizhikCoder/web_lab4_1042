package lab4.database.entity;

import jakarta.persistence.*;
import lab4.connection.dto.DotDTO;
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

    public DotEntity(DotDTO dotDTO){
        this.setX(dotDTO.getX());
        this.setY(dotDTO.getY());
        this.setR(dotDTO.getR());
        this.setTime(dotDTO.getTime());
        this.setExecTime(dotDTO.getExecTime());
        this.setResult(dotDTO.isResult());
        this.setOwnerLogin(dotDTO.getOwnerLogin());
    }
}
