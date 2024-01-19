package lab4.connection;

import lombok.Getter;

public enum RequestAttribute {
    USERNAME("username");
    @Getter
    private final String name;

    RequestAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
