package com.glomaksi.pizzashopbackend.service.ingredient;

import com.glomaksi.pizzashopbackend.dto.ingredient.IngredientRequestDto;
import com.glomaksi.pizzashopbackend.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Ingredient getIngredientById(Long id);
    Ingredient addIngredient(IngredientRequestDto ingredient);
    void deleteIngredient(Long id);
    Ingredient updateIngredient(Long id, IngredientRequestDto ingredient);
}
