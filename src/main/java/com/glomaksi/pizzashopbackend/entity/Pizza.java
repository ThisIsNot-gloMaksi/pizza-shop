package com.glomaksi.pizzashopbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "pizza")
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id", nullable = false)
    private Long id;

    @Column(name = "pizza_name", nullable = false)
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients = new ArrayList<>();

    @ElementCollection
    private List<Integer> sizes = new ArrayList<>();

    public Pizza(String name, List<Ingredient> ingredients, List<Category> categories, List<Integer> sizes) {
        this.name = name;
        this.ingredients = ingredients;
        this.categories = categories;
        this.sizes = sizes;
    }

}
