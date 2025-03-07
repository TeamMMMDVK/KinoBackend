package org.example.kinobackend.service;

import org.example.kinobackend.model.Reservation;
import org.example.kinobackend.model.Show;
import org.example.kinobackend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {

    public final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Optional<Show> getShow(int showId) {
        return showRepository.findById(3);
    }
}
