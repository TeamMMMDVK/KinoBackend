package org.example.kinobackend.service;

import org.example.kinobackend.dto.BookedSeatDTO;
import org.example.kinobackend.model.*;
import org.example.kinobackend.repository.BookedSeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookedSeatService {

    private BookedSeatRepository bookedSeatRepository;
    private final ShowService showService;
    private final SeatService seatService;
    private final TicketService ticketService;

    public BookedSeatService(BookedSeatRepository bookedSeatRepository, ShowService showService, SeatService seatService, TicketService ticketService) {
        this.bookedSeatRepository = bookedSeatRepository;
        this.showService = showService;
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    public List<BookedSeatDTO> getAllBookedSeatsSpecificShow(int showID) {
        //her hentes listen fra db
        List<BookedSeat> allBookedSeatsSpecificShow = bookedSeatRepository.findByShowShowID(showID);
        //her laves ny liste til at gemme DTO i og returnere
        List<BookedSeatDTO> allBookedSeatsSpecificShowDTO = new ArrayList<>();

        for (BookedSeat b : allBookedSeatsSpecificShow) {
            allBookedSeatsSpecificShowDTO.add(mapBookedSeatToBookedSeatDTO(b));
        }
        return allBookedSeatsSpecificShowDTO;
    }

    public List<BookedSeat> createBookedSeats(List<Integer> seatsIDs, int showID,
                                              List<Integer> ticketTypeIDs, Reservation reservation){

        List<BookedSeat> bookedSeats = new ArrayList<>();
        for (int i = 0; i < seatsIDs.size(); i++) {
            Seat seat = seatService.getSeatById(seatsIDs.get(i));
            Show show = showService.findShowByID(showID);
            Ticket ticket = ticketService.findTicketByID(ticketTypeIDs.get(i));
            BookedSeat bookedSeat = new BookedSeat(show, seat, ticket, reservation);
            bookedSeatRepository.save(bookedSeat);
            bookedSeats.add(bookedSeat);
        }
        return bookedSeats;
    }


    public BookedSeatDTO mapBookedSeatToBookedSeatDTO(BookedSeat bookedSeat) {
        return new BookedSeatDTO(
                bookedSeat.getSeat().getSeatID(),
                bookedSeat.getSeat().getSeatRow(),
                bookedSeat.getSeat().getSeatNumber(),
                bookedSeat.getSeat().getTheater().getTheaterName(),
                bookedSeat.getShow().getMovie().getTitle(),
                bookedSeat.getReservation().getReservationID(),
                bookedSeat.getTicket().getTicketID(),
                bookedSeat.getShow().getStartTime(),
                bookedSeat.getTicket().getTicketType(),
                bookedSeat.getTicket().getPrice());
    }
}
