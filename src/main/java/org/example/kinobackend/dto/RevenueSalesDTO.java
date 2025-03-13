package org.example.kinobackend.dto;

public class RevenueSalesDTO {

    private int movieID;
    private String movieTitle;
    private double revenue;
    private int soldTickets;

    public RevenueSalesDTO() {
    }

    public RevenueSalesDTO(int movieID, String movieTitle, double revenue, int soldTickets) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.revenue = revenue;
        this.soldTickets = soldTickets;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(int soldTickets) {
        this.soldTickets = soldTickets;
    }
}
