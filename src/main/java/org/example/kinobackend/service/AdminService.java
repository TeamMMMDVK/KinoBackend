package org.example.kinobackend.service;

import org.example.kinobackend.model.BookedSeat;
import org.example.kinobackend.repository.BookedSeatRepository;
import org.example.kinobackend.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private final TicketRepository ticketRepository;
    private final BookedSeatRepository bookedSeatRepository;

    public AdminService(TicketRepository ticketRepository, BookedSeatRepository bookedSeatRepository) {
        this.ticketRepository = ticketRepository;
        this.bookedSeatRepository = bookedSeatRepository;
    }


    public Integer getTotalNumberOfTickets(int movieID){
        return ticketRepository.countByBookedSeatShowMovieMovieID(movieID);
    }


    public Double getTotalRevenueOfMovie(Integer movieID){
        List<BookedSeat> allSoldSeatsForMovie = bookedSeatRepository.findBookedSeatByShowMovieMovieID(movieID);
        logger.info("amount of sold seats: " + allSoldSeatsForMovie.size());
        double revenue = 0.0;
        for(BookedSeat bookedSeat : allSoldSeatsForMovie){

            logger.info(bookedSeat.getTicket() + "");
            if(bookedSeat.getTicket()!=null){
                logger.info(bookedSeat.getTicket().getTicketType());
                revenue += bookedSeat.getPrice();
            }
        }
        return revenue;
    }
}
