package org.cycle_route.back_end.global.web.advice.exception.jwt;

public class CustomExpiredJwtException extends RuntimeException {

    public CustomExpiredJwtException(String message) {
        super(message);
    }
}
