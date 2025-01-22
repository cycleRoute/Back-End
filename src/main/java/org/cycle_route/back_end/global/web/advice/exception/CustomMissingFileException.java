package org.cycle_route.back_end.global.web.advice.exception;

public class CustomMissingFileException extends RuntimeException{

    public CustomMissingFileException(String message){
        super(message);
    }
}