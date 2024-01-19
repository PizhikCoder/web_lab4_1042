package lab4.connection.controller;

import jakarta.servlet.http.HttpServletResponse;
import lab4.connection.HttpCodes;
import lab4.connection.dto.JwtDTO;
import lab4.connection.dto.UserDTO;
import lab4.database.entity.UserEntity;
import lab4.database.service.interfaces.IAuthService;
import lab4.exception.InvalidUserCredentialsException;
import lab4.exception.UserDoesNotExistException;
import lab4.exception.UsernameOccupiedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @GetMapping("/login")
    public ResponseEntity<JwtDTO> login(UserDTO userDTO, HttpServletResponse response) {
        try {
            UserEntity userEntity = new UserEntity(userDTO);
            return ResponseEntity.ok(authService.authUser(userEntity, response));
        } catch (UserDoesNotExistException e) {
            return ResponseEntity.status(HttpCodes.UNKNOWN_USER.getCode()).build();
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.status(HttpCodes.INVALID_USER_CREDENTIALS.getCode()).build();
        }
    }

    @GetMapping("/register")
    public ResponseEntity<JwtDTO> register(UserDTO userDTO, HttpServletResponse response) {
        try {
            JwtDTO jwtDTO = authService.registerNewUser(new UserEntity(userDTO), response);
            return ResponseEntity.ok(jwtDTO);
        } catch (UsernameOccupiedException ex) {
            return ResponseEntity.status(HttpCodes.USERNAME_ALREADY_USED.getCode()).build();
        } catch (UserDoesNotExistException ex) {
            return ResponseEntity.status(HttpCodes.UNKNOWN_USER.getCode()).build();
        } catch (InvalidUserCredentialsException e) {
            return ResponseEntity.status(HttpCodes.INVALID_USER_CREDENTIALS.getCode()).build();
        }
    }
}
