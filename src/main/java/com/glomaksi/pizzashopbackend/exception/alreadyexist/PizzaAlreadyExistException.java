package com.glomaksi.pizzashopbackend.exception.alreadyexist;

public class PizzaAlreadyExistException extends ItemAlreadyExistException {
    public PizzaAlreadyExistException() {
        super();
    }

    public PizzaAlreadyExistException(String message) {
        super(message);
    }

    public static PizzaAlreadyExistException createForName(String name) {
        return new PizzaAlreadyExistException(String
                .format("pizza with name=%s already exist", name));
    }
}
