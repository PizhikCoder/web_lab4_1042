package lab4.connection.dto;

import lab4.database.entity.DotEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DotDTO {
    private String ownerLogin;
    private float x;
    private float y;
    private float r;
    private String time;
    private Long execTime;
    private boolean result;

    public DotDTO(DotEntity dotEntity){
        setOwnerLogin(dotEntity.getOwnerLogin());
        setTime(dotEntity.getTime());
        setResult(dotEntity.isResult());
        setX(dotEntity.getX());
        setY(dotEntity.getY());
        setR(dotEntity.getR());
        setExecTime(dotEntity.getExecTime());
    }
}
