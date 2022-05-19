package com.glomaksi.pizzashopbackend.factory;

public interface Factory<T> {
    T createItem(String username, String password);
}
