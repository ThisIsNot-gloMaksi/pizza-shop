package com.glomaksi.pizzashopbackend.service.image;

import com.glomaksi.pizzashopbackend.adapter.image.ImageAdapter;
import com.glomaksi.pizzashopbackend.entity.ImageFile;
import com.glomaksi.pizzashopbackend.exception.ApiException;
import com.glomaksi.pizzashopbackend.exception.notfound.ImageNotFoundException;
import com.glomaksi.pizzashopbackend.exception.UnsupportedMediaType;
import com.glomaksi.pizzashopbackend.repository.ImageRepository;
import com.glomaksi.pizzashopbackend.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageAdapter imageAdapter;

    @Override
    public Iterable<ImageFile> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public ImageFile getImageFile(Long id) {
        Optional<ImageFile> optionalImageFile = imageRepository.getImageFileById(id);
        return optionalImageFile.orElseThrow(
                () -> {
                    throw ImageNotFoundException.createForId(id);
                }
        );
    }

    @Override
    public ImageFile createImage(MultipartFile multipartFile) {
        if (ImageUtils.isImage(multipartFile.getOriginalFilename())) {
            String name = ImageUtils.generateName(multipartFile.getOriginalFilename());
            Optional<String> urlOptional = imageAdapter.uploadFile(ImageUtils.getBytesForFile(multipartFile), name);
            if (urlOptional.isPresent()) {
                ImageFile imageFile = new ImageFile(urlOptional.get());
                imageRepository.save(imageFile);
                return imageFile;
            } else {
                throw new ApiException();
            }
        } else {
            throw new UnsupportedMediaType();
        }
    }

    @Override
    public void deleteImage(Long id) {
        Optional<ImageFile> imageFileOptional = imageRepository.getImageFileById(id);
        if (imageFileOptional.isPresent()) {
            ImageFile file = imageFileOptional.get();
            imageAdapter.deleteFile(file.getUrl());
            imageRepository.delete(file);
        } else {
            throw ImageNotFoundException.createForId(id);
        }
    }
}
