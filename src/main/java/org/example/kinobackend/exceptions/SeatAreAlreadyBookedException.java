package org.example.kinobackend.exceptions;

public class SeatAreAlreadyBookedException extends RuntimeException{
    public SeatAreAlreadyBookedException(String message) {
        super(message);
    }
}
