package org.example.kinobackend.dto;

import java.time.LocalDateTime;
import java.util.List;

//Dette er DTO med data, som returneres som bekræftelse til kunden efter booking

public class ReservationDTO {

    private int reservationID;
    private String customerName;
    private String email;
    private LocalDateTime reserved_at;
    private double totalPrice;
    private List<BookedSeatDTO> bookedSeats;

    public ReservationDTO(int reservationID, String customerName, String email, LocalDateTime reserved_at, double totalPrice, List<BookedSeatDTO> bookedSeats) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.email = email;
        this.reserved_at = reserved_at;
        this.totalPrice = totalPrice;
        this.bookedSeats = bookedSeats;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<BookedSeatDTO> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeatDTO> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
