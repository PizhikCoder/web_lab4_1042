package lab4.connection.dto;

import lab4.database.entity.DotEntity;
import lombok.Data;

@Data
public class DotDTO {
    private String ownerLogin;
    private Short x;
    private Short y;
    private Short r;
    private String time;
    private String execTime;
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
