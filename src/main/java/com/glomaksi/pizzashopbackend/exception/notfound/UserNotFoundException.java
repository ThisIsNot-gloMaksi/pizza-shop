package com.glomaksi.pizzashopbackend.exception.notfound;

public class UserNotFoundException extends ItemNotFoundException {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }


    public static UserNotFoundException createForId(Long id) {
        return new UserNotFoundException(String.format("not found user with id=%d", id));
    }

    public static UserNotFoundException createForName(String name) {
        return new UserNotFoundException(String.format("not found user with name=%s", name));
    }
}
