package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.dto.ingredient.IngredientRequestDto;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import com.glomaksi.pizzashopbackend.service.ingredient.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;
    @GetMapping
    public List<Ingredient> getIngredients() {
        return ingredientService.getIngredients();
    }

    @GetMapping("{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody IngredientRequestDto ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @PutMapping("{id}")
    public Ingredient updateIngredient(@RequestBody IngredientRequestDto ingredient, @PathVariable Long id) {
        return ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("{id}")
    public SimpleResponse deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return new SimpleResponse("ok");
    }

}
