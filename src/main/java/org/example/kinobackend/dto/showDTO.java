package org.example.kinobackend.dto;

import org.example.kinobackend.model.Movie;
import org.example.kinobackend.model.Theater;

import java.time.LocalDateTime;

public class showDTO {
    private int showID;
    private String theaterName;
    private String movieName;
    private LocalDateTime startTime;

    public showDTO(int showID, String theaterName, String movieName, LocalDateTime startTime) {
        this.showID = showID;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.startTime = startTime;
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
