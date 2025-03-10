package org.example.kinobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    private String fullName;
    private String email;

    /*
    Nedenstående attribut bliver ikke en kolonne i tabellen, men fortæller at i
    Reservation klassen findes der en Customer attribut som FK.
    */
    @OneToOne(mappedBy = "customer")
    private Reservation reservation;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
