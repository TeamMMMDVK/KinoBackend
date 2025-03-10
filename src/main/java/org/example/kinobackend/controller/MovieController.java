package org.example.kinobackend.controller;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.dto.MovieDTO;
import org.example.kinobackend.model.Movie;
import org.example.kinobackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //skal hente en movie til visning i frontend, her anvendes DTO
    @GetMapping("/{movieID}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable int movieID) {
        MovieDTO requestedMovie = movieService.getMovieByIdDTO(movieID);
        return ResponseEntity.ok(requestedMovie);
    }

    //skal hente en liste af Movies, som vises i en given periode, her avendes DTO
    @GetMapping("/inshow")
    public ResponseEntity<List<MovieDTO>> listOfMoviesOnShowInGivenPeriod(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {

        List<MovieDTO> requestedList = movieService.listOfMoviesOnShowInGivenPeriod(startDate, endDate);
        return ResponseEntity.ok(requestedList);
    }

    //Her skal vi opdatere en movie, derfor skal vi have fat i den rigtige Movie Entity til selve
    //opdateringen, men vi returnerer DTO i visningen
    @PutMapping("/{movieID}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable int movieID, @RequestBody Movie movieDetails) {
        Optional<Movie> movieToBeChanged = movieService.getMovie(movieID);
        if (movieToBeChanged.isPresent()) {
            Movie oprMovie = movieToBeChanged.get();

            oprMovie.setTitle(movieDetails.getTitle());
            oprMovie.setDurationMin(movieDetails.getDurationMin());
            oprMovie.setAgeRestriction(movieDetails.getAgeRestriction());
            oprMovie.setDescription(movieDetails.getDescription());
            oprMovie.setGenre(movieDetails.getGenre());
            oprMovie.setImage(movieDetails.getImage());
            oprMovie.setReviewLink(movieDetails.getReviewLink());
            oprMovie.setTrailerLink(movieDetails.getTrailerLink());

            Movie movieUpdated = movieService.updateMovie(oprMovie);

            //Konverterer til DTO inden returnering af opdateret Movie
            MovieDTO updatedMovieDTO = new MovieDTO(movieUpdated.getMovieID(),
                    movieUpdated.getTitle(),
                    movieUpdated.getDurationMin(),
                    movieUpdated.getDescription(),
                    movieUpdated.getTrailerLink(),
                    movieUpdated.getReviewLink(),
                    movieUpdated.getGenre(),
                    movieUpdated.getAgeRestriction(),
                    movieUpdated.getImage());

            return ResponseEntity.ok(updatedMovieDTO);


        } else {
            throw new EntityNotFoundException("Movie not found with ID: " + movieID);
        }

    }


}
