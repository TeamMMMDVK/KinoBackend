package org.example.kinobackend.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;
    private String ticketType;
    private double price;
    @OneToMany(mappedBy = "ticket")
    private List<BookedSeat> bookedSeats = new ArrayList<>();

    public Ticket() {
    }

    public Ticket(BookedSeat bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}
