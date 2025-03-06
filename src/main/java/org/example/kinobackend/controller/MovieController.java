package org.example.kinobackend.controller;

import org.example.kinobackend.model.Movie;
import org.example.kinobackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    // Create movie
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
    // Edit movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
        Optional<Movie> orgMovie = movieService.getMovie(id);
        if (orgMovie.isPresent()) {
            Movie existingMovie = orgMovie.get();

            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setDurationMin(updatedMovie.getDurationMin());
            existingMovie.setDescription(updatedMovie.getDescription());
            existingMovie.setTrailerLink(updatedMovie.getTrailerLink());
            existingMovie.setReviewLink(updatedMovie.getReviewLink());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setAgeRestriction(updatedMovie.getAgeRestriction());
            existingMovie.setImage(updatedMovie.getImage());
            existingMovie.setShows(updatedMovie.getShows());

            Movie savedMov = movieService.postMovie(existingMovie);
            return ResponseEntity.ok(savedMov);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    // Delete movie
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        Optional<Movie> orgMovie = movieService.getMovie(id);
        if (orgMovie.isPresent()) {
            movieService.deleteMovieById(id);
            return ResponseEntity.ok("Movie deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found.");
        }
    }



}
