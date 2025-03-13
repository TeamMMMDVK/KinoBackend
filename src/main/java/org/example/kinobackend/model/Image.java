package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;
    private String name;
    @Lob
    private String image; //Image gemmes og transporteres som 64bit Streng eller noget i den stil...
    private LocalDate saved;

    public Image() {
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getSaved() {
        return saved;
    }

    public void setSaved(LocalDate saved) {
        this.saved = saved;
    }
}
