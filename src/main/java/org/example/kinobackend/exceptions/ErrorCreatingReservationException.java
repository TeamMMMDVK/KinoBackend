package org.example.kinobackend.exceptions;

public class ErrorCreatingReservationException extends RuntimeException{
    public ErrorCreatingReservationException(String message) {
        super(message);
    }
}
