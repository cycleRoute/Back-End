package org.cycle_route.back_end.global.web.advice.exception;

public class CustomAccessDeniedException extends RuntimeException{

    public CustomAccessDeniedException(String message){
        super(message);
    }
}
