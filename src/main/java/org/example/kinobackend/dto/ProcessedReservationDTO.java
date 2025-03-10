package org.example.kinobackend.dto;

import java.util.List;

//Dette er DTO med data, som returneres som bekræftelse til kunden efter booking
public class ProcessedReservationDTO { //for showing the confirmation on the frontend

    private int reservationID;
    private String customerEmail;
    private double totalPrice;
    private List<BookedSeatDTO> bookedSeats;

    public ProcessedReservationDTO(int reservationID, String customerEmail, double totalPrice) {
        this.reservationID = reservationID;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<BookedSeatDTO> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<BookedSeatDTO> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
