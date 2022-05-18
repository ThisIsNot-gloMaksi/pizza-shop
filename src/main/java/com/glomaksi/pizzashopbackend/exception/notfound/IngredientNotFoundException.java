package com.glomaksi.pizzashopbackend.exception.notfound;

public class IngredientNotFoundException extends ItemNotFoundException {
    public IngredientNotFoundException() {
        super();
    }

    public IngredientNotFoundException(String message) {
        super(message);
    }

    public static IngredientNotFoundException createForId(long id) {
        return new IngredientNotFoundException(String.format("not found ingredient with id=%d", id));
    }
}
