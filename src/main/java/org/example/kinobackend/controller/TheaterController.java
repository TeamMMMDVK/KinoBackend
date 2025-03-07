package org.example.kinobackend.controller;

import org.example.kinobackend.model.Theater;
import org.example.kinobackend.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping("/{theaterId}")
    public Optional<Theater> getTheater(@PathVariable String theaterId) {
        return theaterService.getTheater(Integer.parseInt(theaterId));
    }
}
