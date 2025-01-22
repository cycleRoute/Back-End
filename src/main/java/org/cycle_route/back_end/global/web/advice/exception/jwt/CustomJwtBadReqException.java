package org.cycle_route.back_end.global.web.advice.exception.jwt;

public class CustomJwtBadReqException extends RuntimeException {

    public CustomJwtBadReqException(String message) {
        super(message);
    }
}
