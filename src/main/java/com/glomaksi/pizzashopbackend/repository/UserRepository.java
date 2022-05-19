package com.glomaksi.pizzashopbackend.repository;

import com.glomaksi.pizzashopbackend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
}