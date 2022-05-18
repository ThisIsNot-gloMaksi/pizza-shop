package com.glomaksi.pizzashopbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@Data
public class Ingredient {
    @Id
    @GeneratedValue
    @Column(name = "ingredient_id", nullable = false)
    private long id;

    @Column(name = "name_ingredient", nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    public Ingredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
