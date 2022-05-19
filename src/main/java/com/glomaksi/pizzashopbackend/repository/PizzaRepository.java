package com.glomaksi.pizzashopbackend.repository;

import com.glomaksi.pizzashopbackend.entity.Pizza;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import java.util.Optional;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    Optional<Pizza> getPizzaByName(String name);
}
