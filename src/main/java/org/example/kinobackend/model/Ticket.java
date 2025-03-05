package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    private String ticketType;
    private double price;

    @OneToMany(mappedBy = "ticket")
    @JsonBackReference
    private List<BookedSeat> bookedSeats = new ArrayList<>();

    public Ticket() {
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<BookedSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
