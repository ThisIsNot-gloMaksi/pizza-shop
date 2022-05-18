package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.dto.category.CategoryRequestDto;
import com.glomaksi.pizzashopbackend.entity.Category;
import com.glomaksi.pizzashopbackend.repository.CategoryRepository;
import com.glomaksi.pizzashopbackend.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryRequestDto category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("{id}")
    public Category updateCategoryById(@PathVariable Long id, @RequestBody  CategoryRequestDto category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("{id}")
    public SimpleResponse deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new SimpleResponse("ok");
    }
}
