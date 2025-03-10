package org.example.kinobackend.dto;

import java.util.List;


//initial reservation creation
public class ReservationDTO {

    private String customerName;
    private String customerEmail;
    private int showID;
    private List<Integer> seatsIDs;
    private List<Integer> ticketIDs;

    public ReservationDTO() {
    }

    public ReservationDTO(String customerName, String customerEmail, int showID,
                          List<Integer> seatsIDs, List<Integer> ticketIDs) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.showID = showID;
        this.seatsIDs = seatsIDs;
        this.ticketIDs = ticketIDs;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public List<Integer> getTicketIDs() {
        return ticketIDs;
    }

    public void setTicketIDs(List<Integer> ticketIDs) {
        this.ticketIDs = ticketIDs;
    }

    public List<Integer> getSeatsIDs() {
        return seatsIDs;
    }

    public void setSeatsIDs(List<Integer> seatsIDs) {
        this.seatsIDs = seatsIDs;
    }
}
