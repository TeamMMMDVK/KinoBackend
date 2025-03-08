package org.example.kinobackend.service;

import org.example.kinobackend.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    private final MovieRepository movieRepository;

    public RevenueService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Double getRevenueForMovie(int movieID) {
        return movieRepository.getRevenueForMovie(movieID);
    }




}
