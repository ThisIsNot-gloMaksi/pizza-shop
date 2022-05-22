package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.dto.user.UserRequestDto;
import com.glomaksi.pizzashopbackend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/v1")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public SimpleResponse login(@RequestBody UserRequestDto signInDto) {
        return new SimpleResponse(authService
                .createToken(signInDto.getUsername(),
                        signInDto.getPassword()));
    }

}
