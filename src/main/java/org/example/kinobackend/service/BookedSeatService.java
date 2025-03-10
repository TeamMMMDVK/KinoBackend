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

    public List<BookedSeatDTO> getAllBookedSeatsSpecificShow(int showID) {
        //her hentes listen fra db
        List<BookedSeat> allBookedSeatsSpecificShow = bookedSeatRepository.findByShow_ShowID(showID);
        //her laves ny liste til at gemme DTO i og returnere
        List<BookedSeatDTO> allBookedSeatsSpecificShowDTO = new ArrayList<>();

        for (BookedSeat b : allBookedSeatsSpecificShow) {
            allBookedSeatsSpecificShowDTO.add(new BookedSeatDTO(
                    b.getSeat().getSeatID(),
                    b.getSeat().getSeatRow(),
                    b.getSeat().getSeatNumber(),
                    b.getSeat().getTheater().getTheaterName(),
                    b.getShow().getMovie().getTitle(),
                    b.getReservation().getReservationID(),
                    b.getTicket().getTicketID(),
                    b.getShow().getStartTime(),
                    b.getTicket().getTicketType(),
                    b.getTicket().getPrice()));
        }
        return allBookedSeatsSpecificShowDTO;
    }


}
