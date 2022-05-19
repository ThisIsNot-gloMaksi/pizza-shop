package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.dto.user.UserRequestDto;
import com.glomaksi.pizzashopbackend.entity.User;
import com.glomaksi.pizzashopbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/admin/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/admin/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/admin/users")
    public User createAdmin(UserRequestDto userRequestDto) {
        return userService.createAdmin(userRequestDto.getUsername(), userRequestDto.getPassword());
    }

    @PostMapping("/users")
    public User createSimpleUser(UserRequestDto userRequestDto) {
        return userService.createSimpleUser(userRequestDto.getUsername(), userRequestDto.getPassword());
    }

    @DeleteMapping("/admin/users{id}")
    public SimpleResponse deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new SimpleResponse("ok");
    }

}
