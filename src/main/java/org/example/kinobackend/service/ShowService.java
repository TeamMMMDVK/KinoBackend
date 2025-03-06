package org.example.kinobackend.service;

import org.example.kinobackend.model.Show;
import org.example.kinobackend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    public final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }
}
