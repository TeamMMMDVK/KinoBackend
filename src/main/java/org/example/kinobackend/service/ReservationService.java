package org.example.kinobackend.service;

import org.example.kinobackend.model.Reservation;
import org.example.kinobackend.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> getReservations(int showId) {
        return reservationRepository.findById(showId);
    }

}
