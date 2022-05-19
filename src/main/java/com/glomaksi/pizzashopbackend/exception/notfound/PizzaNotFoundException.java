package com.glomaksi.pizzashopbackend.exception.notfound;

public class PizzaNotFoundException extends ItemNotFoundException {
    public PizzaNotFoundException() {
    }

    public PizzaNotFoundException(String message) {
        super(message);
    }

    public static PizzaNotFoundException createForId(long id) {
        return new PizzaNotFoundException(String.format("not found pizza with id=%d", id));
    }
}
