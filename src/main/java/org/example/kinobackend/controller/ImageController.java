package org.example.kinobackend.controller;

import org.example.kinobackend.model.Image;
import org.example.kinobackend.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{imageID}")
    public Image getImage(@PathVariable int imageID) {
        Optional<Image> imageToFind = imageService.findImageByID(imageID);
        if (imageToFind.isPresent()) {
            System.out.println(imageToFind.get().getName());
            return imageToFind.get();
        } else {
            Image noImage = new Image();
            noImage.setName("Image not found");
            return noImage;
        }
    }
    @PostMapping("/create-image")
    public ResponseEntity<Image> putImage(@RequestBody Image image) {
        Image imageSaved = imageService.postImage(image);
        if (imageSaved == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(imageSaved);
        }
    }
    @PutMapping("/{imageID}")
    public ResponseEntity<Image> updateImage(@PathVariable int imageID,
                                             @RequestBody Image updatedImage) {
        Optional<Image> orgImage = imageService.findImageByID(imageID);
        if (orgImage.isPresent()) {
            Image existingImage = orgImage.get();

            existingImage.setName(updatedImage.getName());
            existingImage.setImageID(updatedImage.getImageID());
            existingImage.setImage(updatedImage.getImage());
            existingImage.setSaved(updatedImage.getSaved());

            Image savedImage = imageService.postImage(existingImage);
            return ResponseEntity.ok(savedImage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/{imageID}")
    public ResponseEntity<String> deleteMovie(@PathVariable int imageID) {
        Optional<Image> orgImage = imageService.findImageByID(imageID);
        if (orgImage.isPresent()) {
            imageService.deleteImageByID(imageID);
            return ResponseEntity.ok("Image deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
        }
    }
}
