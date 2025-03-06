package org.example.kinobackend.dto;

public class SeatDTO {


    private int seatID;
    private int seatRow;
    private int seatNumber;
    private boolean blocked;
    private String theaterName;


    public SeatDTO(int seatID, int seatRow, int seatNumber, boolean blocked, String theaterName) {
        this.seatID = seatID;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.blocked = blocked;
        this.theaterName = theaterName;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
