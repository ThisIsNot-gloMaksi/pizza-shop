package com.glomaksi.pizzashopbackend.exception.alreadyexist;

public class UserAlreadyExistException extends ItemAlreadyExistException {
    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public static UserAlreadyExistException createForUsername(String username) {
        return new UserAlreadyExistException(String
                .format("user with username=%s already exist", username));
    }
}
