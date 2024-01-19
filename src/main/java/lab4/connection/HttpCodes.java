package lab4.connection;

import lombok.Getter;

public enum HttpCodes {
    WRONG_DOT_LIMITS(460),
    USERNAME_ALREADY_USED(470),
    UNKNOWN_USER(471),
    INVALID_USER_CREDENTIALS(472);

    @Getter
    private int code;

    HttpCodes(int code) {
        this.code = code;
    }
}
