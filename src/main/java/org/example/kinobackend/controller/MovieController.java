package org.example.kinobackend.controller;

import org.example.kinobackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

}
