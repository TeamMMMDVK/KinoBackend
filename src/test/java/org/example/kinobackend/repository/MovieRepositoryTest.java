package org.example.kinobackend.repository;

import org.example.kinobackend.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void postMovie() {
        Movie m1 = new Movie();
        m1.setTitle("A test movie");
        movieRepository.save(m1);
        assertEquals(1, movieRepository.findAll().size());
    }
    @Test
    void getMovie() {
        Movie m1 = new Movie();
        m1.setTitle("Find me");
        m1.setDescription("Find my description");
        m1.setDurationMin(120.0);
        Movie savedMovie = movieRepository.save(m1);

        Optional<Movie> findMovie = movieRepository.findById(savedMovie.getMovieID());;
        assertEquals("Find me", findMovie.get().getTitle());
        assertEquals(m1.getDescription(), findMovie.get().getDescription());
        assertEquals(m1.getDurationMin(), findMovie.get().getDurationMin());
    }
    @Test
    void deleteMovie() {
        Movie m1 = new Movie();
        m1.setTitle("Delete me");
        movieRepository.save(m1);
        assertEquals(1, movieRepository.findAll().size()); // One movie has been saved to DB
        movieRepository.deleteById(1); //Only inserted one movie this test
        assertEquals(0, movieRepository.findAll().size());
    }

}
