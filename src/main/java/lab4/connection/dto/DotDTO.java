package lab4.connection.dto;

import lombok.Data;

@Data
public class DotDTO {
    private short x;
    private short y;
    private short r;
    private String time;
    private String execTime;
    private boolean result;
}
