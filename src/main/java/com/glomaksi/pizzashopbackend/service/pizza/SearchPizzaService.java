package com.glomaksi.pizzashopbackend.service.pizza;

import com.glomaksi.pizzashopbackend.dto.pizza.PizzaRequestDto;

public interface SearchPizzaService {
    PizzaProperty searchProperty(PizzaRequestDto pizza);
}
