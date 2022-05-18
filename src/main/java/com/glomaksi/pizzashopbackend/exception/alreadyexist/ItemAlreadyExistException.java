package com.glomaksi.pizzashopbackend.exception.alreadyexist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemAlreadyExistException extends RuntimeException {
    public ItemAlreadyExistException() {
        super();
    }

    public ItemAlreadyExistException(String message) {
        super(message);
    }
}
