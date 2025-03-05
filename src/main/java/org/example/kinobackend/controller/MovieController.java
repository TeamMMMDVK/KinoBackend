package org.example.kinobackend.controller;

import org.example.kinobackend.model.Movie;
import org.example.kinobackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //Til Postman test af EndPoint
    @GetMapping("/{id}")
    public Movie showSpecificKommune(@PathVariable int id) {
        try {
            Optional<Movie> movieToBeReturned = movieService.getMovie(id);
            return movieToBeReturned.get();
        } catch (NoSuchElementException e) {
            Movie noMovie = new Movie();
            noMovie.setTitle("Movie not found");
            return noMovie;
        }
    }

    @PostMapping("/create-movie")
    public Movie postMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.postMovie(movie);
        try {
            System.out.println(savedMovie.getMovieID());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return savedMovie;
    }



}
