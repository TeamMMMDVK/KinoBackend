package org.example.kinobackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.dto.SeatDTO;
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

    public Seat getSeatById(int seatId) {//Denne henter faktisk Seat-entitet (til opdatering)
        Optional<Seat> requestedSeat = seatRepository.findById(seatId);
        if(requestedSeat.isPresent()) {
            return requestedSeat.get();
        } else {
            throw new EntityNotFoundException("Seat not found with ID: "+seatId);
        }

    }

    public SeatDTO getSeatByIdDTO(int seatId) {//Denne henter data fra DTO (til visning)
           Optional<Seat> requestedSeat = seatRepository.findById(seatId);
           if(requestedSeat.isPresent()) {
               Seat s = requestedSeat.get();//Her har vi fat i Seat objektet fra db
               //Her gemmer vi data i dto som kan sendes til Controlleren
               return new SeatDTO(s.getSeatID(),s.getSeatRow(),s.getSeatNumber(),s.isBlocked(),s.getTheater().getTheaterName());
           } else {
               throw new EntityNotFoundException("Seat not found with ID: "+seatId);
           }

    }

    public Seat updateSeat(Seat updatedSeat) {
        return seatRepository.save(updatedSeat);

    }


}
