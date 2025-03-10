package org.example.kinobackend.dto;

import java.time.LocalDateTime;

public class ShowTimesDTO {

    private int showID;
    private LocalDateTime startTime;

    public ShowTimesDTO(int showID, LocalDateTime startTime) {
        this.showID = showID;
        this.startTime = startTime;
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
}
