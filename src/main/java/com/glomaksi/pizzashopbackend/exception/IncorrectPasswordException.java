package com.glomaksi.pizzashopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException() {
        super();
    }
}
