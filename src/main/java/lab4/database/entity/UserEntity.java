package lab4.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class UserEntity {
    @Id
    private String login;

    @Column(nullable = false)
    private String password;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ownerLogin", referencedColumnName = "login")
//    private List<DotEntity> dots;
}
