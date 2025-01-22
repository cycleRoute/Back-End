package org.cycle_route.back_end.global.web.advice.exception.jwt;

public class CustomJwtException extends RuntimeException{

    public CustomJwtException(String message) {
        super(message);}
}
