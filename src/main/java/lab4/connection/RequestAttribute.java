package lab4.connection;

import lombok.Getter;

public enum RequestAttribute {
    USERNAME("username");
    @Getter
    private String name;

    RequestAttribute(String name) {
        this.name = name;
    }
}
