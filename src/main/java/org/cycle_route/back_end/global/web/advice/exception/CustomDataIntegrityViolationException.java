package org.cycle_route.back_end.global.web.advice.exception;

public class CustomDataIntegrityViolationException extends RuntimeException{

    public CustomDataIntegrityViolationException(String message) {
        super(message);}
}
