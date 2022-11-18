package com.mrtb.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException{
    private String message;
    public UserAlreadyExistException(){}
    public UserAlreadyExistException(String msg){
        super(msg);
        this.message=msg;
    }
}
