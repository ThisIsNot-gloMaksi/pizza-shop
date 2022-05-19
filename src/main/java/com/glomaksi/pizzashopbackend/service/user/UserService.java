package com.glomaksi.pizzashopbackend.service.user;

import com.glomaksi.pizzashopbackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    User createSimpleUser(String username, String password);
    User createAdmin(String username, String password);
    void deleteUser(Long id);
}
