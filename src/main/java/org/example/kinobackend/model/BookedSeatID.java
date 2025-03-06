package org.example.kinobackend.model;

//seperat IDklasse til sammensat primærnøgle


import java.io.Serializable;
import java.util.Objects;


public class BookedSeatID implements Serializable {
    //implementering af Serializable gør det muligt at bruge nøglen som identifikator i Hibernate/JPA
    private Integer show;
    private Integer seat;

    public BookedSeatID() {
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {  //required for the composite key
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookedSeatID that = (BookedSeatID) o;
        return Objects.equals(show, that.show) && Objects.equals(seat, that.seat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(show, seat);
    }
}
