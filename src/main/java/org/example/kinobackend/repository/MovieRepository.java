package org.example.kinobackend.repository;

import org.example.kinobackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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


    //JPQL forespørgsel til at finde film der vises (har shows) i en given periode
    //DISTINCT anvendes for ikke at få den samme Movie med flere gange, hvis den har flere
    //forestillinger i perioden
    @Query("SELECT DISTINCT m FROM Movie m JOIN m.shows s WHERE s.startTime BETWEEN :startDate AND :endDate")
    List<Movie> findMoviesByShowStartTimeBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}



