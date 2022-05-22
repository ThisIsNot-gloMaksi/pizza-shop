package com.glomaksi.pizzashopbackend.service.auth;

import com.glomaksi.pizzashopbackend.entity.User;
import com.glomaksi.pizzashopbackend.exception.IncorrectPasswordException;
import com.glomaksi.pizzashopbackend.exception.notfound.UserNotFoundException;
import com.glomaksi.pizzashopbackend.service.user.UserService;
import com.glomaksi.pizzashopbackend.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Value("#{environment.JWT_SECRET_KEY}")
    private String secret;
    @Value("#{environment.VALIDATE_IN_MILLISECONDS}")
    private Long validityInMilliseconds;
    private final UserService userService;

    @Override
    public String createToken(String name, String password) {
        User user = userService.getUserByName(name);
        if (user.getPassword().equals(password)) {
            return JwtUtils.createToken(user.getUsername(), secret, validityInMilliseconds);
        }
        throw new IncorrectPasswordException();
    }
}
