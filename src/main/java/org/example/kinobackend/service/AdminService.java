package org.example.kinobackend.service;

import org.example.kinobackend.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final TicketRepository ticketRepository;

    public AdminService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Integer getTotalNumberOfTickets(int movieID){
        return ticketRepository.countByBookedSeatShowMovieMovieID(movieID);
    }
}
