package com.glomaksi.pizzashopbackend.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

public class ImageUtils {
    private static final String[] extensions = new String[] {".jpg", ".png"};

    public static boolean isImage(String fileName) {
        return fileName != null && checkExtension(fileName);
    }

    private static boolean checkExtension(String fileName) {
        for (String extension : extensions) {
            if (fileName.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    public static String generateName(@NotNull String originalName) {
        String[] names = originalName.split("[.]");
        String extension = names[names.length - 1];
        Date date = new Date();
        return String.format("%d.%s", date.getTime(), extension);
    }

    public static byte[] getBytesForFile(MultipartFile multipartFile)  {
        try {
            return multipartFile.getBytes();
        } catch (IOException ex) {
            return new byte[0];
        }
    }

}
