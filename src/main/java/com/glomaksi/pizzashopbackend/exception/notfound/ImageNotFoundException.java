package com.glomaksi.pizzashopbackend.exception.notfound;

public class ImageNotFoundException extends ItemNotFoundException {
    public ImageNotFoundException(String message) {
        super(message);
    }

    public static ImageNotFoundException createForId(Long id) {
        return new ImageNotFoundException(String.format("not found image with id=%d", id));
    }
}
