package com.glomaksi.pizzashopbackend.service.category;

import com.glomaksi.pizzashopbackend.dto.category.CategoryRequestDto;
import com.glomaksi.pizzashopbackend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long id);
    Category addCategory(CategoryRequestDto category);
    Category updateCategory(Long id, CategoryRequestDto category);
    void deleteCategory(Long id);
}
