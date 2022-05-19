package com.glomaksi.pizzashopbackend.dto.pizza;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PizzaRequestDto {
    private final String name;
    private final List<Long> ingredientsId;
    private final List<Long> categoriesId;
    private final List<Integer> sizes;

}
