package com.glomaksi.pizzashopbackend.service.pizza;

import com.glomaksi.pizzashopbackend.entity.Category;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PizzaProperty {
    private final List<Ingredient> ingredients;
    private final List<Category> categories;
}
