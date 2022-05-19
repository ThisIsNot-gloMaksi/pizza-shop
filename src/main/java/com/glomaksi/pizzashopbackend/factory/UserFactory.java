package com.glomaksi.pizzashopbackend.factory;

import com.glomaksi.pizzashopbackend.entity.Cart;
import com.glomaksi.pizzashopbackend.entity.Role;
import com.glomaksi.pizzashopbackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory implements Factory<User> {
    @Override
    public User createItem(String username, String password) {
        return new User(Role.SIMPLE_USER, username, password, new Cart());
    }
}
