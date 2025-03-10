package org.example.kinobackend.service;

import org.example.kinobackend.exceptions.EntityNotFoundException;
import org.example.kinobackend.model.Ticket;
import org.example.kinobackend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket findTicketByID(int ticketID) {
        Optional<Ticket> requestedTicket = ticketRepository.findById(ticketID);
        if(requestedTicket.isPresent()) {
            return requestedTicket.get();
        } else {
            throw new EntityNotFoundException("Ticket not found with ID: " + ticketID);
        }
    }

}
