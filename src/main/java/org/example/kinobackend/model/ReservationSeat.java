package org.example.kinobackend.model;

import jakarta.persistence.*;

@Entity
@IdClass(ReservationSeatID.class)
public class ReservationSeat {

    @Id
    @OneToOne
    @JoinColumn(name = "showidfk", referencedColumnName = "showID",nullable = false)
    private Show show;
    @Id@OneToOne
    @JoinColumn(name = "seatidfk", referencedColumnName = "seatID", nullable = false)
    private Seat seat;
    @Id
    @ManyToOne
    @JoinColumn(name = "reservationidfk", referencedColumnName = "reservationID", nullable = false)
    private Reservation reservation;
    @OneToOne
    @JoinColumn(name = "ticketidfk", referencedColumnName = "ticketID", nullable = false)
    private Ticket ticket;

    public ReservationSeat() {
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
