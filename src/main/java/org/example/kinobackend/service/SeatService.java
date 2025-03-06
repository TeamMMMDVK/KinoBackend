package org.example.kinobackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat getSeatById(int seatId) {
           Optional<Seat> requestedSeat = seatRepository.findById(seatId);
           if(requestedSeat.isPresent()) {
               return requestedSeat.get();
           } else {
               throw new EntityNotFoundException("Seat not found with ID: "+seatId);
           }

    }

    public Seat updateSeat(Seat updatedSeat) {
        return seatRepository.save(updatedSeat);

    }


}
