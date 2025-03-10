package org.example.kinobackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;
    @OneToOne   //maybe OneToMany? one customer can have multiple reservations
    @JoinColumn(name = "customeridfk", referencedColumnName = "customerID", nullable = false)
    private Customer customer;
    private LocalDateTime reservedAt;
    @OneToMany
    private List<BookedSeat> bookedSeats;


    public Reservation() {
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public List<BookedSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
