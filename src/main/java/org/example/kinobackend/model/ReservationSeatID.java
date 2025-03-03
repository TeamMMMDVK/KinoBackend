package org.example.kinobackend.model;

import java.io.Serializable;

public class ReservationSeatID implements Serializable {
    //implementering af Serializable gør det muligt at bruge nøglen som identifikator
    private int show;
    private int seat;
    private int reservation;

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }
}
