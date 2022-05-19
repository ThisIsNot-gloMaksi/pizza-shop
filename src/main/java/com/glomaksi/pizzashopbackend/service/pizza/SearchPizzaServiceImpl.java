package com.glomaksi.pizzashopbackend.service.pizza;

import com.glomaksi.pizzashopbackend.dto.pizza.PizzaRequestDto;
import com.glomaksi.pizzashopbackend.entity.Category;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import com.glomaksi.pizzashopbackend.service.category.CategoryService;
import com.glomaksi.pizzashopbackend.service.ingredient.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchPizzaServiceImpl implements SearchPizzaService {
    private final IngredientService ingredientService;
    private final CategoryService categoryService;
    @Override
    public PizzaProperty searchProperty(PizzaRequestDto pizza) {
        List<Ingredient> ingredients = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        for (Long id : pizza.getIngredientsId()) {
            ingredients.add(ingredientService.getIngredientById(id));
        }

        for (Long id : pizza.getCategoriesId()) {
            categories.add(categoryService.getCategoryById(id));
        }

        return new PizzaProperty(ingredients, categories);
    }
}
