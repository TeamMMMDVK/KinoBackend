package org.example.kinobackend.service;

import org.example.kinobackend.model.Theater;
import org.example.kinobackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;
    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Optional<Theater> getTheater(int theaterId) {
       return theaterRepository.findById(theaterId);
    }
}
