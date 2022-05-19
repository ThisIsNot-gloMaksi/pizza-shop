package com.glomaksi.pizzashopbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Pizza> pizzas = new ArrayList<>();

    @Column(nullable = false)
    private Date date;

    public Cart(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        date = new Date();
    }
}
