package com.glomaksi.pizzashopbackend.service.ingredient;

import com.glomaksi.pizzashopbackend.dto.ingredient.IngredientRequestDto;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import com.glomaksi.pizzashopbackend.exception.alreadyexist.IngredientAlreadyExistException;
import com.glomaksi.pizzashopbackend.exception.notfound.IngredientNotFoundException;
import com.glomaksi.pizzashopbackend.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getIngredients() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(
                () -> {
                    throw IngredientNotFoundException.createForId(id);
                }
        );
    }

    @Override
    public Ingredient addIngredient(IngredientRequestDto ingredient) {
        Optional<Ingredient> ingredientOptional = ingredientRepository
                .getIngredientByName(ingredient.getName());
        if (ingredientOptional.isEmpty()) {
            return ingredientRepository.save(ingredient.getData());
        }
        throw IngredientAlreadyExistException.createForName(ingredient.getName());
    }


    @Override
    public Ingredient updateIngredient(Long id, IngredientRequestDto ingredient) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isPresent()) {
            Ingredient ingredientFromRequest = ingredient.getData();
            ingredientFromRequest.setId(id);
            return ingredientRepository.save(ingredientFromRequest);
        }
        throw IngredientNotFoundException.createForId(id);
    }

    @Override
    public void deleteIngredient(Long id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
        if (ingredientOptional.isPresent()) {
            Ingredient ingredient = ingredientOptional.get();
            ingredientRepository.delete(ingredient);
        } else {
            throw IngredientNotFoundException.createForId(id);
        }
    }
}
