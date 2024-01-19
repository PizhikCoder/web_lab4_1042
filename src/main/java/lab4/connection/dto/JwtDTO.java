package lab4.connection.dto;

import lombok.Data;

@Data
public class JwtDTO {
    private String username;
    private String jwtToken;

    public JwtDTO(String username, String jwtToken) {

        this.username = username;
        this.jwtToken = jwtToken;
    }
}
