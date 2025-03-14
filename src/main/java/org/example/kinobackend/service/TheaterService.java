package org.example.kinobackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.dto.SeatDTO;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.model.Theater;
import org.example.kinobackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    //Denne henter en liste fra DTO til visning
    public List<SeatDTO> getSeatsByTheaterId(int theaterID) {
        Optional<Theater> requestedTheater = theaterRepository.findById(theaterID);

        if (requestedTheater.isPresent()) { //Hvis salen eksisterer så henter vi en liste af sæder fra db
            List<Seat> seats = requestedTheater.get().getSeats();

            if(seats.isEmpty()) {
                throw new EntityNotFoundException("No seats found for Theater ID: " + theaterID);
            }
            //Listen laves om til DTOer til visning
            List<SeatDTO> seatDTOs = new ArrayList<>();
            for(Seat s:seats) {
                seatDTOs.add(new SeatDTO(s.getSeatID(), s.getSeatRow(), s.getSeatNumber(),s.isBlocked(),s.getTheater().getTheaterName() ));
            }
            return seatDTOs;

        } else {
            throw new EntityNotFoundException("Theater not found with ID: " + theaterID);
        }

    }
}
