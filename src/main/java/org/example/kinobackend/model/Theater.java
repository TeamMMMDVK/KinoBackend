package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterID;
    private String theaterName;
    private int totalAmountOfRows;
    private int seatsPerRow;
    /*nedenstående attribut er reelt ikke nødvendig (bliver ikke kolonne i tabellen), men gør
    det nemt at kalde alle sæder tilknyttet en sal. Vær dog obs, hvis vi arbejder med store
    mængder data!
    */
    @OneToMany(mappedBy = "theater")
    @JsonManagedReference //for at undgå problemer med cirkulær JSON-serialisering (parent)
    private List<Seat> seats = new ArrayList<>();
    @OneToOne(mappedBy = "theater")
    @JsonManagedReference
    private Show show;

    public Theater() {
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

    public int getTotalAmountOfRows() {
        return totalAmountOfRows;
    }

    public void setTotalAmountOfRows(int totalAmountOfRows) {
        this.totalAmountOfRows = totalAmountOfRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
