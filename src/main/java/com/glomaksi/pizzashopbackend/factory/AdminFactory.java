package com.glomaksi.pizzashopbackend.factory;

import com.glomaksi.pizzashopbackend.entity.Cart;
import com.glomaksi.pizzashopbackend.entity.Role;
import com.glomaksi.pizzashopbackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AdminFactory implements Factory<User> {
    @Override
    public User createItem(String username, String password) {
        return new User(Role.ADMIN, username, password, new Cart());
    }
}
