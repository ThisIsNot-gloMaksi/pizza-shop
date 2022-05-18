package com.glomaksi.pizzashopbackend.repository;

import com.glomaksi.pizzashopbackend.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> getCategoryByName(String name);
}
