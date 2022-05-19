package com.glomaksi.pizzashopbackend.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequestDto {
    private final String username;
    private final String password;
}
