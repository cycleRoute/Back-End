package org.cycle_route.back_end.global.web.advice.exception;

public class CustomNoSuchElementException extends RuntimeException{
    public CustomNoSuchElementException(String message){
        super(message);
    }
}
