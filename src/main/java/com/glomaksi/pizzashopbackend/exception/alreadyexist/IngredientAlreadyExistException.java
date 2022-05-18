package com.glomaksi.pizzashopbackend.exception.alreadyexist;

public class IngredientAlreadyExistException extends ItemAlreadyExistException {
    public IngredientAlreadyExistException() {
        super();
    }

    public IngredientAlreadyExistException(String message) {
        super(message);
    }

    public static IngredientAlreadyExistException createForName(String name) {
        return new IngredientAlreadyExistException(String
                .format("ingredient with name=%s already exist", name));
    }
}
