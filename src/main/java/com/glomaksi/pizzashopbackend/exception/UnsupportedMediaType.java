package com.glomaksi.pizzashopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class UnsupportedMediaType extends RuntimeException {
    public UnsupportedMediaType() {
        this("not found extension for this file");
    }

    public UnsupportedMediaType(String message) {
        super(message);
    }
}
