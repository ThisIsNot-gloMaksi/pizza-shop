package com.glomaksi.pizzashopbackend.dto.category;

import com.glomaksi.pizzashopbackend.dto.RequestDto;
import com.glomaksi.pizzashopbackend.entity.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CategoryRequestDto implements RequestDto<Category> {
    private final String name;
    private final String description;

    @Override
    public Category getData() {
        return new Category(name, description);
    }
}
