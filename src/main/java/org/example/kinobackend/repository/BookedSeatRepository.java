package org.example.kinobackend.repository;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.BookedSeatID;
import org.example.kinobackend.model.Seat;
import org.example.kinobackend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatID> {

    //Metodesignatur til at finde alle sæder på en bestemt forestilling
    List<BookedSeat> findByShowShowID(int showID);
    Integer countBookedSeatsByShowMovieMovieID(int movieID);
    Boolean existsBookedSeatBySeatAndShow(Seat seat, Show show);
}
