package org.example.kinobackend.dto;

import java.time.LocalDateTime;

public class BookedSeatDTO {

    private int seatID;
    private int seatRow;
    private int seatNumber;
    private String theaterName;
    private String movieName;
    private LocalDateTime startTime;
    private int reservationID;
    private int ticketID;


    public BookedSeatDTO(int seatID, int seatRow, int seatNumber, String theaterName, String movieName, int reservationID, int ticketID, LocalDateTime startTime) {
        this.seatID = seatID;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.reservationID = reservationID;
        this.ticketID = ticketID;
        this.startTime = startTime;
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

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
}
