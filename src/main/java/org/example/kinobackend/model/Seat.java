package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatID;
    private int seatRow;
    private int seatNumber;

    @ManyToOne //mange sæder tilhører præcis en sal
    @JoinColumn(name = "theateridfk", referencedColumnName = "theaterID", nullable = false)
    private Theater theater;

    @Column(nullable = false)
    private boolean blocked = false; //Default er sæderne ikke blokeret, men dette kan ændres til true ifm fx renovering

    public Seat() {
    }

    public Seat(Theater theater) {
        this.theater = theater;
    }


    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
