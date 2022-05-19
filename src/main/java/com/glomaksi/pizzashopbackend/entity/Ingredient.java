package com.glomaksi.pizzashopbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private long id;

    @Column(name = "ingredient_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    private List<Pizza> pizzas;

    @PreRemove
    public void removeIngredient() {
        pizzas.forEach(pizza -> pizza.getIngredients().remove(this));
    }

    public Ingredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
