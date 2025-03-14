package org.example.kinobackend.dto;

import org.example.kinobackend.model.AgeRestriction;
import org.example.kinobackend.model.Genre;
import org.example.kinobackend.model.Image;

public class MovieDTO {

    private int movieID;
    private String title;
    private double durationMin;
    private String description;
    private String trailerLink;
    private String reviewLink;
    private Genre genre;
    private AgeRestriction ageRestriction;
    private Image image;

    public MovieDTO(int movieID, String title, double durationMin, String description, String trailerLink, String reviewLink, Genre genre, AgeRestriction ageRestriction, Image image) {
        this.movieID = movieID;
        this.title = title;
        this.durationMin = durationMin;
        this.description = description;
        this.trailerLink = trailerLink;
        this.reviewLink = reviewLink;
        this.genre = genre;
        this.ageRestriction = ageRestriction;
        this.image = image;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(double durationMin) {
        this.durationMin = durationMin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getReviewLink() {
        return reviewLink;
    }

    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
