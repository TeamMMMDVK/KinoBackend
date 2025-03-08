package org.example.kinobackend.repository;

import org.example.kinobackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //JPQL forespørgsel til at finde omsætning pr movie. I sådan en forespørgsel bruger vi
    //Java-entitets navnene (Java Persistence Query Language)
    @Query("SELECT SUM(t.price) FROM Movie m " +
            "JOIN m.shows s " + //vi bruger relationen listen af shows i Movie
            "JOIN s.bookedSeats bs " + //vi bruger relationen listen af bookedSeat gemt under show
            "JOIN bs.ticket t " + //vi bruger relationen ticket i bookedSeat
            "WHERE m.movieID = :movieId ")
    Double getRevenueForMovie(@Param("movieId") int movieId); //Vi bruger Double
    //for at kunne håndtere null


}
