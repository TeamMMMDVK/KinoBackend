package org.example.kinobackend.service;

import org.example.kinobackend.model.Show;
import org.example.kinobackend.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    public final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Optional<Show> getShowById(int id) {
        return showRepository.findById(id);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Optional<Show> getShow(int id) {
        return showRepository.findById(id);
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public boolean deleteShow(int id) {
        if (showRepository.existsById(id)) {
            showRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
