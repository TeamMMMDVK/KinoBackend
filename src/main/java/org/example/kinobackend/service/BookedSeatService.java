package org.example.kinobackend.service;

import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.repository.BookedSeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedSeatService {

    private BookedSeatRepository bookedSeatRepository;

    public BookedSeatService(BookedSeatRepository bookedSeatRepository) {
        this.bookedSeatRepository = bookedSeatRepository;
    }

    public List<BookedSeatDTO> getAllSeatsSpecificShowWithStatus(int showID) {
        //her hentes listen fra db
        List<BookedSeat> allSeatsSpecificShowWithStatus = bookedSeatRepository.findByShow_ShowID(showID);
        //her laves ny liste til at gemme DTO i og returnere
        List<BookedSeatDTO> allSeatsSpecificShowWithStatusDTO = new ArrayList<>();

        for(BookedSeat b: allSeatsSpecificShowWithStatus) {
            allSeatsSpecificShowWithStatusDTO.add(new BookedSeatDTO(
                    b.getSeat().getSeatID(),
                    b.getSeat().getSeatRow(),
                    b.getSeat().getSeatNumber(),
                    b.getSeat().getTheater().getTheaterName(),
                    b.getShow().getMovie().getTitle(),
                    (b.getReservation() != null) ? b.getReservation().getReservationID() : null,  // Undgå NullPointerException
                    (b.getTicket() != null) ? b.getTicket().getTicketID() : null,  // Undgå NullPointerException
                    b.getShow().getStartTime()));
        }
        return allSeatsSpecificShowWithStatusDTO;
    }




}
