package com.glomaksi.pizzashopbackend.controller;

import com.glomaksi.pizzashopbackend.dto.SimpleResponse;
import com.glomaksi.pizzashopbackend.entity.ImageFile;
import com.glomaksi.pizzashopbackend.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping
    public Iterable<ImageFile> getImages() {
        return imageService.getImages();
    }

    @GetMapping("{id}")
    public ImageFile getImage(@PathVariable Long id) {
        return imageService.getImageFile(id);
    }

    @PostMapping
    public ImageFile createImage(@RequestBody MultipartFile file)  {
       return imageService.createImage(file);
    }

    @DeleteMapping("{id}")
    public SimpleResponse deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return new SimpleResponse("ok");
    }


}
