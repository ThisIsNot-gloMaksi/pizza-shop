package com.glomaksi.pizzashopbackend.repository;

import com.glomaksi.pizzashopbackend.entity.ImageFile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageFile, Long> {
    Optional<ImageFile> getImageFileById(Long id);
}
