package com.glomaksi.pizzashopbackend.dto.pizza;

import com.glomaksi.pizzashopbackend.entity.Pizza;
import lombok.Getter;

@Getter
public class PizzaSimpleResponseDto {
    private final Long id;
    private final String name;

    public PizzaSimpleResponseDto(Pizza pizza) {
        id = pizza.getId();
        name = pizza.getName();
    }
}
