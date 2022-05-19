package com.glomaksi.pizzashopbackend.service.category;

import com.glomaksi.pizzashopbackend.dto.category.CategoryRequestDto;
import com.glomaksi.pizzashopbackend.entity.Category;
import com.glomaksi.pizzashopbackend.entity.Pizza;
import com.glomaksi.pizzashopbackend.exception.alreadyexist.CategoryAlreadyExistException;
import com.glomaksi.pizzashopbackend.exception.notfound.CategoryNotFoundException;
import com.glomaksi.pizzashopbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> {
                    throw CategoryNotFoundException.createForId(id);
                });
    }

    @Override
    public Category addCategory(CategoryRequestDto category) {
        Optional<Category> categoryOptional = categoryRepository.getCategoryByName(category.getName());
        if (categoryOptional.isEmpty()) {
            return categoryRepository.save(category.getData());
        }
        throw CategoryAlreadyExistException.createForName(category.getName());
    }

    @Override
    public Category updateCategory(Long id, CategoryRequestDto category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category categoryFromRequest = category.getData();
            categoryFromRequest.setId(id);
            return categoryRepository.save(categoryFromRequest);
        }
        throw CategoryNotFoundException.createForId(id);
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
        } else {
            throw CategoryNotFoundException.createForId(id);
        }
    }
}
