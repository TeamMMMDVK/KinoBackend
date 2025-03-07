package org.example.kinobackend.repository;

import org.example.kinobackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    int countByBookedSeatShowMovieMovieID(int movieID);  //retrieves total number of tickets for a certain movie

}
