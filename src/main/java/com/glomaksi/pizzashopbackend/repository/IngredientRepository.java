package com.glomaksi.pizzashopbackend.repository;

import com.glomaksi.pizzashopbackend.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Optional<Ingredient> getIngredientByName(String name);
}
