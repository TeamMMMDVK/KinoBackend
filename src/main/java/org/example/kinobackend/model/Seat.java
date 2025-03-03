package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;
    private int seatRow;
    private int seatNumber;
    @ManyToOne //mange sæder tilhører præcis en sal
    @JoinColumn(name = "theaterID", nullable = false)
    @JsonBackReference //for at undgå problemer med cirkulær JSON-serialisering i child
    private Theater theater;

    public Seat() {
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

    public void setSeatRow(int rowNumber) {
        this.seatRow = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
