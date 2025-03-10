package org.example.kinobackend.service;

import org.example.kinobackend.dto.ShowTimesDTO;
import org.example.kinobackend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowService {

    public final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<ShowTimesDTO> findShowsForMovieInSpecificPeriod(int movieID, LocalDateTime startDate, LocalDateTime endDate) {
        return showRepository.findShowsForMovieInSpecificPeriod(movieID, startDate, endDate);
    }
}
