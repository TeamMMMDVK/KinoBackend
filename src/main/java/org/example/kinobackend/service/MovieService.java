package org.example.kinobackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.kinobackend.dto.MovieDTO;
import org.example.kinobackend.dto.SeatDTO;
import org.example.kinobackend.model.Movie;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie postMovieEntity(Movie movie) {
        return movieRepository.save(movie);
    }
    public Movie deleteMovieEntity(int id) {
        Optional<Movie> movieToDelete = movieRepository.findById(id);
        Movie mov = movieToDelete.get();
        movieRepository.deleteById(id);
        return mov;

    }

    public Optional<Movie> getMovie(int id) {
       return movieRepository.findById(id);
    }

    //Denne henter faktisk Movie-entitet (til opdatering)
    public Movie getMovieById(int movieId) {
        Optional<Movie> requestedMovie = movieRepository.findById(movieId);
        if(requestedMovie.isPresent()) {
            return requestedMovie.get();
        } else {
            throw new EntityNotFoundException("Movie not found with ID: "+movieId);
        }

    }

    //Denne henter data fra DTO (til visning)
    public MovieDTO getMovieByIdDTO(int movieID) {
        Optional<Movie> requestedMovie = movieRepository.findById(movieID);
        if(requestedMovie.isPresent()) {
            Movie m = requestedMovie.get();//Her har vi fat i Seat objektet fra db
            //Her gemmer vi data i DTO som kan sendes til Controlleren
            return new MovieDTO(m.getMovieID(),m.getTitle(),m.getDurationMin(),m.getDescription(),m.getTrailerLink(),m.getReviewLink(),m.getGenre(),m.getAgeRestriction(),m.getImage());
        } else {
            throw new EntityNotFoundException("Movie not found with ID: "+movieID);
        }

    }

    public Movie updateMovie(Movie updatedMovie) {
        return movieRepository.save(updatedMovie);

    }

    public List<MovieDTO> listOfMoviesOnShowInGivenPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        //Vi henter den rigtige liste med Movies fra DB
        List<Movie> listOfMovies = movieRepository.findMoviesByShowStartTimeBetween(startDate, endDate);
        if(listOfMovies.isEmpty()) {
            throw new EntityNotFoundException("No movies are shown in the requested period from "+startDate +" to "+endDate);        }

        //Vi konverterer til en liste af MovieDTO til at returnere
        List<MovieDTO> listOfMoviesDTO = new ArrayList<>();

        for(Movie m:listOfMovies){
            listOfMoviesDTO.add(new MovieDTO(m.getMovieID(),
                    m.getTitle(),
                    m.getDurationMin(),
                    m.getDescription(),
                    m.getTrailerLink(),
                    m.getReviewLink(),
                    m.getGenre(),
                    m.getAgeRestriction(),
                    m.getImage()));
        }
        return listOfMoviesDTO;

    }
}
