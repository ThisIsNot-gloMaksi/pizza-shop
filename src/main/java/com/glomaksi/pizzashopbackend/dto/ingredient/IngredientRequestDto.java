package com.glomaksi.pizzashopbackend.dto.ingredient;

import com.glomaksi.pizzashopbackend.dto.RequestDto;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class IngredientRequestDto implements RequestDto<Ingredient> {
    private final String name;
    private final BigDecimal price;

    @Override
    public Ingredient getData() {
        return new Ingredient(name, price);
    }
}
