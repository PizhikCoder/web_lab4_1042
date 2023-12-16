package lab4.connection;

import lombok.Getter;

public enum HttpCodes {
    WRONG_DOT_LIMITS(460);

    @Getter
    private int code;

    HttpCodes(int code) {
        this.code = code;
    }
}
