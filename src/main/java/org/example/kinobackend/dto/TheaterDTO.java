package org.example.kinobackend.dto;

import org.example.kinobackend.model.Seat;
import org.example.kinobackend.model.Show;

import java.util.List;

public class TheaterDTO {

    private int theaterID;
    private String theaterName;
    private List<Seat> seats;
    private List<Show> shows;

    public TheaterDTO(int theaterID, String theaterName) {
        this.theaterID = theaterID;
        this.theaterName = theaterName;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
