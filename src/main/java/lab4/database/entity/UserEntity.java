package lab4.database.entity;

import jakarta.persistence.*;
import lab4.connection.dto.UserDTO;
import lab4.exception.InvalidUserCredentialsException;
import lombok.Getter;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @Getter
    private String username;

    @Column(nullable = false)
    @Getter
    private String password;

    public UserEntity() {
    }

    public UserEntity(UserDTO userDTO) throws InvalidUserCredentialsException {
        setUsername(userDTO.getUsername());
        setPassword(userDTO.getPassword());
    }

    public void setUsername(String username) throws InvalidUserCredentialsException {
        if (username == null) throw new InvalidUserCredentialsException();
        this.username = username;
    }

    public void setPassword(String password) throws InvalidUserCredentialsException {
        if (password == null) throw new InvalidUserCredentialsException();
        this.password = password;
    }
}
