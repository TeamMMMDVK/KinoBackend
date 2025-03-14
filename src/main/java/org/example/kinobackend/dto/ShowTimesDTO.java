package org.example.kinobackend.dto;

import java.time.LocalDateTime;

public class ShowTimesDTO {

    private int showID;
    private LocalDateTime startTime;
    private int theaterID;

    public ShowTimesDTO(int showID, LocalDateTime startTime, int theaterID) {
        this.showID = showID;
        this.startTime = startTime;
        this.theaterID = theaterID;
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }
}
