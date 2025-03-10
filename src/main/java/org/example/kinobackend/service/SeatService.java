package org.example.kinobackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.dto.SeatDTO;
import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat getSeatById(int seatId) {//Denne henter faktisk Seat-entitet (til opdatering)
        Optional<Seat> requestedSeat = seatRepository.findById(seatId);
        if(requestedSeat.isPresent()) {
            return requestedSeat.get();
        } else {
            throw new EntityNotFoundException("Seat not found with ID: "+seatId);
        }
    }

    public SeatDTO getSeatByIdDTO(int seatId) {
           Seat s = getSeatById(seatId);
           return new SeatDTO(s.getSeatID(),s.getSeatRow(),
                   s.getSeatNumber(),s.isBlocked(),s.getTheater().getTheaterName());
    }

    public Seat updateSeat(Seat updatedSeat) {
        return seatRepository.save(updatedSeat);
    }
}
