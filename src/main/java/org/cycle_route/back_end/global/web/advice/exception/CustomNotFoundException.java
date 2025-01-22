package org.cycle_route.back_end.global.web.advice.exception;

public class CustomNotFoundException extends RuntimeException{

    CustomNotFoundException(){

    }

    public CustomNotFoundException(String message) {
        super(message);
    }

}
