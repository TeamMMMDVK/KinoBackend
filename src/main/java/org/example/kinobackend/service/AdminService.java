package org.example.kinobackend.service;

import org.example.kinobackend.exceptions.EntityNotFoundException;
import org.example.kinobackend.repository.BookedSeatRepository;
import org.example.kinobackend.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);


    private final MovieRepository movieRepository;
    private final BookedSeatRepository bookedSeatRepository;

    public AdminService(MovieRepository movieRepository, BookedSeatRepository bookedSeatRepository) {
        this.movieRepository = movieRepository;
        this.bookedSeatRepository = bookedSeatRepository;
    }


    public Integer getTotalNumberOfTickets(int movieID){
        return bookedSeatRepository.countBookedSeatsByShowMovieMovieID(movieID);
    }


    public Double getTotalRevenueOfMovie(Integer movieID){
        //Vi tjekker først om filmen eksisterer
        if (!movieRepository.existsById(movieID)) {
            logger.info("Checking if the movie exists..");
            throw new EntityNotFoundException("Movie with id + " + movieID + " not found.");
        }
        //vi henter omsætning på filmen. Hvis det er null, så returneres 0.0
        Double revenue = movieRepository.getRevenueForMovie(movieID);
        logger.info("Revenue for the movie " + movieID + " is " + revenue);
        return (revenue != null) ? revenue : 0.0;
    }

}
