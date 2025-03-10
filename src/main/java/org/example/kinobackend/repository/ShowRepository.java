package org.example.kinobackend.repository;

import org.example.kinobackend.dto.ShowTimesDTO;
import org.example.kinobackend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    //JPQL forespørgsel til at finde alle tider en movie vises i en given periode. I sådan en forespørgsel bruger vi
    //Java-entitets navnene (JPQL = Java Persistence Query Language)
    @Query("SELECT new org.example.kinobackend.dto.ShowTimesDTO(s.showID, s.startTime) FROM Show s WHERE s.movie.movieID = :movieID AND s.startTime BETWEEN :startDate AND :endDate")
    List<ShowTimesDTO> findShowsForMovieInSpecificPeriod(@Param("movieID") int movieID, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
