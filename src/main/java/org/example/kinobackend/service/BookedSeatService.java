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

    public List<BookedSeatDTO> getBookedSeatsSpecificShow(int showID) {
        //her hentes listen fra db
        List<BookedSeat> bookedSeatsSpecificShow = bookedSeatRepository.findByShow_ShowID(showID);
        //her laves ny liste til at gemme DTO i og returnere
        List<BookedSeatDTO> bookedSeatsSpecificShowDTO = new ArrayList<>();

        for(BookedSeat b: bookedSeatsSpecificShow) {
            bookedSeatsSpecificShowDTO.add(new BookedSeatDTO(
                    b.getSeat().getSeatID(),
                    b.getSeat().getSeatRow(),
                    b.getSeat().getSeatNumber(),
                    b.getSeat().getTheater().getTheaterName(),
                    b.getShow().getMovie().getTitle(),
                    b.getReservation().getReservationID(),
                    b.getTicket().getTicketID(),
                    b.getStatus(),
                    b.getShow().getStartTime()));
        }
        return bookedSeatsSpecificShowDTO;
    }




}
