package org.example.kinobackend.controller;

import org.example.kinobackend.service.TheaterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    private final TheaterService theaterService;
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }
}
