package org.example.kinobackend.model;

//seperat IDklasse til sammensat primærnøgle


import java.io.Serializable;


public class ShowSeatID implements Serializable {
    //implementering af Serializable gør det muligt at bruge nøglen som identifikator i Hibernate/JPA
    private int show;
    private int seat;

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
}
