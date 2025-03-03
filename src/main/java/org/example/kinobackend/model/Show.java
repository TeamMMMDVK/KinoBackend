package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "showTable")//vi giver tabellen et andet navn, da show er et reserveret ord!
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showID;
    @OneToOne
    @JoinColumn(name = "theateridfk", referencedColumnName = "theaterID", nullable = false)
    @JsonBackReference //for at undgå problemer med cirkulær JSON-serialisering (child)
    private Theater theater;
    @OneToOne
    @JoinColumn(name = "movieidfk", referencedColumnName = "movieID", nullable = false)
    @JsonBackReference //for at undgå problemer med cirkulær JSON-serialisering (child)
    private Movie movie;
    private LocalDateTime startTime;

    public Show() {
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
