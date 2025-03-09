package org.example.kinobackend.service;

import org.example.kinobackend.model.Image;
import org.example.kinobackend.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    private ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public Optional<Image> findImageByID(int imageID) {
        return imageRepository.findById(imageID);
    }
    public Image postImage(Image image) {
        return imageRepository.save(image);
    }
    public void deleteImageByID(int imageID) {
        imageRepository.deleteById(imageID);
    }


}
