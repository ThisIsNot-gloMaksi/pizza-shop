package com.glomaksi.pizzashopbackend.exception.alreadyexist;

public class CategoryAlreadyExistException extends ItemAlreadyExistException {
    public CategoryAlreadyExistException() {
        super();
    }

    public CategoryAlreadyExistException(String message) {
        super(message);
    }

    public static CategoryAlreadyExistException createForName(String name) {
        return new CategoryAlreadyExistException(String
                .format("category with name=%s already exist", name));
    }
}
