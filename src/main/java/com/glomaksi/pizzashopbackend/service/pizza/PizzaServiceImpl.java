package com.glomaksi.pizzashopbackend.service.pizza;

import com.glomaksi.pizzashopbackend.dto.pizza.PizzaRequestDto;
import com.glomaksi.pizzashopbackend.dto.pizza.PizzaSimpleResponseDto;
import com.glomaksi.pizzashopbackend.entity.Category;
import com.glomaksi.pizzashopbackend.entity.Ingredient;
import com.glomaksi.pizzashopbackend.entity.Pizza;
import com.glomaksi.pizzashopbackend.exception.alreadyexist.PizzaAlreadyExistException;
import com.glomaksi.pizzashopbackend.exception.notfound.PizzaNotFoundException;
import com.glomaksi.pizzashopbackend.repository.PizzaRepository;
import com.glomaksi.pizzashopbackend.service.category.CategoryService;
import com.glomaksi.pizzashopbackend.service.ingredient.IngredientService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepository;
    private final SearchPizzaService searchPizzaService;

    @Override
    public List<PizzaSimpleResponseDto> getPizzas() {
        Iterable<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaSimpleResponseDto> response = new ArrayList<>();
        pizzas.forEach(pizza -> response.add(new PizzaSimpleResponseDto(pizza)));
        return response;
    }

    @Override
    @Transactional
    public Pizza getPizzaById(Long id) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (pizzaOptional.isPresent()) {
            Pizza pizza = pizzaOptional.get();
            Hibernate.initialize(pizza.getSizes());
            Hibernate.initialize(pizza.getIngredients());
            Hibernate.initialize(pizza.getCategories());
            return pizza;
        }
        throw PizzaNotFoundException.createForId(id);
    }

    @Override
    public void addPizza(PizzaRequestDto pizza) {
        String namePizza = pizza.getName();
        Optional<Pizza> optionalPizza = pizzaRepository.getPizzaByName(namePizza);
        if (optionalPizza.isEmpty()) {
            PizzaProperty pizzaProperty = searchPizzaService.searchProperty(pizza);
            pizzaRepository.save(new Pizza(pizza.getName(),
                    pizzaProperty.getIngredients(),
                    pizzaProperty.getCategories(),
                    pizza.getSizes()));
        } else {
            throw PizzaAlreadyExistException.createForName(namePizza);
        }


    }

    @Override
    public void updatePizza(Long id, PizzaRequestDto pizza) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (pizzaOptional.isPresent()) {
            PizzaProperty pizzaProperty = searchPizzaService.searchProperty(pizza);
            Pizza pizzaFromRepository = pizzaOptional.get();
            Pizza newPizza = new Pizza(pizza.getName(),
                    pizzaProperty.getIngredients(),
                    pizzaProperty.getCategories(),
                    pizza.getSizes());
            newPizza.setId(pizzaFromRepository.getId());
            pizzaRepository.save(newPizza);
        } else {
            throw PizzaNotFoundException.createForId(id);
        }

    }

    @Override
    public void deletePizza(Long id) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(id);
        if (optionalPizza.isPresent()) {
            pizzaRepository.deleteById(id);
        } else {
            throw PizzaNotFoundException.createForId(id);
        }
    }
}

