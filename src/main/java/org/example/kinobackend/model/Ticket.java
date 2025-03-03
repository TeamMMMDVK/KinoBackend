package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;
    private String ticketType;
    private double price;

    @OneToOne(mappedBy = "ticket")
    @JsonBackReference
    private ReservationSeat reservationSeat;

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

    public ReservationSeat getReservationSeat() {
        return reservationSeat;
    }

    public void setReservationSeat(ReservationSeat reservationSeat) {
        this.reservationSeat = reservationSeat;
    }
}
