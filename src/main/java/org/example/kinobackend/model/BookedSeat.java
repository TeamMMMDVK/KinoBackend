package org.example.kinobackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@IdClass(BookedSeatID.class)
public class BookedSeat {

    @Id
    @ManyToOne //en forestilling kan have mange bookede sæder
    @JoinColumn(name = "showidfk", referencedColumnName = "showID", nullable = false)
    private Show show;
    @Id
    @ManyToOne //et sæde kan være booket flere gange til forskellige forestillinger
    @JoinColumn(name = "seatidfk", referencedColumnName = "seatID",nullable = false)
    private Seat seat;
    @Enumerated(EnumType.STRING) // Gemmer enum som en STRING i databasen
    private Status status;
    @ManyToOne
    @JoinColumn(name = "ticketidfk", referencedColumnName = "ticketID")
    private Ticket ticket;
    @ManyToOne // en reservation kan have flere forskellige bookede sæder
    @JoinColumn(name = "reservationidfk", referencedColumnName = "reservationID")
    private Reservation reservation;
    private double price;

    public BookedSeat() {
    }

    public BookedSeat(Show show, Seat seat, Status status) {
        this.show = show;
        this.seat = seat;
        this.status = status;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
