package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "showTable")//vi giver tabellen et andet navn, da show er et reserveret ord i MySQL!
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showID;
    @ManyToOne
    @JoinColumn(name = "theateridfk", referencedColumnName = "theaterID", nullable = false)
    private Theater theater;
    @ManyToOne
    @JoinColumn(name = "movieidfk", referencedColumnName = "movieID", nullable = false)
    private Movie movie;
    private LocalDateTime startTime;

    /*
    Nedenstående attribut er ikke nødvendig da relationen allerede
    eksisterer i BookedSeat via FK, men dette gør det nemmere at fremsøge data,
    da vi kan hente alle bookede sæder til en given forestilling uden at
    lave en separat query.
     */
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL, orphanRemoval = true) // hvis vi sletter et show
    //så bliver alle de tilknyttede bookede sæder også slettet
    private List<BookedSeat> bookedSeats = new ArrayList<>();

    public Show() {
    }

    public Show(Movie movie, Theater theater) {
        this.movie = movie;
        this.theater = theater;
    }

    public Integer getShowID() {
        return showID;
    }

    public void setShowID(Integer showID) {
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

    public List<BookedSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
