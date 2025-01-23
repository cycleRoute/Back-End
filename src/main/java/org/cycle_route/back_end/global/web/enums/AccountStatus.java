package org.cycle_route.back_end.global.web.enums;

public enum AccountStatus {
    ACTIVE("ACTIVE"),
    DELETED("DELETED");
    private final String type;

    AccountStatus(String type) { this.type = type; }

    public String getType() { return type; }
}
