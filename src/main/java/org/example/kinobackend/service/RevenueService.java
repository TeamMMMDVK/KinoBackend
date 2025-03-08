package org.example.kinobackend.service;

import org.example.kinobackend.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RevenueService {

    private final MovieRepository movieRepository;

    public RevenueService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Double getRevenueForMovie(int movieID) {
        //Vi tjekker først om filmen eksisterer
        if (!movieRepository.existsById(movieID)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filmen med ID " + movieID + " blev ikke fundet.");
        }
        //vi henter omsætning på filmen. Hvis det er null, så returneres 0.0
        return movieRepository.getRevenueForMovie(movieID) != null ? movieRepository.getRevenueForMovie(movieID) : 0.0;
    }


}
