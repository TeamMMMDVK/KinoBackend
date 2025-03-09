package org.example.kinobackend.controller;

import org.example.kinobackend.model.Show;
import org.example.kinobackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable int id) {
        try {
            Optional<Show> showToBeReturned = showService.getShowById(id);
            return showToBeReturned.get();
        } catch (NoSuchElementException e) {
            Show noShow = new Show();
            noShow.setStartTime(null);
            return noShow;
        }
    }

    @GetMapping("/shows")
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> shows = showService.getAllShows();
        return ResponseEntity.ok(shows);
    }

    // Create a movie showing
    @PostMapping("/create-show")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show createdShow = showService.createShow(show);
        return ResponseEntity.ok(createdShow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable int id, @RequestBody Show updatedShow) {
        Optional<Show> orgShow = showService.getShow(id);
        if (orgShow.isPresent()) {
            Show existingShow = orgShow.get();

            existingShow.setMovie(updatedShow.getMovie());
            existingShow.setTheater(updatedShow.getTheater());
            existingShow.setStartTime(updatedShow.getStartTime());
            existingShow.setBookedSeats(updatedShow.getBookedSeats());

            Show savedShow = showService.createShow(existingShow);
            return ResponseEntity.ok(savedShow);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable int id) {
        boolean isDeleted = showService.deleteShow(id);
        if (isDeleted) {
            return ResponseEntity.ok("Show deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Show not found.");
        }
    }





}
