package com.glomaksi.pizzashopbackend.adapter.image;

import java.util.Optional;

public interface ImageAdapter {
    Optional<String> uploadFile(byte[] bytes, String name);
    void deleteFile(String url);

}
