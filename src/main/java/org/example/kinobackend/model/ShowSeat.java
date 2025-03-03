package org.example.kinobackend.model;


import jakarta.persistence.*;

@Entity
@IdClass(ShowSeatID.class)
public class ShowSeat {

    @Id
    @ManyToOne
    @JoinColumn(name = "showidfk", referencedColumnName = "showID", nullable = false)
    private Show show;
    @Id
    @ManyToOne
    @JoinColumn(name = "seatidfk", referencedColumnName = "seatID",nullable = false)
    private Seat seat;
    @Enumerated(EnumType.STRING) // Gemmer enum som en STRING i databasen
    private Status status;

    public ShowSeat() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
