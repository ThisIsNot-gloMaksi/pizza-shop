package com.glomaksi.pizzashopbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id", nullable = false)
    private long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
