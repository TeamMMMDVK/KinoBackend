package org.example.kinobackend.repository;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.model.BookedSeatID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, BookedSeatID> {

    List<BookedSeat> findBookedSeatByShowMovieMovieID(int movieID); //finds all booked seats for a movie
}
