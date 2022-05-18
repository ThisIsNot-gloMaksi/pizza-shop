package com.glomaksi.pizzashopbackend.adapter.image;

import com.uploadcare.api.Client;
import com.uploadcare.api.File;
import com.uploadcare.upload.FileUploader;
import com.uploadcare.upload.UploadFailureException;
import com.uploadcare.upload.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApiImageAdapter implements  ImageAdapter {
    @Value("#{environment.IMAGE_API_URL}")
    private String url;
    private final Client client;

    @Autowired
    public ApiImageAdapter(Client client) {
        this.client = client;
    }

    @Override
    public Optional<String> uploadFile(byte[] bytes, String name) {
        Uploader uploader = new FileUploader(client, bytes, name);
        try {
            File file = uploader.upload().save();
            return Optional.of(url + file.getFileId() + "/");
        } catch (UploadFailureException e) {
            return Optional.empty();
        }

    }

    @Override
    public void deleteFile(String url) {
        String[] parts = url.split("/");
        String uid = parts[parts.length - 1];
        client.deleteFile(uid);
    }
}
