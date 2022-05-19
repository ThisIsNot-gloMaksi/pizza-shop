package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.dto.pizza.PizzaRequestDto;
import com.glomaksi.pizzashopbackend.dto.pizza.PizzaSimpleResponseDto;
import com.glomaksi.pizzashopbackend.entity.Pizza;
import com.glomaksi.pizzashopbackend.service.pizza.PizzaService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping
    public List<PizzaSimpleResponseDto> getPizzas() {
        return pizzaService.getPizzas();
    }

    @GetMapping("{id}")
    public Pizza getPizzaById(@PathVariable Long id) {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping
    public SimpleResponse addPizza(@RequestBody PizzaRequestDto pizza) {
        System.out.println(pizza.getCategoriesId());
        pizzaService.addPizza(pizza);
        return new SimpleResponse("ok");
    }

    @PutMapping("{id}")
    public SimpleResponse updatePizza(@PathVariable Long id, @RequestBody PizzaRequestDto pizza) {
        pizzaService.updatePizza(id, pizza);
        return new SimpleResponse("ok");
    }

    @DeleteMapping("{id}")
    private SimpleResponse deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return new SimpleResponse("ok");
    }

}
