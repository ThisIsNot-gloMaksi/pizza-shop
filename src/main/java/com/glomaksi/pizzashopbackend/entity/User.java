package com.glomaksi.pizzashopbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private Cart cart;


    public User(Role role, String username, String password, Cart cart) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }
}
