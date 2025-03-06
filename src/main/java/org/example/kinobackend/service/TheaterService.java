package org.example.kinobackend.service;

import org.example.kinobackend.model.Seat;
import org.example.kinobackend.model.Theater;
import org.example.kinobackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<Seat> getSeatsByTheaterId(int theaterID) {
        Optional<Theater> optTheater = theaterRepository.findById(theaterID);
        if (optTheater.isPresent()) {
            return optTheater.get().getSeats();
        } else {
            return Collections.emptyList();
        }

    }
}
