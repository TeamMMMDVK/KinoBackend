package org.example.kinobackend.dto;

import org.example.kinobackend.model.Show;
import org.example.kinobackend.model.Status;

import java.time.LocalDateTime;

public class BookedSeatDTO {

    private int seatID;
    private int seatRow;
    private int seatNumber;
    private String theaterName;
    private String movieName;
    private LocalDateTime startTime;
    private Integer reservationID; //ændret fra int til Integer, da kan være null
    private Integer ticketID; //ændret fra int til Integer, da kan være null
    private Status status;

    public BookedSeatDTO(int seatID, int seatRow, int seatNumber, String theaterName, String movieName, Integer reservationID, Integer ticketID, Status status, LocalDateTime startTime) {
        this.seatID = seatID;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.reservationID = reservationID;
        this.ticketID = ticketID;
        this.status = status;
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

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
