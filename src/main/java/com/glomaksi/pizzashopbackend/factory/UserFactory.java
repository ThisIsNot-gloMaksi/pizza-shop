package com.glomaksi.pizzashopbackend.factory;

import com.glomaksi.pizzashopbackend.entity.Role;
import com.glomaksi.pizzashopbackend.entity.RoleConstant;
import com.glomaksi.pizzashopbackend.entity.User;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserFactory implements Factory<User> {
    @Override
    public User createItem(String username, String password) {
        return new User(Set.of(
                new Role(RoleConstant.SIMPLE_USER)
        ), username, password);
    }
}
