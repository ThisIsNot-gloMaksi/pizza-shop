package com.glomaksi.pizzashopbackend.service.pizza;

import com.glomaksi.pizzashopbackend.dto.pizza.PizzaRequestDto;
import com.glomaksi.pizzashopbackend.dto.pizza.PizzaSimpleResponseDto;
import com.glomaksi.pizzashopbackend.entity.Pizza;

import java.util.List;

public interface PizzaService {
    List<PizzaSimpleResponseDto> getPizzas();
    Pizza getPizzaById(Long id);
    void addPizza(PizzaRequestDto pizza);
    void updatePizza(Long id, PizzaRequestDto pizza);
    void deletePizza(Long id);
}
