package com.glomaksi.pizzashopbackend.service.auth;

public interface AuthService {
    String createToken(String name, String password);
}
