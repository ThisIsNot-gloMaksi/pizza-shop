package com.glomaksi.pizzashopbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Pizza> pizzas = new ArrayList<>();
    
    @PreRemove
    public void removeCategory() {
        pizzas.forEach(position -> position.getCategories().remove(this));
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
