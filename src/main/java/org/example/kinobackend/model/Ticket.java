package org.example.kinobackend.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;
    private String ticketType;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "showidfk", referencedColumnName = "showidfk"),
            @JoinColumn(name = "seatidfk", referencedColumnName = "seatidfk")
    })
    private BookedSeat bookedSeat;

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

    public BookedSeat getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(BookedSeat bookedSeat) {
        this.bookedSeat = bookedSeat;
    }
}
