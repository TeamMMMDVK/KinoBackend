package org.example.kinobackend.controller;

import org.example.kinobackend.dto.ShowTimesDTO;
import org.example.kinobackend.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/show")
public class ShowController {

    private final ShowService showService;


    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/movie/{movieID}")
    public ResponseEntity<List<ShowTimesDTO>> findShowsForMovieInSpecificPeriod(@PathVariable int movieID, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(showService.findShowsForMovieInSpecificPeriod(movieID,startDate,endDate));
    }
}
