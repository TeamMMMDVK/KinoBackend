package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieID;
    private String title;
    private double durationMin;
    private String description;
    private String trailerLink;
    private String reviewLink;
    @Enumerated(EnumType.STRING) // Gemmer enum som en STRING i databasen
    private Genre genre;
    @Enumerated(EnumType.STRING) // Gemmer enum som en STRING i databasen
    private AgeRestriction ageRestriction;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageidfk", referencedColumnName = "imageID")
    private Image image;
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
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

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
