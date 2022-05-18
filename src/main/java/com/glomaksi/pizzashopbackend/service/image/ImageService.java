package com.glomaksi.pizzashopbackend.service.image;

import com.glomaksi.pizzashopbackend.entity.ImageFile;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Iterable<ImageFile> getImages();
    ImageFile getImageFile(Long id);
    ImageFile createImage(MultipartFile file);
    void deleteImage(Long id);
}
