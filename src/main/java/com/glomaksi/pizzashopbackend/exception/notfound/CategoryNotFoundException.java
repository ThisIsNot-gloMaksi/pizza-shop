package com.glomaksi.pizzashopbackend.exception.notfound;

public class CategoryNotFoundException extends ItemNotFoundException {
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public static CategoryNotFoundException createForId(long id) {
        return new CategoryNotFoundException(String.format("not found category with id=%d", id));
    }
}
