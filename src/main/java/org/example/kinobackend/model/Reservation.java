package org.example.kinobackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationID;
    @OneToOne
    @JoinColumn(name = "customeridfk", referencedColumnName = "customerID", nullable = false)
    private Customer customer;
    private LocalDateTime reserved_at;
    private double totalPrice;


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

    public LocalDateTime getReserved_at() {
        return reserved_at;
    }

    public void setReserved_at(LocalDateTime reserved_at) {
        this.reserved_at = reserved_at;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
